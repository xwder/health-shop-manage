<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<STYLE type=text/css>
 
A:link {
	COLOR: black; TEXT-DECORATION: none
}
A:visited {
	COLOR: black; TEXT-DECORATION: none
}
A:hover {
	COLOR: #ef9b11; TEXT-DECORATION: underline
}
 
</STYLE>
<body>
	<input id="uid" type="hidden" value="${userinfo.id}">
	<div class="content_right">
				<div class="content_right_title" style="margin-bottom: 20px;margin-top: 10px;">
			<center>
				<span>制定运动计划</span> <span style="margin-left: 10px;"><a
					href="/nutritionist/nutritionist/showsportplanbyself.html">计划列表</a></span>
			</center>
		</div>
		<div class="content_right_bottom">
			<div style="margin-left: 10px;">
				<!-- 运动计划表 -->
				<div id="sportplan">
					<div style="width: 48%; float: left;">
						<form class="form-horizontal" role="form">
							<div class="form-group">
								<label class="col-sm-4 control-label">请选择运动项目:</label>
								<div class="col-sm-7" style="padding-left: 0;">
									<select class="form-control" id="sport1">
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">请填写运动说明:</label>
								<div class="col-sm-7" style="padding-left: 0;">
									<textarea class="form-control" rows="4" id="sportdescribe"></textarea>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">请选择运动日期:</label>
								<div class="input-group date form_date col-sm-2"
									style="padding-left: 0;">
									<input class="form-control" type="text" placeholder="请选择日期"
										style="width: 165px;" id="sportplandate" readonly="readonly">
									<span class="input-group-addon"
										style="background-color: #ffffff"> <span
										class="glyphicon glyphicon-calendar"></span>
									</span> <span class="input-group-addon"
										style="background-color: #ffffff"> <span
										class="glyphicon glyphicon-remove"></span>
									</span>
								</div>
							</div>
							<div class="form-group">
								<div style="float: left; padding-left: 30px;">
									<button type="button" class="btn btn-primary"
										onclick="addsportitem()" id="addsport">添加运动项目</button>
								</div>
								<div style="float: left; padding-left: 10px;">
									<button type="button" class="btn btn-primary"
										onclick="saveeverydaysportplan()" id="savesportplan"></button>
								</div>
								<div style="float: left; padding-left: 10px;">
									<button type="button" class="btn btn-primary"
										onclick="completesport()" id="completesportplan">完成运动周期计划</button>
								</div>

							</div>
						</form>
					</div>
					<div style="width: 52%; float: left;">
						<center>
							<div class="btn-group">
								<button type="button" class="btn btn-default" id="sportplanday1"
									onclick="showsportday1()">第一天</button>
								<button type="button" class="btn btn-default" id="sportplanday2"
									onclick="showsportday2()">第二天</button>
								<button type="button" class="btn btn-default" id="sportplanday3"
									onclick="showsportday3()">第三天</button>
								<button type="button" class="btn btn-default" id="sportplanday4"
									onclick="showsportday4()">第四天</button>
								<button type="button" class="btn btn-default" id="sportplanday5"
									onclick="showsportday5()">第五天</button>
								<button type="button" class="btn btn-default" id="sportplanday6"
									onclick="showsportday6()">第六天</button>
								<button type="button" class="btn btn-default" id="sportplanday7"
									onclick="showsportday7()">第七天</button>
							</div>
						</center>
						<div id="sportplan1">
							<table id="sport1table">
							</table>
						</div>
						<div id="sportplan2">
							<table id="sport2table">
							</table>
						</div>
						<div id="sportplan3">
							<table id="sport3table">
							</table>
						</div>
						<div id="sportplan4">
							<table id="sport4table">
							</table>
						</div>
						<div id="sportplan5">
							<table id="sport5table">
							</table>
						</div>
						<div id="sportplan6">
							<table id="sport6table">
							</table>
						</div>
						<div id="sportplan7">
							<table id="sport7table">
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="/js/makesportplan.js"></script>
</body>
</html>