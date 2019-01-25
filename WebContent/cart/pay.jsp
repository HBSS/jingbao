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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>购物车</title>

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
		height: 100px;
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
		background: NavajoWhite;
		float: left;
		width: 100%;
		margin-right: 20px;
		font-size: 20px;
		text-align: center;
		font-family: 方正舒体;
		height: 600px;
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
			<a href="cart?action=select">购物车</a>&nbsp;&nbsp;&nbsp;
			<a href="save?action=select">收藏夹</a>&nbsp;&nbsp;&nbsp;
			<a href="">联系客服</a>
		<div id="header">
		<br>
		确认支付
		</div>
		<div id="page" class="clearfix" >
			
			
			<div id="content">
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br><br><br><br><br><br><br>
			<a style="height: 50px;width: 100px;font-size: 30px;" href="order?action=pay&&orderid=${requestScope.orderid}">确认付款</a>
			<a style="height: 50px;width: 100px;font-size: 30px;" href="order?action=cancel&&orderid=${requestScope.orderid}">取消支付</a>
			<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
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
	</div>
	</div>
</body>
</html>