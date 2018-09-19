<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<div class="sub-left">
	<div class="sub-tit">
		<h3 style="float: left">${strZxType }</h3>
	</div>
	<ul class="main-list">
		<c:if test="${fn:length(pageBean.list)!=0}">
				<c:forEach var="zixun" items="${pageBean.list}">
							<li>
								<h4>
								<a href="http://localhost:8880/zixun/${zixun.zxtypename}/<fmt:formatDate value='${zixun.createtime}' pattern='yyyy/MM/dd' />/${zixun.id}.html" target="_blank">
									 ${zixun.title }
								</a>
								</h4>
								<span class="png"> <span class="share">
										<div onmouseover="share.setShare('', '主食 吃得少不如吃得杂');">
											<div class="jiathis_style"
												style="background: url(/statics/images/share-ico.png) no-repeat scroll; width: 26px; height: 26px;">
												<a href="http://www.jiathis.com/share?uid=1609262"
													class="jiathis jiathis_txt jtico jtico_jiathis" target="_blank"
													style="background: url(/statics/images/share-ico.png) no-repeat scroll; width: 26px; height: 26px;"></a>
											</div>
										</div>
								</span>
							</span>
							</li>
				</c:forEach>
		</c:if>
 
	</ul>
	<div class="pagebox">
		<div class="aa">
			<div class="page">
				<c:if test="${fn:length(pageBean.list)!=0}">
					<c:if test="${pageBean.pageNum != 1}">
						<a href="http://localhost:8880/zixun/${strZxType}.html?page=${pageBean.pageNum-1}&pagesize=${pagesize}"  class="a1">上一页</a> 
					</c:if>
					<c:if test="${pageBean.pageNum == 1}">
						<a href="" class="a1">上一页</a>
					</c:if>
					<c:forEach var ="i" begin="${pageBean.pageNum }" end="${pageBean.pageNum + 9 }">
							<c:if test="${i <  pageBean.pages}">
								<c:if test="${i ==  pageBean.pageNum}">
									<span>${i}</span> 
								</c:if>
								<c:if test="${i !=  pageBean.pageNum}">
									<a href="http://localhost:8880/zixun/${strZxType}.html?page=${i}&pagesize=${pagesize}">${i}</a> 
								</c:if>
							</c:if>
							 
					</c:forEach>
					<a href="http://localhost:8880/zixun/${strZxType}.html?page=${pageBean.pages}&pagesize=${pagesize}">${pageBean.pages}</a> 
					<c:if test="${pageBean.pageNum != pageBean.pages}">
						<a href="http://localhost:8880/zixun/${strZxType}.html?page=${pageBean.pageNum + 1}&pagesize=${pagesize}" class="a1">下一页</a> 
					</c:if>
					<c:if test="${pageBean.pageNum == pageBean.pages}">
						<a href="" class="a1">下一页</a> 
					</c:if>
					
					
<!-- 					<a href="">1</a> 
					<a href="">6</a> 
					<a href="">7</a> 
					<a href="">8</a> 
					<a href="">9</a> 
					<span>${pagesize}</span> 
					<a href="">11</a> 
					<a href="">12</a> 
					<a href="">13</a> 
					<a href="">14</a><em></em>
					<a href="">52</a> <a href="" class="a1">下一页</a> -->
				</c:if>
				<p class="clear"></p>
			</div>
		</div>
	</div>
</div>