function confirm() {
	if ($("#name").val().length <= 0) {
		alert("昵称不能为空！");
		$("#name").focus();
		return false;
	}   else if ($("#phone").val().length <= 0) {
		alert("请输入电话！");
		$("#phone").focus();
		return false;
	} else {
		alert("修改的头像已经提交，待审核，下次登录生效！");
		return true;
	}
}
