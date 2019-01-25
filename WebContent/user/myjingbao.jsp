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
<title>用户页面</title>
<style type="text/css">
		html,body{
		margin: 0;
		padding: 0;
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
		background-color:MintCream;
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
		background: SkyBlue;
		padding: 15px;
		text-align: center;
		text-decoration: none;
		font-family:华文行楷;
		font-size: 40px;
		font-style: normal;
		font-weight: bold;
	}
	#menu{
		background: DarkCyan;
		height: 40px;
		padding-top:15px;
		
	}
	.nav-2{
		margin: 0px auto;
		background-color: LightSeaGreen;
		background: Blue;
		border-top: 2px solid #000;
		border-bottom: 2px solid #000;
	}
	.nav-2>ul{
		margin:0 auto;
		list-style: none;
		position: relative;
		width: 1000px;
 
	}
	.nav-2>ul>li{
		float: left;
		line-height: 20px;
		width: 200px;
	}
	.nav-2>ul>li:hover>ul{
		display: block;
	}
	.nav-2>ul>li>a{
		display: block;
		width: 105px;
		color: #ffffff;
		text-align: center;
		text-decoration: none;
	}
	.nav-2>ul>li>ul{
		list-style: none;
		display: none;
	}
	.nav-2>ul>li>ul>li{
		display: block;
		background-color: LightSeaGreen;
		line-height: 25px;
		border-left: 2px solid #000;
		border-right: 2px solid #000;
	}
	.nav-2>ul>li>ul>li>a{
		display: block;
		width: 100px;
		color: #ffffff;
		text-align: center;
		text-decoration: none;
	}
	#page{
		width: auto;
		margin: 0 auto;
		padding-bottom: 60px;
		}
	#footer{
		position: absolute;
		bottom: 0;
		width: 100%;
		height: 60px;
		background: PaleTurquoise;
		clear: both;
		text-align: center;
	}
	#left{
		width: 220px;
		float: left;
		margin-right: 20px;
		height: 100%;
		
	}
	
	/*#content{
		background-color: WhiteSmoke;
		float: left;
		width: auto;
		margin-right: 20px;
	}*/
	#content {
		width:100%;
		padding: 10px;
	
		position: absolute;
		z-index: -1;
		height: 100%;
		
		text-align: center;
	}

	#content iframe {
		padding-left:150px;
		height: 100%;
		width: 100%;
	
	
	}
	
	#right{
		height:100%;
		float: right;
		width: 200px;
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
			<a href="cart?action=select" target="_blank">购物车</a>&nbsp;&nbsp;&nbsp;
			<a href="save?action=select">收藏夹</a>&nbsp;&nbsp;&nbsp;
			<a href="">联系客服</a>
			</div>
		<div id="header">京宝网用户中心</div>
		<div id="menu" class="nav-2">
				  <ul>
					<li><a href="save?action=select" target="center">收藏管理</a>
					</li>
					
					<li><a href="order?action=cancel" target="blank">我的订单</a>
					</li>
					
					<li><a href="">个人中心</a>
						<ul>
							<li><a href="user/updateuser.jsp" target="center">修改信息</a></li>
							<li><a href="" target="center">我的评价</a></li>
							<li><a href="" target="center">京宝付</a></li>
						</ul>
					</li>
					
					<li><a href="cart?action=select" target="_blank">查看购物车</a>
						
					</li>
					
					<li><a href="useroff">退出系统</a>
						<ul>
							<li><a href="useroff" >注销用户</a></li>
						</ul>
					</li>
				</ul>
				
		</div>
		<div id="page">
			<div id="left"></div>
	
			<div id="content">
				<iframe src="" name="center" frameborder="0" id="center"></iframe>
			</div>
			<div id="right"></div>
			<div id="footer">
				<br>
				Copyright &reg;白杨安集团有限公司
			</div>
		</div>
	</div>
</body>
</html>