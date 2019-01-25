<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
//获取当前项目的路径，如：http://localhost:8080/项目名称。
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"> 
  	<!-- 
  	base标记是一个基链接标记，是一个单标记。用以改变文件中所有链接标记的参数内定值，网页上的所有相对路径在链接时都将在前面加上基链接指向的地址。
  	比如:<base href="http://www.baidu.com">，那下面的href属性就会以上面设的为基准,
  	如:<a href="http://www.baidu.com/xxx.htm"></a>，现在就只需要写<a href="xxx.htm"></a>
  	 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>所有用户信息</title>
<style type="text/css">
	#t{
		text-align: center;
		
	}
	#td{
		height: 20px;
		width: 400px;
		text-align: center;
	}
</style>
</head>
<body>
	<table border="1" style="border-collapse: collapse;" name="t">
		<tr>
			<td id="td">管理员ID</td>
			<td id="td">用户名</td>
			<td id="td">密码</td>
			
		</tr>
		<c:forEach var="u" items="${requestScope.allusers}">
			<tr>
				<td id="td">${u.id}</td><!-- id为user的变量 -->
				<td id="td">${u.username}</td>
				<td id="td">${u.password}</td>
				
			</tr>
		</c:forEach>
	</table>

</body>
</html>