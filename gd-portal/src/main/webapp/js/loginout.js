function loginout() {
	var _ticket = $.cookie("GD_TOKEN");
	if (!_ticket) {
		return;
	}
	$.ajax({
		url : "http://localhost:8884/user/logout/" + _ticket,
		dataType : "jsonp",
		type : "GET",
		success : function(data) {
			if (data.status == 200) {
				location.href = "http://localhost:8884/page/login.html";
			}
		}
	});
}