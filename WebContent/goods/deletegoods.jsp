<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>删除</title>
<script type="text/javascript">
	function deletegoods(goodsid){
		if(window.confirm("真的删除么？")){
			window.location.href="goods?action=delete&&goodsid=" + goodsid;
			
		}
	}
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
	height: 30px;
	width: 290px;
	}
</style>
</head>
<body>
	<form action="goods?action=deletes" name="myform" method="post">
	<table>
		<tr>
			<th class="t">商品ID</th>
			<th class="t">商品名称</th>
			<th class="t">商品类型</th>
			<th class="t">商品库存</th>
			<th class="t">商品描述</th>
			<th class="t">商品图片</th>
			<th class="t">操作</th>
		</tr>
		
		<c:forEach var="g" items="${requestScope.allgoods }">
			<tr>
				<td class="t">${g.goodsid}</td><!-- id为user类的变量 -->
				<td class="t">${g.goodsname}</td>
				<td class="t">${g.typename}</td>
				<td class="t">${g.left}</td>
				<td class="t">${g.description}</td>
				<td class="t">
				<img src="uploadFiles/${g.goodspicture}" width="50" height="30"/>
				

				</td>
				
				<td>
					<input type="checkbox" value="${g.goodsid}" name="del" >
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" class="t">
				<!-- 分页对应的servlet -->
				<jsp:include page="page.jsp">
					<jsp:param value="goods?action=selects" name="objectSelect"/>
				</jsp:include>
				<!-- 为了page页面方便使用，这里的参数value必须有?传参数，如果没有值可传，可任意传，如?a=a -->
			</td>
		</tr>
	</table>
	<input name="all" type="checkbox" onClick="getAll()">全选
	<input name="opposite" type="checkbox" onClick="reserve()">反选
	<input type="button" onclick="getValue()"  value="删除">
	</form>
</body>
</html>