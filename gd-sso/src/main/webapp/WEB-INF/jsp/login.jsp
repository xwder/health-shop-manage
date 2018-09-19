<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>登录</title>
<link rel="shortcut icon" href="/images/favicon.ico" type="image/ico"/>
<link rel="stylesheet" href="/css/amazeui.min.css" />
<script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/js/amazeui.min.js"></script>
<link rel="stylesheet" href="/css/login.css" />
<link rel="stylesheet" href="/css/mui.min.css" />
<script type="text/javascript" src="/js/mui.min.js"></script>
<script type="text/javascript" src="/js/login.js"></script>
<title></title>
<style>
.bottomLine {
	border-bottom: 1px solid #ccc;
	border-top: 1px solid #ccc;
	padding-top: 8px;
	/*padding-bottom:10px;*/
}

.bot {
	/*margin-top: 5px;*/
	margin-bottom: 49px;
	/*text-align: center;*/
	color: #7b6f5b;
}
</style>
</head>

<body>

	<div class="am-g" style="margin-top: 5px;">
		<div style="width: 1200px; margin: 0 auto;">
			<div class="logo">
				<a href="http://localhost:8881"><img
					src="/images/login/logo.png" /></a>
			</div>
			<div style="float: right; margin-right: 60px; margin-top: 18px;">
				<span
					style="float: right; font-size: 12px; margin-left: 5px; color: #7d7d7d;"><span
					style="background-image: url(images/login/massageicon.png); width: 20px; height: 20px; margin-top: 4px; float: left; background-repeat: no-repeat; margin-right: 8px;"></span>对登录页面的建议</span>
			</div>
		</div>
	</div>
	<div class="am-g content" style="margin-top: 5px;">
		<div
			style="width: 1200px; margin: 0 auto; position: relative; z-index: 999;">
			<div class="loginDiv " style="display: block;" id="login">
				<div class="am-u-sm-12" style="padding-right: 0rem">
					<img src="/images/login/erweima.png"
						style="float: right; height: 58px;" id="loginimg"/ >
				</div>





				<form id="formlogin" method="post" onsubmit="return false;">

					<div class="am-u-sm-12"
						style="padding-left: 30px; padding-right: 30px;">
						<h4 style="font-weight: normal;">欢迎登录</h4>
						<span class="left1"></span> <input type="text" id="loginname"
							name="username" class="am-form-field" placeholder="邮箱/手机号/用户名"
							style="padding-left: 50px; margin-top: 48px; font-size: 12px;" />
					</div>
					<div class="am-u-sm-12"
						style="margin-top: 21px; padding-left: 30px; padding-right: 30px;">
						<span class="left2"></span> <input type="password" id="nloginpwd" name="password"
							class="am-form-field" placeholder="请输入密码"
							style="padding-left: 50px; font-size: 12px;" />
					</div>
					<div class="am-u-sm-12"
						style="margin-top: 12px; padding-left: 30px; padding-right: 30px; font-size: 12px; color: #757575;">
						<input type="checkbox"
							style="margin-top: 1px; vertical-align: middle;" /><span
							style="margin-bottom: -1px; margin-left: 10px; font-size: 12px; vertical-align: middle;">自动登录</span>
					</div>

					<div class="am-u-sm-12"
						style="margin-top: 8px; padding-left: 30px; padding-right: 30px;">
						
						<button id="loginsubmit" type="button" class="am-btn am-btn-warning" style="width: 100%;border-radius: 5px;font-size: 16px;" >登录</button>	
						
					 
					</div>
				</form>



				<div class="am-u-sm-12"
					style="padding-left: 30px; padding-right: 30px;">
					<p
						style="width: 100%; margin-top: 15px; font-size: 12px; color: #333333;">
						忘记登录密码 <span style="float: right;"><a href="register.html">免费注册</a></span>
					</p>
				</div>

			</div>
			<!--扫码页面-->
			<div class="loginDiv" style="display: none;" id="erm">
				<div class="am-u-sm-12" style="padding-right: 0rem">
					<img src="/images/login/pc_2.png" style="float: right;" id="ermimg" />
				</div>
				<div class="am-u-sm-12"
					style="padding-left: 30px; padding-right: 30px; margin-top: 30px; text-align: center;">
					<h4>手机扫码，安全登录</h4>
				</div>
				<div class="am-u-sm-12"
					style="padding-left: 30px; padding-right: 30px; margin-top: 50px; text-align: center;">
					<img src="/images/login/aerweima.png" />
				</div>

				<div class="am-u-sm-12"
					style="margin-top: 50px; padding-left: 30px; padding-right: 30px; text-align: center;">
					<p style="font-size: 14px;">请使用健康购网客户端扫描二维码登录</p>
					<p style="text-align: center;">
						<span
							style="background-image: url(./images/login/Download-512.png); float: left; width: 20px; height: 20px; margin-top: 5px; background-repeat: no-repeat; margin-left: 100px;"></span>
						<a style="float: left; font-size: 12px;"> 下载健康购客户端</a>
					</p>
				</div>
				<div class="am-u-sm-12"
					style="margin-top: 10px; padding-left: 30px; padding-right: 30px; margin-bottom: 100px;">
				</div>

			</div>
		</div>
	</div>
	<div class="am-g "
		style="margin-top: 81px; text-align: center; font-size: 12px;">
		<div class="bottomLine"
			style="margin: 0 auto; width: 700px; height: 35px;">
			<span
				style="float: left; word-spacing: 0.52rem; text-align: center; width: 100%;">关于我们
				| 联系我们 | 商家入驻 | 友情链接 | 站点地图 | 手机商城 | 销售联盟 | 商城社区 | 企业文化 | 帮助中心 </span>
		</div>
	</div>
	<div class="am-g">
		<div class="bot ">
			<div style="margin: 0 auto; width: 700px; height: 30px;">
				<p style="font-size: 12px; float: left; line-height: 10px;">
					© &nbsp;2005-2016 健康购网 版权所有 ，并保留所有权利 <span
						style="margin-left: 30px;">健康购 Tel ：4008125181 </span><span
						style="margin-left: 20px;">E-mai：maila@163.com</span>
				</p>
			</div>
		</div>
	</div>


	<script type="text/javascript">
	var redirectUrl = "${redirect}";
		var LOGIN = {
			checkInput : function() {
				if ($("#loginname").val() == "") {
					alert("用户名不能为空");
					$("#loginname").focus();
					return false;
				}
				if ($("#nloginpwd").val() == "") {
					alert("密码不能为空");
					$("#nloginpwd").focus();
					return false;
				}
				return true;
			},
			doLogin : function(redirectUrl) {
				$.post("/user/login", $("#formlogin").serialize(), function(
						data) {
					if (data.status == 200) {
						alert("登录成功！");
						if (redirectUrl == "") {
							location.href = "http://localhost:8881";
						} else {
							location.href = redirectUrl;
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