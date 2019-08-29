<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ include file="/WEB-INF/jsp/admin/top.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<title>查询</title>
<script type="text/javascript">							
$(function(){
	query();
	var projectFuzzy = "";
	$("#home").click(function() {
		query(projectFuzzy,1);
	}),
		
	$("#upper").click(function() {
		query(projectFuzzy,parseInt($("#pageNow").val()) - 1);
	}),
	
	$("#lower").click(function() {
		query(projectFuzzy,parseInt($("#pageNow").val()) + 1);
	}),
	
	$("#tail").click(function() {
		query(projectFuzzy,$("#pageCount").val());
	}),
	
	$("#button").click(function() {
		projectFuzzy = $("#projectFuzzy").val();
		query(projectFuzzy);
	})
	
	
	
});
		
		
		
	
	
	/* 模糊查询 */
	function query(projectFuzzy,pageNow){
			$.ajax({
				url:"<%=request.getContextPath()%>/projects",
				type:"get",
				dataType:"json",
				data:{"projectFuzzy":projectFuzzy,"pageNow":pageNow},
				async:false,
				success:function(a){
					$("#pageNow").val(a.pageEntity.pageNow);
					$("#pageCount").val(a.pageEntity.pageCount);
					$("#div").empty();
					if($("#pageNow").val() <= 1){
						$("#upper").attr("disabled","disabled");
					}else{
						$("#upper").attr("disabled",false);
					};
					if($("#pageNow").val() >= $("#pageCount").val()){
						$("#lower").attr("disabled","disabled");
					}else{
						$("#lower").attr("disabled",false);
					};
					for (var i = 0; i < a.list.length; i++) {
						$("#div").append("<tr><td>"+
							 a.list[i].article_code+"</td><td>"+
							 a.list[i].article_title+"</td><td><a class='linkCcc' name = 'select' id = '"+a.list[i].id+"'><fmt:message key="project.see"></fmt:message></a></td><td>"+
							 "<a href='<%=request.getContextPath()%>/project?id="+a.list[i].id+" '><button class='btn btn-success btn-xs' ><fmt:message key='project.update'></fmt:message></button></a>"+
							 "<a href='' name='delete' id='"+a.list[i].id+"'><button class='btn btn-danger btn-xs'><fmt:message key="project.delete"></fmt:message></button></a>"+
							 "</td></tr>");
					}
				},
				error:function(XMLHttpRequest,textStatus,errorThrown){
					alert("系统内部错误，请联系管理员！！！")
				}
			});
			
			
			
			/*删除 */
			$("a[name = delete]").click(function(){
				var id = $(this).attr("id");
				var aa = $(this).parent().parent();
				$.ajax({
					url:"<%=request.getContextPath()%>/project/"+id,
					type:"delete",
					dataType:"json",
					success:function(a){
						alert(id);
						if(a.status == 0){
							$(aa).remove();
							alert("删除成功");
						}else{
							alert("删除失败");
						}
						
					}
					
				});
			});
			
			
			
			$(function(){
				$("a[name = select]").click(function(){
					var id = $(this).attr("id");
					var aa = $(this).parent().parent();
					$.ajax({
						url:"<%=request.getContextPath()%>/projectQuery/"+id,
						type:"get",
						dataType:"text",
						success:function(a){
							alert(a);
						},
						error:function(XMLHttpRequest,textStatus,errorThrown){
							alert("系统内部错误，请联系管理员！！！")
						}
					});
				});
			});
			
		}
	
	
	/* 国际化 */
	function test(){
		/* 获取下拉框的值 */
		var userlocale = $("#userlocale").val();
		//相当于转发将projectList?locale="+userlocale传入页面路径当参数
		window.location.href="projectList?locale="+userlocale;
	}
	
	
	
	
	
</script>


</head>
<body>
	<!-- 右侧具体内容栏目 -->
	<div id="rightContent">
		<a class="toggle-btn" id="nimei"> <i
			class="glyphicon glyphicon-align-justify"></i>
		</a>
		<!-- Tab panes -->
		<div class="check-div form-inline">
			<div class="col-xs-1">
				<a href="projectadd"><button class="btn btn-yellow btn-xs" ><fmt:message key="project.addarticles"></fmt:message></button></a>
			</div>
			<div class="col-xs-1">
				<a href="reportList"><button class="btn btn-yellow btn-xs" ><fmt:message key="project.reporting"></fmt:message></button></a>
			</div>
			<div class="col-lg-4 col-xs-2">
				<input type="text" class=" form-control input-sm "
					placeholder="输入文字搜索" name="projectFuzzy" id = "projectFuzzy">
				<button class="btn btn-white btn-xs " id = "button"><fmt:message key="project.query"></fmt:message></button>
			</div>
			
			<div class="col-xs-1">
				<a href="excel"><button class="btn btn-yellow btn-xs" >导出Excel表</button></a>
			</div>
			
			<select onchange="test()" id="userlocale">
				<option value="zh_CN" <c:if test="${sessionScope.locale=='zh_CN'}">selected</c:if>>中文</option>
				<option value="en_US" <c:if test="${sessionScope.locale=='en_US'}">selected</c:if>>英文</option>
			</select>
			
			
			<div class="col-lg-3 col-lg-offset-1 col-xs-3"
				style="padding-right: 40px; text-align: right; float: right;">
				<label for="paixu">排序:&nbsp;</label> <select class="form-control">
					<option>地区</option>
					<option>排名</option>
				</select>
			</div>
		</div>

		<div class="data-div">
			<div class="row tableHeader">
				<div class="col-lg-1 "><fmt:message key="project.articleCode"></fmt:message></div>
				<div class="col-lg-5 "><fmt:message key="project.articleTitle"></fmt:message></div>
				<div class="col-lg-2"><fmt:message key="project.articleText"></fmt:message></div>
				<div class="col-lg-2"><fmt:message key="project.operation"></fmt:message></div>
			</div>
			<div class="tablebody">
				<div class="sitTable">
					<table class="row table table-responsive" id="div">
						<!-- 数据 -->
					</table>
				</div>
			</div>
			
			<!--页码块-->
			<footer class="footer">
				<%@ include file="../../footer.jsp"%>
			</footer>
		<!-- </div>
		<div class="data-div" id="depaList">
			
		</div>-->
	</div>
	</div>
</body>
</html>