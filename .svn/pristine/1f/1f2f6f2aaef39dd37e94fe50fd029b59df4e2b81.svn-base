<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/jsp/admin/top.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="utf-8">
<title>订单管理</title>
</head>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/admin/js/jquery-2.2.4.js"></script>
<script type="text/javascript">
$(function() {
	 var lisk= "";
		aa(lisk,1);
		
		 $("#a").click(function(){
			aa(lisk,1);
		});
		$("#b").click(function(){
			 var p=$("#pageCount").val();
			aa(lisk,p);
		}); 
		$("#c").click(function(){
			var p=$("#pageNo").val()-1;
			var pp=$("#pageNo").val();
			if(p > 0){
				aa(lisk,p);
			}else{ 
				aa(lisk,pp);
			}
		}); 
		 $("#d").click(function(){
			var p= parseFloat($("#pageNo").val())+ 1;
			var pp= parseFloat($("#pageNo").val());
			var r=parseFloat($("#pageCount").val())+1;
			if(p<r){
				aa(lisk,p);
			}else{
				aa(lisk,pp);
			}
		});
		 
		$("#button").click(function(){
			$("#order").empty();
			 lisk=$("#query").val();
			 aa(lisk,1);
		});
});
	 function aa(lisk,p) {
		$("#order").empty();
		$.ajax({
			url:"<%=request.getContextPath()%>/order",
			type : "GET",
			async : false, //改为同步，修改、删除操作才起作用，先运行Ajax，再运行点击事件，不然先运行点击操作，才会运行该Ajax。
			dataType : "json",//预期的服务器响应的数据类型,处理接收的返回数据
			data : {
				"lisk" : lisk,
				"pageNo" : p
			},
			success : function(datas) {//接收后台的返回数据,0/1。请求后台的servlet 中的方法后，响应回来的值，data就是这个值。然后根据dataType参数进行处理后的数据
				$("#pageNo").val(datas.page.pageNo);
				$("#pageCount").val(datas.page.pogeCount);
				$("#order").empty();
				
				for (var i = 0; i < datas.list.length; i++) {
					if (datas.list[i].receiptStatus == 1) {
						datas.list[i].receiptStatus = "已收货";
					} else {
						datas.list[i].receiptStatus = "未收货";
					}
					if (datas.list[i].orderStatus == 1) {
						datas.list[i].orderStatus = "已取消";
					} else if (datas.list[i].orderStatus == 2) {
						datas.list[i].orderStatus = "待审核";
					} else {
						datas.list[i].orderStatus = "未取消";
					}
					if (datas.list[i].paymentStatus == 1) {
						datas.list[i].paymentStatus = "已付款";
					} else if (datas.list[i].paymentStatus == 2) {
						datas.list[i].paymentStatus = "未付款";
					} else {
						datas.list[i].paymentStatus = "已退款";
					}
					$("#order").append(
							"<tr><td>" + datas.list[i].userCode + "</td><td>"
									+ datas.list[i].orderDate+ "</td><td>"
									+ datas.list[i].shippingAddr + "</td><td>"
									+ datas.list[i].receivingAddr + "</td><td>"
									+ datas.list[i].receiver + "</td><td>"
									+ datas.list[i].goodsName + "</td><td>"
									+ datas.list[i].goodsNum + "</td><td>"
									+ datas.list[i].goodsPrice + "</td><td>"
									+ datas.list[i].receiptStatus + "</td><td>"
									+ datas.list[i].orderStatus + "</td><td>"
									+ datas.list[i].paymentStatus + "</td><td>"
									+ datas.list[i].logisticsCode + "</td><td>"
									+ datas.list[i].expressCode + "</td><td>"
									+ datas.list[i].receiptTime + "</td><td>"
									+ datas.list[i].payment + "</td><td>"
									+ datas.list[i].orderCode + "</td></tr>");
				}
			}
		});
	}
