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
<link rel="stylesheet" href="/css/bootstrap-editable.css" type="text/css" media="screen">
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-table.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript" src="/js/bootstrap-editable.js"></script>
<script type="text/javascript" src="/js/bootstrap-table-editable.js"></script>
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
			<div style="float:left;">
				<button id="add" onclick="addzixun()" type="button"
					class="btn btn-default">
					<span class="glyphicon glyphicon-plus"></span>新增
				</button>
			</div>
			<div style="float:left;padding-left:10px;">
				<select class="form-control" id="zxtype">
				</select>
			</div>
		</div>
	</div>
	<table id="zixuntable">
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
					<h4 class="modal-title" id="myModalLabel">新增资讯</h4>
				</div>
				<div class="modal-body">
					<div class="form-group" style="display: none">
						<input type="text" class="form-control" id="zixunid">
					</div>
					<div class="form-group">
						<label for="name">Title</label> <input type="text"
							class="form-control" id="title" maxlength="10" placeholder="资讯标题最多可输入10个中英文字符">
					</div>
					<div class="form-group">
						<label for="name">资讯内容</label>
						<!-- 加载编辑器的容器 -->
						<script id="addcontainer" name="content" type="text/plain"></script>
						<!-- 实例化编辑器 -->
						<script type="text/javascript">
							var ue1 = UE.getEditor('addcontainer', {
								autoClearinitialContent : false,
								elementPathEnabled : false,
								initialFrameWidth : 558,
								initialFrameHeight : 300,
								toolbars: [
								           [
								               'undo', //撤销
								               'redo', //重做
								               'bold', //加粗
								               'indent', //首行缩进								              
								               'italic', //斜体
								               'underline', //下划线
								               'strikethrough', //删除线
								               'subscript', //下标
								               'superscript', //上标
								               'formatmatch', //格式刷
								               'source', //源代码
								               'blockquote', //引用
								               'pasteplain', //纯文本粘贴模式
								               'selectall', //全选
								               'print', //打印
								               'preview', //预览
								               'horizontal', //分隔线
								               'removeformat', //清除格式
								               'time', //时间
								               'date', //日期
								               'unlink', //取消链接								               								        								          
								               'cleardoc', //清空文档								               
								               'fontfamily', //字体
								               'fontsize', //字号
								               'paragraph', //段落格式
								               'simpleupload', //单图上传
								               'insertimage', //多图上传								              
								               'link', //超链接
								               'emotion', //表情
								               'spechars', //特殊字符
								               'searchreplace', //查询替换								              
								               'justifyleft', //居左对齐
								               'justifyright', //居右对齐
								               'justifycenter', //居中对齐
								               'justifyjustify', //两端对齐
								               'forecolor', //字体颜色
								               'backcolor', //背景色								               								               
								               'rowspacingtop', //段前距
								               'rowspacingbottom', //段后距
								               'imagenone', //默认
								               'imageleft', //左浮动
								               'imageright', //右浮动
								               'imagecenter', //居中
								               'wordimage', //图片转存
								               'lineheight', //行间距
								               'edittip ', //编辑提示
								               'customstyle', //自定义标题
								               'autotypeset', //自动排版								           
								               'touppercase', //字母大写
								               'tolowercase', //字母小写
								               'background', //背景							             
								           ]
								       ]
							});
							UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
							UE.Editor.prototype.getActionUrl = function(action) {
								if (action == 'uploadimage'
										|| action == 'uploadscrawl'
										|| action == 'uploadimage') {
									return '/manager/uploaditemimage';
								} else {
									return this._bkGetActionUrl.call(this,
											action);
								}
							}
						</script>
					</div>
					<div class="form-group">
						<label for="name">资讯类型</label> <select class="form-control"
							id="zxtype">							
						</select>
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
						<input type="text" class="form-control" id="zixunid">
					</div>
					<div class="form-group">
						<label for="name">标题</label> <input type="text"
							class="form-control" id="title" maxlength="10" placeholder="资讯标题最多可输入10个中英文字符">
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
								initialFrameHeight : 300,
								toolbars: [
								           [
								               'undo', //撤销
								               'redo', //重做
								               'bold', //加粗
								               'indent', //首行缩进								              
								               'italic', //斜体
								               'underline', //下划线
								               'strikethrough', //删除线
								               'subscript', //下标
								               'superscript', //上标
								               'formatmatch', //格式刷
								               'source', //源代码
								               'blockquote', //引用
								               'pasteplain', //纯文本粘贴模式
								               'selectall', //全选
								               'print', //打印
								               'preview', //预览
								               'horizontal', //分隔线
								               'removeformat', //清除格式
								               'time', //时间
								               'date', //日期
								               'unlink', //取消链接								               								        								          
								               'cleardoc', //清空文档								               
								               'fontfamily', //字体
								               'fontsize', //字号
								               'paragraph', //段落格式
								               'simpleupload', //单图上传
								               'insertimage', //多图上传								              
								               'link', //超链接
								               'emotion', //表情
								               'spechars', //特殊字符
								               'searchreplace', //查询替换								              
								               'justifyleft', //居左对齐
								               'justifyright', //居右对齐
								               'justifycenter', //居中对齐
								               'justifyjustify', //两端对齐
								               'forecolor', //字体颜色
								               'backcolor', //背景色								               								               
								               'rowspacingtop', //段前距
								               'rowspacingbottom', //段后距
								               'imagenone', //默认
								               'imageleft', //左浮动
								               'imageright', //右浮动
								               'imagecenter', //居中
								               'wordimage', //图片转存
								               'lineheight', //行间距
								               'edittip ', //编辑提示
								               'customstyle', //自定义标题
								               'autotypeset', //自动排版								           
								               'touppercase', //字母大写
								               'tolowercase', //字母小写
								               'background', //背景							             
								           ]
								       ]
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
						<input type="text" class="form-control" id="zixunid">
					</div>
					<div class="form-group">
						<div class="form-control" id="infor"
							style="height: 90%; overflow-y: auto;"></div>
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
$('#addModal').on('hidden.bs.modal', function () {
    ue1.getEditor('addcontainer').destroy();
});
$('#modifyModal').on('hidden.bs.modal', function () {
    ue2.getEditor('modifyinfor').destroy();
});

	$("#zixuntable")
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
						url : "/zixun/getzixuninfos/1/100000/"+$("#user").text(),
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
									width : "16%",
									align : "center",
									halign : "center",
									valign : "middle",									
									editable: {
					                    type: 'text',
					                    title: '资讯标题',
					                    placement:'right',
					                    validate: function (v) {
					                    	if (!v) return '资讯标题不能为空!';
					                    	if (v.length>10) return '标题长度不能超过10个中英文字符!';
					                    },
									}
								},
								{
									field : "createtime",
									title : "创建时间",
									width : "10%",
									align : "center",
									halign : "center",
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
									halign : "center",
									valign : "middle",

								},
								{
									field : "author",
									title : "作者",
									width : "5%",
									align : "center",
									halign : "center",
									valign : "middle",
								},
								{
									field : "infortext",
									title : "资讯内容",
									width : "38%",
									align : "left",
									halign : "center",
									valign : "middle",
									formatter : function(value, row, index) {
										if (value != null && value.length > 25) {
											return value.substr(0, 25)
													+ '<a href="javascript:void(0);" onclick="xiangqing(\''
													+ row.id + '\')">[详情]</a>';
										}
										return value;
									}
								},
								{
									field : "zxtypename",
									title : "类型",
									width : "7%",
									align : "center",
									halign : "center",
									valign : "middle",
								},
								{
									field : "operate",
									title : "操作",
									width : "9%",
									align : "center",
									halign : "center",
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
								onEditableSave: function (field, row, oldValue, $el) {
									var time = getcurrenttime();
									$.ajax({
										url : "/zixun/updatezixun",
										data : {
											id : row.id,
											title :row.title,
											infortext : row.infortext,
											updatetime : time,
										},
										type : "post",
										async : false,
										success : function(data) {
											if (data.status == 200) {
												$("#zixuntable")
														.bootstrapTable('updateByUniqueId', {
															id : row.id,
															row : {															
																updatetime : time,													
															}
														})
												alert(data.msg);
											} else
												alert(data.msg);
										}
									})
					            }

					})
	/*删除资讯时执行的函数*/
	function onremove(id) {
		isDel = window.confirm("确定删除此条数据？");
		if (isDel == true) {
			$.ajax({
				url : "/zixun/delzixun/" + id,
				async : false,
				success : function(data) {
					if (data.status == 200) {
						$("#zixuntable").bootstrapTable('removeByUniqueId',
								parseInt(id));
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
		$("#addModal #zxtype").empty();
		$.ajax({
			url : "/zixun/getzxtype",
			async : false,
			success : function(data) {					   
					for (var i = 0; i < data.length; i++) {
						var option = "<option value="
								+ data[i].id + ">"
								+ data[i].zxtypename
								+ "</option>";
						$("#addModal #zxtype").append(option);
					}
				}
		})
		$("#addModal").modal();
	};
	/*添加资讯点击保存按钮执行的函数*/
	function addzixunsaveinfor() {
		$.ajax({
			url : "/zixun/addzixun",
			data : {
				title : $("#addModal #title").val(),
				infortext : ue1.getContent(),
				author : $("#user").text(),
				createtime : getcurrenttime(),
				updatetime : getcurrenttime(),
				zxtypeid:$("#addModal #zxtype").find("option:selected").val(),
			},
			type : 'post',
			async : false,
			success : function(data) {
				if (data.status == 200) {
					$("#addModal").modal('hide'), 
					/* $("#zixuntable")
							.bootstrapTable('prepend', data.data); */
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
			url : "/zixun/getsinglezixun/" + id,
			async : false,
			success : function(data) {
				if (data!=null) {
					$("#modifyModal #zixunid").val(data.id), $(
							"#modifyModal #title").val(data.title), ue2
							.setContent(data.infortext), $("#modifyModal")
							.modal();
				} else {
					alert("获取数据异常!");
				}
			}
		})
	};
	/* 修改资讯点击保存按钮执行的函数*/
	function modifyzixunsaveinfor() {
		var time = getcurrenttime();
		$.ajax({
			url : "/zixun/updatezixun",
			data : {
				id : $("#modifyModal #zixunid").val(),
				title : $("#modifyModal #title").val(),
				infortext : ue2.getContent(),
				updatetime : time,
			},
			type : "post",
			async : false,
			success : function(data) {
				if (data.status == 200) {
					$("#modifyModal").modal('hide'), $("#zixuntable")
							.bootstrapTable('updateByUniqueId', {
								id : $("#modifyModal #zixunid").val(),
								row : {
									title : $("#modifyModal #title").val(),
									updatetime : time,									
									infortext : ue2.getContent(),
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
			url : "/zixun/getsinglezixun/" + id,
			async : false,
			success : function(data) {
				if (data!=null) {
					$("#showzixunModal #zixunid").val(data.id),
							$("#showzixunModal #infor").html(
									data.infortext), $("#showzixunModal")
									.modal();
				} else {
					alert("获取数据异常!");
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
	/*初始化函数*/
	$(function(){
		$("#toolbar #zxtype").append("<option>全部资讯</option>");
		$.ajax({
			url : "/zixun/getzxtype",
			async : false,
			success : function(data) {					   
					for (var i = 0; i < data.length; i++) {
						var option = "<option value="
								+ data[i].id + ">"
								+ data[i].zxtypename
								+ "</option>";
						$("#toolbar #zxtype").append(option);
					}
				}
		})
		$("#toolbar #zxtype").change(function(){
			if ($("#toolbar #zxtype").find("option:selected").text() == "全部资讯") {
				$("#zixuntable").bootstrapTable('refresh', {url: "/zixun/getzixuninfos/1/100000/"+$("#user").text()});	
			}
			else{
				$("#zixuntable").bootstrapTable('refresh', {url: "/zixun/getzixuninfos/1/100000/"+$("#toolbar #zxtype").find("option:selected").val()+"/"+$("#user").text()});	
			}			
		})					
	})			
</script>
</html>