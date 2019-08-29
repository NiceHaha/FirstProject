<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/admin/top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	query();
	var userName = "";
	$("#home").click(function() {
		query(userName,1);
	}),
		
	$("#upper").click(function() {
		query(userName,parseInt($("#pageNow").val()) - 1);
	}),
	
	$("#lower").click(function() {
		query(userName,parseInt($("#pageNow").val()) + 1);
	}),
	
	$("#tail").click(function() {
		query(userName,$("#pageCount").val());
	}),
	
	$("#query").click(function() {
		userName = $("#userNames").val();
		query(userName);
	})
});
function query(userName,pageNow) {
	$.ajax({
		url:"<%=request.getContextPath()%>/userController/userQueryAll",
		type:"get",
		dataType:"json",
		async:false,
		data:{"userName":userName,
				"pageNow":pageNow
		},
		success:function(obj){
			$("#pageNow").val(obj.pageEntity.pageNow);
			$("#pageCount").val(obj.pageEntity.pageCount);
			$("#userList").empty();
			for(var i=0;i<obj.list.length;i++){
				var sex = '';
				var root = '';
				var age = '';
				if(obj.list[i].sex == '0'){
					sex = '女';
				}else{
					sex = '男';
				}
				if(obj.list[i].root == '0'){
					root = 'VIP用户';
				}else{
					root = '普通用户';
				}
				if(obj.list[i].age == '0'){
					age = '保密';
				}else{
					age = obj.list[i].age;
				}
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
				$("#userList").append(
						"<div class='row tablebody'>"+
						"<div class='col-lg-1'>"+obj.list[i].name+"</div>"+
						"<div class='col-lg-1'>"+obj.list[i].tel+"</div>"+
						"<div class='col-lg-1'>"+obj.list[i].account+"</div>"+
						"<div class='col-lg-1'>"+obj.list[i].password+"</div>"+
						"<div class='col-lg-1'>"+obj.list[i].addr+"</div>"+
						"<div class='col-lg-1'>"+sex+"</div>"+
						"<div class='col-lg-1'>"+age+"</div>"+
						"<div class='col-lg-1'>"+root+"</div>"+
						"<div class='col-lg-1'>"+
							"<a href='<%=request.getContextPath()%>/userController/updateJump/"+obj.list[i].id+"'><button class='btn btn-success btn-xs' data-toggle='modal'><fmt:message key='project.update'></fmt:message></button></a>"+
							"<a href='' name='deleteName' id='"+obj.list[i].id+"'><button class='btn btn-danger btn-xs' data-toggle='modal'><fmt:message key='project.delete'></fmt:message></button></a>"+ 
						"</div>"+
					"</div>"
				);
			}
		},
		error:function(XMLHttpRequest,textStatus,errorThrown){
			alert("系统内部错误，请联系管理员！！！")
		}
	});
	$("a[name=deleteName]").click(function(){
		//this代表删除这个超链接 parent td parent.parent tr
		//$(this).parent().parent().find("td")查找td,
			var id = $(this).parent().parent();
			var cc = $(this).attr("id");
		$.ajax({
			url:"<%=request.getContextPath()%>/userController/user/"+cc,
			type:"DELETE",
			datatype:"json",
			data:{
				id:cc
			},
			success:function(aa){
				if(aa.user == 1){
					id.remove();
				}
			}
		});
	});
}
</script>
<%-- <%@ include file="../../cssAll.jsp"%> --%>
</head>
<body>
	

	<div id="rightContent">
		<a class="toggle-btn" id="nimei"> <i
			class="glyphicon glyphicon-align-justify"></i>
		</a>
		<div class="check-div form-inline">
			<div class="col-xs-3">
			<!--添加 -->
				<a href="<%=request.getContextPath()%>/userController/addUser"><button class="btn btn-yellow btn-xs" data-toggle="modal"><fmt:message key="user.addUser"></fmt:message></button></a>
				<a href="<%=request.getContextPath()%>/userController/viewExcel"><button class="btn btn-yellow btn-xs" data-toggle="modal"><fmt:message key="export"></fmt:message></button></a>
			</div>
			<div class="col-xs-4">
				<input type="text" class="form-control input-sm" placeholder="输入文字搜索" id="userNames">
				<button class="btn btn-white btn-xs " id="query"><fmt:message key="query"></fmt:message></button>
			</div>
		</div>
		<div class="data-div">
			<div class="row tableHeader">
				<div class="col-lg-1 "><fmt:message key="user.name"></fmt:message></div>
				<div class="col-lg-1"><fmt:message key="user.tel"></fmt:message></div>
				<div class="col-lg-1"><fmt:message key="user.account"></fmt:message></div>
				<div class="col-lg-1"><fmt:message key="user.password"></fmt:message></div>
				 <div class="col-lg-1"><fmt:message key="user.addr"></fmt:message></div>
				<div class="col-lg-1"><fmt:message key="user.sex"></fmt:message></div>
			 	<div class="col-lg-1"><fmt:message key="user.age"></fmt:message></div>
				 <div class="col-lg-1"><fmt:message key="user.root"></fmt:message></div>
				<div class="col-lg-2"><fmt:message key="operation"></fmt:message></div>
			</div>
		</div>
		<div class="data-div" id="userList">
			<!--页码块 -->
		</div>
	</div>	
	<footer class="footer">
		<!--分页 -->
		<%@ include file="../../footer.jsp"%>
	</footer>
</body>
</html>