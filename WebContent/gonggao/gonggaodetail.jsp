<%@ page language="java" contentType="text/html; charset=utf-8"
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
	<table>
		<tr>
		
			<td>公告ID</td>
			<td>${requestScope.gonggao.gonggaoid}</td>
		</tr>
		
		<tr>
			<td>公告名称</td>
			<td>${requestScope.gonggao.gonggaoname}</td>
			</tr>
		
		<tr>
			<td>公告内容</td>
			<td>${requestScope.gonggao.gonggaocontent}</td>
		</tr>
		
	</table>
</body>
</html>