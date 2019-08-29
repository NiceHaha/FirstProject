<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ include file="/WEB-INF/jsp/admin/top.jsp" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<style>
	img{
	width:100px;
	}
</style>
<script type="text/javascript">
$(function() {
	 query(); 
	 var dataName='';
	 $("#home").click(function() {
			query(dataName,1);
		}),
			
		$("#upper").click(function() {
			query(dataName,parseInt($("#pageNow").val()) - 1);
		}),
		
		$("#lower").click(function() {
			query(dataName,parseInt($("#pageNow").val()) + 1);
		}),
		
		$("#tail").click(function() {
			query(dataName,$("#pageCount").val());
		}),
		$("#likeQuery").click(function() {
			var depaName = $("#dataName").val();
			$("#oktrialquery").empty();
			query(depaName);
		}),
	$("#likeQuery").click(function() {
		 dataName = $("#dataName").val();
		$("#oktrialquery").empty();
		query(dataName);
	});
	
});

function query(dataName,pageNow){
	$.ajax({
		url:"<%=request.getContextPath()%>/goodsHandler/goodss",
		type:"get",
		dataType:"json",
		data:{"dataName":dataName,"pageNow":pageNow},
		async:false,
		success:function(obj){
			$("#pageNow").val(obj.pageEntity.pageNow);
			$("#pageCount").val(obj.pageEntity.pageCount);
			$("#oktrialquery").empty();
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
				$("#oktrialquery").append(
						"<tr><td>"+obj.list[i].code+"</td>"+
						"<td><img src='<%=request.getContextPath()%>/goodsHandler/getImage?materialUrl="+obj.list[i].id+"' ></td>"+
						"<td>"+obj.list[i].goodsName+"</td>"+
						"<td>"+obj.list[i].goodsPrice+"</td>"+
						"<td>"+obj.list[i].goodsDescribe+"</td>"+
						"<td>"+obj.list[i].goodsColor+"</td>"+
						"<td>"+
							"<a href='<%=request.getContextPath()%>/goodsHandler/updatetrial?id="+obj.list[i].id+"'><button class='btn btn-success btn-xs' data-toggle='modal'><fmt:message key="update"></fmt:message></button></a>"+
							"<a href='' name='deleteid' id='"+obj.list[i].id+"'><button class='btn btn-danger btn-xs' data-toggle='modal'><fmt:message key="Delete"></fmt:message></button></a>"+ 
						"</td>"+
					"</tr>"
				);
			}
		},
		error:function(XMLHttpRequest,textStatus,errorThrown){
			 alert("系统错误请联系管理员");
		}
	});
	$("a[name=deleteid]").click(function(){
		//this代表删除这个超链接 parent td parent.parent tr
		//$(this).parent().parent().find("td")查找td,
			var id = $(this).parent().parent();
			var cc = $(this).attr("id");
		$.ajax({
			url:"<%=request.getContextPath()%>/goodsHandler/goods/"+cc,
			type:"get",
			datatype:"json",
			success:function(aa){
				if(aa.aa == 0){
					id.remove();
					alert("删除成功");
				}
			}
		});
	});
	
	
};
</script>
</head>
<body>
	<!-- 右侧具体内容栏目 -->
	<div id="rightContent">
		<a class="toggle-btn" id="nimei"> <i
			class="glyphicon glyphicon-align-justify"></i>
		</a>

	<div class="check-div form-inline">
			<div class="col-lg-3">
				<a href="<%=request.getContextPath()%>/goodsreciewHandler/goodsreciews/goodsreciew"><button class="btn btn-yellow btn-xs "><fmt:message key="previousPage"></fmt:message></button></a>
			</div>
			<div class="col-lg-3 col-xs-1" >
				<input type="text"  class=" form-control input-sm" placeholder="<fmt:message key="material.searchMessage"></fmt:message>" id="dataName">
				<button class="btn btn-white btn-xs " id="likeQuery"><fmt:message key="Query"></fmt:message></button>
			</div>
	</div>
	<div class="data-div">
		<div class="row tableHeader">
			<div class="col-xs-1 " style="margin-left: 40px"><fmt:message key="Code"></fmt:message></div>
			<div class="col-xs-1 " style="margin-left: 120px"><fmt:message key="MerchandisePictures"></fmt:message></div>
			<div class="col-xs-1" style="margin-left: 140px"><fmt:message key="NameOfCommodity"></fmt:message></div>
			<div class="col-xs-1" style="margin-left: 80px"><fmt:message key="commodityPrice"></fmt:message></div>
			<div class="col-xs-2" style="margin-left: 40px"><fmt:message key="CommodityDescription"></fmt:message></div>
			<div class="col-xs-1"><fmt:message key="CommodityColour"></fmt:message></div>
			<div class="col-xs-1"><fmt:message key="operation"></fmt:message></div>
		</div>
		
			<div class="tablebody">
				<div class="sitTable">
					<table class="row table table-responsive" id="oktrialquery">
						<!-- 数据 -->
					</table>
				</div>
			</div>
			
	</div>
	<!--页码块-->
	<footer class="footer">
		<%@ include file="../../footer.jsp"%>
	</footer>
</div>
</body>
</html>