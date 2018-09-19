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
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-table.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript" src="/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript"
	src="/js/bootstrap-datetimepicker.zh-CN.js"></script>
</head>
<body>
	<div class="route_bg">
		<a>会员管理</a>&nbsp;<i class="glyphicon glyphicon-chevron-right"></i><a>&nbsp;会员申请</a>
	</div>

	<div>
		<table id="viptable">
			<thead style="background-color: #003D79; color: #FFF">
			</thead>
		</table>
	</div>

	<!-- 会员健康详细信息 -->
	<div class="modal fade" id="jkinfoModal" tabindex="-1" role="dialog"
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
							url : "/vip/getvipapplication/"
									+ $("#userId").text(),
							columns : [
									{
										field : "id",
										visible : false,
									},
									{
										field : "userid",
										visible : false,
									},
									{
										field : "username",
										title : "用户名",
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
										field : "sqdate",
										title : "申请日期",
										align : "center",
										valign : "middle",

									},
									{
										title : "健康详情",
										align : "center",
										valign : "middle",
										formatter : function(value, row, index) {
											return '<a href="javascript:void(0);" onclick="healthinfo(\''
													+ row.userId
													+ '\')">[详情]</a>';
										}
									},
									{
										title : "操作",
										align : "center",
										valign : "middle",
										formatter : function operate(value,
												row, index) {
											return '<button type="button" class="btn btn-default btn-sm" onclick="accept(\''
													+ row.id
													+ '\',\''
													+ row.userid
													+ '\')"> <span class="glyphicon glyphicon-ok"></span> 接受</button>&nbsp<button type="button" class="btn btn-default btn-sm" onclick="refuse(\''
													+ row.id
													+ '\',\''
													+ row.userid+ '\')"><span class="glyphicon glyphicon-remove"></span> 拒绝</button>'
										}
									} ],

						})
		function healthinfo(id) {		
					$.ajax({
						url : "/vip/getuserhealthinfo/" + id,
						async : false,
						success : function(data) {
							if (data.status == 200) {
								$("#jkinfoModal #username").val(
										data.data.username);
								$("#jkinfoModal #height").val(
										data.data.height + "cm");
								$("#jkinfoModal #weight").val(
										data.data.weight + "kg");
								$("#jkinfoModal #dietprefe").val(
										data.data.dietprefe);
								$("#jkinfoModal #notlikefoods").val(
										data.data.notlikefoods);
								$("#jkinfoModal #healstatus").val(
										data.data.healstatus);
								$("#jkinfoModal #medhis")
										.val(data.data.medhis);
								$("#jkinfoModal #senfoods").val(
										data.data.senfoods);
								$("#jkinfoModal").modal();
							} else
								alert("查看失败!");
						}
					})
		}
		function accept(id,userid){
			isAccept = window.confirm("确定接受该会员申请？");
			if (isAccept == true) {		
				$.ajax({
					url : "/vip/updatevipapplication/",
					data:{
						id:id,
						sqStatus:"1",
						uid:userid,
						nid:$("#userId").text(),
						updatedTime:getcurrenttime(),
					},
					async : false,
					type:"post",
					success : function(data) {	
						if(data.status==200){						
							$("#viptable").bootstrapTable('removeByUniqueId',parseInt(id));
							alert(data.msg);
						}
						else
							alert(data.msg);
					}
				});				
			}		
		}
		function refuse(id,userid){
			isRefuse = window.confirm("确定拒绝该会员申请？");
			if(isRefuse==true){
				$.ajax({
					url : "/vip/updatevipapplication",
					data:{
						id:id,
						sqStatus:"0",
						uid:userid,
						nid:$("#userId").text(),
						updatedTime:getcurrenttime(),					
					},
					async : false,
					type:"post",
					success : function(data) {						
						if(data.status==200){
							$("#viptable").bootstrapTable('remove', {
								field : 'id',
								values : [ parseInt(id) ]
							});
							alert(data.msg);
						} 	
						else
							alert(data.msg);   						
					}
				});				
			}			
		}
		/*获取当前时间*/
		function getcurrenttime() {
			var date = new Date();
			var year = date.getFullYear();
			var month = date.getMonth() + 1;
			var day = date.getDate();
			var hour = date.getHours();
			var minute = date.getMinutes();
			var second = date.getSeconds();
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
			var currentDate = year + "-" + month + "-" + day + " " + hour + ":"
					+ minute + ":" + second;
			return currentDate;
		}
	</script>

</body>
</html>