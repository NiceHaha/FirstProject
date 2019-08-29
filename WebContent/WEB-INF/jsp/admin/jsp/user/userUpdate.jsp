<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/admin/top.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
 	 <%@ include file="/WEB-INF/jsp/admin/jsp/UserPass/judge.jsp"%>
</head>
<body>
<!--弹出修改用户窗口-->
<div id="rightContent">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="panel-title"><fmt:message key="modifyUsers"></fmt:message></h4>
		</div>
		<div class="modal-body">
			<div class="container-fluid">
				<form class="form-horizontal" method="post"
					action="<%=request.getContextPath()%>/userController/user">
					<div class="form-group ">
						<input type="hidden" name="_method" value="put" />
						<input type="hidden" class="form-control input-sm duiqi" id="sId"
							placeholder="" name="id" value="${userEntity.id}">
						<!-- 隐藏的id -->
					</div>
					<div class="form-group ">
						<label for="sName" class="col-xs-3 control-label"><fmt:message key="user.name"></fmt:message>：</label>
						<div class="col-xs-8 ">
							<input type="text" class="form-control input-sm duiqi" id="sName"
								placeholder="" name="name" value="${userEntity.name}"><font color="red">*</font> ${name }
								<!-- <span id="sNameCz">用户名已存在</span> -->
						</div>
					</div>
					<div class="form-group ">
						<label for="sName" class="col-xs-3 control-label"><fmt:message key="user.sex"></fmt:message>：</label>
						<div class="col-xs-8">
							<label class="control-label" for="anniu"> <input
								type="radio" name="sex" id="normal"
								value="1" ${userEntity.sex=='1'?'checked=true':''}><fmt:message key="male"></fmt:message>
							</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label
								class="control-label" for="meun"> <input type="radio"
								name="sex" id="forbid"value="0" ${userEntity.sex=='0'?'checked=true':''}><fmt:message key="female"></fmt:message>
							</label>
						</div>
					</div>
					<div class="form-group ">
						<label for="sName" class="col-xs-3 control-label"><fmt:message key="user.age"></fmt:message>：</label>
						<div class="col-xs-8 ">
							<input type="text" class="form-control input-sm duiqi" id="sage"
								placeholder="" name="age" value="${userEntity.age}" onkeyup="value=value.replace(/[^\d]/g, '')">${age }
						</div>
					</div>
					<div class="form-group">
						<label for="sLink" class="col-xs-3 control-label"><fmt:message key="user.account"></fmt:message>：</label>
						<div class="col-xs-8 ">
							<input type="text" class="form-control input-sm duiqi" id="sLink"
								placeholder="" name="account" value="${userEntity.account}"><font color="red">*</font>${account }
						</div>
					</div>
					<div class="form-group ">
						<label for="sName" class="col-xs-3 control-label"><fmt:message key="user.password"></fmt:message>：</label>
						<div class="col-xs-8 ">
							<input type="password" class="form-control input-sm duiqi" id="sOrd"
								placeholder="" name="password" value="${userEntity.password}"><font color="red">*</font>
						</div>
					</div>
					<div class="form-group">
							<label for="sOrd" class="col-xs-3 control-label"><fmt:message key="confirmPassword"></fmt:message>：</label>
							<div class="col-xs-8">
								<input type="password" class="form-control input-sm duiqi"
									id="sOrds" placeholder="" value="${userEntity.password}"><span id="diss" style="color: red;"><fmt:message key="inconsistentPasswords"></fmt:message></span>
							</div>
						</div>
					<div class="form-group ">
						<label for="sName" class="col-xs-3 control-label"><fmt:message key="user.tel"></fmt:message>：</label>
						<div class="col-xs-8 ">
							<input type="text" class="form-control input-sm duiqi" id="sKnot"
								placeholder="" name="tel" value="${userEntity.tel}" onkeyup="value=value.replace(/[^\d]/g, '')">${tel }
						</div>
					</div>
					<div class="form-group">
						<label for="sKnot" class="col-xs-3 control-label"><fmt:message key="user.addr"></fmt:message>：</label>
						<div class="col-xs-8">
							<select class=" form-control select-duiqi" name="addr">
								<option value="北京" ${userEntity.addr=='北京'?'selected':''}>北京</option>
								<option value="上海" ${userEntity.addr=='上海'?' selected':''}>上海</option>
								<option value="深圳" ${userEntity.addr=='深圳'?' selected':''}>深圳</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="sKnot" class="col-xs-3 control-label"><fmt:message key="user.root"></fmt:message>：</label>
						<div class="col-xs-8">
							<label class="control-label" for="anniu"> <input
								type="radio" name=privilege id="privilege"
								value="1" ${userEntity.root=='1'?'checked=true':''}><fmt:message key="ordinaryUsers"></fmt:message>
							</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label
								class="control-label" for="meun"> <input type="radio"
								name="privilege" id="privilegeVip"
								value="0" ${userEntity.root=='0'?'checked=true':''}><fmt:message key="VIPusers"></fmt:message>
							</label>
						</div>
					</div>
					<div class="form-group">
						<label for="situation" class="col-xs-3 control-label"><fmt:message key="blacklist"></fmt:message>：</label>
						<!-- 是否黑名单 -->
						<div class="col-xs-8">
							<label class="control-label" for="anniu"> <input
								type="radio" name="black" id="black"
								value="1" ${userEntity.black=='1'?'checked=true':''}><fmt:message key="yes"></fmt:message>
							</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label
								class="control-label" for="meun"> <input type="radio"
								name="black" id="blackNo"
								value="0" ${userEntity.black=='0'?'checked=true':''}><fmt:message key="no"></fmt:message>
							</label>
						</div>
					</div>
					<div class="modal-footer">
						<input type="button" name="Submit" onclick="javascript:history.back(-1);" value="<fmt:message key="cancel"></fmt:message>" class="btn btn-xs btn-green">
						<button type="submit" class="btn btn-xs btn-green" id='submit'><fmt:message key="submit"></fmt:message></button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- /.modal-dialog -->
</div>
</body>
</html>