<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/admin/aa.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.2.4.js"></script>
<body>
	<form action="<%=request.getContextPath()%>/order" method="POST">
		<fmt:message key="order.receivingAddr"></fmt:message>:<input type="text" name="receivingAddr" value="${order.receivingAddr}">${receivingAddr}<br>
		<fmt:message key="order.receiver"></fmt:message>:<input type="text" name="receiver" value="${order.receiver }">${receiver}<br>
		<fmt:message key="order.goodsNum"></fmt:message>:<input type="text" name="goodsNum" value="${order.goodsNum }"><br>
		<fmt:message key="order.goodsName"></fmt:message>:<input type="text" name="goodsName" value="${order.goodsName }"><br>
		<fmt:message key="order.goodsPrice"></fmt:message>:<input type="text" name="goodsPrice" value="${order.goodsPrice }"><br>
		<fmt:message key="order.orderDescride"></fmt:message>:<input type="text" name="orderDescride" value="${order.orderDescride }"><br>
		<button>确认订单</button>
	</form>
</body>
</html>