<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<link rel="shortcut icon" href="/images/favicon.ico" type="image/ico"/>
<link rel="stylesheet" href="/css/amazeui.min.css" />
<script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/js/amazeui.min.js"></script>
<link rel="stylesheet" href="/css/regedit.css" />
<link rel="stylesheet" href="/css/sui.css" />
<script type="text/javascript" src="/js/sui.js"></script>
<title></title>
<style>
.bottomLine {
	border-bottom: 1px solid #ccc;
	border-top: 1px solid #ccc;
	padding-top: 8px;
	/*padding-bottom:10px;*/
}

.bot {
	margin-bottom: 50px;
	/*text-align: center;*/
	color: #7b6f5b;
}

.radio-pretty.checked>span:before {
	color: #f88600;
}

input {
	height: 62px;
}

.radio-pretty span:before {
	margin-right: 2px;
	vertical-align: -4px;
	font-size: 20px;
	color: #bdbdbd;
	margin-left: -2px;
}
</style>
</head>

<body>
	<div class="am-g" style="margin-top: 25px;">
		<div class="logo">
			<a href="http://localhost:8881"><img src="/images/login/logo.png" /></a>
		</div>
	</div>
	<div class="am-g">
		<div style="width: 999px; margin: 0 auto; font-size: 14px;">
			<span style="float: right; color: #333333;">我已注册，马上<span
				style="color: #F88600;"><a href="login.html">登录</a></span></span>
		</div>
	</div>
	<div class="am-g content" style="margin-top: 12px;">
		<div data-am-widget="tabs" class="am-tabs am-tabs-d2">
			<ul class="am-tabs-nav am-cf" style="margin-top: 74px;">
				<li class="" style="max-width: 95px; margin-left: 100px;"></li>
				<li class="am-active"><a id="szdl" href="[data-tab-panel-0]"><span
						class="am-badge am-round am-badge-warning-active "
						style="vertical-align: middle; margin-top: -4px;">1</span>设置登录名</a></li>
				<li class=""><a id="xiayibu" href="[data-tab-panel-1]"><span
						class="am-badge  am-round"
						style="vertical-align: middle; margin-top: -4px;">2</span>设置用户信息</a></li>
				<li class=""><a id="zccg" href="[data-tab-panel-2]"><span
						class="am-badge  am-round"
						style="vertical-align: middle; margin-top: -4px;">3</span>注册成功</a></li>
				<li class="" style="max-width: 95px; margin-right: 100px;"></li>
			</ul>

			
			<div class="am-tabs-bd" style="margin-top: 59px; margin-left: -20px;">
				<div data-tab-panel-0 class="am-tab-panel am-active">
					<div class="am-g">
						<div class="am-u-sm-7 am-u-sm-offset-3 ">
							<span class="left2"></span> <input type="text"
								placeholder="请输入您的用户名" class="am-form-field" id="regName" name="username"
								style="margin: auto; display: block; float: left; padding-left: 55px; width: 528px" />
						</div>
						<div class="am-u-sm-1 am-u-end" style="padding: 10px;">
							<span class="right" style="display: none;"></span>
						</div>
					</div>
					<div class="am-g" style="margin-top: 37px;">
						<div class="am-u-sm-7 am-u-sm-offset-3 ">
							<span class="left1"></span> <input type="text" id="phone" name="phone"
								placeholder="请输入您的手机号" class="am-form-field"
								style="margin: auto; display: block; float: left; padding-left: 55px; width: 528px" />
						</div>
						<div class="am-u-sm-1 am-u-end" style="padding: 10px;">
							<span class="right" style="display: none;"></span>
						</div>
					</div>
					<div class="am-g" style="margin-top: 37px;">
						<div class="am-u-sm-7 am-u-sm-offset-3 ">
							<span class="left2"></span> <input type="text" id="name" name="name"
								placeholder="请输入您的昵称" class="am-form-field"
								style="margin: auto; display: block; float: left; padding-left: 55px; width: 528px" />
						</div>
						<div class="am-u-sm-1 am-u-end" style="padding: 10px;">
							<span class="right" style="display: none;"></span>
						</div>
					</div>
					<div class="am-g" style="margin-top: 37px;">
						<div class="am-u-sm-7 am-u-sm-offset-3 ">
							<span class="left2"></span> <input type="text" id="email" name="email"
								placeholder="请输入您的邮箱" class="am-form-field"
								style="margin: auto; display: block; float: left; padding-left: 55px; width: 528px" />
						</div>
						<div class="am-u-sm-1 am-u-end" style="padding: 10px;">
							<span class="right" style="display: none;"></span>
						</div>
					</div>
					<div class="am-g" style="margin-top: 58px; margin-bottom: 80px;">
						<div class="am-u-sm-6 am-u-sm-offset-3 ">
							<button type="button" id="next" class="am-btn am-btn-warning"
								style="width: 100%; height: 62px; font-size: 20px; font-weight: bold; border: 1px rgba(187, 187, 187, 0.5) solid;">下一步</button>
						</div>
					</div>





				</div>
				<!--设置用户信息-->
				<div data-tab-panel-1 class="am-tab-panel ">
					<div class="am-g">
						<div class="am-u-sm-6 am-u-sm-offset-3 ">
							<span class="left3"></span> <input type="password" id="pwd" name="password"
								placeholder="请输入密码" class="am-form-field"
								style="margin: auto; display: block; float: left; padding-left: 59px; width: 100%" />
						</div>
					</div>
					<div class="am-g" style="margin-top: 36px;">
						<div class="am-u-sm-6 am-u-sm-offset-3 ">
							<span class="left3"></span> <input type="password" id="pwdRepeat" 
								placeholder="请再次输入密码" class="am-form-field"
								style="margin: auto; display: block; float: left; padding-left: 59px; width: 100%" />
						</div>
					</div>
					
					
					<div class="am-g" style="margin-top: 21px;">
						<form class="sui-form">
							<div class="am-u-sm-7 am-u-sm-offset-3"
								style="padding-right: 0rem;">
								<label class="checkbox-pretty inline checked"> <input
									type="checkbox" ><span
									style="font-size: 12px; color: #878787;">同意<a>《健康购会员章程》</a>
										<a>《支付宝协议》</a> 及 <a>《健康购广告联盟在线协议》</a></span>
								</label>
							</div>
						</form>
					</div>
					<div class="am-g" style="margin-top: 11px;">
						<div class="am-u-sm-7 am-u-sm-offset-3 ">
							<button id="register" type="button" class="am-btn am-btn-warning"
								style="width: 528px; padding: 20px; border: 1px rgba(187, 187, 187, 0.5) solid;">
								<font style="font-size: 20px; font-weight: bold;">同意协议并注册</font>
							</button>
						</div>
					</div>


				</div>
				<!--成功-->
				<div data-tab-panel-2 class="am-tab-panel ">
					<!--<div class="am-g"> <div class="am-u-sm-12" style="text-align: center;"> <img src="img/lion.png" /> </div> </div>-->
					<div class="am-g" style="margin-top: 90px;">
						<div class="am-u-sm-6 am-u-sm-offset-3 "
							style="text-align: center;">
							<h2 style="color: #8F8F8F; font-size: 20px;"><span id="zctx">恭喜您，152******64账号注册成功</span></h2>
							<br>
							<h2 style="color: #8F8F8F; font-size: 20px;"><a href="http://localhost:8881">首页&nbsp;&nbsp;</a><a href="login.html">登录</a></h2>
						</div>
					</div>

					<div class="am-g" style="margin-top: 176px; margin-bottom: 124px;">
						<div class="am-u-sm-6 am-u-sm-offset-3 ">
							<button type="button" class="am-btn am-btn-warning"
								style="width: 100%; height: 62px; font-size: 20px; font-weight: bold; border: 1px rgba(187, 187, 187, 0.5) B solid;">完成</button>
						</div>
					</div>
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
				<p style="font-size: 12px; float: left;">
					© &nbsp;2005-2016 健康购网 版权所有 ，并保留所有权利 <span
						style="margin-left: 30px;">健康购 Tel ：4008125181 </span><span
						style="margin-left: 30px;">E-mai：maila@163.com</span>
				</p>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="/js/registercheck.js"></script>
</body>

</html>