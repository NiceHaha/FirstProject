<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<%@ include file="/WEB-INF/jsp/admin/aa.jsp" %>
</head>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.2.4.js"></script>
<script type="text/javascript">
$(function bb() {
	$("#order").empty();
	$("button").attr('disabled');
	$.ajax({
		url:"<%=request.getContextPath()%>/qtorder",
					type : "GET",
					async : false,//改为同步，修改、删除操作才起作用，先运行Ajax，再运行点击事件，不然先运行点击操作，才会运行该Ajax。
					dataType : "json",//预期的服务器响应的数据类型,处理接收的返回数据
					data : {},
					success : function(datas) {//接收后台的返回数据,0/1。请求后台的servlet 中的方法后，响应回来的值，data就是这个值。然后根据dataType参数进行处理后的数据
						for (var i = 0; i < datas.length; i++) {
							if(datas[i].receiptStatus==1){
								datas[i].receiptStatus="已收货";
								/* datas[i].orderStatus="已收货无法取消订单" */
							}else{
								datas[i].receiptStatus="<button name='receiptStatus' id='"+datas[i].id +"'>确认收货<button>";
							}
							if(datas[i].orderStatus==1){
								datas[i].orderStatus="已取消";
							}else{
								datas[i].orderStatus="<button name='orderStatus' id='"+datas[i].id +"'>取消订单<button>"
							}
							$("#order").append("<tr><td>"+ datas[i].userCode
													+ "</td><td>"
													+ datas[i].orderDate
													+ "</td><td>"
													+ datas[i].shippingAddr
													+ "</td><td>"
													+ datas[i].receivingAddr
													+ "</td><td>"
													+ datas[i].receiver
													+ "</td><td>"
													+ datas[i].goodsName
													+ "</td><td>"
													+ datas[i].goodsNum
													+ "</td><td>"
													+ datas[i].goodsPrice
													+ "</td><td>"
													+ datas[i].receiptStatus
													+ "</td><td>"
													+ datas[i].orderStatus
													+ "</td><td>"
													+ datas[i].paymentStatus
													+ "</td><td>"
													+ datas[i].logisticsCode
													+ "</td><td>"
													+ datas[i].expressCode
													+ "</td><td>"
													+ datas[i].receiptTime
													+ "</td><td>"
													+ datas[i].payment
													+ "</td><td><a name='Delete' id='"+ datas[i].id + "'>删除</a>"+
													"<a href='<%=request.getContextPath()%>/order/"+ datas[i].id +"'>修改</a></td></tr>");
						}
					}
				});
		$("a[name='Delete']").click(function() {
			var id = $(this).attr("id");
			var tag = $(this).parent().parent();
			$.ajax({
				url:"<%=request.getContextPath()%>/order/"+id,
				type : "delete",
				async : false,//改为同步，修改、删除操作才起作用，先运行Ajax，再运行点击事件，不然先运行点击操作，才会运行该Ajax。
				dataType : "json",//预期的服务器响应的数据类型,处理接收的返回数据
				data : {},
				success : function(datas) {//接收后台的返回数据,0/1。请求后台的servlet 中的方法后，响应回来的值，data就是这个值。然后根据dataType参数进行处理后的数据
					if (datas = 1) {
						$(tag).remove();
					} else {
						alert("删除失败");
					}
				},
			});
		});
		
		$("button[name='orderStatus']").click(function() {
			var id = $(this).attr("id");
			$.ajax({
				url:"<%=request.getContextPath()%>/orderOrderStatusServlet",
				type : "post",
				async : false,//改为同步，修改、删除操作才起作用，先运行Ajax，再运行点击事件，不然先运行点击操作，才会运行该Ajax。
				dataType : "json",//预期的服务器响应的数据类型,处理接收的返回数据
				data : {
					"id" : id
				},
				success : function(datas) {//接收后台的返回数据,0/1。请求后台的servlet 中的方法后，响应回来的值，data就是这个值。然后根据dataType参数进行处理后的数据
					if(datas == '1'){
						$("#"+id+"").attr("disabled","true");
					}else if(datas=="3"){
						$("#"+id+"").attr("disabled","true");
						alert("已收货无法取消订单");
					}else{
						$("#"+id+"").removeAttr("disabled",false);
					}
				},
			});
		});
		
		$("button[name='receiptStatus']").click(function() {
			var id = $(this).attr("id");
			alert(id);
			$.ajax({
				url:"<%=request.getContextPath()%>/orderreceiptstatusservlet",
				type : "post",
				async : false,//改为同步，修改、删除操作才起作用，先运行Ajax，再运行点击事件，不然先运行点击操作，才会运行该Ajax。
				dataType : "json",//预期的服务器响应的数据类型,处理接收的返回数据
				data : {
					"id" : id
				},
				success : function(datas) {//接收后台的返回数据,0/1。请求后台的servlet 中的方法后，响应回来的值，data就是这个值。然后根据dataType参数进行处理后的数据
					if(datas == '1'){
						bb();
						$("button[name='orderStatus']").attr("disabled","true");
					}else{
						$("#"+id+"").removeAttr("disabled",false);
					}
				},
			});
		});
	});
	function test(){
		var locale=$("#url").val();
		window.location.href="as?locale="+locale;
	}
