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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>密保问题界面</title>
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
	}
	
	#top a{
		text-decoration: none;
	}
	#top a:hover{
		color: blue;
	}
	#header{
		
	background: #E6E6FA;
		padding: 10px;
		border-bottom: 1px solid black;
	}
	#header h1{
		font-family:幼圆;
		color:SlateBlue;
		font-weight: bold;
		font-size: 36px;
	}
	#header h2{
		color:MediumSlateBlue;
		font-style: italic;
		font-weight: bold;
		font-size: 30px;
	}
	#page{
		width: auto;
		margin: 0 auto;
		padding-bottom: 60px;
	}
	#footer{
		text-align:center;
		margin-top:10px;
		position:absolute;
		bottom: 0;
		width: 100%;
		height: 60px;
		background: #E6E6FA;
		clear: both;
	}
	/*#left{
		float: left;
		width:220px;
		margin-right: 20px;
		background: lime;
	}*/
	#content{
		background: Azure;
		float: left;
		/*width: 1030px;*/
		width:100%;
		
		margin: 0px;
		padding-top:200px;
		text-align: center;
		padding-bottom: 200px;
	}
	/*#right{
		background: green;
		float:right;
		width: 300px;
		
	}*/
	.t{
		height: 30px;
		width: 200px;
	}
	.s{
		height: 30px;
		width: 150px;
		font-size: medium;
	}
</style>
</head>
<body>
<div class="container">
		<div id="top">
			<a href="index?action=select">回到首页</a>
			<a href="user/login.jsp">登录</a>
		</div>
		<div id="header">
			<h1>&nbsp;&nbsp;&nbsp;京宝网</h1>
			<h2>&nbsp;&nbsp;&nbsp;jingbao.com</h2>
		</div>
		<div id="page" class="clearfix" >
			<!-- <div id="left">left
			</div>-->
			
			
			<div id="content">
				<form action="forget" method="post" name="forget">
					用&nbsp;户&nbsp;名：<input type="text" name="username" class="t">
					<br>
					<br>
					密保问题：<select class="t" name="question"  >
								<option value="父亲的生日？">父亲的生日？
								<option value="母亲的生日？">母亲的生日？
								<option value="父亲的电话号码？">父亲的电话号码？
								<option value="母亲的电话号码？">母亲的电话号码？
								<option value="父亲的名字？">父亲的名字？
								<option value="母亲的名字？">母亲的名字？
							</select>
					<br>
					<br>
					密保答案：<input type="text" class="t" name="questionan">
					<br>
					<br>
					<font color="red">
						<!--内置对象不需要声明，直接使用 -->
						<!-- EL表达式，null不会显示 -->
						${requestScope.msg}<!-- 相当于request.getAttribute("msg"); -->
						</font>
					<br>
					<br>
					&nbsp;&nbsp;&nbsp;<input type="submit" class="s" value="提交">
					
					
				</form>
			</div>
			
			
			
			<!--<div id="right" >right
		   </div>-->
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