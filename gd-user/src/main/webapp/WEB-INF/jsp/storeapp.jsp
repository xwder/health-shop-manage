<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="multipart/form-data; charset=utf-8" />
<title>商家申请</title>
<link rel="shortcut icon" href="/images/favicon.ico" type="image/ico"/>
<link rel="stylesheet" href="/css/userinfomanager_common.css">
<link rel="stylesheet" href="/css/userhealth.css">
<link href="/css/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
<link href="/css/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="/css/personal.css" rel="stylesheet" type="text/css">
<link href="/css/orstyle.css" rel="stylesheet" type="text/css">
<link href="/css/city-picker.css" rel="stylesheet">
<link href="/css/main.css" rel="stylesheet">
<link href="/css/daohang.css" rel="stylesheet" type="text/css">
<script src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/jquery.cookie.js"></script>
<script type="text/javascript" src="/js/userapplication/storeapplication.js" charset="utf-8"></script>
<script src="/js/loginout.js"></script>
 
</head>
<body>
	<jsp:include page="commons/top.jsp" />
	<div id="container">
		<jsp:include page="commons/userinfohead.jsp" />
		<div class="clear"></div>
		<div id="content">
			<jsp:include page="commons/userinfomanager.jsp" />
			<jsp:include page="content/userstoreapp.jsp" />
		</div>
	</div>
	<script type="text/javascript" src="/js/userinfo.js"></script>


	<script src="/js/bootstrap.js"></script>
	<script src="/js/city-picker.data.js"></script>
	<script src="/js/city-picker.js"></script>
	<script src="/js/main.js"></script>
</body>
</html>