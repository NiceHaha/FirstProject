<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/admin/top.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">

</script>
</head>
<!--弹出修改用户窗口-->
<div id="rightContent">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="panel-title">修改客服</h4>
		</div>
		====================${csrEntity.empCode}==============
		<div class="modal-body">
			<div class="container-fluid">
				<form class="form-horizontal" method="post" action="<%=request.getContextPath()%>/csr" enctype="multipart/form-data">
					<div class="form-group ">
						<input type="hidden" name="_method" value="put" />
						<input type="hidden" id="csrId" name="id" value="${csrEntity.id}">
						<input type="hidden" name="empCode" value="${csrEntity.empCode}">
						<!-- 隐藏的id -->
					</div>
					<div class="form-group ">
						<label for="csrName" class="col-xs-3 control-label"><fmt:message key="csr.csrName"></fmt:message></label>
						<div class="col-xs-8 ">
							<input type="text" class="form-control input-sm duiqi" id="csrName" name="csrName" value="${csrEntity.csrName}"> 
								<!-- <span id="csrName">用户名已存在</span> -->
						</div>
					</div>
					<div class="form-group ">
						<label for="csrSex" class="col-xs-3 control-label"><fmt:message key="csr.csrSex"></fmt:message></label>
						<div class="col-xs-8">
							<label class="control-label" for="anniu"> 
								<input type="radio" name="csrSex" id="normal" value="1" ${csrEntity.csrSex=='1'?'checked=true':''}><fmt:message key="male"></fmt:message>
							</label> 
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<label class="control-label" for="meun"> 
								<input	type="radio" name="csrSex" id="forbid" value="0" ${csrEntity.csrSex=='0'?'checked=true':''}><fmt:message key="female"></fmt:message>
							</label>
						</div>
					</div>
					<div class="form-group ">
						<label for="csrAge" class="col-xs-3 control-label"><fmt:message key="csr.csrAge"></fmt:message></label>
						<div class="col-xs-8 ">
							<input type="text" class="form-control input-sm duiqi" id="csrAge"
								placeholder="" name="csrAge" value="${csrEntity.csrAge}">
						</div>
					</div>
					<div class="form-group ">
						<label for="csrTel" class="col-xs-3 control-label"><fmt:message key="csr.csrTel"></fmt:message></label>
						<div class="col-xs-8 ">
							<input type="text" class="form-control input-sm duiqi" id="csrTel"
								placeholder="" name="csrTel" value="${csrEntity.csrTel}">
						</div>
					</div>

					<div class="form-group">
						<label for="fileName" class="col-xs-3 control-label"><fmt:message key="csr.csrPath"></fmt:message></label>
						<div class="col-xs-8">
							<input type="file" name="csrPicture" value = "${csrEntity.csrPath}">
							<!--上传头像 -->
						</div>
					</div>


					<div class="form-group">
						<label for="csrStatus" class="col-xs-3 control-label"><fmt:message key="csr.csrStatus"></fmt:message></label>
						<!-- 是否在线 -->
						<div class="col-xs-8">
							<label class="control-label" for="anniu">
								 <input type="radio" name="csrStatus" id="normal" value="1" ${csrEntity.csrStatus=='1'?'checked=true':''}><fmt:message key="yes"></fmt:message>
							</label>
							 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
							 <label	class="control-label" for="meun"> 
							 	<input type="radio" name="csrStatus" id="forbid" value="0"${csrEntity.csrStatus=='0'?'checked=true':''}><fmt:message key="no"></fmt:message>
							</label>
						</div>
					</div>
						<!-- 返回 -->
						<input type="button" name="Submit" onclick="javascript:history.back(-1);" value="<fmt:message key="csr.return"></fmt:message>" class="btn btn-xs btn-green">
						<!-- 保存 -->
						<button type="submit" class="btn btn-xs btn-green" id='submit'><fmt:message key="csr.preservation"></fmt:message></button>
					<div class="modal-footer">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- /.modal-dialog -->
</div>
</body>
</html>