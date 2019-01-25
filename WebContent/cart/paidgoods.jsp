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
<title>购买到的商品</title>

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
	
	#content{
		background: #FFD700;
		float: left;
		width: 100%;
		margin-right: 20px;
		font-size: 20px;
		text-align: center;
		font-family: 方正舒体;
		color: SaddleBrown;
	}
	#td{
		height: 20px;
		width: 300px;
	}
	.t{
	text-align: center;
	width: 320px;
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
		购买到的商品
		</div>
		<div id="page" class="clearfix" >
			
			
			<div id="content">
			<table border="1"  style="border-collapse: collapse;">
	
		<tr>
		
			<th class="t">商品名称</th>
			<th class="t">商品图片</th>
			<th class="t">商品单价</th>
			<th class="t">商品数量</th>
			<th class="t">商品小计</th>

		</tr>
		<c:forEach var="ct" items="${requestScope.odt1}" >
			<tr>
				
				<td>${ct.goodsname}</td>
				<td>
					<img src="uploadFiles/${ct.goodspicture}" width="50" height="50"/>
				</td>
				<td align="right">${ct.goodsprice}</td>
				<td align="right">${ct.left}</td>
				<td align="right">${ct.smallsum}</td>
			</tr>
			
			<tr ><td colspan="5">商品总价：${ct.totol}</td></tr>
			
		</c:forEach>
		
		
		
	</table>
		
	</div>
	</div>
	</div>
	</div>
</body>
</html>