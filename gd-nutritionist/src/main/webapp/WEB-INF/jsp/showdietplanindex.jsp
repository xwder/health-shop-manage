<%@ page language="java" contentType="text/html; utf-8"
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
<script type="text/javascript" src="/js/showvipinfo.js"></script>
<script type="text/javascript" src="/js/showdietplanindex.js"></script>

</head>
<body>
	<input id="uid" type="hidden" value="${id}">
	<input id="nid" type="hidden" value="${nid}">
    <input id="planid" type="hidden">

	<div class="route_bg">
		<a>健康计划管理</a>&nbsp;<i class="glyphicon glyphicon-chevron-right"></i><a>&nbsp;显示饮食计划</a>
	</div>

	<div id="toolbar">
		<div style="float: left;">
			<button id="add" onclick="fanhui()" type="button"
				class="btn btn-default">
				<span class="glyphicon glyphicon-chevron-left"></span>返回
			</button>
		</div>
	</div>

	<div>
		<table id="dietplanindextable">
			<thead style="background-color: #003D79; color: #FFF">
			</thead>
		</table>
	</div>

	<!-- 显示饮食计划模态框 -->
	<div class="modal fade" id="dietplanModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width: 900px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">饮食计划</h4>
				</div>
				<div class="modal-body" style="height: 400px;">				
					<center>
						<div style="margin-bottom: 15px; display: block;"
							id="dietplandate">
							<div class="btn-group">								
							</div>
						</div>
					</center>
					<center>
						<div style="width: 80%; display: block;">
							<div id="foodplan">
								<table id="foodtable">
								</table>
							</div>						
						</div>
					</center>
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