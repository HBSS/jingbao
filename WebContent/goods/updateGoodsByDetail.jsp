<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改商品界面</title>
<script type="text/javascript">
</script>
<style type="text/css">
.t{
	height: 30px;
}
</style>
</head>
<body>
	<table>
		<tr>
			<th class="t">商品ID</th>
			<th class="t">商品名称</th>
			<th class="t">商品类型</th>
			<th class="t">商品价格</th>
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
				<td class="t">${g.goodsprice}</td>
				<td class="t">${g.left}</td>
				<td class="t">${g.description}</td>
				
				<td class="t">
				<img src="uploadFiles/${g.goodspicture}" width="50" height="50"/>
				</td>
				<td class="t">
					<a href="goods?action=details&&goodsid=${g.goodsid}&&flag=updates">修改</a>
					
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" class="t">
				<!-- 分页对应的servlet -->
				<jsp:include page="page.jsp">
					<jsp:param value="goods?action=selectitem" name="objectSelect"/>
				</jsp:include>
				<!-- 为了page页面方便使用，这里的参数value必须有?传参数，如果没有值可传，可任意传，如?a=a -->
			</td>
		</tr>
	</table>

</body>
</html>