<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ include file="/WEB-INF/jsp/admin/aa.jsp" %>

<div id="wrap">
		 <!-- 左侧菜单栏目块 -->
            <div class="leftMeun" id="leftMeun" style="background: white bottom;">
                <div id="logoDiv" style="background-color: #337ab7;">
                   <p id="logoP">
					<span style="color:white"><fmt:message key="index.system"></fmt:message></span>
				</p>
                </div>
                <div id="personInfor" style=" font-weight: bold;color: #646987;">
                    <fmt:message key="index.userName"></fmt:message>:<p id="userName">${sessionScope.username}</p>
					<!-- 中英文切换 -->
					<select onchange="changeLanguage()" id="language" style="float:right;margin-top:-13px;">
						<option value="zh_CN" <c:if test="${locale=='zh_CN'}">selected</c:if> >中文</option>
						<option value="en_US" <c:if test="${locale=='en_US'}">selected</c:if> >English</option>
					</select>
					<a href="<%=request.getContextPath()%>/cookieHandler2" ><fmt:message key="index.logOut"></fmt:message></a>
				
                </div>
                <div class="meun-title"><fmt:message key="index.account"></fmt:message></div>
         
                <nav >
					<ul class="list-group hidden-sm hidden-xs" id="menu" >
						<li id="choose" class=" active list-group-item" ><!-- style="background-color: #3d4e60; border-color:#3d4e60;   border-right: 4px solid #647f9d;" -->
							<a href="<%=request.getContextPath() %>/materialHandler/materialList"><fmt:message key="index.material"></fmt:message></a>
						</li>
						<li class="list-group-item list-unstyled " ><!-- style="color:#4d5e70;background-color:#4d5e70;border-color:#4d5e70" -->
							<a href="<%=request.getContextPath()%>/advertHandler/advertList" ><fmt:message key="index.advert"></fmt:message></a>
						</li>
						<li class="list-group-item list-unstyled " ><!-- style="color:#4d5e70;background-color:#4d5e70;border-color:#4d5e70" -->
							<a href="<%=request.getContextPath() %>/brandList" ><fmt:message key="index.brand"></fmt:message></a>
						</li>
						<li class="list-group-item list-unstyled " ><!-- style="color:#4d5e70;background-color:#4d5e70;border-color:#4d5e70" -->
							<a href="<%=request.getContextPath() %>/agentList" ><fmt:message key="index.agent"></fmt:message></a>
						</li>
						<li class="list-group-item list-unstyled " ><!-- style="color:#4d5e70;background-color:#4d5e70;border-color:#4d5e70" -->
							<a href="<%=request.getContextPath() %>/goodsreciewHandler/goodsreciews/goodsreciew" ><fmt:message key="index.goods"></fmt:message></a>
						</li>
						<li class="list-group-item list-unstyled " ><!-- style="color:#4d5e70;background-color:#4d5e70;border-color:#4d5e70" -->
							<a href="<%=request.getContextPath() %>/csrList" ><fmt:message key="index.service"></fmt:message></a>
						</li>
						<li class="list-group-item list-unstyled" ><!-- style="color:#4d5e70;background-color:#4d5e70;border-color:#4d5e70" -->
							<a href="<%=request.getContextPath() %>/userController/userList"><fmt:message key="index.user"></fmt:message></a>
						</li>
						<li class="list-group-item list-unstyled " ><!-- style="color:#4d5e70;background-color:#4d5e70;border-color:#4d5e70" -->
							<a href="<%=request.getContextPath() %>/orders" ><fmt:message key="index.orders"></fmt:message></a>
						</li>
						<li class="list-group-item list-unstyled" ><!-- style="color:#4d5e70;background-color:#4d5e70;border-color:#4d5e70" -->
							<a href="<%=request.getContextPath() %>/projectList"><fmt:message key="index.project"></fmt:message></a>
						</li>
						<li class="list-group-item list-unstyled" ><!-- style="color:#4d5e70;background-color:#4d5e70;border-color:#4d5e70" -->
							<a href="<%=request.getContextPath() %>/empController/empList"><fmt:message key="index.employee"></fmt:message></a>
						</li>
						<li class="list-group-item list-unstyled" ><!-- style="color:#4d5e70;background-color:#4d5e70;border-color:#4d5e70" -->
							<a href="<%=request.getContextPath() %>/depaController/depaList"><fmt:message key="index.department"></fmt:message></a>
						</li>
					</ul>
				</nav>
</div>
