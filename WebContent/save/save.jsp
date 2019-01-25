<%@ page language="java" contentType="text/html; charset=utf-8"
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>收藏夹</title>
<script type="text/javascript">
function del(goodsid) {
	if(window.confirm("真的不再收藏了吗?")){
		window.location.href="save?action=delete&&goodsid=" + goodsid;
		
	}
}

</script>
<style type="text/css">
	.t{
	height: 50px;
	width: 250px;
	text-align: center;
}
</style>
</head>
<body>
	<table border="1"  style="border-collapse: collapse;">
		<tr>
		
			<th class="t">商品id</th>
			<th class="t">商品名称</th>
			<th class="t">商品图片</th>
			<th class="t">商品单价</th>
			<th class="t">删除收藏</th>
		</tr>
		<c:forEach var="sv" items="${requestScope.allsave}">
			<tr>
				<td class="t">${sv.goodsid}</td>
				<td class="t"><a href="goods?action=showgoods&&goodsid=${sv.goodsid}">${sv.goodsname}</a></td>
				<td class="t">
					<img src="uploadFiles/${sv.goodspicture}" width="50" height="50"/>
				</td>
				<td class="t" align="right">${sv.goodsprice}</td>
				<td class="t"><a href="javascript:del('${sv.goodsid}' )">删除</a></td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>