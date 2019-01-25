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
<title>购买到的商品</title>
<style type="text/css">
.t1{

	width: 300px;
	text-align: center;
}
</style>

</head>
<body>
<table border="1"  style="border-collapse: collapse;">
		<tr>
		
			<th class="t1">订单ID</th>
			<th class="t1">订单状态</th>
			<th class="t1">下单时间</th>
			<th class="t1">订单总价</th>
			<th class="t1">买家ID</th>
			<th class="t1">操作</th>

		</tr>
		<c:forEach var="ct2" items="${requestScope.allorder}" varStatus="status">
			<tr>
				<td class="t1">${ct2.orderid}</td>
				<td class="t1" align="right">${ct2.position}</td>
				<td class="t1" align="right">${ct2.time}</td>
				<td class="t1" align="right">${ct2.totol}</td>
				<td class="t1" align="right">${ct2.userid}</td>
				<td class="t1"><a href="order?action=delete1&&orderid=${ct2.orderid}">删除订单</a>
			</td></tr>
			
			</c:forEach>
		</table>
</body>
</html>