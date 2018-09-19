<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link rel="stylesheet" href="/css/main.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css" media="screen" />
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/tendina.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>

<div style="margin: 0 auto; text-align:">
	<div class="modal-body">
		<form class="form-horizontal" method="POST"
			action="/manager/user/updateuserinfo" enctype="multipart/form-data"
			id="updateform">
			<fieldset>
				<div id="legend" class="">
					<legend>用户信息管理</legend>
					<input name="id" value="${userinfo.id }" type="hidden"/>
				</div>

				<div class="control-group">
					<!-- Text input-->
					<label class="control-label" for="input01">用户名</label>
					<div class="controls">
						<input type="text" name="username" id="username" value="${userinfo.username }"
							class="input-xlarge" style="width: 480px;" readonly="readonly">
					</div>
				</div>
				
				<div class="control-group">
					<label class="control-label">用户头像</label>
					<div >
						<img alt="" src="${userinfo.image }" style="width:200px;height: 200px;">
					</div>
					<!-- File Upload -->
					<div class="controls">
						<input class="input-file" name="file" id="fileInput" type="file"
							style="width: 480px;">
					</div>
				</div>
				<div class="control-group">
		          <label class="control-label">性别</label>
				       <input type="radio" value="1" name="sex"  <c:if test="${userinfo.sex== 1}">checked="checked"</c:if>>男
                       <input type="radio" value="0" name="sex" <c:if test="${userinfo.sex== 0}">checked="checked"</c:if>>女
			      </label>
				 </div>
				 
				 <div class="control-group">
					<!-- Text input-->
					<label class="control-label" for="input01">昵称</label>
					<div class="controls">
						<input type="text" name="name" id="name" value="${userinfo.name }"
							class="input-xlarge" style="width: 480px;" >
					</div>
				 </div>
				 
				 <div class="control-group">
					<!-- Text input-->
					<label class="control-label" for="input01">手机</label>
					<div class="controls">
						<input type="text" name="phone" id="phone" value="${userinfo.phone }"
							class="input-xlarge" style="width: 480px;" >
					</div>
				 </div>
				 
				 <div class="control-group">
					<!-- Text input-->
					<label class="control-label" for="input01">邮箱</label>
					<div class="controls">
						<input type="text" name="email" id="email" value="${userinfo.email }"
							class="input-xlarge" style="width: 480px;"  >
					</div>
				 </div>
				 
				<div class="control-group">
					<!-- Text input-->
					<label class="control-label" for="input01">专属高级会员营养师</label>
					<div class="controls">
						<input type="text" name="dietitianid" id="dietitianid" "
							<c:if test="${userinfo.dietitianid== 0}">value="否"</c:if>   <c:if test="${userinfo.dietitianid== 1}">value="是"</c:if>
							class="input-xlarge" style="width: 480px;"  readonly="readonly">
					</div>
				 </div>
				 
				 
				
				<div class="control-group">
					<!-- Text input-->
					<label class="control-label" for="input01">是否高级会员</label>
					<div class="controls">
						<input type="text" name="isVip" id="isVip" 
							<c:if test="${userinfo.isVip== 1}">value="是"</c:if>   <c:if test="${userinfo.isVip== 0}">value="否"</c:if>
							class="input-xlarge" style="width: 480px;" readonly="readonly">
					</div>
				 </div>
				<div class="control-group">
					<!-- Text input-->
					<label class="control-label" for="input01">商家</label>
					<div class="controls">
						<input type="text" name="isstore" id="isstore" 
							<c:if test="${userinfo.isstore== 1}">value="是"</c:if>   <c:if test="${userinfo.isstore== 0}">value="否"</c:if>
							class="input-xlarge" style="width: 480px;" readonly="readonly">
					</div>
				 </div>
				<div class="control-group">
					<!-- Text input-->
					<label class="control-label" for="input01">营养师</label>
					<div class="controls">
						<input type="text" name="isdiet" id="isdiet" 
							<c:if test="${userinfo.isdiet== 1}">value="是"</c:if>   <c:if test="${userinfo.isdiet== 0}">value="否"</c:if>
							class="input-xlarge" style="width: 480px;" readonly="readonly">
					</div>
				 </div>
			</fieldset>
 
			<div class="controls" style="text-align: left;">
				<button type="button" id="updateuserinfo" class="btn btn-default">修改</button>
			</div>
		</form>
	</div>
</div>
<script>
 
	$("#updateuserinfo").click(function() {
			if ($("#name").val() == "") {
				alert("昵称为空！！");
				$("#name").focus();
			} else if ($("#phone").val() == "") {
				alert("手机号为空！！");
				$("#phone").focus();
			} else if ($("#email").val() == "") {
				alert("邮箱为空！！");
				$("#email").focus();
			}else {
				$("#updateform").submit();
			}
	});
	
</script>

