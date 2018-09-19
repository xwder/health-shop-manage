function changepw(){
	if($("#oldpw").val().length == 0){
		alert("请输入原密码！");
		$("#oldpw").focus();
		return ;
	}else if($("#newpw").val().length == 0){
		alert("请输入新密码");
		$("#newpw").focus();
		return ;
	}else if($("#renewpw").val().length == 0){
		alert("请输入确认密码！");
		$("#renewpw").focus();
		return ;
	}else if($("#newpw").val() != $("#renewpw").val()){
		alert("两次密码不一致！");
		$("#newpw").focus();
		return;
	}else{
		$.post("/user/changepw", $("#pwform").serialize(),
		function(data) {
			if (data.status == 200) {
				alert("修改成功！");
			} else {
				alert("修改失败！" + data.msg);
				$("#newpw").select();
			}
		});
	}
}

$(function(){
	$("#change").click(function(){
		changepw();
	});
	
});