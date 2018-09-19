/*var GD = GRDDES = {
	checkLogin : function() {
		var _ticket = $.cookie("GD_TOKEN");
		if (!_ticket) {
			alert("请先登录11111！")
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
}*/
$(function() {
	 
	var stock = $("#stock").val();
	var itemid = $("#itemid").val();
	var pname = $("#pname").val();
	var storeid = $("#storeid").val();
	var pprice = $("#pprice").val();
	var ppic = $("#ppic").val();
	

	$("#buyNow").click(function() {
		// 拦截登录
		if (!GD.checkLogin()) {
			return;
		}
		
		if(parseInt(itemnum) > parseInt(stock)){
			alert("商品数量不能大于库存！")
			return;
		}
		var itemnum = $("#text_box").val();
	    // 取得要提交页面的URL  
	    var action =   '/shop/buynow.html';
	    // 创建Form  
	    var form = $('<form></form>');  
	    $(document.body).append(form);
	    // 设置属性  
	    form.attr('action', action);  
	    form.attr('method', 'post');  
	    // form的target属性决定form在哪个页面提交  
	    // _self -> 当前页面 _blank -> 新页面  
	    form.attr('target', '_self');  
	    // 创建Input  
	    var itemnum_input = $('<input type="text" name="itemnum" />');  
	    itemnum_input.attr('value', itemnum);  
	    var itemid_input = $('<input type="text" name="itemid" />');  
	    itemid_input.attr('value', itemid);  
	    var pname_input = $('<input type="text" name="pname" />');  
	    pname_input.attr('value', pname);  
	    var storeid_input = $('<input type="text" name="storeid" />');  
	    storeid_input.attr('value', storeid);  
	    var ppic_input = $('<input type="text" name="ppic" />');  
	    ppic_input.attr('value', ppic);  
	    var pprice_input = $('<input type="text" name="pprice" />');  
	    pprice_input.attr('value', pprice);  
	    // 附加到Form  
	    form.append(itemnum_input);  
	    form.append(itemid_input);  
	    form.append(pname_input);  
	    form.append(storeid_input);  
	    form.append(ppic_input);  
	    form.append(pprice_input);  
	    // 提交表单  
	    form.submit();  
	    // 注意return false取消链接的默认动作  
	    return false;  
 

	});
})
