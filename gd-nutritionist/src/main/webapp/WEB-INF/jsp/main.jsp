<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>健康管理系统——营养师管理后台</title>
<link rel="stylesheet" href="/css/main.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css" media="screen" />
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
			<span style="font-size: 16px; line-height: 45px; padding-left: 20px; color: #8d8d8d">健康管理系统——营养师管理后台</span>
			<span style="font-size: 14px; line-height: 45px; padding-left: 730px; color: #8d8d8d" id="currenttime"></span>				
		</div>
		<div id="ad_setting" class="ad_setting">
			<a class="ad_setting_a"> <span id="userId" style="display:none">${userinfo.id}</span> <span id="user">${userinfo.username}</span><span><i
				class="glyphicon glyphicon-off" id="logout"></i></span></a>
		</div>
	</div>
	<!--顶部结束-->
	<!--菜单-->
	<div class="layout_left_menu">
		<ul id="menu">
			<li class="childUlLi"><a href="#" target="menuFrame"><i
					class="glyphicon glyphicon-home"></i>&nbsp;&nbsp;&nbsp;首页</a></li>
			<li class="childUlLi"><a> <i
					class="glyphicon glyphicon-list"></i>&nbsp;&nbsp;&nbsp;个人信息管理
			</a>
				<ul style="display: none;">
					<li id="shownutritionistinfo"><a href="javascript:void(0);"><i
							class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;基本信息</a></li>
					
				</ul></li>

			<li class="childUlLi"><a> <i
					class="glyphicon glyphicon-list"></i>&nbsp;&nbsp;&nbsp;健康计划管理
			</a>
				<ul style="display: none;">
					<li id="showhealthplan"><a href="javascript:void(0);"><i
							class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;健康计划记录</a></li>
				</ul></li>

			<li class="childUlLi"><a> <i
					class="glyphicon glyphicon-list"></i>&nbsp;&nbsp;&nbsp;资讯管理
			</a>
				<ul style="display: none;">
					<li id="allzixun"><a href="javascript:void(0);"><i
							class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;全部资讯</a></li>					
				</ul></li>

			<li class="childUlLi"><a> <i
					class="glyphicon glyphicon-list"></i>&nbsp;&nbsp;&nbsp;会员管理
			</a>
				<ul style="display: none;">
				    <li id="vipapplication"><a href="javascript:void(0);"><i
							class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;会员申请</a></li>
					<li id="vipinfo"><a href="javascript:void(0);"><i
							class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;显示会员</a></li>
				</ul></li>
			<li class="childUlLi"><a> <i
					class="glyphicon glyphicon-list"></i>&nbsp;&nbsp;&nbsp;留言管理
			</a>
				<ul style="display: none;">
					<li id="showunreplycomment"><a href="javascript:void(0);"><i
							class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;未回复留言</a></li>
				    <li id="showreplycomment"><a href="javascript:void(0);"><i
							class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;已回复留言</a></li>						
				</ul></li>
		</ul>
	</div>
	<!--菜单-->
	<div id="layout_right_content" class="layout_right_content">	
	</div>
	<div class="layout_footer">
		<p>Copyright © 2016 - 重庆科技学院</p>
	</div>
</body>
<script type="text/javascript">
	$('#menu').tendina()
	$(document).ready(function() {	
		$("#logout").click(function(){
			loginout();
		})
		$("#shownutritionistinfo a").click(function(){
			$.ajax({
				url : "/jsp/personalinfo.html",
				async : false,
				success : function(data) {
					$("#layout_right_content").html(data);
				}
			});
		})		
		$("#showhealthplan a").click(function(){
			$.ajax({
				url : "/jsp/showjiankangplan.html",
				async : false,
				success : function(data) {
					$("#layout_right_content").html(data);
				}
			});
		})
		$("#allzixun a").click(function() {
			$.ajax({
				url : "/jsp/showzixun.html",
				async : false,
				success : function(data) {
					$("#layout_right_content").html(data);
				}
			});
		});		
		$("#vipapplication a").click(function(){
			$.ajax({
				url :"/jsp/showvipapplication.html",
				async:false,
				success:function(data){
					$("#layout_right_content").html(data);
				}
			})
		})
		$("#vipinfo a").click(function(){
			$.ajax({
				url :"/jsp/showvipinfo.html",
				async:false,
				success:function(data){
					$("#layout_right_content").html(data);
				}
			})
		});
		$("#showunreplycomment a").click(function(){
			$.ajax({
				url :"/jsp/showunreplycomment.html",
				async:false,
				success:function(data){
					$("#layout_right_content").html(data);
				}
			})
		})
		$("#showreplycomment a").click(function(){
			$.ajax({
				url :"/jsp/showreplycomment.html",
				async:false,
				success:function(data){
					$("#layout_right_content").html(data);
				}
			})
		})		
	});
</script>
</html>