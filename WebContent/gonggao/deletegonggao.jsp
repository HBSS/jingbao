<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%
String path = request.getContextPath();
//获取当前项目的路径，如：http://localhost:8080/项目名称。
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
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
<style type="text/css">
.t{
	width: 400px;
	text-align: left;
}
</style>
</head>
<body>
	<form action="gonggao?action=delete2" name="myform" method="post">
	<table>
		<tr>
			<th class="t">公告ID</th>
			<th class="t">公告名称</th>
			<th class="t">操作</th>
		</tr>
		
		<c:forEach var="g" items="${requestScope.allgonggao}">
			<tr>
				<td class="t">${g.gonggaoid}</td><!-- id为user类的变量 -->
				<td class="t">${g.gonggaoname}</td>
				<td class="t">
					<input type="checkbox" value="${g.gonggaoid}" name="del" >
				</td>
			</tr>
		</c:forEach>
	</table>
	<input  name="all" type="checkbox" onClick="getAll()">全选
	<input  name="opposite" type="checkbox" onClick="reserve()">反选
	<input   type="button" onclick="getValue()"  value="删除">
	</form>
</body>
</html>