<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<!--[if IE 7 ]><html class="ie ie7 lte9 lte8 lte7" lang="en-US"><![endif]-->
<!--[if IE 8]><html class="ie ie8 lte9 lte8" lang="en-US">	<![endif]-->
<!--[if IE 9]><html class="ie ie9 lte9" lang="en-US"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--><html class="noIE" lang="en-US"><!--<![endif]-->
<head>
	<meta charset="UTF-8" />
	<title>GFashion - Responsive e-commerce HTML Template</title>
	<!-- 购物页面，所有商品 -->
	<meta name="description" content=""/>
	<meta name="keywords" content=""/>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	
	<!-- Favorite Icons -->
	<link rel="icon" href="img/favicon/favicon.html" type="image/x-icon" />
	<link rel="apple-touch-icon-precomposed" sizes="144x144" href="img/favicon/apple-touch-icon-144x144-precomposed.html">
	<link rel="apple-touch-icon-precomposed" sizes="72x72" href="img/favicon/apple-touch-icon-72x72-precomposed.html">
	<link rel="apple-touch-icon-precomposed" href="img/favicon/apple-touch-icon-precomposed.html">
	<!-- // Favorite Icons -->
	
	<link href='http://fonts.useso.com/css?family=Open+Sans:300,400,600,700' rel='stylesheet' type='text/css'>
	
	<!-- GENERAL CSS FILES -->
	<link rel="stylesheet" href="css/minified.css">
	<!-- // GENERAL CSS FILES -->
	
	<!--[if IE 8]>
		<script src="js/respond.min.js"></script>
		<script src="js/selectivizr-min.js"></script>
	<![endif]-->
	<!--
	<script src="js/jquery.min.js"></script>
	-->
	<script>window.jQuery || document.write('<script src="js/jquery.min.js"><\/script>');</script>
	<script src="js/modernizr.min.js"></script>	
	<!-- PARTICULAR PAGES CSS FILES -->
	<link rel="stylesheet" href="css/jquery.nouislider.css">
	<link rel="stylesheet" href="css/isotope.css">
	<link rel="stylesheet" href="css/innerpage.css">
	<!-- // PARTICULAR PAGES CSS FILES -->
	<link rel="stylesheet" href="css/responsive.css">
</head>
<body class="products-view">
			
	<!-- PAGE WRAPPER -->
