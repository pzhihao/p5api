<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工信息</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".delete").click(function(){
			var lastName=$(this).next(":input").val();
			var flag = confirm("确定要删除"+lastName+"的信息吗?");
			if(flag){

				var $tr=$(this).parent().parent();
				//删除员工信息
				var url =this.href;
				var args={"time":new Date()};
				$.post(url,args,function(data){
					if (data == "1") {
						alert("删除成功");
						$tr.remove();
					} else {
						alert("删除失败");
					}
				});
			}
			return false;
		});
	});
</script>
</head>
<body>
	<h4>员工信息页面</h4>
	<s:if test="%{#request.employees == null||#request.employees.size() == 0}">
		没有任何员工信息
		
	</s:if>
	<s:else>
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<td>ID</td>
				<td>LAST_NAME</td>
				<td>EMAIL</td>
				<td>BIRTH</td>
				<td>CREATETIME</td>
				<td>DEPT</td>
				<td>DELETE</td>
			</tr>
			<s:iterator value="#request.employees">
			
				<tr>
					<td>${id}</td>
					<td>${lastName}</td>
					<td>${email}</td>
					<td>${birth}</td>
					<td>${createTime}</td>
					<td>${department.departmentName}</td>
					<td><a href="emp-delete?id=${id}" class="delete">删除</a>
						<input type="hidden" value="${lastName}"> 
					</td>
				</tr>
			</s:iterator>
			
		</table>
	</s:else>
</body>
</html>