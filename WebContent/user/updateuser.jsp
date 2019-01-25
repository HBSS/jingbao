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
<title>修改用户信息界面</title>
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
	
        <form action="userinformation" method="post">
			<table  border="0" id="mytable">
					<tr>
						<th>密码提示问题:</th>
					  <td>
						
								<!--<input type="text" name="question"  value="${param.question}">-->
							<select class="txtlength" name="question" value="${param.question}"  >
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
							
								<input type="text" name="questionan"  value="${param.questionan}">
						      <font class="cue">(只有答案完全正确时才可找回密码，请牢记</font>)
							    </td>
					</tr>
					<tr>
						<th>真实姓名:</th>
						<td>
							
								<input type="text" name="realname" value="${param.realname}">
							
							
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
							
								<input type="text" name="email"	 id="email" value="${param.email}">
							
							
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
			<br>
			<br>  
			<input name="submit" type="submit" value="确认修改">
			<input name="reset" type="reset" value="取消" onclick="user/myjinbao.jsp">
			</form>	
			<font color="red">
			<!--内置对象不需要声明，直接使用 -->
			<!-- EL表达式，null不会显示 -->
			${requestScope.msg}<!-- 相当于request.getAttribute("msg"); -->
			</font>
     
</body>
</html>