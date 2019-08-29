<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/admin/top.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <html>
<head>
<title>客服查询页面</title>
<script type="text/javascript">




$(function(){
	//alert("123");
	query();
	
	var csrName= "";//用来接输入框的值  点击查询之后
	
	$("#home").click(function() {
		query(csrName,1);
	}),
		
	$("#upper").click(function() {
		query(csrName,parseInt($("#pageNow").val()) - 1);
		
	}),
	
	$("#lower").click(function() {
		query(csrName,parseInt($("#pageNow").val()) + 1);
		
	}),
	
	$("#tail").click(function() {
		query(csrName,$("#pageCount").val());
	}),


	
	$("#query").click(function() {
		csrName = $("#csrName").val();
		$("#csrList").empty();
		query(csrName);
	})
});
function query(csrName,pageNow) {
	$.ajax({
		url:"<%=request.getContextPath()%>/csrQueryAll",
		type:"get",
		dataType:"json",
		async:false,
		data:{
			"csrName":csrName,
			"pageNow":pageNow
		},
		success:function(obj){
			//alert("12")
			$("#pageNow").val(obj.pageEntity.pageNow);
			$("#pageCount").val(obj.pageEntity.pageCount);
			$("#csrList").empty();
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
				if(obj.list[i].csrSex == '1'){
						var csrSex = '男';
					}else{
						var csrSex = '女';
					};
					if(obj.list[i].csrStatus == '0'){
						var csrStatus = '不在线';
					}else{
						var csrStatus = '在线'
					
					};
				//alert(obj[i].csrPath);
				//alert(obj[i].csrName);
				$("#csrList").append(
						"<div class='row tablebody'>"+
						"<div class='col-lg-1'><img src='<%=request.getContextPath()%>/getCsrImg?CsrImgUrl="+obj.list[i].id+"' height='60' width='60'/></div>"+
						"<div class='col-lg-1'>"+obj.list[i].csrName+"</div>"+
						"<div class='col-lg-1'>"+obj.list[i].csrSex+"</div>"+
						"<div class='col-lg-1'>"+obj.list[i].csrAge+"</div>"+
						"<div class='col-lg-1'>"+obj.list[i].csrTel+"</div>"+
						"<div class='col-lg-1'>"+obj.list[i].csrStatus+"</div>"+
						"<div class='col-lg-1'>"+obj.list[i].empCode+"</div>"+
						"<div class='col-lg-1'>"+
						"<a href='<%=request.getContextPath()%>/csr/"+obj.list[i].id+"'><button class='btn btn     -success btn-xs' data-toggle='modal'><fmt:message key='project.update'></fmt:message></button></a>"+
							"<a href=''  name='deleteName' id='"+obj.list[i].id+"'><button class='btn btn-danger btn-xs' data-toggle='modal' data-target='#deleteUser'><fmt:message key='project.delete'></fmt:message></button></a>"+
						"</div>"+
					"</div>"
				);
			}
		},
		error:function(XMLHttpRequest,textStatus,errorThrown){
			alert("系统内部错误，请联系管理员！！！")
		}
	});
	
	$("a[name=deleteName]").click(function(){
		//this代表删除这个超链接 parent td parent.parent tr
		//$(this).parent().parent().find("td")查找td,
			var id = $(this).parent().parent();
			var cc = $(this).attr("id");
		$.ajax({
			url:"<%=request.getContextPath()%>/csr/"+cc,
			type:"delete",
			datatype:"json",
			data:{
				id:cc
			},
			success:function(aa){
				if(aa.status == 0){
					id.remove();
				}
			}
		});
	});
}
	//用于国际化 
	function test() {
		//alert(1);
		var language = $("#language").val();
		window.location.href = "csrList?locale=" + language;//csrList这个写的是查询跳转的路径
	}
</script>
</head>
<body>
	<div id="rightContent">
		<a class="toggle-btn" id="nimei"> <i
			class="glyphicon glyphicon-align-justify"></i>
		</a>
	<div class="check-div form-inline">
		<div class="col-xs-3">
			<!-- 添加 -->
			<a href="<%=request.getContextPath()%>/csrPut"><button class="btn btn -yellow btn-xs" data-to><fmt:message key="csr.addCsr"></fmt:message></button></a>
			<!-- 导出Excel表 -->
			<a href="<%=request.getContextPath()%>/csrviewExcel"><button class="btn btn -yellow btn-xs" data-toggle="modal"><fmt:message key="csr.export"></fmt:message></button></button></a>
		</div>
		<div class="col-xs-4">
			<input type="text" class="form-control input-sm" placeholder="输入文字搜索" id = "csrName">
			<button class="btn btn -white btn-xs " id = "query"><fmt:message key="csr.query"></fmt:message></button>
		</div>
		<%-- <fmt:message key="csr.language"></fmt:message><select onchange="test()" id="language">
			<option value="zh_CN" <c:if test="${locale=='zh_CN'}">selected</c:if>>中文</option>
			<option value="en_US" <c:if test="${locale=='en_US'}">selected</c:if>>英文</option>
		</select>
		当前语言: ${pageContext.response.locale} --%>
	</div>
	<div class="data-div">
		<div class="row tableHeader">
			<div class="col-lg-1"><fmt:message key="csr.csrPath"></fmt:message></div>
			<div class="col-lg-1"><fmt:message key="csr.csrName"></fmt:message></div>
			<div class="col-lg-1"><fmt:message key="csr.csrSex"></fmt:message></div>
			<div class="col-lg-1"><fmt:message key="csr.csrAge"></fmt:message></div>
			<div class="col-lg-1"><fmt:message key="csr.csrTel"></fmt:message></div>
			<div class="col-lg-1"><fmt:message key="csr.csrStatus"></fmt:message></div>
			<div class="col-lg-1"><fmt:message key="csr.empCode"></fmt:message></div>
			<div class="col-lg-1"><fmt:message key="csr.control"></fmt:message></div>
		</div>
	</div>
	<div class="data-div" id="csrList">
	</div>
<!--页码块->
	<!--分页 -->
	<footer class="footer">
		<%@ include file="../../footer.jsp"%>
	</footer>
	</div>
</body>
</html>