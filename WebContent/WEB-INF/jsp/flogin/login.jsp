<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>前台登录</title>
<meta name="author" content="DeathGhost" />
   
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" tppabs="css/style.css" />
<style>
body{height:100%;background:#DBDBDB;overflow:hidden;}
canvas{z-index:-1;position:absolute;}
</style>
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/js/verificationNumbers.js" tppabs="js/verificationNumbers.js"></script>
<script src="<%=request.getContextPath()%>/js/Particleground.js" tppabs="js/Particleground.js"></script>
<script>
$(document).ready(function() {
  //粒子背景特效
  $('body').particleground({
    dotColor: '#FA6F57',
    lineColor: '#FA6F57'
  });
 
  
  //测试提交，对接程序删除即可
  $(".submit_btn").click(function(){
	  location.href="javascrpt:;"/*tpa=http://***index.html*/;
	  });
  
});




$(function() {
	var auto= $("#auto").val();
	if(auto==1){
		$("#formId").submit();
	}
});

$(function() {
	var mark= $("#mark").val();
	if(mark==1){
		$("#div").show();
	}
});


$(document).ready(function() {
	$("#img").click(function(){//<font>被单击隐藏自己
		 $("#img").attr("src","/GF/code?t="+Math.random()); 
		
	});
 });



function changeLanguage(){
	var language = $("#language").val();
	window.location.href="<%=request.getContextPath() %>/changelogin?locale="+language; 
}

</script>

</head>
<body>
<% Cookie[] cooks=request.getCookies();
	for (Cookie cookie : cooks) {
		if(cookie.getName().equals("cookUserName")){
			request.setAttribute("cookUserName", cookie.getValue());
		}else if(cookie.getName().equals("cookPassWord")){
			request.setAttribute("cookPassWord", cookie.getValue());
			//request.setAttribute("auto", "1");//自动登录
		}
	} %>
	






<dl class="admin_login">
 <dt>
  <strong>GFashion<fmt:message key="user.gww"></fmt:message></strong>
  <em>Front-End System</em>
 </dt>
 
  <form action="<%=request.getContextPath()%>/login" method="post" id="formId">
 <input type="hidden" name="auto" id="auto" value="<%=request.getAttribute("auto") %>">
 <input type="hidden" name="mark" id="mark" value="${mark}">
 <dd class="user_icon">
  <input type="text" placeholder="<fmt:message key="user.useraccount"></fmt:message>" class="login_txtbx" name="username" id="username" value="${empty cookUserName ? '' : cookUserName}" />
 </dd><br/>
 <dd class="pwd_icon">
  <input type="password" placeholder="<fmt:message key="user.userpassword"></fmt:message>" class="login_txtbx" name="password" id="password" value="${empty cookUserPassWord ? '' : cookUserPassWord}" />
 </dd><br/>

 <dd>
  <input type="submit" value="<fmt:message key="user.login"></fmt:message>" class="submit_btn"/>
 </dd><br/>
<div style="display: none" id="div">
	<dd class="yz_icon">
  		<input type="text"  class="login_txtyz" placeholder="<fmt:message key="user.yzm"></fmt:message>" id="code" name="code"/><img alt="点击刷新" title="点击刷新" src="/GF/code" id="img" />
 	</dd><br/>
 </div>
 <font style="color:#EE9572"><fmt:message key="user.mdl"></fmt:message></font><input type="checkbox" name="cok" value="1">
</form><br>
<!-- 中英文切换 -->
			<select onchange="changeLanguage()" id="language" style="float:right;margin-top:-32px;">
				<option value="zh_CN" <c:if test="${locale=='zh_CN'}">selected</c:if> >中文</option>
				<option value="en_US" <c:if test="${locale=='en_US'}">selected</c:if> >English</option>
			</select>



<a href="<%=request.getContextPath()%>/fzc" style="color:#EE9572"><fmt:message key="user.wzc"></fmt:message></a><a href="<%=request.getContextPath()%>/adl" style="color:#EE9572;float: right"><fmt:message key="user.hdl"></fmt:message></a></br>

 <dd>
  <p>© 2019-2022 jy <fmt:message key="user.bq"></fmt:message></p>
  <p>粤-88888888</p>
 </dd>
</dl>
</body>
</html>