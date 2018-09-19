<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="/css/main.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="/css/bootstrap-table.min.css"
	type="text/css" media="screen">
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery.cookie.js"></script>
<script type="text/javascript" src="/js/userinfo.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-table.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript" src="/js/item/item.js"></script>
</head>
<body>
	<div class="route_bg">
		<a>商品管理</a>&nbsp;<i class="glyphicon glyphicon-chevron-right"></i><a>&nbsp;${type}商品管理</a>
	</div>
	<div>
		<div style="margin-top: 10px; margin-bottom: -44px;">
			<button id="add" onclick="addzixun()" type="button"
				class="btn btn-default">
				<span class="glyphicon glyphicon-plus"></span>新增
			</button>
		</div>
		<table id="itemtable">
		<colgroup>
				<col style="width: 5%;">
				<col style="width: 15%;">
				<col style="width: 15%;">
				<col style="width: 5%;">
				<col style="width: 8%;">
				<col style="width: 5%;">
				<col style="width: 5%;">
				<col style="width: 5%;">
				<col style="width: 5%;">
				<col style="width: 5%;">
				<col style="width: 15%;">
			</colgroup>
			<thead style="background-color: #003D79; color: #FFF">
				<tr>
					<th data-field="id" data-align="center" data-sortable="true">ID</th>
					<th data-field="pname" data-align="center" data-sortable="true">名称</th>
					<th data-field="pms" data-align="center" data-formatter="name">描述</th>
					<th data-field="pprice" data-sortable="true" data-align="center">价格</th>
					<th data-field="pcreattime" data-sortable="true"
						data-align="center">上架时间</th>
					<th data-field="pstock" data-sortable="true" data-align="left">库存</th>
					<th data-field="psellnum" data-sortable="true" data-align="left">销量</th>
					<th data-field="isHot" data-align="left">热门商品</th>
					<th data-field="isSell" data-sortable="true" data-align="left">上下架</th>
					<th data-field="ptype" data-align="left">商品类型</th>
					<th data-field="operate" data-align="center"
						data-formatter="operate">操作</th>
				</tr>
			</thead>
		</table>
	</div>
	<!-- 修改商品页面 -->
	<jsp:include page="item/updateitem.jsp" />

</body>
<script type="text/javascript" src="/js/item/item.js"></script>
</html>