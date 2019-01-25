<%@ page language="java" import="com.jingbao.dao.BaseDao" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%
String path = request.getContextPath();
//获取当前项目的路径，如：http://localhost:8080/项目名称。
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="gonggao?action=add" method="post"><!-- 上传表单用 -->
	<table>
		<tr>
		
			<td>公告ID</td>
			<td><input type="text" name="gonggaoid" value="<%=BaseDao.getStringID() %>" readonly></td><!-- 产生商品ID -->
			
		</tr>
		
		<tr>
			<td>公告名称</td>
			<td><input type="text" name="gonggaoname" ></td>
		</tr>
		
		<tr>
		<td>公告内容</td>
		<td><input type="text" name="gonggaocontent"></td>
		</tr>
		
<tr>
			<td><input type="submit" value="提交" ></td>
			<td><input type="reset" value="重置" ></td>
		</tr>
	</table>
		
	</form>
</body>
</html>