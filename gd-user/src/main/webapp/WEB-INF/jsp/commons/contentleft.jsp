<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="content_left" style="height:870px;">
		<div class="content_side">
			<div class="content_side_neck">
				<i></i>
			</div>
			<div class="content_ms_side">
				<ul>
					<li class="normal_li"><a
						href="http://localhost:8883/shop/cart.html"> <img
							src="/images/userImages/shopcar1.png" alt=""> 购物车
					</a></li>
					<li class="normal_li"><a href="/user/userinfo.html"> <img
							src="/images/userImages/maila.png" alt="">账号管理
					</a></li>
					<li class="normal_li"><img
						src="/images/userImages/dingdan.png" alt=""> 订单管理</li>
					<li><a href="/user/order.html">我的订单</a></li>
					<li>我的收藏</li>					
						<li id="yys" class="normal_li"><img
							src="/images/userImages/maila.png" alt=""> 营养师</li>
						<li id="yyslist"><a
							href="/nutritionist/nutritionist/nutritionistlist.html">营养师列表</a></li>
						<li id="myyys"><a
							href="/nutritionist/nutritionist/mynutritionist.html">我的营养师</a></li>
						<li id="yyscomment"><a
							href="/nutritionist/nutritionist/uncommentrecord.html">留言记录</a></li>
						<li id="yysmessage"><a
							href="/nutritionist/nutritionist/messageremind.html">消息通知</a></li>				
					<li class="normal_li"><img src="/images/userImages/maila.png"
						alt=""> 我的计划</li>
					<li><a
						href="/nutritionist/nutritionist/makedietplanbyself.html">制定饮食计划</a></li>
					<li><a
						href="/nutritionist/nutritionist/makesportplanbyself.html">制定运动计划</a></li>
					<li><a
						href="/nutritionist/nutritionist/showdietplanbyself.html">查看饮食计划</a></li>
					<li><a
						href="/nutritionist/nutritionist/showsportplanbyself.html">查看运动计划</a></li>

					<li class="normal_li"><img src="/images/userImages/maila.png"
						alt=""> 专属计划</li>
					<c:if test="${userinfo.isVip == 1 }">
						<li><a
							href="/nutritionist/nutritionist/showdietplanbynutritionist.html">专属饮食计划</a></li>
						<li><a
							href="/nutritionist/nutritionist/showsportplanbynutritionist.html">专属运动计划</a></li>
					</c:if>
					<c:if test="${userinfo.isVip != 1 }">
						<li id="specialdietplan"><a href="javascript:void(0);">专属饮食计划</a></li>
						<li id="specialsportplan"><a href="javascript:void(0)">专属运动计划</a></li>
						<script type="text/javascript">
							$("#specialdietplan").click(function() {
								alert("对不起，您不是高级会员，无法使用此服务!");
							})
							$("#specialsportplan").click(function() {
								alert("对不起，您不是高级会员，无法使用此服务!");
							})
						</script>
					</c:if>
					<li class="normal_li"><img
						src="/images/userImages/shouhou .png" alt=""> 售后服务</li>
					<li>退换货</li>
					<li>意见/投诉</li>
				</ul>
			</div>
		</div>
	</div>

</body>
</html>