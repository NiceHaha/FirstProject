<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/admin/top.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>品牌管理</title>
</head>
<style>
img{
width:100px;
}
</style>
<script type="text/javascript" src="js/jquery-2.2.4.js"></script>
<script type="text/javascript">
function brand(a,pageNow) {
	$.ajax({
		url:"<%=request.getContextPath()%>/brands",
		type:"get",
		dataType:"json",
		data:
		{
			"str":a,
			"pageNow":pageNow,
			"pageSize":1
		},
		async:false,
		success:function(obj){
			$("#pageNow").val(obj.pageEntity.pageNow);
			$("#pageCount").val(obj.pageEntity.pageCount);
			
			$("#bralist").empty();
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
				$("#bralist").append(
						"<tr><td>"+obj.list[i].brand_name+"</td>"+
						"<td>"+obj.list[i].brand_tel+"</td>"+
						"<td>"+obj.list[i].code+"</td>"+
						"<td><img src='<%=request.getContextPath()%>/materialDownloadServlet?materialUrl="+obj.list[i].brand_url+"'></td>"+
						"<td>"+
							"<a href='<%=request.getContextPath()%>/brand/"+obj.list[i].id+"'><button class='btn btn-success btn-xs' data-toggle='modal'>修改</button></a>"+
							"<a href='javascript:void(0);' name = 'nae' aa = "+obj.list[i].id+"><button class='btn btn-yellow btn-xs' data-toggle='modal'>删除</button></a>"+
						"</td>"+
					"</tr>")
			}
		},
	});
		$("a[name = nae]").click(function(){//点击元素名是a并且name=nae
		var id = $(this).attr("aa");//var定义一个变量，当点击是(this)谁,就会获取 他aa中的值
		var ar = $(this).parent().parent();//var定义一个变量,点击谁就会获取他的上一级(.parent);
		
		$.ajax({
			url:"<%=request.getContextPath()%>/brand/"+id,
			type:"delete",
			datatype : "json",
			success:function(a){
				if(a == 0){
					$(ar).remove();
				}else{
					alert("删除失败");
				}
			}
		});
	})
}

$(function() {
	brand();
	var a = "";
 	$("#home").click(function() {
		brand(a,1);
	}),
		
	$("#upper").click(function() {
		brand(a,parseInt($("#pageNow").val()) - 1);
		
	}),
	
	$("#lower").click(function() {
		brand(a,parseInt($("#pageNow").val()) + 1);
		
	}),
	
	$("#tail").click(function() {
		brand(a,$("#pageCount").val());
	}),
	 
	$("#but").click(function() {
		a = $("#chaxun").val();
		$("#bralist").empty();
		brand(a);
	})
})

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
			<a href="<%=request.getContextPath() %>/brand"><button class="btn btn-yellow btn-xs"><fmt:message key="AddBrand"></fmt:message></button></a>
			<input type="text" class=" form-control input-sm "
					placeholder="<fmt:message key="InputTextSearch"></fmt:message>" id="chaxun">
				<button class="btn btn-white btn-xs" id="but"><fmt:message key="Query"></fmt:message></button>
				<select onchange="test()" id="language">
					<option value="en_US" <c:if test="${sessionScope.locale=='en_US'}">selected</c:if>><fmt:message key="English"></fmt:message></option>
					<option value="zh_CN" <c:if test="${sessionScope.locale=='zh_CN'}">selected</c:if>><fmt:message key="Chinese"></fmt:message></option>
				</select>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="<%=request.getContextPath()%>/brand/viewExcel"><button class="btn btn-yellow btn-xs" data-toggle="modal"><fmt:message key="export"></fmt:message></button></a>
		</div>
	</div>
	<div class="data-div">
		<div class="row tableHeader">
			<div class="col-xs-2"><fmt:message key="brand.name"></fmt:message></div>
			<div class="col-xs-3"><fmt:message key="brand.tel"></fmt:message></div>
			<div class="col-xs-2"><fmt:message key="Code"></fmt:message></div>
			<div class="col-xs-3"><fmt:message key="brand.path"></fmt:message></div>
			<div class="col-xs-1"><fmt:message key="operation"></fmt:message></div>
		</div>
		<div class="tablebody" >
		<div class="sitTable">
				<table class="row table  table-responsive"  id="bralist">

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