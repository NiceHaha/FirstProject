<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%-- 	<%@ include file="/admin/top.jsp" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
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
	$.ajax({
		url:"<%=request.getContextPath()%>/imageQueryServlet",
		type:"get",
		async:false,//改为同步，修改、删除操作才起作用，先运行Ajax，再运行点击事件，不然先运行点击操作，才会运行该Ajax。
		dataType:"json",//预期的服务器响应的数据类型,处理接收的返回数据
		success:function(material){//接收后台的返回数据,0/1。请求后台的servlet 中的方法后，响应回来的值，data就是这个值。然后根据dataType参数进行处理后的数据
			for(var i=0;i<material.length;i++){
				 $("#data").append("<div class="imgDiv "><img src="+material[i].materialUrl+"style='width:100px;'/></div>"+
				 "<p>"+material[i].materialName+"</p><div class='btnDiv'>"+
				 "<button class='btn btn-danger btn-xs'  name='chooseImg' materialId='"+material[i].materialId+"'>确定</button>"+
				 "</div></div>");
			} 
		}
	});
	
	$("button[name='chooseImg']").click(function(){
		var materialId = $(this).attr("materialId");//获取包含要删除的id的属性值
		$.ajax({
			url:"<%=request.getContextPath()%>/imageQueryServlet",
			type:"post",
			data:{"materialId":materialId},
			dataType:"json",//预期的服务器响应的数据类型,处理接收的返回数据
			success:function(materialData){//接收后台的返回数据,0/1。请求后台的servlet 中的方法后，响应回来的值，data就是这个值。然后根据dataType参数进行处理后的数据
			$("#advertUrl").attr("value",materialData.materialUrl);//设值
			} 
		});
	});
});
	
</script>
</head>
<body> --%>
<div class="modal fade" id="addImg" role="dialog"
	aria-labelledby="gridSystemModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<!-- <h4 class="modal-title" id="gridSystemModalLabel">选择图片</h4>
				<input type="text" class="form-control input-sm duiqi" name="advertUrl" id="advertUrl" placeholder="" style="height:35px;"> -->
			</div>

			<div class="modal-body">
				<div class="container-fluid" id="mtrBody">
					<div class="sitTable " id="data">
					<!-- 数据 -->
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- </body> -->