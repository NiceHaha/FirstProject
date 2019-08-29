<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>前台注册</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" tppabs="css/style.css" />
<style>
body{height:100%;background:#DBDBDB;overflow:hidden;}
canvas{z-index:-1;position:absolute;}
</style>
<script src="<%=request.getContextPath()%>js/jquery.js"></script>
<script src="<%=request.getContextPath()%>js/verificationNumbers.js" tppabs="js/verificationNumbers.js"></script>
<script src="<%=request.getContextPath()%>js/Particleground.js" tppabs="js/Particleground.js"></script>
<script type="text/javascript">
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



$(document).ready(function(){
	$("#useraccount").change(function(){
		var useraccount=$("#useraccount").val();
		 $.ajax({
			 url:"<%=request.getContextPath()%>/fregister",
			 type:"post",
			 data:{"useraccount":useraccount},//传值到后台
		 	 dataType:"json",//预期的服务器响应的数据类型
		 	 async:false,
		 	 success:function(aa){
		 		   if(aa.ss==0){
		 			 //alert("姓名可以使用");
		 			 $("#div").hide();
		 			 $("#bt").attr("disabled",false);//按钮启动 (disabled:禁用)
		 		 }else{
		 			//alert("姓名已存在");
		 			 $("#div").show();
		 			$("#bt").attr("disabled",true);//按钮失效
		 		 } 
		 	 },
		 	/*  error:function(XMLHttpRequest,textStatus,errorThrown){
					alert("系统内部错误，请联系管理员！！！")
				} */
		 	 
		 });
	});
	
});



</script>
</head>
<body>



<dl class="admin_login">
 <dt>
  <strong>GFashion<fmt:message key="user.gww"></fmt:message></strong>
  <em><fmt:message key="user.register"></fmt:message></em>
 </dt>
 
 <form action="<%=request.getContextPath()%>/fregister" method="post" id="formId">
 <dd class="user_icon">
  <input type="text" placeholder="<fmt:message key="user.useraccount"></fmt:message>" class="login_txtbx" name="useraccount" id="useraccount"/>
 </dd> 
 <div id="div" style="display: none">
 <font style="color: red">此账号已存在请重新输入</font>
 </div><br/>

 <dd class="pwd_icon">
  <input type="password" placeholder="<fmt:message key="user.userpassword"></fmt:message>" class="login_txtbx" name="userpassword" id="userpassword"/>
 </dd><br/>
 <dd class="name_icon">
  <input type="text" placeholder="<fmt:message key="user.username"></fmt:message>" class="login_txtbx" name="username" id="username"/>
 </dd><br/>
 <div style="color:#FA6F57">
  <input type="radio" value="0" name="usersex" /><fmt:message key="user.men"></fmt:message>
  <input type="radio" value="1" name="usersex" /><fmt:message key="user.women"></fmt:message>
  </div><br/>
  <dd class="age_icon">
  <input type="text" placeholder="<fmt:message key="user.userage"></fmt:message>" class="login_txtbx" name="userage" id="userage"/>
 </dd><br/>
 <dd class="telephone_icon">
  <input type="text" placeholder="<fmt:message key="user.usertel"></fmt:message>" class="login_txtbx" name="usertel" id="usertel"/>
 </dd><br/>
 <dd class="addr_icon">
  <input type="text" placeholder="<fmt:message key="user.useraddr"></fmt:message>" class="login_txtbx" name="useraddr" id="useraddr"/>
 </dd><br/>


 
 <dd>
  <input type="submit" value="<fmt:message key="user.register"></fmt:message>" class="submit_btn" id="bt" />
 </dd><br/>
 </form>
 
<a href="<%=request.getContextPath()%>/flg" style="color:#EE9572"><fmt:message key="user.qdl"></fmt:message></a>
 <dd>
  <p>© 2019-2022 jy 版权所有</p>
  <p>粤-88888888</p>
 </dd>
</dl>
</body>
</html>
