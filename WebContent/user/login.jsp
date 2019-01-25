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
<title>用户登录界面</title>
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
		/*background-color: orange;
		width:auto;
		font-family: fantasy;
		color: red;
		text-align: justify;*/
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
		position:absolute;
		padding:20px;
		text-align:center;
		bottom: 0;
		width: 100%;
		height: 60px;
		background: #E6E6FA;
		clear: both;
		margin: 10px;
		border-top: 1px solid black;
		top:697px;
	}
	#left{
		float: left;
		height:480px;
		width:1070px;
		margin-right: 0px;
		background-image: url("images/logo/login1.jpg.png");
		background-repeat: no-repeat;
		background-size:100%; 
		border: 2px solid white;
	}
	#right{
		background: LightSteelBlue;
		float:right;
		width: 300px;
		text-align: center;
		margin:0px;
		padding: 70px;
		font-size: medium;
		border: 1px solid #4B0082;
	}
	form{
		font-size:16px; 
	}
	.input-text{
		width: 200px;
		height: 20px;
	}
	#submit{
		font-size:large;
		width: 180px;
		height: 40px;
		position: static;
	}
</style>
<script type="text/javascript">
	function reloadcode(){
		document.getElementById("codeImg").src = "code?" + new Date();
	}
</script>
</head>
<body>
	<div class="container">
		<div id="top">
			<a href="index?action=select">回到首页</a>
		</div>
		<div id="header">
			<h1>京宝网</h1>
			<h2>jingbao.com</h2>
		</div>
		<div id="page" >
			<div id="left">
			
			</div>
			<div id="right" >
				<font size="14px" style="font-family:Arial Black" color="SteelBlue">京宝账户登录</font>
				<br>
				<br>
				<form  id="login-form" action="userlogin" method="post">
						用户名：<input type="text" class="input-text" id="username" name="username" value="${param.username}"/><br>
						<br>
						<br>
						密&nbsp;&nbsp;码：<input type="password" class="input-text" id="password" name="password" value="${param.password}" /><br>
						<br>
						&nbsp;验证码:<input type="text"  name="code" />
        					<img id="codeImg" src="code" alt="点击换一张" style="cursor: hand" onclick="javascript:reloadcode()" height="20" />
							<br>
						<font color="red">
						<!--内置对象不需要声明，直接使用 -->
						<!-- EL表达式，null不会显示 -->
						${requestScope.msg}<!-- 相当于request.getAttribute("msg"); -->
						</font>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<br>
						<br>
						<input type="submit" value="登录" id="submit"><br>
						<br>
						<br>
						<br>
						<a href="user/forget.jsp">忘记密码？</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="user/userregister.jsp">注册用户</a>
						
				</form>
		   </div>
	
	<div id="footer">
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
	
</body>
</html>