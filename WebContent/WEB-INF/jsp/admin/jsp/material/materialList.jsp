<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
	<%@ include file="/WEB-INF/jsp/admin/top.jsp" %>
	
<!DOCTYPE html>
<html>
<head>
	<style>
	#Materialdata img {
		width: 100px;
	}
	</style>
	<script type="text/javascript">
		$(document).ready(function(){
			//加载完成就调用查询
			page(1,"");//第一页
			
			//点击查询事件
			$("#likeQuery").click(function(){ 
				/* 给搜索框的值赋给隐藏框 */
				$("#likeQueryWords").val($("#words").val());
				page(1,$("#likeQueryWords").val());
			});
			
			//点击首页
			$("#home").click(function(){
				$("#words").val($("#likeQueryWords").val());
				page(1,$("#likeQueryWords").val());//第一页
				$("#lower").attr("disabled",false);
			});
			
			//点击尾页
			$("#tail").click(function(){
				$("#words").val($("#likeQueryWords").val());
				page($("#pageCount").val(),$("#likeQueryWords").val());//总页数
				$("#upper").attr("disabled",false);
			});
			
			//点击上一页
			$("#upper").click(function(){
				 $("#words").val($("#likeQueryWords").val());
				var pg = parseInt($("#pageNow").val());//当前页-1
				if (pg == 1){
					page(pg,$("#likeQueryWords").val());
					$("#upper").attr("disabled", true); 
				}else{
					page(pg-1,$("#likeQueryWords").val());
					$("#lower").attr("disabled",false);
				}
				
			});
			
			//点击下一页
			$("#lower").click(function(){
				 $("#words").val($("#likeQueryWords").val());
				var pg = parseInt($("#pageNow").val());//当前页+1
				if(pg == $("#pageCount").val()){
					page(pg,$("#likeQueryWords").val());
					$("#lower").attr("disabled", true); 
				}else{
					page(pg+1,$("#likeQueryWords").val());
					$("#upper").attr("disabled",false);
				}
			});
			
		//点击删除事件
		function deleteClick(){
			$("button[name='deleteMaterial']").click(function(){
				var materialId = $(this).attr("materialId");//获取包含要删除的id的属性值
				var tag = $(this).parent().parent();//获取到a标签的父级td的父级tr
				$.ajax({
					url:"<%=request.getContextPath()%>/materialHandler/material/"+materialId,
					type:"delete",
					dataType:"json",//预期的服务器响应的数据类型,处理接收的返回数据
					success:function(mtrDelData){//接收后台的返回数据,0/1。请求后台的servlet 中的方法后，响应回来的值，data就是这个值。然后根据dataType参数进行处理后的数据
						if(mtrDelData.mtrDelStatus == 0){//删除成功
							$(tag).remove();//删除tr标签
						}else{//删除失败
							alert("啊哦，删除失败了");
						}
					} 
				});
			});
		}
		
		//分页
		function page(pageN,words){
			$.ajax({
				url:"<%=request.getContextPath()%>/materialHandler/materials",
				type:"get",
				async:false,//改为同步，修改、删除操作才起作用，先运行Ajax，再运行点击事件，不然先运行点击操作，才会运行该Ajax。
				dataType:"json",//预期的服务器响应的数据类型,处理接收的返回数据
				data:{"pageNow":pageN,"materialName":words},
				success:function(material){//接收后台的返回数据,0/1。请求后台的servlet 中的方法后，响应回来的值，data就是这个值。然后根据dataType参数进行处理后的数据
					$("#count").val(material.pageEntity.count);//给总条数赋值
					$("#pageCount").val(material.pageEntity.pageCount);//给总页数赋值
					$("#pageNow").val(material.pageEntity.pageNow);
					$("#Materialdata").empty();
					for(var i=0;i<material.list.length;i++){
						 $("#Materialdata").append("<tr><td>"+material.list[i].materialCode+
								 			  "</td><td><img src='<%=request.getContextPath()%>/materialHandler/showPhoto?path="+material.list[i].materialUrl+
								 			  "'></td><td>"+material.list[i].materialName+
								 			  "</td><td>"+
								 			  		 "<a href='<%=request.getContextPath()%>/materialHandler/material/"+material.list[i].materialId+"'><button class='btn btn-success btn-xs'><fmt:message key="material.update"></fmt:message></button></a>"+
								 			  		 "<button class='btn btn-danger btn-xs'  name='deleteMaterial' materialId='"+material.list[i].materialId+"'><fmt:message key="material.del"></fmt:message></button>"+
								 			  "</td></tr>"
								 			  );
					} 
					deleteClick();
				}
			}); 
		}
	});
</script>
</head>
<body>
	
	<!-- 右侧具体内容栏目 -->
	<div id="rightContent">
		<a class="toggle-btn" id="nimei"> <i
			class="glyphicon glyphicon-align-justify"></i>
		</a>
		<div class="check-div form-inline">
			<!-- 权限管理模块 -->
			<div class="col-lg-3">
				<a href="<%=request.getContextPath()%>/materialHandler/material"><button class="btn btn-yellow btn-xs" style="margin-top:25px;"><fmt:message key="material.addMaterial"></fmt:message></button></a>
			</div>
			<div class="col-lg-4 col-xs-5">
				<input type="text" id="words" value="" class=" form-control input-sm" placeholder="<fmt:message key='material.searchMessage'></fmt:message>">
				<button class="btn btn-white btn-xs " id="likeQuery"><fmt:message key="material.search"></fmt:message></button>
				
			</div>
			<div class="col-lg-5">
				<a href="<%=request.getContextPath()%>/materialHandler/viewExcel"><fmt:message key="material.export"></fmt:message></a>
			</div>
			
		</div>
		
		<div class="data-div">
			<div class="row tableHeader">
				<div class=" col-lg-3"><fmt:message key="material.materialCode"></fmt:message></div>
				<div class=" col-lg-3" style="margin-left:70px;"><fmt:message key="material.materialUrl"></fmt:message></div>
				<div class=" col-lg-3"><fmt:message key="material.materialName"></fmt:message></div>
				<div class=" col-lg-1" style="margin-left:-85px;"><fmt:message key="material.operation"></fmt:message></div>
			</div>
			
			<div class="tablebody">
				<div class="sitTable">
					<table class="row table table-responsive" id="Materialdata">
						<!-- 数据 -->
					</table>
				</div>
			</div>

		</div>
		<!--页码块-->
		<footer class="footer">
			<%-- <%@ include file="../../footer.jsp"%> --%>
			<input type="hidden" id="count">
			<input type="hidden" id="pageNow">
			<input type="hidden" id="pageCount">
			<input type="hidden" id="likeQueryWords" value=""><!-- 隐藏的搜索框的值 -->

			<button type="button" class="btn btn-yellow btn-xs" id='home'><fmt:message key="index.home"></fmt:message></button>
			<button type="button" class="btn btn-yellow btn-xs" id='upper'><fmt:message key="index.previous"></fmt:message></button>
			<button type="button" class="btn btn-yellow btn-xs" id='lower'><fmt:message key="index.next"></fmt:message></button>
			<button type="button" class="btn btn-yellow btn-xs" id='tail'><fmt:message key="index.end"></fmt:message></button>
		</footer>
	</div>
</body>
</html>