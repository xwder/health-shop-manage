function confirm() {
	if($("#province").val().length == 0){
		alert("请输入所在地区!");
		$("#province").focus();
		return false;
	}else if($("#detailaddr").val().length == 0){
		alert("请输入详细地址!");
		$("#detailaddr").focus();
		return false;
	}else if($("#zipcode").val().length == 0){
		alert("请输入邮编!");
		$("#zipcode").focus();
		return false;
	}else if($("#receiptname").val().length == 0){
		alert("请输入收货人姓名!");
		$("#receiptname").focus();
		return false;
	}else if($("#receipphone").val().length == 0){
		alert("请输入收货人电话!");
		$("#receipphone").focus();
		return false;
	}else{
		return true;
	}
		
}
