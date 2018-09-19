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
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-table.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-table-zh-CN.js"></script>
<!-- 配置文件 -->
<script type="text/javascript" charset="utf-8"
	src="/ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" charset="utf-8"
	src="/ueditor/ueditor.all.js"></script>
<!-- 加载语言文件 -->
<script type="text/javascript" charset="utf-8"
	src="/ueditor/lang/zh-cn/zh-cn.js"></script>
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
						<input type="text" class="form-control" id="jiankangzixunid"
							maxlength="10">
					</div>
					<div class="form-group">
						<label for="name">Title</label> <input type="text"
							class="form-control" id="title">
					</div>
					<div class="form-group">
						<label for="name">资讯内容</label>
						<!-- 加载编辑器的容器 -->
						<script id="addcontainer" name="content" type="text/plain"></script>						
						<!-- 实例化编辑器 -->
						<script type="text/javascript">
							var ue1 = UE.getEditor('addcontainer',{
								autoClearinitialContent : false,
								elementPathEnabled : false,
								initialFrameWidth : 558,
								initialFrameHeight : 300
							});
						</script>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" id="closeModal" class="btn btn-default"
						data-dismiss="modal">关闭</button>
					<button type="button" id="submitInfor" class="btn btn-primary"
						onclick="addzixunsaveinfor()">保存</button>
				</div>
			</div>
		</div>
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
						<label for="name">标题</label> <input type="text"
							class="form-control" id="title">
					</div>
					<div class="form-group">
						<label for="name">资讯内容</label>
						<!-- 加载编辑器的容器 -->
						<script id="modifyinfor" name="content" type="text/plain"></script>
						<!-- 实例化编辑器 -->
						<script type="text/javascript">
							var ue2 = UE.getEditor('modifyinfor', {
								autoClearinitialContent : false,
								elementPathEnabled : false,
								initialFrameWidth : 558,
								initialFrameHeight : 300
							});
							/* UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
							UE.Editor.prototype.getActionUrl = function(action) {
								if (action == 'uploadimage'
										|| action == 'uploadscrawl'
										|| action == 'uploadimage') {
									return '/manager/uploaditemimage';
								} else {
									return this._bkGetActionUrl.call(this,
											action);
								}
							} */
						</script>
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
						<div class="form-control" id="infor" style="height:90%;overflow-y:auto;"></div>
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
						pageNumber : 1,
						pageSize : 5,
						pageList : [ 5, 10, 15 ],
						columns : [
								{
									field : "id",
									title : "序号",
									visible : false,
								},
								{
									field : "title",
									title : "标题",
									width : "15%",
									align : "left",
									halign : "center",
									valign : "middle",
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
									title : "创建时间",
									width : "10%",
									align : "center",
									valign : "middle",
									formatter : function formatterdate(value) {
										return value.substr(0, 10);
									}

								},
								{
									field : "updatetime",
									title : "更改时间",
									width : "15%",
									align : "center",
									valign : "middle",

								},
								{
									field : "author",
									title : "作者",
									width : "8%",
									align : "center",
									valign : "middle",
								},
								{
									field : "infortext",
									title : "资讯内容",
									width : "42%",
									align : "left",
									halign : "center",
									valign : "middle",
									formatter : function(value, row, index) {
										if (value != null && value.length > 28) {
											return value.substr(0, 28)
													+ '<a href="javascript:void(0);" onclick="xiangqing(\''
													+ row.id + '\')">[详情]</a>';
										}
										return value;
									}
								},
								{
									field : "operate",
									title : "操作",
									width : "10%",
									align : "center",
									valign : "middle",
									formatter : function operate(value, row,
											index) {
										return '<button type="button" class="btn btn-default btn-sm" onclick="onremove(\''
												+ row.id
												+ '\')"> <span class="glyphicon glyphicon-remove"></button></span>&nbsp<button type="button" class="btn btn-default btn-sm" onclick="modifyzixun(\''
												+ row.id
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
						$("#jktable").bootstrapTable('removeByUniqueId',parseInt(id));
						alert(data.msg);
					} else {
						alert(data.msg);
					}
				}
			});
		}
	};
	/*添加资讯时执行的函数*/
	function addzixun() {
		$("#addModal #title").val("");
		ue1.setContent("");
		$("#addModal").modal();
	};
	/*添加资讯点击保存按钮执行的函数*/
	function addzixunsaveinfor() {
		$.ajax({
			url : "/zixun/addjiankangzixun/",
			data : {
				title : $("#addModal #title").val(),
				infortext : ue1.getContent(),
				author : $("#user").text(),
				createtime : getcurrenttime(),
				updatetime : getcurrenttime(),
			},
			type : 'post',
			async : false,
			success : function(data) {
				if (data.status == 200) {
					$("#addModal").modal('hide'), $("#jktable").bootstrapTable(
							'prepend', data.data);
					alert(data.msg);
				} else {
					$("#addModal").modal('hide'), alert(data.msg);
				}
			}
		});

	};
	/*修改资讯时执行的函数*/
	function modifyzixun(id) {
		$.ajax({
			url : "/zixun/getSingleJiankangzixun/" + id,
			async : false,
			success : function(data) {
				if (data.status == 200) {
					$("#modifyModal #jiankangzixunid").val(data.data.id), $(
							"#modifyModal #title").val(data.data.title), ue2
							.setContent(data.data.infortext), $("#modifyModal")
							.modal();
				} else {
					alert(data.msg);
				}
			}
		})
	};
	/* 修改资讯点击保存按钮执行的函数*/
	function modifyzixunsaveinfor() {
		$.ajax({
			url : "/zixun/modifyjiankangzixun",
			data : {
				id : $("#modifyModal #jiankangzixunid").val(),
				title : $("#modifyModal #title").val(),
				infortext : ue2.getContent(),
				updatetime : getcurrenttime(),
			},
			type : "post",
			async : false,
			success : function(data) {
				if (data.status == 200) {
					$("#modifyModal").modal('hide'), $("#jktable")
							.bootstrapTable('updateByUniqueId', {
								id : $("#modifyModal #jiankangzixunid").val(),
								row : {
									title : $("#modifyModal #title").val(),
									updatetime : data.data.updatetime,
									author : $("#user").text(),
									infortext :ue2.getContent(),
								}
							})
					alert(data.msg);
				} else
					alert(data.msg);
			}
		})
	};
	/*展示资讯的详细信息*/
	function xiangqing(id, infortext) {
		$.ajax({
			url : "/zixun/getSingleJiankangzixun/" + id,
			async : false,
			success : function(data) {
				if (data.status == 200) {
					$("#showzixunModal #jijiezixunid").val(data.data.id), $(
							"#showzixunModal #infor").html(data.data.infortext),
							$("#showzixunModal").modal();
				} else {
					alert(data.msg);
				}
			}
		})
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