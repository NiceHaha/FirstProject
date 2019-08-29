<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/admin/top.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
 	 <%@ include file="/WEB-INF/jsp/admin/jsp/UserPass/judge.jsp"%>
</head>
<body>
	<div id="rightContent">
		<div class="panel panel-default" >
			<div class="panel-heading">
				<h4 class="panel-title"><fmt:message key="user.addUser"></fmt:message></h4>
			</div>
			
			<div class="modal-body">
				<div class="container-fluid">
					<form class="form-horizontal" method="post" action="<%=request.getContextPath()%>/userController/user">
						<div class="form-group ">
							<label for="sName" class="col-xs-3 control-label"><fmt:message key="user.name"></fmt:message>：</label>
							<div class="col-xs-8 ">
								<input type="text" class="form-control input-sm duiqi"
									id="sName" placeholder="" name="name" value="${userEntity.name }">${name }
							</div>
						</div>
						<div class="form-group ">
							<label for="sName" class="col-xs-3 control-label"><fmt:message key="user.sex"></fmt:message>：</label>
							<div class="col-xs-8">
								<label class="control-label" for="anniu"> <input
									type="radio" name="sex" id="normal" value="1" ><fmt:message key="male"></fmt:message>
								</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label
									class="control-label" for="meun"> <input
									type="radio" name="sex" id="forbid" value="0"><fmt:message key="female"></fmt:message>
								</label>
							</div>
						</div>
						<div class="form-group ">
							<label for="sName" class="col-xs-3 control-label"><fmt:message key="user.age"></fmt:message>：</label>
							<div class="col-xs-8 ">
								<input type="text" class="form-control input-sm duiqi"
									id="sAge" placeholder="" name="age" onkeyup="value=value.replace(/[^\d]/g, '')">${age }
							</div>
						</div>
						<div class="form-group">
							<label for="sLink" class="col-xs-3 control-label"><fmt:message key="user.account"></fmt:message>：</label>
							<div class="col-xs-8 ">
								<input type="text" class="form-control input-sm duiqi"
									id="sLink" placeholder="" name="account">${account }
							</div>
						</div>
						<div class="form-group">
							<label for="sOrd" class="col-xs-3 control-label"><fmt:message key="user.password"></fmt:message>：</label>
							<div class="col-xs-8">
								<input type="password" class="form-control input-sm duiqi"
									id="sOrd" placeholder="" name="password">
							</div>
						</div>
						<div class="form-group">
							<label for="sOrd" class="col-xs-3 control-label"><fmt:message key="confirmPassword"></fmt:message>：</label>
							<div class="col-xs-8">
								<input type="password" class="form-control input-sm duiqi"
									id="sOrds" placeholder="" ><span id="diss" style="color: red;"><fmt:message key="inconsistentPasswords"></fmt:message></span>
							</div>
						</div>
						<div class="form-group">
							<label for="sKnot" class="col-xs-3 control-label"><fmt:message key="user.tel"></fmt:message>：</label>
							<div class="col-xs-8">
								<input type="text" class="form-control input-sm duiqi"
									id="sKnot" placeholder="" name="tel" onkeyup="value=value.replace(/[^\d]/g, '')" >${tel }
							</div>
						</div>
						<div class="form-group">
							<label for="sKnot" class="col-xs-3 control-label"><fmt:message key="user.addr"></fmt:message>：</label>
							<div class="col-xs-8">
								<select class=" form-control select-duiqi" name="addr">
									<option value="北京" >北京</option>
									<option value="上海" >上海</option>
									<option value="深圳" >深圳</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="sKnot" class="col-xs-3 control-label"><fmt:message key="user.root"></fmt:message>：</label>
							<div class="col-xs-8">
								<label class="control-label" for="anniu"> <input
									type="radio" name=privilege id="normal" value="1" ><fmt:message key="ordinaryUsers"></fmt:message>
								</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label
									class="control-label" for="meun"> <input
									type="radio" name="privilege" id="forbid" value="0" ><fmt:message key="VIPusers"></fmt:message>
								</label>
							</div>
						</div>
						<div class="form-group">
							<label for="situation" class="col-xs-3 control-label"><fmt:message key="blacklist"></fmt:message>：</label><!-- 是否黑名单 -->
							<div class="col-xs-8">
								<label class="control-label" for="anniu"> <input
									type="radio" name="black" id="normal" value="1" ><fmt:message key="yes"></fmt:message>
								</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label
									class="control-label" for="meun"> <input
									type="radio" name="black" id="forbid" value="0" ><fmt:message key="no"></fmt:message>
								</label>
							</div>
						</div>
						<div class="form-group">
								<label for="situation" class="col-xs-3 control-label"></label>
								<div class="col-xs-8">
									<label class="control-label" for="anniu">
										<input type="button" name="Submit" onclick="javascript:history.back(-1);" value="<fmt:message key="cancel"></fmt:message>" class="btn btn-xs btn-green">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" class="btn btn-xs btn-green" id="submit"><fmt:message key="submit"></fmt:message></button>
									</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
								</div>
							</div>
					</form>
				</div>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
</body>
</html>