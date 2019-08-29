<%@ page language="java" contentType="text/html; charset=utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/nav.css">
	<!-- /foreground/jsp/csrChat/Navigation/css -->
	<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
	<style type="text/css">
		body{
			padding:0;
			margin:0;
			background: #f2f2f2;
		}
		.wrap .line{
			height: 500px;
			width: 188px;
			margin:0 auto;
		}
	</style>
		<div class="leftNav-item">
		<ul>
			<li>
				<i class="fa fa-location-arrow"></i>
				<a href="javascript:void(0)" class="rota">首页</a>
			</li>
			<li title="在线客服">
				<i class="fa fa-comments-o"></i>
				<a href="javascript:void(0)"class="rota">在线客服</a>
			</li> 
			<li lay-data="img" data-fooc="<%=request.getContextPath()%>/wx.png">
				<i class="fa fa-money"></i><a href="javascript:;" class="rota">小额打赏</a>
			</li> 
			<li title="返回顶部" class="for-top">
				<i class="fa fa-arrow-up"></i>
				<a href="javascript:;" class="rota">去顶部</a>
			</li>
		</ul>
	</div>
	<script src="/admin/js/jquery-2.2.4.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/nav.js"></script>
