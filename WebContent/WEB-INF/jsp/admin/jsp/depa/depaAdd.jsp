<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ include file="/WEB-INF/jsp/admin/top.jsp"%>
    	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	$(function() {
	  $('#submit').click(function() {
	    var d = {};
	    var t = $('form').serializeArray();
	    $.each(t, function() {
	      d[this.name] = this.value;
	    });
	    alert(JSON.stringify(d));
	  });
	});
</script>
</head>
<body>
	<div id="rightContent">
		<div class="panel panel-default" >
			<div class="panel-heading">
				<h4 class="panel-title">添加部门</h4>
			</div>
			<div class="modal-body">
				<div class="container-fluid">
					<form class="form-horizontal" method="POST" action="<%=request.getContextPath()%>/depaReciewController/depaReciew">
						<div class="form-group ">
							<label for="sName" class="col-xs-3 control-label"><fmt:message key="depa.name"></fmt:message></label>
							<div class="col-xs-8 ">
								<input type="text" class="form-control input-sm duiqi"
									id="sName" placeholder="" name="name" value="${depaReciewEntity.name}"><font color="red">*</font>${name}
							</div>
						</div>
						<div class="modal-footer">
							<input type="button" name="Submit" onclick="javascript:history.back(-1);" value="<fmt:message key="cancel"></fmt:message>" class="btn btn-xs btn-green">
							<button type="submit" class="btn btn-xs btn-green"><fmt:message key="submit"></fmt:message></button>
						</div>
					</form>
				</div>
			</div>
		</div>
			<!-- /.modal-content -->
	</div>
		<!-- /.modal-dialog -->
</body>
</html>