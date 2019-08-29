<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/admin/top.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<title>Insert title here</title>
<title>添加客服</title>
<script type="text/javascript">


$(function() {
	$("#goodsp").change(function() {
		var goodsp=$("#goodsp").val();
		$.ajax({
			url:"<%=request.getContextPath()%>/Agentdata",
			type:"post",
			dataType:"json",
			data:{"goodsp":goodsp},
			async:false,
			success:function(obj){
				for(var i=0;i<obj.length;i++){
					$("#goodsd").empty().append("<option value="+obj[i].name+">"+obj[i].name+"</option>");
				}
			},
			error:function(XMLHttpRequest,textStatus,errorThrown){
				 alert("系统错误请联系管理员");
			}
		});
	});
	
	/* 判断名字是否重复 */
	$("#goodsname").change(function() {
		var goodsname=$("#goodsname").val();
		$.ajax({
			url:"<%=request.getContextPath()%>/judegaddname",
			type:"post",
			dataType:"json",
			data:{"goodsname":goodsname},
			async:false,
			success:function(obj){
				if(obj.bool !=0){
					$("#Tips").show();
					$("#save").attr("disabled",true);//按钮启动 (disabled:禁用)
				}else {
					$("#Tips").hide();
					$("#save").attr("disabled",false);//按钮启动 (disabled:禁用)
				}
			},
			error:function(XMLHttpRequest,textStatus,errorThrown){
				 alert("系统错误请联系管理员");
			}
		});
	});
});

</script>
</head>
<body>
	


	<div id="rightContent">
		<a class="toggle-btn" id="nimei"> <i
			class="glyphicon glyphicon-align-justify"></i>
		</a>

			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<a class="modal-title" id="gridSystemModalLabel"><h4><fmt:message key="csr.addCsr"></fmt:message></h4></a>
				</div>
				<div class="modal-body">
					<div class="container-fluid">
						<form class="form-horizontal" method="POST" action="<%=request.getContextPath()%>/csr" enctype="multipart/form-data">
							<div class="form-group ">
								<label for="csrName" class="col-xs-3 control-label"><fmt:message key="csr.addName"></fmt:message></label>
								<div class="col-xs-8 ">
									<input type="text" class="form-control input-sm duiqi" id="csrName" placeholder="请输入客服昵称" name="csrName" >
									<!-- <span id = "errorMsg"></erorMsg> -->
								</div>
							</div>
							<div class="form-group ">
								<label for="csrSex" class="col-xs-3 control-label"><fmt:message key="csr.addSex"></fmt:message></label>
								<div class="col-xs-8">
									<label class="control-label" for="anniu">
									 <input type="radio" name="csrSex" id="normal" value="1"><fmt:message key="male"></fmt:message>
									</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									 <label	class="control-label" for="meun">
									  <input type="radio" name="csrSex" id="forbid" value="0"><fmt:message key="female"></fmt:message>
									</label>
								</div>
							</div>
							<div class="form-group ">
								<label for="csrAge" class="col-xs-3 control-label"><fmt:message key="csr.addAge"></fmt:message></label>
								<div class="col-xs-8 ">
									<input type="text" class="form-control input-sm duiqi" id="csrAge" placeholder="请输入年龄" name="csrAge" onkeyup="value=value.replace(/[^\d]/g,'')">
								</div>
							</div>
							
							<div class="form-group">
								<label for="csrTel" class="col-xs-3 control-label"><fmt:message key="csr.addTel"></fmt:message></label>
								<div class="col-xs-8">
									<input type="text" class="form-control input-sm duiqi"
										id="csrTel" placeholder="请输入电话" name="csrTel" onkeyup="value=value.replace(/[^\d]/g, '')">
								</div>
							</div>
							
							<div class="form-group">
								<label for="fileName" class="col-xs-3 control-label"><fmt:message key="csr.addPath"></fmt:message></label>
								<div class="col-xs-8">
									<input type="file" name="csrPicture" >
								</div>
							</div>

						<div class="form-group">
								<label for="csrStatus" class="col-xs-3 control-label"><fmt:message key="csr.addStatus"></fmt:message></label><!-- 是否在线 -->
								<div class="col-xs-8">
									<label class="control-label" for="anniu"> <input
										type="radio" name="csrStatus" id="normal" value="1"><fmt:message key="yes"></fmt:message>
									</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
									<label class="control-label" for="meun"> 
									<input	type="radio" name="csrStatus" id="forbid" value="0"><fmt:message key="no"></fmt:message>
									</label>
								</div>
							</div>
							<div class="modal-footer">
								<!-- 重置 -->
								<button type="button" class="btn btn-xs btn-white" data-dismiss="modal"><fmt:message key="csr.reset"></fmt:message></button>
								<!-- 保存 -->
								<button type="submit" class="btn btn-xs btn-green" id="subimt"><fmt:message key="csr.preservation"></fmt:message></button>
							</div> 
								<!-- 返回 -->
								<input type="button" name="Submit" onclick="javascript:history.back(-1);" value="<fmt:message key="csr.return"></fmt:message>" class="btn btn-xs btn-green">
						</form>
					</div>
				</div>
			</div>
		</div>
</body>
</html>