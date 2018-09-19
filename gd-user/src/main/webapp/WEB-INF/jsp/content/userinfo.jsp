<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

	            <div class="content_right">
                <div class="content_right_title"><span style="margin-left:30px;">个人资料</span></div>
                <div class="content_right_bottom">
                   
                    <div style="margin-left: 30px;">
                     <form action="/user/updateuserinfo.html" onSubmit="return confirm();"  method="POST" enctype="multipart/form-data">
                        <table style="text-align: left;">
                            <tr>
                                <td colspan="2">亲爱的${userinfo.username} ，填写真实的资料，有助于好友找到你哦。</td>
                                <td><input type="hidden" name="username" value="${userinfo.username}"></td>
                                <td><input type="hidden" name="id" value="${userinfo.id}"></td>
                            </tr>
                            <tr height="10px"><td colspan="2"></td></tr>
                            <tr>
                                <td>当前头像</td>
                                <td><img src="${userinfo.image}" alt="" width="60" height="60"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="file" name=file id="fileUpload" ></td>
                                 
                            </tr>
                             <tr height="10px"><td colspan="2"></td></tr>
                         
                            <tr>
                                <td>*性别</td>
                                <td><input type="radio" value="1" name="sex"  <c:if test="${userinfo.sex== 1}">checked="checked"</c:if>>男&nbsp;
                                    <input type="radio" value="0" name="sex" <c:if test="${userinfo.sex== 0}">checked="checked"</c:if>>女</td>
                            </tr>
                               <tr height="10px"><td colspan="2"></td></tr>
                            <tr>
                                <td>*昵称</td>
                                <td><input type="text" id="name" name="name" value="${userinfo.name }" style="height: 20px;width:118px;"></td>
                            </tr>
                            </tr>
                               <tr height="10px"><td colspan="2"></td></tr>
                            <tr>
                                <td>*手机</td>
                                <td><input type="text" id="phone" name="phone" value="${userinfo.phone }" style="height: 20px;width:118px;"></td>
                            </tr>
                               <tr height="10px"><td colspan="2"></td></tr>
                            <tr>
                                <td>*邮箱</td>
                                <td><input type="text" name="email" value="${userinfo.email }"  readonly="true"style="height: 20px;width:118px;"></td>
                            </tr>
                             <tr height="10px"><td colspan="2"></td></tr>
                            
                            <tr>
                                <td>专属高级会员营养师</td>
                                <td><input type="text" readonly="true" name="dietitianid" <c:if test="${userinfo.dietitianid== 0}">value="否"</c:if>   <c:if test="${userinfo.dietitianid== 1}">value="是"</c:if>  style="height: 20px;width:118px;"></td>
                            </tr>
                             <tr height="10px"><td colspan="2"></td></tr>
                             <tr>
                                <td>是否高级会员</td>
                                <td><input type="text" readonly="true" name="isVip"  <c:if test="${userinfo.isVip== 1}">value="是"</c:if>   <c:if test="${userinfo.isVip== 0}">value="否"</c:if>style="height: 20px;width:118px;"></td>
                            </tr>
                             <tr height="10px"><td colspan="2"></td></tr>
                             <tr>
                                <td>商家</td>
                                <td><input type="text" readonly="true" name="isstore"  <c:if test="${userinfo.isstore== 1}">value="是"</c:if>   <c:if test="${userinfo.isstore== 0}">value="否"</c:if>style="height: 20px;width:118px;"></td>
                            </tr>
                             <tr height="10px"><td colspan="2"></td></tr>
                             <tr>
                                <td>营养师</td>
                                <td><input type="text" readonly="true" name="isdiet"  <c:if test="${userinfo.isdiet== 1}">value="是"</c:if>   <c:if test="${userinfo.isdiet== 0}">value="否"</c:if>style="height: 20px;width:118px;"></td>
                            </tr>
                             <tr height="10px"><td colspan="2"></td></tr>
                            <tr>
                                <td></td>
                                <td><input type="submit" value="修改" style="line-height: 28px; height: 28px;width: 70px; color: #FFF;font-weight: 700;font-size: 14px;background: #FF4001;border-radius: 3px;border: 0;"></td>
                            </tr>
                        </table>
                        </form>
                        </div>
                    </div>
                </div>
<script type="text/javascript" src="/js/userinfo/updateuserinfo.js"></script>