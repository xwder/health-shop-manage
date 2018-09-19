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
		<a>留言管理</a>&nbsp;<i class="glyphicon glyphicon-chevron-right"></i><a>&nbsp;已回复留言</a>
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
				    	<div class="form-group">
							<label for="name">留言内容</label>
							<textarea class="form-control" id="commentcontent" readonly="readonly"></textarea>
						</div>														
						<div class="form-group">
							<label for="name">回复内容</label>
							<textarea class="form-control" rows="5" id="replycontent"></textarea>
						</div>					
				</div>
				<div class="modal-footer">
					<button type="button" id="closeModal" class="btn btn-default"
						data-dismiss="modal">关闭</button>					
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
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
							url : "/comment/getreplycomment/"
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
										field : "name",
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
										visible : "false",										
									},
									{
										field : "commenttime",
										title : "留言时间",
										align : "center",
										valign : "middle",
									},
									{
										field : "replycontent",
										visible : "false",
									},
									{
										field : "replytime",
										title : "回复时间",
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
											return '<button type="button" class="btn btn-default btn-sm" onclick="replycomment(\''
													+ row.commentcontent
													+ '\',\''+row.replycontent+'\')"> <span class="glyphicon glyphicon-share-alt"></span> 留言详情</button>&nbsp<button type="button" class="btn btn-default btn-sm" onclick="deletecomment(\''
													+ row.id
													+ '\')"><span class="glyphicon glyphicon-remove"></span> 删除留言</button>'
										}
									} ],
						})	
		function deletecomment(id){
			isDel = window.confirm("确定删除此条留言？");
			if (isDel == true) {
				$.ajax({
					url : "/comment/deletecomment/" + id,
					async : false,
					success : function(data) {
						if (data.status == 200) {
							alert(data.msg);
						} else {
							alert(data.msg);
						}
					}
				});
				$("#commenttable").bootstrapTable('remove', {
					field : 'id',
					values : [ parseInt(id) ]
				});
			}			
		}		
	</script>
</body>
</html>