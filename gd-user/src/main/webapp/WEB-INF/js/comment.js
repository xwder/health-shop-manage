/*
 * 根据index获取 str
 * **/
var commentlevel =0;
function byIndexLeve(index) {
	var str = "";
	switch (index) {
	case 0:
		str = "差评";
		break;
	case 1:
		str = "较差";
		break;
	case 2:
		str = "中等";
		break;
	case 3:
		str = "一般";
		break;
	case 4:
		str = "好评";
		break;
	}
	return str;
}
// 星星数量
var stars = [ [ 'x2.png', 'x1.png', 'x1.png', 'x1.png', 'x1.png' ],
		[ 'x2.png', 'x2.png', 'x1.png', 'x1.png', 'x1.png' ],
		[ 'x2.png', 'x2.png', 'x2.png', 'x1.png', 'x1.png' ],
		[ 'x2.png', 'x2.png', 'x2.png', 'x2.png', 'x1.png' ],
		[ 'x2.png', 'x2.png', 'x2.png', 'x2.png', 'x2.png' ], ];

$(".block li").find("img")
		.hover(
				function(e) {
					var obj = $(this);
					var index = obj.index();
					if (index < (parseInt($(".block li").attr(
							"data-default-index")) - 1)) {
						return;
					}
					var li = obj.closest("li");
					var star_area_index = li.index();
					for (var i = 0; i < 5; i++) {
						li.find("img").eq(i).attr(
								"src",
								"/images/"
										+ stars[index][i]);// 切换每个星星
					}
					$(".level").html(byIndexLeve(index));
				}, function() {
				})

$(".block li")
		.hover(
				function(e) {
				},
				function() {
					var index = $(this).attr("data-default-index");// 点击后的索引
					index = parseInt(index);
					console.log("index", index);
					commentlevel = index;
					$(".level").html(byIndexLeve(index - 1));
					console.log(byIndexLeve(index - 1));
					$(".order-evaluation ul li:eq(0)").find("img").attr("src",
							"/images/x1.png");
					for (var i = 0; i < index; i++) {

						$(".order-evaluation ul li:eq(0)")
								.find("img")
								.eq(i)
								.attr("src",
										"/images/x2.png");
					}
				})
$(".block li")
		.find("img")
		.click(
				function() {
					var obj = $(this);
					var li = obj.closest("li");
					var star_area_index = li.index();
					var index1 = obj.index();
					li.attr("data-default-index", (parseInt(index1) + 1));
					var index = $(".block li").attr("data-default-index");// 点击后的索引
					index = parseInt(index);
					commentlevel = index;
					console.log("index", index);
					$(".level").html(byIndexLeve(index - 1));
					console.log(byIndexLeve(index - 1));
					$(".order-evaluation ul li:eq(0)").find("img").attr("src",
							"/images/x1.png");
					for (var i = 0; i < index; i++) {
						$(".order-evaluation ul li:eq(0)")
								.find("img")
								.eq(i)
								.attr("src",
										"/images/x2.png");
					}

				});

// 评价字数限制
function words_deal() {
	var curLength = $("#TextArea1").val().length;
	if (curLength > 140) {
		var num = $("#TextArea1").val().substr(0, 140);
		$("#TextArea1").val(num);
		alert("超过字数限制，多出的字将被截断！");
	} else {
		$("#textCount").text(140 - $("#TextArea1").val().length);
	}
}
$("#order_evaluation").click(
		function() {
			if(check_comment_input()){
				var commentcontent = $("#TextArea1").val();
				var pid = $("#pid").val();
				var orderitemid = $("#orderitemid").val();
				var orderid = $("#orderid").val();
				$.ajax({
					url : '/user/addcomment',// 跳转到 action
					data : {
						commentlevel : commentlevel, 
						pid : pid, 
						orderitemid : orderitemid, 
						orderid : orderid, 
						commentcontent : commentcontent
					},
					type : 'post',
					datatype : "json",
					cache : false,
					success : function(data) {
						if (data.status == 200) {
							$("#order_evaluate_modal").html("感谢您的评价！么么哒(* ￣3)(ε￣ *)").show()
							.delay(3000).hide(500);
							location.href = "http://localhost:8885/user/itemcomment.html?itemid="+orderitemid;
						} else {
							alert(data.msg);
						}
					},
				});

				
			}
			
		})
function check_comment_input(){
	if(commentlevel == 0){
		$("#order_evaluate_modal").html("请点击星星评价哦！么么哒(* ￣3)(ε￣ *)").show()
		.delay(3000).hide(500);
		return;
	}
	if($("#TextArea1").val().length<=0){
		$("#order_evaluate_modal").html("评论内容不能为空哦！么么哒(* ￣3)(ε￣ *)").show()
		.delay(3000).hide(500);
		return false;
	}else{
		return true;
	}
}
