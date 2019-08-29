<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/jsp/admin/top.jsp" %>
<html>
<head>
<title>客服聊天记录</title>
<!-- <style type="text/css">
body {
	margin: 0;
	padding: 0;
	background: #494A5F;
	font-weight: 500;
	font-family: "Microsoft YaHei", "宋体", "Segoe UI", "Lucida Grande",
		Helvetica, Arial, sans-serif, FreeSans, Arimo;
}

#container {
	width: 500px;
	height: 820px;
	margin: 0 auto;
}

div.search {
	padding: 30px 0;
}

form {
	position: relative;
	width: 300px;
	margin: 0 auto;
}

input, button {
	border: none;
	outline: none;
}

input {
	width: 100%;
	height: 42px;
	padding-left: 13px;
}

button {
	height: 42px;
	width: 42px;
	cursor: pointer;
	position: absolute;
}

/*搜索框1*/
.bar1 {
	background: #A3D0C3;
}

.bar1 input {
	border: 2px solid #7BA7AB;
	border-radius: 5px;
	background: #F9F0DA;
	color: #9E9C9C;
}

.bar1 button {
	top: 0;
	right: 0;
	background: #7BA7AB;
	border-radius: 0 5px 5px 0;
}

.bar1 button:before {
	content: "\f002";
	font-family: FontAwesome;
	font-size: 16px;
	color: #F9F0DA;
}
</style> -->
<body>
<%-- 
	<div id="rightContent">
		<a class="toggle-btn" id="nimei"> <i
			class="glyphicon glyphicon-align-justify"></i>
		</a>
		<div class="check-div form-inline">
			<div class="col-xs-4">
				<input type="text" class="form-control input-sm"
					placeholder="输入文字搜索" id="csrName">
				<button class="btn btn-white btn-xs " id="query">查 询</button>
			</div>
		</div>
		
		
		<div class="data-div">
			<div class="row tableHeader">
				<div class="col-lg-1">用户编号</div>
				<div class="col-lg-1 ">用户名字</div>
				<div class="col-lg-1">客服编号   </div>
				<div class="col-lg-1">客服年龄</div>
				<div class="col-lg-1">开始时间</div>
				<div class="col-lg-1">借书时间</div>
				<div class="col-lg-1">接待时间</div>
				<div class="col-lg-1">满意度</div>
				<div class="col-lg-1">具体内容</div>
				<div class="col-lg-2">操作</div>
			</div>
			<c:forEach items="${list}" varStatus="tt" var="aa">
			<tr>
				<td>${aa.userCode}</td>
				<td>${aa.userName}</td>
				<td>${aa.csrCode}</td>
				<td>${aa.csrName}</td>
				<td>${aa.startTade}</td>
				<td>${aa.endTade}</td>
				<td>${aa.totalTade}</td>
				<td>${aa.recordCsat}</td>
				<td>${aa.recordContent}</td>
				<td>
					<a href="<%=request.getContextPath()%>/CsrRecordDeleServlet?id=${aa.id}">删除</a>
				</td>
			</tr>
		</c:forEach>
			<div class="row tableHeader">
				<c:forEach items="${list}" varStatus="tt" var="aa">
					<div class="col-lg-1">${aa.userCode}</div>
					<div class="col-lg-1 ">${aa.userName}</div>
					<div class="col-lg-1">${aa.csrCode}</div>
					<div class="col-lg-1">${aa.csrName}</div>
					<div class="col-lg-1">${aa.startTade}</div>
					<div class="col-lg-1">${aa.endTade}</div>
					<div class="col-lg-1">${aa.totalTade}</div>
					<div class="col-lg-1">${aa.recordCsat}</div>
					<div class="col-lg-1">${aa.recordContent}</div>
					<div class='col-lg-1'>
						<a href="<%=request.getContextPath()%>/CsrRecordDeleServlet?id=${aa.id}">删除</a>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="data-div" id="csrList"></div>


	</div> --%>
	
