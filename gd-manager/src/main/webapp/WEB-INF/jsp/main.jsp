
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>健康管理系统——系统管理员管理后台</title>
<link rel="stylesheet" href="/css/main.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css"
	media="screen" />
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/jquery.cookie.js"></script>
<script type="text/javascript" src="/js/tendina.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/userinfo.js"></script>
<script type="text/javascript" src="/js/loginout.js"></script>
<script type="text/javascript">
/* 获取当前时间 */
function get_currenttime() {
	var date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	var day = date.getDate();
	var hour = date.getHours();
	var minute = date.getMinutes();
	var second = date.getSeconds();
	var val = date.getDay();
	if (month < 10)
		month = "0" + month;
	if (day < 10)
		day = "0" + day;
	if (hour < 10)
		hour = "0" + hour;
	if (minute < 10)
		minute = "0" + minute;
	if (second < 10)
		second = "0" + second;
	switch (val) {
	case 0:
		val = "星期日";
		break
	case 1:
		val = "星期一";
		break
	case 2:
		val = "星期二";
		break
	case 3:
		val = "星期三";
		break
	case 4:
		val = "星期四";
		break
	case 5:
		val = "星期五";
		break
	case 6:
		val = "星期六";
		break
	}
	var currentDate = year + "-" + month + "-" + day + " " + hour + ":"
			+ minute + ":" + second + " " + val;
	currenttime.innerText = currentDate;
}
setInterval("get_currenttime()", 1000);
</script>
</head>
<body>
	<!--顶部-->
	<div class="layout_top_header">
		<div style="float: left">
			<span
				style="font-size: 16px; line-height: 45px; padding-left: 20px; color: #8d8d8d">健康管理系统——系统管理员管理后台</span>
			<span
				style="font-size: 14px; line-height: 45px; padding-left: 700px; color: #8d8d8d"
				id="currenttime"></span>
		</div>
		<div id="ad_setting" class="ad_setting">
			<a class="ad_setting_a"> <span id="userId" style="display: none">${userinfo.id}</span>
				<span id="user">${userinfo.username}&nbsp;&nbsp;&nbsp;<i
				class="glyphicon glyphicon-off" id="logout"></i></span>
			</a>
		</div>
	</div>
	<!--顶部结束-->
	<!--菜单-->
	<div class="layout_left_menu">
		<ul id="menu">
			<li class="childUlLi" id="sy"><a href="javascript:void(0);"
				target="menuFrame"><i class="glyphicon glyphicon-home"></i>&nbsp;&nbsp;&nbsp;首页</a></li>
			<li class="childUlLi"><a> <i
					class="glyphicon glyphicon-list"></i>&nbsp;&nbsp;&nbsp;用户审核
			</a>
				<ul style="display: none;">
					<li id="shopcheck"><a href="javascript:void(0);"><i
							class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;商家审核</a></li>
					<li id="nutritionistcheck"><a href="javascript:void(0);"><i
							class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;营养师审核</a></li>
					<li id="supervipcheck"><a href="javascript:void(0);"><i
							class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;高级会员审核</a></li>
				</ul></li>

			<li class="childUlLi"><a> <i
					class="glyphicon glyphicon-list"></i>&nbsp;&nbsp;&nbsp;用户管理
			</a>
				<ul style="display: none;">
					<li id="vip"><a href="javascript:void(0);"><i
							class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;普通会员</a></li>
				    <li id="supervip"><a href="javascript:void(0);"><i
							class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;高级会员</a></li>
				    <li id="alluser"><a href="javascript:void(0);"><i
							class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;所有会员</a></li>
					<li id="shop"><a href="javascript:void(0);"><i
							class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;注册商家</a></li>
					<li id="nutritionist"><a href="javascript:void(0);"><i
							class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;注册营养师</a></li>
				</ul></li>

			<li class="childUlLi"><a> <i
					class="glyphicon glyphicon-list"></i>&nbsp;&nbsp;&nbsp;食材管理
			</a>
				<ul style="display: none;">
					<li id="foodinfo"><a href="javascript:void(0);"><i
							class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;食材信息</a></li>					
				</ul></li>
			<li class="childUlLi"><a> <i
					class="glyphicon glyphicon-list"></i>&nbsp;&nbsp;&nbsp;统计管理
			</a>
				<ul style="display: none;">
					<li id="userlogrecord"><a href="javascript:void(0);"><i
							class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;用户登陆记录</a></li>
					<li id="productrecord"><a href="javascript:void(0);"><i
							class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;商品浏览记录</a></li>
					<li id="searchrecord"><a href="javascript:void(0);"><i
							class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;搜索查找记录</a></li>
					<li id="portalrecord"><a href="javascript:void(0);"><i
							class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;首页访问记录</a></li>
					<li id="zxrecord"><a href="javascript:void(0);"><i
							class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;资讯浏览记录</a></li>
				</ul></li>
		</ul>
	</div>
	<!-- 左侧菜单结束 -->
	<!--右侧显示内容-->
	<div id="layout_right_content" class="layout_right_content"></div>
	<!-- 底部 -->
	<div class="layout_footer">
		<p>Copyright © 2016 - 重庆科技学院</p>
	</div>
