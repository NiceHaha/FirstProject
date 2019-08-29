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
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/minified.css">
	<!-- // GENERAL CSS FILES -->
	
	<!--[if IE 8]>
		<script src="js/respond.min.js"></script>
		<script src="js/selectivizr-min.js"></script>
	<![endif]-->
	<!--
	<script src="js/jquery.min.js"></script>
	-->
	<script>window.jQuery || document.write('<script src="js/jquery.min.js"><\/script>');</script>
	<script src="<%=request.getContextPath()%>/js/modernizr.min.js"></script>	
	<!-- PARTICULAR PAGES CSS FILES -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/owl.carousel.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/owl.theme.css">
	
	<link href="<%=request.getContextPath()%>/css/flexslider.css" rel="stylesheet" />
	<!-- // PARTICULAR PAGES CSS FILES -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/responsive.css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/jquery-2.2.4.js"></script>
	<script type="text/javascript">
		
	</script>
</head>
<body class="home">
			
	<!-- PAGE WRAPPER -->
<div id="page-wrapper">

	<!-- 网站顶部 -->
	<header id="site-header" role="banner">
		<%@ include file="top.jsp"%>
	</header>
	<!-- // 网站顶部 -->
		
		<!-- HOME页面 -->
		<div id="home-slider">
			<div class="flexslider">
	<ul class="slides">
		<!-- 第一个轮播 -->
		<li>
			<!-- 图片 -->
			<img src="rev-slider/img/slides/Street-Fashion.jpg" alt="" />
			
			<!-- 内容 -->
			<div class="flex-caption h6 text-bold gfc uppercase animated"
			data-animation="fadeInLeftBig"
			data-x="800"
			data-y="110"
			data-speed="600"
			data-start="1200">本 周 新 品</div>
			
			<div class="flex-caption herotext text-bold gfc animated"
			data-animation="fadeInRightBig"
			data-x="580"
			data-y="140"
			data-speed="900"
			data-start="2000">春 季 时 尚</div>
			
			<div class="flex-caption h6 text-bold gfc text-center animated"
			data-animation="fadeInDown"
			data-x="639"
			data-y="260"
			data-speed="1600"
			data-start="2900">
				防 紫 外 线 针 织 茄 克<br/>
				<a href="goods.jsp" class="btn btn-primary uppercase">所有商品＞ ＞</a>
			</div>
			
		</li>
		
		<!-- 第二个轮播 -->
		<li style="background: #fa6f57;">
			<!-- 图片 -->
			<img src="img/transparent.png" alt="" />
			
			<div class="flex-caption super-giant gfc animated uppercase"
			data-animation="fadeInUp"
			data-x="center"
			data-y="60"
			data-speed="500"
			data-start="900">Sale</div>

			<div id="caption-left-round" class="flex-caption round gfc animated uppercase"
			data-animation="fadeInLeftBig"
			data-x="140"
			data-y="60"
			data-speed="600"
			data-start="1200"><div class="vmid"><span>换季<br/>清仓</span></div></div>

			<div class="flex-caption round gfc animated uppercase"
			data-animation="fadeInRightBig"
			data-x="925"
			data-y="60"
			data-speed="600"
			data-start="1200"><div class="vmid"><span>七折<br/>优惠</span></div></div>

			<div class="flex-caption h3 gfc animated uppercase"
			data-animation="fadeInDown"
			data-x="center"
			data-y="250"
			data-speed="400"
			data-start="1800"><strong class="text-bold">50个 </strong>新商品</div>

		</li>
		
		<!-- 第三个轮播 -->
		<li>
			<!-- THE MAIN IMAGE IN THE SLIDE -->
			<img src="rev-slider/img/slides/3303349658_cfaebb811f_o.jpg" alt="" />
			
			<div class="flex-caption herotext text-bold gfc bg-dark animated uppercase"
			data-animation="fadeInUpBig"
			data-x="760"
			data-y="60"
			data-speed="900"
			data-start="100">免运费</div>
			
			<div class="flex-caption h2 text-bold gfc bg-dark animated uppercase"
			data-animation="fadeInUpBig"
			data-x="797"
			data-y="175"
			data-speed="600"
			data-start="900">订购超过$ 200</div>
		</li>
	</ul>
