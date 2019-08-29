<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/admin/top.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>品牌管理</title>
</head>
<script type="text/javascript" src="js/jquery-2.2.4.js"></script>
<script type="text/javascript">
$(function() {
	$("#brand_name").change(function() {
		var name = $("#brand_name").val();
		$.ajax({
			url:"<%=request.getContextPath()%>/brand/count",
			type:"get",
			datatype:"json",
			data:{"brName":name},
			success:function(i){
				if(i == 0){
					$("input[name = submit]").show();
				}else{
					$("input[name = submit]").hide();
					alert("品牌名称重复请重新输入!!!");
				}
			}
		});
	});
});

$(function() {
	$("#brTel").change(function() {
		var a = $("#brTel").val();
		var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
		if (a.match(myreg)) {
			$("input[name = submit]").show();
		} else {
			alert("请输入正确的电话号码");
			$("input[name = submit]").hide();
		}
	})
});
</script>
<body>
	<div id="rightContent">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title"><fmt:message key="AddBrand"></fmt:message></h4>
			</div>
			<div class="panel-body" style="padding-left: 20%;">
				<div class="container-fluid">
					<form class="form-horizontal"  action="<%=request.getContextPath() %>/brand/add"  method="post"  enctype="multipart/form-data">
						<div class="form-group ">
							<label for="sName" class="col-xs-3 control-label"><fmt:message key="brand.name"></fmt:message></label>
							<div class="col-xs-8 ">
								<input type="text" class="form-control input-sm duiqi" 
									    id="brand_name" placeholder="<fmt:message key="Pleaseenterabrand"></fmt:message>" name="brand_name" value=${brand.brand_name }>
									    <font color="red">${brand_name }</font>
							</div>
						</div>
						<div class="form-group ">
							<label for="sName" class="col-xs-3 control-label"><fmt:message key="brand.tel"></fmt:message></label>
							<div class="col-xs-8 ">
								<input type="text"  class="form-control input-sm duiqi" 
									id="brand_tel" placeholder="<fmt:message key="Pleaseentercontactinformation"></fmt:message>" name="brand_tel" maxlength="11" value=${brand.brand_tel }>
							</div>
						</div>
						<div class="form-group">
							<label for="sOrd" class="col-xs-3 control-label"><fmt:message key="brand.path"></fmt:message></label>
							<div class="col-xs-8">
								<input type="file" id="brurl" placeholder="" name="brurl" required="required" >
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