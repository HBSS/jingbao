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
<title>购物主界面</title>
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
		top:2000px;
	}
	#left{
		float: left;
		width:220px;
		margin-right: 20px;
		
	}
	#d5{
	width: 302px;
	height: 290px;
	float: left;
	position: absolute;
	top:248px;
	left:58px;
	background-color: pink;
	border:3px solid DarkOrange;
	
}
#d5 a{
	text-decoration:none;/*去超链接的横线*/
}
#d5 h2{
	text-align: center;
	color: #FF0000;
}
#d5 marquee {
	direction: left;
	font-size: 20px;
	text-align: left; 
}
#d6{
	border:1px solid Lavende;
	width: 810px;;
	height: 400px;
	position: absolute;
	top: 248px;
	left: 370px;
	overflow: hidden;
	z-index: -1;
	background-color: white;
}


	#content{
		background: orange;
		float: left;
		width: 480px;
		margin: 20px;
	}
	#right{
		background: green;
		float:right;
		width: 300px;
		
	}
	
	
	
	#d7{
	width: 302px;
	height: 290px;
	border:3px solid DarkOrange;
	position: absolute;
	top:248px;
	left:1180px;
	z-index: -1;
	
}
#d7 h2{
	text-align: center;
	color: #FF0000;
}
#d7 a{
	text-decoration:none;/*去超链接的横线*/
}
#d7 ul li{
	list-style: none;
}
#d8{
	
	left:58px;
	width: 302px;
	height: 350px;
	border:3px solid DarkOrange;
	position: absolute;
	top:548px;
}
#d8 h2{
	text-align: center;
	color: #FF0000;
}
#d8 a{
	text-decoration:none;/*去超链接的横线*/
}
#d8 ul li{
	list-style: none;
}
#d9{
	width: 780px;
	height: 200px;
	background-color: white;
	position: absolute;
	top:650px;
	left:377px;
	padding: 5px;
	border: 0px solid red;
}
#d9 a{
	text-decoration:none;/*去超链接的横线*/
	text-align: center;
}
#d92{
	position: absolute;
	top: 42px;
	left: 270px;
	text-align: center;
}
#d93{
	position: absolute;
	top: 42px;
	left: 530px;
	text-align: center;
}
#d10{
	width: 302px;
	height: 350px;
	border:3px solid DarkOrange;
	position: absolute;
	top:548px;
	left:1180px;
	
}
#d10 h2{
	text-align: center;
	color: #FF0000;
}
#d10 a{
	text-decoration:none;/*去超链接的横线*/
}
#d10 ul li{
	list-style: none;
}
#img1{
	height: 100px;
	width: auto;
	position: absolute;
	top:920px;
	left: 40px;
}
#img2{
	height: 100px;
	width: auto;
	position: absolute;
	top:1320px;
	left: 40px;
}
</style>
<script type="text/javascript">
	var m=new Array();
	m[0]="images/logo/main/1.png";
	m[1]="images/logo/main/2.png";
	m[2]="images/logo/main/3.png";
	m[3]="images/logo/main/4.png";
	m[4]="images/logo/main/5.png";
	var i=0;
	function play1(){
		if(i==5)
			i=0;
		document.getElementById("mainimg").src=m[i++];
		setTimeout("play1()", 3000);
	}
	
</script>
	
	
	



</head>
<body onload="play1()">
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
			<a href="save?action=select" target="center">收藏夹</a>&nbsp;&nbsp;&nbsp;
			<a href="">联系客服</a>
		</div>
		<div id="header">
			<div id="d2">
			<h1>京宝网</h1>
			<h2>Jingbao.com</h2>
			</div>
			<div id="d3">
			<form action="goods?action=condition" method="post" >
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
		
		
			<div id="left">
				
				<div id="d5">
					<h2>京宝头条</h2>
					<ul>
				<c:forEach var="g" items="${requestScope.allgonggao }">
					<li><a href="">${g.gonggaocontent}</a>	<br>		
				</c:forEach>
				</ul>
			</div>
			
			</div>
			
			<div id="content">
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
				
				<div id="d6">
					<img id="mainimg" alt="" src="" width="800px" height="400px">
				</div>
				
				
				
				<div id="d9" >
		<font>他们都在买<a href="">(换一波)</a></font>
		<hr color="orange">
		<a href="" id="d91"><img alt="" src="images/goods/box/2.jpg"
		width="250px" height="200px"><br> &nbsp; &nbsp;&nbsp; &nbsp;gotrip旅行箱</a>
		<a href="" id="d92"><img alt="" src="images/goods/dress/1.jpg"
		width="250px" height="200px"><br>金大班沙滩裙</a>
		<a href="" id="d93"><img alt="" src="images/goods/t-shirt/1.jpg"
		width="250px" height="200px"><br>素色百搭T恤</a>
	</div>
			
			</div>
			
			
			
			<div id="right" >
			<div id="d7">
				<h2>京宝自营</h2>
				<ul>
					<li><a href="">
						1.<img alt="" src="images/goods/camera/7.jpg"
						width="65px" height="65px">
						佳能相机
					</a></li>
					<li><a href="">
						2.<img alt="" src="images/goods/fruit/4.jpg"
						width="65px" height="65px">
						秭归脐橙
					</a></li>
					<li><a href="">
						3.<img alt="" src="images/goods/t-shirt/4.jpg"
						width="65px" height="65px">
						女士打底短袖
					</a></li>
				</ul>
			</div>
			<div id="d8">
				<h2>特划算</h2>
					<ul>
					<li><a href="">
						1.<img alt="" src="images/goods/3_thumb.jpg"
						width="65px" height="70px">
						三星耳机 现价￥49
					</a></li>
					<li><a href="">
						2.<img alt="" src="images/goods/food4.jpg"
						width="65px" height="70px">
						美国车厘子 现价￥35
						</a></li>
					<li><a href="">
						3.<img alt="" src="images\goods\99.jpg"
						width="65px" height="70px">
						极有家抱枕 现价￥9.9
					</a></li>
					</ul>
			</div>
	
	<div id="d10">
		<h2>上新啦</h2>
		<ul>
			<c:forEach var="g" items="${requestScope.allgoods }" >
		<li style="text-align: center; ">
				<img  alt="" src="uploadFiles/${g.goodspicture}"  
				width="80px" height="70px"><br>
				<a href="">${g.goodsname}
			</a></li>
			</c:forEach>
		</ul>
	</div>
	
		  
		   </div>
		
		<div id="img1">
		<img alt="" src="images/logo/main/6.png" height="400px" width="1500px">
		</div>
		
		<div id="img2">
			<img alt="" src="images/logo/main/7.png" height="600px" width="1500px">
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