<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 

<style>
body,div,p,h3,ul,input{ margin:0; padding:0;}
body{ font-size:12px; font-family:'微软雅黑',Verdana,"Lucida Grande","Lucida Sans",sans; color:#333;}
img{ border:none;}
a{text-decoration:none;color:#6a9700; }
a:hover { text-decoration:underline; color:#f60;}
.b{ font-weight:bold;}
.font16{ font-size:16px;}
.fl{ float:left;}
/* 清除浮动 */
.clearfix:after{content:""; display:block; height:0; font-size:0; clear:both;}
.clearfix {zoom:1;}

.head{ width:1000px; height:160px; border-bottom:1px solid #ccc; margin:0 auto; }
	.head .logo{ display:inline-block;}
	
.warpper{ width:1000px; margin:0 auto;}
.content{ width:520px; min-height:189px; _height:189px; padding:50px 0 0 210px; margin:100px 0 120px 180px; background:url(/images/404/bg404.jpg) no-repeat;}

.falseCode{ width:300px; padding-right:20px; border-right:1px solid #ccc; text-align:right; font-size:40px; font-family:Arial,Helvetica,sans-serif; color:#999; float:left;     margin-bottom: 20px;}
.falseText{ width:380px; padding-left:20px; float:left; line-height:2;}

</style>
<body>
	<div class="content_right">
		<div id="navlist">
			<ul>
				<li class="navlist_red_left"></li>
				<li class="navlist_red">我的购物车</li>
			</ul>
		</div>

		<div id="content">
		<c:if test="${fn:length(cart)!=0}">
		 <form onsubmit="return false;" method="post"  id="orderform">
			<table width="100%" border="0" cellspacing="0" cellpadding="0"
				id="shopping">
				 
					<tr>
						<td class="title_1"><input id="allCheckBox" type="checkbox"
							value="" onclick="selectAll()" />全选</td>
						<td class="title_2" colspan="2">店铺宝贝</td>
						<td class="title_3">获积分</td>
						<td class="title_4">单价（元）</td>
						<td class="title_5">数量</td>
						<td class="title_6">小计（元）</td>
						<td class="title_7">操作</td>
					</tr>
					<tr>
						<td colspan="8" class="line"></td>
					</tr>

				
					<c:forEach var="cartpojo" items="${cart}">
						<tr class="store" id="${cartpojo.storeinfo.id}_store">
							<td colspan="8" class="shopInfo" style="text-align: left">店铺：<a
								href="#">${cartpojo.storeinfo.storename }</a> 卖家：<a href="#">${cartpojo.storeinfo.sname }</a>
								<img src="/images/cart/taobao_relation.jpg" alt="relation" /></td>
						</tr>
						<c:forEach var="cartitem" items="${cartpojo.tCartitemList}">
							<tr id="${cartitem.id}">
								<td class="cart_td_1"><input name="cartCheckBox"
									type="checkbox" value="${cartitem.id}" onclick="selectSingle()" /></td>
								<td class="cart_td_2"><a href="http://localhost:8883/${cartitem.pid}.html"><img src="${cartitem.ppic }"
									alt="shopping" style="width: 80px; height: 80px;" /></a></td>
								<td class="cart_td_3"><a href="http://localhost:8883/${cartitem.pid}.html">${cartitem.pname }</a><br />
									  保障：<img
									src="/images/cart/taobao_icon_01.jpg" alt="icon" /></td>
								<td class="cart_td_4">${cartitem.count }</td>
								<td class="cart_td_5">${cartitem.pprice }</td>
								<td class="cart_td_6"><img
									src="/images/cart/taobao_minus.jpg" alt="minus"
									onclick="changeNum('${cartitem.id}'+'_','minus',${cartitem.id})" class="hand" /> <input
									id="${cartitem.id}_" type="text" value="${cartitem.count}" class="num_input"
									readonly="readonly" /> <img
									src="/images/cart/taobao_adding.jpg" alt="add"
									onclick="changeNum('${cartitem.id}'+'_','add',${cartitem.id})" class="hand" /></td>
								<td class="cart_td_7"></td>
								<td class="cart_td_8"><a
									href="javascript:deleteRow(${cartitem.id});">删除</a></td>
							</tr>
						</c:forEach>
					</c:forEach>
				<tr>
					<td colspan="3" style="text-align: left"><a
						href="javascript:deleteSelectRow()"><img
							src="/images/cart/taobao_del.jpg" alt="delete" /></a></td>
					<td colspan="5" class="shopend">商品总价（不含运费）：<label id="total"
						class="yellow"></label> 元<br /> 可获积分 <label class="yellow"
						id="integral"></label> 点<br /> <input type="button"  value="" id="ordersubmit"
						 style=" background-image:url('/images/cart/taobao_subtn.jpg');width: 80px;height: 25px; "   /></td>
				</tr>
			</table>
			</form>
			</c:if>
			<c:if test="${fn:length(cart)==0}">
					<div class="warpper">
					 	<div class="content clearfix">
							<div class="falseCode">/(ㄒoㄒ)/~~</div>
							<div class="falseText">
								<p class="font16 b" >您还未添加商品！</p>
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