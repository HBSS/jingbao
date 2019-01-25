<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
	function getAll(){
		var mylike=document.getElementsByName("del");
		var nolike=document.getElementsByName("opposite");
		var like=document.getElementsByName("all");
		nolike[0].checked=false;
		for(var i=0;i<mylike.length;i++){
			if(!mylike[i].checked){
				mylike[i].checked=true;
			}
		}
		if(!like[0].checked){
			for(var i=0;i<mylike.length;i++){
				if(mylike[i].checked){
					mylike[i].checked=false;
				}
			}	
		}
	}
	
	function reserve(){
		var mylike=document.getElementsByName("del");
		var like=document.getElementsByName("all");
		like[0].checked=false;
		for(var i=0;i<mylike.length;i++){
			if(!mylike[i].checked){
				mylike[i].checked=true;
			}else{
				mylike[i].checked=false;	
			}
		}
	}
	function getValue(){
		var mylike=document.getElementsByName("del");
		//都没有选 return
		if(window.confirm("真的删除么？")){
			document.myform.submit();
		}
	}
</script>
</head>
<body>
	<form action="alluser1?action=deletes" name="myform" method="post">
	<table>
		<tr>
			<td id="td">用户ID</td>
			<td id="td">用户名</td>
			<td id="td">密码</td>
			<td id="td">密保问题</td>
			<td id="td">密保问题答案</td>
			<td id="td">真实姓名</td>
			<td id="td">身份证号</td>
			<td id="td">邮编</td>
			<td id="td">地址</td>
			<td id="td">电话</td>
			<td id="td">邮箱</td>
			
			
		</tr>
		<c:forEach var="u1" items="${requestScope.alluser}">
			<tr>
				<td id="td">${u1.id}</td><!-- id为user的变量 -->
				<td id="td">${u1.username}</td>
				<td id="td">${u1.password}</td>
				<td id="td">${u1.question}</td>
				<td id="td">${u1.questionan}</td>
				<td id="td">${u1.realname}</td>
				<td id="td">${u1.idnumber}</td>
				<td id="td">${u1.post}</td>
				<td id="td">${u1.address}</td>
				<td id="td">${u1.phone}</td>
				<td id="td">${u1.email}</td>
				<td>
					<input type="checkbox" value="${u1.id}" name="del" >
				</td>
				
			</tr>
		</c:forEach>
	</table>
	<input name="all" type="checkbox" onClick="getAll()">全选
	<input name="opposite" type="checkbox" onClick="reserve()">反选
	<input type="button" onclick="getValue()"  value="删除">
	</form>
</body>
</html>