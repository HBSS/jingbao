<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
<title>管理员注册页面</title>
<script type="text/javascript">
</script>
</head>
<body>
	<form action="register" method="post">
		用户名:<input type="text" name="username" value="${param.username}"><br>
		密码:<input type="password" name="password" value="${param.password}"><br>
		确认密码:<input type="password" name="repassword" value="${param.repassword}" ><br>
		<br>
		<input type="submit" value="提交" >
		<input type="reset" value="重置">
	</form>
	<font color="red">
		<!--内置对象不需要声明，直接使用 -->
		<!-- EL表达式，null不会显示 -->
		${requestScope.msg}<!-- 相当于request.getAttribute("msg"); -->
	</font>
</body>
</html>