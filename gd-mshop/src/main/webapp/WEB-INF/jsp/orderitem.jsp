<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<link rel="stylesheet" href="/css/main.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css"
	media="screen" />
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/jquery.cookie.js"></script>
<script type="text/javascript" src="/js/userinfo.js"></script>
<script type="text/javascript" src="/js/tendina.js"></script>
<link rel="stylesheet" type="text/css"
	href="/css/bootstrap-table.min.css">
<script src="/js/bootstrap.min.js"></script>
<script src="/js/bootstrap-table.min.js"></script>
<script src="/js/bootstrap-table-zh-CN.js"></script>

<body>
	<div style="margin-top: 10px;">
		<div class="route_bg">
			<a>订单处理</a>&nbsp;<i class="glyphicon glyphicon-chevron-right"></i><a>&nbsp;
				<c:if test="${status == 0 }">全部订单</c:if>
				<c:if test="${status == 1 }">待处理订单</c:if>
				<c:if test="${status == 2 }">拒接单订单</c:if>
				<c:if test="${status == 3 }">已接单订单</c:if>
				<c:if test="${status == 4 }">已发货订单</c:if>
				<c:if test="${status == 5 }">交易完成</c:if>
			</a>&nbsp;<i class="glyphicon glyphicon-chevron-right"></i>
			&nbsp;<a>订单详情</a>
		</div>
		<div style="margin-top: 10px; margin-bottom: -44px;">
			<c:if test="${status == 1 }">
				<button type="button" class="btn btn-default btn-sm" id="btn_fanhui"
					value="${status }">
					<span class="glyphicon glyphicon-chevron-left"></span> 返回
				</button>
				<button type="button" class="btn btn-default btn-sm" id="btn_jujue"
					value="${oid }">
					<span class="glyphicon glyphicon-ban-circle"></span>拒绝接单
				</button>
				<button type="button" class="btn btn-default btn-sm" id="btn_jiedan"
					value="${oid }">
					<span class="glyphicon glyphicon-ok"></span>接单
				</button>
			</c:if>
			<c:if test="${status != 1 }">
				<button type="button" class="btn btn-default btn-sm" id="btn_fanhui"
					value="${status }">
					<span class="glyphicon glyphicon-chevron-left"></span> 返回
				</button>
			</c:if>
		</div>
		<table id="jktable" data-toggle="table"
			data-url="/manager/getorderitemsbyoid/${oid }" data-pagination="true"
			data-striped="true" data-show-refresh="true" data-search="true"
			data-show-Columns="true" data-height="500">
			<colgroup>
				<col style="width: 10%;">
				<col style="width: 30%;">
				<col style="width: 10%;">
				<col style="width: 15%;">
				<col style="width: 10%;">
				<col style="width: 10%;">
				<col style="width: 15%;">
				<col style="width: 10%;">
			</colgroup>
			<thead style="background-color: #003D79; color: #FFF">
				<tr>
					<th data-field="id" data-align="center" data-sortable="true">购物项编号</th>
					<th data-field="pname" data-align="center">商品名</th>
					<th data-field="pprice" data-align="center">单价</th>
					<th data-field="count" data-align="center">数量</th>
					<th data-field="subtotal" data-align="center">小计</th>
					<th data-field="strStatus" data-align="center">状态</th>
					<th data-field="" data-align="center" data-formatter="operate">操作</th>
				</tr>
			</thead>
		</table>
	</div>

	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel"></div>


</body>

<script>
	function operate(value, row, index) {
		var status = row.status;
		if (status == 1) {
			return '<button type="button" class="btn btn-default btn-sm" onclick="jiedanOper()"><span class="glyphicon glyphicon-ok"></span>接单</button>'
					+ '<button type="button" class="btn btn-default btn-sm" onclick="jujieOper()"><span class="glyphicon glyphicon-ban-circle"></span>拒接</button>';
		}
		if (status == 5) {
			return '<button type="button" class="btn btn-default btn-sm" onclick="pingjia('
					+ row.id
					+ ','
					+ row.orderid
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
 
	$("#btn_fanhui").click(function() {
		var status = $("#btn_fanhui").val();
		var url = "/manager/order/orderlist/" + status + ".html";
		window.location.href = url;
	});
	$("#btn_jujue").click(function() {
		jujieOper();
	});
	$("#btn_jiedan").click(function() {
		jiedanOper();
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
					alert("拒接单成功！");
					var url = "/manager/order/orderlist/" + status + ".html";
					window.location.href = url;
				} else {
					alert("处理失败！");
				}
			}
		});
	}
	//接单操作
	function jiedanOper() {
		var status = $("#btn_fanhui").val();
		var id = $("#btn_jiedan").val();
		$.ajax({
			url : "/manager/order/acceptorder/" + id,
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
	//查看商品评价
	function pingjia(id, oid, status) {
		$("#myModalLabel").text("查看评价");
		$.ajax({
			url : "/manager/order/comment/" + id + "/" + oid,
			async : false,
			success : function(data) {
				$('#myModal').html(data);
				$('#myModal').modal();
			}
		});

	}
</script>
</html>
