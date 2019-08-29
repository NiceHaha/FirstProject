<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="左右结构项目，属于大人员的社交工具">
<meta name="keywords" content="左右结构项目 社交 占座 ">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/common.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/slide.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/flat-ui.min.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery.nouislider.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/minified.css">

<script type="text/javascript" src ="<%=request.getContextPath()%>/js/jquery-1.8.3.min.js"></script>

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

	function changeLanguage(){
		var language = $("#language").val();
		window.location.href="<%=request.getContextPath() %>/materialHandler/change?locale="+language; 
	}

</script>