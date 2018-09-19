// JavaScript Document

/*改变所购商品的数量*/
/* numId表示对应商品数量的文本框ID，
 * flag表示是增加还是减少商品数量，
 * cartitemid 购物项ID */
function changeNum(numId, flag, cartitemid) {

	var numId = document.getElementById(numId);
	if (flag == "minus") {/* 减少商品数量 */
		if (numId.value <= 1) {
			alert("宝贝数量必须是大于0");
			return false;
		} else {
			$.ajax({
				url : '/shop/changeItemNum/minus/' + cartitemid,
				type : 'get',
				success : function(data) {
					if (data.status == 200) {
						numId.value = parseInt(numId.value) - 1;
						productCount();
					} else {
						alert(data.msg);
					}
				},
			});

		}
	} else {/* flag为add，增加商品数量 */
		$.ajax({
			url : '/shop/changeItemNum/add/' + cartitemid,
			type : 'get',
			success : function(data) {
				if (data.status == 200) {
					numId.value = parseInt(numId.value) + 1;
					productCount();
				} else {
					alert(data.msg);
				}
			},
		});

	}

}

/* 自动计算商品的总金额、总共节省的金额和积分 */
function productCount() {
	var total = 0; // 商品金额总计
	var integral = 0; // 可获商品积分

	var point; // 每一行商品的单品积分
	var price; // 每一行商品的单价
	var number; // 每一行商品的数量
	var subtotal; // 每一行商品的小计

	/* 访问ID为shopping表格中所有的行数 */
	var myTableTr = document.getElementById("shopping").getElementsByTagName(
			"tr");
	if (myTableTr.length > 0) {
		for (var i = 1; i < myTableTr.length; i++) {/* 从1开始，第一行的标题不计算 */
			if (myTableTr[i].getElementsByTagName("td").length > 2) { // 最后一行不计算
				point = myTableTr[i].getElementsByTagName("td")[3].innerHTML;
				price = myTableTr[i].getElementsByTagName("td")[4].innerHTML;
				number = myTableTr[i].getElementsByTagName("td")[5]
						.getElementsByTagName("input")[0].value;
				integral += point * number;
				total += price * number;
				myTableTr[i].getElementsByTagName("td")[6].innerHTML = returnFloat(price
						* number);
			}
		}
		document.getElementById("total").innerHTML = returnFloat(total);
		document.getElementById("integral").innerHTML = returnFloat(integral);

	}
}
window.onload = productCount;

/* 复选框全选或全不选效果 */
function selectAll() {
	var oInput = document.getElementsByName("cartCheckBox");
	for (var i = 0; i < oInput.length; i++) {
		oInput[i].checked = document.getElementById("allCheckBox").checked;
	}
}

/* 根据单个复选框的选择情况确定全选复选框是否被选中 */
function selectSingle() {
	var k = 0;
	var oInput = document.getElementsByName("cartCheckBox");
	for (var i = 0; i < oInput.length; i++) {
		if (oInput[i].checked == false) {
			k = 1;
			break;
		}
	}
	if (k == 0) {
		document.getElementById("allCheckBox").checked = true;
	} else {
		document.getElementById("allCheckBox").checked = false;
	}
}

/* 删除单行商品 */
function deleteRow(id) {

	$.ajax({
		url : '/shop/deleteCartItemById/' + id,
		type : 'get',
		success : function(data) {
			if (data.status == 200) {
				var Index = document.getElementById(id).rowIndex; // 获取当前行的索引号
				document.getElementById("shopping").deleteRow(Index);
				productCount();
			} else {
				alert(data.msg);
			}
		},
	});

}

/* 删除选中行的商品 */
function deleteSelectRow() {
	var oInput = document.getElementsByName("cartCheckBox");
	var Index;
	for (var i = oInput.length - 1; i >= 0; i--) {
		if (oInput[i].checked == true) {

			Index = document.getElementById(oInput[i].value).rowIndex; /* 获取选中行的索引号 */

			$.ajax({
				url : '/shop/deleteCartItemById/' + oInput[i].value,
				type : 'get',
				success : function(data) {
					if (data.status == 200) {
						document.getElementById("shopping").deleteRow(Index);
						productCount();
					} else {
						alert(data.msg);
						return;
					}
				},
			});
		}
	}

}

$(function() {

	$("#ordersubmit").click(function() {
		var oInput = document.getElementsByName("cartCheckBox");
		var flag = false;
		for (var i = oInput.length - 1; i >= 0; i--) {
			if (oInput[i].checked == true) {
				flag = true;
				break;
			}
		}
		if(!flag){
			alert("请先勾选购买的商品！");
		}
		if(flag){
			$.post("/shop/confirmorderinfo", $("#orderform").serialize(),
				function(data){
					if(data.status == 200){
						location.href = "http://localhost:8883/shop/showConfirmOder.html";
					}else {
						alert(data.msg);
					}
					
				}
			);
		}
	});
});

/* double 数字格式化 保留两位小数 */
function returnFloat(value) {
	var value = Math.round(parseFloat(value) * 100) / 100;
	var xsd = value.toString().split(".");
	if (xsd.length == 1) {
		value = value.toString() + ".00";
		return value;
	}
	if (xsd.length > 1) {
		if (xsd[1].length < 2) {
			value = value.toString() + "0";
		}
		return value;
	}
}
