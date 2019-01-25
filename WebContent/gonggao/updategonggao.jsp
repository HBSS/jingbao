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
</script>
<style type="text/css">
.t{
	text-align: center;
	width: 400px;
}
</style>
</head>
<body>
	<table>
		<tr>
			<th class="t">公告ID</th>
			<th class="t">公告名称</th>
			<th class="t">操作</th>
		</tr>
		<c:forEach var="g" items="${requestScope.allgonggao }">
			<tr>
				<td class="t">${g.gonggaoid}</td><!-- id为user类的变量 -->
				<td class="t">${g.gonggaoname}</td>
				<td class="t">
					<a href="gonggao?action=detail&&gonggaoid=${g.gonggaoid}&&flag=update">修改</a>
					
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>