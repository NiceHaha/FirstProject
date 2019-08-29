<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="m" uri="/aa"  %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/jsp/admin/top.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>代理商管理</title>
</head>
<script type="text/javascript" src="js/jquery-2.2.4.js"></script>
<script type="text/javascript">
$(function() {
	$("#agname").change(function() {
		var name = $("#agname").val();
		$.ajax({
			url:"<%=request.getContextPath()%>/agent/count",
			type:"get",
			datatype:"json",
			data:{"agName":name},
			success:function(i){
				if(i != 0){
					$("input[name = submit]").hide();
					alert("品牌名称重复请重新输入!");
				}else{
					$("input[name = submit]").show();
				}
			}
		});
	});
});

$(function() {
	$("#agtel").change(function() {
		var a = $("#agtel").val();
		var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
		if (a.match(myreg)) {
			$("input[name = submit]").show();
		} else {
			alert("请输入正确的电话号码");
			$("input[name = submit]").hide();
		}
	})
})
</script>
<body>
	<div id="rightContent">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title"><fmt:message key="UpdateAgent"></fmt:message></h4>
			</div>
			<div class="panel-body" style="padding-left: 20%;">
				<div class="container-fluid">
					<form class="form-horizontal" action="<%=request.getContextPath() %>/agent" method="post">
						<input type="hidden" name="_method" value="PUT">
						<div class="form-group ">
							<label for="sName" class="col-xs-3 control-label"><fmt:message key="agent.name"></fmt:message></label>
							<div class="col-xs-8 ">
								<input type="hidden" name="id" value="${agent.id }"> <input
									type="text" class="form-control input-sm duiqi" id="agname" name="agent_name" value="${agent.agent_name }">
									<font color="red">${agent_name }</font>
							</div>
						</div>
						<div class="form-group ">
							<label for="sName" class="col-xs-3 control-label"><fmt:message key="agent.city"></fmt:message></label>
							<div class="col-xs-8 ">
								<input type="text" class="form-control input-sm duiqi" id="agent_city" name="agent_city" value="${agent.agent_city }">
								<font color="red">${agent_city }</font>
							</div>
						</div>
						<div class="form-group ">
							<label for="sName" class="col-xs-3 control-label"><fmt:message key="agent.tel"></fmt:message></label>
							<div class="col-xs-8 ">
								<input type="text" class="form-control input-sm duiqi"  id="agtel" name="agent_tel" value="${agent.agent_tel }">
								<font color="red">${agent_tel }</font>
							</div>
						</div>
						<div class="form-group ">
							<label for="sName" class="col-xs-3 control-label"><fmt:message key="ChoosingBrand"></fmt:message></label>
							<div class="col-xs-8 ">
								<!-- 自定义标签 name=gooodsp id =goodsp -->
								<m:goodsp></m:goodsp>
							</div>
						</div>
						<div class="modal-footer">
							<input type="reset" class="btn btn-xs btn-green" value="<fmt:message key="reset"></fmt:message>">
							<input type="submit" class="btn btn-xs btn-green" value="<fmt:message key="submit"></fmt:message>"
								name="submit" />
						</div>
					</form>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
</body>
</html>