<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息管理</title>
<link rel="shortcut icon" href="/images/favicon.ico" type="image/ico"/>
<link rel="stylesheet" href="/css/userinfomanager_common.css">
<link rel="stylesheet" href="/css/userinfomanager.css">
<link href="/css/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
<link href="/css/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="/css/personal.css" rel="stylesheet" type="text/css">
<link href="/css/orstyle.css" rel="stylesheet" type="text/css">
<link href="/css/daohang.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/js/jquery.cookie.js" charset="utf-8"></script>
<script src="/js/loginout.js"></script>
</head>
</head>
<body>
	<jsp:include page="commons/top.jsp" />
	<div id="container">
		<jsp:include page="commons/header.jsp" />
		<div class="clear"></div>
		<div id="content">
			<jsp:include page="commons/userinfomanager.jsp" />
			<jsp:include page="content/userinfo.jsp" />
		</div>
	</div>
	<script type="text/javascript" src="/js/userinfo.js"></script>
	
</body>
</html>