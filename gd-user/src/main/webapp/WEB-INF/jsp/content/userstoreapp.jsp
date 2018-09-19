<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="now" class="java.util.Date" />


	            <div class="content_right">
                <div class="content_right_title"><span style="margin-left:30px;">店铺申请</span></div>
                <div class="content_right_bottom">
                   
                    <div style="margin-left: 30px;">
                     <form action="/user/app/addstoreapp" onSubmit="return confirm();" method="POST" enctype="multipart/form-data">
                        <table style="text-align: left;">
                            <tr>
                                <td colspan="2">亲爱的${userinfo.username} ，填写真实的资料，有助于更快通过审核！</td>
                                <td><input type="hidden" name="id" value="${storeapp.id}"><input type="hidden" id="userid" name="userid" value="${userinfo.id}"></td>
                            </tr>
                            <tr height="10px"><td colspan="2"></td></tr>
                            
                            <tr>
                                <td>*店主姓名</td>
                                <td>
                                	  <input type="text" id="ownname" name="ownname" <c:if test="${storeapp.ownname == null}"> placeholder="请输入真实姓名" size="22" </c:if> value="${storeapp.ownname }" style="height: 20px;width:118px;"> 
                                </td>
                            </tr>
                               <tr height="10px"><td colspan="2"></td></tr>

                            <tr>
                                <td>*电话</td>
                                <td>
                                	  <input type="text" id="phone" name="phone" <c:if test="${storeapp.phone == null}"> placeholder="请输入真实电话" size="22" </c:if> value="${storeapp.phone }" style="height: 20px;width:118px;"> 
                                </td>
                            </tr>
                               <tr height="10px"><td colspan="2"></td></tr>
                               
                             <tr>
                                <td>*身份证ID</td>
                                <td>
                                	 <input type="text" id="uid" name="uid" <c:if test="${storeapp.uid == null}"> placeholder="请输入真实身份信息" size="22" </c:if> value="${storeapp.uid }"  style="height: 20px;width:118px;">
                                </td>
                            </tr>
                               <tr height="10px"><td colspan="2"></td></tr>
                            
                            <tr>
                                <td>*身份证图片</td>
                                <td><img src="${storeapp.uidimageurl}" alt="" width="60" height="60"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="file" name="file" id="fileUpload" ></td>
                                 
                            </tr>
                             <tr height="10px"><td colspan="2"></td></tr>
                            
                            <tr>
                                <td>*店铺名称</td>
                                <td>
                                	  <input type="text" id="storename" name="storename" <c:if test="${storeapp.storename == null}"> placeholder="请输入店铺名称" size="22" </c:if> value="${storeapp.storename }" style="height: 20px;width:118px;"> 
                                </td>
                            </tr>
                               <tr height="10px"><td colspan="2"></td></tr>
                               
                            <tr>
                                <td>*店铺地址</td>
                                <td>
                               	<div class="docs-methods">
								<div class="form-inline">
									<div id="distpicker">
										<div class="form-group">
											<div style="position: relative;">
												<input id="city-picker3" class="form-control" readonly type="text" 
												name="storeaddr" <c:if test="${storeapp.storeaddr == null }"> value="北京市/北京市/朝阳区" </c:if> value="${storeapp.storeaddr}" data-toggle="city-picker">
											</div>
										</div>
									</div>
								</div>
							</div>
                                </td>
                            </tr>
                               <tr height="10px"><td colspan="2"></td></tr>
                               
                               
                          
                            <tr>
                                <td>*详细地址</td>
                                <td>
                                	 <textarea name="detailaddr" id="detailaddr"  cols="30" rows="3" style="width: 200px;">${storeapp.detailaddr}</textarea>
                                </td>
                            </tr>
                               <tr height="10px"><td colspan="2"></td></tr>
                               
                     		  <tr>
                                <td>营业执照编号(可选)</td>
                                <td>
                                	  <input type="text" id="storelicenseid" name="storelicenseid"  <c:if test="${storeapp.storelicenseid == null}"> placeholder="请输入店铺名称" size="22" </c:if> value="${storeapp.storelicenseid }" style="height: 20px;width:118px;">
                                	  
                                </td>
                            </tr>
                               <tr height="10px"><td colspan="2"></td></tr>
                                      
                            
                            <tr>
                                <td>营业执照图片(可选)</td>
                                <td><img src="${storeapp.licenseimageurl}" alt="" width="60" height="60"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="file" name="file" id="fileUpload" ></td>
                            </tr>
                            <tr height="10px">
                                <td colspan="2"></td>
                            </tr>
                            
                            
                            <tr>
                                <td>*店铺类型</td>
                                <td>
                                	  	  <select name="storetype" id="storetype" <c:if test="${storeapp.storetype == null}">value="6"</c:if>  <c:if test="${storeapp.storetype != null}">value="${storeapp.storetype}"</c:if>>
											<option value="1">蔬菜类店铺</option>
											<option value="2">水果类店铺</option>
											<option value="3">肉类店铺</option>
											<option value="4">熟食类店铺</option>
											<option value="5">谷物类店铺</option>
											<option value="6">综合类店铺</option>
										  </select>
                                </td>
                            </tr>
                               <tr height="10px"><td colspan="2"></td></tr>
                              
                            <tr>
                                <td>店铺logo图片</td>
                                <td><img src="${storeapp.storelogoimg}" alt="" width="60" height="60"></td>
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
                                <td><input type="text" readonly="true" name="sqdate" <c:if test="${storeapp.sqdate == null}"> value=' <fmt:formatDate value="${now}" dateStyle="medium" /> '</c:if>
                                								<c:if test="${storeapp.sqdate != null}">value=" <fmt:formatDate value="${storeapp.sqdate}" dateStyle="medium" />" </c:if> style="height: 23px;width:100px;"></td>
                            </tr>
                            
                             <tr height="10px"><td colspan="2"></td></tr>
                           
                            <tr>
                                <td>申请状态</td>
                                <td>
                                	<input type="text" readonly="true"  id="sqstatus"  name="sqstatus" 
		                                  <c:if test="${storeapp.sqstatus == null}"> value='待申请'</c:if> 
										  <c:if test="${storeapp.sqstatus == 2}"> value='待审核'</c:if> 
					   					  <c:if test="${storeapp.sqstatus == 0}"> value='审核失败'</c:if>
										  <c:if test="${storeapp.sqstatus == 1}"> value='审核成功'</c:if>   style="height: 20px;width:118px;">
							   </td>
                            </tr>
                            
                            <tr height="10px">
                                <td colspan="2"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="submit" <c:if test="${storeapp.sqstatus == null}"> value="提交" </c:if> 
                                							<c:if test="${storeapp.sqstatus != null}"> value="已申请" </c:if> 
                                 							 id="change" style="line-height: 28px; height: 28px;width: 70px; color: #FFF;font-weight: 700;font-size: 14px;background: #FF4001;border-radius: 3px;border: 0;"></td>
                            </tr>
                        </table>
                        </form>
                        </div>
                    </div>
                </div>
                <input type="hidden" id="storetype_" value="${storeapp.storetype}"/>
                <script type="text/javascript">
                	var storetype = $("#storetype_").val();
                	$("#storetype").val(storetype);
                </script>