function inputcheck() {
	// 不能为空检查
	if ($("#regName").val() == "") {
		alert("用户名不能为空");
		$("#szdl").trigger("click");
		$("#regName").focus();
		return false;
	}
	if ($("#phone").val() == "") {
		alert("手机号不能为空");
		$("#szdl").trigger("click");
		$("#phone").focus();
		return false;
	}
	if ($("#name").val() == "") {
		alert("昵称不能为空");
		$("#szdl").trigger("click");
		$("#name").focus();
		return false;
	}
	if ($("#email").val() == "") {
		alert("邮箱不能为空");
		$("#szdl").trigger("click");
		$("#email").focus();
		return false;
	}
	if ($("#pwd").val() == "") {
		alert("密码不能为空");
		$("#xiayibu").trigger("click");
		$("#pwd").focus();
		return false;
	}
	// 密码检查
	if ($("#pwd").val() != $("#pwdRepeat").val()) {
		alert("确认密码和密码不一致，请重新输入！");
		$("#xiayibu").trigger("click");
		$("#pwdRepeat").select();
		$("#pwdRepeat").focus();
		return false;
	}
	return true;
}

function checkinfo() {
	// 检查用户是否已经被占用
	var checkurl = "http://localhost:8884";
	window.flag = false;
	$.ajax({
		url : checkurl + "/user/check/" + $("#regName").val() + "/1?r="
				+ Math.random(),
		success : function(data) {
			if (data.data) {
				// 检查手机号是否存在
				$.ajax({
					url : checkurl + "/user/check/" + $("#phone").val()
							+ "/2?r=" + Math.random(),
					success : function(d) {
						if (d.data) {
							$.post("/user/register", {
								username : $("#regName").val(),
								phone : $("#phone").val(),
								email : $("#email").val(),
								name : $("#name").val(),
								password : $("#pwd").val()
							}, function(data) {
								if (data.status == 200) {
									$("#zccg").trigger("click");
									var html = "恭喜您，" + data.data.username
											+ "账号注册成功";
									$("#zctx").html(html);
								} else {
									alert("登录失败，原因是：" + data.msg);
									$("#loginname").select();
								}
							});
							window.flag = true;
						} else {
							alert("此手机号已经被注册！");
							$("#szdl").trigger("click");
							$("#phone").select();
						}
					}
				});
			} else {
				alert("此用户名已经被占用，请选择其他用户名");
				$("#szdl").trigger("click");
				$("#regName").select();
			}
		}
	});
	if (window.flag == true)
		return true;
}

$(function() {
	$("#next").click(function() {
		$("#xiayibu").trigger("click");
	});

	$("#register").click(function() {
		if (inputcheck()) {
			if (checkinfo()) {
			}
		}
	});

});

function post(url, params) {
	var temp = document.createElement("form");
	temp.action = url;
	temp.method = "post";
	temp.style.display = "none";
	for ( var x in params) {
		var opt = document.createElement("input");
		opt.name = x;
		opt.value = params[x];
		temp.appendChild(opt);
	}
	document.body.appendChild(temp);
	temp.submit();
	console.log(temp);
	alert(temp);
	return temp;
}
