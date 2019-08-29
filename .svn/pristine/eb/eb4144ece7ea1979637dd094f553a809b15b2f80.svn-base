<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/admin/top.jsp"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
 	$(function() {
		$("#diss").hide();
			var pass = $("#sOrd").val();
			var pass1 = $("#sOrds").val();
			if(pass1 == ''){
				$("#submit").attr("disabled","disabled");
			}
		$("#sOrd").change(function() {
			var pass = $("#sOrd").val();
			var pass1 = $("#sOrds").val();
			if(pass1 != ''){
				if(pass1 != pass){
					$("#diss").show();
					$("#submit").attr("disabled","disabled");
				};
				if(pass1 == pass){
					$("#diss").hide();
					$("#submit").attr("disabled",false);
				};
			}
		})
	  $("#sOrds").change(function() {
			var pass = $("#sOrd").val();
			var pass1 = $("#sOrds").val();
			if(pass1 != pass){
				$("#diss").show();
				$("#submit").attr("disabled","disabled");
			}
			if(pass1 == pass){
				$("#diss").hide();
				$("#submit").attr("disabled",false);
			}
		})
	});
 	</script>
</head>
</html>