<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ include file="/WEB-INF/jsp/admin/top.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>后台举报查询</title>
<script type="text/javascript">
	$(function(){
		/* 回调函数 */
		query();
		$("#button").click(function() {
			var projectFuzzy = $("#projectFuzzy").val();
			$("#div").empty();
			query(projectFuzzy);
		});
		
	});
	
	
	
	/* 模糊查询 */
	function query(projectFuzzy){
			$.ajax({
				url:"<%=request.getContextPath()%>/reportquery",
				type:"get",
				dataType:"json",
				async:false,
				success:function(a){
					for (var i = 0; i < a.length; i++) {
						$("#div").append("<tr><td>"+
							 a[i].articletcode+"</td><td>"+
							 a[i].articletitle+"</td><td>"+a[i].reporting+"</td><td>"+
							 "<td>已审核</td></td></tr>");
					}
				},
				error:function(XMLHttpRequest,textStatus,errorThrown){
					alert("系统内部错误，请联系管理员！！！")
				}
			});
		}
	



	$(function(){
		$("#tg").click(function(){
			$("#sb").hide();
		}),
		$("#sb").click(function(){
			$("#tg").hide();
		});
		
	});
	
	
	
	
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
			<div class="col-xs-3">
				<a href="projectList"><button class="btn btn-yellow btn-xs" onclick="javascript:history.back(-1);">返回上一级</button></a>
			</div>
			<div class="col-lg-4 col-xs-5">
				<input type="text" class=" form-control input-sm "
					placeholder="输入文字搜索" name="projectFuzzy" id = "projectFuzzy">
				<button class="btn btn-white btn-xs " id = "button">查 询</button>
			</div>
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
				<div class="col-lg-1 ">编码</div>
				<div class="col-lg-3 ">举报文章名</div>
				<div class="col-lg-5">举报理由</div>
				<div class="col-lg-2">操作</div>
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
	</div>

</body>
</html>