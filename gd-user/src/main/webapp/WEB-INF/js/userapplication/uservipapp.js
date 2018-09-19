function uservipapp() {
	if ($("#userid").val().length == 0) {
		alert("信息有误暂时无法申请！");
		return;
	} else if ($("#username").val().length == 0) {
		alert("信息有误暂时无法申请！");
		return;
	} else {
		$.post("/user/app/uservipapp", $("#uservip").serialize(),
				function(data) {
					if (data.status == 200) {
						alert("申请成功,请耐心等待审核！");
						$("#sqstatus").val("待审核");
						$("#change").val("已申请");

					} else {
						alert("提交申请失败！" + data.msg);
						$("#newpw").select();
					}
				});

	}
}

$(function() {
	$("#change").click(function() {
		if ($("#sqstatus").val() == '待审核') {
			alert("您已经申请，请耐心等待！");
		} else if ($("#sqstatus").val() == '审核成功') {
			alert("您已经申请通过,请勿再申请！");
		} else {
			uservipapp();
		}

	});

});