<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/iconfont.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery-3.4.0.js"></script>
<script type="text/javascript">
	$(document).ready(function(){ 
	  $("#menu a").each(function(){ 
	    $this = $(this); 
	    if($this[0].href==String(window.location)){ 
	    	$("#choose").removeClass("active");
	      $this.parent().addClass("active"); 
	    } 
	  });
	});
</script>
</head>
<body>
<!-- HEADER TOP -->
		<div class="header-top">
			<div class="container">
				<div class="row">
					<div class="col-xs-12 col-sm-6 col-md-7">
						<!-- 左上角联系 -->
						<div class="contact-info">
							<i class="iconfont-headphones round-icon"></i>
							<strong>(+86)88888888</strong>
							<span>(Mon- Fri: 09.00 - 21.00)</span>
							</div>
						<!-- // 左上角联系 -->
					</div>
					<div class="col-xs-12 col-sm-6 col-md-5">
						<ul class="actions unstyled clearfix">
							<li>
								<!-- 右上角搜索框 -->
								<div class="search-box">
									<form action="#" method="post">
										<div class="input-iconed prepend">
											<button class="input-icon"><i class="iconfont-search"></i></button>
											<label for="input-search" class="placeholder">搜索</label>
											<input type="text" name="q" id="input-search" class="round-input full-width" required />
										</div>
									</form>
								</div>
								<!-- // 右上角搜索框 -->
							</li>
							<li data-toggle="sub-header" data-target="#sub-social">
								<!-- 右上角分享 -->
								<a href="javascript:void(0);" id="social-icons">
									<i class="iconfont-share round-icon"></i>
								</a>
								
								<div id="sub-social" class="sub-header">
									<ul class="social-list unstyled text-center">
										<li ><a href="#"><i class="iconfont-facebook round-icon"></i></a></li>
										<li ><a href="#"><i class="iconfont-twitter round-icon"></i></a></li>
										<li ><a href="#"><i class="iconfont-google-plus round-icon"></i></a></li>
										<li ><a href="#"><i class="iconfont-pinterest round-icon"></i></a></li>
										<li ><a href="#"><i class="iconfont-rss round-icon"></i></a></li>
									</ul>
								</div>
								<!-- // 右上角分享 -->
							</li>
							<!-- 右上角客服 -->
							<li data-toggle="sub-header" data-target="#">
								<a href="csrChat.jsp" id="service">
									<i class="iconfont icon-wodekefu round-icon"></i>
								</a>
							</li>
							<!-- 右上角投诉 -->
							<li data-toggle="sub-header" data-target="#">
								<a href="javascript:void(0);" id="complaint">
									<i class="iconfont icon-tousujianyi round-icon"></i>
								</a>
							</li>
							<li data-toggle="sub-header" data-target="#sub-cart">
								<!-- 右上角购物车 -->
								<a href="javascript:void(0);" id="total-cart">
									<i class="iconfont-shopping-cart round-icon"></i>
								</a>
								
								<div id="sub-cart" class="sub-header">
									<div class="cart-header">
										<span>您的购物车是空的</span>
										<small><a href="cart.jsp">(查看所有)</a></small>
									</div>
									<ul class="cart-items product-medialist unstyled clearfix"></ul>
									<div class="cart-footer">
										<div class="cart-total clearfix">
											<span class="pull-left uppercase">合计</span>
											<span class="pull-right total">$ 0</span>
										</div>
										<div class="text-right">
											<a href="cart.jsp" class="btn btn-default btn-round view-cart">我的购物车</a>
										</div>
									</div>
								</div>
								<!-- // 右上角购物车 -->
							</li>
						</ul>
					</div>
				</div>
			</div>
			
			<!-- 添加购物车信息 -->
			<div class="cart-notification">
				<ul class="unstyled"></ul>
			</div>
			<!-- // 添加购物车信息 -->
		</div>
		<!-- // HEADER TOP -->
		<!-- MAIN HEADER -->
		<div class="main-header-wrapper">
			<div class="container">
				<div class="main-header">
					<!-- CURRENCY / LANGUAGE / USER MENU -->
					<div class="actions">
						<div class="center-xs">
							<!-- 右上角货币 -->
							<div class="option-list unstyled" style="background-color: black;">
								<a  href="<%=request.getContextPath()%>/cookieHandler" style="color: white;">注销</a>
								
							</div>
							<!-- // 右上角货币 -->
							<!-- 右上角语言 -->
							<div class="option-list unstyled" style="background-color: white;">
								用户:<font  style="color: #FA6F57;" >${sessionScope.username}</font>
							</div>
							<!-- // 右上角语言 -->
						</div>
						<div class="clearfix"></div>
						
					</div>
					<!-- // CURRENCY / LANGUAGE / USER MENU -->
					<!-- 网站 LOGO -->
					<div class="logo-wrapper">
						<img src="img/logo.png" alt="GFashion - Responsive e-commerce HTML Template" />
					</div>
					<!-- // 网站 LOGO -->
					<!-- 导航菜单 -->
						<nav id="site-menu" role="navigation">
						<ul id="menu" class="main-menu hidden-sm hidden-xs">
							<li id="choose" class="active">
								<a href="index.jsp">首页</a>
							</li>
							<li>
								<a href="goods.jsp">商品</a>
							</li>
							<li>
								<a href="use1.jsp">可用模块1</a>
							</li>
							<li>
								<a href="use2.jsp">可用模块2</a>
							</li>
							<li>
								<a href="use3.jsp">可用模块3</a>
							</li>
							<li>
								<a href="cart.jsp">购物车</a>
							</li>
							<li>
								<a href="order.jsp">订单</a>
							</li>
							<li>
								<a href="footprint.jsp">足迹</a>
							</li>
						</ul>
						
						<!-- 手机端导航菜单 -->
						<div id="mobile-menu" class="dl-menuwrapper visible-xs visible-sm">
							<button class="dl-trigger"><i class="iconfont-reorder round-icon"></i></button>
							<ul class="dl-menu">
								<li class="active">
									<a href="javsacript:void(0);">首页</a>
								</li>
								<li>
									<a href="goods.jsp">商品</a>
								</li>
							</ul>
						</div>
						<!-- // 手机端导航菜单 -->

					</nav><%-- <%@ include file="menu.jsp"%> --%>
					<!-- // 导航菜单 -->
				</div>
			</div>
		</div>
		<!-- // MAIN HEADER -->
</body>
</html>