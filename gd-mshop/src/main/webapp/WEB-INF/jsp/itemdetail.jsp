<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link rel="stylesheet" href="/css/main.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/css/itemdetail/normalize.css" />
<link rel="stylesheet" href="/css/itemdetail/layout.css">
<link rel="stylesheet" href="/css/itemdetail/style.css">
<link rel="stylesheet" href="/css/itemdetail/daohang.css">
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/jquery.cookie.js"></script>
<script type="text/javascript" src="/js/userinfo.js"></script>
<script type="text/javascript" src="/js/tendina.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>

<body>
	<div class="route_bg" style="text-align: left;margin-top: 10px;">
			&nbsp;&nbsp;<a>商品管理</a>&nbsp;<i class="glyphicon glyphicon-chevron-right"></i><a>&nbsp;商品详情</a>
	</div>
	<div style="margin-top: 10px; margin-bottom: -44px; text-align: left;" >
		<button type="button" class="btn btn-default btn-sm" id="additem">
			<span class="glyphicon glyphicon-plus"></span> 添加商品
		</button>
		<button type="button" class="btn btn-default btn-sm" id=edititem>
			<span class="glyphicon glyphicon-edit"></span> 编辑商品
		</button>
		<button type="button" class="btn btn-default btn-sm" id=fhitemlist>
			<span class="glyphicon glyphicon-chevron-left"></span> 返回商品列表
		</button>
	</div>
	
	<div class="showall">
		<!--left -->
		<div class="showbot">
		<input id="itemid" type="hidden"  value="${item.id }">
			<div id="showbox">
				<img src="${item.ppic }" width="400" height="400" /> 
			</div>
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
				<span class="tex-o">库存</span>
				<ul class="glist" id="glist"
					data-monitor="goodsdetails_fenlei_click">
					<li><a title="">${item.pstock }</a></li>
				</ul>
			</div>
 
		</div>
		</div>
        <div class="gdetail">
       	<div class="dp_wrap_title">
       		推荐搭配
       	</div>
       	<div class="dp_wrap">
       	 
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
         					 
         					</p>
         				</div>
        				</div>
       				</c:forEach>
       			</c:if>
       		</c:if>
       		</div>
       	</div>
       </div>  
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
		
		<script>
		$("#edititem").click(function(){
			var itemid = $("#itemid").val();
			var url = "/manager/item/getitem/"+ itemid +".html" ;
			window.location.href=url;
		});
		$("#additem").click(function(){
			window.location.href="/manager/item/addpage.html";
		});
		$("#fhitemlist").click(function(){
			window.location.href="/manager/item/itemlistpage.html";
		});
		</script>




	 

