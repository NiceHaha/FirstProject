<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
	 <%@ include file="/WEB-INF/jsp/admin/top.jsp" %>
<!DOCTYPE html>
    <head>
     <style>
    img{
    	width:100px;
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
				<h4 class="modal-title"><fmt:message key="advert.modifyAdvert"></fmt:message></h4>
			</div>
			<div class="panel-body" style="padding-left: 20%;">
				<div class="container-fluid">
					<form class="form-horizontal" action="<%=request.getContextPath()%>/advertHandler/advert" method="post" enctype="multipart/form-data">
						<input type="hidden" name="id" id="advertId" value="${advert.id}" />
						<input type="hidden" name="_method" value="PUT">
						<div class="form-group">
							<label for="sName" class="col-xs-3 control-label"><fmt:message key="advert.goodsCode"></fmt:message>：</label>
							<div class="col-xs-6">
								<input type="text" class="form-control input-sm duiqi" name="goodsCode" placeholder="" value="${advert.goodsCode}" readonly="readonly">
							</div>
						</div>
						<div class="form-group">
							<label for="sLink" class="col-xs-3 control-label"><fmt:message key="advert.advertUrl"></fmt:message>：</label>
							<div class="col-xs-6 ">
								<img src="<%=request.getContextPath()%>/advertHandler/showPhoto?path=${advert.advertUrl}">
								<input type="file" class="input-sm duiqi" id="advertUrl" name="file" placeholder="" style="height: 35px;">
							</div>
						</div>
						<div class="form-group">
							<label for="sOrd" class="col-xs-3 control-label"><fmt:message key="advert.descride"></fmt:message>：</label>
							<div class="col-xs-6">
								<input type="text" class="form-control input-sm duiqi" style="float:left;" id="descride" name="descride" placeholder="" value="${advert.descride}" ><!-- required="required" -->
								<p style="color: red; margin-top: 7px; ">${descride}</p>
							</div>
						</div>
						<div class="modal-footer">
							<%String refererPage = request.getHeader("REFERER");%>
							<input type="button" id="back" name="back" class="button_return" value="<fmt:message key="advert.cancel"></fmt:message>" onclick="javascript:window.location='<%=refererPage%>'">
							<input type="submit" id="save" value="<fmt:message key="advert.save"></fmt:message>"></input>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
