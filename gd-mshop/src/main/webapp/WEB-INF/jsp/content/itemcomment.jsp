<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<link rel="stylesheet" href="/css/comment.css">
<link href="/css/personal.css" rel="stylesheet" type="text/css">
<link href="/css/orstyle.css" rel="stylesheet" type="text/css">
<link href="/css/daohang.css" rel="stylesheet" type="text/css">

		<div class="modal-dialog" role="document" style="width:910px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">查看评价</h4>
				</div>
				<div class="modal-body">
	<div class="content_right">

		<div class="content_right_bottom">
			<div class="order-evaluation clearfix">
				<div>
					<div class="am-tab-panel am-fade am-in am-active" id="tab1">
					<div class="order-title">
							<span style="margin-left: 0px;">订单编号：<a href=" ">${order.id}</a></span>
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
													<a href=" ">
														<div class="item-pic" style="margin-top: 0px;">
															<img alt="" src="${item.ppic}" style="width: 80px;height:80px; ">
														</div>
													</a>
													<div class="item-info">
														<div class="item-basic-info" style="padding-top: 19px">
															<a href=""> 
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
					<p>购买用户：${commentUser.username }   &nbsp;&nbsp;&nbsp;评论内容：</p>
				</div>
				<div class="block">
					<ul>
						<li data-default-index="0">
							<span> 
								<c:forEach begin="1" end="${comment.comlevel }" >
										<img src="/image/x2.png">
								</c:forEach>
								<c:forEach begin="1" end="${5 - comment.comlevel }" >
										<img src="/image/x1.png">
								</c:forEach>
								 
							</span> 
							<em class="level">
								<c:if test="${comment.comlevel == 1}">
									差评
								</c:if>
								<c:if test="${comment.comlevel == 2}">
									较差
								</c:if>
								<c:if test="${comment.comlevel == 3}">
									中等
								</c:if>
								<c:if test="${comment.comlevel == 4}">
									一般
								</c:if>
								<c:if test="${comment.comlevel == 5}">
									好评
								</c:if>
							</em>
							<span style="margin-left: 20px;">评论类型: </span>
							<em class="level" style="display: ;">
								<c:if test="${comment.comtype == 1}">
									好评
								</c:if>
								<c:if test="${comment.comtype == 2}">
									中评
								</c:if>
								<c:if test="${comment.comtype == 3}">
									差评
								</c:if>
							</em>
						</li>
					</ul>
				</div>
				<div>
					<div style="margin-top: 20px;">
						<p style="font-size: 14px;  color: #999; line-height: 45px; margin-bottom: 0;">评论类容: </p> <span class="level">&nbsp;&nbsp;&nbsp;${comment.comtext }</span> 
					</div>
				</div>
			</div>
		</div>
					</div>
				</div>
			</div>
		</div>
