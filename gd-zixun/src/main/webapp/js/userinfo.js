var TT = TAOTAO = {
	checkLogin : function(){
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
					var imageurl = data.data.image;
					$("#loginshow").hide();
					$("#registershow").hide();
					$("#memopt").hide();
					$("#head_right").show();
					var html ="<a href=\"http://localhost:8881"+"\">"+"健康购&nbsp;&nbsp;&nbsp;"+"</a>"+"欢迎 "+ "<a href=\"http://localhost:8885/user/userindex.html"+"\">"+data.data.username+"</a>";
					$("#showusername").html(html);
					$("#member_username").html(username);
					$("#showuserimage").attr('src',imageurl); 
					var url = "http://localhost:8885/user/userindex.html";
					$("#grzx").attr('href',url);
					$("#showuserindex").attr("href","http://localhost:8885/user/userindex.html");
					
				}
			}
		});
	},

}

function logout(){
	var _ticket = $.cookie("GD_TOKEN");
	if(!_ticket){
		return ;
	}
	$.ajax({
		url : "http://localhost:8884/user/logout/" + _ticket,
		dataType : "jsonp",
		type : "GET",
		success : function(data){
			if(data.status == 200){
				location.href = "http://localhost:8881";
			}
		}
	});
	
}

$(function(){
	// 查看是否已经登录，如果已经登录查询登录信息
	TT.checkLogin();
});