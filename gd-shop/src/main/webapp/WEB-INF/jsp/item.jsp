<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${item.pname }</title>
<link rel="shortcut icon" href="/images/favicon.ico" type="image/ico"/>
<link rel="stylesheet" type="text/css" href="/css/normalize.css" />
<link rel="stylesheet" href="/css/layout.css">
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/css/daohang.css">
<link rel="stylesheet" href="/css/itemcomment.css">
<link rel="stylesheet" href="/css/itemlist/zzsc.css" type="text/css">
<script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/js/jquery.cookie.js" charset="utf-8"></script>
<script type="text/javascript" src="/js/jquery.SuperSlide.js"></script>
<script src="/js/common.js" type="text/javascript" charset="utf-8"></script> 
<script type="text/javascript" src="/js/login_register.js"></script>
<script type="text/javascript" src="/js/cart.js"></script>
<script type="text/javascript" src="/js/buynow.js"></script>
<script type="text/javascript" src="/js/changeitemnum.js"></script>
<script type="text/javascript" src="/js/collocation.js"></script>
<script type="text/javascript" src="/js/pcommentfy.js"></script>
<script src="/js/loginout.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var showproduct = {
			"boxid" : "showbox",
			"sumid" : "showsum",
			"boxw" : 300,//宽度,该版本中请把宽高填写成一样
			"boxh" : 300,//高度,该版本中请把宽高填写成一样
			"sumw" : 60,//列表每个宽度,该版本中请把宽高填写成一样
			"sumh" : 60,//列表每个高度,该版本中请把宽高填写成一样
			"sumi" : 7,//列表间隔
			"sums" : 5,//列表显示个数
			"sumsel" : "sel",
			"sumborder" : 1,//列表边框，没有边框填写0，边框在css中修改
			"lastid" : "showlast",
			"nextid" : "shownext"
		};//参数定义	  
		$.ljsGlasses.pcGlasses(showproduct);//方法调用，务必在加载完后执行
		$(".search input.btn_srh").css("width","64px");
		$(".search").css("height","35");
	});
</script>
</head>
<body>
	<!-- header start -->
	<jsp:include page="commons/header.jsp" />
	<div id="container">
		<jsp:include page="commons/search.jsp" />
		<div id="content">
			<jsp:include page="item/itemheader.jsp" />
			<jsp:include page="item/tjdp.jsp" />
			<jsp:include page="item/itemdetail.jsp" />
		</div>
		<div class="clear"></div>

		<div class="clear"></div>
		<div id="footer"></div>
	</div>
	<script type="text/javascript" src="/js/userinfo.js"></script>
</body>
</html>