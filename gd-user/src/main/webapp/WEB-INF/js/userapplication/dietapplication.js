function confirm() {
	if ($("#sqstatus").val() == '待审核') {
		alert("您已经申请，请耐心等待！");
		return false;
	} else if ($("#sqstatus").val() == '审核成功') {
		alert("您已经申请通过,请勿再申请！");
		return false;
	} else if ($("#username").val().length <= 0) {
		alert("请您的姓名！");
		$("#username").focus();
		return false;
	} else if ($("#uid").val().length <= 0) {
		alert("请输入您的身份证号码!");
		$("#uid").focus();
		return false;
	} else if ($("#dietlicense").val() <= 0) {
		alert("请输入您的营养师证书编号！");
		$("#dietlicense").focus();
		return false;
	} else{
		return true;
	}
}

