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
                <div class="content_right_title"><span style="margin-left:30px;margin-top:20px;">修改密码</span></div>
                <div class="content_right_bottom">
                   
                    <div style="margin-left: 30px;">
            		 <form id="pwform"  method="POST" onSubmit="return false;" >         
                        <table style="text-align: left;">
                         <tr height="10px"><td colspan="2"></td></tr>
                          <tr height="10px"><td colspan="2"></td></tr>
                            <tr>
                                <td>*原密码</td>
                                <td>
                                	<input type="password" id="oldpw" name="oldpw" value="" style="height: 20px;width:118px;">
                                	<input type="hidden" value="${userinfo.id }" name="id">
                                </td>
                            </tr>
                               <tr height="10px"><td colspan="2"></td></tr>
                            <tr>
                                <td>*新密码</td>
                                <td><input type="password" id="newpw" name="newpw" value="" style="height: 20px;width:118px;"></td>
                            </tr>
                              <tr height="10px"><td colspan="2"></td></tr>
    					   <tr>
                                <td>*确定密码</td>
                                <td><input type="password" id="renewpw" name="renewpw" style="height: 20px;width:118px;"></td>
                            </tr>
                             <tr height="10px"><td colspan="2"></td></tr>
                            <tr>
                                <td></td>
                                <td><input type="button" value="修改"  id="change"style="line-height: 28px; height: 28px;width: 70px; color: #FFF;font-weight: 700;font-size: 14px;background: #FF4001;border-radius: 3px;border: 0;"></td>
                            </tr>
                        </table>
                        </form>
                        </div>
                    </div>
                </div>
</body>
</html>