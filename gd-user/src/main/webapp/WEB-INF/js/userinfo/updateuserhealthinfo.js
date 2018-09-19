function updateUserHealthinfo(){
	if($("#username").val().length == 0){
		alert("请您的姓名！");
		$("#username").focus();
		return ;
	}else if($("#height").val() <= 0){
		alert("请输入您的身高(cm)!");
		$("#height").focus();
		return ;
	}else if($("#weight").val() <= 0){
		alert("请输入您的体重(KG)！");
		$("#weight").focus();
		return ;
	} if($("#birthday").val() <= 0){
		alert("请输入您的生日！");
		$("#birthday").focus();
		return ;
	} if($("#dietprefe").val().length == 0){
		alert("请输入您的饮食偏好！");
		$("#dietprefe").focus();
		return ;
	} if($("#notlikefoods").val().length == 0){
		alert("请输入您不喜欢的食物，没有请输入 无！");
		$("#notlikefoods").focus();
		return ;
	} if($("#senfoods").val().length == 0){
		alert("请输入您过敏的物品，没有请输入 无！");
		$("#senfoods").focus();
		return ;
	} if($("#medhis").val().length == 0){
		alert("请输入您病史，没有请输入 无！");
		$("#medhis").focus();
		return ;
	}else{
		$.post("/user/updateuserhealthinfo", $("#uhform").serialize(),
		function(data) {
			if (data.status == 200) {
				alert("修改成功！");
			} else {
				alert("修改失败！" + data.msg);
				$("#username").select();
			}
		});
	}
}

$(function(){
	$("#change").click(function(){
		updateUserHealthinfo();
	});
	
});