<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="m" uri="/aa"  %>
   <%@ include file="/WEB-INF/jsp/admin/top.jsp" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
	$(document).ready(function(){
		$("#save").click(function(){
			var path = $("#Goodsimg").val();
			  if (path.length == 0) {
			      alert("请选择一张图片！");
			      return false;
			  } else {
			      var extStart = path.lastIndexOf('.'),
			          ext = path.substring(extStart, path.length).toUpperCase();
			      if (ext !== '.PNG' && ext !== '.JPG' && ext !== '.JPEG' && ext !== '.GIF'&& ext !== 'BMP') {
			          alert("图片格式不正确！");
			          $("#Goodsimg").attr("value","");
			          return false;
			      }
			  }
		});
	});
	
	
	
	
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
							$("#goodsd").empty().append("<option value="+obj[i].agent_name+">"+obj[i].agent_name+"</option>");
						}
					},
					error:function(XMLHttpRequest,textStatus,errorThrown){
						 alert("系统错误请联系管理员");
					}
				});
			});
			
			/* 判断名字是否重复 */
			$("#goodsName").change(function() {
				var goodsName=$("#goodsName").val();
				$.ajax({
					url:"<%=request.getContextPath()%>/judegaddname",
					type:"post",
					dataType:"json",
					data:{"goodsName":goodsName},
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
			<div class="panel panel-default" >
				<div class="panel-heading">
					<h4 class="panel-title"><fmt:message key="AddGoods"></fmt:message></h4>
				</div>
				
				<div class="panel-body" style="padding-left: 20%;">
					<div class="container-fluid">
						<form class="form-horizontal" action="<%=request.getContextPath()%>/goodsreciewHandler/goodsreciew" method="Post" enctype="multipart/form-data">
							<div class="form-group ">
									<label for="sName" class="col-xs-3 control-label"><fmt:message key="ChoosingBrand"></fmt:message></label>
									<div class="col-xs-8 ">
										<!-- 自定义标签 name=gooodsp id =goodsp -->
										<m:goodsp></m:goodsp>
								</div>
							</div>
							
							
							<div class="form-group ">
									<label for="sName" class="col-xs-3 control-label"><fmt:message key="SelectionOfAgents"></fmt:message></label>
									<div class="col-xs-8 ">
										<select name="goodsd" id="goodsd">
											<option value="罗日天">罗日天</option>
											<option value="天日罗">天日罗</option>
											<option value="日罗天">日罗天</option>
										</select>
									</div>
							</div>
							
							
							
							<div class="form-group ">
								<label for="sName" class="col-xs-3 control-label"><fmt:message key="NameOfCommodity"></fmt:message></label>
								<div class="col-xs-8 ">
									<input type="text" class="form-control input-sm duiqi"
										name="goodsName" id="goodsName" placeholder="" required="required">
										<font color="red">${goodsName }</font>
										<div style="display: none" id="Tips">
											<font color="red">名字已经存在</font>
										</div>
								</div>
							</div>

							<div class="form-group">
								<label for="sLink" class="col-xs-3 control-label"><fmt:message key="commodityPrice"></fmt:message></label>
								<div class="col-xs-8 ">
									<input type="text" class="form-control input-sm duiqi"
										name="goodsj" id="" placeholder="" pattern="^[0-9]*$">
								</div>
							</div>

							<div class="form-group">
								<label for="sOrd" class="col-xs-3 control-label"><fmt:message key="MerchandisePictures"></fmt:message></label>
								<div class="col-xs-8">
									<input type="file" class="form-control input-sm duiqi"
										id="Goodsimg" name="Goodsimg" placeholder="">
								</div>
							</div>

							<div class="form-group">
								<label for="sLink" class="col-xs-3 control-label"><fmt:message key="commodityPrice"></fmt:message></label>
								<div class="col-xs-8 ">
									<input type="text" class="form-control input-sm duiqi"
										name="goodsm" id="" placeholder="" required="required">
								</div>
							</div>

							<div class="form-group">
								<label for="sLink" class="col-xs-3 control-label"><fmt:message key="CommodityColour"></fmt:message></label>
								<div class="col-xs-8 ">
									<input required="required" name="goodsy" type="radio" value="红色" /><fmt:message key="red"></fmt:message>
									 <input required="required" name="goodsy" type="radio" value="黑色" /><fmt:message key="black"></fmt:message>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-xs btn-white"
									data-dismiss="modal" onclick="javascript:history.back(-1);"><fmt:message key="cancel"></fmt:message></button>
								<input type="submit" value="<fmt:message key="submit"></fmt:message>" id="save">
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