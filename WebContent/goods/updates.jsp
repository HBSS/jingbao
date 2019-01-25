<%@ page language="java" import="com.jingbao.dao.BaseDao" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改单个商品</title>
</head>
<body>
	<form action="goods?action=updates" method="post" enctype="multipart/form-data"><!-- 上传表单用 -->
	<table>
		<tr>
		
			<td>商品ID</td>
			<td><input type="text" name="goodsid" value="${requestScope.goods.goodsid }" readonly></td><!-- 产生商品ID -->
			
		</tr>
		
		<tr>
			<td>商品名称</td>
			<td><input type="text" name="goodsname" value="${ requestScope.goods.goodsname}"></td>
		</tr>
		<tr>
			<td>商品类型</td>
			<td>
				<select name="goodstype" >
					<c:forEach var="g" items="${sessionScope.goodstype}">
						<option value="${g.typeid}" <c:if test="${requestScope.goods.goodstype==g.typeid }">selected</c:if>  >${g.typename}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>商品价格</td>
			<td><input type="text" name="goodsprice" value="${requestScope.goods.goodsprice}"></td>
		</tr>
		<tr>
			<td>商品库存</td>
			<td><input type="text" name="left" value="${requestScope.goods.left}"></td>
		</tr>
		<tr>
			<td>商品描述</td>
			<td><input type="text" name="description" value="${requestScope.goods.description}"></td>
		</tr>
		<tr>
			<td >商品图片</td>
			<td>
				<img src="uploadFiles/${requestScope.goods.goodspicture }" width="50" height="50"/>
				<input type="file" name="goodspicture" >
			</td>
			
		</tr>
		<tr>
			<td><input type="submit" value="提交" ></td>
			<td><input type="reset" value="重置" ></td>
		</tr>
	</table>
		
	</form>
</body>
</html>