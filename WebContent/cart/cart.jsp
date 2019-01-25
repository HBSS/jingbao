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
<script type="text/javascript">
	function zero(goodsid,shopnumber) {
		if(shopnumber>0){
			window.location.href="cart?action=delete&&goodsid="+goodsid+"&&shopnumber="+shopnumber;
		}else{
			alert("您的商品数量已为零!");
			return;
		}
	}
	function del(goodsid) {
		if(window.confirm("你真的不爱我了吗？")){
			window.location.href="cart?action=clear&&goodsid=" + goodsid;
			
		}
	}
</script>
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
		background-color: Linen;
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
	.t{
	width: 224px;
	color: red;
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
		我的购物车
		</div>
		<div id="page" class="clearfix" >
			
			
			<div id="content">
			<form action="order?action=confirmorder" method="post">
	<table border="1"  style="border-collapse: collapse;">
	
		<tr>
		
			<th class="t">商品名称</th>
			<th  class="t">商品图片</th>
			<th  class="t">商品单价</th>
			<th  class="t">商品数量</th>
			<th  class="t">商品小计</th>
			<th colspan="2"  class="t">增删商品</th>
			<th  class="t">清出购物车</th>
		</tr>
		<c:forEach var="ct" items="${requestScope.allcart}">
			<tr>
				
				<td class="t" ><a href="goods?action=showgoods&&goodsid=${ct.goodsid}">${ct.goodsname}</a></td>
				<td>
					<img src="uploadFiles/${ct.goodspicture}" width="50" height="50"/>
				</td>
				<td class="t" align="right">${ct.goodsprice}</td>
				<td class="t" align="right">${ct.shopnumber}</td>
				<td class="t"  align="right">${ct.smallsum}</td>
				<td class="t" ><a href="cart?action=add&&goodsid=${ct.goodsid}&&shopnumber=${ct.shopnumber}">增加</a></td>
				<td class="t"><a href="javascript:zero('${ct.goodsid}','${ct.shopnumber}' )">删除</a></td>
				<td class="t"><a href="javascript:del('${ct.goodsid}' )">清出购物车</a></td>
				
			</tr>
		</c:forEach>
		<tr>
			<td colspan="9" align="right" class="t">总计：${requestScope.totol}</td>
		</tr>
		
		<tr>
			<td colspan="9" align="right"><input type="submit" value="去结算" name="" style="height: 30px;width: 100px;color: white-space;background-color: red;"></td>
		</tr>
	</table>
	</form>
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
	</div>
	
</body>
</html>