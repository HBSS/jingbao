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
<title>商品详情</title>
</head>
<body>
	<table>
		<tr>
		
			<td>商品ID：</td>
			<td>${requestScope.goods.goodsid}</td>
		</tr>
		
		<tr>
			<td>商品名称：</td>
			<td>${requestScope.goods.goodsname}</td>
			</tr>
		<tr>
			<td>商品类型：</td>
			<td>${requestScope.goods.typename}
			</td>
		</tr>
		<tr>
			<td>商品价格：</td>
			<td>${requestScope.goods.goodsprice}</td>
		</tr>
		<tr>
			<td>商品库存：</td>
			<td>${requestScope.goods.left}</td>
		</tr>
		<tr>
			<td>商品描述：</td>
			<td>${requestScope.goods.description}</td>
		</tr>
		<tr>
			<td>商品图片：</td>
			<td><img src="uploadFiles/${requestScope.goods.goodspicture }" width="50" height="50" ></td>
		</tr>
	</table>
</body>
</html>