<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<head>
<link rel="stylesheet" href="/css/main.css" type="text/css" media="screen" />
<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>


<link href="/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="/js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>


<!-- 引入 echarts.js -->
<script src="/js/echarts/echarts.js"></script>
</head>
<body>
	<div style="margin-top: 15px;">
		<div class="route_bg" style="margin-bottom: 10px;">
			<a>统计总览</a>&nbsp;<i class="glyphicon glyphicon-chevron-right"></i><a>&nbsp;订单、资讯、商品、访问统计</a>
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
		<div id="echartsId" style="width: 1100px; height: 350px;"></div>
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
		var userlog = new Array();
		var potal = new Array();
		var zixun = new Array();
		var search = new Array();
		$.ajax({
			url : "/statistics/orderstatistics/" + datenum,
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
		$.ajax({
			url : "/statistics/zixunstatistics/" + datenum,
			type : "GET",
			async : false,
			success : function(data) {
				console.log(data);
				var length = data.length;
				for (var i = data.length - 1; i >= 0; i--) {
					zixun[length - i - 1] = data[i];
				}
				console.log(zixun);
			}
		});
		$.ajax({
			url : "/statistics/potalstatistics/" + datenum,
			type : "GET",
			async : false,
			success : function(data) {
				console.log(data);
				var length = data.length;
				for (var i = data.length - 1; i >= 0; i--) {
					potal[length - i - 1] = data[i];
				}
				console.log(potal);
			}
		});
		$.ajax({
			url : "/statistics/itemstatistics/" + datenum,
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
			url : "/statistics/userlogstatistics/" + datenum,
			type : "GET",
			async : false,
			success : function(data) {
				console.log(data);
				var length = data.length;
				for (var i = data.length - 1; i >= 0; i--) {
					userlog[length - i - 1] = data[i];
				}
				console.log(userlog);
			}
		});
		$.ajax({
			url : "/statistics/searchstatistics/" + datenum,
			type : "GET",
			async : false,
			success : function(data) {
				console.log(data);
				var length = data.length;
				for (var i = data.length - 1; i >= 0; i--) {
					search[length - i - 1] = data[i];
				}
				console.log(search);
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
				text : '网站统计图'
			},
			subtext : {
				text : '网站统计图'
			},
			tooltip : {
				trigger : 'axis'
			},
			legend : {
				data : [ '商品访问量', '订单金额','用户登录量','首页访问量','资讯浏览量','商品搜索量' ]
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
			},{
				name : '用户登录量',
				type : 'line',
				stack : '总量',
				data : userlog
			},{
				name : '首页访问量',
				type : 'line',
				stack : '总量',
				data : potal
			},{
				name : '资讯浏览量',
				type : 'line',
				stack : '总量',
				data : zixun
			},{
				name : '商品搜索量',
				type : 'line',
				stack : '总量',
				data : search
			}]
		};
		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	}

	</script>
</body>
</html>
