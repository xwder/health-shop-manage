var JK = {
	showInfo : function() {
		var _ticket = $.cookie("ADMIN_TOKEN");
		if (!_ticket) {
			alert(_ticket);
			location.href = "http://localhost:8884/page/managerlogin.html";
			return;
		}
		$.ajax({
			url : "http://localhost:8884/user/token/" + _ticket,
			dataType : "jsonp",
			type : "GET",
			success : function(data) {
				if (data.status == 200 && data.data.isstore ==1) {
					$("#username").html(data.data.useranme);
				}else{
					alert("请登录！")
					location.href = "http://localhost:8884/page/managerlogin.html";
				}
			}
		});
	} 
}
function logout(){
	var _ticket = $.cookie("ADMIN_TOKEN");
	if(!_ticket){
		return ;
	}
	$.ajax({
		url : "http://localhost:8884/user/logout/" + _ticket,
		dataType : "jsonp",
		type : "GET",
		success : function(data){
			if(data.status == 200){
				location.href = "http://localhost:8884/page/managerlogin.html";
			}
		}
	});
	
}

function showoptions(){
	$("#showloginout").css("display","block");
}
function closeoptions(){
	$("#showloginout").css("display","none");
}


function showChoose(){
	$("#showchoose").hover(function(){
		alert(1);
	},function(){
		
	});
}
$(function() {
	// 查看是否已经登录，如果已经登录查询登录信息
	JK.showInfo();
});