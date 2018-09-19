<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专属运动计划</title>
<link rel="shortcut icon" href="/images/favicon.ico" type="image/ico"/>
<link rel="stylesheet" href="/css/common.css">
<link rel="stylesheet" href="/css/userIndex.css">
<link href="/css/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
<link href="/css/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">
<script src="/css/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
<script src="/css/AmazeUI-2.4.2/assets/js/amazeui.js"></script>
<link href="/css/personal.css" rel="stylesheet" type="text/css">
<link href="/css/orstyle.css" rel="stylesheet" type="text/css">
<link href="/css/daohang.css" rel="stylesheet" type="text/css">
<link href="/css/orderfenye.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/js/jquery.cookie.js" charset="utf-8"></script>

<link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/css/bootstrap-table.min.css" type="text/css" media="screen">
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-table.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript" src="/js/userinfo.js"></script>
<script src="/js/loginout.js"></script>
</head>
<body>
	<jsp:include page="commons/top.jsp" />
	<div id="container">
		<jsp:include page="commons/userinfohead.jsp" />
		<div class="clear"></div>
		<div id="content" style="height:auto;">
			<jsp:include page="commons/contentleft.jsp" />
			<jsp:include page="content/showsportplanbynutritionist.jsp" />
		</div>
	</div>
</body>
</html>