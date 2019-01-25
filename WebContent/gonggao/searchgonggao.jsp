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
	function deletegonggao(gonggaoid){
		if(window.confirm("真的删除么？")){
			window.location.href="gonggao?action=delete1&&gonggaoid=" + gonggaoid;
			
		}
	}
</script>
</head>
<body>
<table>
	<tr>
	<td>公告ID</td>
	<td>公告名</td>
	<td>公告内容</td>
	<td>操作</td>
	</tr>
	<c:forEach var="g" items="${requestScope.allgonggao }">
			<tr>
				<td>${g.gonggaoid}</td><!-- id为user类的变量 -->
				<td>${g.gonggaoname}</td>
				<td>${g.gonggaocontent}</td>
				<td>
					<a href="gonggao?action=detail&&gonggaoid=${g.gonggaoid}&&flag=update">修改</a>&nbsp;&nbsp;&nbsp;
					<a href="javascript:deletegonggao('${g.gonggaoid}')">删除</a>&nbsp;&nbsp;&nbsp;
					<a href="gonggao?action=detail&&gonggaoid=${g.gonggaoid}" target="blank">详情</a>
				</td>
			</tr>
		</c:forEach>
</table>
</body>
</html>