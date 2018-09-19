<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="user">
		<div id="member">
			<div id="member_bd">
				<a id="userurl" href="" class="touxiang"> <img
					id="showuserimage" src="./images/tx.jpg" alt="" class="tx">
				</a>
			</div>
			
				<div id="member_username"><a id="userurl" href="">用户名</a></div>
			
			<div id="memopt">
				<ul>
					<li><a href="http://localhost:8884/page/login.html">登录</a></li>
					<li><a href="http://localhost:8884/page/register.html">注册</a></li>
					<li><a href="http://localhost:8884/page/login.html?redirect=http://localhost:8885/user/app/storeapp.html">开店</a></li>
				</ul>
			</div>
			<div id="member_clo">
				<table>
					<tr>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
					</tr>
					<tr>
						<td>待付款</td>
						<td>待发货</td>
						<td>待收货</td>
						<td>待评价</td>
					</tr>
				</table>
			</div>
			<div id="mem_gonggao">
				<ul>
					<li><a href="">公告</a></li>
					<li><a href="">规则</a></li>
					<li><a href="">安全</a></li>
					<li><a href="">论坛</a></li>
					<li><a href="">公益</a></li>
				</ul>
			</div>
			<div id="gg_info">
				<table>
					<tr>
						<td>双十二开始报名啦</td>
						<td>双十二开始报名啦</td>
					</tr>
					<tr>
						<td>双十二开始报名啦</td>
						<td>双十二开始报名啦</td>
					</tr>
				</table>
			</div>
			<div id="member_ft">
				<div class="yypc">营养配餐</div>
				<div id="pc">
					<table>
						<tr>
							<td>年龄:</td>
							<td><input type="text" name="pcage" class="pctext">
							</td>
							<td>身高:</td>
							<td><input type="text" name="pcheight" class="pctext"></td>
						</tr>
						<tr>
							<td>体重:</td>
							<td><input type="text" name="pcweghit" class="pctext"></td>
							<td>性别:</td>
							<td><input type="text" name="pcsex" class="pctext"></td>
						</tr>
					</table>
				</div>
				<div class="yypc">
					<a href="">配餐</a>
				</div>
				<div id="pcjg">
					<table>
						<tr>
							<td class="pcjg_name">谷类:</td>
							<td class="pcjg_jg">300-500克</td>
						</tr>
						<tr>
							<td class="pcjg_name">蔬菜和水果:</td>
							<td>500克左右(两类各半)</td>
						</tr>
						<tr>
							<td class="pcjg_name">鱼禽肉蛋:</td>
							<td class="pcjg_jg">150克左右</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>