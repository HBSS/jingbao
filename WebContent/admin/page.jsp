<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>   
	<title>Insert title here</title>
</head>
<body>
	<c:if test="${requestScope.maxPage > 0}">
	<table>
		<tr>
			<td><a style="text-decoration: none" href="${param.objectSelect}&&page=1">首页</a></td>
			<c:forEach var="x"  begin="2" end="${requestScope.maxPage - 1}">
				<td><a style="text-decoration: none" href="${param.objectSelect}&&page=${x}">第${x}页</a>&nbsp;&nbsp;</td>
			</c:forEach>
			<td><a style="text-decoration: none" href="${param.objectSelect}&&page=${requestScope.maxPage}">末页</a></td>
			<td>共${requestScope.maxPage}页</td>
		</tr>
	</table>
	</c:if>
</body>
</html>