</script>
<body>
	<!-- 右侧具体内容栏目 -->
	<div id="rightContent">
		<a class="toggle-btn" id="nimei"> <i
			class="glyphicon glyphicon-align-justify"></i>
		</a>
		<div class="check-div form-inline">
			<!-- 顶端的添加按钮 搜索 -->
			<div class="col-lg-2">
				<input type="text" id="query" class="form-control input-sm " placeholder='<fmt:message key="material.searchMessage"></fmt:message>' name="lisk"/>
				<button class="btn btn-white btn-xs " id="button"><fmt:message key="project.query"></fmt:message></button>
			</div>
		</div>
		<div class="data-div">
			<div class="row tableHeader" id="colName">
				<div class="col-lg-6">
					<div class="row">
						<div class="col-lg-2"><fmt:message key="order.userCode"></fmt:message></div>
						<div class="col-lg-2" style="margin-left: -25px;"><fmt:message key="order.orderDate"></fmt:message></div>
						<div class="col-lg-2" style="margin-left: -25px;"><fmt:message key="order.shippingAddr"></fmt:message></div>
						<div class="col-lg-2" style="margin-left: -25px;"><fmt:message key="order.receivingAddr"></fmt:message></div>
						<div class="col-lg-2" style="margin-left: -25px;"><fmt:message key="order.receiver"></fmt:message></div>
						<div class="col-lg-2" style="margin-left: -25px;"><fmt:message key="order.goodsName"></fmt:message></div>
						<div class="col-lg-2" style="margin-left: -25px;"><fmt:message key="order.goodsNum"></fmt:message></div>
						<div class="col-lg-2" style="margin-left: -25px;"><fmt:message key="order.goodsPrice"></fmt:message></div>
					</div>
				</div>
				<div class="col-lg-6" style="margin-left: -10px;">
					<div class="row">
						<div class="col-lg-2 " style="margin-left: -25px;"><fmt:message key="order.receiptStatus"></fmt:message></div>
						<div class="col-lg-2 " style="margin-left: -25px;"><fmt:message key="order.orderStatus"></fmt:message></div>
						<div class="col-lg-2" style="margin-left: -25px;"><fmt:message key="order.paymentStatus"></fmt:message></div>
						<div class="col-lg-2" style="margin-left: -25px;"><fmt:message key="order.logisticsCode"></fmt:message></div>
						<div class="col-lg-2 " style="margin-left: -25px;"><fmt:message key="order.expressCode"></fmt:message></div>
						<div class="col-lg-2" style="margin-left: -25px;"><fmt:message key="order.receiptTime"></fmt:message></div>
						<div class="col-lg-2" style="margin-left: -25px;"><fmt:message key="order.payment"></fmt:message></div>
						<div class="col-lg-2" style="margin-left: -25px;"><fmt:message key="order.orderCode"></fmt:message></div>
					</div>
				</div>
			</div>
			<div class="tablebody">
				<div class="sitTable">
					<table class="row table table-responsive" id="order">
					</table>
				</div>
			</div>
		</div>
		<form action="<%=request.getContextPath()%>/uiop">
			<button><fmt:message key="material.export"></fmt:message></button>
		</form>
		<footer class="footer">
			<input type="hidden" id="pageNo"> <input type="hidden"
				id="pageCount"> <input type="button" id="a"
				class="btn btn-yellow btn-xs" data-toggle="modal" value='<fmt:message key="homePage"></fmt:message>'>
			<input type="button" id="c" class="btn btn-yellow btn-xs"
				data-toggle="modal" value='<fmt:message key="previousPage"></fmt:message>'> <input type="button" id="d"
				class="btn btn-yellow btn-xs" data-toggle="modal" value='<fmt:message key="nextPage"></fmt:message>'>
			<input type="button" id="b" class="btn btn-yellow btn-xs"
				data-toggle="modal" value='<fmt:message key="tailPage"></fmt:message>'>
		</footer>
</body>
</html>