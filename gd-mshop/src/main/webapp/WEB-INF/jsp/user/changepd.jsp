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

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.2.0/jquery-confirm.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.2.0/jquery-confirm.min.js"></script>

<div style="margin: 0 auto; text-align:">
	<div class="modal-body">
		<form class="form-horizontal" method="POST"
			
			id="updateform">
			<fieldset>
				<div id="legend" class="">
					<legend>修改密码</legend>
					<input name="id" value="${userinfo.id }" type="hidden"/>
				</div>

				<div class="control-group">
					<!-- Text input-->
					<label class="control-label" for="input01">原密码</label>
					<div class="controls">
						<input type="password" name="oldpswd" id="oldpswd" value=""
							class="input-xlarge" style="width: 480px;"  >
					</div>
				</div>
				<div class="control-group">
					<!-- Text input-->
					<label class="control-label" for="input01">新密码</label>
					<div class="controls">
						<input type="password" name="newpd" id="newpd" value=""
							class="input-xlarge" style="width: 480px;"  >
					</div>
				</div>
				<div class="control-group">
					<!-- Text input-->
					<label class="control-label" for="input01">确认密码</label>
					<div class="controls">
						<input type="password" name="confirmnewpd" id="confirmnewpd" value=""
							class="input-xlarge" style="width: 480px;" >
					</div>
				</div>
				
			</fieldset>
 
			<div class="controls" style="text-align: left;">
				<button type="button" id="changepswd" class="btn btn-default">修改</button>
			</div>
		</form>
	</div>
</div>
<script>
 
	$("#changepswd").click(function() {
			if ($("#oldpswd").val() == "") {
				$.alert("原密码为空！！");
				$("#oldpswd").focus();
			} else if ($("#newpd").val() == "") {
				$.alert("新密码为空！！");
				$("#newpd").focus();
			} else if ($("#confirmnewpd").val() == "") {
				$.alert("确认密码为空！！");
				$("#confirmnewpd").focus();
			}else if($("#newpd").val() != $("#confirmnewpd").val()){
				$.alert("两次密码不一致！！");
				$("#confirmnewpd").focus();
			} else{
				$.post("/manager/user/changepw", $("#updateform").serialize(),
						function(data) {
							if (data.status == 200) {
								 $.alert('修改成功!');
							} else {
								 $.alert("修改失败！请重试!" + data.msg);
							}
				});
			}
	});
	
</script>

