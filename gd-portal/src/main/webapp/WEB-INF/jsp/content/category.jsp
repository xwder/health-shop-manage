<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<div id="category">
		<div id="category_left">
			<div>
				<div class="hot">
					<div class="hot_name hot_name_thing">
						<h3 class="box_tit" style="color: white; font-weight: 600;">热门宝贝</h3>
					</div>

					<div class="www360buy">
						<div class="hd">
							<ul>
								<li class="on">蔬菜</li>
								<li class=" ">水果</li>
								<li class=" ">肉类</li>
								<li class=" ">熟食</li>
								<li class=" ">谷物</li>
							</ul>
						</div>
						<div class="bd">
							<ul class="lh" style="display: none;">

								<c:forEach var="item" items="${hotVeItemList }">
									<li>
										<div class="p-img ld">
											<a href="http://localhost:8883/${item.id }.html"><img src="${item.ppic }" style="width: 100px; height: 100px;"></a>
										</div>
										<div class="p-name">
											<a href="http://localhost:8883/${item.id }.html">${item.pname }</a>
										</div>
										<div class="p-price">
											<a href="http://localhost:8883/${item.id }.html">优惠价：<strong>￥${item.pprice }</strong></a>
										</div>
									</li>
								</c:forEach>
							</ul>
							<ul class="lh" style="display: none;">
								<c:forEach var="item" items="${hotFruItemList }">
									<li>
										<div class="p-img ld">
											<a href="http://localhost:8883/${item.id }.html"><img src="${item.ppic }" style="width: 100px; height: 100px;"></a>
										</div>
										<div class="p-name">
											<a href="http://localhost:8883/${item.id }.html">${item.pname }</a>
										</div>
										<div class="p-price">
											<a href="http://localhost:8883/${item.id }.html">优惠价：<strong>￥${item.pprice }</strong></a>
										</div>
									</li>
								</c:forEach>

							</ul>
							<ul class="lh" style="display: none;">
								<c:forEach var="item" items="${hotMeatItemList }">
									<li>
										<div class="p-img ld">
											<a href="http://localhost:8883/${item.id }.html"><img src="${item.ppic }" style="width: 100px; height: 100px;"></a>
										</div>
										<div class="p-name">
											<a href="http://localhost:8883/${item.id }.html">${item.pname }</a>
										</div>
										<div class="p-price">
											<a href="http://localhost:8883/${item.id }.html">优惠价：<strong>￥${item.pprice }</strong></a>
										</div>
									</li>
								</c:forEach>

							</ul>
							<ul class="lh" style="display: none;">
								<c:forEach var="item" items="${hotCookedItemList }">
									<li>
										<div class="p-img ld">
											<a href="http://localhost:8883/${item.id }.html"><img src="${item.ppic }" style="width: 100px; height: 100px;">
												</a>
										</div>
										<div class="p-name">
											<a href="http://localhost:8883/${item.id }.html">${item.pname }</a>
										</div>
										<div class="p-price">
											<a href="http://localhost:8883/${item.id }.html">优惠价：<strong>￥${item.pprice }</strong></a>
										</div>
									</li>
								</c:forEach>
							</ul>
							<ul class="lh" style="display: block;">
								<c:forEach var="item" items="${hotGrainItemList }">
									<li>
										<div class="p-img ld">
											<a href="http://localhost:8883/${item.id }.html"><img src="${item.ppic }" style="width: 100px; height: 100px;"></a>
										</div>
										<div class="p-name">
											<a href="http://localhost:8883/${item.id }.html">${item.pname }</a>
										</div>
										<div class="p-price">
											<a href="http://localhost:8883/${item.id }.html">优惠价：<strong>￥${item.pprice }</strong></a>
										</div>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="hot">
				<div class="hot_name hot_name_shop">
					<h3 class="box_tit" style="color: white; font-weight: 600;">热门店铺</h3>
				</div>
				<div class="www360buy">
					<div class="hd">
						<ul>
							<li class="on">蔬菜店</li>
							<li class=" ">水果店</li>
							<li class=" ">肉类店</li>
							<li class=" ">熟食店</li>
							<li class=" ">谷物店</li>
						</ul>
					</div>
					<div class="bd">
						<ul class="lh" style="display: none;">
							<c:forEach var="storeinfo" items="${vagetablesstores }">
									<li>
										<div class="p-img ld">
											<a href="http://localhost:8883/list.html?storeid=${storeinfo.id }"><img src="${storeinfo.storelogoimg }"
												style="width: 100px; height: 100px;"></a>
										</div>
										<div class="p-name" style="line-height: 23px;height: 23px;">
											<a href="http://localhost:8883/list.html?storeid=${storeinfo.id }">店铺名: ${storeinfo.storename }</a>
										</div>
										<div class="p-price" style="font-size: 10px;">
											<a href="http://localhost:8883/list.html?sdz=${storeinfo.sdz }">${storeinfo.sdz }</a>
										</div>
									</li>
							</c:forEach>
						</ul>
						<ul class="lh" style="display: none;">
							<c:forEach var="storeinfo" items="${fruitsstores }">
								<li>
									<div class="p-img ld">
										<a href="http://localhost:8883/list.html?storeid=${storeinfo.id }"><img src="${storeinfo.storelogoimg }"
											style="width: 100px; height: 100px;"></a>
									</div>
									<div class="p-name" style="line-height: 23px;height: 23px;">
										<a href="http://localhost:8883/list.html?storeid=${storeinfo.id }">店铺名: ${storeinfo.storename }</a>
									</div>
									<div class="p-price" style="font-size: 10px;">
										<a href="http://localhost:8883/list.html?sdz=${storeinfo.sdz }">${storeinfo.sdz }</a>
									</div>
								</li>
							</c:forEach>
						</ul>
						<ul class="lh" style="display: none;">
							 <c:forEach var="storeinfo" items="${meatstores }">
								<li>
									<div class="p-img ld">
										<a href="http://localhost:8883/list.html?storeid=${storeinfo.id }"><img src="${storeinfo.storelogoimg }"
											style="width: 100px; height: 100px;"></a>
									</div>
									<div class="p-name" style="line-height: 23px;height: 23px;">
										<a href="http://localhost:8883/list.html?storeid=${storeinfo.id }">店铺名: ${storeinfo.storename }</a>
									</div>
									<div class="p-price" style="font-size: 10px;">
										<a href="http://localhost:8883/list.html?sdz=${storeinfo.sdz }">${storeinfo.sdz }</a>
									</div>
								</li>
							</c:forEach>
						</ul>
						<ul class="lh" style="display: none;">
							 <c:forEach var="storeinfo" items="${cookedfoodstores }">
								<li>
									<div class="p-img ld">
										<a href="http://localhost:8883/list.html?storeid=${storeinfo.id }"><img src="${storeinfo.storelogoimg }"
											style="width: 100px; height: 100px;"></a>
									</div>
									<div class="p-name" style="line-height: 23px;height: 23px;">
										<a href="http://localhost:8883/list.html?storeid=${storeinfo.id }">店铺名: ${storeinfo.storename }</a>
									</div>
									<div class="p-price" style="font-size: 10px;">
										<a href="http://localhost:8883/list.html?sdz=${storeinfo.sdz  }">${storeinfo.sdz }</a>
									</div>
								</li>
							</c:forEach>
						</ul>
						<ul class="lh" style="display: block;">
							<c:forEach var="storeinfo" items="${grainstores }">
								<li>
									<div class="p-img ld">
										<a href="http://localhost:8883/list.html?storeid=${storeinfo.id }"><img src="${storeinfo.storelogoimg }"
											style="width: 100px; height: 100px;"></a>
									</div>
									<div class="p-name" style="line-height: 23px;height: 23px;">
										<a href="http://localhost:8883/list.html?storeid=${storeinfo.id }">店铺名: ${storeinfo.storename }</a>
									</div>
									<div class="p-price" style="font-size: 10px;">
										<a href="http://localhost:8883/list.html?sdz=${storeinfo.sdz  }">${storeinfo.sdz }</a>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
			<div class="hot">
				<div class="food_sort">
					<h3 class="box_tit" style="color: white; font-weight: 600;">食品排行榜</h3>
				</div>

				<div class="www360buy">
					<div class="hd">
						<ul>
							<li class="on">疯狂抢购</li>
							<li class=" ">猜您喜欢</li>
							<li class=" ">热卖商品</li>
							<li class=" ">热评商品</li>
							<li class="">新品上架</li>
						</ul>
					</div>
					<div class="bd">
						<ul class="lh" style="display: none;">
							 <c:forEach var="item" items="${panicbuyitems }">
									<li>
										<div class="p-img ld">
											<a href="http://localhost:8883/${item.id }.html"><img src="${item.ppic }" style="width: 100px; height: 100px;"></a>
										</div>
										<div class="p-name">
											<a href="http://localhost:8883/${item.id }.html">${item.pname }</a>
										</div>
										<div class="p-price">
											<a href="http://localhost:8883/${item.id }.html">优惠价：<strong>￥${item.pprice }</strong></a>
										</div>
									</li>
								</c:forEach>
						</ul>
						<ul class="lh" style="display: none;">
							<c:forEach var="item" items="${userlikeitems }">
									<li>
										<div class="p-img ld">
											<a href="http://localhost:8883/${item.id }.html"><img src="${item.ppic }" style="width: 100px; height: 100px;"></a>
										</div>
										<div class="p-name">
											<a href="http://localhost:8883/${item.id }.html">${item.pname }</a>
										</div>
										<div class="p-price">
											<a href="http://localhost:8883/${item.id }.html">优惠价：<strong>￥${item.pprice }</strong></a>
										</div>
									</li>
								</c:forEach>
						</ul>
						<ul class="lh" style="display: none;">
							<c:forEach var="item" items="${bestselleritems }">
									<li>
										<div class="p-img ld">
											<a href="http://localhost:8883/${item.id }.html"><img src="${item.ppic }" style="width: 100px; height: 100px;"></a>
										</div>
										<div class="p-name">
											<a href="http://localhost:8883/${item.id }.html">${item.pname }</a>
										</div>
										<div class="p-price">
											<a href="http://localhost:8883/${item.id }.html">优惠价：<strong>￥${item.pprice }</strong></a>
										</div>
									</li>
								</c:forEach>
						</ul>
						<ul class="lh" style="display: none;">
							<c:forEach var="item" items="${commentitems }">
									<li>
										<div class="p-img ld">
											<a href="http://localhost:8883/${item.id }.html"><img src="${item.ppic }" style="width: 100px; height: 100px;"></a>
										</div>
										<div class="p-name">
											<a href="http://localhost:8883/${item.id }.html">${item.pname }</a>
										</div>
										<div class="p-price">
											<a href="http://localhost:8883/${item.id }.html">优惠价：<strong>￥${item.pprice }</strong></a>
										</div>
									</li>
								</c:forEach>
						</ul>
						<ul class="lh" style="display: block;">
							<c:forEach var="item" items="${newestitems }">
									<li>
										<div class="p-img ld">
											<a href="http://localhost:8883/${item.id }.html"><img src="${item.ppic }" style="width: 100px; height: 100px;"></a>
										</div>
										<div class="p-name">
											<a href="http://localhost:8883/${item.id }.html">${item.pname }</a>
										</div>
										<div class="p-price">
											<a href="http://localhost:8883/${item.id }.html">优惠价：<strong>￥${item.pprice }</strong></a>
										</div>
									</li>
								</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	 
	<script type="text/javascript">
		jQuery(".www360buy").slide({
			delayTime : 0
		});
	</script>
</body>
</html>