<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>健康购</title>
<link rel="shortcut icon" href="/images/favicon.ico" type="image/ico"/>
<link rel="stylesheet" href="/css/layout.css">
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/css/daohang.css">
<link rel="stylesheet" href="/css/lb/indexlunbo.css">
<script src="/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/js/login_register.js"></script>
<script type="text/javascript" src="/js/jquery.cookie.js" charset="utf-8"></script>
<script type="text/javascript" src="/js/jquery.flexslider-min.js"></script>
<script src="/js/jquery.flexslider-min.js"></script>
<script src="/js/jquery.SuperSlide.js"></script>
<script src="/js/loginout.js"></script>

</head>
<body>
	<!-- header start -->
	<jsp:include page="commons/header.jsp" />
	<div id="container">
	<jsp:include page="commons/search.jsp" />
		<div id="content">
			<jsp:include page="content/zixun.jsp" />
			<jsp:include page="content/lunbo.jsp" />
			<jsp:include page="content/userright.jsp" />
		</div>
		<div class="clear"></div>
		<jsp:include page="content/category.jsp" />
		<div class="clear"></div>
		<div id="footer"></div>
	</div>
	<jsp:include page="commons/footer.jsp" />


</body>

<script type="text/javascript" src="/js/userinfo.js"></script>
<script>
	$(window).load(function() {
		$('.flexslider').flexslider({
			directionNav : false,
			pauseOnAction : false
		});
	});
</script>
</html>