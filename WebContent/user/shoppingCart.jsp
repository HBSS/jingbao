<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>购物车界面</title>
	<style type="text/css">
	html,body{
		margin: 0;
		padding:0;
		height: 100%;
	}
	.container{
		min-height: 100%;
		height: auto !important;
		height: 100%;
		position: relative;
	}
	#top{
		height: 20px;
		width: auto;
		text-align: right;
		text-decoration: none;
		color: MistyRose;
	}
	
	#top a{
		text-decoration: none;
	}
	#top a:hover{
		color: blue;
	}
	#header{
		text-align:left;
		background: #ff0;
		padding: 10px;
		font-size: 30px;
		font-family:GungsuhChe ;
		font-weight: bolder;
		color: SaddleBrown;
	}
	
	#page{
		width: auto;
		margin: 0 auto;
		padding-bottom: 60px;
	}
	#footer{
		margin-top:10px;
		position:absolute;
		bottom: 0;
		width: 100%;
		height: 60px;
		background: #E6E6FA;
		clear: both;
		text-align: center;
	}
	#content{
		background: orange;
		float: left;
		width: 100%;
		margin-right: 20px;
		font-size: 20px;
		text-align: center;
		font-family: 方正舒体;
	}
	#td{
		height: 20px;
		width: 300px;
	}
	
</style>
</head>
<body>
<div class="container">
		<div id="top">
			<c:if test="${sessionScope.auser.username ==null }">
			<a href="user/login.jsp">请登录</a>&nbsp;&nbsp;&nbsp;
			</c:if>
			
			<c:if test="${sessionScope.auser.username !=null }">
				欢迎${sessionScope.auser.username}&nbsp;&nbsp;&nbsp;
			</c:if>
			<a href="index?action=select">回到首页</a>&nbsp;&nbsp;&nbsp;
			<a href="user/myjingbao.jsp">我的京宝</a>&nbsp;&nbsp;&nbsp;
			<a href="user/shoppingCart.jsp">购物车</a>&nbsp;&nbsp;&nbsp;
			<a href="save?action=select">收藏夹</a>&nbsp;&nbsp;&nbsp;
			<a href="">联系客服</a>
		<div id="header">
		我的购物车
		</div>
		<div id="page" class="clearfix" >
			
			
			<div id="content">
				<table border="1" style="border-collapse: collapse;" name="t">
		<tr>
			<td id="td">商品ID</td>
			<td id="td">商品名称</td>
			<td id="td">商品类型</td>
			<td id="td">商品图片</td>
			<td id="td">商品价格</td>
			<td id="td">购买数量</td>
			
		</tr>
		<c:forEach var="u" items="${requestScope.allusers}">
			<tr>
				<td id="td">${u.id}</td><!-- id为user的变量 -->
				<td id="td">${u.username}</td>
				<td id="td">${u.password}</td>
				
			</tr>
		</c:forEach>
	</table>
			</div>
			
		<div id="footer">
		<br>
			<a href="">倩倩中国站</a>&nbsp;|
			<a href="">白斓国际站</a>&nbsp;|
			<a href="">哈佬集团</a>&nbsp;|
			<a href="">全球速卖通</a>&nbsp;|
			<a href="">京宝网</a>&nbsp;|
			<a href="">京宝付</a>&nbsp;|
			<a href="">特划算</a>&nbsp;|
			<a href="">安武云计算</a>&nbsp;|
			<a href="">啥米</a>&nbsp;|
			<a href="">乱花呗</a>&nbsp;|
		</div>
	</div>
	</div>
</body>
</html>
