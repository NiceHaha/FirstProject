<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@ include file="/WEB-INF/jsp/admin/top.jsp"%>
    <%@ taglib prefix="emp" uri="/emp"  %> 
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				<h4 class="panel-title">添加员工</h4>
			</div>
				<div class="modal-body">
					<div class="container-fluid">
						<form class="form-horizontal" method="post" action="<%=request.getContextPath()%>/empController/emp">
						<div class="form-group ">
								<div class="col-xs-8 ">
									<input type="hidden" name="_method" value="put" />
									<input type="hidden" id="sId" placeholder="" name="id" value="${empEntity.id}">
								</div>
							</div>
							<div class="form-group ">
								<label for="sName" class="col-xs-3 control-label"><fmt:message key="empReciew.name"></fmt:message>：</label>
								<div class="col-xs-8 ">
									<input type="text" class="form-control input-sm duiqi"
										id="sName" placeholder="" name="name" value="${empEntity.name}"><font color="red">*</font>${name }
								</div>
							</div>
							<div class="form-group ">
								<label for="sName" class="col-xs-3 control-label"><fmt:message key="empReciew.sex"></fmt:message>：</label>
								<div class="col-xs-8">
									<label class="control-label" for="anniu"> <input
										type="radio" name="sex" id="normal" value="1"  ${empEntity.sex=='1'?'checked=true':''}><fmt:message key="male"></fmt:message>
									</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label
										class="control-label" for="meun"> <input
										type="radio" name="sex" id="forbid" value="0"  ${empEntity.sex=='0'?'checked=true':''}><fmt:message key="female"></fmt:message>
									</label>
								</div>
							</div>
							<div class="form-group ">
								<label for="sName" class="col-xs-3 control-label"><fmt:message key="empReciew.age"></fmt:message>：</label>
								<div class="col-xs-8 ">
									<input type="text" class="form-control input-sm duiqi"
										id="sAge" placeholder="" name="age" value="${empEntity.age}" onkeyup="value=value.replace(/[^\d]/g, '')">${age }
								</div>
							</div>
							<div class="form-group">
								<label for="sLink" class="col-xs-3 control-label"><fmt:message key="empReciew.accountnumber"></fmt:message>：</label>
								<div class="col-xs-8 ">
									<input type="text" class="form-control input-sm duiqi"
										id="sLink" placeholder="" name="account" value="${empEntity.account}"><font color="red">*</font>${account }
								</div>
							</div>
							<div class="form-group">
								<label for="sOrd" class="col-xs-3 control-label"><fmt:message key="empReciew.password"></fmt:message>：</label>
								<div class="col-xs-8">
									<input type="password" class="form-control input-sm duiqi"
										id="sOrd" placeholder="" name="password" value="${empEntity.password}"><font color="red">*</font>
								</div>
							</div>
							<div class="form-group">
								<label for="sOrd" class="col-xs-3 control-label"><fmt:message key="confirmPassword"></fmt:message>：</label>
								<div class="col-xs-8">
									<input type="password" class="form-control input-sm duiqi"
										id="sOrds" placeholder="" value="${empEntity.password}"> <span id="diss" style="color: red;"><fmt:message key="inconsistentPasswords"></fmt:message>！！！</span>
								</div>
							</div>
							<div class="form-group">
								<label for="sKnot" class="col-xs-3 control-label"><fmt:message key="empReciew.telephone"></fmt:message>：</label>
								<div class="col-xs-8">
									<input type="text" class="form-control input-sm duiqi"
										id="sKnot" placeholder="" name="tel" value="${empEntity.tel}" onkeyup="value=value.replace(/[^\d]/g, '')">${tel }
								</div>
							</div>
							<div class="form-group">
								<label for="sKnot" class="col-xs-3 control-label"><fmt:message key="empReciew.addr"></fmt:message>：</label>
								<div class="col-xs-8">
									<select class=" form-control select-duiqi" name="addr">
										<option value="北京"  ${empEntity.addr=='北京'?'selected':''}>北京</option>
										<option value="上海"  ${empEntity.addr=='上海'?'selected':''}>上海</option>
										<option value="深圳"  ${empEntity.addr=='深圳'?'selected':''}>深圳</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="sKnot" class="col-xs-3 control-label"><fmt:message key="empReciew.state"></fmt:message>：</label>
								<div class="col-xs-8">
									<label class="control-label" for="anniu"> <input
										type="radio" name=state id="normal" value="1" ${empEntity.state=='1'?'checked=true':''}><fmt:message key="incumbency"></fmt:message>
									</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label
										class="control-label" for="meun"> <input
										type="radio" name="state" id="forbid" value="0" ${empEntity.state=='0'?'checked=true':''}><fmt:message key="quit"></fmt:message>
									</label>
								</div>
							</div>
							<div class="form-group">
								<label for="sKnot" class="col-xs-3 control-label"><fmt:message key="user.root"></fmt:message>：</label>
								<div class="col-xs-8">
									<label class="control-label" for="anniu"> <input
										type="radio" name=root id="rootYes" value="1" ${empEntity.root=='1'?'checked=true':''}><fmt:message key="yes"></fmt:message>
									</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label
										class="control-label" for="meun"> <input
										type="radio" name="root" id="rootNo" value="0" ${empEntity.root=='0'?'checked=true':''}><fmt:message key="no"></fmt:message>
									</label>
								</div>
							</div>
							<div class="form-group">
								<label for="situation" class="col-xs-3 control-label"><fmt:message key="depaName"></fmt:message>：</label>
								<div class="col-xs-8">
									<label class="control-label" for="anniu">
										<emp:mepTag></emp:mepTag><!-- 自定义标签  选择部门 -->
									</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
								</div>
							</div>
							<div class="form-group">
								<label for="situation" class="col-xs-3 control-label"><fmt:message key="empReciew.position"></fmt:message>：</label>
								<div class="col-xs-8">
									<label class="control-label" for="anniu">
										<select name="position">
											<option value="部门经理" ${empEntity.position=='部门经理'?'selected':''}>部门经理</option >
											<option value="普通员工" ${empEntity.position=='普通员工'?'selected':''}>普通员工</option >
											<option value="客服" ${empEntity.position=='客服'?'selected':''}>客服</option >
 										</select>
									</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
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
		</div>
</body>
</html>