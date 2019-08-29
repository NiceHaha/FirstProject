<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ include file="/WEB-INF/jsp/admin/aa.jsp" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<!-- 引用jquery -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>

<script type="text/javascript">
	function a() {
		alert("已举报");
	}
	
</script>


</head>
<body>
	<div id="rightContent">
                 <div class="panel panel-default" >
			 <div class="panel-heading">
			 
					<h4 class="panel-title">举报文章(回显)</h4>
				</div>
				<div class="panel-body" style="padding-left: 20%;">
					<div class="container-fluid">
						<form class="form-horizontal" method="post" action="<%=request.getContextPath()%>/repo">
							<div class="form-group ">
								<label for="csrName" class="col-xs-3 control-label" >请输入要举报的文章名:</label>
								<div class="col-xs-8 ">
									<input type="text" class="form-control input-sm duiqi"
										id="ArticleTitle" placeholder="" name="ArticleTitle" value="${projectentity.article_title}">
								</div>
							</div>
							
							<div class="form-group">
								<label for="csrTel" class="col-xs-3 control-label" >请输入举报理由:</label>
								<div class="col-xs-8">
									<input type="text" class="form-control input-sm duiqi"
										placeholder="" id = "reporting" name = "reporting">
								</div>
							</div>
							
							<input type="hidden" class="form-control input-sm duiqi"
								id="id" placeholder="" name="id" value="${projectentity.id}">
								
							<div class="modal-footer">
								<button type="button" class="btn btn-xs btn-white"
									data-dismiss="modal" onclick="javascript:history.back(-1);">取 消举报</button>
								<button type="submit" class="btn btn-xs btn-green" id="button" onclick = "a()">确定举报</button>
							</div> 
							
						</form>
					</div>
				</div>
				
			</div>
		</div>
	
	
	
	
</body>
</html>