<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>showzixun</title>
<link rel="stylesheet" href="/css/main.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="/css/bootstrap-table.min.css"
	type="text/css" media="screen">
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/jquery.cookie.js"></script>
<script type="text/javascript" src="/js/userinfo.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-table.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-table-zh-CN.js"></script>

</head>
<body>
	<div class="route_bg">
		<a>资讯管理</a>&nbsp;<i class="glyphicon glyphicon-chevron-right"></i><a>&nbsp;健康资讯</a>
	</div>
	<div>
		<div id="toolbar">
			<button id="add" onclick="addzixun()" type="button"
				class="btn btn-default">
				<span class="glyphicon glyphicon-plus"></span>新增
			</button>
		</div>
		<table id="jktable">
			<thead style="background-color: #003D79; color: #FFF">
			</thead>
		</table>
	</div>
	<!-- 修改模态框 -->
	<div class="modal fade" id="modifyModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">修改健康资讯</h4>
				</div>
				<div class="modal-body">					
						<div class="form-group" style="display: none">
							<input type="text" class="form-control" id="jiankangzixunid">
						</div>
						<div class="form-group">
							<label for="name">Title</label> <input type="text"
								class="form-control" id="title">
						</div>
						<div class="form-group">
							<label for="name">资讯内容</label>
							<textarea class="form-control" rows="8" id="infor"></textarea>
						</div>					
				</div>
				<div class="modal-footer">
					<button type="button" id="closeModal" class="btn btn-default"
						data-dismiss="modal">关闭</button>
					<button type="button" id="submitInfor" class="btn btn-primary"
						onclick="modifyzixunsaveinfor()">保存修改</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 添加模态框 -->
	<div class="modal fade" id="addModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">新增健康资讯</h4>
				</div>
				<div class="modal-body">				
						<div class="form-group" style="display: none">
							<input type="text" class="form-control" id="jiankangzixunid">
						</div>
						<div class="form-group">
							<label for="name">Title</label> <input type="text"
								class="form-control" id="title">
						</div>
						<div class="form-group">
							<label for="name">资讯内容</label>
							<textarea class="form-control" rows="8" id="infor"></textarea>
						</div>					
				</div>
				<div class="modal-footer">
					<button type="button" id="closeModal" class="btn btn-default"
						data-dismiss="modal">关闭</button>
					<button type="button" id="submitInfor" class="btn btn-primary"
						onclick="addzixunsaveinfor()">保存修改</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 展示资讯详情 -->
	<div class="modal fade" id="showzixunModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">资讯详情</h4>
				</div>
				<div class="modal-body">				
						<div class="form-group" style="display: none">
							<input type="text" class="form-control" id="jiankangzixunid">
						</div>
						<div class="form-group">
							<textarea class="form-control" rows="8" id="infor"></textarea>
						</div>					
				</div>
				<div class="modal-footer">
					<button type="button" id="closeModal" class="btn btn-default"
						data-dismiss="modal">关闭</button>
					<!-- <button type="button" id="submitInfor" class="btn btn-primary"
						onclick="modifyzixunsaveinfor()">保存修改</button> -->
				</div>
			</div>
		</div>
	</div>
