<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet" href="/css/main.css" type="text/css" media="screen" />
<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/bootstrap-table.min.css">
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/jquery.cookie.js"></script>
<script type="text/javascript" src="/js/userinfo.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script src="/js/bootstrap-table.min.js"></script>
<script src="/js/bootstrap-table-zh-CN.js"></script>

<link href="/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="/js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>

<body>

	<div style="margin-top: 15px;">
		<div class="route_bg">
			<a>订单处理</a>&nbsp;<i class="glyphicon glyphicon-chevron-right"></i><a>&nbsp;
				<c:if test="${status == 0 }">全部订单</c:if>
				<c:if test="${status == 1 }">待处理订单</c:if>
				<c:if test="${status == 2 }">拒接单订单</c:if>
				<c:if test="${status == 3 }">已接单订单</c:if>
				<c:if test="${status == 4 }">已发货订单</c:if>
				<c:if test="${status == 5 }">交易完成</c:if>
			</a>
		</div>
		<div style="margin-top: 10px; margin-bottom: -60px;">
			<div class="form-group">
				<div class='input-group date'>
					<input name="status" type="hidden" id="status" value="${status}">
					<input class="form-control" type="text" placeholder="起始时间"
						id="datetimepicker" style="width: 145px;"> - <input
						class="form-control" type="text" placeholder="结束时间"
						id="datetimepicker2" style="width: 145px;"> &nbsp;
					<button type="button" class="btn" id="searchwithtime">搜索</button>
					&nbsp;&nbsp; <input type="text" class="form-control" id="oderid"
						placeholder="订单号" style="width: 200px;"> &nbsp;
					<button type="button" class="btn" id="searchwithoid">搜索</button>
					&nbsp;&nbsp;
				</div>

			</div>
		</div>
		<table id="jktable" data-toggle="table"
			data-url="/manager/getorderlist/${status }" data-pagination="true"
			data-striped="true" data-show-refresh="true" data-search="true"
			data-show-Columns="true" data-height="">
			<colgroup>
				<col style="width: 8%;">
				<col style="width: 8%;">
				<col style="width: 10%;">
				<col style="width: 8%;">
				<col style="width: 10%;">
				<col style="width: 15%;">
				<col style="width: 15%;">
				<col style="width: 10%;">
				<col style="width: 15%;">
			</colgroup>
			<thead style="background-color: #003D79; color: #FFF">
				<tr>
					<th data-field="id" data-align="center" data-sortable="true">订单编号</th>
					<th data-field="total" data-align="center" data-sortable="true">金额</th>
					<th data-field="ordertime" data-align="center" data-sortable="true">下单时间</th>
					<th data-field="username" data-align="center" data-sortable="true">用户名</th>
					<th data-field="userphone" data-align="center" data-sortable="true">电话</th>
					<th data-field="useraddr" data-align="center" data-sortable="true">地址</th>
					<th data-field="message" data-align="center" data-sortable="true">留言</th>
					<th data-field="orderstates" data-align="center" data-sortable="true">订单状态</th>
					<th data-field="" data-align="center" data-formatter="operate">操作</th>
				</tr>
			</thead>
		</table>
	</div>

</body>
<script type="text/javascript">
	$('#datetimepicker').datetimepicker({
		language : 'zh-CN',
		autoclose : 1,
	});
	$('#datetimepicker2').datetimepicker({
		language : 'zh-CN',
		autoclose : 1, 
	});
