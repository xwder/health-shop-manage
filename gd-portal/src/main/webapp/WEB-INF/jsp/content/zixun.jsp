<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div id="zixun">
		<!--左侧资讯-->
		<div class='title'>
			<h2>健康资讯</h2>
		</div>
		<div class='content'>
			<ul>
				<c:forEach var="healthinfo" items="${healthinfoList}" begin="0"
					end="6">
					<li><a
						href="http://localhost:8880/zixun/${healthinfo.zxtypename}/<fmt:formatDate value="${healthinfo.createtime}" pattern="yyyy/MM/dd" />/${healthinfo.id}.html">${healthinfo.title}</a></li>
				</c:forEach>
			</ul>
		</div>

		<div class='title'>
			<h2>季节资讯</h2>
		</div>
		<div class='content'>
			<ul>
				<c:forEach items="${seasoninforList}" begin="0" end="5"
					var="seasoninfo">
					<li><a href="http://localhost:8880/zixun/${seasoninfo.zxtypename}/<fmt:formatDate value="${seasoninfo.createtime}" pattern="yyyy/MM/dd" />/${seasoninfo.id}.html">${seasoninfo.title}</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>

</body>
</html>