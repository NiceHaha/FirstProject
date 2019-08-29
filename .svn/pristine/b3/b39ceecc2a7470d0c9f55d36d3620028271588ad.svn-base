<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/jsp/admin/aa.jsp" %>
<html class="noIE" lang="en-US">
<head>
<title>GFashion - Responsive e-commerce HTML Template</title>
</head>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.2.4.js"></script>
<script type="text/javascript">
</script>
<body class="product-single">
	<div id="page-wrapper">
		<!-- 网站顶部 -->
		<header id="site-header" role="banner"> </header>
		<!-- // 网站顶部 -->

		<!-- 导航路径 -->
		<div class="breadcrumb-container">
			<div class="container">
				<div class="relative">
					<ul class="bc unstyled clearfix">
						<li><a href="index.jsp">首页</a></li>
						<li class="active">订单</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- // 导航路径 -->

		<!-- 主体内容 -->
		<main id="main-content" role="main">
		<div class="container">
			<form action="<%=request.getContextPath()%>/order" method="POST">
			<input type="hidden" name="_method" value="PUT">
				<input type="hidden" name="id" value="${id}" required="required" onkeyup="this.value=this.value.replace(/\s+/g,'')"> <fmt:message key="order.receivingAddr"></fmt:message>:<input
					type="text" name="receivingAddr" value="${list.receivingAddr}" required="required" onkeyup="this.value=this.value.replace(/\s+/g,'')">
				<fmt:message key="order.receiver"></fmt:message>:<input type="text" name="receiver" value="${list.receiver}" required="required" onkeyup="this.value=this.value.replace(/\s+/g,'')">
				<button>确认修改</button>
			</form>
		</div>
	</div>
	</main>
	<footer class="page-footer">
		<%@ include file="../../bottom.jsp"%>
	</footer>
	</div>
	</main>
</body>
</html>