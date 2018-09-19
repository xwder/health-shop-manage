function changeDefaultAddress(addressid) {
	$.ajax({
		url : '/shop/changeDefaultAddress/' + addressid,
		type : 'get',
		success : function(data) {
			if (data.status == 200) {
				window.location.reload();
			} else {
				alert(data.msg);
			}
		},
	});
}

function createOrder() {
	if (confirm()) {
		$("#addrForm").submit();
	}
}

function confirm() {
	var r = $('input:radio:checked').val();
	if (!r) {
		alert("请选择收货地址！");
		return false;
	}
	return true;
}

$(function() {
	$("input[name=addressradio]").click(function() {
		var addressid = this.id;
		$.ajax({
			url : '/shop/getAddressByid/' + addressid,
			type : 'get',
			success : function(data) {
				if (data.status == 200) {
					var html = "<li><em>寄送至:</em><span id='J_AddrConfirm' style='word-break: break-all;'>"
							+ data.data.province
							+ data.data.detailaddr
							+ "</span></li> <li><em>收货人:</em><span id='J_AddrNameConfirm'>"
							+ data.data.receiptname
							+ data.data.receipphone
							+ "</span></li>"
							+ "<input type='hidden' name='userPhone' value='"+data.data.receipphone+"'/>"
							+ "<input type='hidden' name='userName' value='"+data.data.receiptname+"'/>"
							+ "<input type='hidden' name='userAddr' value='"+data.data.detailaddr+"'/>";
							
					
					$("#orderaddress").html(html);

				} else {
					alert(data.msg);
				}
			},
		});
	});
});