</div>
<!-- 轮播效果 -->
<script>
	jQuery(function($) {
		var $slider = $('#home-slider > .flexslider');
		$slider.find('.flex-caption').each(function() {
			var $this = $(this);
			var configs = {
				left: $this.data('x'),
				top: $this.data('y'),
				speed: $this.data('speed') + 'ms',
				delay: $this.data('start') + 'ms'
			};
			if ( configs.left == 'center' && $this.width() !== 0 ) 
			{
				configs.left = ( $slider.width() - $this.width() ) / 2;
			}
			if ( configs.top == 'center' && $this.height() !== 0 ) 
			{
				configs.top = ( $slider.height() - $this.height() ) / 2;
			}
			
			$this.data('positions', configs);
			
			$this.css({
				'left': configs.left + 'px',
				'top': configs.top + 'px',
				'animation-duration': configs.speed,
				'animation-delay': configs.delay
			});
		});
		
		$(window).on('resize', function() {
			var wW = $(window).width(),
				zoom = ( wW >= 1170 ) ? 1 : wW / 1349;
			$('.flex-caption.gfc').css('zoom', zoom);
		});
		$(window).trigger('resize');
		
		
		
		$slider.imagesLoaded(function() {
			$slider.flexslider({
				animation: 'slide',
				easing: 'easeInQuad',
				slideshow: false,
				nextText: '<i class="iconfont-angle-right"></i>',
				prevText: '<i class="iconfont-angle-left"></i>',
				start: function() {
					flex_fix_pos(1);
				},
				before: function(slider) {
					// initial caption animation for next show
					$slider.find('.slides li .animation-done').each(function() {
						$(this).removeClass('animation-done');
						var animation = $(this).attr('data-animation');
						$(this).removeClass(animation);
					});
					
					flex_fix_pos(slider.animatingTo + 1);
				},
				after: function() {
					// run caption animation
					$slider.find('.flex-active-slide .animated').each(function() {
						var animation = $(this).attr('data-animation');
						$(this).addClass('animation-done').addClass(animation);
					});
				}
			});
		});
		
		
		function flex_fix_pos(i) {
			$slider.find('.slides > li:eq(' + i + ') .gfc').each(function() {
				var $this = $(this),
					pos = $(this).data('positions');
					
				if ( pos.left == 'center' )
				{
					pos.left = ( $slider.width() - $this.width() ) / 2;
					$this.css('left', pos.left + 'px');
					$this.data('positions', pos);
				}
				if ( pos.top == 'center' )
				{
					pos.top = ( $slider.height() - $this.height() ) / 2;
					$this.css('left', pos.top + 'px');
					$this.data('positions', pos);
				}
			});
		}
	});
