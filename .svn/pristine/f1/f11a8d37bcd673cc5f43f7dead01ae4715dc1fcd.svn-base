<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ include file="/WEB-INF/jsp/admin/top.jsp"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
$(function(){
	query();
	var depaName = "";
	$("#query").click(function() {
		depaName = $("#depaName").val();
		$("#depaList").empty();
		query(depaName);
	}),
	$("#home").click(function() {
		query(depaName,1);
	}),
		
	$("#upper").click(function() {
		query(depaName,parseInt($("#pageNow").val()) - 1);
	}),
	
	$("#lower").click(function() {
		query(depaName,parseInt($("#pageNow").val()) + 1);
	}),
	
	$("#tail").click(function() {
		query(depaName,$("#pageCount").val());
	})
	
});
function query(depaName,pageNow) {
	$.ajax({
		url:"<%=request.getContextPath()%>/depaController/depas",
		type:"get",
		dataType:"json",
		async:false,
		data:
		{	"depaName":depaName,
			"pageNow":pageNow
		},
		success:function(obj){
			$("#pageNow").val(obj.pageEntity.pageNow);
			$("#pageCount").val(obj.pageEntity.pageCount);
			$("#depaList").empty();
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
				$("#depaList").append(
						"<div class='row tablebody' >"+
						"<div class='col-lg-1'>"+obj.list[i].code+"</div>"+
						"<div class='col-lg-1'>"+obj.list[i].name+"</div>"+
						"<div class='col-lg-2'>"+
							"<a href='<%=request.getContextPath()%>/depaController/depa/"+obj.list[i].id+"'><button class='btn btn-success btn-xs' data-toggle='modal'><fmt:message key='project.update'></fmt:message></button></a>"+
							"<a href='' name='deleteName' id="+obj.list[i].id+"><button class='btn btn-danger btn-xs' data-toggle='modal'><fmt:message key='project.delete'></fmt:message></button></a>"+ 
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
		var id = $(this).parent().parent();
		var cc = $(this).attr("id");
		$.ajax({
			url:"<%=request.getContextPath()%>/depaController/depa/"+cc,
			type:"DELETE",
			datatype:"json",
			data:{
				id:cc
			},
			success:function(aa){
				if(aa.depa == '1'){
					id.remove();
				}
			}
		});
	});
}
/* function test()
{
	var language = $("#language").val();
	window.location.href="depaList?locale="+language;
} */
</script>
</head>
<body>
	<div id="rightContent">
		<a class="toggle-btn" id="nimei"> <i
			class="glyphicon glyphicon-align-justify"></i>
		</a>
		<div class="check-div form-inline">
			<div class="col-xs-3">
				<a href="<%=request.getContextPath()%>/depaController/depaPust"><button class="btn btn-yellow btn-xs" data-toggle="modal"><fmt:message key="depa.add"></fmt:message></button></a>
				<a href="<%=request.getContextPath()%>/depaReciewController/depaReciewList"><button class="btn btn-yellow btn-xs" data-toggle="modal"><fmt:message key="toExamine"></fmt:message></button>	</a>
			</div>
			<div class="col-xs-4">
				<input type="text" class="form-control input-sm" placeholder="输入文字搜索" name="depaName" id="depaName">
				<button class="btn btn-white btn-xs" id="query"><fmt:message key="query"></fmt:message></button>
			</div>
			<%-- <div class="col-xs-5">
			<fmt:message key="language"></fmt:message>
				<select onchange="test()" id="language">
					<option value="zh_CN" <c:if test="${locale=='zh_CN'}">selected</c:if>><fmt:message key="Chinese"></fmt:message></option>
					<option value="en_US" <c:if test="${locale=='en_US'}">selected</c:if>><fmt:message key="English"></fmt:message></option>
					<option value="tt_RU" <c:if test="${locale=='tt_RU'}">selected</c:if>>俄语</option>
				</select>	
			</div> --%>
		</div>
		<div class="data-div">
			<div class="row tableHeader">
				<!-- <div class="col-lg-1">编号</div>
				<div class="col-lg-1 ">姓名</div>
				<div class="col-lg-2">操作</div> -->
				<div class="col-lg-1"><fmt:message key="depa.code"></fmt:message></div>
				<div class="col-lg-1 "><fmt:message key="depa.name"></fmt:message></div>
				<div class="col-lg-2"><fmt:message key="operation"></fmt:message></div>
			</div>
		</div>
		<div class="data-div" id="depaList">
			
		</div>
	</div>
	<!--页码块->
	<!--分页 -->
	<!--页码块-->
		<footer class="footer">
			<%@ include file="../../footer.jsp"%>
		</footer>
</body>
</html>