<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<head>
<link rel="stylesheet" href="/css/main.css" type="text/css" media="screen" />
<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/bootstrap-table.min.css">
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script src="/js/bootstrap-table.min.js"></script>
<script src="/js/bootstrap-table-zh-CN.js"></script>

<link href="/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="/js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>


<!-- 引入 echarts.js -->
<script src="/js/echarts/echarts.js"></script>
</head>
<body>
	<div style="margin-top: 15px;">
		<div class="route_bg" style="margin-bottom: 10px;">
			<a>统计总览</a>&nbsp;<i class="glyphicon glyphicon-chevron-right"></i><a>&nbsp;订单商品统计</a>
		</div>
		<div class="form-group">
			<div class='input-group date'>
				<input class="form-control" type="text" placeholder="起始时间"
					id="datetimepicker1" style="width: 145px;"> - <input
					class="form-control" type="text" placeholder="结束时间"
					id="datetimepicker2" style="width: 145px;"> &nbsp;
				<button type="button" class="btn" id="searchwithdate">搜索</button>

			</div>
		</div>
		<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
		<div id="echartsId" style="width: 1000px; height: 350px;"></div>
		
		
		<div class="route_bg" style="    margin-top: 30px;">
			<a>订单处理</a>&nbsp;<i class="glyphicon glyphicon-chevron-right"></i><a>&nbsp;待处理订单</a>
		</div>
		<div style="margin-top: 10px; margin-bottom: -60px;">
			<div class="form-group">
				<div class='input-group date'>
					<input name="status" type="hidden" id="status" value="1"> <input
						class="form-control" type="text" placeholder="起始时间"
						id="datetimepicker3" style="width: 145px;"> - <input
						class="form-control" type="text" placeholder="结束时间"
						id="datetimepicker4" style="width: 145px;"> &nbsp;
					<button type="button" class="btn" id="searchwithtime">搜索</button>
					&nbsp;&nbsp; <input type="text" class="form-control" id="oderid"
						placeholder="订单号" style="width: 200px;"> &nbsp;
					<button type="button" class="btn" id="searchwithoid">搜索</button>
					&nbsp;&nbsp;
				</div>

			</div>
		</div>
		<table id="jktable" data-toggle="table"
			data-url="/manager/getorderlist/1" data-pagination="true"
			data-striped="true" data-show-refresh="true" data-search="true"
			data-show-Columns="true" data-height="500">
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
					<th data-field="orderstates" data-align="center"
						data-sortable="true">订单状态</th>
					<th data-field="" data-align="center" data-formatter="operate">操作</th>
				</tr>
			</thead>
		</table>

	</div>
	<script type="text/javascript">
		$('#datetimepicker1').datetimepicker({
			minView : "month",//设置只显示到月份
			format : "yyyy-mm-dd",//日期格式
			autoclose : true,//选中关闭
			todayBtn : true,//今日按钮
			language : 'zh-CN',
			autoclose : 1,
		});
		$('#datetimepicker2').datetimepicker({
			minView : "month",//设置只显示到月份
			format : "yyyy-mm-dd",//日期格式
			autoclose : true,//选中关闭
			todayBtn : true,//今日按钮
			language : 'zh-CN',
			autoclose : 1,
		});
		$('#datetimepicker3').datetimepicker({
			language : 'zh-CN',
			autoclose : 1,
		});
		$('#datetimepicker4').datetimepicker({
			language : 'zh-CN',
			autoclose : 1,
		});
		$(function() {
			showecharts(10);
		});

		function DateDiff(sDate1, sDate2) { //sDate1和sDate2是2002-12-18格式  
			var aDate, oDate1, oDate2, iDays
			aDate = sDate1.split("-")
			oDate1 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0]) //转换为12-18-2002格式  
			aDate = sDate2.split("-")
			oDate2 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0])
			iDays = parseInt(Math.abs(oDate1 - oDate2) / 1000 / 60 / 60 / 24) //把相差的毫秒数转换为天数  
			return iDays
		}

		$("#searchwithdate").click(function() {
			var beginDate = $("#datetimepicker1").val();
			var endDate = $("#datetimepicker2").val();
			if (beginDate == "") {
				$("#datetimepicker1").focus();
			} else if (endDate == "") {
				$("#datetimepicker2").focus();
			} else {
				var datenum = DateDiff(beginDate, endDate);
				showecharts(datenum);
			}
		});

		function showecharts(datenum) {
			var pbrowse = new Array();
			var order = new Array();
			$.ajax({
				url : "/manager/statistics/pbrowse/" + datenum,
				type : "GET",
				async : false,
				success : function(data) {
					console.log(data);
					var length = data.length;
					for (var i = data.length - 1; i >= 0; i--) {
						pbrowse[length - i - 1] = data[i];
					}
					console.log(pbrowse);
				}
			});
			$.ajax({
				url : "/manager/statistics/order/" + datenum,
				type : "GET",
				async : false,
				success : function(data) {
					console.log(data);
					var length = data.length;
					for (var i = data.length - 1; i >= 0; i--) {
						order[length - i - 1] = data[i];
					}
					console.log(order);
				}
			});

			function getBeforeDate(n) {
				var n = n;
				var d = new Date();
				var year = d.getFullYear();
				var mon = d.getMonth() + 1;
				var day = d.getDate();
				if (day <= n) {
					if (mon > 1) {
						mon = mon - 1;
					} else {
						year = year - 1;
						mon = 12;
					}
				}
				d.setDate(d.getDate() - n);
				year = d.getFullYear();
				mon = d.getMonth() + 1;
				day = d.getDate();
				s = year + "-" + (mon < 10 ? ('0' + mon) : mon) + "-"
						+ (day < 10 ? ('0' + day) : day);
				return s;
			}

			var dateArray = new Array();
			for (var i = datenum; i > 0; i--) {
				dateArray[datenum - i] = getBeforeDate(i);
			}
			console.log(dateArray);
			// 基于准备好的dom，初始化echarts实例
			var myChart = echarts.init(document.getElementById('echartsId'));
			// 指定图表的配置项和数据
			option = {
				title : {
					text : '订单商品统计图'
				},
				subtext : {
					text : '订单商品统计'
				},
				tooltip : {
					trigger : 'axis'
				},
				legend : {
					data : [ '商品访问量', '订单金额' ]
				},
				grid : {
					left : '3%',
					right : '4%',
					bottom : '3%',
					containLabel : true
				},
				toolbox : {
					feature : {
						saveAsImage : {}
					}
				},
				xAxis : {
					type : 'category',
					boundaryGap : false,
					data : dateArray
				},
				yAxis : {
					type : 'value'
				},
				series : [ {
					name : '商品访问量',
					type : 'line',
					stack : '总量',
					data : pbrowse
				}, {
					name : '订单金额',
					type : 'line',
					stack : '总量',
					data : order
				} ]
			};
			// 使用刚指定的配置项和数据显示图表。
			myChart.setOption(option);
		}

		function operate(value, row, index) {

			return '<button type="button" class="btn btn-default btn-sm" onclick="jujie('
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
					+ ')"><span class="glyphicon glyphicon-edit"></span>详情</button>';

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
						var url = "/manager/order/orderlist/" + status
								+ ".html";
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
						var url = "/manager/order/orderlist/" + status
								+ ".html";
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
	</script>
</body>
</html>
