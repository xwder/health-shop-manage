<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<style>
body, div, p, h3, ul, input {
	margin: 0;
	padding: 0;
}

body {
	font-size: 12px;
	font-family: '微软雅黑', Verdana, "Lucida Grande", "Lucida Sans", sans;
	color: #333;
}

.warpper img {
	border: none;
}

.warpper a {
	text-decoration: none;
	color:black;
}

.warpper a:hover {
	text-decoration: underline;
	color: #f60;
}

.warpper.b {
	font-weight: bold;
}

.warpper .font16 {
	font-size: 16px;
}

.warpper .fl {
	float: left;
}
/* 清除浮动 */
.warpper .clearfix:after {
	content: "";
	display: block;
	height: 0;
	font-size: 0;
	clear: both;
}

.warpper .clearfix {
	zoom: 1;
}

.head {
	width: 1000px;
	height: 160px;
	border-bottom: 1px solid #ccc;
	margin: 0 auto;
}

.head .logo {
	display: inline-block;
}

.warpper {
	width: 1000px;
	margin: 0 auto;
}

.content {
	width: 520px;
	min-height: 189px;
	_height: 189px;
	padding: 50px 0 0 210px;
	margin: 100px 0 120px 180px;
	background: url(/images/404/bg404.jpg) no-repeat;
}

.falseCode {
	width: 300px;
	padding-right: 20px;
	border-right: 1px solid #ccc;
	text-align: right;
	font-size: 40px;
	font-family: Arial, Helvetica, sans-serif;
	color: #999;
	float: left;
	margin-bottom: 20px;
}

.falseText {
	width: 380px;
	padding-left: 20px;
	float: left;
	line-height: 2;
}
</style>

