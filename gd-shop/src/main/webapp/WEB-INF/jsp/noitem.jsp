<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>error</title>
<link rel="shortcut icon" href="/images/favicon.ico" type="image/ico"/>
<link rel="stylesheet" type="text/css" href="/css/normalize.css" />
<script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/js/jquery.cookie.js" charset="utf-8"></script>
<script type="text/javascript" src="/js/jquery.SuperSlide.js"></script>
<script src="/js/common.js" type="text/javascript" charset="utf-8"></script> 
<script type="text/javascript" src="/js/login_register.js"></script>
<script src="/js/loginout.js"></script>
</head>
<body>
	<!-- header start -->
	<jsp:include page="commons/header.jsp" />
	<div id="container">
		<jsp:include page="commons/search.jsp" />
		<div id="content">
			
		</div>
		<div class="clear"></div>
				对不起，${msg }
		<div class="clear"></div>
		<div id="footer"></div>
	</div>
	<script type="text/javascript" src="/js/userinfo.js"></script>
</body>
</html>