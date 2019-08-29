<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%@ include file="/WEB-INF/jsp/admin/top.jsp"%>
  	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<!-- <script type="text/javascript">
	$(function(){
		$("#nameYC").hide();
		var nameId = $("#nameId").val();
		$("#nameId").change(function(){
			$.ajax({
				url:"updateJson",
				type:"get",
				datatype:"json",
				data:{
					"id":$("#Id").val(),//ajax传值到后台
					"name":$("#nameId").val()
				},
				success:function(aa){
					if(aa == 0){
						$("#nameYC").show();
						$("#submit").attr({"disabled":"disabled"});//disabled禁止使用按钮
					}else{
						$("#nameYC").hide();
						$("#submit").removeAttr("disabled");
					}
				}
			});
		});
	});

</script> -->
</head>
<body>
	<div id="rightContent">
		<div class="panel panel-default" >
			<div class="panel-heading">
				<h4 class="panel-title">修改部门</h4>
			</div>
				<div class="modal-body">
					<div class="container-fluid">
						<form class="form-horizontal" method="post" action="<%=request.getContextPath()%>/depaController/depa">
							<input type="hidden" name="_method" value="PUT" />
							<input type="hidden" name="id" value="${depaEntity.id}">
							<input type="hidden" name="code" value="${depaEntity.code}">
							<div class="form-group ">
								<label for="sName" class="col-xs-3 control-label"><fmt:message key="depa.name"></fmt:message></label>
								<div class="col-xs-8 ">
									<input type="text" class="form-control input-sm duiqi" id="sName" placeholder="" name="name" value="${depaEntity.name}"><font color="red">*</font>${name }
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
		</div>
</body>
</html>