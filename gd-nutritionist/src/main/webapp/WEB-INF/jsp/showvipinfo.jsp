<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet" href="/css/main.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="/css/bootstrap-table.min.css"
	type="text/css" media="screen">
<link rel="stylesheet" href="/css/bootstrap-datetimepicker.min.css"
	type="text/css" media="screen" />
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-table.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript" src="/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript"
	src="/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="/js/bootstrap-editable.js"></script>
<script type="text/javascript" src="/js/bootstrap-table-editable.js"></script>
<script type="text/javascript" src="/js/showvipinfo.js"></script>
<script type="text/javascript" src="/js/makedietplan.js"></script>
<script type="text/javascript" src="/js/makesportplan.js"></script>
</head>
<body>
	<div class="route_bg">
		<a>会员管理</a>&nbsp;<i class="glyphicon glyphicon-chevron-right"></i><a>&nbsp;显示会员</a>
	</div>


	<div>
		<table id="viptable">
			<thead style="background-color: #003D79; color: #FFF">
			</thead>
		</table>
	</div>

	<!-- 消息提醒模态框  -->
	<div class="modal fade" id="messageModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">添加健康提醒信息</h4>
				</div>
				<div class="modal-body">
					<div class="form-group" style="display: none">
						<input type="text" class="form-control" readonly id="userid">
					</div>
					<div class="form-group">
						<textarea class="form-control" rows="8" id="message"></textarea>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" id="closeModal" class="btn btn-default"
						data-dismiss="modal">关闭</button>
					<button type="button" id="submitInfor" class="btn btn-primary"
						onclick="savemessage()">保存</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 展示会员详细信息模态框 -->
	<div class="modal fade" id="showvipModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">会员健康信息</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="name">姓名</label><input type="text"
							class="form-control" readonly id="username">
					</div>
					<div class="form-group">
						<label for="name">身高</label><input type="text"
							class="form-control" readonly id="height">
					</div>
					<div class="form-group">
						<label for="name">体重</label><input type="text"
							class="form-control" readonly id="weight">
					</div>
					<div class="form-group">
						<label for="name">饮食偏好</label><input type="text"
							class="form-control" readonly id="dietprefe">
					</div>
					<div class="form-group">
						<label for="name">不喜欢的事物</label><input type="text"
							class="form-control" readonly id="notlikefoods">
					</div>
					<div class="form-group">
						<label for="name">健康状况</label><input type="text"
							class="form-control" readonly id="healstatus">
					</div>
					<div class="form-group">
						<label for="name">病史情况</label><input type="text"
							class="form-control" readonly id="medhis">
					</div>
					<div class="form-group">
						<label for="name">过敏食物</label><input type="text"
							class="form-control" readonly id="senfoods">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" id="closeModal" class="btn btn-default"
						data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 制定健康计划模态框 -->
	<div class="modal fade" id="jkplanModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width: 1000px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">健康计划</h4>
				</div>
				<div class="modal-body" style="height: 500px;">
					<!-- 保存会员id -->
					<input id="vipid" style="display: none;">
					<center>
						<div style="margin-bottom: 15px; display: block;">
							<div class="btn-group">
								<button type="button" class="btn btn-default" id="diet"
									onclick="showdietplan()">饮食计划</button>
								<button type="button" class="btn btn-default" id="sport"
									onclick="showsportplan()">运动计划</button>
								<button type="button" class="btn btn-default" onclick="">理疗计划</button>
								<button type="button" class="btn btn-default" onclick="">休闲计划</button>
							</div>
						</div>
					</center>
					<!-- 饮食计划表 -->
					<div id="dietplan" style="display: none;">
						<div style="width: 50%; float: left;">
							<form class="form-horizontal" role="form">
								<div class="form-group">
									<label class="col-sm-4 control-label">请选择餐饮类别:</label>
									<div class="col-sm-6" style="padding-left: 0;">
										<select class="form-control" id="food1">
											<option value="1">早餐</option>
											<option value="2">午餐</option>
											<option value="3">晚餐</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-4 control-label">请选择食材种类:</label>
									<div class="col-sm-6" style="padding-left: 0;">
										<select class="form-control" id="food2">
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-4 control-label">请选择具体食物:</label>
									<div class="col-sm-6" style="padding-left: 0;">
										<select class="form-control" id="food3">
										</select>
									</div>
								</div>
								<!-- <div class="form-group">
								<label class="col-sm-4 control-label">请输入参考量(克):</label>
								<div class="col-sm-6" style="padding-left: 0;">
									<input type="text" class="form-control" id="food4" placeholder="请输入参考量">
								</div>
							</div> -->
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

						<div style="width: 50%; float: left;">
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

							<div id="foodplan1">
								<table id="food1table">
								</table>
							</div>

							<div id="foodplan2">
								<table id="food2table">
								</table>
							</div>

							<div id="foodplan3">
								<table id="food3table">
								</table>
							</div>
							<div id="foodplan4">
								<table id="food4table">
								</table>
							</div>
							<div id="foodplan5">
								<table id="food5table">
								</table>
							</div>
							<div id="foodplan6">
								<table id="food6table">
								</table>
							</div>
							<div id="foodplan7">
								<table id="food7table">
								</table>
							</div>
						</div>

						<div style="display: none;" id="foodnutrition">
							<table class="table table-bordered">
								<caption>每100克该食物所含各元素分量</caption>
								<tbody>
									<tr>
										<td>能量(千焦)</td>
										<td id="nengliang"></td>
										<td>水分(克)</td>
										<td id="water"></td>
										<td>蛋白质(克)</td>
										<td id="danbaizhi"></td>
										<td>脂肪(克)</td>
										<td id="zhifang"></td>
									</tr>
									<tr>
										<td>膳食纤维(克)</td>
										<td id="xianwei"></td>
										<td>碳水化合物(克)</td>
										<td id="tanshui"></td>
										<td>维生素A(克)</td>
										<td id="wA"></td>
										<td>维生素B1(克)</td>
										<td id="wB1"></td>
									</tr>
									<tr>
										<td>维生素B2(克)</td>
										<td id="wB2"></td>
										<td>维生素C(克)</td>
										<td id="wC"></td>
										<td>维生素E(克)</td>
										<td id="wE"></td>
										<td>盐酸(克)</td>
										<td id="yansuan"></td>
									</tr>
									<tr>
										<td>钠(克)</td>
										<td id="na"></td>
										<td>钙(克)</td>
										<td id="gai"></td>
										<td>铁(克)</td>
										<td id="tie"></td>
										<td>胆固醇(克)</td>
										<td id="danguchun"></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>


					<!-- 运动计划表 -->
					<div id="sportplan" style="display: none;">
						<div style="width: 50%; float: left;">
							<form class="form-horizontal" role="form">
								<div class="form-group">
									<label class="col-sm-4 control-label">请选择运动项目:</label>
									<div class="col-sm-6" style="padding-left: 0;">
										<select class="form-control" id="sport1">
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-4 control-label">请填写运动说明:</label>
									<div class="col-sm-6" style="padding-left: 0;">
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

						<div style="width: 50%; float: left;">
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
				<div class="modal-footer">
					<button type="button" id="closeModal" class="btn btn-default"
						data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>