<div id="page-wrapper">

	<!-- 网站顶部 -->
	<header id="site-header" role="banner">
		<%@ include file="top.jsp"%>
	</header>
	<!-- // 网站顶部 -->
	
		<!-- BREADCRUMB -->
		<div class="breadcrumb-container">
			<div class="container">
				<div class="relative">
					<ul class="bc push-up unstyled clearfix">
						<li><a href="index.jsp">首页</a></li>
						<li class="active">商品</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- // BREADCRUMB -->
		
		<!-- SITE MAIN CONTENT -->
		<main id="main-content" role="main">
			<div class="container">
				<div class="row">
					
					<div class="m-t-b clearfix">
						<!-- SIDEBAR -->
						<aside class="col-xs-12 col-sm-4 col-md-3" style="margin-top:-32px;">
								<!-- 广告 -->
								<div class="promo inverse-background" style="background: url('images/demo/Barn-Dress-Girl_t.jpg') no-repeat; background-size: auto 100%;">
									<div class="inner text-center np">
										<div class="ribbon">
											<h6 class="nmb">New Arrivals</h6>
											<h5 class="text-semibold uppercase nmb">Leather Fashion</h5>
											<div class="space10"></div>
											<a href="products.html" class="with-icon prepend-icon"><i class="iconfont-caret-right"></i><span> Shop Now</span></a>
										</div>
									</div>
								</div>
								&nbsp;
								&nbsp;
								<%@ include file="/WEB-INF/jsp/foreground/jsp/project/project.jsp" %>
								<%-- <jsp:include page="/foreground/jsp/project/article.jsp" flush="true"/> --%>
								<!-- // 广告 -->
						</aside>
						<!-- // SIDEBAR -->
						<section class="col-xs-12 col-sm-8 col-md-9">
							<section class="products-wrapper">
								<!-- DISPLAY MODE - NUMBER OF ITEMS TO BE DISPLAY - PAGINATION -->
								<header class="products-header">
									<div class="row">
										<div class="col-xs-12 col-sm-12 col-md-6 center-xs">
											<!-- DISPLAY MODE -->
											<ul class="unstyled inline-li li-m-r-l-sm pull-left">
												<li><a class="round-icon active" href="#" data-toggle="tooltip" data-layout="grid" data-title="Switch to List Grid Mode"><i class="iconfont-th"></i></a></li>
												<li><a class="round-icon" href="#" data-toggle="tooltip" data-layout="list" data-title="Switch to List View Mode"><i class="iconfont-list"></i></a></li>
											</ul>
											<!-- // DISPLAY MODE -->
											
											<!-- NUMBER OF ITEMS TO BE DISPLAY -->
											<div class="pull-right m-l-lg">
												<span class="inline-middle m-r-sm text-xs">Show</span>
												<div class="inline-middle styled-dd">
													<select>
														<option value="9">9</option>
														<option value="12" selected>12</option>
														<option value="24">24</option>
														<option value="36">36</option>
													</select>
												</div>
											</div>
											<!-- // NUMBER OF ITEMS TO BE DISPLAY -->
										</div>
										<div class="space30 visible-xs"></div>
										<!-- PAGINATION -->
										<div class="col-xs-12 col-sm-12 col-md-6 center-xs">
											<ul class="paginator li-m-r-l pull-right">
												<li><a class="round-icon" href="#" data-toggle="tooltip" data-title="Previous Page"><i class="iconfont-angle-left"></i></a></li>
												<li><a href="#">1</a></li>
												<li><a href="#">2</a></li>
												<li><a href="#">3</a></li>
												<li><a href="#">4</a></li>
												<li><a href="#">5</a></li>
												<li><a class="round-icon" href="#" data-toggle="tooltip" data-title="Next Page"><i class="iconfont-angle-right"></i></a></li>
											</ul>
										</div>
										<!-- // PAGINATION -->
									</div>
								</header>
								<!-- // DISPLAY MODE - NUMBER OF ITEMS TO BE DISPLAY - PAGINATION -->
								
								<!-- PRODUCT LAYOUT -->
								<div class="products-layout grid m-t-b add-cart" data-product=".product" data-thumbnail=".entry-media .thumb" data-title=".entry-title > a" data-url=".entry-title > a" data-price=".entry-price > .price">
									
									<div class="product" data-product-id="1" data-category="women|women-jeans|women-skirt" data-brand="brand1" data-price="250" data-colors="red|blue|black|white" data-size="S|M|L">
										<div class="entry-media">
											<img data-src="images/women/skirt/430041-0014_1_t.jpg" alt="" class="lazyLoad thumb" />
											<div class="hover">
												<a href="good.html" class="entry-url"></a>
												<ul class="icons unstyled">
													<li>
														<div class="circle ribbon ribbon-sale">Sale</div>
													</li>
													<li>
														<a href="images/women/skirt/430041-0014_1.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
													</li>
													<li>
														<a href="#" class="circle add-to-cart"><i class="iconfont-shopping-cart"></i></a>
													</li>
												</ul>
												<div class="rate-bar">
													<input type="range" value="4.5" step="0.5" id="backing1" />
													<div class="rateit" data-rateit-backingfld="#backing1" data-rateit-starwidth="12" data-rateit-starheight="12" data-rateit-resetable="false"  data-rateit-ispreset="true" data-rateit-min="0" data-rateit-max="5"></div>
												</div>
											</div>
										</div>
										<div class="entry-main">
											<h5 class="entry-title">
												<a href="good.html">Inceptos orci hac libero</a>
											</h5>
											<div class="entry-description visible-list">
												<p>Sed ornare cras donec litora integer curabitur orci, at nullam aliquam libero nam himenaeos, amet massa amet ut ipsum viverra mauris rhoncus neque aenean rhoncus gravida orci facilisis quis dui consectetur.</p>
											</div>
											<div class="entry-price">
												<s class="entry-discount">$ 350.00</s>
												<strong class="accent-color price">$ 250.00</strong>
												<a href="#" class="btn btn-round btn-default add-to-cart visible-list">Add to Cart</a>
											</div>
											<div class="entry-links clearfix">
												<a href="cart.jsp" class="pull-left m-r">+ 立即购买</a>
												<a href="#" class="add-to-cart pull-right">+ 加入购物车</a>
											</div>
										</div>
									</div>
									
									<div class="product" data-product-id="2" data-category="women|women-accessories|women-basics|women-legging|new" data-brand="brand2" data-price="450" data-colors="red|green|black|white|silver" data-size="XS|S|M">
										<div class="entry-media">
											<img data-src="images/women/accessories/582120-0029_1_t.jpg" alt="" class="lazyLoad thumb" />
											<div class="hover">
												<a href="good.html" class="entry-url"></a>
												<ul class="icons unstyled">
													<li>
														<a href="images/women/accessories/582120-0029_1.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
													</li>
													<li>
														<a href="#" class="circle add-to-cart"><i class="iconfont-shopping-cart"></i></a>
													</li>
												</ul>
												<div class="rate-bar">
													<input type="range" value="4" step="0.5" id="backing2" />
													<div class="rateit" data-rateit-backingfld="#backing2" data-rateit-starwidth="12" data-rateit-starheight="12" data-rateit-resetable="false"  data-rateit-ispreset="true" data-rateit-min="0" data-rateit-max="5"></div>
												</div>
											</div>
										</div>
										<div class="entry-main">
											<h5 class="entry-title">
												<a href="good.html">Inceptos orci hac libero</a>
											</h5>
											<div class="entry-description visible-list">
												<p>Sed ornare cras donec litora integer curabitur orci, at nullam aliquam libero nam himenaeos, amet massa amet ut ipsum viverra mauris rhoncus neque aenean rhoncus gravida orci facilisis quis dui consectetur.</p>
											</div>
											<div class="entry-price">
												<strong class="price">$ 350.00</strong>
												<a href="#" class="btn btn-round btn-default add-to-cart visible-list">Add to Cart</a>
											</div>
											<div class="entry-links clearfix">
												<a href="cart.jsp" class="pull-left m-r">+ 立即购买</a>
												<a href="#" class="add-to-cart pull-right">+ 加入购物车</a>
											</div>
										</div>
									</div>
									
									<div class="product" data-product-id="3" data-category="men|men-jacket|men-accessories|men-jumper|new" data-brand="brand2" data-price="450" data-colors="purple|brown|black|white|patternie" data-size="S|M|L|XL">
										<div class="entry-media">
											<img data-src="images/men/accessories/255615-0014_1_t.jpg" alt="" class="lazyLoad thumb" />
											<div class="hover">
												<a href="good.html" class="entry-url"></a>
												<ul class="icons unstyled">
													<li>
														<div class="circle ribbon ribbon-new">New</div>
													</li>
													<li>
														<a href="images/men/accessories/255615-0014_1.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
													</li>
													<li>
														<a href="#" class="circle add-to-cart"><i class="iconfont-shopping-cart"></i></a>
													</li>
												</ul>
												<div class="rate-bar">
													<input type="range" value="3.5" step="0.5" id="backing3" />
													<div class="rateit" data-rateit-backingfld="#backing3" data-rateit-starwidth="12" data-rateit-starheight="12" data-rateit-resetable="false"  data-rateit-ispreset="true" data-rateit-min="0" data-rateit-max="5"></div>
												</div>
											</div>
										</div>
										<div class="entry-main">
											<h5 class="entry-title">
												<a href="good.html">Inceptos orci hac libero</a>
											</h5>
											<div class="entry-description visible-list">
												<p>Sed ornare cras donec litora integer curabitur orci, at nullam aliquam libero nam himenaeos, amet massa amet ut ipsum viverra mauris rhoncus neque aenean rhoncus gravida orci facilisis quis dui consectetur.</p>
											</div>
											<div class="entry-price">
												<strong class="price">$ 450.00</strong>
												<a href="#" class="btn btn-round btn-default add-to-cart visible-list">Add to Cart</a>
											</div>
											<div class="entry-links clearfix">
												<a href="cart.jsp" class="pull-left m-r">+ 立即购买</a>
												<a href="#" class="add-to-cart pull-right">+ 加入购物车</a>
											</div>
										</div>
									</div>
									
									<div class="product" data-product-id="4" data-category="men|men-jacket|men-accessories|men-jeans|men-jumper" data-brand="brand3" data-price="350" data-colors="purple|brown|black|white|red" data-size="S|M|L|XL|XXL">
										<div class="entry-media">
											<img data-src="images/men/blazer/677326-0014_1_t.jpg" alt="" class="lazyLoad thumb" />
											<div class="hover">
												<a href="good.html" class="entry-url"></a>
												<ul class="icons unstyled">
													<li>
														<a href="images/men/blazer/677326-0014_1.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
													</li>
													<li>
														<a href="#" class="circle add-to-cart"><i class="iconfont-shopping-cart"></i></a>
													</li>
												</ul>
												<div class="rate-bar">
													<input type="range" value="5" step="0.5" id="backing4" />
													<div class="rateit" data-rateit-backingfld="#backing4" data-rateit-starwidth="12" data-rateit-starheight="12" data-rateit-resetable="false"  data-rateit-ispreset="true" data-rateit-min="0" data-rateit-max="5"></div>
												</div>
											</div>
										</div>
										<div class="entry-main">
											<h5 class="entry-title">
												<a href="good.html">Inceptos orci hac libero</a>
											</h5>
											<div class="entry-description visible-list">
												<p>Sed ornare cras donec litora integer curabitur orci, at nullam aliquam libero nam himenaeos, amet massa amet ut ipsum viverra mauris rhoncus neque aenean rhoncus gravida orci facilisis quis dui consectetur.</p>
											</div>
											<div class="entry-price">
												<strong class="price">$ 350.00</strong>
												<a href="#" class="btn btn-round btn-default add-to-cart visible-list">Add to Cart</a>
											</div>
											<div class="entry-links clearfix">
												<a href="cart.jsp" class="pull-left m-r">+ 立即购买</a>
												<a href="#" class="add-to-cart pull-right">+ 加入购物车</a>
											</div>
										</div>
									</div>
									
									<div class="product" data-product-id="5" data-category="men|men-shoe|men-accessories|men-jean|new" data-brand="brand4" data-price="250" data-colors="brown|silver|black|green|red" data-size="L|XL|XXL">
										<div class="entry-media">
											<img data-src="images/men/shoes/000312-2259_1_t.jpg" alt="" class="lazyLoad thumb" />
											<div class="hover">
												<a href="good.html" class="entry-url"></a>
												<ul class="icons unstyled">
													<li>
														<div class="circle ribbon ribbon-sale">Sale</div>
													</li>
													<li>
														<a href="images/men/shoes/000312-2259_1.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
													</li>
													<li>
														<a href="#" class="circle add-to-cart"><i class="iconfont-shopping-cart"></i></a>
													</li>
												</ul>
												<div class="rate-bar">
													<input type="range" value="4.5" step="0.5" id="backing5" />
													<div class="rateit" data-rateit-backingfld="#backing5" data-rateit-starwidth="12" data-rateit-starheight="12" data-rateit-resetable="false"  data-rateit-ispreset="true" data-rateit-min="0" data-rateit-max="5"></div>
												</div>
											</div>
										</div>
										<div class="entry-main">
											<h5 class="entry-title">
												<a href="good.html">Inceptos orci hac libero</a>
											</h5>
											<div class="entry-description visible-list">
												<p>Sed ornare cras donec litora integer curabitur orci, at nullam aliquam libero nam himenaeos, amet massa amet ut ipsum viverra mauris rhoncus neque aenean rhoncus gravida orci facilisis quis dui consectetur.</p>
											</div>
											<div class="entry-price">
												<s class="entry-discount">$ 350.00</s>
												<strong class="accent-color price">$ 250.00</strong>
												<a href="#" class="btn btn-round btn-default add-to-cart visible-list">Add to Cart</a>
											</div>
											<div class="entry-links clearfix">
												<a href="cart.jsp" class="pull-left m-r">+ 立即购买</a>
												<a href="#" class="add-to-cart pull-right">+ 加入购物车</a>
											</div>
										</div>
									</div>
									
									<div class="product" data-product-id="6" data-category="women|women-legging|women-dresses|women-jeans|women-skirt" data-brand="brand5" data-price="350" data-colors="white|silver|green|red|blue" data-size="XS|S">
										<div class="entry-media">
											<img data-src="images/women/jeans/220008-0054_1_t.jpg" alt="" class="lazyLoad thumb" />
											<div class="hover">
												<a href="good.html" class="entry-url"></a>
												<ul class="icons unstyled">
													<li>
														<a href="images/women/jeans/220008-0054_1.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
													</li>
													<li>
														<a href="#" class="circle add-to-cart"><i class="iconfont-shopping-cart"></i></a>
													</li>
												</ul>
												<div class="rate-bar">
													<input type="range" value="4" step="0.5" id="backing6" />
													<div class="rateit" data-rateit-backingfld="#backing6" data-rateit-starwidth="12" data-rateit-starheight="12" data-rateit-resetable="false"  data-rateit-ispreset="true" data-rateit-min="0" data-rateit-max="5"></div>
												</div>
											</div>
										</div>
										<div class="entry-main">
											<h5 class="entry-title">
												<a href="good.html">Inceptos orci hac libero</a>
											</h5>
											<div class="entry-description visible-list">
												<p>Sed ornare cras donec litora integer curabitur orci, at nullam aliquam libero nam himenaeos, amet massa amet ut ipsum viverra mauris rhoncus neque aenean rhoncus gravida orci facilisis quis dui consectetur.</p>
											</div>
											<div class="entry-price">
												<strong class="price">$ 350.00</strong>
												<a href="#" class="btn btn-round btn-default add-to-cart visible-list">Add to Cart</a>
											</div>
											<div class="entry-links clearfix">
												<a href="cart.jsp" class="pull-left m-r">+ 立即购买</a>
												<a href="#" class="add-to-cart pull-right">+ 加入购物车</a>
											</div>
										</div>
									</div>
									
									<div class="product" data-product-id="7" data-category="women|women-swimwear|best|new" data-brand="brand5" data-price="150" data-colors="white|black|patternie" data-size="XS|S">
										<div class="entry-media">
											<img data-src="images/women/swimwear/116796-0001_1_t.jpg" alt="" class="lazyLoad thumb" />
											<div class="hover">
												<a href="good.html" class="entry-url"></a>
												<ul class="icons unstyled">
													<li>
														<div class="circle ribbon ribbon-new">New</div>
													</li>
													<li>
														<a href="images/women/swimwear/116796-0001_1.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
													</li>
													<li>
														<a href="#" class="circle add-to-cart"><i class="iconfont-shopping-cart"></i></a>
													</li>
												</ul>
												<div class="rate-bar">
													<input type="range" value="3.5" step="0.5" id="backing7" />
													<div class="rateit" data-rateit-backingfld="#backing7" data-rateit-starwidth="12" data-rateit-starheight="12" data-rateit-resetable="false"  data-rateit-ispreset="true" data-rateit-min="0" data-rateit-max="5"></div>
												</div>
											</div>
										</div>
										<div class="entry-main">
											<h5 class="entry-title">
												<a href="good.html">Inceptos orci hac libero</a>
											</h5>
											<div class="entry-description visible-list">
												<p>Sed ornare cras donec litora integer curabitur orci, at nullam aliquam libero nam himenaeos, amet massa amet ut ipsum viverra mauris rhoncus neque aenean rhoncus gravida orci facilisis quis dui consectetur.</p>
											</div>
											<div class="entry-price">
												<strong class="price">$ 150.00</strong>
												<a href="#" class="btn btn-round btn-default add-to-cart visible-list">Add to Cart</a>
											</div>
											<div class="entry-links clearfix">
												<a href="cart.jsp" class="pull-left m-r">+ 立即购买</a>
												<a href="#" class="add-to-cart pull-right">+ 加入购物车</a>
											</div>
										</div>
									</div>
									
									<div class="product" data-product-id="8" data-category="women|women-dresses|best" data-brand="brand4" data-price="350" data-colors="white|black" data-size="XS|S|L">
										<div class="entry-media">
											<img data-src="images/women/dress/278638-0083_1_t.jpg" alt="" class="lazyLoad thumb" />
											<div class="hover">
												<a href="good.html" class="entry-url"></a>
												<ul class="icons unstyled">
													<li>
														<a href="images/women/dress/278638-0083_1.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
													</li>
													<li>
														<a href="#" class="circle add-to-cart"><i class="iconfont-shopping-cart"></i></a>
													</li>
												</ul>
												<div class="rate-bar">
													<input type="range" value="5" step="0.5" id="backing8" />
													<div class="rateit" data-rateit-backingfld="#backing8" data-rateit-starwidth="12" data-rateit-starheight="12" data-rateit-resetable="false"  data-rateit-ispreset="true" data-rateit-min="0" data-rateit-max="5"></div>
												</div>
											</div>
										</div>
										<div class="entry-main">
											<h5 class="entry-title">
												<a href="good.html">Inceptos orci hac libero</a>
											</h5>
											<div class="entry-description visible-list">
												<p>Sed ornare cras donec litora integer curabitur orci, at nullam aliquam libero nam himenaeos, amet massa amet ut ipsum viverra mauris rhoncus neque aenean rhoncus gravida orci facilisis quis dui consectetur.</p>
											</div>
											<div class="entry-price">
												<strong class="price">$ 350.00</strong>
												<a href="#" class="btn btn-round btn-default add-to-cart visible-list">Add to Cart</a>
											</div>
											<div class="entry-links clearfix">
												<a href="cart.jsp" class="pull-left m-r">+ 立即购买</a>
												<a href="#" class="add-to-cart pull-right">+ 加入购物车</a>
											</div>
										</div>
									</div>
							
									<div class="product" data-product-id="9" data-category="men|men-accessories|men-jean|best|new" data-brand="brand5" data-price="850" data-colors="white|black" data-size="L|XL|XXL">
										<div class="entry-media">
											<img data-src="images/men/accessories/000095-0014_2_t.jpg" alt="" class="lazyLoad thumb" />
											<div class="hover">
												<a href="good.html" class="entry-url"></a>
												<ul class="icons unstyled">
													<li>
														<a href="images/men/accessories/000095-0014_2.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
													</li>
													<li>
														<a href="#" class="circle add-to-cart"><i class="iconfont-shopping-cart"></i></a>
													</li>
												</ul>
												<div class="rate-bar">
													<input type="range" value="5" step="0.5" id="backing9" />
													<div class="rateit" data-rateit-backingfld="#backing9" data-rateit-starwidth="12" data-rateit-starheight="12" data-rateit-resetable="false"  data-rateit-ispreset="true" data-rateit-min="0" data-rateit-max="5"></div>
												</div>
											</div>
										</div>
										<div class="entry-main">
											<h5 class="entry-title">
												<a href="good.html">Inceptos orci hac libero</a>
											</h5>
											<div class="entry-description visible-list">
												<p>Sed ornare cras donec litora integer curabitur orci, at nullam aliquam libero nam himenaeos, amet massa amet ut ipsum viverra mauris rhoncus neque aenean rhoncus gravida orci facilisis quis dui consectetur.</p>
											</div>
											<div class="entry-price">
												<strong class="price">$ 850.00</strong>
												<a href="#" class="btn btn-round btn-default add-to-cart visible-list">Add to Cart</a>
											</div>
											<div class="entry-links clearfix">
												<a href="cart.jsp" class="pull-left m-r">+ 立即购买</a>
												<a href="#" class="add-to-cart pull-right">+ 加入购物车</a>
											</div>
										</div>
									</div>
							
									<div class="product" data-product-id="10" data-category="women|women-basics|new" data-brand="brand1" data-price="550" data-colors="white|black|patternie" data-size="XS|S">
										<div class="entry-media">
											<img data-src="images/women/basic/848051-0014_1_t.jpg" alt="" class="lazyLoad thumb" />
											<div class="hover">
												<a href="good.html" class="entry-url"></a>
												<ul class="icons unstyled">
													<li>
														<a href="images/women/basic/848051-0014_1.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
													</li>
													<li>
														<a href="#" class="circle add-to-cart"><i class="iconfont-shopping-cart"></i></a>
													</li>
												</ul>
												<div class="rate-bar">
													<input type="range" value="3.5" step="0.5" id="backing10" />
													<div class="rateit" data-rateit-backingfld="#backing10" data-rateit-starwidth="12" data-rateit-starheight="12" data-rateit-resetable="false"  data-rateit-ispreset="true" data-rateit-min="0" data-rateit-max="5"></div>
												</div>
											</div>
										</div>
										<div class="entry-main">
											<h5 class="entry-title">
												<a href="good.html">Inceptos orci hac libero</a>
											</h5>
											<div class="entry-description visible-list">
												<p>Sed ornare cras donec litora integer curabitur orci, at nullam aliquam libero nam himenaeos, amet massa amet ut ipsum viverra mauris rhoncus neque aenean rhoncus gravida orci facilisis quis dui consectetur.</p>
											</div>
											<div class="entry-price">
												<strong class="price">$ 550.00</strong>
												<a href="#" class="btn btn-round btn-default add-to-cart visible-list">Add to Cart</a>
											</div>
											<div class="entry-links clearfix">
												<a href="cart.jsp" class="pull-left m-r">+ 立即购买</a>
												<a href="#" class="add-to-cart pull-right">+ 加入购物车</a>
											</div>
										</div>
									</div>
									
									<div class="product" data-product-id="11" data-category="women|women-basics|makeup" data-brand="brand3" data-price="700" data-colors="white|black|red|green|brown" data-size="XS|S">
										<div class="entry-media">
											<img data-src="images/women/basic/848099-0067_1_t.jpg" alt="" class="lazyLoad thumb" />
											<div class="hover">
												<a href="good.html" class="entry-url"></a>
												<ul class="icons unstyled">
													<li>
														<a href="images/women/basic/848099-0067_1.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
													</li>
													<li>
														<a href="#" class="circle add-to-cart"><i class="iconfont-shopping-cart"></i></a>
													</li>
												</ul>
												<div class="rate-bar">
													<input type="range" value="2.5" step="0.5" id="backing11" />
													<div class="rateit" data-rateit-backingfld="#backing11" data-rateit-starwidth="12" data-rateit-starheight="12" data-rateit-resetable="false"  data-rateit-ispreset="true" data-rateit-min="0" data-rateit-max="5"></div>
												</div>
											</div>
										</div>
										<div class="entry-main">
											<h5 class="entry-title">
												<a href="good.html">Inceptos orci hac libero</a>
											</h5>
											<div class="entry-description visible-list">
												<p>Sed ornare cras donec litora integer curabitur orci, at nullam aliquam libero nam himenaeos, amet massa amet ut ipsum viverra mauris rhoncus neque aenean rhoncus gravida orci facilisis quis dui consectetur.</p>
											</div>
											<div class="entry-price">
												<strong class="price">$ 700.00</strong>
												<a href="#" class="btn btn-round btn-default add-to-cart visible-list">Add to Cart</a>
											</div>
											<div class="entry-links clearfix">
												<a href="cart.jsp" class="pull-left m-r">+ 立即购买</a>
												<a href="#" class="add-to-cart pull-right">+ 加入购物车</a>
											</div>
										</div>
									</div>
								</div>
								<!-- // PRODUCT LAYOUT -->
							</section>
							
						</section>
					</div>
					
				</div>
			</div>
		</main>
		<!-- // SITE MAIN CONTENT -->
		
		<!-- 网站底部 -->
	<footer class="page-footer">
		<%@ include file="bottom.jsp"%>
	</footer>
	<!-- // 网站底部 -->
		
</div>
<!-- // PAGE WRAPPER -->

<!-- Essential Javascripts -->
<script src="js/minified.js"></script>
<!-- // Essential Javascripts -->

<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','../../../www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-27646173-3', 'themina.net');
  ga('send', 'pageview');

</script>
	<!-- Particular Page Javascripts -->
	<script src="js/jquery.nouislider.js"></script>
	<script src="js/jquery.isotope.min.js"></script>
	<script src="js/products.js"></script>
	<!-- // Particular Page Javascripts -->
</body>
</html>