</script>
<script>
	function operate(value, row, index) {
		var status = row.intOrderstates;
		if (status == 1) {
			return  '<button type="button" class="btn btn-default btn-sm" onclick="jujie('
					+ row.id
					+ ','
					+ row.intOrderstates
					+ ')"> <span class="glyphicon glyphicon-check"></span>拒接</button>&nbsp<button type="button" class="btn btn-default btn-sm" onclick="acceptorder('
					+ row.id
					+ ','
					+ row.intOrderstates
					+ ')"> <span class="glyphicon glyphicon-check"></span>接单</button>&nbsp<button type="button" class="btn btn-default btn-sm" onclick="xiangqing('
					+ row.id
					+ ','
					+ row.intOrderstates
					+ ')"><span class="glyphicon glyphicon-edit"></span>详情</button>'
		}
		if (status == 2) {
			return '<button type="button" class="btn btn-default btn-sm" onclick="xiangqing('
					+ row.id
					+ ','
					+ row.intOrderstates
					+ ')"><span class="glyphicon glyphicon-edit"></span>详情</button>'
		}
		if (status == 3) {
			return '<button type="button" class="btn btn-default btn-sm" onclick="xiangqing('
					+ row.id
					+ ','
					+ row.intOrderstates
					+ ')"><span class="glyphicon glyphicon-edit"></span>详情</button>'
		}
		if (status == 4) {
			return '<button type="button" class="btn btn-default btn-sm" onclick=""> <span class="glyphicon glyphicon-align-justify"></span>物流</button>&nbsp<button type="button" class="btn btn-default btn-sm" onclick="xiangqing('
					+ row.id
					+ ','
					+ row.intOrderstates
					+ ')"><span class="glyphicon glyphicon-edit"></span>详情</button>'
		}
		if (status == 5) {
			return '<button type="button" class="btn btn-default btn-sm" onclick="chakanpingjia('
					+ row.id
					+ ','
					+ row.intOrderstates
					+ ')"><span class="glyphicon glyphicon-align-justify"></span>查看评价</button>'
		}
	}
	function name(value, row, index) {
		if (value != null && value.length > 20) {
			return value.substr(0, 15) + "......"
		}
		return value;
	}
	function xiangqing(id, status) {
		var url = "/manager/order/orderitem/" + id + "/" + status;
		window.location.href = url;
	}

	function chakanpingjia(id, status) {
		var url = "/manager/order/orderitem/" + id + "/" + status;
		window.location.href = url;
	}
	function acceptorder(id, status) {
		$.ajax({
			url : "/manager/order/acceptorder/" + id,
			async : false,
			success : function(data) {
				if (data.status == 200) {
					alert("处理成功！");
					var url = "/manager/order/orderlist/" + status + ".html";
					window.location.href = url;
				} else {
					alert("处理失败！");
				}
			}
		});
	}
	function jujie(id, status) {
		$.ajax({
			url : "/manager/order/refuseorder/" + id,
			async : false,
			success : function(data) {
				if (data.status == 200) {
					alert("处理成功！");
					var url = "/manager/order/orderlist/" + status + ".html";
					window.location.href = url;
				} else {
					alert("处理失败！");
				}
			}
		});
	}
	function fahuotorder(id, status) {
		$.ajax({
			url : "/manager/order/fahuoorder/" + id,
			async : false,
			success : function(data) {
				if (data.status == 200) {
					alert("处理成功！");
					var url = "/manager/order/orderlist/" + status + ".html";
					window.location.href = url;
				} else {
					alert("处理失败！");
				}
			}
		});
	}
	
	$("#searchwithtime").click(function(){
		var status = $("#status").val();
		var begintime = $("#datetimepicker").val();
		var endtime = $("#datetimepicker2").val();
		var url_ = "/manager/order/searchwithtime?status="+status+"&begintime="+begintime+"&endtime="+endtime;
		$("#jktable").bootstrapTable('refresh',{url: url_});  
	});
	$("#searchwithoid").click(function(){
		var status = $("#status");
		var orderid = $("#oderid").val();
		var url_ = "/manager/order/getorderbyoid/"+orderid;
		$("#jktable").bootstrapTable('refresh',{url: url_} );  
	});
	
	//拒接接单操作
	function jujieOper(){
		var id = $("#btn_jujue").val();
		var status = $("#btn_fanhui").val();
		$.ajax({
			url : "/manager/order/refuseorder/" + id,
			async : false,
			success : function(data) {
				if (data.status == 200) {
					alert("接单成功！");
					var url = "/manager/order/orderlist/" + status + ".html";
					window.location.href = url;
				} else {
					alert("处理失败！");
				}
			}
		});
	}
</script>
</html>
