<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@ include file="/WEB-INF/jsp/admin/top.jsp" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<style>
	img{
	width:100px;
	}
</style>
<script type="text/javascript">
$(function() {
	query();
	var depaName = "";
	$("#home").click(function() {
		query(depaName,1);
	}),
		
	$("#upper").click(function() {
		query(depaName,parseInt($("#pageNow").val()) - 1);
	}),
	
	$("#lower").click(function() {
		query(depaName,parseInt($("#pageNow").val()) + 1);
	}),
	
	$("#tail").click(function() {
		query(depaName,$("#pageCount").val());
	}),
	$("#likeQuery").click(function() {
		depaName = $("#depaName").val();
		$("#querygoods").empty();
		query(depaName);
	});
	
});

function query(dataName,pageNow){
	$.ajax({
		url:"<%=request.getContextPath()%>/goodsreciewHandler/goodsreciews",
		type:"get",
		dataType:"json",
		data:{"dataName":dataName,"pageNow":pageNow},
		async:false,
		success:function(obj){
			$("#pageNow").val(obj.pageEntity.pageNow);
			$("#pageCount").val(obj.pageEntity.pageCount);
			$("#querygoods").empty();
			if($("#pageNow").val() <= 1){
				$("#upper").attr("disabled","disabled");
			}else{
				$("#upper").attr("disabled",false);
			};
			if($("#pageNow").val() >= $("#pageCount").val()){
				$("#lower").attr("disabled","disabled");
			}else{
				$("#lower").attr("disabled",false);
			};
			for(var i=0;i<obj.list.length;i++){
				var to;
				if(obj.list[i].goodsTo==0){
					to="未审核";
				}
				$("#querygoods").append(
						"<tr><td>"+obj.list[i].goodsCode+"</td>"+
						"<td><img src='<%=request.getContextPath()%>/goodsreciewHandler/getImage?materialUrl="+obj.list[i].id+"' ></td>"+
						"<td>"+obj.list[i].goodsName+"</td>"+
						"<td>"+obj.list[i].goodsPrice+"</td>"+
						"<td>"+obj.list[i].goodsDescribe+"</td>"+
						"<td>"+obj.list[i].goodsColor+"</td>"+
						"<td>"+to+"</td>"+
						"<td>"+
							"<a href='<%=request.getContextPath()%>/goodsreciewHandler/updatetrial?id="+obj.list[i].id+"'><button class='btn btn-success btn-xs' data-toggle='modal'><fmt:message key="update"></fmt:message></button></a>"+
							"<a href='' name='deleteName' id='"+obj.list[i].id+"'><button class='btn btn-danger btn-xs'><fmt:message key="Delete"></fmt:message></button></a>"+ 
						"</td>"+
					"</tr>"
				);
			}
		},
		error:function(XMLHttpRequest,textStatus,errorThrown){
			 alert("系统错误请联系管理员");
		}
	});
	$("a[name=deleteName]").click(function(){
		//this代表删除这个超链接 parent td parent.parent tr
		//$(this).parent().parent().find("td")查找td,
			var id = $(this).parent().parent();
			var cc = $(this).attr("id");
		$.ajax({
			url:"<%=request.getContextPath()%>/goodsreciewHandler/goodsreciew/"+cc,
			type:"delete",
			datatype:"json",
			data:{"dataName":dataName,"pageNow":pageNow},
			success:function(aa){
				if(aa.aa == 0){
					id.remove();
					alert("删除失败");
				}else{
					alert("删除成功");
					
				}
			}
		});
		//alert(id);
	});
};


	/* 国际化 */
	function test(){
		/* 获取下拉框的值 */
		var userlocale = $("#userlocale").val();
		alert(userlocale);
		//相当于转发将projectList?locale="+userlocale传入页面路径当参数
		window.location.href="<%=request.getContextPath()%>/goodsreciewHandler/goodsreciews/goodsreciew?locale="+userlocale;
	}

</script>


</head>
<body>
	<div id="rightContent">
		<a class="toggle-btn" id="nimei"> <i
			class="glyphicon glyphicon-align-justify"></i>
		</a>
		<!-- Tab panes -->
		<div class="check-div form-inline">
			
			<div class="col-lg-1 ol-xs-1"  style="padding-top:25px;">
					<a href="<%=request.getContextPath()%>/goodsreciewHandler/goodsreciew/addgoods"><button class="btn btn-yellow btn-xs" ><fmt:message key="AddGoods"></fmt:message></button></a>
			</div>

			<div class="col-lg-1 col-xs-1"  style="padding-top:25px;">
				<a href="<%=request.getContextPath()%>/goodsreciewHandler/goodsreciews/goodsreciewa"><button class="btn btn-yellow btn-xs" ><fmt:message key="ToExamine"></fmt:message></button></a>
			</div>
		
			<div class="col-lg-1  col-xs-1"  style="padding-top:25px;">
				<a href="<%=request.getContextPath()%>/goodsHandler/goodss/goods"><button class="btn btn-yellow btn-xs" ><fmt:message key="Okgoods"></fmt:message></button></a>
			</div>
			
			<div class="col-lg-3 col-xs-1" style="padding-left:100px;">
				<input type="text" id="depaName" class=" form-control input-sm" placeholder="<fmt:message key="material.searchMessage"></fmt:message>">
				<button class="btn btn-white btn-xs " id="likeQuery"><fmt:message key="Query"></fmt:message></button>
			</div>
			<div class="col-lg-3 col-xs-1" style="padding-left:100px;">
			
				<a href="<%=request.getContextPath()%>/goodsreciewHandler/getExcel"><fmt:message key="ExportToExcel"></fmt:message></a>
			</div>
		</div>
		<div class="data-div">
			<div class="row tableHeader">
				<div class="col-lg-1" ><fmt:message key="Code"></fmt:message></div>
				<div class="col-lg-2" style="margin-left:150px;"><fmt:message key="MerchandisePictures"></fmt:message></div>
				<div class="col-lg-1" style=""><fmt:message key="NameOfCommodity"></fmt:message></div>
				<div class="col-lg-1" style="margin-left:60px;"><fmt:message key="commodityPrice"></fmt:message></div>
				<div class="col-lg-1" style="margin-left:20px;"><fmt:message key="CommodityDescription"></fmt:message></div>
				<div class="col-lg-1" ><fmt:message key="CommodityColour"></fmt:message></div>
				<div class="col-lg-1" style="margin-left:-10px;"><fmt:message key="AuditAtatus"></fmt:message></div>
				<div class="col-lg-1" style="margin-left:60px;"><fmt:message key="operation"></fmt:message></div>
			</div>
			
			<div class="tablebody">
				<div class="sitTable">
					<table class="row table table-responsive" id="querygoods">
						<!-- 数据 -->
					</table>
				</div>
			</div>

		</div>
		
		<!--页码块-->
		<footer class="footer">
			<%@ include file="../../footer.jsp"%>
		</footer>
	</div>

</body>
</html>