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
<title>添加商品</title>
</head>
<body>
	<form action="goods?action=add" method="post" enctype="multipart/form-data"><!-- 上传表单用 -->
	<table>
		<tr>
		
			<td>商品ID</td>
			<td><input type="text" name="goodsid" value="<%=BaseDao.getStringID() %>" readonly></td><!-- 产生商品ID -->
			
		</tr>
		
		<tr>
			<td>商品名称</td>
			<td><input type="text" name="goodsname" ></td>
		</tr>
		<tr>
			<td>商品类型</td>
			<td>
				<select name="goodstype">
					<c:forEach var="g" items="${sessionScope.goodstype}">
						<option value="${g.typeid}">${g.typename}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>商品价格</td>
			<td><input type="text" name="goodsprice" ></td>
		</tr>
		<tr>
			<td rowspan="5">商品图片</td>
			<td><input type="file" name="goodspicture" ></td>
		</tr>
		<tr>
			
			<td><input type="file" name="goodspicture1" ></td>
		</tr>
		<tr>
			
			<td><input type="file" name="goodspicture2" ></td>
		</tr>
		<tr>
			
			<td><input type="file" name="goodspicture3" ></td>
		</tr>
		<tr>
			
			<td><input type="file" name="goodspicture4" ></td>
		</tr>
		<tr>
			<td>商品库存</td>
			<td><input type="text"" name="left" ></td>
		</tr>
		<tr>
			<td>商品描述</td>
			<td><input type="textarea" rows=10 name="description" ></td>
		</tr>
		<tr>
			<td><input type="submit" value="提交" ></td>
			<td><input type="reset" value="重置" ></td>
		</tr>
	</table>
		
	</form>
</body>
</html>