</script>
<body class="product-single">
	<div id="page-wrapper">
		<!-- 网站顶部 -->
		<header id="site-header" role="banner">
		</header>
		<!-- // 网站顶部 -->

		<!-- 导航路径 -->
		<div class="breadcrumb-container">
			<div class="container">
				<div class="relative">
					<ul class="bc unstyled clearfix">
						<li><a href="index.jsp">首页</a></li>
						<li class="active">订单</li>
						<form action="<%=request.getContextPath()%>/order/inset">
						<button>添加订单</button>
						</form>
					</ul>
				</div>
			</div>
		</div>
		<select onchange="test()" id="url">
			<option value="en_US" <c:if test="${locale eq 'en_US'}">selected</c:if> >英文</option>
			<option value="zh_CN" <c:if test="${locale eq 'zh_CN'}">selected</c:if> >中文</option>
		</select>
		<!-- // 导航路径 -->
		
		<!-- 主体内容 -->
		<main id="main-content" role="main">
		<div class="container">
			<body>
				<div class="data-div">
					<div class="row tableHeader">
						<!-- <div class="col-lg-1 ">用户</div> -->
						<div class="col-lg-1 "><fmt:message key="order.orderDate"></fmt:message></div>
						<div class="col-lg-1"><fmt:message key="order.shippingAddr"></fmt:message></div>
						<div class="col-lg-1"><fmt:message key="order.receivingAddr"></fmt:message></div>
						<div class="col-lg-1"><fmt:message key="order.receiver"></fmt:message></div>
						<div class="col-lg-1"><fmt:message key="order.goodsName"></fmt:message></div>
						<div class="col-lg-1"><fmt:message key="order.goodsNum"></fmt:message></div>
						<div class="col-lg-1"><fmt:message key="order.goodsPrice"></fmt:message></div>
						<div class="col-lg-1 "><fmt:message key="order.receiptStatus"></fmt:message></div>
						<div class="col-lg-1 "><fmt:message key="order.orderStatus"></fmt:message></div>
						<div class="col-lg-1"><fmt:message key="order.paymentStatus"></fmt:message></div>
						<div class="col-lg-1"><fmt:message key="order.logisticsCode"></fmt:message></div>
						<div class="col-lg-1 "><fmt:message key="order.expressCode"></fmt:message></div>
						<div class="col-lg-1"><fmt:message key="order.payment"></fmt:message></div>
						<div class="col-lg-2"><fmt:message key="order.operation"></fmt:message></div>
					</div>
					<div class="tablebody">
						<div class="sitTable">
							<table class="row table  table-responsive" id="order">
							</table>
						</div>
					</div>
				</div>

				<!-- 猜你喜欢 -->
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
				<!-- // 猜你喜欢 -->
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
		(function(i, s, o, g, r, a, m) {
			i['GoogleAnalyticsObject'] = r;
			i[r] = i[r] || function() {
				(i[r].q = i[r].q || []).push(arguments)
			}, i[r].l = 1 * new Date();
			a = s.createElement(o), m = s.getElementsByTagName(o)[0];
			a.async = 1;
			a.src = g;
			m.parentNode.insertBefore(a, m)
		})(window, document, 'script',
				'../../../www.google-analytics.com/analytics.js', 'ga');

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
		var disqus_shortname = 'gfashion'; // required: replace example with your forum shortname

		/* * * DON'T EDIT BELOW THIS LINE * * */
		(function() {
			var dsq = document.createElement('script');
			dsq.async = true;
			dsq.src = '//' + disqus_shortname + '.disqus.com/embed.js';
			(document.getElementsByTagName('head')[0] || document
					.getElementsByTagName('body')[0]).appendChild(dsq);
		})();
	</script>
	<!-- // Disqus -->

</body>
</html>