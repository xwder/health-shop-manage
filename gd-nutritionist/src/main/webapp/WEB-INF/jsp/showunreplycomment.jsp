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
<link rel="stylesheet" href="/css/sinaFaceAndEffec.css" type="text/css"
	media="screen" />
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-table.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript" src="/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="/js/sinaFaceAndEffec.js"></script>
</head>
<body>

	<div class="route_bg">
		<a>留言管理</a>&nbsp;<i class="glyphicon glyphicon-chevron-right"></i><a>&nbsp;未回复留言</a>
	</div>
	<div>
		<table id="commenttable">
			<thead style="background-color: #003D79; color: #FFF">
			</thead>
		</table>
	</div>
	<!-- 回复留言模态框 -->
	<div class="modal fade" id="commentModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="commentModalLabel">留言回复</h4>
				</div>
				<div class="modal-body">
					<div class="form-group" style="display: none">
						<input type="text" class="form-control" id="commentid">
					</div>
					<div class="form-group" style="height:120px;">
						<label for="name">留言内容</label>
						<div class="form-control" id="commentcontent" style="height:90%;overflow-y:auto;"></div>
					</div>
					<div class="form-group" id="reply">
						<label for="name">回复内容</label>
						<textarea class="form-control" rows="5" id="replycontent"></textarea>
						<div class="tools-box">
							<div class="operator-box-btn">
								<span class="face-icon">☺</span>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" id="closeModal" class="btn btn-default"
						data-dismiss="modal">关闭</button>
					<button type="button" id="submitInfor" class="btn btn-primary"
						onclick="savereplycomment()">确定回复</button>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			$('.face-icon').SinaEmotion($('#replycontent'));
		})
		$("#commenttable")
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
							url : "/comment/getunreplycomment/"
									+ $("#userId").text(),
							columns : [
									{
										field : "id",
										visible : false,
									},
									{
										field : "image",
										title : "头像",
										align : "center",
										valign : "middle",
										formatter : function(value) {
											return '<img src=\''+value+'\' height="30px" width="30px"><img>';
										}
									},
									{
										field : "username",
										title : "名字",
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
										title : "性别",
										align : "center",
										valign : "middle",
										formatter : function(value) {
											if (value == "1")
												return "男"
											return "女"
										}

									},
									{
										field : "commentcontent",
										title : "留言内容",
										align : "center",
										valign : "middle",
										formatter : function(value, row, index) {
											if (value != null
													&& value.length > 20) {										
												return value.substr(0, 20)
														+ '<a href="javascript:void(0);" onclick="replycomment(\''
														+ row.id + '\')">[详情]</a>';
											}
											return value;
										}
									},
									{
										field : "commenttime",
										title : "留言时间",
										align : "center",
										valign : "middle",
									},
									{
										field : "operate",
										title : "operate",
										align : "center",
										valign : "middle",
										formatter : function operate(value,
												row, index) {
											return '<button type="button" class="btn btn-default btn-sm" onclick="replycomment(\''+row.id+'\')"> <span class="glyphicon glyphicon-share-alt"></span> 回复留言</button>&nbsp<button type="button" class="btn btn-default btn-sm" onclick="deletecomment(\''
													+ row.id
													+ '\')"><span class="glyphicon glyphicon-remove"></span> 删除留言</button>'
										}
									} ],
						})
		/*打开回复留言框*/
		function replycomment(id) {
			$.ajax({
				 url:"/comment/getSingleUnReplycomment/"+id,
				 async:false,
				 success:function(data){
					 if(data.status==200){
						 $("#commentModal #commentid").val(id);
						 $("#commentModal #commentcontent").html(data.data.commentcontent),
						 $("#commentModal #replycontent").val(data.data.replycontent), 
						 $("#commentModal").modal(); 
					 }
					 else
						 alert(data.msg);
				 }
			 })						
		}
		/*保存回复的内容*/
		function savereplycomment() {
			 $.ajax({
				url : "/comment/replycomment",
				data : {
					id : $("#commentModal #commentid").val(),
					replycontent : AnalyticEmotion($('#replycontent').val()),
					replytime : getcurrenttime(),
				},
				type : "post",
				async : false,
				success : function(data) {
					if (data.status == 200) {
						$("#commentModal").modal('hide'), $("#commenttable")
								.bootstrapTable(
										'remove',
										{
											field : 'id',
											values : [ parseInt($(
													"#commentModal #commentid")
													.val()) ]
										});
						alert(data.msg);
					} else
						alert(data.msg);
				}
			})
		}
		/*删除留言记录*/
		function deletecomment(id) {
			isDel = window.confirm("确定删除此条留言？");
			if (isDel == true) {
				$.ajax({
					url : "/comment/deletecomment/" + id,
					async : false,
					success : function(data) {
						if (data.status == 200) {
							$("#commenttable").bootstrapTable('removeByUniqueId',parseInt(id));
							alert(data.msg);
						} else {
							alert(data.msg);
						}
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