<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ include file="/WEB-INF/jsp/admin/top.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<title>添加</title>
<script type="text/javascript">
	
</script>
</head>
<body>
	<div id="rightContent">
                 <div class="panel panel-default" >
			 <div class="panel-heading">
			 
					<h4 class="panel-title">添加文章</h4>
				</div>
				<div class="panel-body" style="padding-left: 20%;">
					<div class="container-fluid">
						<form class="form-horizontal" method="post" action="<%=request.getContextPath()%>/project">
							
							<div class="form-group ">
								<label for="csrName" class="col-xs-3 control-label" ><fmt:message key="project.articleNumber"></fmt:message>:</label>
								<div class="col-xs-8 ">
									<input type="text" class="form-control input-sm duiqi"
										id="ArticleCode" placeholder="" name="article_code" value="${a.article_code}">${article_code}
								</div>
							</div>
							
							<div class="form-group ">
								<label for="csrName" class="col-xs-3 control-label" ><fmt:message key="project.titleofarticle"></fmt:message>:</label>
								<div class="col-xs-8 ">
									<input type="text" class="form-control input-sm duiqi"
										id="csrName" placeholder="" name="article_title" value="${a.article_title}">${article_title}
								</div>
							</div>
							
							<div class="form-group">
								<label for="csrTel" class="col-xs-3 control-label" ><fmt:message key="project.contentofthearticle"></fmt:message>:</label>
								<div class="col-xs-8">
									<input type="text" class="form-control input-sm duiqi"
										id="csrTel" placeholder="" name="article_text" value="${a.article_text}">
								</div>
							</div>
							<div class="modal-footer">
							<!-- onclick="javascript:history.back(-1);" 返回上一级 -->
								<button type="button" class="btn btn-xs btn-white"
									data-dismiss="modal" onclick="javascript:history.back(-1);"><fmt:message key="cancel"></fmt:message></button>
								<button type="submit" class="btn btn-xs btn-green" id = "button"><fmt:message key="submit"></fmt:message></button>
							</div>
							
						</form>
					</div>
				</div>
				
				
				
				
			</div>
		</div>

	
	
</body>
</html>