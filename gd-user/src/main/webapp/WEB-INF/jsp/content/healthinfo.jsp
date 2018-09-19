<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	            <div class="content_right">
                <div class="content_right_title"><span style="margin-left:30px;">健康资料</span></div>
                <div class="content_right_bottom">
                   
                    <div style="margin-left: 30px;">
                   	 <form id="uhform"  method="POST" onSubmit="return false;" > 
                     
                      <table style="text-align: left;">
                            <tr>
                                <td colspan="2">亲爱的${userinfo.username} ，填写真实的资料，有助于营养师为你制定更合适的健康计划哦。</td>
                                <td>
                                	<input type="hidden" id="userid" name="userid" value="${userinfo.id}">
                                	<input type="hidden" id="id" name="id" value="${healthinfo.id}">
                                </td>
                            </tr>
                            <tr height="10px">
                                <td colspan="2"></td>
                            </tr>
                            <tr>
                                <td>用户名</td>
                                <td><input type="text" id="username" name="username" value="${healthinfo.username }" style="height: 20px;width:118px;"></td>
                            </tr>
                            <tr height="10px">
                                <td colspan="2"></td>
                            </tr>
                            <tr>
                                <td>身高(cm)</td>
                                <td><input type="text" name="height" id="height" value="${healthinfo.height }" style="height: 20px;width:118px;">厘米</td>
                            </tr>
                            <tr height="10px">
                                <td colspan="2"></td>
                            </tr>
                            <tr>
                                <td>体重(kg)</td>
                                <td><input type="text" id="weight" name="weight" value="${healthinfo.weight }" style="height: 20px;width:118px;"></td>
                            </tr>
                            <tr height="10px">
                                <td colspan="2"></td>
                            </tr>
                            <tr>
                                <td>*性别</td>
                                <td>&nbsp;&nbsp;&nbsp;<input type="radio" value="1" name="sex"  <c:if test="${healthinfo.sex== null}">checked="checked"</c:if>  <c:if test="${healthinfo.sex== 1}">checked="checked"</c:if>>男&nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="radio" value="0" name="sex" <c:if test="${healthinfo.sex== 0}">checked="checked"</c:if>>女</td>
                            </tr>
                            <tr height="10px">
                                <td colspan="2"></td>
                            </tr>
                            <tr>
                                <td>出生日期 </td>
                                <td><input  type="text"  class="laydate-icon" id="birthday"  name="birthday" value=" <fmt:formatDate value="${healthinfo.birthday}" dateStyle="medium" />" style="height: 23px;width:100px;"></td>
                            </tr>
                            <tr height="10px">
                                <td colspan="2"></td>
                            </tr>
                            <tr>
                                <td>饮食偏好</td>
                                <td><input type="text" id="dietprefe" name="dietprefe"  value="${healthinfo.dietprefe}"  style="height: 20px;width:118px;"></td>
                            </tr>
                            <tr height="10px">
                                <td colspan="2"></td>
                            </tr>
                            <tr>
                                <td>不喜欢的食物</td>
                                <td><input type="text"   value="${healthinfo.notlikefoods}" id="notlikefoods" name="notlikefoods" style="height: 20px;width:118px;"></td>
                            </tr>
                            <tr height="10px">
                                <td colspan="2"></td>
                            </tr>
                            <tr>
                                <td>健康状况</td>
                                <td>
                                	<input type="radio" value="0" name="healstatus" <c:if test="${healthinfo.healstatus == null}">checked="checked"</c:if>  <c:if test="${healthinfo.healstatus == '健康'}">checked="checked"</c:if>>健康&nbsp;
                                    <input type="radio" value="1" name="healstatus"  <c:if test="${healthinfo.healstatus == '亚健康'}">checked="checked"</c:if>>亚健康&nbsp;
                                    <input type="radio" value="2" name="healstatus"  <c:if test="${healthinfo.healstatus == '不健康'}">checked="checked"</c:if>>不健康
                                </td>
                            </tr>
                            <tr height="10px">
                                <td colspan="2"></td>
                            </tr>
                            <tr>
                                <td>过敏物品</td>
                                <td><input type="text" id="senfoods" name="senfoods" value="${healthinfo.senfoods}" style="height: 20px;width:118px;"></td>
                            </tr>
                            <tr height="10px">
                                <td colspan="2"></td>
                            </tr>
                            <tr>
                                <td>病史</td>
                                <td><input type="text" id="medhis" name="medhis" value="${healthinfo.medhis}" style="height: 20px;width:118px;"></td>
                            </tr>
                            <tr height="10px">
                                <td colspan="2"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="button"  id="change" value="修改" style="line-height: 28px; height: 28px;width: 70px; color: #FFF;font-weight: 700;font-size: 14px;background: #FF4001;border-radius: 3px;border: 0;"></td>
                            </tr>
                        </table>
                        </form>
                        </div>
                    </div>
                </div>
                    <script>
        ;! function () {
            laydate({
                elem: '#birthday'
            })
        }();
    </script>
                
</body>
</html>