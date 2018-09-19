<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>健康购后台管理系统--登录</title>
<link rel="shortcut icon" href="/images/favicon.ico" type="image/ico"/>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="/layui/css/layui.css">
<link rel="stylesheet" type="text/css" href="/css/sccl.css">

</head>

<body class="login-bg">
	<div class="login-box">
		<header>
		<h1>健康购后台管理系统</h1>
		</header>
		<div class="login-main">
			<form id="formlogin" class="layui-form" onsubmit="return false;"
				method="post">

				<div class="layui-form-item">
					<label class="login-icon"> <i class="layui-icon"></i>
					</label> <input type="text" id="username" name="username"
						lay-verify="userName" autocomplete="off" placeholder="这里输入登录名"
						class="layui-input">
				</div>
				<div class="layui-form-item">
					<label class="login-icon"> <i class="layui-icon"></i>
					</label> <input id="password" type="password" name="password"
						lay-verify="password" autocomplete="off" placeholder="这里输入密码"
						class="layui-input">
				</div>

				<div class="layui-form-item">
					<input type="radio" value="1" name="identity" checked="checked">商家&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="2" name="identity">营养师&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="3" name="identity">管理员&nbsp;
				</div>

				<div class="layui-form-item">
					<div class="pull-left login-remember">
						<label>记住帐号？</label> <input type="checkbox" name="rememberMe"
							value="true" lay-skin="switch" title="记住帐号">
						<div class="layui-unselect layui-form-switch">
							<i></i>
						</div>
					</div>
					<div class="pull-right">
						<button id="loginsubmit" class="layui-btn layui-btn-primary"
							lay-submit="" lay-filter="login">
							<i class="layui-icon"></i> 登录
						</button>
					</div>
					<div class="clear"></div>
				</div>
			</form>
		</div>
	</div>

	<script src="/layui/layui.js"></script>
	<script type="text/javascript">
		var redirectUrl = "${redirect}";
		var LOGIN = {
			checkInput : function() {
				if ($("#username").val() == "") {
					alert("用户名不能为空");
					$("#username").focus();
					return false;
				}
				if ($("#password").val() == "") {
					alert("密码不能为空");
					$("#password").focus();
					return false;
				}
				return true;
			},
			doLogin : function(redirectUrl) {
				$.post("/user/mlogin", $("#formlogin").serialize(), 
					function(data) {
					if (data.status == 200) {
						alert("登录成功！");
						
							if (data.data.identity == 1) {
								location.href = "http://localhost:8890/manager/checklogin/"+data.data.token;
							} else if (data.data.identity == 2) {
								location.href = "http://localhost:8888/index.html";
							} else if (data.data.identity == 3) {
								location.href = "http://localhost:8886/manager/index.html";
							} else {
								location.href = "http://localhost:8881";
							}
						

					} else {
						alert("登录失败，原因是：" + data.msg);
						$("#loginname").select();
					}
					});
			},			
			login : function() {
				if (this.checkInput()) {
					this.doLogin(redirectUrl);
				}
			}

		};
		$(function() {

			$("#loginsubmit").click(function() {
				LOGIN.login(redirectUrl);
			});
		});
	</script>
</body>
</html>
