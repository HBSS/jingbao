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
<title>确认订单</title>

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
		margin-right: 20px;
		font-size: 20px;
		text-align: center;
		font-family: 方正舒体;
		color: Sienna;
	}
	#td{
		height: 20px;
		width: 300px;
	}
	.t{
	width: 330px;
	text-align: center;
	}
	
</style>
<script type="text/javascript">
	function pay1(){
		document.pay1.submit();
	}
</script>
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
		确认订单
		</div>
		
			<div id="content">
			<h2>订单信息</h2>
			<h3>订单号${requestScope.orderid}</h3>
			
			
			<form action="order?action=beforpay&&orderid=${requestScope.orderid}" method="post" name="pay1">
	
			
		<p style="color: red;">
		收货人姓名:${requestScope.auser1.realname}<br>
		收货人地址:${requestScope.auser1.address}<br>
		收货人电话:${requestScope.auser1.phone}
		
		
		
		
		
		
		</p>

		<table border="1"  style="border-collapse: collapse;">
		<tr>
			<th class="t">商品名称</th>
			<th class="t">商品图片</th>
			<th class="t">商品单价</th>
			<th class="t">商品数量</th>
			<th class="t">商品小计</th>
		</tr>
		<c:forEach var="ot" items="${requestScope.ordergoods}">
			<tr>
				
				<td class="t">${ot.goodsname}</td>
				<td class="t">
					<img src="uploadFiles/${ot.goodspicture}" width="50" height="50"/>
				</td>
				<td  class="t" align="right">${ot.goodsprice}</td>
				<td class="t" align="right">${ot.left}</td>
				<td  class="t" align="right">${ot.smallsum}</td>	
			</tr>
		</c:forEach>
		<tr>
			<td class="t" colspan="9" align="right">总计：${requestScope.totol}</td>
		</tr>
		
		<tr>
			<td class="t" colspan="9" align="right">
			
			<a href="javascript:pay1()">提交订单</a>
			
			</td>
		</tr>
	</table></form>
	</div>
			
		
	</div>
	</div>
	
	
</body>
</html>