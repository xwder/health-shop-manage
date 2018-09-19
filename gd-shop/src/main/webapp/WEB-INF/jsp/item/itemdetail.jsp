<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="gdetail">
		<!-- left -->
		<div class="aside">
			<h3>
				看了还看<span><img src="/images/item/fod.png" width="22"
					height="22" />换一批</span>
			</h3>

			<c:if test="${sortItemList != null}">
				<c:if test="${fn:length(sortItemList)>0}">
					<c:forEach var="product" items="${sortItemList}" begin="0" end="3">

						<dl class="ac-mod-list">
							<dt>
								<a href="http://localhost:8883/${product.id }.html"><img src="${product.ppic }" /></a>
							</dt>
							<dd>
								<a href="http://localhost:8883/${product.id }.html">${product.pname }<span>￥${product.pprice }</span></a>
							</dd>
						</dl>

					</c:forEach>
				</c:if>
			</c:if>

		</div>

		<div class="detail">
			<div class="www360buy">
				<div class="hd">
					<ul>
						<li class="on">商品描述</li>
						<li class=" ">商品评价(<c:if test="${pageBean.total != 0}">${pageBean.total }</c:if>
												<c:if test="${pageBean == null}">0 </c:if>
											)</li>
						<li class=" ">售后保障</li>
					</ul>
				</div>
				<div class="bd">
					<ul class="lh" style="display: none;">
						<div id="ui-a" class="ui-a">
							<ul style="margin: 0;">
								<li>商品名称：${item.pname }</li>
								<li>商品编号：${item.id }</li>
								<li>上架时间：<fmt:formatDate value="${item.pcreattime}"
										dateStyle="medium" /></li>
								<li>库存： ${item.pstock }</li>
								<li>${item.pdesc }</li>
							</ul>
						</div>
					</ul>
					<ul class="lh" style="display: none;">
						<div id="comment">
							<div class="rate-grid">
								<table>
									<tbody id="commenttext">
									
									<c:if test="${pageBean != null }">
										<c:if test="${fn:length(pageBean.list)!=0}">
										<c:forEach var="comment" items="${pageBean.list }"> 
										<tr>
											<td class="tm-col-master" style="width:550px;">
												<div class="tm-rate-content">
													<div class="tm-rate-fulltxt" style="text-align: center;">
														<span style="">${comment.comtext }</span>	
													</div>
												</div>
												<div class="tm-rate-date" style="text-align: left;margin-left: 10px;">
														  <fmt:formatDate value="${comment.time}" dateStyle="medium" />  
												</div>
											</td>
											<td class="col-meta">
												<div class="rate-sku">
													<span> 
														<c:forEach begin="1" end="${comment.comlevel }" >
																<img src="/images/x2.png">
														</c:forEach>
														<c:forEach begin="1" end="${5 - comment.comlevel }" >
																<img src="/images/x1.png">
														</c:forEach>
													</span> 
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
												</div>
											</td>
											<td class="col-author"><div class="rate-user-info">
													${comment.username }（匿名）</span>
												</div>
											</td>
										</tr>
										</c:forEach>
									</c:if>
									</c:if>
									
									</tbody>
								</table>
							</div>

						</div>
						<div  class="pagination" id="fypagination">
							<c:if test="${pageBean != null }">
								<div style="    text-align: center;height: 20px;width: 140px;font-size: 15px;margin-top: 20px;float: left;">第${pageBean.pageNum }页/共${pageBean.pages }页 </div>
								<div class="pagnation" id="pagnation" style="float: right; margin-right: 40px;">
									<c:if test="${pageBean.pageNum != 1}">
										<a href="javascript:void(0);" onclick="commentfy(${item.id },${pageBean.pageNum -1})"  class="page-prev">上一页</a>
									</c:if>
									<c:if test="${pageBean.pageNum == 1}">
										<a href="javascript:void(0);" onclick="commentfy(${item.id },${pageBean.pageNum })"  class="page-prev">上一页</a>
									</c:if>
									
									<c:forEach var ="i" begin="${pageBean.pageNum }" end="${pageBean.pageNum + 5 }">
										<c:if test="${i <  pageBean.pages}">
											<c:if test="${i ==  pageBean.pageNum}">
												<a href="javascript:void(0);" onclick="commentfy(${item.id },${i})"  class="current">${i}</a>
											</c:if>
											<c:if test="${i !=  pageBean.pageNum}">
												<a href="javascript:void(0);" onclick="commentfy(${item.id },${i})"  class="">${i}</a>
											</c:if>
										</c:if>
										 
									</c:forEach>
										...
									<a href="javascript:void(0);" onclick="commentfy(${item.id },${pageBean.pages})" >${pageBean.pages}</a>
									
									<c:if test="${pageBean.pageNum != pageBean.pages}">
										<a href="javascript:void(0);" onclick="commentfy(${item.id },${pageBean.pageNum +1})"  class="page-next">下一页</a>
									</c:if>
									<c:if test="${pageBean.pageNum == pageBean.pages}">
										<a href="javascript:void(0);" onclick="commentfy(${item.id },${pageBean.pageNum })"  class="page-next">下一页</a>
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
					</ul>
					<ul class="lh" style="display: none;">
						<div>售后保障</div>

					</ul>

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