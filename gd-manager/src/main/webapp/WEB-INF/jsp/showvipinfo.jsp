<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/css/main.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="/css/bootstrap-table.min.css"
	type="text/css" media="screen">
<link rel="stylesheet" href="/css/bootstrap-datetimepicker.min.css"
	type="text/css" media="screen" />
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/jquery.cookie.js"></script>
<script type="text/javascript" src="/js/userinfo.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-table.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript" src="/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript"
	src="/js/bootstrap-datetimepicker.zh-CN.js"></script>
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
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">健康计划</h4>
				</div>
				<div class="modal-body">
					<center>
						<div class="btn-group" style="margin-bottom: 15px;">
							<button type="button" class="btn btn-default"
								onclick="showdietpian()">饮食计划</button>
							<button type="button" class="btn btn-default"
								onclick="showsportplan()">运动计划</button>
							<button type="button" class="btn btn-default" onclick="">理疗计划</button>
							<button type="button" class="btn btn-default" onclick="">休闲计划</button>
						</div>
					</center>
					<!-- 饮食计划表 -->
					<div id="dietplan" style="display: none">
						<form class="form-horizontal" role="form">
							<div class="form-group">
								<label class="col-sm-2 control-label">早餐:</label>
								<div class="col-sm-7" style="padding-right: 0;">
									<input type="text" class="form-control" id="breakfast"
										placeholder="请输入食物">
								</div>
								<div class="col-sm-3" style="padding-left: 0;">
									<select class="form-control" id="food1">
										<option>请选择</option>
										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
										<option>5</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">午餐:</label>
								<div class="col-sm-7" style="padding-right: 0;">
									<input type="text" class="form-control" id="lunch"
										placeholder="请输入食物">
								</div>
								<div class="col-sm-3" style="padding-left: 0;">
									<select class="form-control" id="food2">
										<option>请选择</option>
										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
										<option>5</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">晚餐:</label>
								<div class="col-sm-7" style="padding-right: 0;">
									<input type="text" class="form-control" id="dinner"
										placeholder="请输入食物">
								</div>
								<div class="col-sm-3" style="padding-left: 0;">
									<select class="form-control" id="food3">
										<option>请选择</option>
										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
										<option>5</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">选择日期:</label>
								<div class="input-group date form_date col-md-8"
									style="margin-left: 112px;">
									<input class="form-control" type="text" placeholder="请选择日期"
										style="width: 328px;"> <span class="input-group-addon"
										style="background-color: #ffffff"><span
										class="glyphicon glyphicon-remove"></span></span> <span
										class="input-group-addon" style="background-color: #ffffff"><span
										class="glyphicon glyphicon-calendar"></span></span>
								</div>
							</div>
						</form>
					</div>
					
				    <!-- 运动计划表 -->
				    <div id="sportplan" style="display:none;">
				       
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
<script>
	$("#viptable")
			.bootstrapTable(
					{
						idField : "id",
						uniqueId : "id",
						pagination : true,
						striped : true,
						search : true,
						showRefresh : true,
						cache : false,
						height : 500,
						pageNumber : 1,
						pageSize : 5,
						pageList : [ 5, 10, 15 ],
						url : "/vip/getvipinfo/" + $("#userId").text(),
						columns : [
								{
									field : "id",
									visible : false,
								},
								{
									field : "image",
									title : "photo",
									align : "center",
									valign : "middle",
									formatter : function(value) {
										return '<img src=\''+value+'\' height="30px" width="30px"><img>';
									}
								},
								{
									field : "name",
									title : "name",
									align : "center",
									valign : "middle",
									cellStyle : function(value, row, index,
											field) {
										return {
											css : {
												"color" : "#2c87f0"
											}
										}
									},
								},
								{
									field : "sex",
									title : "sex",
									align : "center",
									valign : "middle",
									formatter : function(value) {
										if (value == "1")
											return "男"
										return "女"
									}

								},
								{
									field : "phone",
									title : "phone",
									align : "center",
									valign : "middle",

								},
								{
									field : "email",
									title : "email",
									align : "center",
									valign : "middle",
								},
								{
									field : "operate",
									title : "operate",
									align : "center",
									valign : "middle",
									formatter : function operate(value, row,
											index) {
										return '<button type="button" class="btn btn-default btn-sm" onclick="healthinfo(\''
												+ row.id
												+ '\')"> <span class="glyphicon glyphicon-align-justify"></span> 健康信息</button>&nbsp<button type="button" class="btn btn-default btn-sm" onclick="modifyhealthplan(\''
												+ row.id
												+ '\')"><span class="glyphicon glyphicon-edit"></span> 健康请求</button>&nbsp<button type="button" class="btn btn-default btn-sm" onclick="addhealthplan(\''
												+ row.id
												+ '\')"><span class="glyphicon glyphicon-plus"></span> 健康计划</button>&nbsp<button type="button" class="btn btn-default btn-sm" onclick="addhealthplan(\''
												+ row.id
												+ '\')"><span class="glyphicon glyphicon-plus"></span> 留言</button>'
									}
								} ],

					})
	$('.form_date').datetimepicker({
		language : 'zh-CN',
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		minView : 2,
		forceParse : 0,
		format : 'yyyy-mm-dd',
	});

	function healthinfo(id) {
		$.ajax({
			url : "/vip/getuserhealthinfo/" + id,
			async : false,
			success : function(data) {
				if (data.status == 200) {
					$("#showvipModal #username").val(data.data.username);
					$("#showvipModal #height").val(data.data.height + "cm");
					$("#showvipModal #weight").val(data.data.weight + "kg");
					$("#showvipModal #dietprefe").val(data.data.dietprefe);
					$("#showvipModal #notlikefoods")
							.val(data.data.notlikefoods);
					$("#showvipModal #healstatus").val(data.data.healstatus);
					$("#showvipModal #medhis").val(data.data.medhis);
					$("#showvipModal #senfoods").val(data.data.senfoods);
					$("#showvipModal").modal();
				} else
					alert("查看失败!");
			}
		})
	}
	function modifyhealthplan(id) {

	}
	function addhealthplan(id) {
		
		$("#jkplanModal").modal();

	}
	function showdietpian() {
		$("#dietplan").show();
	}
	$(function() {
		$("#food1").change(
				function() {
					var breakfast = $("#breakfast").val().split(" ");
					if ($("#food1").find("option:selected").text() != "请选择") {
						if ($.inArray($("#food1").find("option:selected")
								.text(), breakfast) < 0) {
							$("#breakfast").val(
									$("#breakfast").val()
											+ " "
											+ $("#food1").find(
													"option:selected").text());
						} else {
							alert("您已经选择过了!");
						}
					}
				})
		$("#food2").change(
				function() {
					var lunch = $("#lunch").val().split(" ");
					if ($("#food2").find("option:selected").text() != "请选择") {
						if ($.inArray($("#food2").find("option:selected")
								.text(), lunch) < 0) {
							$("#lunch").val(
									$("#lunch").val()
											+ " "
											+ $("#food2").find(
													"option:selected").text());
						} else {
							alert("您已经选择过了!");
						}
					}
				})
		$("#food3").change(
				function() {
					var dinner = $("#dinner").val().split(" ");
					if ($("#food3").find("option:selected").text() != "请选择") {
						if ($.inArray($("#food3").find("option:selected")
								.text(), dinner) < 0) {
							$("#dinner").val(
									$("#dinner").val()
											+ " "
											+ $("#food3").find(
													"option:selected").text());
						} else {
							alert("您已经选择过了!");
						}
					}
				})	
	})
</script>
</html>