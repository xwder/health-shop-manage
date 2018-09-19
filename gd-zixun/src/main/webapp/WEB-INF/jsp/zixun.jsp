<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资讯内容</title>
<link rel="shortcut icon" href="/images/favicon.ico" type="image/ico"/>
<meta name="keywords" content="饮食,营养">
<meta name="description"
	content="${zixun.title }">

<link href="/statics/css/reset_new.css" rel="stylesheet" type="text/css" />
<link href="/statics/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/statics/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery.cookie.js" charset="utf-8"></script>
<script type="text/javascript" src="/statics/js/jquery.SuperSlide.js"></script>
<script type="text/javascript" src="/statics/js/index.js"></script>
</head>
<body>

	<jsp:include page="zixun/zxtop.jsp" />
	<div class="warp" style="width: 960px; margin:0 auto;">
		<div>
			<jsp:include page="zixun/topchoose.jsp" />
			<jsp:include page="zixun/zxcontentleft.jsp" />
			<jsp:include page="zixun/zxcontentright.jsp" />
			<jsp:include page="zixun/footer.jsp" />
		</div>

	</div>
	<script type="text/javascript" src="/js/zxuserinfo.js"></script>
</body>
</html>