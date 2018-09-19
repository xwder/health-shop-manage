var GD = GRDDES = {
	checkLogin : function() {
		var _ticket = $.cookie("GD_TOKEN");
		if (!_ticket) {
			alert("请先登录！")
			var redirecturl = window.location.href;
			var url = "http://localhost:8884/page/login.html?redirect="
					+ redirecturl;
			location.href = url;
			return false;
			;
		}else{
			return true;
		}
	},
}
$(function() {
	 
	var stock = $("#stock").val();
	var itemid = $("#itemid").val();
	var pname = $("#pname").val();
	var storeid = $("#storeid").val();
	var pprice = $("#pprice").val();
	var ppic = $("#ppic").val();

	$("#addToCart").click(function() {
		// 拦截登录
		if (!GD.checkLogin()) {
			return;
		}
		var itemnum = $("#text_box").val();
		if(parseInt(itemnum) > parseInt(stock)){
			alert("商品数量不能大于库存！")
			return;
		}
		$.ajax({
			url : '/shop/addcart',// 跳转到 action
			data : {
				itemnum : itemnum,
				itemid : itemid,
				pname : pname,
				storeid : storeid,
				ppic : ppic,
				pprice : pprice
			},
			type : 'post',
			datatype : "json",
			cache : false,
			success : function(data) {
				if (data.status == 200) {
					con=confirm("添加成功，前往购物车！"); //在页面上弹出对话框
					if(con==true){
						location.href = "http://localhost:8883/shop/cart.html";
					}

				} else {
					alert(data.msg);
				}
			},
		});

	});
})