</body>
<script>
	$("#jktable")
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
						toolbar : "#toolbar",
						url : "/zixun/getHealthinfos",
						pageNumber: 1,
						pageSize: 5,
					    pageList: [5, 10, 15],					    					    
						columns : [
								{
									field : "id",
									title : "序号",
									visible : false,
								},
								{
									field : "title",
									title : "title",
									width : "15%",
									align : "left",
									halign: "center",
									valign: "middle",
									formatter : function(value, row, index) {
										if (value != null && value.length > 10) {
											return value.substr(0, 9) + "...";
										}
										return value;
									},
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
									field : "createtime",
									title : "createtime",
									width : "10%",
									align : "center",
									valign: "middle",
									formatter : function formatterdate(value) {
										return value.substr(0, 10);
									}

								},
								{
									field : "updatetime",
									title : "updatetime",
									width : "15%",
									align : "center",
									valign: "middle",

								},
								{
									field : "author",
									title : "author",
									width : "5%",
									align : "center",
									valign: "middle",
								},
								{
									field : "infortext",
									title : "infortext",
									width : "45%",
									align : "left",
									halign: "center",
									valign: "middle",
									formatter : function(value, row, index) {
										if (value != null && value.length > 30) {
											return value.substr(0, 30)
													+ '<a href=\"#\" onclick="xiangqing(\''
													+ row.id + '\',\''
													+ row.infortext
													+ '\')">[详情]</a>';
										}
										return value;
									}
								},
								{
									field : "operate",
									title : "operate",
									width : "10%",
									align : "center",
									valign: "middle",
									formatter : function operate(value, row,
											index) {
										return '<button type="button" class="btn btn-default btn-sm" onclick="onremove(\''
												+ row.id
												+ '\')"> <span class="glyphicon glyphicon-remove"></span></button>&nbsp<button type="button" class="btn btn-default btn-sm" onclick="modifyzixun(\''
												+ row.id
												+ '\',\''
												+ row.title
												+ '\',\''
												+ row.infortext
												+ '\')"><span class="glyphicon glyphicon-edit"></span></button>'
									}
								} ],

					})
	/*删除资讯时执行的函数*/
	function onremove(id) {
		isDel = window.confirm("确定删除此条数据？");
		if (isDel == true) {		
			$.ajax({
				url : "/zixun/deljiankangzixun/" + id,
				async : false,
				success : function(data) {
					if (data.status == 200) {
						alert(data.msg);
					} else {
						alert(data.msg);
					}
				}
			});
			$("#jktable").bootstrapTable('remove', {
				field : 'id',
				values : [ parseInt(id) ]
			});
		}
	};
	/*添加资讯时执行的函数*/
	function addzixun() {
		$("#addModal #title").val("");
		$("#addModal #infor").val("")
		$("#addModal").modal();
	};
	/*添加资讯点击保存按钮执行的函数*/
	function addzixunsaveinfor() {
		$.ajax({
			url : "/zixun/addjiankangzixun/",
			data : {
				title : $("#addModal #title").val(),
				infortext : $("#addModal #infor").val(),
				author : $("#user").text(),
				createtime : getcurrenttime(),
				updatetime : getcurrenttime(),
			},
			type : 'post',
			async : false,
			success : function(data) {
				if (data.status == 200) {
					$("#addModal").modal('hide'), alert(data.msg);
					$("#jktable").bootstrapTable('prepend', data.data);
				} else {
					$("#addModal").modal('hide'), alert(data.msg);
				}
			}
		});

	};
	/*修改资讯时执行的函数*/
	function modifyzixun(id, title, infortext) {
		$("#modifyModal #jiankangzixunid").val(id);
		$("#modifyModal #title").val(title);
		$("#modifyModal #infor").val(infortext);
		$("#modifyModal").modal();
	};
	/* 修改资讯点击保存按钮执行的函数*/
	function modifyzixunsaveinfor() {
		$.ajax({
			url : "/zixun/modifyjiankangzixun",
			data : {
				id : $("#modifyModal #jiankangzixunid").val(),
				title : $("#modifyModal #title").val(),
				infortext : $("#modifyModal #infor").val(),
				updatetime : getcurrenttime(),
			},
			type : "post",
			async : false,
			success : function(data) {
				if (data.status == 200) {
					$("#modifyModal").modal('hide'), alert(data.msg), $(
							"#jktable").bootstrapTable('updateByUniqueId', {
						id : $("#modifyModal #jiankangzixunid").val(),
						row : {
							title : $("#modifyModal #title").val(),
							updatetime : data.data.updatetime,
							author : $("#user").text(),
							infortext : $("#modifyModal #infor").val()
						}
					})
				}
			}
		})
	};

	/*展示资讯的详细信息*/
	function xiangqing(id, infortext) {
		$("#showzixunModal #jiankangzixunid").val(id);
		$("#showzixunModal #infor").val(infortext);
		$("#showzixunModal").modal();
	};
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
</html>