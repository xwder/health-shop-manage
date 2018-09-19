<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<link rel="stylesheet" href="/css/comment.css">
<body>
	<div class="content_right">
		<div class="content_right_title">
			<span style="margin-left: 10px;">商品评价</span>
		</div>
		<div class="content_right_bottom">
			<div class="order-evaluation clearfix">
				<div>
					<div class="am-tab-panel am-fade am-in am-active" id="tab1">
					<div class="order-title">
							<span style="margin-left: 0px;">订单编号：<a href="http://localhost:8883/shop/orderinfo.html?orderid=${order.id}">${order.id}</a></span>
							<span style="margin-left: 20px;">成交时间：<fmt:formatDate value="${order.ordertime }" type="both" /></span>
							<em style="margin-left: 20px;">店铺：${storeinfo.storename }</em>
					</div>
						
						<div class="order-top">
							<div class="th th-item" style="width: 45%;">
								<td class="td-inner">商品</td>
							</div>
							<div class="th th-price" style="width: 15%;">
								<td class="td-inner">单价</td>
							</div>
							<div class="th th-number" style="width: 10%;">
								<td class="td-inner">数量</td>
							</div>

							<div class="th th-amount" style="width: 15%;">
								<td class="td-inner">合计</td>
							</div>
							<div class="th th-status" style="width: 15%;">
								<td class="td-inner">交易状态</td>
							</div>

						</div>

						<div class="order-main">
							<div class="order-list">
								<div class="order-status5">
									<div class="order-content">
										<div class="order-left">
											<ul class="item-list">
												<li class="td td-item" style="width: 45%;">
													<a href="http://localhost:8883/${item.pid}.html">
														<div class="item-pic" style="margin-top: 0px;background-image: url('${item.ppic }' );">
															<ul>
															</ul>
														</div>
													</a>
													<div class="item-info">
														<div class="item-basic-info" style="padding-top: 19px">
															<a href="http://localhost:8883/${item.pid}.html"> 
															<span style="color: #555555;">
																${item.pname }
																<input id="pid" type="hidden"  value="${item.pid}"/>
																<input id="orderitemid" type="hidden"  value="${item.id}"/>
																<input id="orderid" type="hidden"  value="${item.orderid}"/>
															</span>
															</a>
														</div>
													</div>
												</li>
												<li class="td td-price" style="width: 15%;">
													<div class="item-price">${item.pprice }</div>
												</li>
												<li class="td td-number" style="width: 10%;">
													<div class="item-number">
														<span>×</span>${item.count }
													</div>
												</li>
												<li class="td td-number" style="width: 15%;">
													<div class="item-number">
														<span>合计：${item.subtotal }</span>
													</div>
												</li>
												<li class="td td-number" style="width: 15%;">
													<div class="item-number">
														<c:if test="${item.status == 1 }">
															<span>待商家接单</span> 
														</c:if>
														<c:if test="${item.status == 2  }">
															<span>商家拒接单</span> 
														</c:if>
														<c:if test="${item.status == 3 }">
															<span>商家已接单待配送</span> 
														</c:if>
														<c:if test="${item.status == 4  }">
															<span>已收货待评价</span> 
														</c:if>
														<c:if test="${item.status ==  5 }">
															<span>交易成功</span>
														</c:if>
													</div>
												</li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div style="    margin-top: 15px;">
					<h4>给"订单商品"做出评价</h4>
					<p>请严肃认真对待此次评价哦！您的评价对我们真的真的非常重要！</p>
				</div>
				<div class="block">
					<ul>
						<li data-default-index="0"><span> <img
								src="/images/x1.png"> <img
								src="/images/x1.png"> <img
								src="/images/x1.png"> <img
								src="/images/x1.png"> <img
								src="/images/x1.png">
						</span> <em class="level"></em></li>
					</ul>
				</div>
				<div class="order-evaluation-text">本次交易，乖，摸摸头 给您留下了什么印象呢？</div>

				<div class="order-evaluation-textarea">
					<textarea name="content" id="TextArea1" onkeyup="words_deal();"></textarea>
					<span>还可以输入<em id="textCount">140</em>个字
					</span>
				</div>
				<a href="javascript:;" id="order_evaluation"><span
					style="font-size: 16px;">评价完成</span></a>
			</div>

			<div id="order_evaluate_modal" class="dmlei_tishi_info"></div>
		</div>
</body>
<script type="text/javascript" src="/js/comment.js"></script>
</html>