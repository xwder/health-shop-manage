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
</head>
<body>
	<div class="route_bg">
		<a>统计管理</a>&nbsp;<i class="glyphicon glyphicon-chevron-right"></i><a>&nbsp;资讯查找记录</a>
	</div>
	<div>
		<table id="zixuntable">
			<thead style="background-color: #003D79; color: #FFF">
			</thead>
		</table>
	</div>
	<script type="text/javascript">
		$("#zixuntable").bootstrapTable({
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
			url : "/record/getzxrecord",
			columns : [ {
				field : "id",
				visible : false,
			}, {
				field : "username",
				title : "用户名",
				align : "center",
				valign : "middle",
			}, {
				field : "zxtitle",
				title : "资讯标题",
				align : "center",
				valign : "middle",
			}, {
				field : "browsetime",
				title : "浏览时间",
				align : "center",
				valign : "middle",
				sortable: "true",
			}, {
				field : "zxtype",
				title : "资讯类型",
				align : "center",
				valign : "middle",
				formatter : function(value) {
					if (value == "1")
						return "健康资讯"
					if (value == "2")
						return "季节资讯"					
				}
			}, {
				field : "userip",
				title : "登陆IP",
				align : "center",
				valign : "middle",

			} ],
		})
	</script>
</body>
</html>