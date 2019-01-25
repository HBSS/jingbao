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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品详情页</title>
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
		color: white;
	}
	
	#top a{
		color:grey;
		text-decoration: none;
	}
	#top a:hover{
		color: HotPink;
	}
	#header{
		font-family:幼圆;
		background: white;
		padding: 10px;
		font-size: 32px;
		color: Coral;
		margin-left: 60px;
	}
	#search{
		float:right;
		position: relative;
		padding-top: 3px;
		height: 35px;
		width: 380px;
		margin-right: 50px;
	}
	#input{
		left:2px;
		position: absolute;
		font-size: 20px;
		width: 240px;
		height: 25px;
		border: 0;
		background: #ffffff;
		border: 1px solid Coral;
	}
	#go{
		font-size: 14px;
		color: #ffffff;
		position: absolute;
		left: 258px;
		width: 70px;
		height: 30px;
		cursor: pointer;
		border: 0;
		background: LightSalmon;
		border: 1px solid;
		border-radius:5px;
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
		background: SeaShell;
		clear: both;
		text-align: center;
	}
	#left{
		float: left;
		width:450px;
		margin-left:200px;
		margin-top:60px;
		border: 2px solid Lavender;
		border-right-color: white;
	}
	#bigpicture{
		width: 396px;
		height: 300px;
		background-image: url("images/goods/s.jpg");
		background-repeat: no-repeat;
		background-size:100%;
	}
	#pics{
		width: 396px;
		height: 200px;
		border: 1px solid ;
		overflow: hidden;
	
		left: 300px;
	}
	
	#content{
	    margin-top:60px;
		top:130px;
		float: left;
		width: 450px;
		margin-right: 20px;
		border: 2px solid Lavender;
		border-left-color: white;
		position: absolute;
		left: 650px;
		line-height: 60px;
		font-size: 20px;
		height: 540px;
	}
	#right{
		position:absolute;
		top:213px;
		margin-top:-20px;
		margin-right:200px;
		border:3px solid Lavender;
		float:right;
		width: 240px;
		right: 10px;
		text-align: center;
		font-size: 24px;
		height: 535px;
		
	}
	
</style>
<script type="text/javascript">
	var m=new Array();
	m[0]="uploadFiles/${requestScope.goods.goodspicture }";
	m[1]="uploadFiles/${requestScope.goods.goodspicture1 }";
	m[2]="uploadFiles/${requestScope.goods.goodspicture2 }";
	m[3]="uploadFiles/${requestScope.goods.goodspicture3 }";
	m[4]="uploadFiles/${requestScope.goods.goodspicture4 }";
	var i=0;
	function play1(){
		i--;
		if(i==-1)
			i=4;
		document.getElementById("img1").src=m[i];
	}
	function play2(){
		i++;
		if(i==5)
			i=0;
		document.getElementById("img1").src=m[i];
	}
	function iflogin(userid) {
		if(userid!=null){
			document.myform.submit();
		}else{
			window.location.href="user/login.jsp";
		}
	}
	function save(goodsid) {
		window.location.href="save?action=add&&goodsid="+goodsid;
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
			<a href="user/myjingbao.jsp">我的京宝</a>
			<a href="cart?action=select" target="_blank">购物车</a>
			<a href="">收藏夹</a>
			<a href="">联系客服</a>
			<a href="">网站导航</a>
			<a href="index?action=select">回到首页</a>
		</div>
		<div id="header">
			&nbsp;&nbsp;&nbsp;京宝网
			<br>
			jingbao.com
			<div id="search">
			<form action="goods?action=condition" method="post">
				<input class="block" name="goodsname" type="text" ><!-- 搜索框 -->
				<select class="block1" name="goodstype">
					<option value="all">全部</option>
					<c:forEach var="g" items="${requestScope.goodstype}">
						<option value="${g.typeid}">${g.typename}</option>
					</c:forEach>
				</select>
				<input type="submit" class="butt" style="background-color: orange;color: white;"  value="搜京宝">
			</form>
			</div>
		</div>
		<hr style="color: orange;">
		<div id="page" class="clearfix" >
			<div id="left">
				<br>
				<br>
				<div id="bigpicture">
					<img src="uploadFiles/${requestScope.goods.goodspicture }" width="396px" height="300px"/>
				</div>
				<div id="pics">
					<table>
						<tr>
							<td onclick="play1()"><<</td>
							<td>
								<img id="img1" src="uploadFiles/${requestScope.goods.goodspicture }" height="180px" width="350px"/>
							</td>
							<td onclick="play2()">>></td>
						</tr>
					</table>
				</div>
			</div>
			</div>
			<div id="content">
			<form action="cart?action=put" method="post" name="myform" >
				<table>
					<tr>
		
						<td>商品ID：</td>
						<td>
							${requestScope.goods.goodsid}
							<input type="hidden" name="goodsid" value="${requestScope.goods.goodsid}">
						</td>
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
	        </table>
	        	<img alt="" src="images/icon/bnt_coll.gif" width="60px" height="30px" onclick="save('${requestScope.goods.goodsid}')" >
				<br>
				购买数目：<input type="text" name="shopnumber" value="1">
				<br>
				<input type="submit"  value="加入购物车"  style="color: red;width: 170px;height: 50px;background-color: orange;font-size: 30px;">
				<input type="submit"  value="立即购买"  style="color: red;width: 170px;height: 50px;background-color: orange;font-size: 30px;" >
				</form>
			</div>
			<div id="right" >
				<h1>商品描述</h1>
				${requestScope.goods.description}
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
</body>
</html>