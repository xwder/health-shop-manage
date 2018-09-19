$(function(){
	showuserinfo();
})

function showuserinfo(){
	var _ticket = $.cookie("GD_TOKEN");
	if(!_ticket){
		return ;
	}
	$.ajax({
		url : "http://localhost:8884/user/token/" + _ticket,
		dataType : "jsonp",
		type : "GET",
		success : function(data){
			if(data.status == 200){
				var username = data.data.username;
				var showuserinfo = $("#showuserinfo");
				var html = "<a href='"+"http://localhost:8885/user/userindex.html"+"' class='login' target='_top'>"+username+"</a>"; 
				showuserinfo.html(html);
			}
		}
	});
}