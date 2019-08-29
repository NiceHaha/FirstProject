<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>前台查询</title>
<!-- 引用jquery -->
<script type="text/javascript" src="admin/js/jquery.min.js"></script>

<script type="text/javascript">
	$(function(){
		$.ajax({
			url:" <%=request.getContextPath()%>/reportecho",
			type:"post",
			dataType:"json",
			async:false,
			success:function(a){
				for (var i = 0; i < a.length; i++) {
					$("#div").html("<p align='center'>"+a[i].article_title+"</p></br><p>"+a[i].article_text+"</p>"+
					"<a href='<%=request.getContextPath()%>/reportdisplay?id="+a[i].id+" '><button class='btn btn-success btn-xs' id = 'a' >举报文章</button></a>");
					/* alert(i); */
				}
				
			},
			error:function(XMLHttpRequest,textStatus,errorThrown){
				alert("系统内部错误，请联系管理员！！！")
			}
			
		});
	});
	
	
	
	
	
	/* $(function(){
		$("#a").click(function(){
			$("#div").hide();
			$("#a").hide();
		});
	}); */
	
	
</script>

	
</head>
<body>
	<!-- width 宽度  height 长度   -->
	<div id ="div" style="width:220px; height:1000px; border:1px solid #000 ">
		<!-- <p align="center">半唯物半唯心主义</p></br>
		<p>命运(运气，巧合之聚大成者): 我只是给你开了个头，你的选择我无法阻挡，你的人生你自己主宰。</br>
		如果有一天，你发现了进化论不正确，没关系!但不要信神，千万不要信神。</br>
		还是那句话，这世界真有鬼，那也是心魔在昭雪!</br>
		万物有灵，每一个灵魂都是美丽。所以，人们才会那样自恋。</br>
		我的心灵如此美丽，怎能经得起你这样百般羞辱 ?</br>
		我不相信进化论，也否定神造万物，我始终认为一切生命都是起源于大自然，是大自然界里面的各种物质成份发生的化学+物理反应，土里、水里、空气里、火里……各种物质分子的各种无巧不成书的各种分分合合，这就是为什么自然界一直有新物种不断诞生也有物种不断消亡的最根本原因，生命总会找到出路!不是吗?
		也就是说，关于生命起源，本人支持的是物理+化学起源学说。意识与物质共存，应该不分主次，不分先后，不分大小。所以，我是大自然信仰者，又是灵魂信仰者，我不是纯粹的唯物主义者，也不是纯粹的唯心主义者。很早以前，我就学习了父亲的理论体系，我将之称为“半唯物半唯心主义”。</br>
		爱是每一次缘分的化身，情是物质的分分合合。</p> -->
	</div>
	
	
	<!-- <input type="submit" value="举报文章" id = "input" /> -->
	
	<!-- <a href="jsp/project/report.jsp" id = "a">举报文章</a> -->
	
	<!-- jsp/project/report.jsp -->
	
	
	<!-- readonly="readonly"设置为只读，不可编辑  cols 宽度   rows 可见行数 -->
	<!-- <textarea id = "id" name="name" rows="8" cols="60" readonly="readonly "> -->
	
	
	
	
	<!-- 其实就是在文本框里绑定个失焦事件onblus，当方本框失焦后，得到文本框输入后的值，和后台交互再反回至前台，这里建议用ajax做 -->
	
	
</body>
</html>