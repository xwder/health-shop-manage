<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#page {
	width: auto;
}

#comm-header-inner, #content {
	width: 1000px;
	margin: auto;
}

#logo {
	padding-top: 26px;
	padding-bottom: 12px;
}

#header .wrap-box {
	margin-top: -67px;
}

#logo .logo {
	position: relative;
	overflow: hidden;
	display: inline-block;
	width: 140px;
	height: 35px;
	font-size: 35px;
	line-height: 35px;
	color: #f40;
}

#logo .logo .i {
	position: absolute;
	width: 140px;
	height: 35px;
	top: 0;
	left: 0;
	background: url(http://a.tbcdn.cn/tbsp/img/header/logo.png);
}
</style>

</head>
<body data-spm="1">
	<div id="page">
		<div id="content" class="grid-c">
		
			<div id="address" class="address" style="margin-top: 20px;" data-spm="2">
					 <h3>
						<span style="float: left;font-size: 30px;"><h3>确认收货地址</h3></span>  
						<span class="manage-address"> 
						<a href="http://localhost:8885/user/address/useraddress.html" target="_blank" title="管理我的收货地址" class="J_MakePoint" >管理收货地址</a>
						</span>
					 </h3>
					 
					<ul id="address-list" class="address-list">
					
					<c:if test="${fn:length(addressList) > 0}">
						<c:forEach var="address" items="${addressList}">
							<li class="J_Addr J_MakePoint clearfix  J_DefaultAddr " >
								<s class="J_Marker marker"></s> 
								<span class="marker-tip">寄送至</span>
								<div class="address-info">
									<a href="#" class="J_Modify modify J_MakePoint" >修改本地址</a> 
									
										<c:if test="${address.defauladdress > 0}">
											<input name="addressradio" class="J_MakePoint "  type="radio" value="${address.province}${address.detailaddr} " id="${address.id }" checked="checked" > 
										</c:if>
										<c:if test="${address.defauladdress <= 0}">
											<input name="addressradio" class="J_MakePoint "  type="radio" value="${address.province}${address.detailaddr} " id="${address.id }"   > 
										</c:if>
										
									<label for="addrId_674944241" class="user-address"> ${address.province}   ${address.detailaddr}   (${address.receiptname}  收) <em>${address.receipphone}</em>
									</label> 
									<c:if test="${address.defauladdress > 0}">
										<em class="tip" >默认地址</em> 
									</c:if>
									<c:if test="${address.defauladdress <= 0}">
										<em class="tip" style="display: none">默认地址</em> 
										<em class="tip"> <a href="javaScript:" onclick="changeDefaultAddress(${address.id}); return false;">设置为默认地址</a></em> 
									</c:if>
								</div>
							</li>
						</c:forEach>
					 </c:if>
					 <c:if test="${fn:length(addressList) <= 0}">
					 	<em class="tip"> <a href="http://localhost:8885/user/address/useraddress.html">您还未添加收货地址，请添加收货地址！</a></em> 
					 </c:if>
					</ul>
					 

					<div class="address-bar">
						<span style="float: left;margin-left: 10px;"><a href="http://localhost:8885/user/address/useraddress.html" class="new J_MakePoint" id="J_NewAddressBtn">使用新地址</a></span>
					</div>

				 
			</div>
				<form name="addrForm" id="addrForm" action="/shop/buynoworder.html" onSubmit="return confirm();" method="POST">
				<div>
					<span style="float:left"><h3 class="dib">确认订单信息</h3></span>
					<table cellspacing="0" cellpadding="0" class="order-table"
						id="J_OrderTable" summary="统一下单订单信息区域">
						<caption style="display: none">统一下单订单信息区域</caption>
						<thead>
							<tr>
								<th class="s-title">店铺宝贝
									<hr />
								</th>
								<th class="s-price">单价(元)
									<hr />
								</th>
								<th class="s-amount">数量
									<hr />
								</th>
								<th class="s-agio">优惠方式(元)
									<hr />
								</th>
								<th class="s-total">小计(元)
									<hr />
								</th>
							</tr>
						</thead>
						<tbody data-spm="3" class="J_Shop" data-tbcbid="0"
							data-outorderid="47285539868" data-isb2c="false"
							data-postMode="2" data-sellerid="1704508670">
							<tr class="first">
								<td colspan="5"></td>
							</tr>
							<tr class="shop blue-line">
								<td colspan="3" style="text-align: left;">店铺：
									<a class="J_ShopName J_MakePoint" href="" target="_blank"  title="${orderStoreinfo.storename }">
										${orderStoreinfo.storename }
									</a> 
									<span class="seller">
										卖家：<a href="" target="_blank" class="J_MakePoint" >
											${orderStoreinfo.sname }
											</a>
									</span> 
								</td>
								<td colspan="2" class="promo">
									<div>
										<ul class="scrolling-promo-hint J_ScrollingPromoHint">
										</ul>
									</div>
								</td>
							</tr>
							
							<c:forEach var="oderitem" items="${orderitemList}">
								<tr class="item" data-pointRate="0">
									<td class="s-title">
										<a href="http://localhost:8883/${oderitem.pid}.html" 
											target="_blank"
											title="${oderitem.pname }"
											class="J_MakePoint" > 
											<img style="width:52px;height: 52px;" src="${oderitem.ppic }" class="itempic">
											<span class="title J_MakePoint" >${oderitem.pname } </span>
										</a>
										<a title="消费者保障服务，卖家承诺商品如实描述" href="#" target="_blank"> <img
											src="http://img03.taobaocdn.com/tps/i3/T1bnR4XEBhXXcQVo..-14-16.png" />
										</a>
										<div>
											<span style="color: gray;">卖家承诺72小时内发货</span>
										</div>
									</td>
									<td class="s-price"><span class='price '> 
										<em class="style-normal-small-black J_ItemPrice"><fmt:formatNumber type="number" value="${oderitem.pprice}" pattern="0.00" maxFractionDigits="2"/></em>
										</span> 
									</td>
									<td class="s-amount"  >
										${oderitem.count }
									</td>
									<td class="s-agio">
										<div class="J_Promotion promotion"  >无优惠</div>
									</td>
									<td class="s-total">
										<span class='price '> 
											<em class="style-normal-bold-red J_ItemTotal ">${oderitem.subtotal }</em>
										</span> 
									</td>
								</tr>
							</c:forEach>


							<tr class="item-service">
								<td colspan="5" class="servicearea" style="display: none"></td>
							</tr>

							<tr class="blue-line" style="height: 2px;">
								<td colspan="5"></td>
							</tr>
							<tr class="other other-line">
								<td colspan="5">
									<ul class="dib-wrap">
										<li class="dib user-info">
											<ul class="wrap">
												<li>
													<div class="field gbook">
														<label class="label">给卖家留言：</label>
														<textarea name="message" style="width: 350px; height: 80px; background-color: white;"
															title="选填：对本次交易的补充说明（建议填写已经和卖家达成一致的说明）"  ></textarea>
													</div>
												</li>
											</ul>
										</li>
										<li class="dib extra-info">

											<div class="shoparea">
												<ul class="dib-wrap">
													<li class="dib title">店铺优惠：</li>
													<li class="dib sel">
														<div class="J_ShopPromo J_Promotion promotion clearfix" ></div>
													</li>
													<li class="dib fee"><span class='price '> -<em
															class="style-normal-bold-black J_ShopPromo_Result">0.00</em>
													</span></li>
												</ul>
											</div>

											<div class="shoppointarea"></div>

											<div class="farearea">
												<ul class="dib-wrap J_farearea">
													<li class="dib title">运送方式：</li>
													<li class="dib sel"  >
														<select name="" class="J_Fare">
															<option data-fare="1500" value=" 2 "
																data-codServiceType="2" data-level=""
																selected="selected">快递 0.00元</option>
															<option data-fare="2500" value=" 7 "
																data-codServiceType="7" data-level="">EMS
																0.00元</option>
															<option data-fare="1500" value=" 1 "
																data-codServiceType="1" data-level="">平邮 0.00元</option>
														</select> 
														<em tabindex="0" class="J_FareFree" style="display: none">免邮费</em>
													</li>
													<li class="dib fee"><span class='price '> <em
															class="style-normal-bold-red J_FareSum">0.00</em>
													</span></li>
												</ul>
											</div>
											<div class="extra-area">
												<ul class="dib-wrap">
													<li class="dib title">发货时间：</li>
													<li class="dib content">卖家承诺订单在买家付款后，72小时内<a href="#">发货</a></li>
												</ul>
											</div>

											 
										</li>
									</ul>
								</td>
							</tr>

							<tr class="shop-total blue-line">
								<td colspan="5">店铺合计(<span class="J_Exclude"
									style="display: none">不</span>含运费<span class="J_ServiceText"
									style="display: none">，服务费</span>)： <span
									class='price g_price '> <span>&yen;</span><em
										class="style-middle-bold-red J_ShopTotal"> 
										<span style=" font-size: 16px; color: #e4393c; font-weight: 700;">
											<fmt:formatNumber type="number" value="${total}" pattern="0.00" maxFractionDigits="2"/>
										</span>
									</em>
								</span>  

								</td>
							</tr>
						</tbody>
						<tfoot>
							<tr>
								<td colspan="5">

									<div class="order-go" data-spm="4">
										<div class="J_AddressConfirm address-confirm">
											<div class="kd-popup pop-back" style="margin-bottom: 40px;">
												<div class="box">
													<div class="bd">
														<div class="point-in">

															<em class="t">应付款：</em> <span class='price g_price '>
																<span>&yen;</span><em class="style-large-bold-red" id="J_ActualFee">
																<fmt:formatNumber type="number" value="${total}" pattern="0.00" maxFractionDigits="2"/>
														   </em>
															</span>
														</div>
														<ul id="orderaddress">
															<li><em>寄送至:</em><span id="J_AddrConfirm"
																style="word-break: break-all;">${defaultAddress.province}   ${defaultAddress.detailaddr}</span></li>
															<li><em>收货人:</em><span id="J_AddrNameConfirm">${defaultAddress.receiptname}
																	${defaultAddress.receipphone}
															</span></li>
															<li><input  type="hidden" name="userPhone" value="${defaultAddress.receipphone}"/></li>
															<li><input name="userName" value="${defaultAddress.receiptname}" type="hidden"/></li>
															<li><input name="userAddr" value="${defaultAddress.detailaddr}" type="hidden"/></li>
														</ul>
													</div>
												</div>
												<a href="http://localhost:8883/shop/cart.html" class="back J_MakePoint" target="_top" >返回购物车</a> 
												<a href="javaScript:" onclick="createOrder(); return false;" id="J_Go" class=" btn-go" tabindex="0" title="点击此按钮，提交订单。">
													 
													<b class="dpl-button"></b>
												</a>
											</div>
										</div>

										<div class="J_confirmError confirm-error">
											<div class="msg J_shopPointError" style="display: none;">
												<p class="error">积分点数必须为大于0的整数</p>
											</div>
										</div>


										<div class="msg" style="clear: both;">
											<p class="tips naked" style="float: right; padding-right: 0">若价格变动，请在提交订单后联系卖家改价，并查看已买到的宝贝</p>
										</div>
									</div>
								</td>
							</tr>
						</tfoot>
					</table>
				</div>
 
			</form>
		</div>

		<div id="footer"></div>
	</div>

</body>
</html>