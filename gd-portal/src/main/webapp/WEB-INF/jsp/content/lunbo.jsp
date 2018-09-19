<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/lb/common.css" />
<link rel="stylesheet" href="/css/lb/jd.css" />
</head>
<body>
	<div id="lunbotu">
		<div id="lbzx">
			<div class="flexslider">
				<ul class="slides">
					<c:forEach var="spCarouse" items="${spCarouseList}">
						<li ><a href="${spCarouse.url}"><img alt="" src="${spCarouse.purl}" style="width:100%;height:100%;"></a></li>
					</c:forEach>
				</ul>
			</div>
		</div>

		<div id="lbzx">
			<div id="jdAdSlide" class="jd_ad_slide" style="margin-top: 20px;">
					<c:forEach var="zxCarouse" items="${ziXunCarouseList}">
						<a href="${zxCarouse.url }"><img alt="" src="${zxCarouse.purl}" style="width:100%;height:100%;" class="jd_ad_img"></a>
					</c:forEach>
             <div id="jdAdBtn" class="jd_ad_btn"></div>
			</div>
		</div>
	</div>
	
<script src="/js/lb/jquery-powerSwitch.js"></script>
<script>
// 大的图片广告
// 根据图片创建id,按钮元素等，实际开发建议使用JSON数据类似
var htmlAdBtn = '';
$("#jdAdSlide img").each(function(index, image) {
	var id = "adImage" + index;
	htmlAdBtn = htmlAdBtn + '<a href="javascript:" class="jd_ad_btn_a" data-rel="'+ id +'">'+ (index + 1) +'</a>';
	image.id = id;
});
$("#jdAdBtn").html(htmlAdBtn).find("a").powerSwitch({
	eventType: "hover",
	classAdd: "active",
	animation: "fade",
	autoTime: 5000,
	onSwitch: function(image) {
		if (!image.attr("src")) {
			image.attr("src", image.attr("data-src"));	
		}
	}
}).eq(0).trigger("mouseover");

// 便民服务
$("#servNav a").powerSwitch({
	classAdd: "active",
	eventType: "hover",
	onSwitch: function() {
		$("#pointLine").animate({ "left": $(this).position().left}, 200);
	}
});
</script>
</body>
</html>