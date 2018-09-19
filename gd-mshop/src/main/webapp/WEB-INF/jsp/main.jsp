<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>健康管理系统——商家管理后台</title>
<link rel="stylesheet"
	href="http://118.89.34.94/resourcefile/gd-mshop/css/main.css"
	type="text/css" media="screen" />
<link rel="stylesheet"
	href="http://118.89.34.94/resourcefile/gd-mshop/css/bootstrap.min.css"
	type="text/css" media="screen" />
<script type="text/javascript"
	src="http://118.89.34.94/resourcefile/gd-mshop/js/jquery.js"></script>
<script type="text/javascript" src="/js/jquery.cookie.js"></script>
<script type="text/javascript"
	src="http://118.89.34.94/resourcefile/gd-mshop/js/tendina.js"></script>
<script type="text/javascript"
	src="http://118.89.34.94/resourcefile/gd-mshop/js/bootstrap.min.js"></script>
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
	<div>
		<div>
			<!--顶部-->
			<div class="layout_top_header">
				<div style="float: left">
					<span
						style="font-size: 16px; line-height: 45px; padding-left: 20px; color: #8d8d8d">健康管理系统——商家管理后台</span>
					<span
						style="font-size: 14px; line-height: 45px; padding-left: 730px; color: #8d8d8d"
						id="currenttime"></span>
				</div>
				<div id="ad_setting" class="ad_setting">
					<a class="ad_setting_a"> <span id="userId"
						style="display: none">${userinfo.id}</span> <span id="user">${userinfo.username}</span><span><i
							class="glyphicon glyphicon-off" id="logout"></i></span></a>
				</div>
			</div>
			<!--顶部结束-->
			<div>
				<!--菜单-->
				<div class="layout_left_menu">
					<ul id="menu">
						<li id="sy" class="childUlLi"><a href="javascript:void(0);"
							target="menuFrame"> <i class="glyphicon glyphicon-home"></i>
								&nbsp;&nbsp;&nbsp;首页
							</a>
						</li>
						<li class="childUlLi">
							<a> <i class="glyphicon glyphicon-list"></i>&nbsp;&nbsp;&nbsp;信息管理 </a>
							<ul style="display: none;">
								<li id="userinfo"><a href="javascript:void(0);"><i
										class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;个人信息管理</a></li>
								<li id="storeinfo"><a href="javascript:void(0);"><i
										class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;商家信息管理</a></li>
								<li id="loginlog"><a href="javascript:void(0);"><i
										class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;登录记录</a></li>
								<li id="changepswd"><a href="javascript:void(0);"><i
										class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;修改密码</a></li>
							</ul></li>
						<li class="childUlLi"><a> <i
								class="glyphicon glyphicon-list"></i>&nbsp;&nbsp;&nbsp;订单处理
						</a>
							<ul style="display: none;">
								<li id="allorder"><a href="javascript:void(0);"><i
										class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;全部订单</a></li>
								<li id="waitorder"><a href="javascript:void(0);"><i
										class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;待处理订单</a></li>
								<li id="jjorder"><a href="javascript:void(0);"><i
										class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;拒接单订单</a></li>
								<li id="yjdorder"><a href="javascript:void(0);"><i
										class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;已接单订单</a></li>
								<li id="dpsorder"><a href="javascript:void(0);"><i
										class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;已收货订单</a></li>
								<li id="wcorder"><a href="javascript:void(0);"><i
										class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;已完成订单</a></li>
							</ul></li>

						<li class="childUlLi"><a> <i
								class="glyphicon glyphicon-list"></i>&nbsp;&nbsp;&nbsp;商品管理
						</a>
							<ul style="display: none;">
								<li id="itemlist"><a href="javascript:void(0);"><i
										class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;所有商品列表</a></li>
								<li id="shangjiaitemlist"><a href="javascript:void(0);"><i
										class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;上架商品列表</a></li>
								<li id="xiajiaitemlist"><a href="javascript:void(0);"><i
										class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;下架商品列表</a></li>
								<li id="additem"><a href="javascript:void(0);"><i
										class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;添加商品</a></li>
							</ul>
						</li>

					 
						<li class="childUlLi">
							<a> <i class="glyphicon glyphicon-list"></i>&nbsp;&nbsp;&nbsp;统计管理 </a>
							<ul style="display: none;">
								<li id="pbrowselist"><a href="javascript:void(0);"><i
										class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;商品浏览</a></li>
								<li id=""><a href="javascript:void(0);"><i
										class="glyphicon glyphicon-chevron-right"></i>&nbsp;&nbsp;&nbsp;订单统计</a></li>
							</ul>
						</li>
					</ul>
				</div>
				<!-- 左侧菜单结束 -->
				<!--右侧显示内容-->
				<div id="layout_right_content" class="layout_right_content">

					<iframe src="/manager/statistics/main" id="con" style="width: 100%;height: 800px;"
						frameborder="no" border="0" marginwidth="0" scrolling="yes"
						allowtransparency="yes"> </iframe>
				</div>

			
			<!-- 底部 -->
			<!-- <div class="layout_footer">
				<p>Copyright © 2016 - 重庆科技学院</p>
			</div> -->
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$("#sy").click(function() {
		$("#con").attr("src", " /manager/statistics/main");
	});

	$("#userinfo a").click(function() {
		$("#con").attr("src", "/manager/user/userinfo.html");
	});
	$("#storeinfo a").click(function() {
		$("#con").attr("src", "/manager/store/storeinfo.html");
	});
	$("#loginlog a").click(function() {
		$("#con").attr("src", "/manager/user/loginrecordpage.html");
	});
	$("#changepswd a").click(function() {
		$("#con").attr("src", "/manager/user/changepwpage.html");
	});
	
	$("#allorder a").click(function() {
		$("#con").attr("src", "/manager/order/orderlist/0.html");
	});
	$("#waitorder a").click(function() {
		$("#con").attr("src", "/manager/order/orderlist/1.html");
	});
	$("#jjorder a").click(function() {
		$("#con").attr("src", "/manager/order/orderlist/2.html");
	});

	$("#yjdorder a").click(function() {
		$("#con").attr("src", "/manager/order/orderlist/3.html");
	});

	$("#dpsorder a").click(function() {
		$("#con").attr("src", "/manager/order/orderlist/4.html");
	});

	$("#wcorder a").click(function() {
		$("#con").attr("src", "/manager/order/orderlist/5.html");
	});

	$("#itemlist a").click(function() {
		$("#con").attr("src", "/manager/item/itemlistpage.html");
	})
	$("#additem a").click(function() {
		$("#con").attr("src", "/manager/item/addpage.html");
	})
 
	$("#shangjiaitemlist a").click(function() {
		$("#con").attr("src", "/manager/item/itemliststatuspage/1.html");
	})
	
	$("#xiajiaitemlist a").click(function() {
		$("#con").attr("src", "/manager/item/itemliststatuspage/0.html");
	})
	
	$("#pbrowselist a").click(function() {
		$("#con").attr("src", "/manager/record/pbrowsepage.html");
	})
	$(document).ready(function() {
		$('#menu').tendina();
	});
</script>
</html>