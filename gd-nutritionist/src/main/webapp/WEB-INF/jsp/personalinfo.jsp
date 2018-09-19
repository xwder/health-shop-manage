<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="/css/main.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="/css/bootstrap-table.min.css"
	type="text/css" media="screen">
<link rel="stylesheet" href="/css/bootstrap-datetimepicker.min.css"
	type="text/css" media="screen" />
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/jquery.cookie.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-table.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript" src="/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript"
	src="/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="/js/bootstrap-editable.js"></script>
<script type="text/javascript" src="/js/bootstrap-table-editable.js"></script>
<script type="text/javascript">
$.ajax({
	url:"/user/getuserinfo/"+$("#userId").text(),
	async:false,
	success:function(data){
	     if(data!=null){
	    	$(".table.table-bordered #username").html(1);
			$(".table.table-bordered #sex").html(data.sex==1?"男":"女");
			$(".table.table-bordered #phone").val(data.phone);
			$(".table.table-bordered #email").val(data.email);
			$(".table.table-bordered #shenfenzheng").html(data.uid);
			$(".table.table-bordered #license").html(data.dietlicense);
	     }										
	}
})
</script>
</head>
<body>
	<div class="route_bg">
		<a>个人信息管理</a>&nbsp;<i class="glyphicon glyphicon-chevron-right"></i><a>&nbsp;基本信息 (<font color="red">&lowast;</font>说明不可修改)</a>
	</div>
	<div style="margin-top:10px;">
		<table class="table table-bordered">			
			<tbody>
				<tr>
					<td><font color="red">&lowast;</font>用户名</td>
					<td id="username" width="400px;"></td>
					<td><font color="red">&lowast;</font>性别</td>
					<td id="sex" width="400px;"> </td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;手机号</td>
					<td style="padding: 0px; margin: 0px;"><input id="phone"
						type="text"
						style="width: 400px; height: 39px; border: 0px; margin: 0px;"></td>
					<td>&nbsp;&nbsp;&nbsp;邮箱</td>
					<td style="padding: 0px; margin: 0px;"><input id="email"
						type="text"
						style="width: 400px; height: 39px; border: 0px; margin: 0px;"></td>
				</tr>
				<tr>
					<td><font color="red">&lowast;</font>身份证号</td>
					<td id="shenfenzheng" width="400px;"></td>
					<td><font color="red">&lowast;</font>证书编号</td>
					<td id="license" width="400px;"></td>				
				</tr>
				<tr>
				    <td colspan="4" align="center">
				    <button class="btn btn-primary" onclick="saveinfo();">保存修改</button>&nbsp;&nbsp;<button class="btn btn-primary" onclick="changepw();">修改密码</button>
				    </td>
				</tr>
			</tbody>
		</table>			
	</div>
	
	<!-- 修改密码模态框  -->
	<div class="modal fade" id="changepwModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="height:100px;width:300px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">密码修改</h4>
				</div>
				<div class="modal-body">
					<div class="form-group" style="display: none">
						<input type="text" class="form-control" readonly id="userid">
					</div>
					<div class="form-group">
						<label for="name">原密码</label><input type="password"
							class="form-control" id="oldpw">
					</div>
					<div class="form-group">
						<label for="name">新密码</label><input type="password"
							class="form-control" id="newpw">
					</div>
					<div class="form-group">
						<label for="name">确认密码</label><input type="password"
							class="form-control" id="confirmpw">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" id="closeModal" class="btn btn-default"
						data-dismiss="modal">关闭</button>
					<button type="button" id="submitInfor" class="btn btn-primary"
						onclick="savepw()">保存密码</button>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
	function saveinfo(){
		if($("#phone").val()!=''&&$("#email").val()!=''){
			$.ajax({
				url:"/user/updateuserinfo",
				async:false,
				type:"post",
				data:{
					id:$("#userId").text(),
					phone:$("#phone").val(),
					email:$("#email").val(),
				},
				success:function(data){
					alert(data.msg);				
				}
			})
		}
		else
			alert("请填写正确的邮箱和手机号!");
	}
	function changepw(){
		$("#oldpw").val("");
		$("#newpw").val("");
		$("#newpw").attr("disabled",true);
		$("#confirmpw").val("");
		$("#confirmpw").attr("disabled",true);
		$("#changepwModal").modal();
	}
	function savepw(){
		if($("#oldpw").val()!='' && $("#newpw").val()!='' && $("#confirmpw").val()){
			$.ajax({
				url:"/user/changepw",
				async:false,
				type:"post",
				data:{
					id:$("#userId").text(),
					oldpw:$("#oldpw").val(),
					newpw:$("#newpw").val(),
				},
				success:function(data){
					alert(data.msg+"即将重新登陆!");
					if(data.status==200){
						loginout();
					}						
				}
			})
		}
		else
			alert("请完整填写!");
	}
	$("#oldpw").blur(function(){
		if($("#oldpw").val()!='')
			$("#newpw").attr("disabled",false);
		else
			$("#newpw").attr("disabled",true);
	})
	$("#newpw").blur(function(){
		if($("#newpw").val()!='')
			$("#confirmpw").attr("disabled",false);
		else
			$("#confirmpw").attr("disabled",true);
	})
	$("#confirmpw").blur(function(){
		if($("#newpw").val()!=$("#confirmpw").val())
			alert("两次输入密码不一样!");
	})
	</script>
</body>
</html>