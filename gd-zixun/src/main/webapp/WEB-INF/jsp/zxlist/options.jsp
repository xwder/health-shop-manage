<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
  <div class="navbox">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td align="left" valign="top"><div class="nav c50">
          <dl>
            <dt><a href="" target="_blank">新闻</a> </dt>
            <dd><a href="" target="_blank">人口计生</a></dd>
            <dd><a href="" target="_blank">公共卫生</a></dd>
            <dd><a href="" target="_blank">时评</a></dd>
          </dl>
          <dl>
            <dt><a href="" target="_blank">寻医问药</a> </dt>
            <dd><a href="" target="_blank">中医中药</a></dd>
            <dd><a href="" target="_blank">农村卫生</a></dd>
            <dd><a href="" target="_blank">医生园地</a></dd>
          </dl>
          <dl>
            <dt><a href="" target="_blank">视频</a> </dt>
            <dd><a href="" target="_blank">产业经济</a></dd>
            <dd><a href="" target="_blank">教育培训</a></dd>
          </dl>
          <dl>
            <dt><a href="" target="_blank">舆情</a> </dt>
            <dd><a href="" target="_blank">探讨思考</a></dd>
            <dd><a href="" target="_blank">政务信息</a></dd>
            <dd><a href="" target="_blank">管理</a></dd>
          </dl>
          <dl>
            <dt><a href="" target="_blank">健康生活</a></dt>
            <dd><a href="" target="_blank">社区卫生</a></dd>
            <dd><a href="" target="_blank">医学前沿</a></dd>
            <dd><a href="" target="_blank">医学人文</a></dd>
          </dl>
          <dl>
            <dt><a href="" target="_blank">专题</a></dt>
            <dd><a href="">食品药品</a></dd>
            <dd><a href="" target="_blank">人才招聘</a></dd>
          </dl>
        </div></td>
      <td valign="top" align="right"><div class="nav-els">
          <div class="sub-els"><strong>健康报系</strong><a href="" target="_blank">健康报</a><a href="" target="_blank">健康文摘报</a><a href="">中国卫生</a><a href="">村医导刊</a><span></span></div>
          <div id=s1 class=subMenu1 onmouseover=popupNoClose(); onmouseout=popupClose();> <a href="" target="_blank">北京市</a> <a href="" target="_blank">天津市</a> <a href="" target="_blank">上海市</a><a href="" target="_blank">内蒙古自治区</a><a href="" target="_blank">新疆维吾尔自治区</a><a href="" target="_blank">宁夏回族自治区</a><a href="" target="_blank">黑龙江省</a> <a href="" target="_blank">吉林省</a> <a href="" target="_blank">辽宁省</a><a href="" target="_blank">河北省</a> <a href="" target="_blank">山西省</a><a href="" target="_blank">河南省</a><a href="" target="_blank">江苏省</a><a href="" target="_blank">安徽省</a><a href="" target="_blank">浙江省</a><a href="" target="_blank">福建省</a><a href="" target="_blank">湖北省</a><a href="" target="_blank">海南省</a><a href="" target="_blank">甘肃省</a><a href="" target="_blank">陕西省</a><a href="" target="_blank">贵州省</a><a href="" target="_blank">新疆生产建设兵团</a><a href="" target="_blank">青岛</a></div>
        </div></td>
    </tr>
  </table>
</div>




  <div class="sub-head"> <a class="fl"><img src="/statics/images/36.jpg" /></a>
    <div class="soRight">
      <form action="" method="get" target="_blank">
            <input type="hidden" name="m" value="search"/>
            <input type="hidden" name="c" value="index"/>
            <input type="hidden" name="a" value="init"/>
            <input type="hidden" name="typeid" value="1" id="typeid"/>
			<input type="hidden" name="siteid" value="1" id="siteid"/>
            <input type="text" class="inpt" name="q" id="q"/><input name="" type="image" src="/statics/images/sobtn.gif" class="sobtn" />
        </form>
    </div>
  </div>
  <p class="clear"></p>
      	 
       <div class="sub-nav c50">
          <a href="http://localhost:8880/zixun/资讯首页.html" >资讯首页</a>
          <c:forEach var="zxtype" items="${zxtypeList}"  >
					|<a href="http://localhost:8880/zixun/${zxtype.zxtypename}.html" >${zxtype.zxtypename}</a> 
		  </c:forEach>
          
                </div>