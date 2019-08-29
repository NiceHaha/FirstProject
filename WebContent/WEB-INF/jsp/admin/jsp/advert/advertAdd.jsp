<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
     <%@ include file="/WEB-INF/jsp/admin/top.jsp" %>
    <%@ taglib prefix="advertGoodsCode" uri="/advGsCd" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
img{
width:100px;
}

#mtrBody{

}
#date{
	width:100%;
	background:orange;
}
.imgDiv{
	width:100px;
	height:100px;
	position: relative;
	background:red;
}
 .btnDiv{
background:pink;
margin-top:-10px;
}
	#mtrBody img{
		max-width:100px; 
		max-height:100px;
		overflow:hidden; 
		position: absolute;
		bottom: 0px;
	}
	
	.dateDiv{
		float:left;
		width:110px;
		heigth:150px;
		margin-right:60px;
		
	magin-top:10px;
	}
</style>      
	<script type="text/javascript">
		$(document).ready(function(){
			$("#save").click(function(){
				var path = $("#advertUrl").val();
				  if (path.length == 0) {
				      alert("请选择一张图片！");
				      return false;
				  } else {
				      var extStart = path.lastIndexOf('.'),
				          ext = path.substring(extStart, path.length).toUpperCase();
				      if (ext !== '.PNG' && ext !== '.JPG' && ext !== '.JPEG' && ext !== '.GIF'&& ext !== 'BMP') {
				          alert("图片格式不正确！");
				          $("#advertUrl").attr("value","");
				          return false;
				      }
				  }
			});
		});
	</script>
</head>
<body>
	<div id="rightContent">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title"><fmt:message key="advert.addAdvert"></fmt:message></h4>
			</div>
			<div class="panel-body" style="padding-left: 20%;">
				<div class="container-fluid">
					<form class="form-horizontal" action="<%=request.getContextPath()%>/advertHandler/advert" method="POST" enctype="multipart/form-data">
						<div class="form-group ">
							<label for="gdsCode" class="col-xs-3 control-label"><fmt:message key="advert.goodsCode"></fmt:message>：</label>
							<div class="col-xs-8 " style="margin-top: 8px;">
								<advertGoodsCode:targetSelect></advertGoodsCode:targetSelect>
							</div>
						</div>
						<div class="form-group ">
							<label for="advUrl" class="col-xs-3 control-label"><fmt:message key="advert.advertUrl"></fmt:message>：</label>
							<div class="col-xs-8 ">
								<input type="file" class="input-sm duiqi" id="advertUrl" name="file" placeholder="" style="height: 35px;">
							</div>
						</div>
						<div class="form-group ">
							<label for="advDescride" class="col-xs-3 control-label"><fmt:message key="advert.descride"></fmt:message>：</label>
							<div class="col-xs-8 ">
								<input type="text" class="form-control input-sm duiqi" name="descride" placeholder="" style="height: 35px;float:left;"><!-- required="required" -->
								<p style="color: red; margin-top: 7px;">${descride}</p>
							</div>
						</div>

						<!-- 按钮 -->
						<div class="modal-footer">
							<%String refererPage = request.getHeader("REFERER");%>
							      <input type="button" id="back" name="back"
								class="button_return" value="<fmt:message key="advert.cancel"></fmt:message>"
								onclick="javascript:window.location='<%=refererPage%>'">
							<input type="submit" id="save" value="<fmt:message key="advert.save"></fmt:message>"></input>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>