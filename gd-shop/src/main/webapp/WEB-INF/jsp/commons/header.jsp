<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<body>
	    <div id="cover">
        <div id="J_SiteNavBd">
            <div id="site-nav-l">
                <ul class=quick-menu>
                    <li class=home id="loginshow">
                        <a href="javascript:login()"> 亲,请登录</a>
                    </li>
                    <li class=home id="registershow">
                      	<a href="javascript:regist()">免费注册</a>
                    </li>
                    <li class=home id="showusername">
                      	
                    </li>
                    <li class=home>
                        <a href="#">手机逛健康购</a>
                    </li>
                </ul>
            </div>
            <div id="site-nav-r">
                <UL class=quick-menu>
					<LI class=home><a id="showuserindex" href="http://localhost:8884/page/login.html">个人中心</a> </LI>
                    <LI class="mytaobao menu-item">
                        <div class=menu>
                            <a class=menu-hd href="#" target=_top rel=nofollow>我的健康购<B></B></a>
                            <div class=menu-bd>
                                <div class=menu-bd-panel>
                                    <div>
                                        <a href="http://localhost:8885/user/order.html?orderStates=5&page=1" rel=nofollow>已买到的宝贝</a>
                                        <a href="#" rel=nofollow>已卖出的宝贝</a>
                                         <a href="javascript:void(0);" onclick="loginout()" rel=nofollow>退出登录</a>
                                    </div>
                                </div>
                                <S class=r></S>
                                <S class=rt></S>
                                <S class=lt></S>
                                <S class=b></S>
                                <S class="b b2"></S>
                                <S class=rb></S>
                                <S class=lb></S>
                            </div>
                        </div>
                    </LI>
                    <LI class=cart>
                        <a href="http://localhost:8883/shop/cart.html" rel=nofollow>
                            <img src="/images/dh/dhcart.png" alt="" >购物车 </a>
                    </LI>
                    <LI class=favorite>
                        <a href="#" rel=nofollow>  <img src="/images/dh/dhsc.png" alt="" >收藏夹</a>
                    </LI>
                    <LI class="dhsearch menu-item">
                        <div class=menu>
                            <SPaN class=menu-hd><S></S>搜索<B></B></SPaN>
                            <div class=menu-bd>
                                <div class=menu-bd-panel>
                                	<FORM name=topSearch action=http://localhost:8883/list.html?>
                                        <INPUT maxLength=60 name=query>
                                        <BUTTON type=submit>搜 索</BUTTON>
                                    </FORM>
                                </div>
                                <S class=r></S>
                                <S class=rt></S>
                                <S class=lt></S>
                                <S class=b></S>
                                <S class="b b2"></S>
                                <S class=rb></S>
                                <S class=lb></S>
                            </div>
                        </div>
                    </LI>
                    <LI class="services menu-item last">
                        <div class=menu>
                            <a class=menu-hd href="#" target=_top>网站导航<B></B></a>
                            <div class=menu-bd style="WIDTH: 210px; HEIGHT: 262px; _width: 202px">
                                <div class=menu-bd-panel>
                                    <DL>
                                        <DT>
                                            <a href="#">购物</a>
                                            <DD>
                                                <a href="#">商城</a>
                                                <a href="#">电器城</a>
                                                <a href="#">嗨淘</a>
                                                <a href="#">全球购</a>
                                                <a href="#">跳蚤街</a>
                                                <a href="#">礼物</a>
                                                <a href="#">促销</a>
                                                <a href="#">机票</a>
                                                <a href="#">彩票</a>
                                                <a href="#">创意</a>
                                            </DD>
                                    </DL>
                                    <DL>
                                        <DT>
                                            <a href="#">门户</a>
                                            <DD>
                                                <a href="#">服饰</a>
                                                <a href="#">女人</a>
                                                <a href="#">美容</a>
                                                <a href="#">居家</a>
                                                <a href="#">男人</a>
                                                <a href="#">数码</a>
                                                <a href="#">亲子</a>
                                                <a href="#">时尚</a>
                                                <a href="#">试用</a>
                                                <a href="#">心得</a>
                                                <a href="#">帮派</a>
                                                <a href="#">画报</a>
                                                <a href="#">淘女郎</a>
                                                <a href="#">社区</a>
                                                <a href="#">宝贝传奇</a>
                                            </DD>
                                    </DL>
                                    <DL>
                                        <DT>
                                            <a href="#">淘江湖</a> &nbsp;
                                            <a href="#">手机淘宝</a> </DT>
                                    </DL>
                                    <DL>
                                        <DT>
                                            <a href="#">帮助中心</a>
                                            <DD>
                                                <a href="#">交易安全</a>
                                                <a href="#">维权中心</a> </DD>
                                    </DL>
                                    <DL class=last>
                                        <DD>
                                            <STRONG style="FONT-WEIGHT: bold"><a href="#">更多内容</a></STRONG>
                                        </DD>
                                    </DL>
                                </div>
                                <S class=r></S>
                                <S class=rt></S>
                                <S class=lt></S>
                                <S class=b style="WIDTH: 169px"></S>
                                <S class="b b2" style="WIDTH: 169px"></S>
                                <S class=rb></S>
                                <S class=lb></S>
                            </div>
                        </div>
                    </LI>
                </UL>

            </div>
        </div>
    </div>
</body>
</html>