<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<body>
 
        <div class="clear"></div>
        <div id="title">
            <div class="title_top">
                <div class="title_top_img">
                     <a href="/user/userindex.html"><img id="showuserimage" src="${userinfo.image}" alt="" width="60" height="60"> class="tx"></a>
                </div>
                <div class="title_top_text">我的健康购</div>
            </div>
            <div class="clear"></div>
            <div class="title_bottom">
                <div class="title_bottom_name" id="showusername">${userinfo.username}</div>
                <div class="title_bottom_menu">
                   <!--  <span style="margin-left:0px;"><a href="">我的编号：111</a></span> -->
                    &nbsp;  &nbsp;  
                    <span><a href="/user/userinfo.html">信息管理</a></span>
                    <c:if test="${userinfo.isVip != 1 }">
                   		 <span><a href="/user/app/uservip.html" style="color:red">注册成为高级会员</a></span>
                   	</c:if>
                </div>
            </div>
        </div>
</body>
</html>