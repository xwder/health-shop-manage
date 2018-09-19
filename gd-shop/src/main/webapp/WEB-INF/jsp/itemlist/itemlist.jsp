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
	<div class="center">
		<div class="col-main">
			<div class="main-wrap">
				<div class="wrap-left">
					<c:if test="${fn:length(pageBean.list)!=0}">
					<div class="wrap-list">
						<!--收藏夹 -->
						<div class="you-like">
							<div class="s-content">
							
							<c:forEach var="item" items="${pageBean.list }">
							<input type="hidden" id="totalpages" value="${pageBean.pages }" />
								<div class="s-item-wrap">
									<div class="s-item">
										<div class="s-pic">
											<a href="http://localhost:8883/${item.id}.html" class="s-pic-link"> <img
												src="${item.ppic }"
												style="width:220px;height:220px;"
												alt=""
												title=""
												class="s-pic-img s-guess-item-img">
											</a>
										</div>
										<div class="s-price-box">
											<a href="http://localhost:8883/${item.id}.html" >
												<span class="s-price" style="float:left;"><em class="s-price-sign">¥</em><em
													class="s-value">${item.pprice}</em></span> 
													<span class="s-history-price" style="float:right;"><em
													class="s-price-sign">销量</em><em class="">${item.psellnum}</em></span>
											</a>
										</div>
										<div  style="width:100%;font-size: 14px;height:40px;text-align: center;">
											<a href="http://localhost:8883/${item.id}.html" style="color:black;">${item.pname }</a>
										</div>
										<div class="s-extra-box iteminfo"   style="height: 20px;text-align: center;margin-top: 4px;">
											<span  style="float:left;"><a href="http://localhost:8883/shop/store/${item.sid}.html">${item.storename }</a></span> 
											<span   style="float:right;"><a href="">${item.sdz }</a></span>

										</div>
									</div>
								</div>
								
								</c:forEach>
							</div>

						</div>

					</div>
					<div  class="pagination" style="width:100%">
					 
						<c:if test="${pageBean != null }">
							<div style="text-align: center;height: 20px;width: 80px;font-size: 15px;margin-top: -10px;float: left;">第${pageBean.pageNum }页/共${pageBean.pages }页 </div>
							<div class="pagnation" id="pagnation" style="float: right; margin-right:40px;margin-top: -10px;">
								<c:if test="${pageBean.pageNum != 1}">
									<a href="http://localhost:8883/list.html?query=${query}&storeid=${storeid}&sdz=${sdz}&sellnum=${sellnum}&sssj=${sssj}&price=${price}&itemtype=${itemtype }&page=${pageBean.pageNum -1}"  class="page-prev">上一页</a>
								</c:if>
								<c:if test="${pageBean.pageNum == 1}">
									<a href="http://localhost:8883/list.html?query=${query}&storeid=${storeid}&sdz=${sdz}&sellnum=${sellnum}&sssj=${sssj}&price=${price}&itemtype=${itemtype }&page=${pageBean.pageNum }"  class="page-prev">上一页</a>
								</c:if>
								
								<c:forEach var ="i" begin="${pageBean.pageNum }" end="${pageBean.pageNum + 5 }">
									<c:if test="${i <  pageBean.pages}">
										<c:if test="${i ==  pageBean.pageNum}">
											<a href="http://localhost:8883/list.html?query=${query}&storeid=${storeid}&sdz=${sdz}&sellnum=${sellnum}&sssj=${sssj}&price=${price}&itemtype=${itemtype }&page=${i}"  class="current">${i}</a>
										</c:if>
										<c:if test="${i !=  pageBean.pageNum}">
											<a href="http://localhost:8883/list.html?query=${query}&storeid=${storeid}&sdz=${sdz}&sellnum=${sellnum}&sssj=${sssj}&price=${price}&itemtype=${itemtype }&page=${i}"  class="">${i}</a>
										</c:if>
									</c:if>
									 
								</c:forEach>
								
								
									...
								<a href="http://localhost:8883/list.html?query=${query}&storeid=${storeid}&sdz=${sdz}&sellnum=${sellnum}&sssj=${sssj}&price=${price}&itemtype=${itemtype }&page=${pageBean.pages}" >${pageBean.pages}</a>
								
								<c:if test="${pageBean.pageNum != pageBean.pages}">
									<a href="http://localhost:8883/list.html?query=${query}&storeid=${storeid}&sdz=${sdz}&sellnum=${sellnum}&sssj=${sssj}&price=${price}&itemtype=${itemtype }&page=${pageBean.pageNum+1}"  class="page-next">下一页</a>
								</c:if>
								<c:if test="${pageBean.pageNum == pageBean.pages}">
									<a href="http://localhost:8883/list.html?query=${query}&storeid=${storeid}&sdz=${sdz}&sellnum=${sellnum}&sssj=${sssj}&price=${price}&itemtype=${itemtype }&page=${pageBean.pageNum }"  class="page-next">下一页</a>
								</c:if>
							</div>
							<script>
								var pagnation=$("#pagnation");
								$(document).on("keydown",function(event){
									switch(event.keyCode){
										 case 37 : window.location.href = pagnation.find(".page-prev").attr("href");break;
										 case 39 : window.location.href = pagnation.find(".page-next").attr("href");break
									}
								});
							</script>
						<!-- 代码 结束 -->
						</c:if>
					</div>
				</c:if>
				<c:if test="${fn:length(pageBean.list)==0}">
					<div class="warpper">
					 	<div class="content clearfix">
							<div class="falseCode">/(ㄒoㄒ)/~~</div>
							<div class="falseText">
								<p class="font16 b" >抱歉，未查到符合条件的商品。</p>
								<p>&nbsp;</p>
								<p class="b" style="text-align: center"><span class="red" id="404_time">10</span> 秒之后会自动跳转所有商品页面，您还可以：</p>
								<p class="b" style="text-align: center">1）<a style="color:#f60;" title="返回首页" href="http://localhost:8881/">返回健康购首页</a></p>
								<p class="b" style="text-align: center">2）去其它地方逛逛：<a style="color:#f60;" title="" href="http://localhost:8880/zixun/%E8%B5%84%E8%AE%AF%E9%A6%96%E9%A1%B5.html">浏览健康资讯</a> | 
								<a style="color:#f60;" title=" " href="http://localhost:8883/list.html">显示所有商品</a> 
							</div>
						</div>
					</div>
				</c:if>
				</div>
				
				<div class="wrap-right" style="width: 20%; float: right;">
				
				<c:if test="${rightList != null }">
					<c:if test="${fn:length(rightList)!=0}">
						<c:forEach var="product" items="${rightList }">
							<div class="right-item" style="    padding-top: 1px;">
								<div class="s-item">
		
									<div class="s-pic">
										<a href="http://localhost:8883/${product.id}.html" class="s-pic-link"> <img
											src="${product.ppic}"
											alt="${product.pname}"
											title="${product.pname}"
											class="s-pic-img s-guess-item-img">
										</a>
									</div>
									<div class="s-price-box">
										<span class="s-price" style="margin-left: 40px;"><em class="s-price-sign">¥</em><em
											class="s-value">${product.pprice }</em></span> <span class="s-history-price"><em
											class="s-price-sign">¥</em><em class="s-value">${product.pprice +20 }</em></span>
		
									</div>
									<div class="s-title">
										<a href="http://localhost:8883/${product.id}.html" title="${product.pname}">${product.pname }</a>
									</div>
									<div class="s-extra-box">
										<span class="s-comment" style="float: left; margin-left: 5px;">库存:${product.pstock} </span> 
										<span class="s-sales" style="float: right; margin-right: 5px;">月销: ${product.psellnum}</span>
		
									</div>
								</div>
							</div>
						</c:forEach>
 					</c:if>
 				</c:if>
				</div>
			</div>
		</div>
	</div>
<script>
	
	$(function(){
		
		$(".city-picker-span").css("height","38px");
		$(".city-picker-span").css("line-height","39px");
		
	});

</script>