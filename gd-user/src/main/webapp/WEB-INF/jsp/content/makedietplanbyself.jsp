<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
    <input id="uid" type="hidden" value="${userinfo.id}">
	<div class="content_right">
		<div class="content_right_title" style="margin-bottom: 20px;margin-top: 10px;">
			<center><span>制定饮食计划</span>
			<span style="margin-left: 10px;"><a href="/nutritionist/nutritionist/showdietplanbyself.html">计划列表</a></span>
			</center>
		</div>
		<div class="content_right_bottom">
			<div style="margin-left: 10px;">

				<!-- 饮食计划表 -->
				<div id="dietplan">
					<div style="width: 45%; float: left;">
						<form class="form-horizontal" role="form">
							<div class="form-group">
								<label class="col-sm-4 control-label">请选择餐饮类别:</label>
								<div class="col-sm-7" style="padding-left: 0;">
									<select class="form-control" id="food1">
										<option value="1">早餐</option>
										<option value="2">午餐</option>
										<option value="3">晚餐</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">请选择食材种类:</label>
								<div class="col-sm-7" style="padding-left: 0;">
									<select class="form-control" id="food2">
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">请选择具体食物:</label>
								<div class="col-sm-7" style="padding-left: 0;">
									<select class="form-control" id="food3">
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">请选择饮食日期:</label>
								<div class="input-group date form_date col-sm-2"
									style="padding-left: 0;">
									<input class="form-control" type="text" placeholder="请选择日期"
										style="width: 165px;" id="foodplandate" readonly="readonly">
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
								<div style="float: left; padding-left: 90px;">
									<button type="button" class="btn btn-primary"
										onclick="saveeverydayfoodplan()" id="savefoodplan"></button>
								</div>
								<div style="float: left; padding-left: 10px;">
									<button type="button" class="btn btn-primary"
										onclick="completediet()" id="completedietplan">完成饮食周期计划</button>
								</div>

							</div>
						</form>
					</div>

					<div style="width: 55%; float: left;">
					<center>
						<div class="btn-group">
							<button type="button" class="btn btn-default" id="foodplanday1"
								onclick="showfoodday1()">第一天</button>
							<button type="button" class="btn btn-default" id="foodplanday2"
								onclick="showfoodday2()">第二天</button>
							<button type="button" class="btn btn-default" id="foodplanday3"
								onclick="showfoodday3()">第三天</button>
							<button type="button" class="btn btn-default" id="foodplanday4"
								onclick="showfoodday4()">第四天</button>
							<button type="button" class="btn btn-default" id="foodplanday5"
								onclick="showfoodday5()">第五天</button>
							<button type="button" class="btn btn-default" id="foodplanday6"
								onclick="showfoodday6()">第六天</button>
							<button type="button" class="btn btn-default" id="foodplanday7"
								onclick="showfoodday7()">第七天</button>
						</div>
                      </center>
						<div id="foodplan1">
							<table id="food1table">
							</table>
						</div>

						<div id="foodplan2" style="display:none;">
							<table id="food2table">
							</table>
						</div>

						<div id="foodplan3" style="display:none;">
							<table id="food3table">
							</table>
						</div>
						<div id="foodplan4" style="display:none;">
							<table id="food4table">
							</table>
						</div>
						<div id="foodplan5" style="display:none;">
							<table id="food5table">
							</table>
						</div>
						<div id="foodplan6" style="display:none;">
							<table id="food6table">
							</table>
						</div>
						<div id="foodplan7" style="display:none;">
							<table id="food7table">
							</table>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
<script type="text/javascript" src="/js/makedietplan.js"></script>
 