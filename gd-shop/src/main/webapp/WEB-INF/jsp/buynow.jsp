<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提交订单</title>
<link rel="shortcut icon" href="/images/favicon.ico" type="image/ico"/>
<link rel="stylesheet" type="text/css" href="/css/normalize.css" />
<script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/js/jquery.cookie.js" charset="utf-8"></script>
<script src="/js/common.js" type="text/javascript" charset="utf-8"></script> 
<link href="/css/orstyle.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="/css/cartlayout.css">
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/css/cartdaohang.css">
<link rel="stylesheet" href="/css/order/tasp.css" />
<link href="/css/order/orderconfirm.css" rel="stylesheet" />
<script src="/js/orderconfirm.js" type="text/javascript" charset="utf-8"></script> 
<script src="/js/loginout.js"></script>
</head>
<body>
	<!-- header start -->
	<jsp:include page="commons/header.jsp" />
	<div id="container">
		 
		<div id="content">
			<jsp:include page="order/buynow.jsp" />
		</div>
		<div class="clear"></div>

		<div class="clear"></div>
		<div id="footer"></div>
	</div>
	<script type="text/javascript" src="/js/userinfo.js"></script>
</body>
</html>