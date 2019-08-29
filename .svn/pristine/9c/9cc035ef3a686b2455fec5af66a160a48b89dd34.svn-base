<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ include file="/WEB-INF/jsp/admin/top.jsp"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
$(function(){
	query();
	var empName = "";
	$("#home").click(function() {
		query(empName,1);
	}),
		
	$("#upper").click(function() {
		query(empName,parseInt($("#pageNow").val()) - 1);
	}),
	
	$("#lower").click(function() {
		query(empName,parseInt($("#pageNow").val()) + 1);
	}),
	
	$("#tail").click(function() {
		query(empName,$("#pageCount").val());
	}),
	
	$("#query").click(function() {
		empName = $("#empName").val();
		query(empName);
	})
});
function query(empName,pageNow) {
	$.ajax({
		url:"<%=request.getContextPath()%>/empController/emps",
		type:"get",
		dataType:"json",
		async:false,
		data:{"empName":empName,
				"pageNow":pageNow,
				"pageSize":1
		},
		success:function(obj){
			
			$("#pageNow").val(obj.pageEntity.pageNow);
			$("#pageCount").val(obj.pageEntity.pageCount);
			$("#empList").empty();
			for(var i=0;i<obj.list.length;i++){
				if(obj.list[i].sex == '1'){
					var sex = '男';
				}else{
					var sex = '女';
				}
				if(obj.list[i].state = '1'){
					var state = '在职';
				}else{
					var state = '离职';
				}
				if(obj.list[i].age =='0'){
					var age ='保密';
				}else{
					var age = obj.list[i].age;
				}
				if($("#pageNow").val() <= 1){
					$("#upper").attr("disabled","disabled");
				}else{
					$("#upper").attr("disabled",false);
				};
				if($("#pageNow").val() >= $("#pageCount").val()){
					$("#lower").attr("disabled","disabled");
				}else{
					$("#lower").attr("disabled",false);
				};
				$("#empList").append(
						"<tr>"+
		                   "<td style='line-height:70px;'>"+obj.list[i].empCode+"</td>"+
		                   "<td>"+obj.list[i].name+"</td>"+
		                   "<td>"+sex+"</td>"+
		                   "<td>"+age+"</td>"+
		                   "<td>"+obj.list[i].tel+"</td>"+
		                   "<td>"+obj.list[i].addr+"</td>"+
		                   "<td>"+obj.list[i].position+"</td>"+
		                   "<td>"+state+"</td>"+
		                   "<td>"+obj.list[i].depaName+"</td>"+
		                   "<td>"+obj.list[i].account+"</td>"+
		                   "<td>"+obj.list[i].password+"</td>"+
		                   "<td class='padding-right:27px'>"+
			                  "<a href='<%=request.getContextPath()%>/empController/empPut/"+obj.list[i].id+"'><button class='btn btn-success btn-xs' data-toggle='modal'><fmt:message key='project.update'></fmt:message></button></a>"+
			                  "<a href='' name='deleteName' id='"+obj.list[i].id+"'><button class='btn btn-danger btn-xs' data-toggle='modal'><fmt:message key='project.delete'></fmt:message></button></a>"+ 
							"</td>"+
		                "</tr>"
				);
			}
		},
		error:function(XMLHttpRequest,textStatus,errorThrown){
			alert("系统内部错误，请联系管理员！！！")
		}
	});
	$("a[name=deleteName]").click(function(){
		//this代表删除这个超链接 parent td parent.parent tr
		//$(this).parent().parent().find("td")查找td,
			var id = $(this).parent().parent();
			var cc = $(this).attr("id");
		$.ajax({
			url:"<%=request.getContextPath()%>/empController/emp/"+cc,
			type:"DELETE",
			datatype:"json",
			data:{
				id:cc
			},
			success:function(aa){
				if(aa.emp == '1'){
					id.remove();
				}
			}
		});
	});
}
/* function test()
{
	var language = $("#language").val();
	window.location.href="empList?locale="+language;
} */
</script>
<%-- <%@ include file="../../cssAll.jsp"%> --%>
</head>
<body>
	<div id="rightContent">
		<a class="toggle-btn" id="nimei"> <i
			class="glyphicon glyphicon-align-justify"></i>
		</a>
	<div class="check-div form-inline">
		<div class="col-xs-3">
			<a href="<%=request.getContextPath()%>/empReciewController/empRecorPost"><button class="btn btn-yellow btn-xs" data-toggle="modal"
				data-target="#addEmp"><fmt:message key="addEmp"></fmt:message></button></a>
			<a href="<%=request.getContextPath()%>/empReciewController/empReciewsList">
				<button class="btn btn-yellow btn-xs" data-toggle="modal"><fmt:message key="emptoExamine"></fmt:message></button>
			</a>
		</div>
		<div class="col-xs-4">
			<input type="text" class="form-control input-sm" placeholder="输入文字搜索" id = "empName">
			<button class="btn btn-white btn-xs " id="query"><fmt:message key="query"></fmt:message></button>
		</div>
		<%-- <div class="col-xs-5">
			<fmt:message key="language"></fmt:message>
			<select onchange="test()" id="language">
				<option value="zh_CN" <c:if test="${locale=='zh_CN'}">selected</c:if>><fmt:message key="Chinese"></fmt:message></option>
				<option value="en_US" <c:if test="${locale=='en_US'}">selected</c:if>><fmt:message key="English"></fmt:message></option>
				<option value="tt_RU" <c:if test="${locale=='tt_RU'}">selected</c:if>>俄语</option>
			</select>	
		</div> --%>
	</div>
	<div class="tablebody">
       <div class="sitTable">
           <table class="row table  table-responsive">
                <tr>
                   <td style="line-height:70px;"><fmt:message key="empReciew.code"></fmt:message></td>
                   <td><fmt:message key="empReciew.name"></fmt:message></td>
                   <td><fmt:message key="empReciew.sex"></fmt:message></td>
                   <td><fmt:message key="empReciew.age"></fmt:message></td>
                   <td><fmt:message key="empReciew.telephone"></fmt:message></td>
                   <td><fmt:message key="empReciew.addr"></fmt:message></td>
                   <td><fmt:message key="empReciew.position"></fmt:message></td>
                   <td><fmt:message key="empReciew.state"></fmt:message></td>
                   <td><fmt:message key="depaName"></fmt:message></td>
                   <td><fmt:message key="empReciew.accountnumber"></fmt:message></td>
                   <td><fmt:message key="empReciew.password"></fmt:message></td>
                   <td><fmt:message key="operation"></fmt:message></td>
                </tr>
         </table>
           <table class="row table  table-responsive" id="empList">
                
         </table>
      </div>
   </div>
	</div>
	
	
	
	
	
	
	
	
	
	<!--页码块->
					<!--分页 -->
	<footer class="footer">
		<%@ include file="../../footer.jsp"%>
	</footer>
	<%--
	<<!--修改 -->
	<footer class="footer">
		<%@ include file="userUpdate.jsp"%> 
	</footer>--%>
	<!-- /.modal -->
	<%-- <!-- 删除 -->
	<footer class="footer">
		<%@ include file="userDelete.jsp"%>
	</footer>  --%>
	<!-- /.modal -->
</body>
</html>