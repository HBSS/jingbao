<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改用户界面</title>
<script type="text/javascript">
</script>
<style type="text/css">
.t{
	height: 30px;
}
</style>
</head>
<body>
	<table>
		<tr>
			<th class="t">用户ID</th>
			<th class="t">用户名</th>
			<th class="t">密码</th>
			<th class="t">密保问题</th>
			<th class="t">密保问题答案</th>
			<th class="t">真实姓名</th>
			<th class="t">身份证号</th>
			<th class="t">邮编</th>
			<th class="t">地址</th>
			<th class="t">电话</th>
			<th class="t">邮箱</th>
			<th class="t">操作</th>
		</tr>
		<c:forEach var="u1" items="${requestScope.allusers }">
			<tr>
				<td class="t">${u1.id}</td><!-- id为user类的变量 -->
				<td class="t">${u1.username}</td>
				<td class="t">${u1.password}</td>
				<td class="t">${u1.question}</td>
				<td class="t">${u1.questionan}</td>
				<td class="t">${u1.realname}</td>
				<td class="t">${u1.idnumber}</td>
				<td class="t">${u1.post}</td>
				<td class="t">${u1.address}</td>
				<td class="t">${u1.phone}</td>
				<td class="t">${u1.email}</td>
				
				<td class="t">
					<a href="alluser1?action=details&&id=${u1.id}&&flag=updates">修改</a>
					
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="11" class="t">
				<!-- 分页对应的servlet -->
				<jsp:include page="page.jsp">
					<jsp:param value="alluser1?action=select" name="objectSelect"/>
				</jsp:include>
				<!-- 为了page页面方便使用，这里的参数value必须有?传参数，如果没有值可传，可任意传，如?a=a -->
			</td>
		</tr>
	</table>

</body>
</html>