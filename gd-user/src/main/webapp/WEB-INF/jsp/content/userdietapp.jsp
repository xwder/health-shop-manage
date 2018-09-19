<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="now" class="java.util.Date" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	            <div class="content_right">
                <div class="content_right_title"><span style="margin-left:30px;">营养师申请</span></div>
                <div class="content_right_bottom">
                   
                    <div style="margin-left: 30px;">
                     <form action="/user/app/adddietapp" onSubmit="return confirm();" method="POST" enctype="multipart/form-data">
                        <table style="text-align: left;">
                            <tr>
                                <td colspan="2">亲爱的${userinfo.username} ，填写真实的资料，有助于更快通过审核！</td>
                                <td><input type="hidden" name="id" value="${dietapp.id}"></td>
                            </tr>
                            <tr height="10px"><td colspan="2"></td></tr>
                            
                            <tr>
                                <td>*用户名</td>
                                <td>
                                	  <input type="text" id="username" name="username" value="${dietapp.username }" placeholder="请输入真实姓名" style="height: 20px;width:118px;"> 
                                </td>
                            </tr>
                               <tr height="10px"><td colspan="2"></td></tr>
                               
                            <tr>
                                <td>*身份证ID</td>
                                <td>
                                	 <input type="text" id="uid" name="uid" value="${dietapp.uid }" placeholder="请输入真实身份证号" style="height: 20px;width:118px;">
                                </td>
                            </tr>
                               <tr height="10px"><td colspan="2"></td></tr>
                            
                            <tr>
                                <td>*身份证图片</td>
                                <td><img src="${dietapp.uidimagesurl}" alt="" width="60" height="60"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="file" name="file" id="fileUpload" ></td>
                                 
                            </tr>
                             <tr height="10px"><td colspan="2"></td></tr>
                             
                            <tr>
                                <td>*证书编号</td>
                                <td>
                                	  <input type="text" id="dietlicense" name="dietlicense" placeholder="营养师证书编号" value="${dietapp.dietlicense }" style="height: 20px;width:118px;">
                                </td>
                            </tr>
                               <tr height="10px"><td colspan="2"></td></tr>
                            
                            <tr>
                                <td>*证书图片</td>
                                <td><img src="${dietapp.dietimageurl}" alt="" width="60" height="60"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="file" name="file" id="fileUpload" ></td>
                            </tr>
                            
                            <tr height="10px">
                                <td colspan="2"></td>
                            </tr>
                            <tr>
                                <td>申请日期 </td>
                                <td><input type="text" name="sqdate" <c:if test="${dietapp.sqdate == null}"> value=' <fmt:formatDate value="${now}" dateStyle="medium" /> '</c:if>
                                								<c:if test="${dietapp.sqdate != null}">value= <fmt:formatDate value="${dietapp.sqdate}" dateStyle="medium" /> </c:if> style="height: 23px;width:100px;"></td>
                            </tr>
                            
                             <tr height="10px"><td colspan="2"></td></tr>
                           
                            <tr>
                                <td>申请状态</td>
                                <td>
                                	<input type="text" readonly="true"  id="sqstatus"  name="sqstatus" 
		                                  <c:if test="${dietapp.sqstatus == null}"> value='待申请'</c:if> 
										  <c:if test="${dietapp.sqstatus == 2}"> value='待审核'</c:if> 
					   					  <c:if test="${dietapp.sqstatus == 0}"> value='审核失败'</c:if>
										  <c:if test="${dietapp.sqstatus == 1}"> value='审核成功'</c:if>   style="height: 20px;width:118px;">
							   </td>
                            </tr>
                            
                            <tr height="10px">
                                <td colspan="2"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="submit" <c:if test="${dietapp.sqstatus == null}"> value="提交" </c:if> 
                                							<c:if test="${dietapp.sqstatus != null}"> value="已申请" </c:if> 
                                 							 id="change" style="line-height: 28px; height: 28px;width: 70px; color: #FFF;font-weight: 700;font-size: 14px;background: #FF4001;border-radius: 3px;border: 0;"></td>
                            </tr>
                        </table>
                        </form>
                        </div>
                    </div>
                </div>
</body>
</html>