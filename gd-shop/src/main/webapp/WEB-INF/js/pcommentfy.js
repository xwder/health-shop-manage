function commentfy(pid,page){
	$.ajax({
		url : '/comments',// 跳转到 action
		data : {
			pid : pid,
			page : page
		},
		type : 'post',
		datatype : "json",
		cache : false,
		success : function(data) {
			if (data.status == 200) {
				var fypagination = $("#fypagination");
				var commenttext = $("#commenttext");
				fypagination.html(data.data.fy);
				commenttext.html(data.data.html);
			} else {
				alert(data.msg);
			}
		},
	});
}