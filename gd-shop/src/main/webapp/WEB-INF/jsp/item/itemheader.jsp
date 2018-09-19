<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<body>
	<div class="showall">
		<!--left -->
		<div class="showbot">
			<div id="showbox">
				<img src="${item.ppic }" width="400" height="400" /> <img
					src="${item.ppic }" width="400" height="400" /> <img
					src="${item.ppic }" width="400" height="400" /> <img
					src="${item.ppic }" width="400" height="400" />

			</div>
			<!--展示图片盒子-->
			<div id="showsum">
				<!--展示图片里边-->
			</div>
			<p class="showpage">
				<a href="javascript:void(0);" id="showlast"> < </a> <a
					href="javascript:void(0);" id="shownext"> > </a>
			</p>
		</div>
		<!--conet -->
		<div class="tb-property">
			<div class="tr-nobdr">
				<div class="itemname">
					<h3>${item.pname }</h3>
				</div>
				<div class="itemnpms" style="width: 560px;">
					<h4>${item.pms }</h4>
				</div>
			</div>
			<div class="txt">
				<span class="tex-o">价格</span><span class="nowprice">
					￥<a href=""> ${item.pprice } </a></span>
				<div class="cumulative">
					<span class="number ty1">累计售出<br /> <em
						id="add_sell_num_363">${item.psellnum }</em></span> <span
						class="number tyu">累计评价<br /> <em id="add_sell_num_363"><c:if test="${pageBean.total != 0}">${pageBean.total }</c:if>
												<c:if test="${pageBean == null}">0 </c:if></em></span>
				</div>
			</div>
			<div class="txt-h">
				<span class="tex-o">分类</span>
				<ul class="glist" id="glist"
					data-monitor="goodsdetails_fenlei_click">
					<li><a title="红色36g">暂无</a></li>
				</ul>
			</div>

			<div class="gcIpt">
				<span class="guT">数量</span> <input id="min" name="" type="button"
					value="-" /> 
					<input id="text_box" name="" type="number" value="1" style="width: 30px; text-align: center; color: #0F0F0F;" /> 
					<input id="itemid" type="hidden" value="${item.id }"></input>
					<input id="storeid" type="hidden" value="${storeinfo.id }"></input>
					<input id="pname" type="hidden" value="${item.pname }"></input>
					<input id="pprice" type="hidden" value="${item.pprice }"></input>
					<input id="ppic" type="hidden" value="${item.ppic }"></input>
					<input id="stock" type="hidden" value="${item.pstock }"></input>
					<input id="add" name="" type="button" value="+" /> 
					<span class="Hgt">库存（${item.pstock }）</span>
			</div>
			
			<div class="nobdr-btns">
				<button class="addcart hu" id="addToCart">
					<img src="/images/item/shop.png" width="25" height="25" />加入购物车
				</button>
				<button class="addcart yh" id="buyNow">
					<img src="/images/item/ht.png" width="25" height="25" />立即购买
				</button>
			</div>
			<div class="guarantee">
				<span>邮费：包邮&nbsp;&nbsp;支持货到付款 <a href=""><img
						src="/images/item/me.png" /></a></span>
			</div>
		</div>
		<!--right -->
		<div class="extInfo">
			<div class="brand-logo">
				<a href="" title="奥影汽车影音"> <img src="/images/item/ho_03.png" />
				</a>
			</div>
			<div class="seller-pop-box">
				<span class="tr">商家名称：${storeinfo.storename }</span> <span
					class="tr">商家等级：初级店铺</span> <span class="tr">客家电话：${storeinfo.sphone }</span>
				<span class="tr hoh">所在地区：${storeinfo.saddr }</span>
			</div>
			<div class="seller-phone">
				<span class="pop im"> <a href="" data-name="联系卖家"><img
						src="/images/item/phon.png" />联系卖家</a>
				</span> <span class="pop in"> <a href="" data-name="咨询卖家"><img
						src="/images/item/qq.png" />咨询卖家</a>
				</span> <span class="pop in"> <a href="" data-name="进店逛逛"><img
						src="/images/item/shop-line.png" />进店逛逛</a>
				</span> <span class="pop in"> <a href="" data-name="关注店铺"><img
						src="/images/item/staar.png" />关注店铺</a>
				</span>
			</div>
			<div class="jd-service">
				<a href=""> <img src="/images/item/ho_07.png" />
				</a>
			</div>
			<div class="suport-icons">
				<h4>
					扫一扫<br />手机下单更优惠
				</h4>
				<img src="/images/item/ho_11.jpg" />
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			firstChild = $("#showsum>:first");//用选择器的方式获取第一个子元素
			firstChild.css('left', 0);//将第一个子元素中的文字变为红色，可以看到只有“111”是红色的 
		});
	</script>
</body>
</html>