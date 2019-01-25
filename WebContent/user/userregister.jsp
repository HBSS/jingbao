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
<title>用户注册页面</title>
<link rel="stylesheet" href="register.css" type="text/css" />
<style type="text/css">
	
</style>
<script type="text/javascript">
	function samepassword(){
		var repassword=document.getElementById("repassword");
		var password=document.getElementById("password");
		if(repassword.value!=password.value){
			alert("确认密码与密码不一致！");
			document.myform.repassword.focus();
			return false;
		}
	}
	function isIDtrue(){
		var id=document.getElementById("idnumber").value;
		var pattern1=/^\d{15}$|^\d{18}$|^\d{17}[xX]$/;
		if(!pattern1.test(id)){
			alert("身份证号输入不合法!");
			document.idform.id.focus();
			return false;
			}
		return true;
		}
	function isPostTrue(){
		var mpost=document.getElementById("post").value;
		var pattern = /^\d{6}$/;
		if(!pattern.test(mpost)){
			alert("邮编输入不合法!");
			document.postform.postnumber.focus();
			return false;
			}
		return true;
		}
</script>
<style type="text/css">
#top{
	text-align: right;
}
#footer{
	position:absolute;
	top:700px;
	text-align: center;
	width: 100%;
}
#content{
	position:absolute;
	left: 430px;
}
</style>
</head>
<body>
	<div>
		<div id="top">
			<a href="index?action=select">返回首页</a>&nbsp;&nbsp;&nbsp;<a href="">客服中心</a>
		</div>
    	<div id="header">
    		<hr color="#778899">
    		<h1 align="center">京宝网</h1>
    		<h2 align="center">jingbao.com</h2>
    		<hr color="#778899">
        </div>
        <div id="content">
        <form action="userregister" method="post">
			<table  border="0" id="mytable">
				<caption>
					<h2 id="myfont">用户信息注册</h2>
				</caption>
				
					<tr>
						<th >用户名:</th>
						<td >
							
								<p>
								  <input type="text" name="username" class="txtlength" value="${param.username}">
						      <font class="cue">(请记住您的用户名</font> )</p>
		             
					</tr>
					<tr>
						<th>密&nbsp;&nbsp;&nbsp;码:</th>
					  <td>
						
								<input type="password" name="password" class="txtlength" value="${param.password}" >
			              <font class="cue">(请牢记密码</font>
						)
						</td>
					</tr>
					<tr>
						<th>确认密码:</th>
						<td>
							
								<input type="password" name="repassword" class="txtlength" onblur="samepassword()" value="${param.repassword}">
							
							<font></font>
						</td>
					</tr>
					<tr>
						<th>密码提示问题:</th>
					  <td>
						
								<!--<input type="text" name="question" class="txtlength" value="${param.question}">-->
							<select class="txtlength" name="question"  >
								<option value="父亲的生日？">父亲的生日？
								<option value="母亲的生日？">母亲的生日？
								<option value="父亲的电话号码？">父亲的电话号码？
								<option value="母亲的电话号码？">母亲的电话号码？
								<option value="父亲的名字？">父亲的名字？
								<option value="母亲的名字？">母亲的名字？
							</select>
			              <font class="cue">(密码提示问题帮助您找回密码</font>
						)
						</td>
					</tr>
					<tr>
						<th>密码提示答案:</th>
						<td>
							
								<input type="text" name="questionan" class="txtlength" value="${param.questionan}">
						      <font class="cue">(只有答案完全正确时才可找回密码，请牢记</font>)
							    </td>
					</tr>
					<tr>
						<th>真实姓名:</th>
						<td>
							
								<input type="text" name="realname" class="txtlength" value="${param.realname}">
							
							
						</td>
					</tr>
					<tr>
						<th>身份证号:</th>
						<td>
							
								<input type="text" name="idnumber" class="txtlength" maxlength="18" id="idnumber" onblur="isIDtrue()" value="${param.idnumber}">
							
							
						</td>
					</tr>
					<tr>
						<th>邮箱地址:</th>
						<td>
							
								<input type="text" name="email"	class="txtlength" id="email" value="${param.email}">
							
							
						</td>
					</tr>
					<tr>
						<th>邮编:</th>
						<td>
							
								<input type="text" name="post" class="txtlength" maxlength="6" id="post" onblur="isPostTrue()" value="${param.postcode}">
							
							
						</td>
					</tr>
					<tr>
						<th>邮寄地址:</th>
						<td>
							
								<input type="text" name="address" class="txtlength" value="${param.address}">
							
							
						</td>
					</tr>
					<tr>
						<th>联系电话:</th>
						<td>
							
								<input type="text" name="phone" class="txtlength" value="${param.phone}" maxlength="11">
							
							
						</td>
					</tr>
				</table>
			<br>
			<br>  
			<input name="submit" type="submit" value="注册" style="left: 200px;position: absolute;">
			<input name="reset" type="reset" value="重置" style="left: 300px;position: absolute;">
			</form>	
			<font color="red">
			<!--内置对象不需要声明，直接使用 -->
			<!-- EL表达式，null不会显示 -->
			${requestScope.msg}<!-- 相当于request.getAttribute("msg"); -->
			</font>
        </div>
        
      
       
       
       
        <div id="footer">
        	<hr color="red" width="100%">
        	<br>
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