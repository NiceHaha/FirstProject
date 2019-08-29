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
	<!-- 单个商品页面 -->
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
	<link rel="stylesheet" href="css/owl.carousel.css">
	<link rel="stylesheet" href="css/owl.theme.css">
	<link rel="stylesheet" href="css/innerpage.css">
	<!-- // PARTICULAR PAGES CSS FILES -->
	<link rel="stylesheet" href="css/responsive.css">
</head>
<body class="product-single">
			
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
					<ul class="bc unstyled clearfix">
						<li><a href="index.jsp">首页</a></li>
						<li class="active">商品详情</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- // BREADCRUMB -->
		
		<!-- SITE MAIN CONTENT -->
		<main id="main-content" role="main">
					
			<section class="section">
				<div class="container">
					<div class="row">
						<!-- PRODUCT PREVIEW -->
						<div class="col-xs-12 col-sm-4">
							
							<div class="product-preview">
								<div class="big-image">
									<a href="images/women/skirt/103314-0735_1_o.jpg" data-toggle="lightbox">
										<img src="images/women/skirt/103314-0735_1_t.jpg" alt="" />
									</a>
								</div>
								<ul class="thumbs unstyled clearfix">
									<li><a href="images/women/skirt/103314-0735_1_o.jpg"><img src="images/women/skirt/103314-0735_1_t.jpg" alt="" /></a></li>
									<li><a href="images/women/skirt/103314-0735_2_o.jpg"><img src="images/women/skirt/103314-0735_2_t.jpg" alt="" /></a></li>
								</ul>
							</div>
							
						</div>
						<!-- // PRODUCT PREVIEW -->
						<div class="space40 visible-xs"></div>
						<!-- PRODUCT DETAILS -->
						<div class="col-xs-12 col-sm-8">
							<section class="product-details add-cart">
								<header class="entry-header">
									<h2 class="entry-title uppercase">Sexy Skirt</h2>
								</header>
								<article class="entry-content">
									<figure>
										<span class="entry-price inline-middle">$120</span>
										<div class="rate-bar inline-middle">
											<input type="range" value="4.5" step="0.5" id="backing0" />
											<div class="rateit" data-rateit-backingfld="#backing0" data-rateit-starwidth="12" data-rateit-starheight="12" data-rateit-resetable="false"  data-rateit-ispreset="true" data-rateit-min="0" data-rateit-max="5"></div>
										</div>
										<span class="entry-review-count inline-middle">( 2 条评论 )</span>
										
										<ul class="entry-meta unstyled">
											<li>
												<span class="key">品牌:</span>
												<span class="value">Versace</span>
											</li>
											<li>
												<span class="key">库存量:</span>
												<span class="value">In Stock</span>
											</li>
											<li>
												<span class="key">商品编号:</span>
												<span class="value">GF-123456</span>
											</li>
										</ul>
										
										<div class="clearfix"></div>
										
										<figcaption class="m-b-sm">
											<h5 class="subheader uppercase">服务承诺:</h5>
											<p>不支持七天无理由退换  正品保证  极速退款  增运费险</p>
										</figcaption>
										
										<div class="row">
											<div class="col-xs-12 col-sm-6">
												<h5 class="subheader uppercase">颜色:</h5>
												<div class="inline-middle styled-dd">
													<select>
														<option>-- 请 选 择 --</option>
														<option value="Black">黑色</option>
														<option value="Aubergine">白色</option>
													</select>
												</div>
											</div>
											<div class="space30 visible-xs"></div>
											<div class="col-xs-12 col-sm-6">
												<h5 class="subheader uppercase">尺码:</h5>
												<div class="inline-middle styled-dd">
													<select>
														<option>-- 请 选 择 --</option>
														<option value="xs">XS</option>
														<option value="s">S</option>
														<option value="m">M</option>
														<option value="l">L</option>
													</select>
												</div>
											</div>
										</div>
										
										<ul class="inline-li li-m-r-l m-t-lg">
											<li>
												<a href="cart.jsp" class="btn btn-default btn-lg btn-round">立即购买</a>
											</li>
											<li>
												<a href="#" class="add-to-cart">+ 加入购物车</a>
											</li>
										</ul>
										
									</figure>
								</article>
							</section>
						</div>
						<!-- // PRODUCT DETAILS -->
					</div>
					<div class="m-t-lg">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#product-description" data-toggle="tab">商品描述</a></li>
							<li><a href="#product-reviews" data-toggle="tab">商品评论</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane fade in active" id="product-description">
								<!-- 描述 -->
								<p>Ultricies et consectetur rhoncus lorem mattis, ligula interdum nibh dolor ipsum, venenatis ultrices sem nisl senectus phasellus lectus facilisis gravida curabitur interdum pretium et pellentesque nullam auctor vestibulum aenean ipsum placerat erat volutpat lectus mi est lacinia sociosqu, pretium habitasse aenean eros tristique augue a vivamus ac, sapien blandit nullam et neque curabitur varius nostra dui dictum cras orci congue.</p>
								<ul>
									<li>Sed ornare cras donec litora </li>
									<li>Integer curabitur orci </li>
									<li>At nullam aliquam libero nam himenaeos </li>
								</ul>
							</div>
							<div class="tab-pane fade in" id="product-reviews">
								<div class="comments-list">
									<div id="disqus_thread"></div>
									<!-- 评价 -->
									<noscript>Please enable JavaScript to view the <a href="http://disqus.com/?ref_noscript">comments powered by Disqus.</a></noscript>
									<a href="http://disqus.com/" class="dsq-brlink">comments powered by <span class="logo-disqus">Disqus</span></a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>

			<!-- FEATURED PRODUCTS -->
			<section class="section featured visible-items-4">
				<div class="container">
					<div class="row">
						<header class="section-header clearfix col-sm-offset-3 col-sm-6">
							<h3 class="section-title">猜 你 喜 欢</h3>
							<p class="section-teaser">从“森林、海洋与田野”中获取灵感，描绘了北欧优美的夏日风情。</p>
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
							
							<div class="owl-carousel owl-theme" data-visible-items="4" data-navigation="true" data-lazyload="true">
								<div class="product" data-product-id="1">
									<div class="entry-media">
										<img data-src="images/women/basic/848051-0014_1_t.jpg" alt="" class="lazyOwl thumb" />
										<div class="hover">
											<a href="product.html" class="entry-url"></a>
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
											<!-- 商品名字 -->
											<a href="#">商品名字</a>
										</h5>
										<div class="entry-price">
											<s class="entry-discount">$ 350.00</s>
											<strong class="accent-color price">$ 250.00</strong>
										</div>
										<div class="entry-links clearfix">
											<a href="cart.jsp" class="pull-left m-r">+ 立即购买</a>
											<a href="#" class=" add-to-cart pull-right">+ 加入购物车</a>
										</div>
									</div>
								</div>
								
								<div class="product" data-product-id="2">
									<div class="entry-media">
										<img data-src="images/women/basic/688086-0286_1_t.jpg" alt="" class="lazyOwl thumb" />
										<div class="hover">
											<a href="product.html" class="entry-url"></a>
											<ul class="icons unstyled">
												<li>
													<a href="images/women/basic/688086-0286_1.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
												</li>
												<li>
													<a href="#" class="circle add-to-cart" data-><i class="iconfont-shopping-cart"></i></a>
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
											<a href="#">商品名字</a>
										</h5>
										<div class="entry-price">
											<strong class="price">$ 350.00</strong>
										</div>
										<div class="entry-links clearfix">
											<a href="cart.jsp" class="pull-left m-r">+ 立即购买</a>
											<a href="#" class="add-to-cart pull-left">+ 加入购物车</a>
										</div>
									</div>
								</div>
								
								<div class="product" data-product-id="3">
									<div class="entry-media">
										<img data-src="images/women/basic/848099-0067_1_t.jpg" alt="" class="lazyOwl thumb" />
										<div class="hover">
											<a href="product.html" class="entry-url"></a>
											<ul class="icons unstyled">
												<li>
													<div class="circle ribbon ribbon-new">New</div>
												</li>
												<li>
													<a href="images/women/basic/848099-0067_1.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
												</li>
												<li>
													<a href="#" class="circle add-to-cart" data-><i class="iconfont-shopping-cart"></i></a>
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
											<a href="product.html" class="entry-url"></a>
											<ul class="icons unstyled">
												<li>
													<a href="images/women/basic/589550-0014_1.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
												</li>
												<li>
													<a href="#" class="circle add-to-cart" data-><i class="iconfont-shopping-cart"></i></a>
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
											<a href="product.html" class="entry-url"></a>
											<ul class="icons unstyled">
												<li>
													<div class="circle ribbon ribbon-sale">Sale</div>
												</li>
												<li>
													<a href="images/women/legging/104331-0014_1.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
												</li>
												<li>
													<a href="#" class="circle add-to-cart" data-><i class="iconfont-shopping-cart"></i></a>
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
											<a href="product.html" class="entry-url"></a>
											<ul class="icons unstyled">
												<li>
													<a href="images/women/legging/714384-0014_1.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
												</li>
												<li>
													<a href="#" class="circle add-to-cart" data-><i class="iconfont-shopping-cart"></i></a>
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
											<a href="product.html" class="entry-url"></a>
											<ul class="icons unstyled">
												<li>
													<div class="circle ribbon ribbon-new">New</div>
												</li>
												<li>
													<a href="images/women/dress/256479-0014_1.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
												</li>
												<li>
													<a href="#" class="circle add-to-cart" data-><i class="iconfont-shopping-cart"></i></a>
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
											<a href="product.html" class="entry-url"></a>
											<ul class="icons unstyled">
												<li>
													<a href="images/women/dress/278638-0083_1.jpg" class="circle" data-toggle="lightbox"><i class="iconfont-search"></i></a>
												</li>
												<li>
													<a href="#" class="circle add-to-cart" data-><i class="iconfont-shopping-cart"></i></a>
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
			<!-- // FEATURED PRODUCTS -->
			
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
	<script src="js/owl.carousel.js"></script>
	<script src="js/products.js"></script>
	<!-- // Particular Page Javascripts -->
	
	<!-- Disqus -->
	<script type="text/javascript">
	/* * * CONFIGURATION VARIABLES: EDIT BEFORE PASTING INTO YOUR WEBPAGE * * */
	var disqus_shortname = 'gfashion';		// required: replace example with your forum shortname

	/* * * DON'T EDIT BELOW THIS LINE * * */
	(function() {
		var dsq = document.createElement('script'); dsq.async = true;
		dsq.src = '//' + disqus_shortname + '.disqus.com/embed.js';
		(document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(dsq);
	})();
	</script>
	<!-- // Disqus -->
	
</body>
</html>