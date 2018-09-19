<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	            <div class="content_right">
                <div class="content_right_title"><span style="margin-left:10px;">收货地址</span></div>
                <div class="content_right_bottom">
                    <div>
                        <table>
                            <tr>
                                <td style="color:red;">新增收货地址</td>
                                <td>&nbsp;电话号码、手机号选填一项, 其余均为必填项</td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <form action="/user/address/addUserAddress.html" method="POST" onSubmit="return confirm();" >
                                        <table>
                                            <tr>
                                                <td style="text-align:right;">所在地区<span>*</span></td>
                                                <td>
                                                	<input type="text" id="province" name="province" value="${address.province}">
                                                	<input type="hidden" name="id" value="${address.id}">
                                                </td>
                                            </tr>
                                            <tr>
                                                <td style="height:5px;"></td>
                                            </tr>
                                            <tr>
                                                <td style="text-align:right;">详细地址<span>*</span></td>
                                                <td><textarea name="detailaddr" id="detailaddr"  cols="30" rows="3">${address.detailaddr}</textarea></td>
                                            </tr>
                                            <tr>
                                                <td style="height:5px;"></td>
                                            </tr>
                                            <tr>
                                                <td style="text-align:right;">邮政编码<span>*</span></td>
                                                <td><input type="text" id="zipcode" name="zipcode" value="${address.zipcode }"></td>
                                            </tr>
                                            <tr>
                                                <td style="height:5px;"></td>
                                            </tr>
                                            <tr>
                                                <td style="text-align:right;">收货人姓名<span>*</span></td>
                                                <td><input type="text" id="receiptname" name="receiptname" value="${address.receiptname }"></td>
                                            </tr>
                                            <tr>
                                                <td style="height:5px;"></td>
                                            </tr>
                                            <tr>
                                                <td style="text-align:right;">手机号码<span>*</span></td>
                                                <td><input type="text" id="receipphone" name="receipphone" value="${address.receipphone }"></td>
                                            </tr>
                                            <tr>
                                                <td style="height:5px;"></td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td><button type="submit">保存</button></td>
                                            </tr>
                                        </table>
                                    </form>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div style="margin-top:15px;width:100%;">
                    <c:if test="${addressCount > 0 }">
                        <span style="font-weight:700;display:block;margin-left:28px;">已保存了${addressCount}条地址，还能保存${syAddressCount}条地址</span>
                        <div style="margin-left:28px;width:95%;margin-top:5px;">
                            <table style="border-collapse: collapse;width:100%;border:solid 1px #e7e7e7;">
                                <tr class="thead-tbl-grade">
                                    <th>收货人</th>
                                    <th>所在地区</th>
                                    <th>详细地址</th>
                                    <th>邮编</th>
                                    <th>手机号码</th>
                                    <th>操作</th>
                                    <th>操作</th>
                                </tr>
                                <c:forEach items="${addressList}" var = "address">
                                	 <tr class="thead-tbl-address">
		                                    <td width="60"> ${address.receiptname }</td>
		                                    <td width="120" style="padding:8px">${address.province }</td>
		                                    <td width="140" style="padding:8px">${address.detailaddr }</td>
		                                    <td width="80" style="padding:8px">${address.zipcode }</td>
		                                    <td width="80" style="padding:8px">${address.receipphone }</td>
		                                    <td style="padding:8px"><a href="/user/address/updateAddress/${address.id }.html">修改</a>|
		                                    						<a href="/user/address/deleteAddress/${address.id }.html">删除</a></td>
		                                   	<c:if test="${address.defauladdress > 0 }">
		                                   		<td style="padding:8px"><span class="note">默认地址</span></td>
		                                   	</c:if>
		                                   	<c:if test="${address.defauladdress <= 0 }">
		                                   		<td style="padding:8px"><a href="/user/address/defauladdress/${address.id }.html">设为默认地址</a></span></td>
		                                   	</c:if>
		                                    
                              		  </tr>
                                </c:forEach>
                               
                            </table>
                        </div>
                        </c:if>
                        <c:if test="${addressCount < 1 }">
                      	  <span style="font-weight:700;display:block;margin-left:28px;">您还未添加收货地址！</span>
                        </c:if>
                    </div>
                </div>
            </div>
</body>
</html>