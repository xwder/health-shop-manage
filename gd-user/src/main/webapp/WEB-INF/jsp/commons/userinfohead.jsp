<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

        <div class="clear"></div>
        <div id="title">
            <div class="title_top">
                <div class="title_top_img">
                    <a href="/user/userinfo.html"><img id="showuserimage" src="${userinfo.image}" alt="" width="60" height="60"> class="tx"> </a>
                </div>
                <div class="title_top_text">我的健康购</div>
            </div>
            <div class="clear"></div>
            <div class="title_bottom">
                <div class="title_bottom_name" id="showusername">${userinfo.username}</div>
                <div class="title_bottom_menu">
                    <input type="hidden" value="${userinfo.id}" id="userid">
                    &nbsp;  &nbsp;  
                    <span><a href="/user/userinfo.html">我的资料</a></span>
                    <!-- <span><a href="/user/page/changepw.html">修改密码</a></span> -->
                    <span><a href="/user/userinfo.html"><i id="tubiao" style="background-image: url(/images/infologo/phone.png);"></i>修改手机</a></span>
                    <span><a href="/user/userinfo.html"><i id="tubiao" style="background-image: url(/images/infologo/email.png);"></i>修改邮箱</a></span>
                    <span><a href="/user/address/useraddress.html"><i id="tubiao" style="background-image: url(/images/infologo/address.png);"></i>地址管理</a></span>
                    <c:if test="${userinfo.isVip != 1 }">
                    	<span><a href="/user/app/uservip.html" style="color:red"><i id="tubiao"style="background-image: url(/images/infologo/zcgy.png);"></i></i>注册成为高级会员</a></span>
                    </c:if>
                </div>
            </div>
        </div>
</body>
</html>