</body>
<script type="text/javascript">
	$('#menu').tendina()
	$(document).ready(function() {
		
		$.ajax({
			url : "/statistics/statisticspage.html",
			async : false,
			success : function(data) {
				$("#layout_right_content").html(data);
			}
		});
		
		$("#sy").click(function() {
			$.ajax({
				url : "/statistics/statisticspage.html",
				async : false,
				success : function(data) {
					$("#layout_right_content").html(data);
				}
			});
		});
		$("#shopcheck a").click(function() {
			$.ajax({
				url : "/manager/jsp/shopcheck.html",
				async : false,
				success : function(data) {
					$("#layout_right_content").html(data);
				}
			});
		});
		$("#nutritionistcheck a").click(function() {
			$.ajax({
				url : "/manager/jsp/nutritionistcheck.html",
				async : false,
				success : function(data) {
					$("#layout_right_content").html(data);
				}
			})
		})
		$("#supervipcheck a").click(function() {
			$.ajax({
				url : "/manager/jsp/supervipcheck.html",
				async : false,
				success : function(data) {
					$("#layout_right_content").html(data);
				}
			})
		})
		$("#vip a").click(function(){
			$.ajax({
				url :"/user/userlistpage/0.html",
				async:false,
				success:function(data){
					$("#layout_right_content").html(data);
				}
			})
		})
		$("#supervip a").click(function(){
			$.ajax({
				url :"/user/userlistpage/1.html",
				async:false,
				success:function(data){
					$("#layout_right_content").html(data);
				}
			})
		})
		$("#alluser a").click(function(){
			$.ajax({
				url :"/user/userlistpage/2.html",
				async:false,
				success:function(data){
					$("#layout_right_content").html(data);
				}
			})
		})
		$("#shop a").click(function(){
			$.ajax({
				url :"/store/storelistpage.html",
				async:false,
				success:function(data){
					$("#layout_right_content").html(data);
				}
			})
		})
		$("#nutritionist a").click(function(){
			$.ajax({
				url :"/nutritionist/nutritionistlistpage.html",
				async:false,
				success:function(data){
					$("#layout_right_content").html(data);
				}
			})
		})
		$("#foodinfo a").click(function() {
			$.ajax({
				url : "/manager/jsp/showfoodinfo.html",
				async : false,
				success : function(data) {
					$("#layout_right_content").html(data);
				}
			})
		})
		$("#userlogrecord a").click(function() {
			$.ajax({
				url : "/manager/jsp/userlogrecord.html",
				async : false,
				success : function(data) {
					$("#layout_right_content").html(data);
				}
			})
		})
 
		$("#productrecord a").click(function() {
			$.ajax({
				url : "/manager/jsp/productbrowserecord.html",
				async : false,
				success : function(data) {
					$("#layout_right_content").html(data);
				}
			})
		})
		$("#searchrecord a").click(function() {
			$.ajax({
				url : "/manager/jsp/searchrecord.html",
				async : false,
				success : function(data) {
					$("#layout_right_content").html(data);
				}
			})
		})
		$("#portalrecord a").click(function() {
			$.ajax({
				url : "/manager/jsp/portalbrowserecord.html",
				async : false,
				success : function(data) {
					$("#layout_right_content").html(data);
				}
			})
		})
		$("#zxrecord a").click(function() {
			$.ajax({
				url : "/manager/jsp/zxbrowserecord.html",
				async : false,
				success : function(data) {
					$("#layout_right_content").html(data);
				}
			})
		})
			$("#logout").click(function(){
			loginout();
		})
	});
 
</script>
</html>