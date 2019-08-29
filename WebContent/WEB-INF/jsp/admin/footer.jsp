<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
	<input type="hidden" id="pageSize">
	<input type="hidden" id="pageNow">
	<input type="hidden" id="pageCount">



	<!-- 每页显示<select class="btn btn-yellow btn-xs" data-toggle="modal" id="xl">
			<option value="2">2</option>
			<option value="5">5</option>
			<option value="10">10</option>
			<option value="20">20</option>
			<option value="50">50</option>
	</select>条 -->
	<button type="button" class='btn btn-danger btn-xs' data-toggle='modal' id='home'><fmt:message key="homePage"></fmt:message></button>
	<button type="button" class='btn btn-danger btn-xs' data-toggle='modal' id='upper'><fmt:message key="previousPage"></fmt:message></button>
	<button type="button" class='btn btn-danger btn-xs' data-toggle='modal' id='lower'><fmt:message key="nextPage"></fmt:message></button>
	<button type="button" class='btn btn-danger btn-xs' data-toggle='modal' id='tail'><fmt:message key="tailPage"></fmt:message></button>
</body>
</html>