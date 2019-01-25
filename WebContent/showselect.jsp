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
<title>搜索主界面</title>
<link rel="stylesheet" href="home.css" type="text/css" />
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
		background-color: Linen;
	}
	#top{
		height: 20px;
		width: auto;
		text-align: right;
		text-decoration: none;
		color: MediumPurple;
		/*height:100%;     /*垂直居中*/
		line-height:100%;/*垂直居中*/
		overflow:hidden; /*垂直居中*/
		background-color:#f9ddce;
		text-align:right;
		font-size:18px;
	}
	#top a{
		text-decoration:none;/*去超链接的横线*/
		font-family: DFKai-SB,KaiTi;
		color: #8401b6;
	}
	#top a:hover{
		color: #fd0902;
		font-family: FangSong,SimHei;
		font-style: oblique;
	}
	
	
	#header{
		height:180px;
		background: Yellow;
		padding: 10px;
	}
	#d2{
		height:100%
		border:0px solid;
		width: 320px;
		font-family:华文新魏;
		color: Chocolate;
		font-size: 24px;
		float: left;
		text-align: center;
	}
	#d3{
		height:100%;
		border:0px solid;
		width: 1100px;
		height:90px;
		float: right;
		text-align: center;
		padding-top: 4px;
		background-image: ;
		margin-top: 50px;
	}
	
	.block{
		width: 500px;
		height: 30px;
		background-image: url("");
		background-position:right;
		background-repeat: no-repeat;
	}
	.block1{
		width: 70px;
		height: 35px;
	}
	.butt{
		background-color: orange;
		height: 30px;
		width: 80px;
	}
	
	#d4{
		width: 1100px;
		height: 80px;
		position: absolute;
		top:153px;
		left:350px;
		margin-left: 20px;
	}	
	#d4 ul{
		font-size: 14px;
		list-style-type: none;
	}
	#d4 ul li{
		float: left;
	}
	#d4 ul li a{
		color: black;
		text-decoration: none;
		padding-top: 4px;
		display: block;
		width: 130px;
		height: 40px;
		text-align: center;
		background-color: #FFA500;
		margin-left: 5px;
		font-size: 25px;
		font-family: 华文新魏;
	}
	#d4 ul li a:hover{
		background-color: red;
		font-size: 30px;
	}
	#d4 ul li ul li{
		float: none;
	}
	#d4 ul li ul li a{
		background-color: #FFE4B5;
		width: 130px;
		height: 30px;
		color: gray;
	
	}
	#d4 ul li ul li a:hover{
		background-color: red;
		font-size: 30px;
		color: black;
		z-index: 1;
	}
	#d4 ul li ul{
		display: none;
	}
	#d4 ul li:hover>ul{
		display: block;
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
		color: white;
		top:730px;
	}
	


	#content{
		background: Linen;
		float: left;
		width: 100%;
		margin: 0px;
		height: 100%;
	}
	
.t{
	height: 30px;
	width: 230px;
	text-align: center;
}


</style>




</head>
<body >
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
			<a href="cart?action=select" target="_blank">购物车</a>&nbsp;&nbsp;&nbsp;
			<a href="">收藏夹</a>&nbsp;&nbsp;&nbsp;
			<a href="">联系客服</a>
		</div>
		<div id="header">
			<div id="d2">
			<h1>京宝网</h1>
			<h2>Jingbao.com</h2>
			</div>
			<div id="d3">
			<form action="goods?action=condition" method="post">
				<input class="block" name="goodsname" type="text" ><!-- 搜索框 -->
				<select class="block1" name="goodstype">
					<option value="all">全部</option>
					<c:forEach var="g" items="${requestScope.goodstype}">
						<option value="${g.typeid}">${g.typename}</option>
					</c:forEach>
				</select>
				<input type="submit" class="butt"   value="搜索">
			</form>
		</div>
		</div>
		<div id="page" class="clearfix" >
		
			
			<div id="content"  >
			
			
			  <table border="1" name="ta" style="border-collapse: collapse;">
		<tr>
			<th class="t">商品ID</th>
			<th class="t">商品名称</th>
			<th class="t">商品类型</th>
			<th class="t">商品库存</th>
			<th class="t">商品描述</th>
			<th class="t">商品图片</th>
			<th class="t">操作</th>
			
			
		</tr>
		<c:forEach var="g" items="${requestScope.allgoods }">
			<tr>
				<td class="t">${g.goodsid}</td><!-- id为user类的变量 -->
			    <td class="t">${g.goodsname}</td>
				<td class="t">${g.typename}</td>
				<td class="t">${g.left}</td>
				<td class="t">${g.description}</td>
				<td class="t">
				
				<img src="uploadFiles/${g.goodspicture}" width="50" height="50"/>
				

				</td>
				<td class="t">
					<a href="goods?action=showgoods&&goodsid=${g.goodsid}">去看看</a>
					
				</td>
				
			</tr>
		</c:forEach>
		<tr>
			<td colspan="7" class="t">
				<!-- 分页对应的servlet -->
				<jsp:include page="page.jsp">
					<jsp:param value="goods?action=select" name="objectSelect"/>
				</jsp:include>
				<!-- 为了page页面方便使用，这里的参数value必须有?传参数，如果没有值可传，可任意传，如?a=a -->
			 </td>
		</tr>
	</table>
			</div>
				<div id="d4">
					<ul>
						<li><a href="">服装衣饰</a>
							<ul>
								<li><a href="">女装</a></li>
								<li><a href="">男装</a></li>
								<li><a href="">童装</a></li>
							</ul>
						</li>
						<li><a href="">个护化妆</a>
							<ul>
								<li><a href="">洗护用品</a></li>
								<li><a href="">化妆品</a></li>
							</ul>
						</li>
						<li><a href="">家用电器</a>
							<ul>
								<li><a href="">厨房用品</a></li>
								<li><a href="">卫浴用品</a></li>
								<li><a href="">声像电器</a></li>
							</ul>
						</li>
						<li><a href="">电脑办公</a>
							<ul>
								<li><a href="">文具事务</a></li>
								<li><a href="">办公耗材</a></li>
								<li><a href="">办公设备</a></li>
							</ul>
						</li>
						<li><a href="">图书资料</a>
							<ul>
								<li><a href="">儿童图书</a></li>
								<li><a href="">学习用书</a></li>
								<li><a href="">文学图书</a></li>
							</ul>
						</li>
						<li><a href="">食品生鲜</a>
							<ul>
							<li><a href="">新鲜蔬果</a></li>
							<li><a href="">飘香肉类</a></li>
							<li><a href="">好吃零食</a></li>
							</ul>
						</li>
						<li><a href="">鞋靴箱包</a>
							<ul>
								<li><a href="">精品皮鞋</a></li>
								<li><a href="">奢侈品包</a></li>
								<li><a href="">服装配件</a></li>
							</ul>
						</li>
					</ul>
				</div>
				
				
				
			
			
			
			
	
	
		
		
		
		  <div id="footer">
			<br>
			
			<a href="">倩倩中国站</a>&nbsp;|
			<a href="">白斓国际站</a>&nbsp;|
			<a href="">哈佬集团</a>&nbsp;|
			<a href="">全球速卖通</a>&nbsp;|
			<a href="user/usermain.jsp">京宝网</a>&nbsp;|
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