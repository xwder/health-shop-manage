var JK = {
	showInfo : function() {
		var _ticket = $.cookie("YYS_TOKEN");
		if (!_ticket) {
			location.href = "http://localhost:8884/page/managerlogin.html";
			return;
		}
		$.ajax({
			url : "http://localhost:8884/user/token/" + _ticket,
			dataType : "jsonp",
			type : "GET",
			success : function(data) {
				if (data.status == 200) {
					var username = data.data.username;
					var imageurl = data.data.image;
				}else{
					alert("请登录！")
					location.href = "http://localhost:8884/page/managerlogin.html";
				}
			}
		});
	} 
}
function logout(){
	var _ticket = $.cookie("YYS_TOKEN");
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
$(function() {
	// 查看是否已经登录，如果已经登录查询登录信息
	JK.showInfo();
});