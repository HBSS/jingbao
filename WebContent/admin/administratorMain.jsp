<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
<title>后台管理员页面</title>
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
	#header{
		background: lightgrey;
		padding: 15px;
		text-align: center;
		text-decoration: none;
		font-family:华文行楷;
		font-size: 40px;
		font-style: normal;
		font-weight: bold;
	}
	#menu{
		background: grey;
		height: 40px;
		padding-top:15px;
		
	}
	.nav-2{
		margin: 0px auto;
		background-color: #666;
		background: dimgrey;
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
		background-color: #666;
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
		top:800px;
		width: 100%;
		height: 60px;
		background: DimGray;
		clear: both;
		text-align: center;
	}
	/*#left{
		width: 220px;
		float: left;
		margin-right: 20px;
		background: Silver;
		
	}*/
	
	/*#content{
		background-color: WhiteSmoke;
		float: left;
		width: auto;
		margin-right: 20px;
	}*/
	#content {
		width:100%;
		height:100%;
		padding: 10px;
		position: absolute;
		z-index: -1;
	}

	#content iframe {
		height: 100%;
		width: 100%;
	
	
	}
	
	/*#right{
		background: green;
		float: right;
		width: 10px;
	}*/
</style>


</head>
<body>
	<div class="container">
		<div id="header">京宝网后台管理系统</div>
		<div id="menu" class="nav-2">
				  <ul>
					<li><a href="goods?action=select">商品管理</a>
						<ul>
							<li><a href="goods?action=select" target="center">查询商品</a></li>
							<li><a href="goods/addgoods.jsp" target="center">添加商品</a></li>
							<li><a href="goods?action=selectitem" target="center">修改商品</a></li>
							<li><a href="goods?action=selects" target="center">删除商品</a></li>
						</ul>
					</li>
					
					<li><a href="#">订单管理</a>
						<ul>
							<li><a href="order?action=select" target="center">查询订单</a></li>
							
						</ul>
					</li>
					
					<li><a href="#">用户管理</a>
						<ul>
							<li><a href="alluser1?action=select" target="center">查询用户</a></li>
							<li><a href="admin/adduser.jsp" target="center">添加用户</a></li>
							<li><a href="alluser1?action=selectitem" target="center">修改用户</a></li>
							<li><a href="alluser1?action=selects" target="center">删除用户</a></li>
							<li><a href="alluser" target="center">查询管理员</a></li>
						</ul>
					</li>
					
					<li><a href="#">公告管理</a>
						<ul>
							<li><a href="gonggao?action=select" target="center">查询公告</a></li>
							<li><a href="gonggao/addgonggao.jsp" target="center">添加公告</a></li>
							<li><a href="gonggao?action=update" target="center">修改公告</a></li>
							<li><a href="gonggao?action=delete" target="center">删除公告</a></li>
						</ul>
					</li>
					
					<li><a href="#">退出系统</a>
						<ul>
							<li><a href="loginoff" target="center">注销用户</a></li>
						</ul>
					</li>
				</ul>
				
		</div>
		<div id="page">
	
			<div id="content">
				<iframe src="" name="center" frameborder="0"></iframe>
			</div>
		
			<div id="footer">
				<br>
				Copyright &reg;白杨安集团有限公司
			</div>
		</div>
	</div>
</body>
</html>