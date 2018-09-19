function confirm() {
	if ($("#userid").val() == null) {
		alert("信息有误，您暂时不能申请！");
		return false;
	} else if ($("#sqstatus").val() == '待审核') {
		alert("您已经申请，请耐心等待！");
		return false;
	} else if ($("#sqstatus").val() == '审核成功') {
		alert("您已经申请通过,请勿再申请！");
		return false;
	} else if ($("#ownname").val().length <= 0) {
		alert("请输入店主姓名！");
		$("#ownname").focus();
		return false;
	} else if ($("#phone").val().length <= 0) {
		alert("请输入店主电话！");
		$("#phone").focus();
		return false;
	} else if ($("#uid").val().length <= 0) {
		alert("请输入店主身份证号码！");
		$("#uid").focus();
		return false;
	} else if ($("#storename").val().length <= 0) {
		alert("请输入店铺名称！");
		$("#storename").focus();
		return false;
	} else if ($("#detailaddr").val().length <= 0) {
		alert("请输入店铺详细地址！");
		$("#detailaddr").focus();
		return false;
	} else {
		return true;
	}
}
