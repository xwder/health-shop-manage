<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
/* search */
.search{border:2px solid #f58400;height:37px; width:600px;    }
.search select{display:none;}
.search .select_box{font-size:12px;color:#999999;width:100px;line-height:35px;float:left;position:relative;}
.search .select_showbox{height:35px;background:url(images/search_ico.png) no-repeat 80px center;text-indent:1.5em;}
.search .select_showbox.active{background:url(images/search_ico_hover.png) no-repeat 80px center;}
.search .select_option{border:2px solid #f58400;border-top:none;display:none;left:-2px;top:32px;position:absolute;z-index:99;background:#fff;}
.search .select_option li{text-indent:1.5em;width:90px;cursor:pointer;}
.search .select_option li.selected{background-color:#F3F3F3;color:#999;}
.search .select_option li.hover{background:#BEBEBE;color:#fff;}

.search input.inp_srh,.search input.btn_srh{border:none;background:none;height:35px;line-height:35px;float:left}
.search input.inp_srh{outline:none;width:365px;}
.search input.btn_srh{background:#f58400;color:#FFF;font-family:"微软雅黑";font-size:15px;width:60px;    margin-left: 171px;}
</style>
</head>
<body>
	<div id="top">
		<a href="http://localhost:8881">
		<div id="logo">
			<div class="logo_1"></div>
		</div>
		</a>
		<div id="search">
			<div id="sea" style="background-color: ;">
				 <div class="search radius6">
					<form name="searchform" method="get" action="/list.html">
						<input class="inp_srh" name="query"  placeholder="   请输入您要搜索的商品" value="${query }" >
						<input class="btn_srh" type="submit"   value="搜索">
					</form>
				</div>
			</div>
			<div id="tuijian">
				<ul>

					<c:forEach items="${hotSearchList}" begin="1" end="10"
						var="hotSearch">
						<li><a href='http://localhost:8883/list.html?query=${hotSearch.hotname}'>${hotSearch.hotname}<a></li>
					</c:forEach>


				</ul>
			</div>
		</div>
	</div>
</body>
</html>