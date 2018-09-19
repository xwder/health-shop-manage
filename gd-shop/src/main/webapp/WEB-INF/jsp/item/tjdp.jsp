<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
			<form action="">
                <div class="gdetail">
                	<div class="dp_wrap_title">
                		推荐搭配
                	</div>
                	<div class="dp_wrap">
                		<!-- 结算 -->
                		<div class="dq_total_wrap">
                			<div class="icon_equal">
                				=
                			</div>
                			<div class="dp_num">已经选择0个商品
                				<p class="dq_price">总计<span id="totalprice">￥${item.pprice }</span>元</p>
                				<button class="get">立即购买</button>
                			</div>
                		</div>
                		<!-- 搭配1 -->
                		<div class="dq_ori">
                			<a class="dq_ori_prd" href=""><img src="${item.ppic }" style="wdith:170px;height:100px;" /></a>
                			<a class="ori_prd" href="">${item.pname }</a>
                			<p class="ori_prd dp_wrap_pprice_ori">${item.pprice }</p>
                		</div>
                		<div class="scroll_wrap">
                		<c:if test="${collocationList != null}">
                			<c:if test="${fn:length(collocationList)>0}">
                				<c:forEach var="product" items="${collocationList}" begin="0" end="3">
	                				<div class="dp_prd">
		                				<div class="icon_plus">+</div>
		                				<div class="dp_p_wrap">
		                					<a class="dp_wrap_pimg" href="http://localhost:8883/${product.id }.html" target="_blank"><img src="${product.ppic }"/></a>
		                					<span style="white-space: nowrap; text-overflow: ellipsis;overflow:hidden; width: 115px;height: 44px;text-align: center;">
		                						<a class="dp_wrap_pname" href="http://localhost:8883/${product.id }.html" target="_blank">${product.pname }</a>
		                					</span>
		                					<p class="dp_wrap_pprice">
		                					<label>
		                					<input type="checkbox" id="${product.id }" value="${product.id }" onclick="collocation(${product.pprice},${product.id})" >
		                						￥${product.pprice }
		                					</label>
		                					</p>
		                				</div>
	                				</div>
                				</c:forEach>
                			</c:if>
                		</c:if>
                		</div>
                	</div>
                </div>   
               </form>
</body>
</html>