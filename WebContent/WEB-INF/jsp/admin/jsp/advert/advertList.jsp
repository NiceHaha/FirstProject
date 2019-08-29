<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    <%@ include file="/WEB-INF/jsp/admin/top.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>广告管理</title>
	<style>
	  img{
		width:100px;
	  }
	</style>
	<script type="text/javascript">
		$(document).ready(function(){
			page(1);//第一页
	
			//分页
			function page(pageN){
				$.ajax({
					url:"<%=request.getContextPath()%>/advertHandler/adverts",
					type:"get",
					async:false,//改为同步，修改、删除操作才起作用，先运行Ajax，再运行点击事件，不然先运行点击操作，才会运行该Ajax。
					dataType:"json",//预期的服务器响应的数据类型,处理接收的返回数据
					data:{"pageNow":pageN},
					success:function(advert){//接收后台的返回数据,0/1。请求后台的servlet 中的方法后，响应回来的值，data就是这个值。然后根据dataType参数进行处理后的数据
						$("#count").val(advert.pageEntity.count);//给总条数赋值
						$("#pageCount").val(advert.pageEntity.pageCount);//给总页数赋值
						$("#pageNow").val(advert.pageEntity.pageNow);
						$("#data").empty();
						for(var i=0;i<advert.list.length;i++){
							if (advert.list[i].advertShow == 0){
								var btn = "<fmt:message key="advert.online"></fmt:message>";
								var btnColor = "btn-success";
							} else {
								var btn = "<fmt:message key="advert.offline"></fmt:message>";
								var btnColor = "btn-danger";
							}
							 $("#data").append("<tr><td>"+advert.list[i].goodsCode+
						 			  "</td><td><img src='<%=request.getContextPath()%>/advertHandler/showPhoto?path="+advert.list[i].advertUrl+
						 			  "'></td><td>"+advert.list[i].descride+
						 			 	"</td><td>"+advert.list[i].advertClick+
						 			 	"</td><td>"+
						 			 	"<button class='btn "+btnColor+" btn-xs' id="+advert.list[i].id+" name='advertShowBtn' advertShow="+advert.list[i].advertShow+">"+btn+"</button>"+
						 			    "</td><td>"+
						 			  		 "<a href='<%=request.getContextPath()%>/advertHandler/advert/"+advert.list[i].id+"'><button class='btn btn-success btn-xs'><fmt:message key="material.update"></fmt:message></button></a>"+
						 			  		 "<button class='btn btn-danger btn-xs'  name='deleteAdvert' id='"+advert.list[i].id+"'><fmt:message key="material.del"></fmt:message></button>"+
						 			  "</td></tr>"
						 			  );
						}  
						show();//回调展示方法
						deleteClick();//回调删除方法
					}
				}); 
			}
	
			//点击首页
			$("#home").click(function(){
				page(1);//第一页
				$("#lower").attr("disabled",false);
			});
			
			//点击尾页
			$("#tail").click(function(){
				page($("#pageCount").val());//总页数
				$("#upper").attr("disabled",false);
			});
			
			//点击上一页
			$("#upper").click(function(){
				var pg = parseInt($("#pageNow").val());//当前页-1
				if (pg == 1){
					page(pg);
					$("#upper").attr("disabled", true); 
				}else{
					page(pg-1);
					$("#lower").attr("disabled",false);
				}
			});
	
			//点击下一页
			$("#lower").click(function(){
				var pg = parseInt($("#pageNow").val());//当前页+1
				if(pg == $("#pageCount").val()){
					page(pg);
					$("#lower").attr("disabled", true); 
				}else{
					page(pg+1);
					
					$("#upper").attr("disabled",false);
				}
			});
			
			//展示
			function show(){ 
				$("button[name='advertShowBtn']").click(function(){
					var advertShow = $(this).attr("advertShow");//获取状态，0为可上线，1为可下线
					if(advertShow == 0){
						advertShow = 1;
					}else{
						advertShow = 0;
					}
					var id = $(this).attr("id");
					$.ajax({
						url:"<%=request.getContextPath()%>/advertHandler/advert/"+id,
						type:"put",
						data:{"advertShow":advertShow},
						dataType:"json",//预期的服务器响应的数据类型,处理接收的返回数据
						success:function(advertShowData){//接收后台的返回数据,0/1。请求后台的servlet 中的方法后，响应回来的值，data就是这个值。然后根据dataType参数进行处理后的数据
							if(advertShowData.status == 0){//修改成功
								if(advertShow == 0){//状态为0，说明处于未展示状态，改为1可下线
									window.location.reload();
								}else {
									window.location.reload();
								}
							}else{//修改失败
								alert("啊哦，修改失败了");
							}
						} 
					});
				});
			}
			
			/* 删除 */
			function deleteClick(){
				$("button[name='deleteAdvert']").click(function(){
					var id = $(this).attr("id");//获取包含要删除的id的属性值
					var tag = $(this).parent().parent();//获取到a标签的父级td的父级tr
					$.ajax({
						url:"<%=request.getContextPath()%>/advertHandler/advert/"+id,
						type:"delete",
						dataType:"json",//预期的服务器响应的数据类型,处理接收的返回数据
						success:function(advDelData){//接收后台的返回数据,0/1。请求后台的servlet 中的方法后，响应回来的值，data就是这个值。然后根据dataType参数进行处理后的数据
							if(advDelData.advDelStatus == 0){//删除成功
								$(tag).remove();//删除tr标签
							}else{//删除失败
								alert("啊哦，删除失败了");
							}
						} 
					});
				});
			}
		});
	</script>
</head>
<body>
     <div id="rightContent">
        <a class="toggle-btn" id="nimei">
            <i class="glyphicon glyphicon-align-justify"></i>
        </a>
		<div class="check-div form-inline">
			<div class="col-xs-3">
				<a href="<%=request.getContextPath()%>/advertHandler/advert"><button class="btn btn-yellow btn-xs"  style="margin-top:25px;"><fmt:message key="advert.addAdvert"></fmt:message></button></a>
			</div>
		</div>
		<div class="data-div">
			<div class="row tableHeader">
				<div class=" col-lg-3"><fmt:message key="advert.goodsCode"></fmt:message></div>
				<div class=" col-lg-3" style="margin-left:-20px;"><fmt:message key="advert.advertUrl"></fmt:message></div>
				<div class=" col-lg-2" style="margin-left:-85px;"><fmt:message key="advert.descride"></fmt:message></div>
				<div class=" col-lg-1"><fmt:message key="advert.advertClick"></fmt:message></div>
				<div class=" col-lg-1"><fmt:message key="advert.advertShow"></fmt:message></div>
				<div class=" col-lg-1" style="margin-left:55px;"><fmt:message key="advert.operation"></fmt:message></div>
			</div>
			<div class="tablebody">
				<div class="sitTable">
					<table class="row table table-responsive" id="data">
							<!-- 数据 -->
					</table>
				</div>
			</div>
		</div>
		<!--页码块-->
		<footer class="footer">
			<input type="hidden" id="count">
			<input type="hidden" id="pageNow">
			<input type="hidden" id="pageCount">

			<button type="button" class="btn btn-yellow btn-xs" id='home'><fmt:message key="index.home"></fmt:message></button>
			<button type="button" class="btn btn-yellow btn-xs" id='upper'><fmt:message key="index.previous"></fmt:message></button>
			<button type="button" class="btn btn-yellow btn-xs" id='lower'><fmt:message key="index.next"></fmt:message></button>
			<button type="button" class="btn btn-yellow btn-xs" id='tail'><fmt:message key="index.end"></fmt:message></button>
		</footer>
	</div>
</body>
</html>