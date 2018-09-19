$(document).ready(function() {
	var stock = $("#stock").val();
	var t = $("#text_box");
	$("#add").click(function() {
		if (t.val() == "") {
			t.val(0);
		}
		if (parseInt(t.val()) >= stock) {
			alert("商品数量不能大于库存数量！");
			$('#add').attr('disabled', true);
		}
		if (parseInt(t.val()) < stock) {
			t.val(parseInt(t.val()) + 1);
			$('#min').attr('disabled', false);

		}
	})
	$("#min").click(function() {
		if (t.val() == "") {
			t.val(1);
		}
		if (parseInt(t.val()) <= 1) {
			alert("商品数量必须大于1！");
			$('#min').attr('disabled', true);

		} else {
			t.val(parseInt(t.val()) - 1);
			$('#add').attr('disabled', false);
		}
	})
});