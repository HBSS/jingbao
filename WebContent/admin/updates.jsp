<%@ page language="java" import="com.jingbao.dao.BaseDao" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改单个用户</title>
</head>
<body>
	<form action="alluser1?action=updates" method="post" >
	<table>
		<tr>
		
			<td>用户ID</td>
			<td><input type="text" name="id" value="${requestScope.user.id }" readonly></td><!-- 产生商品ID -->
			
		</tr>
		
		<tr>
			<td>用户名</td>
			<td><input type="text" name="username" value="${ requestScope.user.username}"></td>
		</tr>
		<tr>
			<td>用户密码</td>
			<td><input type="text" name="password" value="${requestScope.user.password}"></td>
		</tr>
		<tr>
			<td>密保问题</td>
			<td><input type="text" name="question" value="${requestScope.user.question}"></td>
		</tr>
		<tr>
			<td>密保问题答案</td>
			<td><input type="text" name="questionan" value="${requestScope.user.questionan}"></td>
		</tr>
		<tr>
			<td>真实姓名</td>
			<td><input type="text" name="realname" value="${requestScope.user.realname}"></td>
		</tr>
		<tr>
			<td>身份证号</td>
			<td><input type="text" name="idnumber" value="${requestScope.user.idnumber}"></td>
		</tr>
		
		<tr>
			<td>邮编</td>
			<td><input type="text" name="post" value="${requestScope.user.post}"></td>
		</tr>
		<tr>
			<td>地址</td>
			<td><input type="text" name="address" value="${requestScope.user.address}"></td>
		</tr>
		<tr>
			<td>电话</td>
			<td><input type="text" name="phone" value="${requestScope.user.phone}"></td>
		</tr>
		<tr>
			<td><input type="submit" value="提交" ></td>
			<td><input type="reset" value="重置" ></td>
		</tr>
	</table>
		
	</form>
</body>
</html>