<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/admin/top.jsp" %>
<!DOCTYPE html>
<html>
<head>
 <title>代理商管理</title>
</head>
<script type="text/javascript" src="../../js/jquery-2.2.4.js"></script>
<script type="text/javascript">
function agent(y,pageNow) {
	$.ajax({
		url:"<%=request.getContextPath()%>/agents",
		type:"get",
		dataType:"json",
		data:
		{	"str":y,
			"pageNow":pageNow,
			"pageSize":1
		},
		async:false,
		success:function(obj){
			$("#pageNow").val(obj.pageEntity.pageNow);
			$("#pageCount").val(obj.pageEntity.pageCount);
			
			$("#aglist").empty();
			
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
			
			for(var i=0;i<obj.list.length;i++){
					var brand_name;
						if (obj.list[i].brand_name == null || obj.list[i].brand_name == '') {
							brand_name = "无品牌关联";
						}else{
							 brand_name = obj.list[i].brand_name;
						}
				$("#aglist").append(
						"<tr><td>"+obj.list[i].agent_name+"</td>"+
						"<td>"+obj.list[i].agent_city+"</td>"+
						"<td>"+obj.list[i].agent_tel+"</td>"+
						"<td>"+brand_name+"</td>"+
						"<td>"+
							"<a href='<%=request.getContextPath()%>/agent/"+obj.list[i].id+"'><button class='btn btn-success btn-xs' data-toggle='modal'>修改</button></a>"+
							"<a href='javascript:void(0);' name = 'nae' aa = "+obj.list[i].id+"><button class='btn btn-yellow btn-xs' data-toggle='modal'>删除</button></a>"+
						"</td>"+
					"</tr>");
			}
		},
	});
	$("a[name = nae]").click(function(){//点击元素名是a并且name=nae
		var id = $(this).attr("aa");//var定义一个变量，当点击是(this)谁,就会获取 他aa中的值
		var ar = $(this).parent().parent();//var定义一个变量,点击谁就会获取他的上一级(.parent);
		
		$.ajax({
			url:"<%=request.getContextPath()%>/agent/"+id,
			type:"delete",
			dataType:"json",//预期的服务器响应的数据类型,处理接收的返回数据
			success:function(a){
				if(a.del == 0){//将后台sta的值进行对比
					$(ar).remove();
				}else{
					alert("删除失败");
				}
			}
		});
	})
}
$(function() {
	agent();
	var y = "";
	$("#home").click(function() {
		agent(y,1);
	}),
		
	$("#upper").click(function() {
		agent(y,parseInt($("#pageNow").val()) - 1);
		
	}),
	
	$("#lower").click(function() {
		agent(y,parseInt($("#pageNow").val()) + 1);
		
	}),
	
	$("#tail").click(function() {
		agent(y,$("#pageCount").val());
	}),
	
	$("#but").click(function() {
		y = $("#chaxun").val();
		$("#aglist").empty();
		agent(y);
	})
});
function test()
	{
		var language = $("#language").val();
		window.location.href="agentList?locale="+language;
	}
</script>
<body>
	<!-- 右侧具体内容栏目 -->
	<div id="rightContent">
		<a class="toggle-btn" id="nimei"> <i
			class="glyphicon glyphicon-align-justify"></i>
		</a>

		<div class="check-div form-inline">
			<div class="col-lg-10 col-xs-5">
				<a href="<%=request.getContextPath() %>/agent/add"><button class="btn btn-yellow btn-xs"><fmt:message key="AddAgent"></fmt:message></button></a>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="text" class=" form-control input-sm "
					placeholder="<fmt:message key="InputTextSearch"></fmt:message>" id="chaxun">
				<button class="btn btn-white btn-xs " id="but"><fmt:message key="Query"></fmt:message></button>
				<select onchange="test()" id="language">
					<option value="en_US" <c:if test="${sessionScope.locale=='en_US'}">selected</c:if>><fmt:message key="English"></fmt:message></option>
					<option value="zh_CN" <c:if test="${sessionScope.locale=='zh_CN'}">selected</c:if>><fmt:message key="Chinese"></fmt:message></option>
				</select>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="<%=request.getContextPath()%>/agent/viewExcel"><button class="btn btn-yellow btn-xs" data-toggle="modal"><fmt:message key="export"></fmt:message></button></a>
			</div>
		</div>
		<div class="data-div">
		<div class="row tableHeader">
			<div class="col-xs-2"><fmt:message key="agent.name"></fmt:message></div>
			<div class="col-xs-2"><fmt:message key="agent.city"></fmt:message></div>
			<div class="col-xs-3"><fmt:message key="agent.tel"></fmt:message></div>
			<div class="col-xs-2"><fmt:message key="brand.name"></fmt:message></div>
			<div class="col-xs-2"><fmt:message key="operation"></fmt:message></div>
		</div>
		<div class="tablebody">
			<div class="sitTable">
				<table class="row table  table-responsive"  id="aglist">

				</table>
			</div>
		</div>
	</div>
	<footer class="footer">
			<input type="hidden" id="count">
			<input type="hidden" id="pageNow">
			<input type="hidden" id="pageCount">

			<button type="button" class="btn btn-yellow btn-xs" id='home'><fmt:message key="homePage"></fmt:message></button>
			<button type="button" class="btn btn-yellow btn-xs" id='upper'><fmt:message key="previousPage"></fmt:message></button>
			<button type="button" class="btn btn-yellow btn-xs" id='lower'><fmt:message key="nextPage"></fmt:message></button>
			<button type="button" class="btn btn-yellow btn-xs" id='tail'><fmt:message key="tailPage"></fmt:message></button>
		</footer>
	</div>
</body>
</html>