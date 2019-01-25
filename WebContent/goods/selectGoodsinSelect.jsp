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
<title>查询商品</title>
<style type="text/css">
.t{
	height: 50px;
	width: 290px;
	text-align: center;
}
#ta{
	width: 100%;
	height: 100%;
}
</style>


</head>
<body >
	<table border="1" name="ta" style="border-collapse: collapse;">
		<tr>
			<th class="t">商品ID</th>
			<th class="t">商品名称</th>
			<th class="t">商品类型</th>
			<th class="t">商品库存</th>
			<th class="t">商品描述</th>
			<th class="t">商品图片</th>
			
			
		</tr>
		<c:forEach var="g" items="${requestScope.allgoods }">
			<tr>
				<td class="t">${g.goodsid}</td><!-- id为user类的变量 -->
				<td class="t">${g.goodsname}</td>
				<td class="t">${g.typename}</td>
				<td class="t">${g.left}</td>
				<td class="t">${g.description}</td>
				<td class="t">
				
				<img src="uploadFiles/${g.goodspicture}" width="50" height="50"/>
				

				</td>
				
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" class="t">
				<!-- 分页对应的servlet -->
				<jsp:include page="page.jsp">
					<jsp:param value="goods?action=selectinselect" name="objectSelect"/>
				</jsp:include>
				<!-- 为了page页面方便使用，这里的参数value必须有?传参数，如果没有值可传，可任意传，如?a=a -->
			</td>
		</tr>
	</table>
</body>
</html>