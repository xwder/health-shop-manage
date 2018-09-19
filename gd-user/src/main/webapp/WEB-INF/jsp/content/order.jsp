<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 

<style>
body,div,p,h3,ul,input{ margin:0; padding:0;}
body{ font-size:12px; font-family:'微软雅黑',Verdana,"Lucida Grande","Lucida Sans",sans; color:#333;}
.warpper img{ border:none;}
.warpper a{text-decoration:none;color:; }
.warpper a:hover { text-decoration:underline; color:#f60;}
.warpper.b{ font-weight:bold;}
.warpper .font16{ font-size:16px;}
.warpper .fl{ float:left;}
/* 清除浮动 */
.warpper .clearfix:after{content:""; display:block; height:0; font-size:0; clear:both;}
.warpper .clearfix {zoom:1;}

.head{ width:1000px; height:160px; border-bottom:1px solid #ccc; margin:0 auto; }
	.head .logo{ display:inline-block;}
	
.warpper{ width:1000px; margin:0 auto;}
.content{ width:520px; min-height:189px; _height:189px; padding:50px 0 0 210px; margin:100px 0 120px 180px; background:url(/images/404/bg404.jpg) no-repeat;}

.falseCode{ width:300px; padding-right:20px; border-right:1px solid #ccc; text-align:right; font-size:40px; font-family:Arial,Helvetica,sans-serif; color:#999; float:left;     margin-bottom: 20px;}
.falseText{ width:380px; padding-left:20px; float:left; line-height:2;}

</style>

<html>
<body>
 <div class="content_right">
	<div class="user-order">

		<!--标题 -->
		<div class="am-cf am-padding">
			<div class="am-fl am-cf">
				<strong class="am-text-danger am-text-lg">订单管理</strong> / <small>Order</small>
			</div>
		</div>
		
	<c:if test="${fn:length(allOrderPageBean.list)!=0}">
			<div class="am-tabs am-tabs-d2 am-margin" data-am-tabs>
				 	<ul class="am-avg-sm-6 am-tabs-nav am-nav am-nav-tabs">
						<c:if test="${orderStates == 0}">
							<li class="am-active"><a href="#tab1">所有订单</a></li>
						</c:if>
						<c:if test="${orderStates != 0}">
							<li class=""><a href="#tab1">所有订单</a></li>
						</c:if>
						<c:if test="${orderStates == 1}">
							<li class="am-active"><a href="#tab2" >待商家接单</a></li>
						</c:if>
						<c:if test="${orderStates != 1}">
							<li><a href="#tab2">待商家接单</a></li>
						</c:if>
						<c:if test="${orderStates == 2}">
							<li class="am-active"><a href="#tab3">商家拒接单</a></li>
						</c:if>
						<c:if test="${orderStates != 2}">
							<li ><a href="#tab3">商家拒接单</a></li>
						</c:if>
						<c:if test="${orderStates == 3}">
							<li class="am-active"><a href="#tab4">商家接单配送中</a></li>
						</c:if>
						<c:if test="${orderStates != 3}">
							<li><a href="#tab4">商家接单配送中</a></li>
						</c:if>
						<c:if test="${orderStates == 4}">
							<li class="am-active"><a href="#tab5">已收货待评价</a></li>
						</c:if>
						<c:if test="${orderStates != 4}">
							 <li><a href="#tab5">已收货待评价</a></li>
						</c:if>
						<c:if test="${orderStates == 5}">
							 <li class="am-active"><a href="#tab6">交易完成</a></li>
						</c:if>
						<c:if test="${orderStates != 5}">
							 <li><a href="#tab6">交易完成</a></li>
						</c:if>
					</ul>
	 
	
				<div class="am-tabs-bd">
					<div  
						  <c:if test="${orderStates == 0}">class="am-tab-panel am-fade am-in am-active"</c:if>
						  <c:if test="${orderStates != 0}">class="am-tab-panel am-fade"</c:if>
					 id="tab1">
						<div class="order-top">
							<div class="th th-item">
								<td class="td-inner">商品</td>
							</div>
							<div class="th th-price">
								<td class="td-inner">单价</td>
							</div>
							<div class="th th-number">
								<td class="td-inner">数量</td>
							</div>
							<div class="th th-operation">
								<td class="td-inner">商品操作</td>
							</div>
							<div class="th th-amount">
								<td class="td-inner">合计</td>
							</div>
							<div class="th th-status">
								<td class="td-inner">交易状态</td>
							</div>
							<div class="th th-change">
								<td class="td-inner">交易操作</td>
							</div>
						</div>
	
						<div class="order-main">
							<div class="order-list">
	
								<!--所有订单-->
								<div class="order-status5">
								
									<c:if test="${fn:length(allOrderPageBean.list)!=0}">
										<c:forEach var = "orderInfo"  items="${allOrderPageBean.list }">
											<div class="order-title">
												<div class="dd-num">
													订单编号：<a href="http://localhost:8883/shop/orderinfo.html?orderid=${orderInfo.order.id }">${orderInfo.order.id }</a>
												</div>
												<span>下单时间：<fmt:formatDate value="${orderInfo.order.ordertime }" type="both" /></span>
												<!--    <em>店铺：小桔灯</em>-->
											</div>
											<div class="order-content">
												<div class="order-left">
												<%-- <c:if test="${fn:length(allOrderPageBean.list)!=0}"> --%>
													<c:forEach var="orderitem" items="${orderInfo.orderitemList}">
														<ul class="item-list">
															<li class="td td-item">
																<div class="item-pic">
																	<a href="http://localhost:8883/${orderitem.pid}.html" class="J_MakePoint"> 
																		<%-- <img style="width: 80px,height:80px;"
																			src="${orderitem.ppic }"
																			class="itempic J_ItemImg"> --%>
																			<img src="${orderitem.ppic }" alt="shopping" style="width: 80px; height: 80px;" />
																	</a>
																</div>
																
																<div class="item-info">
																	<div class="item-basic-info">
																		<a href="#">
																			<p><a href="http://localhost:8883/${orderitem.pid}.html">${orderitem.pname }</a></p>
																			<!-- <p class="info-little">
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
															 <fmt:formatNumber type="number" value="${orderInfo.order.total}" maxFractionDigits="2"/>￥
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
																	<a href="http://localhost:8883/shop/orderinfo.html?orderid=${orderInfo.order.id}">订单详情</a>
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
									</c:if>
								</div>
							</div>
						</div>
						
						<div class="pagelist">
						  <ul>
						 	   <li><a href="http://localhost:8885/user/order.html?orderStates=0&page=1">首页</a></li>
						 	   
						    <c:if test="${allOrderPageBean.pageNum != 1 }">
						 	   <li><a href="http://localhost:8885/user/order.html?orderStates=0&page=${allOrderPageBean.pageNum -1}">上页</a></li>
						    </c:if>
						    <c:forEach var ="i" begin="${allOrderPageBean.pageNum }" end="${allOrderPageBean.pageNum + 3 }">
									<c:if test="${i <  allOrderPageBean.pages}">
										<c:if test="${i ==  allOrderPageBean.pageNum}">
											<li><a href="http://localhost:8885/user/order.html?orderStates=0&&page=${i}" class="current">${i}</a></li>
										</c:if>
										<c:if test="${i !=  allOrderPageBean.pageNum}">
											<li><a href="http://localhost:8885/user/order.html?orderStates=0&&page=${i}" class="">${i}</a></li>
										</c:if>
									</c:if>
							</c:forEach>
							<li>···</li>
							<li><a href="http://localhost:8885/user/order.html?orderStates=0&&page=${allOrderPageBean.pages}" class="">${allOrderPageBean.pages}</a></li>
						    <c:if test="${allOrderPageBean.pageNum != allOrderPageBean.pages}">
						    	 <li><a href="http://localhost:8885/user/order.html?orderStates=0&page=${allOrderPageBean.pageNum +1}">下页</a></li>
							</c:if>
							<c:if test="${allOrderPageBean.pageNum != allOrderPageBean.pages}">
								<li><a href="http://localhost:8885/user/order.html?orderStates=0&page=${allOrderPageBean.pages}">尾页</a></li>
							</c:if>
						    
						     
						     
						    <li class="pageinfo">第${allOrderPageBean.pageNum}页/共${allOrderPageBean.pages}页</li>
						    
						  </ul>
						</div>
					</div>
					<div  
						  <c:if test="${orderStates == 1}">class="am-tab-panel am-fade am-in am-active"</c:if>
						  <c:if test="${orderStates != 1}">class="am-tab-panel am-fade  "</c:if>
					 id="tab2">
						<div class="order-top">
							<div class="th th-item">
								<td class="td-inner">商品</td>
							</div>
							<div class="th th-price">
								<td class="td-inner">单价</td>
							</div>
							<div class="th th-number">
								<td class="td-inner">数量</td>
							</div>
							<div class="th th-operation">
								<td class="td-inner">商品操作</td>
							</div>
							<div class="th th-amount">
								<td class="td-inner">合计</td>
							</div>
							<div class="th th-status">
								<td class="td-inner">交易状态</td>
							</div>
							<div class="th th-change">
								<td class="td-inner">交易操作</td>
							</div>
						</div>
	
						<div class="order-main">
							<div class="order-list">
								<div class="order-status1">
									<c:if test="${fn:length(waitOrderPageBean.list)!=0}">
										<c:forEach var = "orderInfo"  items="${waitOrderPageBean.list }">
											<div class="order-title">
												<div class="dd-num">
													订单编号：<a href="http://localhost:8883/shop/orderinfo.html?orderid=${orderInfo.order.id }">${orderInfo.order.id }</a>
												</div>
												<span>下单时间：<fmt:formatDate value="${orderInfo.order.ordertime }" type="both" /></span>
												<!--    <em>店铺：小桔灯</em>-->
											</div>
											<div class="order-content">
												<div class="order-left">
												<c:if test="${fn:length(allOrderPageBean.list)!=0}">
													<c:forEach var="orderitem" items="${orderInfo.orderitemList}">
														<ul class="item-list">
															<li class="td td-item">
																<div class="item-pic">
																	<a href="http://localhost:8883/${orderitem.pid}.html" class="J_MakePoint"> 
																		<%-- <img style="width: 80px,height:80px;"
																			src="${orderitem.ppic }"
																			class="itempic J_ItemImg"> --%>
																			<img src="${orderitem.ppic }" alt="shopping" style="width: 80px; height: 80px;" />
																	</a>
																</div>
																
																<div class="item-info">
																	<div class="item-basic-info">
																		<a href="#">
																			<p><a href="http://localhost:8883/${orderitem.pid}.html">${orderitem.pname }</a></p>
																			<!-- <p class="info-little">
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
																<div class="item-operation"></div>
															</li>
														</ul>
													</c:forEach>
												</c:if>
												 
												</div>
												
												
												<div class="order-right">
													<li class="td td-amount">
														<div class="item-amount">
															合计：
															<fmt:formatNumber type="number" value="${orderInfo.order.total}" maxFractionDigits="2"/>
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
																	<a href="http://localhost:8883/shop/orderinfo.html?orderid=${orderInfo.order.id}">订单详情</a>
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
									</c:if>
								</div>
							</div>
	
						</div>
						<div class="pagelist">
						  <ul>
						 	   <li><a href="http://localhost:8885/user/order.html?orderStates=1&page=1">首页</a></li>
						 	   
						    <c:if test="${waitOrderPageBean.pageNum != 1 }">
						 	   <li><a href="http://localhost:8885/user/order.html?orderStates=1&page=${waitOrderPageBean.pageNum -1}">上页</a></li>
						    </c:if>
						    <c:forEach var ="i" begin="${waitOrderPageBean.pageNum }" end="${waitOrderPageBean.pageNum + 3 }">
									<c:if test="${i <  waitOrderPageBean.pages}">
										<c:if test="${i ==  waitOrderPageBean.pageNum}">
											<li><a href="http://localhost:8885/user/order.html?orderStates=1&&page=${i}" class="current">${i}</a></li>
										</c:if>
										<c:if test="${i !=  waitOrderPageBean.pageNum}">
											<li><a href="http://localhost:8885/user/order.html?orderStates=1&&page=${i}" class="">${i}</a></li>
										</c:if>
									</c:if>
							</c:forEach>
							<li>···</li>
							<li><a href="http://localhost:8885/user/order.html?orderStates=1&&page=${waitOrderPageBean.pages}" class="">${waitOrderPageBean.pages}</a></li>
						    <c:if test="${waitOrderPageBean.pageNum != waitOrderPageBean.pages}">
						    	 <li><a href="http://localhost:8885/user/order.html?orderStates=1&page=${waitOrderPageBean.pageNum +1}">下页</a></li>
							</c:if>
							<c:if test="${waitOrderPageBean.pageNum != waitOrderPageBean.pages}">
								<li><a href="http://localhost:8885/user/order.html?orderStates=1&page=${waitOrderPageBean.pages}">尾页</a></li>
							</c:if>
						    
						     
						     
						    <li class="pageinfo">第${waitOrderPageBean.pageNum}页/共${waitOrderPageBean.pages}页</li>
						  </ul>
						</div>
					</div>
					<div  
						  <c:if test="${orderStates == 2}">class="am-tab-panel am-fade am-in am-active"</c:if>
						  <c:if test="${orderStates != 2}">class="am-tab-panel am-fade  "</c:if>
					 id="tab3">
						<div class="order-top">
							<div class="th th-item">
								<td class="td-inner">商品</td>
							</div>
							<div class="th th-price">
								<td class="td-inner">单价</td>
							</div>
							<div class="th th-number">
								<td class="td-inner">数量</td>
							</div>
							<div class="th th-operation">
								<td class="td-inner">商品操作</td>
							</div>
							<div class="th th-amount">
								<td class="td-inner">合计</td>
							</div>
							<div class="th th-status">
								<td class="td-inner">交易状态</td>
							</div>
							<div class="th th-change">
								<td class="td-inner">交易操作</td>
							</div>
						</div>
	
						<div class="order-main">
							<div class="order-list">
								<div class="order-status2">
	 								<c:if test="${fn:length(refuseOrderPageBean.list)!=0}">
										<c:forEach var = "orderInfo"  items="${refuseOrderPageBean.list }">
											<div class="order-title">
												<div class="dd-num">
													订单编号：<a href="http://localhost:8883/shop/orderinfo.html?orderid=${orderInfo.order.id }">${orderInfo.order.id }</a>
												</div>
												<span>下单时间：<fmt:formatDate value="${orderInfo.order.ordertime }" type="both" /></span>
												<!--    <em>店铺：小桔灯</em>-->
											</div>
											<div class="order-content">
												<div class="order-left">
												<c:if test="${fn:length(allOrderPageBean.list)!=0}">
													<c:forEach var="orderitem" items="${orderInfo.orderitemList}">
														<ul class="item-list">
															<li class="td td-item">
																<div class="item-pic">
																	<a href="http://localhost:8883/${orderitem.pid}.html" class="J_MakePoint"> 
																		<%-- <img style="width: 80px,height:80px;"
																			src="${orderitem.ppic }"
																			class="itempic J_ItemImg"> --%>
																			<img src="${orderitem.ppic }" alt="shopping" style="width: 80px; height: 80px;" />
																	</a>
																</div>
																
																<div class="item-info">
																	<div class="item-basic-info">
																		<a href="#">
																			<p><a href="http://localhost:8883/${orderitem.pid}.html">${orderitem.pname }</a></p>
																			<!-- <p class="info-little">
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
																<div class="item-operation"></div>
															</li>
														</ul>
													</c:forEach>
												</c:if>
												 
												</div>
												
												
												<div class="order-right">
													<li class="td td-amount">
														<div class="item-amount">
															合计：
															<fmt:formatNumber type="number" value="${orderInfo.order.total}" maxFractionDigits="2"/>￥
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
																	<a href="http://localhost:8883/shop/orderinfo.html?orderid=${orderInfo.order.id}">订单详情</a>
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
									</c:if>
								</div>
							</div>
						</div>
						<div class="pagelist">
						  <ul>
						 	   <li><a href="http://localhost:8885/user/order.html?orderStates=2&page=1">首页</a></li>
						 	   
						    <c:if test="${refuseOrderPageBean.pageNum != 1 }">
						 	   <li><a href="http://localhost:8885/user/order.html?orderStates=2&page=${refuseOrderPageBean.pageNum -1}">上页</a></li>
						    </c:if>
						    <c:forEach var ="i" begin="${refuseOrderPageBean.pageNum }" end="${refuseOrderPageBean.pageNum + 3 }">
									<c:if test="${i <  refuseOrderPageBean.pages}">
										<c:if test="${i ==  refuseOrderPageBean.pageNum}">
											<li><a href="http://localhost:8885/user/order.html?orderStates=2&&page=${i}" class="current">${i}</a></li>
										</c:if>
										<c:if test="${i !=  refuseOrderPageBean.pageNum}">
											<li><a href="http://localhost:8885/user/order.html?orderStates=2&&page=${i}" class="">${i}</a></li>
										</c:if>
									</c:if>
							</c:forEach>
							<li>···</li>
							<li><a href="http://localhost:8885/user/order.html?orderStates=2&&page=${refuseOrderPageBean.pages}" class="">${refuseOrderPageBean.pages}</a></li>
						    
						    <c:if test="${refuseOrderPageBean.pageNum != refuseOrderPageBean.pages}">
						    	 <li><a href="http://localhost:8885/user/order.html?orderStates=2&page=${refuseOrderPageBean.pageNum +1}">下页</a></li>
							</c:if>
							<c:if test="${refuseOrderPageBean.pageNum != refuseOrderPageBean.pages}">
								<li><a href="http://localhost:8885/user/order.html?orderStates=2&page=${refuseOrderPageBean.pages}">尾页</a></li>
							</c:if>
						     
						    <li class="pageinfo">第${refuseOrderPageBean.pageNum}页/共${refuseOrderPageBean.pages}页</li>
						  </ul>
						</div>
					</div>
					<div  
						  <c:if test="${orderStates == 3}">class="am-tab-panel am-fade am-in am-active"</c:if>
						  <c:if test="${orderStates != 3}">class="am-tab-panel am-fade "</c:if>
					 id="tab4">
						<div class="order-top">
							<div class="th th-item">
								<td class="td-inner">商品</td>
							</div>
							<div class="th th-price">
								<td class="td-inner">单价</td>
							</div>
							<div class="th th-number">
								<td class="td-inner">数量</td>
							</div>
							<div class="th th-operation">
								<td class="td-inner">商品操作</td>
							</div>
							<div class="th th-amount">
								<td class="td-inner">合计</td>
							</div>
							<div class="th th-status">
								<td class="td-inner">交易状态</td>
							</div>
							<div class="th th-change">
								<td class="td-inner">交易操作</td>
							</div>
						</div>
	
						<div class="order-main">
							<div class="order-list">
								<div class="order-status3">
									<c:if test="${fn:length(dispatchingOrderPageBean.list)!=0}">
										<c:forEach var = "orderInfo"  items="${dispatchingOrderPageBean.list }">
											<div class="order-title">
												<div class="dd-num">
													订单编号：<a href="http://localhost:8883/shop/orderinfo.html?orderid=${orderInfo.order.id }">${orderInfo.order.id }</a>
												</div>
												<span>下单时间：<fmt:formatDate value="${orderInfo.order.ordertime }" type="both" /></span>
												<span><a href="/user/updateorderstatus/${ orderInfo.order.id}/4.html">确定收货</a></span>
											</div>
											<div class="order-content">
												<div class="order-left">
												<c:if test="${fn:length(allOrderPageBean.list)!=0}">
													<c:forEach var="orderitem" items="${orderInfo.orderitemList}">
														<ul class="item-list">
															<li class="td td-item">
																<div class="item-pic">
																	<a href="http://localhost:8883/${orderitem.pid}.html" class="J_MakePoint"> 
																		<%-- <img style="width: 80px,height:80px;"
																			src="${orderitem.ppic }"
																			class="itempic J_ItemImg"> --%>
																			<img src="${orderitem.ppic }" alt="shopping" style="width: 80px; height: 80px;" />
																	</a>
																</div>
																
																<div class="item-info">
																	<div class="item-basic-info">
																		<a href="#">
																			<p><a href="http://localhost:8883/${orderitem.pid}.html">${orderitem.pname }</a></p>
																			<!-- <p class="info-little">
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
																<div class="item-operation"><a href="/user/updateorderstatus/${ orderInfo.order.id}/4.html">确定收货</a></div>
															</li>
														</ul>
													</c:forEach>
												</c:if>
												 
												</div>
												
												
												<div class="order-right">
													<li class="td td-amount">
														<div class="item-amount">
															合计：
															<fmt:formatNumber type="number" value="${orderInfo.order.total}" maxFractionDigits="2"/>￥
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
																	<a href="http://localhost:8883/shop/orderinfo.html?orderid=${orderInfo.order.id}">订单详情</a>
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
									</c:if>
								</div>
							</div>
						</div>
						<div class="pagelist">
						  <ul>
						 	   <li><a href="http://localhost:8885/user/order.html?orderStates=3&page=1">首页</a></li>
						 	   
						    <c:if test="${dispatchingOrderPageBean.pageNum != 1 }">
						 	   <li><a href="http://localhost:8885/user/order.html?orderStates=3&page=${dispatchingOrderPageBean.pageNum -1}">上页</a></li>
						    </c:if>
						    <c:forEach var ="i" begin="${dispatchingOrderPageBean.pageNum }" end="${dispatchingOrderPageBean.pageNum + 3 }">
									<c:if test="${i <  dispatchingOrderPageBean.pages}">
										<c:if test="${i ==  dispatchingOrderPageBean.pageNum}">
											<li><a href="http://localhost:8885/user/order.html?orderStates=3&&page=${i}" class="current">${i}</a></li>
										</c:if>
										<c:if test="${i !=  dispatchingOrderPageBean.pageNum}">
											<li><a href="http://localhost:8885/user/order.html?orderStates=3&&page=${i}" class="">${i}</a></li>
										</c:if>
									</c:if>
							</c:forEach>
							<li>···</li>
							<li><a href="http://localhost:8885/user/order.html?orderStates=3&&page=${dispatchingOrderPageBean.pages}" class="">${dispatchingOrderPageBean.pages}</a></li>
						    
						    <c:if test="${dispatchingOrderPageBean.pageNum != dispatchingOrderPageBean.pages}">
						    	 <li><a href="http://localhost:8885/user/order.html?orderStates=3&page=${dispatchingOrderPageBean.pageNum +1}">下页</a></li>
							</c:if>
							<c:if test="${dispatchingOrderPageBean.pageNum != dispatchingOrderPageBean.pages}">
								<li><a href="http://localhost:8885/user/order.html?orderStates=3&page=${dispatchingOrderPageBean.pages}">尾页</a></li>
							</c:if>
						     
						    <li class="pageinfo">第${dispatchingOrderPageBean.pageNum}页/共${dispatchingOrderPageBean.pages}页</li>
						  </ul>
						</div>
					</div>
					<div  
						  <c:if test="${orderStates == 4}">class="am-tab-panel am-fade am-in am-active"</c:if>
						  <c:if test="${orderStates != 4}">class="am-tab-panel am-fade "</c:if>
					 id="tab5">
						<div class="order-top">
							<div class="th th-item">
								<td class="td-inner">商品</td>
							</div>
							<div class="th th-price">
								<td class="td-inner">单价</td>
							</div>
							<div class="th th-number">
								<td class="td-inner">数量</td>
							</div>
							<div class="th th-operation">
								<td class="td-inner">商品操作</td>
							</div>
							<div class="th th-amount">
								<td class="td-inner">合计</td>
							</div>
							<div class="th th-status">
								<td class="td-inner">交易状态</td>
							</div>
							<div class="th th-change">
								<td class="td-inner">交易操作</td>
							</div>
						</div>
						<div class="order-main">
							<div class="order-list">
								<!--不同状态的订单	-->
								<div class="order-status4">
	 								<c:if test="${fn:length(receiptPageBean.list)!=0}">
										<c:forEach var = "orderInfo"  items="${receiptPageBean.list }">
											<div class="order-title">
												<div class="dd-num">
													订单编号：<a href="http://localhost:8883/shop/orderinfo.html?orderid=${orderInfo.order.id }">${orderInfo.order.id }</a>
												</div>
												<span>下单时间：<fmt:formatDate value="${orderInfo.order.ordertime }" type="both" /></span>
											</div>
											<div class="order-content">
												<div class="order-left">
												<c:if test="${fn:length(allOrderPageBean.list)!=0}">
													<c:forEach var="orderitem" items="${orderInfo.orderitemList}">
														<ul class="item-list">
															<li class="td td-item">
																<div class="item-pic">
																	<a href="http://localhost:8883/${orderitem.pid}.html" class="J_MakePoint"> 
																		<%-- <img style="width: 80px,height:80px;"
																			src="${orderitem.ppic }"
																			class="itempic J_ItemImg"> --%>
																			<img src="${orderitem.ppic }" alt="shopping" style="width: 80px; height: 80px;" />
																	</a>
																</div>
																
																<div class="item-info">
																	<div class="item-basic-info">
																		<a href="#">
																			<p><a href="http://localhost:8883/${orderitem.pid}.html">${orderitem.pname }</a></p>
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
												</c:if>
												 
												</div>
												
												
												<div class="order-right">
													<li class="td td-amount">
														<div class="item-amount">
															合计： 
															<fmt:formatNumber type="number" value="${orderInfo.order.total}" maxFractionDigits="2"/>￥
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
																	<a href="http://localhost:8883/shop/orderinfo.html?orderid=${orderInfo.order.id}">订单详情</a>
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
									</c:if>
								</div>
							</div>
	
						</div>
	
						<div class="pagelist">
						  <ul>
						 	   <li><a href="http://localhost:8885/user/order.html?orderStates=4&page=1">首页</a></li>
						 	   
						    <c:if test="${receiptPageBean.pageNum != 1 }">
						 	   <li><a href="http://localhost:8885/user/order.html?orderStates=orderStates=4&page=${receiptPageBean.pageNum -1}">上页</a></li>
						    </c:if>
						    <c:forEach var ="i" begin="${receiptPageBean.pageNum }" end="${receiptPageBean.pageNum + 3 }">
									<c:if test="${i <  receiptPageBean.pages}">
										<c:if test="${i ==  receiptPageBean.pageNum}">
											<li><a href="http://localhost:8885/user/order.html?orderStates=4&&page=${i}" class="current">${i}</a></li>
										</c:if>
										<c:if test="${i !=  receiptPageBean.pageNum}">
											<li><a href="http://localhost:8885/user/order.html?orderStates=4&&page=${i}" class="">${i}</a></li>
										</c:if>
									</c:if>
							</c:forEach>
							<li>···</li>
							<li><a href="http://localhost:8885/user/order.html?orderStates=4&&page=${receiptPageBean.pages}" class="">${receiptPageBean.pages}</a></li>
						    
						    <c:if test="${receiptPageBean.pageNum != receiptPageBean.pages}">
						    	 <li><a href="http://localhost:8885/user/order.html?orderStates=4&page=${receiptPageBean.pageNum +1}">下页</a></li>
							</c:if>
							<c:if test="${receiptPageBean.pageNum != receiptPageBean.pages}">
								<li><a href="http://localhost:8885/user/order.html?orderStates=4&page=${receiptPageBean.pages}">尾页</a></li>
							</c:if>
						     
						    <li class="pageinfo">第${receiptPageBean.pageNum}页/共${receiptPageBean.pages}页</li>
						  </ul>
						</div>
					</div>
					<div  
						  <c:if test="${orderStates == 5}">class="am-tab-panel am-fade am-in am-active"</c:if>
						  <c:if test="${orderStates != 5}">class="am-tab-panel am-fade "</c:if>
					 id="tab6">
						<div class="order-top">
							<div class="th th-item">
								<td class="td-inner">商品</td>
							</div>
							<div class="th th-price">
								<td class="td-inner">单价</td>
							</div>
							<div class="th th-number">
								<td class="td-inner">数量</td>
							</div>
							<div class="th th-operation">
								<td class="td-inner">商品操作</td>
							</div>
							<div class="th th-amount">
								<td class="td-inner">合计</td>
							</div>
							<div class="th th-status">
								<td class="td-inner">交易状态</td>
							</div>
							<div class="th th-change">
								<td class="td-inner">交易操作</td>
							</div>
						</div>
						<div class="order-main">
							<div class="order-list">
								<!--不同状态的订单	-->
								<div class="order-status4">
	 								<c:if test="${fn:length(completePageBean.list)!=0}">
										<c:forEach var = "orderInfo"  items="${completePageBean.list }">
											<div class="order-title">
												<div class="dd-num">
													订单编号：<a href="http://localhost:8883/shop/orderinfo.html?orderid=${orderInfo.order.id }">${orderInfo.order.id }</a>
												</div>
												<span>下单时间：<fmt:formatDate value="${orderInfo.order.ordertime }" type="both" /></span>
												<!--    <em>店铺：小桔灯</em>-->
											</div>
											<div class="order-content">
												<div class="order-left">
												<c:if test="${fn:length(allOrderPageBean.list)!=0}">
													<c:forEach var="orderitem" items="${orderInfo.orderitemList}">
														<ul class="item-list">
															<li class="td td-item">
																<div class="item-pic">
																	<a href="http://localhost:8883/${orderitem.pid}.html" class="J_MakePoint"> 
																		<%-- <img style="width: 80px,height:80px;"
																			src="${orderitem.ppic }"
																			class="itempic J_ItemImg"> --%>
																			<img src="${orderitem.ppic }" alt="shopping" style="width: 80px; height: 80px;" />
																	</a>
																</div>
																
																<div class="item-info">
																	<div class="item-basic-info">
																		<a href="#">
																			<p><a href="http://localhost:8883/${orderitem.pid}.html">${orderitem.pname }</a></p>
																			<!-- <p class="info-little">
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
																	<a href="/user/itemcomment.html?itemid=${orderitem.count}">查看评价</a>
																</div>
															</li>
														</ul>
													</c:forEach>
												</c:if>
												 
												</div>
												
												
												<div class="order-right">
													<li class="td td-amount">
														<div class="item-amount">
															合计：
															<fmt:formatNumber type="number" value="${orderInfo.order.total}" maxFractionDigits="2"/>￥
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
																	<a href="http://localhost:8883/shop/orderinfo.html?orderid=${orderInfo.order.id}">订单详情</a>
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
									</c:if>
								</div>
							</div>
	
	
						</div>
	
						<div class="pagelist">
						  <ul>
						 	   <li><a href="http://localhost:8885/user/order.html?orderStates=5&page=1">首页</a></li>
						 	   
						    <c:if test="${completePageBean.pageNum != 1 }">
						 	   <li><a href="http://localhost:8885/user/order.html?orderStates=5&page=${completePageBean.pageNum -1}">上页</a></li>
						    </c:if>
						    <c:forEach var ="i" begin="${completePageBean.pageNum }" end="${completePageBean.pageNum + 3 }">
									<c:if test="${i <  completePageBean.pages}">
										<c:if test="${i ==  completePageBean.pageNum}">
											<li><a href="http://localhost:8885/user/order.html?orderStates=5&&page=${i}" class="current">${i}</a></li>
										</c:if>
										<c:if test="${i !=  completePageBean.pageNum}">
											<li><a href="http://localhost:8885/user/order.html?orderStates=5&&page=${i}" class="">${i}</a></li>
										</c:if>
									</c:if>
							</c:forEach>
							<li>···</li>
							<li><a href="http://localhost:8885/user/order.html?orderStates=5&&page=${completePageBean.pages}" class="">${completePageBean.pages}</a></li>
						    
						    <c:if test="${completePageBean.pageNum != completePageBean.pages}">
						    	 <li><a href="http://localhost:8885/user/order.html?orderStates=5&page=${completePageBean.pageNum +1}">下页</a></li>
							</c:if>
							<c:if test="${completePageBean.pageNum != completePageBean.pages}">
								<li><a href="http://localhost:8885/user/order.html?orderStates=5&page=${completePageBean.pages}">尾页</a></li>
							</c:if>
						     
						    <li class="pageinfo">第${completePageBean.pageNum}页/共${completePageBean.pages}页</li>
						  </ul>
						</div>
					</div>
				</div>
	
			</div>
			
		</c:if>
		<c:if test="${fn:length(allOrderPageBean.list) ==0}">
			
				<div class="warpper">
					 	<div class="content clearfix">
							<div class="falseCode">/(ㄒoㄒ)/~~</div>
							<div class="falseText">
								<p class="font16 b" style="text-align: center;" >您还未下单！</p>
								<p>&nbsp;</p>
								<p class="b" style="text-align: center;"><span class="red" id="404_time">10</span> 秒之后会自动跳转所有商品页面，您还可以：</p>
								<p class="b" style="text-align: center">1）<a style="color:#f60;" title="返回首页" href="http://localhost:8881/">返回健康购首页</a></p>
								<p class="b" style="text-align: center">2）去其它地方逛逛：<a style="color:#f60;" title="" href="http://localhost:8880/zixun/%E8%B5%84%E8%AE%AF%E9%A6%96%E9%A1%B5.html">浏览健康资讯</a> | 
								<a style="color:#f60;" title=" " href="http://localhost:8883/list.html">显示所有商品</a> 
							</div>
						</div>
					</div>
		</c:if>
	</div>
	</div>
</body>
</html>