<!-- 	<div class="search bar1">
        <form>
            <input type="text" placeholder="请输入您要搜索的内容...">
            <button type="submit" id = "csrRecordButton"></button>
        </form>
    </div> -->
	<div id="rightContent">
		<div class="check-div form-inline">
			<div class="col-xs-4">
				<input type="text" class="form-control input-sm" placeholder="输入文字搜索" id="csrName">
				<button class="btn btn-white btn-xs" id="query">查 询</button>
			</div>
		</div>
		<table class="row table  table-responsive" id="empList">
			<tr>
				<td style="line-height: 70px;">用户编号</td>
				<td>用户名字</td>
				<td>客服编号</td>
				<td>客服名字</td>
				<td>开始时间</td>
				<td>结束时间</td>
				<td>接待时长</td>
				<td>满意度</td>
				<td>具体内容</td>
				<td class="col-lg-2">操作</td>
			</tr>
		<c:forEach items="${list}" varStatus="tt" var="aa">
			<tr>
				<td>${aa.userCode}</td>
				<td>${aa.userName}</td>
				<td>${aa.csrCode}</td>
				<td>${aa.csrName}</td>
				<td>${aa.startTade}</td>
				<td>${aa.endTade}</td>
				<td>${aa.totalTade}</td>
				<td>${aa.recordCsat}</td>
				<td>${aa.recordContent}</td>
				<td>
					<a href="<%=request.getContextPath()%>/CsrRecordDeleServlet?id=${aa.id}">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<div >
			<div class="modal-footer" id="rightContent">

				共 ${pageEntity.pageCount}页；
				 每页显示
				<select class="btn btn-yellow btn-xs" data-toggle="modal">
					<option>2</option>
					<option>5</option>
					<option>10</option>
					<option>20</option>
					<option>50</option>
				</select>条 
				<a	href="<%=request.getContextPath()%>/CsrRecordQueryServlet?pageNow=1">
					<button type="button" class="btn btn-yellow btn-xs" data-toggle="modal" id='home'>首页</button>
				</a> 
				<a href="<%=request.getContextPath()%> /CsrRecordQueryServlet?pageNow-1">
					<button type="button" class="btn btn-yellow btn-xs" data-toggle="modal" id='upper'>上一页</button>
				</a> 
				<a>
					<button type="button" class="btn btn-yellow btn-xs" data-toggle="modal" id='lower'>下一页</button>
				</a>
				 <a	href="<%=request.getContextPath()%>/CsrRecordQueryServlet?pageNow=${pageEntity.pageCount}">
					<button type="button" class="btn btn-yellow btn-xs" data-toggle="modal" id='home'>尾页</button>
				</a> 
					<input type="button" name="Submit" onclick="javascript:history.back(-1);" value="返回" class="btn btn-xs btn-green">
			</div>
			
			
			
		</div>
	</div> 
		
</body>































 <%-- <script type="text/javascript">
$(function(){
	
	//alert("123");
	$.ajax({
		url:"<%=request.getContextPath()%>/CsrRecordQueryServlet",
		type:"get",
		dataType:"text",
		async:false,
		success:function(obj){
			alert("12")
			for(var i=0;i<obj.length;i++){
				alert(obj[i].csrName);
				$("#csrRecordId").append(
						"<div class='row tablebody'>"+
						"<div class='col-lg-1'>"+obj[i].userCode+"</div>"+
						"<div class='col-lg-1'>"+obj[i].userName+"</div>"+
						"<div class='col-lg-1'>"+obj[i].csrCode+"</div>"+
						"<div class='col-lg-1'>"+obj[i].csrName+"</div>"+
						"<div class='col-lg-1'>"+obj[i].startTade+"</div>"+
						"<div class='col-lg-1'>"+obj[i].endTade+"</div>"+
						"<div class='col-lg-1'>"+obj[i].totalTade+"</div>"+
						"<div class='col-lg-1'>"+obj[i].recordCsat+"</div>"+
						"<div class='col-lg-1'>"+obj[i].recordContent+"</div>"+
						"<div class='col-lg-1'>"+
							"<a href=''  name='deleteName' id='"+obj[i].id+"'><button class='btn btn-danger btn-xs' data-toggle='modal' data-target='#deleteUser'>删除</button></a>"+
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
			url:"<%=request.getContextPath()%>/CsrDeleSerlvet",
			type:"get",
			datatype:"json",
			data:{
				id:cc
			},
			success:function(aa){
				if(aa.status == 0){
					id.remove();
					alert("删除成功");
				}else{
					alert("删除失败");
				}
			}
		});
		//alert(id);
	});
});
</script>
</head>
<body>

	<div class="check-div form-inline">
		<div class="col-xs-4">
			<input type="text" class="form-control input-sm" placeholder="输入文字搜索">
			<button class="btn btn-white btn-xs ">查 询</button>
		</div>
		<div class="col-xs-3 col-xs-offset-2 col-xs-4"
			style="padding-right: 40px; text-align: right;">
			<label for="paixu">排序:&nbsp;</label> <select class=" form-control">
				<option>年龄</option>
				<option>年龄</option>
				<option>性别</option>
				<option>编号</option>
			</select>
		</div>
	</div>
	<div class="data-div" id="csrRecordId">
		<div class="row tableHeader">
			<div class="col-lg-1">用户编码</div>
			<div class="col-lg-1 ">用户名字</div>
			<div class="col-lg-1">客服编号</div>
			<div class="col-lg-1">客服名字</div>
			<div class="col-lg-1">开始时间</div>
			<div class="col-lg-1">结束时间</div>
			<div class="col-lg-1">接待时长</div>
			<div class="col-lg-1">满意度</div>
			<div class="col-lg-1">具体内容</div>
			<div class="col-lg-2">操作</div>
		</div>
	</div>
	 --%>
	
	<!-- 删除 -->
<%-- 	<footer class="footer">
		<%@ include file="csrDelete.jsp"%>
	</footer>  --%>
</body> 
</html>