<html>
<body>
	<div class="content_right">
		<div class="user-order">

			<!--标题 -->
			<div class="am-cf am-padding">
				<div class="am-fl am-cf">
					<strong class="am-text-danger am-text-lg">未完成订单</strong> / <small>Order</small>
				</div>
			</div>

			<c:if test="${fn:length(allOrderPageBean.list)!=0}">
				<div class="am-tabs-bd">
					<div class="am-tab-panel am-fade am-in am-active" id="tab1">


						<div class="order-main">
							<div class="order-list">

								<!--所有订单-->
								<div class="order-status5">
									<c:forEach var="orderInfo" items="${allOrderPageBean.list }">
										<div class="order-title">
											<div class="dd-num">
												订单编号：<a
													href="http://localhost:8883/shop/orderinfo.html?orderid=${orderInfo.order.id }">${orderInfo.order.id }</a>
											</div>
											<span>下单时间：<fmt:formatDate
													value="${orderInfo.order.ordertime }" type="both" /></span>
											<!--    <em>店铺：小桔灯</em>-->
										</div>
										<div class="order-content">
											<div class="order-left">
												<%-- <c:if test="${fn:length(allOrderPageBean.list)!=0}"> --%>
												<c:forEach var="orderitem"
													items="${orderInfo.orderitemList}">
													<ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="http://localhost:8883/${orderitem.pid}.html"
																	class="J_MakePoint"> <%-- <img style="width: 80px,height:80px;"
																			src="${orderitem.ppic }"
																			class="itempic J_ItemImg"> --%> <img
																	src="${orderitem.ppic }" alt="shopping"
																	style="width: 80px; height: 80px;" />
																</a>
															</div>

															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p>
																			<a href="http://localhost:8883/${orderitem.pid}.html">${orderitem.pname }</a>
																		</p> <!-- <p class="info-little">
																				颜色：12#川南玛瑙 <br />包装：裸装
																			</p> -->
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">
															<div class="item-price">${orderitem.pprice}</div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span>×</span>${orderitem.count}
															</div>
														</li>
														<li class="td td-operation">
															<div class="item-operation">
																<c:if test="${orderitem.status == 4}">
																	<a href="/user/comment.html?itemid=${orderitem.id}">评价</a>
																</c:if>
																<c:if test="${orderitem.status == 5}">
																	<a href="/user/itemcomment.html?itemid=${orderitem.id}">查看评价</a>
																</c:if>
															</div>
														</li>
													</ul>
												</c:forEach>
											</div>


											<div class="order-right">
												<li class="td td-amount">
													<div class="item-amount">
														合计：
														<fmt:formatNumber type="number"
															value="${orderInfo.order.total}" maxFractionDigits="2" />
														￥
														<p>
															含运费：<span>0</span>
														</p>
													</div>
												</li>
												<div class="move-right">
													<li class="td td-status">
														<div class="item-status">
															<c:if test="${orderInfo.order.orderstates == 1 }">
																<p class="Mystatus">待商家接单</p>
															</c:if>
															<c:if test="${orderInfo.order.orderstates == 2  }">
																<p class="Mystatus">商家拒接单</p>
															</c:if>
															<c:if test="${orderInfo.order.orderstates == 3 }">
																<p class="Mystatus">商家接单配送中</p>
															</c:if>
															<c:if test="${orderInfo.order.orderstates == 4  }">
																<p class="Mystatus">已收货待评价</p>
															</c:if>
															<c:if test="${orderInfo.order.orderstates ==  5 }">
																<p class="Mystatus">交易完成</p>
															</c:if>

															<p class="order-info">
																<a
																	href="http://localhost:8883/shop/orderinfo.html?orderid=${orderInfo.order.id}">订单详情</a>
															</p>
															<p class="order-info">
																<a href="">查看物流</a>
															</p>
														</div>
													</li>
													<li class="td td-change">
														<div class="am-btn am-btn-danger anniu">删除订单</div>
													</li>
												</div>
											</div>
										</div>

									</c:forEach>
								</div>
							</div>
						</div>

						<div class="pagelist">
							<ul>
								<li><a
									href="http://localhost:8885/user/userindexorder.html?page=1">首页</a></li>

								<c:if test="${allOrderPageBean.pageNum != 1 }">
									<li><a
										href="http://localhost:8885/user/userindexorder.html?page=${allOrderPageBean.pageNum -1}">上页</a></li>
								</c:if>
								<c:forEach var="i" begin="${allOrderPageBean.pageNum }"
									end="${allOrderPageBean.pageNum + 3 }">
									<c:if test="${i <  allOrderPageBean.pages}">
										<c:if test="${i ==  allOrderPageBean.pageNum}">
											<li><a
												href="http://localhost:8885/user/userindexorder.html?&page=${i}"
												class="current">${i}</a></li>
										</c:if>
										<c:if test="${i !=  allOrderPageBean.pageNum}">
											<li><a
												href="http://localhost:8885/user/userindexorder.html?&page=${i}"
												class="">${i}</a></li>
										</c:if>
									</c:if>
								</c:forEach>
								<li>···</li>
								<li><a
									href="http://localhost:8885/user/userindexorder.html?&page=${allOrderPageBean.pages}"
									class="">${allOrderPageBean.pages}</a></li>
								<c:if
									test="${allOrderPageBean.pageNum != allOrderPageBean.pages}">
									<li><a
										href="http://localhost:8885/user/userindexorder.html?page=${allOrderPageBean.pageNum +1}">下页</a></li>
								</c:if>
								<c:if
									test="${allOrderPageBean.pageNum != allOrderPageBean.pages}">
									<li><a
										href="http://localhost:8885/user/userindexorder.html?page=${allOrderPageBean.pages}">尾页</a></li>
								</c:if>



								<li class="pageinfo">第${allOrderPageBean.pageNum}页/共${allOrderPageBean.pages}页</li>

							</ul>
						</div>
					</div>
				</div>
			</c:if>
		</div>


		<c:if test="${fn:length(allOrderPageBean.list) ==0}">

			<div class="warpper">
				<div class="content clearfix">
					<div class="falseCode">/(ㄒoㄒ)/~~</div>
					<div class="falseText">
						<p class="font16 b" style="text-align: center;">您还未下单！</p>
						<p>&nbsp;</p>
						<p class="b" style="text-align: center;">
							<span class="red" id="404_time">10</span> 秒之后会自动跳转所有商品页面，您还可以：
						</p>
						<p class="b" style="text-align: center">
							1）<a style="color: #f60;" title="返回首页"
								href="http://localhost:8881/">返回健康购首页</a>
						</p>
						<p class="b" style="text-align: center">
							2）去其它地方逛逛：<a style="color: #f60;" title=""
								href="http://localhost:8880/zixun/%E8%B5%84%E8%AE%AF%E9%A6%96%E9%A1%B5.html">浏览健康资讯</a>
							| <a style="color: #f60;" title=" "
								href="http://localhost:8883/list.html">显示所有商品</a>
					</div>
				</div>
			</div>
		</c:if>

		<div id="showtodayplan">
			<div id="showplanbyself">
			    <div><strong style="font-size:18px;">今日健康计划(自定义)</strong></div>
				<div id="showdietplanbyself">
					<table id="dietplanshowbyself">
					</table>
				</div>
				<div id="showsportplanbyself">
					<table id="sportplanshowbyself">
					</table>
				</div>
			</div>
			<script type="text/javascript">
				$("#dietplanshowbyself")
						.bootstrapTable(
								{
									idField : "id",
									uniqueId : "id",
									pagination : true,
									striped : true,									
									cache : false,							
									pageNumber : 1,
									pageSize : 2,									
									columns : [
											{
												field : "id",
												title:"健康计划编号",
												align : "center",
												valign : "middle",
											},
											{
												field : "userid",
												visible : false,
											},
											{
												field : "startdate",
												title : "开始日期",
												align : "center",
												valign : "middle",
												formatter : function formatterdate(
														value) {
													return today;
												}
											},											
											{
												field : "plantype",
												title : "计划类型",
												align : "center",
												valign : "middle",
												formatter : function formatterdate(
														value) {
													return "饮食计划";
												}
											},
											{
												field : "operate",
												title : "操作",
												align : "center",
												valign : "middle",
												formatter : function operate(
														value, row, index) {
													return '<button type="button" class="btn btn-default btn-sm" onclick="showtodaydietplanByself(\''
															+ row.userid
															+ '\',\''
															+ row.id
															+ '\')"><span class="glyphicon glyphicon-align-justify"></span> 查看详情</button>'
												}
											} ],
								})
				$("#sportplanshowbyself")
						.bootstrapTable(
								{
									idField : "id",
									uniqueId : "id",
									pagination : true,
									striped : true,								
									cache : false,									
									pageNumber : 1,
									pageSize : 2,									
									columns : [
											{
												field : "id",
												title : "运动计划编号",
												align : "center",
												valign : "middle",
											},	
											{
												field : "userid",
												visible : false,
											},
											{
												field : "startdate",
												title : "开始日期",
												align : "center",
												valign : "middle",
												formatter : function formatterdate(
														value) {
													return today;
												}
											},											
											{
												field : "plantype",
												title : "计划类型",
												align : "center",
												valign : "middle",
												formatter : function formatterdate(
														value) {
													return "运动计划";
												}
											},
											{
												field : "operate",
												title : "操作",
												align : "center",
												valign : "middle",
												formatter : function operate(
														value, row, index) {
													return '<button type="button" class="btn btn-default btn-sm" onclick="showtodaysportplanByself(\''
															+ row.userid
															+ '\',\''
															+ row.id
															+ '\')"><span class="glyphicon glyphicon-align-justify"></span> 查看详情</button>'
												}
											} ],
								})
				$(function() {
					$("#dietplanshowbyself").bootstrapTable('refresh',{url : '/plan/getdietplanindexBydate/'+ $(".title_bottom .title_bottom_menu #userid").val()+"/"+getcurrenttime().substr(0,10)});
					$("#sportplanshowbyself").bootstrapTable('refresh',{url : '/plan/getsportplanindexBydate/'+ $(".title_bottom .title_bottom_menu #userid").val()+"/"+getcurrenttime().substr(0,10)});
				})				
			</script>
		</div>
	</div>
	<!-- 显示饮食计划模态框 -->
	<div class="modal fade" id="dietplanModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width: 800px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">今日饮食计划</h4>
				</div>
				<div class="modal-body" style="height: 400px;">					
					<div id="foodplan">
						<table id="foodtable">
						</table>
					</div>				
				</div>

				<div class="modal-footer">
					<button type="button" id="closeModal" class="btn btn-default"
						data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 显示运动计划模态框 -->
	<div class="modal fade" id="sportplanModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width: 800px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">运动计划</h4>
				</div>
				<div class="modal-body" style="height: 400px;">										
					<div id="sportplan">
						<table id="sporttable">
						</table>
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
var today = getcurrenttime().substr(0,10);
$("#foodtable").bootstrapTable({
	idField : "id",
	uniqueId : "id",
	cache : false,
	pagination : false,
	striped : false,
	height : 300,
	columns : [ {
		field : "id",
		visible : false,
	}, {
		field : "foodname",
		title : "食物名称",
		align : "center",
		valign : "middle",
		cellStyle : function(value, row, index, field) {
			return {
				css : {
					"color" : "#2c87f0"
				}
			}
		},
	}, {
		field : "foodquantity",
		title : "参考量(克)",
		align : "center",
		valign : "middle",
	}, {
		field : "type",
		title : "餐饮类别",
		align : "center",
		valign : "middle",
		cellStyle : function(value, row, index, field) {
			return {
				css : {
					"color" : "#2c87f0"
				}
			}
		},
	} ],
})
$("#sporttable").bootstrapTable({
			idField : "id",
			uniqueId : "id",
			cache : false,
			pagination : false,
			striped : false,
			height : 300,
			columns : [ {
				field : "id",
				visible : false,
			}, {
				field : "sportname",
				title : "运动名称",
				align : "center",
				valign : "middle",
				cellStyle : function(value, row, index, field) {
					return {
						css : {
							"color" : "#2c87f0"
						}
					}
				},
			}, {
				field : "sportdescribe",
				title : "运动描述",
				align : "center",
				valign : "middle",
				cellStyle : function(value, row, index, field) {
					return {
						css : {
							"color" : "#2c87f0"
						}
					}
				},
			} ],
		})

function showtodaydietplanByself(userid,planid) {
	$("#foodtable").bootstrapTable('refresh',{url : '/plan/geteverydaydietplan/'+ userid + '/'+ planid + '/' + today});
	$("#dietplanModal").modal();
}
function showtodaysportplanByself(userid,planid,date) {
	$("#sporttable").bootstrapTable('refresh',{url : '/plan/geteverydaysportplan/'+ userid + '/'+ planid + '/' + today});
	$("#sportplanModal").modal();
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