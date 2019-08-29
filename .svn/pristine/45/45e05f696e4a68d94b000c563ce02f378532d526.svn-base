<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ include file="/WEB-INF/jsp/admin/top.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<title>修改</title>
</head>

<body>
	<div id="rightContent">
                 <div class="panel panel-default" >
			 <div class="panel-heading">
			 
					<h4 class="panel-title">修改文章</h4>
				</div>
				<div class="panel-body" style="padding-left: 20%;">
					<div class="container-fluid">
						<form class="form-horizontal" method="post" action="<%=request.getContextPath()%>/project">
							<input type="hidden" name="_method" value="PUT">
							<div class="form-group ">
								<label for="csrName" class="col-xs-3 control-label" ><fmt:message key="project.titleofarticle"></fmt:message>:</label>
								<div class="col-xs-8 ">
									<input type="text" class="form-control input-sm duiqi"
										id="ArticleTitle" placeholder="" name="ArticleTitle" value="${projectentity.article_title}">
								</div>
							</div>
							
							<div class="form-group">
								<label for="csrTel" class="col-xs-3 control-label" ><fmt:message key="project.contentofthearticle"></fmt:message>:</label>
								<div class="col-xs-8">
									<input type="text" class="form-control input-sm duiqi"
										id="ArticleText" placeholder="" name="ArticleText" value="${projectentity.article_text}">
								</div>
							</div>
							
							<input type="hidden" class="form-control input-sm duiqi"
								id="id" placeholder="" name="id" value="${projectentity.id}">
								
							<div class="modal-footer">
								<button type="button" class="btn btn-xs btn-white"
									data-dismiss="modal" onclick="javascript:history.back(-1);"><fmt:message key="cancel"></fmt:message></button>
								<button type="submit" class="btn btn-xs btn-green"><fmt:message key="submit"></fmt:message></button>
							</div> 
							
						</form>
					</div>
				</div>
				
			</div>
		</div>
</body>
</html>