</script>		</div>
		<!-- // HOMEPAGE SLIDER -->
		
		<!-- SITE MAIN CONTENT -->
		<main id="main-content" role="main">
			
			<!-- PROMO BOXES -->
			<section class="section promos">
				
			</section>
			<!-- // PROMO BOXES -->
			
			<!-- 女装 -->
			<section class="section featured visible-items-4">
				<div class="container">
					<div class="row">
						<header class="section-header clearfix col-sm-offset-3 col-sm-6">
							<h3 class="section-title">女 装</h3>
							<p class="section-teaser">2019春夏系列 色彩新美学 摩登新经典</p>
						</header>
						
						<div class="clearfix"></div>
						
						<!-- BEGIN CAROUSEL -->
						<div id="featured-products" class="add-cart" data-product=".product" data-thumbnail=".entry-media .thumb" data-title=".entry-title > a" data-url=".entry-title > a" data-price=".entry-price > .price">
						
							<div class="owl-controls clickable top">
								<div class="owl-buttons">
									<div class="owl-prev"><i class="iconfont-angle-left"></i></div>
									<div class="owl-next"><i class="iconfont-angle-right"></i></div>
								</div>
							</div>
							
							<!-- 第一个图片 -->
							<div class="owl-carousel owl-theme" data-visible-items="4" data-navigation="true" data-lazyload="true">
								<div class="product" data-product-id="1">
									<div class="entry-media">
										<img data-src="images/women/basic/848051-0014_1_t.jpg" alt="" class="lazyOwl thumb" />
										<div class="hover">
											<a href="good.jsp" class="entry-url"></a>
											<ul class="icons unstyled">
												<li>
													<div class="circle ribbon ribbon-sale">Sale</div>
												</li>
												<li>
													<a href="images/women/basic/848051-0014_1.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
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
											<a href="#">Inceptos orci hac libero</a>
										</h5>
										<div class="entry-price">
											<s class="entry-discount">$ 350.00</s>
											<strong class="accent-color price">$ 250.00</strong>
										</div>
										<div class="entry-links clearfix">
											<a href="cart.jsp" class="pull-left m-r">+ 立即购买</a>
											<a href="#" class="add-to-cart pull-right">+ 加入购物车</a>
										</div>
									</div>
								</div>
								
								<div class="product" data-product-id="2">
									<div class="entry-media">
										<img data-src="images/women/basic/688086-0286_1_t.jpg" alt="" class="lazyOwl thumb" />
										<div class="hover">
											<a href="good.jsp" class="entry-url"></a>
											<ul class="icons unstyled">
												<li>
													<a href="images/women/basic/688086-0286_1.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
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
											<a href="#">Inceptos orci hac libero</a>
										</h5>
										<div class="entry-price">
											<strong class="price">$ 350.00</strong>
										</div>
										<div class="entry-links clearfix">
											<a href="cart.jsp" class="pull-left m-r">+ 立即购买</a>
											<a href="#" class="add-to-cart pull-right">+ 加入购物车</a>
										</div>
									</div>
								</div>
								
								<div class="product" data-product-id="3">
									<div class="entry-media">
										<img data-src="images/women/basic/848099-0067_1_t.jpg" alt="" class="lazyOwl thumb" />
										<div class="hover">
											<a href="good.jsp" class="entry-url"></a>
											<ul class="icons unstyled">
												<li>
													<div class="circle ribbon ribbon-new">New</div>
												</li>
												<li>
													<a href="images/women/basic/848099-0067_1.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
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
											<a href="#">Inceptos orci hac libero</a>
										</h5>
										<div class="entry-price">
											<strong class="price">$ 450.00</strong>
										</div>
										<div class="entry-links clearfix">
											<a href="cart.jsp" class="pull-left m-r">+ 立即购买</a>
											<a href="#" class="add-to-cart pull-right">+ 加入购物车</a>
										</div>
									</div>
								</div>
								
								<div class="product" data-product-id="4">
									<div class="entry-media">
										<img data-src="images/women/basic/589550-0014_1_t.jpg" alt="" class="lazyOwl thumb" />
										<div class="hover">
											<a href="good.jsp" class="entry-url"></a>
											<ul class="icons unstyled">
												<li>
													<a href="images/women/basic/589550-0014_1.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
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
											<a href="#">Inceptos orci hac libero</a>
										</h5>
										<div class="entry-price">
											<strong class="price">$ 350.00</strong>
										</div>
										<div class="entry-links clearfix">
											<a href="cart.jsp" class="pull-left m-r">+ 立即购买</a>
											<a href="#" class="add-to-cart pull-right">+ 加入购物车</a>
										</div>
									</div>
								</div>
								
								<div class="product" data-product-id="5">
									<div class="entry-media">
										<img data-src="images/women/legging/104331-0014_1_t.jpg" alt="" class="lazyOwl thumb" />
										<div class="hover">
											<a href="good.jsp" class="entry-url"></a>
											<ul class="icons unstyled">
												<li>
													<div class="circle ribbon ribbon-sale">Sale</div>
												</li>
												<li>
													<a href="images/women/legging/104331-0014_1.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
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
											<a href="#">Inceptos orci hac libero</a>
										</h5>
										<div class="entry-price">
											<s class="entry-discount">$ 350.00</s>
											<strong class="accent-color price">$ 250.00</strong>
										</div>
										<div class="entry-links clearfix">
											<a href="cart.jsp" class="pull-left m-r">+ 立即购买</a>
											<a href="#" class="add-to-cart pull-right">+ 加入购物车</a>
										</div>
									</div>
								</div>
								
								<div class="product" data-product-id="6">
									<div class="entry-media">
										<img data-src="images/women/legging/714384-0014_1_t.jpg" alt="" class="lazyOwl thumb" />
										<div class="hover">
											<a href="good.jsp" class="entry-url"></a>
											<ul class="icons unstyled">
												<li>
													<a href="images/women/legging/714384-0014_1.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
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
											<a href="#">Inceptos orci hac libero</a>
										</h5>
										<div class="entry-price">
											<strong class="price">$ 350.00</strong>
										</div>
										<div class="entry-links clearfix">
											<a href="cart.jsp" class="pull-left m-r">+ 立即购买</a>
											<a href="#" class="add-to-cart pull-right">+ 加入购物车</a>
										</div>
									</div>
								</div>
								
								<div class="product" data-product-id="7">
									<div class="entry-media">
										<img data-src="images/women/dress/256479-0014_1_t.jpg" alt="" class="lazyOwl thumb" />
										<div class="hover">
											<a href="good.jsp" class="entry-url"></a>
											<ul class="icons unstyled">
												<li>
													<div class="circle ribbon ribbon-new">New</div>
												</li>
												<li>
													<a href="images/women/dress/256479-0014_1.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
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
											<a href="#">Inceptos orci hac libero</a>
										</h5>
										<div class="entry-price">
											<strong class="price">$ 450.00</strong>
										</div>
										<div class="entry-links clearfix">
											<a href="cart.jsp" class="pull-left m-r">+ 立即购买</a>
											<a href="#" class="add-to-cart pull-right">+ 加入购物车</a>
										</div>
									</div>
								</div>
								
								<div class="product" data-product-id="8">
									<div class="entry-media">
										<img data-src="images/women/dress/278638-0083_1_t.jpg" alt="" class="lazyOwl thumb" />
										<div class="hover">
											<a href="good.jsp" class="entry-url"></a>
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
											<a href="#">Inceptos orci hac libero</a>
										</h5>
										<div class="entry-price">
											<strong class="price">$ 350.00</strong>
										</div>
										<div class="entry-links clearfix">
											<a href="cart.jsp" class="pull-left m-r">+ 立即购买</a>
											<a href="#" class="add-to-cart pull-right">+ 加入购物车</a>
										</div>
									</div>
								</div>
							
							</div>
								
						</div>
						<!-- // END CAROUSEL -->
						
					</div>
				</div>
			</section>
			<!-- // 女装 -->
			
			<!-- 男装 -->
			<section class="section new-arrivals visible-items-5">
				<div class="container">
					<div class="row">
						<header class="section-header clearfix col-sm-offset-3 col-sm-6">
							<h3 class="section-title">男 装</h3>
							<p class="section-teaser">兼具利落剪裁与优质面料 助您打造考究的个性造型</p>
						</header>
						
						<div class="clearfix"></div>
						
						<!-- BEGIN CAROUSEL -->
						<div id="new-arrivals-products" class="add-cart" data-product=".product" data-thumbnail=".entry-media .thumb" data-title=".entry-title > a" data-url=".entry-title > a" data-price=".entry-price > .price">
						
							<div class="owl-controls clickable outside">
								<div class="owl-buttons">
									<div class="owl-prev"><i class="iconfont-angle-left"></i></div>
									<div class="owl-next"><i class="iconfont-angle-right"></i></div>
								</div>
							</div>
							
							<div class="owl-carousel owl-theme" data-visible-items="5" data-navigation="true" data-lazyload="true">
								<div class="product" data-product-id="9">
									<div class="entry-media">
										<img data-src="images/men/jacket/271865-0286_1_t.jpg" alt="" class="lazyOwl thumb" />
										<div class="hover">
											<a href="good.jsp" class="entry-url"></a>
											<ul class="icons unstyled">
												<li>
													<div class="circle ribbon ribbon-sale">Sale</div>
												</li>
												<li>
													<a href="images/men/jacket/271865-0286_1.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
												</li>
												<li>
													<a href="#" class="circle add-to-cart"><i class="iconfont-shopping-cart"></i></a>
												</li>
											</ul>
											<div class="rate-bar">
												<input type="range" value="4.5" step="0.5" id="backing9" />
												<div class="rateit" data-rateit-backingfld="#backing9" data-rateit-starwidth="12" data-rateit-starheight="12" data-rateit-resetable="false"  data-rateit-ispreset="true" data-rateit-min="0" data-rateit-max="5"></div>
											</div>
										</div>
									</div>
									<div class="entry-main">
										<h5 class="entry-title">
											<a href="#">Inceptos orci hac libero</a>
										</h5>
										<div class="entry-price">
											<s class="entry-discount">$ 350.00</s>
											<strong class="accent-color price">$ 250.00</strong>
										</div>
									</div>
								</div>
								
								<div class="product" data-product-id="10">
									<div class="entry-media">
										<img data-src="images/men/jacket/634082-0014_1_t.jpg" alt="" class="lazyOwl thumb" />
										<div class="hover">
											<a href="good.jsp" class="entry-url"></a>
											<ul class="icons unstyled">
												<li>
													<a href="images/men/jacket/634082-0014_1.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
												</li>
												<li>
													<a href="#" class="circle add-to-cart"><i class="iconfont-shopping-cart"></i></a>
												</li>
											</ul>
											<div class="rate-bar">
												<input type="range" value="4" step="0.5" id="backing10" />
												<div class="rateit" data-rateit-backingfld="#backing10" data-rateit-starwidth="12" data-rateit-starheight="12" data-rateit-resetable="false"  data-rateit-ispreset="true" data-rateit-min="0" data-rateit-max="5"></div>
											</div>
										</div>
									</div>
									<div class="entry-main">
										<h5 class="entry-title">
											<a href="#">Inceptos orci hac libero</a>
										</h5>
										<div class="entry-price">
											<strong class="price">$ 350.00</strong>
										</div>
									</div>
								</div>
								
								<div class="product" data-product-id="11">
									<div class="entry-media">
										<img data-src="images/men/jacket/217365-0014_1_t.jpg" alt="" class="lazyOwl thumb" />
										<div class="hover">
											<a href="good.jsp" class="entry-url"></a>
											<ul class="icons unstyled">
												<li>
													<div class="circle ribbon ribbon-new">New</div>
												</li>
												<li>
													<a href="images/men/jacket/217365-0014_1.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
												</li>
												<li>
													<a href="#" class="circle add-to-cart"><i class="iconfont-shopping-cart"></i></a>
												</li>
											</ul>
											<div class="rate-bar">
												<input type="range" value="3.5" step="0.5" id="backing11" />
												<div class="rateit" data-rateit-backingfld="#backing11" data-rateit-starwidth="12" data-rateit-starheight="12" data-rateit-resetable="false"  data-rateit-ispreset="true" data-rateit-min="0" data-rateit-max="5"></div>
											</div>
										</div>
									</div>
									<div class="entry-main">
										<h5 class="entry-title">
											<a href="#">Inceptos orci hac libero</a>
										</h5>
										<div class="entry-price">
											<strong class="price">$ 450.00</strong>
										</div>
									</div>
								</div>
								
								<div class="product" data-product-id="12">
									<div class="entry-media">
										<img data-src="images/men/blazer/105797-1056_1_t.jpg" alt="" class="lazyOwl thumb" />
										<div class="hover">
											<a href="good.jsp" class="entry-url"></a>
											<ul class="icons unstyled">
												<li>
													<a href="images/men/blazer/105797-1056_1.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
												</li>
												<li>
													<a href="#" class="circle add-to-cart"><i class="iconfont-shopping-cart"></i></a>
												</li>
											</ul>
											<div class="rate-bar">
												<input type="range" value="5" step="0.5" id="backing12" />
												<div class="rateit" data-rateit-backingfld="#backing12" data-rateit-starwidth="12" data-rateit-starheight="12" data-rateit-resetable="false"  data-rateit-ispreset="true" data-rateit-min="0" data-rateit-max="5"></div>
											</div>
										</div>
									</div>
									<div class="entry-main">
										<h5 class="entry-title">
											<a href="#">Inceptos orci hac libero</a>
										</h5>
										<div class="entry-price">
											<strong class="price">$ 350.00</strong>
										</div>
									</div>
								</div>
								
								<div class="product" data-product-id="13">
									<div class="entry-media">
										<img data-src="images/men/jumper/271866-0014_1_t.jpg" alt="" class="lazyOwl thumb" />
										<div class="hover">
											<a href="good.jsp" class="entry-url"></a>
											<ul class="icons unstyled">
												<li>
													<div class="circle ribbon ribbon-sale">Sale</div>
												</li>
												<li>
													<a href="images/men/jumper/271866-0014_1.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
												</li>
												<li>
													<a href="#" class="circle add-to-cart"><i class="iconfont-shopping-cart"></i></a>
												</li>
											</ul>
											<div class="rate-bar">
												<input type="range" value="4.5" step="0.5" id="backing13" />
												<div class="rateit" data-rateit-backingfld="#backing13" data-rateit-starwidth="12" data-rateit-starheight="12" data-rateit-resetable="false"  data-rateit-ispreset="true" data-rateit-min="0" data-rateit-max="5"></div>
											</div>
										</div>
									</div>
									<div class="entry-main">
										<h5 class="entry-title">
											<a href="#">Inceptos orci hac libero</a>
										</h5>
										<div class="entry-price">
											<s class="entry-discount">$ 350.00</s>
											<strong class="accent-color price">$ 250.00</strong>
										</div>
									</div>
								</div>
								
								<div class="product" data-product-id="14">
									<div class="entry-media">
										<img data-src="images/men/shirt/803500-6989_1_t.jpg" alt="" class="lazyOwl thumb" />
										<div class="hover">
											<a href="good.jsp" class="entry-url"></a>
											<ul class="icons unstyled">
												<li>
													<a href="images/men/shirt/803500-6989_1.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
												</li>
												<li>
													<a href="#" class="circle add-to-cart"><i class="iconfont-shopping-cart"></i></a>
												</li>
											</ul>
											<div class="rate-bar">
												<input type="range" value="4" step="0.5" id="backing14" />
												<div class="rateit" data-rateit-backingfld="#backing14" data-rateit-starwidth="12" data-rateit-starheight="12" data-rateit-resetable="false"  data-rateit-ispreset="true" data-rateit-min="0" data-rateit-max="5"></div>
											</div>
										</div>
									</div>
									<div class="entry-main">
										<h5 class="entry-title">
											<a href="#">Inceptos orci hac libero</a>
										</h5>
										<div class="entry-price">
											<strong class="price">$ 350.00</strong>
										</div>
									</div>
								</div>
								
								<div class="product" data-product-id="15">
									<div class="entry-media">
										<img data-src="images/men/shirt/217360-0014_1_t.jpg" alt="" class="lazyOwl thumb" />
										<div class="hover">
											<a href="good.jsp" class="entry-url"></a>
											<ul class="icons unstyled">
												<li>
													<div class="circle ribbon ribbon-new">New</div>
												</li>
												<li>
													<a href="images/men/shirt/217360-0014_1.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
												</li>
												<li>
													<a href="#" class="circle add-to-cart"><i class="iconfont-shopping-cart"></i></a>
												</li>
											</ul>
											<div class="rate-bar">
												<input type="range" value="3.5" step="0.5" id="backing15" />
												<div class="rateit" data-rateit-backingfld="#backing15" data-rateit-starwidth="12" data-rateit-starheight="12" data-rateit-resetable="false"  data-rateit-ispreset="true" data-rateit-min="0" data-rateit-max="5"></div>
											</div>
										</div>
									</div>
									<div class="entry-main">
										<h5 class="entry-title">
											<a href="#">Inceptos orci hac libero</a>
										</h5>
										<div class="entry-price">
											<strong class="price">$ 450.00</strong>
										</div>
									</div>
								</div>
								
								<div class="product" data-product-id="16">
									<div class="entry-media">
										<img data-src="images/men/accessories/000095-0014_2_t.jpg" alt="" class="lazyOwl thumb" />
										<div class="hover">
											<a href="good.jsp" class="entry-url"></a>
											<ul class="icons unstyled">
												<li>
													<a href="images/men/accessories/000095-0014_2.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
												</li>
												<li>
													<a href="#" class="circle add-to-cart"><i class="iconfont-shopping-cart"></i></a>
												</li>
											</ul>
											<div class="rate-bar">
												<input type="range" value="5" step="0.5" id="backing16" />
												<div class="rateit" data-rateit-backingfld="#backing16" data-rateit-starwidth="12" data-rateit-starheight="12" data-rateit-resetable="false"  data-rateit-ispreset="true" data-rateit-min="0" data-rateit-max="5"></div>
											</div>
										</div>
									</div>
									<div class="entry-main">
										<h5 class="entry-title">
											<a href="#">Inceptos orci hac libero</a>
										</h5>
										<div class="entry-price">
											<strong class="price">$ 350.00</strong>
										</div>
									</div>
								</div>
							</div>
							
						</div>
						<!-- // END CAROUSEL -->
						
					</div>
				</div>
			</section>
			<!-- // 男装 -->
			
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
	<script src="js/owl.carousel.js"></script>
	<script src="js/jquery.flexslider-min.js"></script>
	<!-- // Particular Page Javascripts -->
</body>
</html>