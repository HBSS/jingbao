<%@ page language="java" import="com.jingbao.dao.BaseDao" contentType="text/html; charset=utf-8"
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
  	<!-- 
  	base标记是一个基链接标记，是一个单标记。用以改变文件中所有链接标记的参数内定值，网页上的所有相对路径在链接时都将在前面加上基链接指向的地址。
  	比如:<base href="http://www.baidu.com">，那下面的href属性就会以上面设的为基准,
  	如:<a href="http://www.baidu.com/xxx.htm"></a>，现在就只需要写<a href="xxx.htm"></a>
  	 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加用户</title>
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
</head>
<body>
	
	<form action="alluser1?action=adduser" method="post">
			<table  border="0" id="mytable">
				<caption>
					<h2 id="myfont">用户信息注册</h2>
				</caption>
				
					<tr>
						<th >用户名:</th>
						<td >	
							 <input type="text" name="username"  value="${param.username}">
		             
					</tr>
					<tr>
						<th>密&nbsp;&nbsp;&nbsp;码:</th>
					  <td>
						
								<input type="password" name="password"  value="${param.password}" >
						</td>
					</tr>
					<tr>
						<th>确认密码:</th>
						<td>
							
								<input type="password" name="repassword"  onblur="samepassword()" value="${param.repassword}">
							
							
						</td>
					</tr>
					<tr>
						<th>密码提示问题:</th>
					  <td>
						
								<!--<input type="text" name="question" class="txtlength" value="${param.question}">-->
							<select  name="question"  >
								<option value="父亲的生日？">父亲的生日？
								<option value="母亲的生日？">母亲的生日？
								<option value="父亲的电话号码？">父亲的电话号码？
								<option value="母亲的电话号码？">母亲的电话号码？
								<option value="父亲的名字？">父亲的名字？
								<option value="母亲的名字？">母亲的名字？
							</select>
			              
						</td>
					</tr>
					<tr>
						<th>密码提示答案:</th>
						<td>
							
								<input type="text" name="questionan"  class="txtlength" value="${param.questionan}">
						      
							    </td>
					</tr>
					<tr>
						<th>真实姓名:</th>
						<td>
							
								<input type="text" name="realname"  value="${param.realname}">
							
							
						</td>
					</tr>
					<tr>
						<th>身份证号:</th>
						<td>
							
								<input type="text" name="idnumber"  maxlength="18" id="idnumber" onblur="isIDtrue()" value="${param.idnumber}">
							
							
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
							
								<input type="text" name="post"  maxlength="6" id="post" onblur="isPostTrue()" value="${param.postcode}">
							
							
						</td>
					</tr>
					<tr>
						<th>邮寄地址:</th>
						<td>
							
								<input type="text" name="address"  value="${param.address}">
							
							
						</td>
					</tr>
					<tr>
						<th>联系电话:</th>
						<td>
							
								<input type="text" name="phone"  value="${param.phone}" maxlength="11">
							
							
						</td>
					</tr>
				</table>
				<font color="red">
			<!--内置对象不需要声明，直接使用 -->
			<!-- EL表达式，null不会显示 -->
			${requestScope.msg}<!-- 相当于request.getAttribute("msg"); -->
			</font>
			<br>
			<br>  
			<input name="submit" type="submit" value="注册">
			<input name="reset" type="reset" value="重置">
			</form>	
</body>
</html>