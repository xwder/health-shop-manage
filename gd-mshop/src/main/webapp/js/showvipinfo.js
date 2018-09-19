/**
 * 
 */
$("#viptable")
		.bootstrapTable(
				{
					idField : "id",
					uniqueId : "id",
					pagination : true,
					striped : true,
					search : true,
					showRefresh : true,
					cache : false,
					height : 500,
					pageNumber : 1,
					pageSize : 5,
					pageList : [ 5, 10, 15 ],
					url : "/vip/getvipinfo/" + $("#userId").text(),
					columns : [
							{
								field : "id",
								visible : false,
							},
							{
								field : "image",
								title : "头像",
								align : "center",
								valign : "middle",
								formatter : function(value) {
									return '<img src=\''
											+ value
											+ '\' height="30px" width="30px"><img>';
								}
							},
							{
								field : "name",
								title : "名字",
								align : "center",
								valign : "middle",
								cellStyle : function(value, row, index, field) {
									return {
										css : {
											"color" : "#2c87f0"
										}
									}
								},
							},
							{
								field : "sex",
								title : "性别",
								align : "center",
								valign : "middle",
								formatter : function(value) {
									if (value == "1")
										return "男"
									return "女"
								}

							},
							{
								field : "phone",
								title : "手机",
								align : "center",
								valign : "middle",

							},
							{
								field : "email",
								title : "邮箱",
								align : "center",
								valign : "middle",
							},
							{
								field : "operate",
								title : "操作",
								align : "center",
								valign : "middle",
								formatter : function operate(value, row, index) {
									return '<button type="button" class="btn btn-default btn-sm" onclick="healthinfo(\''
											+ row.id
											+ '\')"><span class="glyphicon glyphicon-align-justify"></span> 健康信息</button>&nbsp<button type="button" class="btn btn-default btn-sm" onclick="healthrequest(\''
											+ row.id
											+ '\')"><span class="glyphicon glyphicon-edit"></span> 健康请求</button>&nbsp<button type="button" class="btn btn-default btn-sm" onclick="addhealthplan(\''
											+ row.id
											+ '\')"><span class="glyphicon glyphicon-plus"></span> 健康计划</button>&nbsp<button type="button" class="btn btn-default btn-sm" onclick="messageremind(\''
											+ row.id
											+ '\')"><span class="glyphicon glyphicon-plus"></span> 消息提醒</button>&nbsp<button type="button" class="btn btn-default btn-sm" onclick="deletevip(\''
											+ row.id
											+ '\')"><span class="glyphicon glyphicon-remove"></span> 删除会员</button>'
								}
							} ],

				})
$("#food1table")
		.bootstrapTable(
				{
					idField : "id",
					uniqueId : "id",
					cache : false,
					pagination : false,
					striped : false,
					height : 205,
					columns : [
							{
								field : "id",
								visible : false,
							},
							{
								field : "foodname",
								title : "食物名称",
								align : "center",
								valign : "middle",
								cellStyle : function(value, row, index, field) {
									return {
										css : {
											"color" : "#2c87f0"
										}
									}
								},
							},
							{
								field : "foodquantity",
								title : "参考量(克)",
								align : "center",
								valign : "middle",
								cellStyle : function(value, row, index, field) {
									return {
										css : {
											"color" : "#2c87f0"
										}
									}
								},
							},
							{
								field : "type",
								title : "餐饮类别",
								align : "center",
								valign : "middle",
								cellStyle : function(value, row, index, field) {
									return {
										css : {
											"color" : "#2c87f0"
										}
									}
								},
							},
							{
								field : "operate",
								title : "操作",
								align : "center",
								valign : "middle",
								formatter : function operate(value, row, index) {
									var table = "#food1table";
									return '<button type="button" class="btn btn-default btn-sm" onclick="deletefood(\''+table+'\',\''
											+ row.id
											+ '\')"><span class="glyphicon glyphicon-remove"></span> 删除</button>'
								}
							} ],
				})
$("#food2table")
		.bootstrapTable(
				{
					idField : "id",
					uniqueId : "id",
					cache : false,
					pagination : false,
					striped : false,
					height : 205,
					columns : [
							{
								field : "id",
								visible : false,
							},
							{
								field : "foodname",
								title : "食物名称",
								align : "center",
								valign : "middle",
								cellStyle : function(value, row, index, field) {
									return {
										css : {
											"color" : "#2c87f0"
										}
									}
								},
							},
							{
								field : "foodquantity",
								title : "参考量(克)",
								align : "center",
								valign : "middle",
								cellStyle : function(value, row, index, field) {
									return {
										css : {
											"color" : "#2c87f0"
										}
									}
								},
							},
							{
								field : "type",
								title : "餐饮类别",
								align : "center",
								valign : "middle",
								cellStyle : function(value, row, index, field) {
									return {
										css : {
											"color" : "#2c87f0"
										}
									}
								},
							},
							{
								field : "operate",
								title : "操作",
								align : "center",
								valign : "middle",
								formatter : function operate(value, row, index) {
									var table = "#food2table";
									return '<button type="button" class="btn btn-default btn-sm" onclick="deletefood(\''+table+'\',\''
											+ row.id
											+ '\')"><span class="glyphicon glyphicon-remove"></span> 删除</button>'
								}
							} ],
				})
$("#food3table")
		.bootstrapTable(
				{
					idField : "id",
					uniqueId : "id",
					cache : false,
					pagination : false,
					striped : false,
					height : 205,
					columns : [
							{
								field : "id",
								visible : false,
							},
							{
								field : "foodname",
								title : "食物名称",
								align : "center",
								valign : "middle",
								cellStyle : function(value, row, index, field) {
									return {
										css : {
											"color" : "#2c87f0"
										}
									}
								},
							},
							{
								field : "foodquantity",
								title : "参考量(克)",
								align : "center",
								valign : "middle",
								cellStyle : function(value, row, index, field) {
									return {
										css : {
											"color" : "#2c87f0"
										}
									}
								},
							},
							{
								field : "type",
								title : "餐饮类别",
								align : "center",
								valign : "middle",
								cellStyle : function(value, row, index, field) {
									return {
										css : {
											"color" : "#2c87f0"
										}
									}
								},
							},
							{
								field : "operate",
								title : "操作",
								align : "center",
								valign : "middle",
								formatter : function operate(value, row, index) {
									var table = "#food3table";
									return '<button type="button" class="btn btn-default btn-sm" onclick="deletefood(\''+table+'\',\''
											+ row.id
											+ '\')"><span class="glyphicon glyphicon-remove"></span> 删除</button>'
								}
							} ],
				})
$("#food4table")
		.bootstrapTable(
				{
					idField : "id",
					uniqueId : "id",
					cache : false,
					pagination : false,
					striped : false,
					height : 205,
					columns : [
							{
								field : "id",
								visible : false,
							},
							{
								field : "foodname",
								title : "食物名称",
								align : "center",
								valign : "middle",
								cellStyle : function(value, row, index, field) {
									return {
										css : {
											"color" : "#2c87f0"
										}
									}
								},
							},
							{
								field : "foodquantity",
								title : "参考量(克)",
								align : "center",
								valign : "middle",
								cellStyle : function(value, row, index, field) {
									return {
										css : {
											"color" : "#2c87f0"
										}
									}
								},
							},
							{
								field : "type",
								title : "餐饮类别",
								align : "center",
								valign : "middle",
								cellStyle : function(value, row, index, field) {
									return {
										css : {
											"color" : "#2c87f0"
										}
									}
								},
							},
							{
								field : "operate",
								title : "操作",
								align : "center",
								valign : "middle",
								formatter : function operate(value, row, index) {
									var table = "#food4table";
									return '<button type="button" class="btn btn-default btn-sm" onclick="deletefood(\''+table+'\',\''
											+ row.id
											+ '\')"><span class="glyphicon glyphicon-remove"></span> 删除</button>'
								}
							} ],
				})
$("#food5table")
		.bootstrapTable(
				{
					idField : "id",
					uniqueId : "id",
					cache : false,
					pagination : false,
					striped : false,
					height : 205,
					columns : [
							{
								field : "id",
								visible : false,
							},
							{
								field : "foodname",
								title : "食物名称",
								align : "center",
								valign : "middle",
								cellStyle : function(value, row, index, field) {
									return {
										css : {
											"color" : "#2c87f0"
										}
									}
								},
							},
							{
								field : "foodquantity",
								title : "参考量(克)",
								align : "center",
								valign : "middle",
								cellStyle : function(value, row, index, field) {
									return {
										css : {
											"color" : "#2c87f0"
										}
									}
								},
							},
							{
								field : "type",
								title : "餐饮类别",
								align : "center",
								valign : "middle",
								cellStyle : function(value, row, index, field) {
									return {
										css : {
											"color" : "#2c87f0"
										}
									}
								},
							},
							{
								field : "operate",
								title : "操作",
								align : "center",
								valign : "middle",
								formatter : function operate(value, row, index) {
									var table = "#food5table";
									return '<button type="button" class="btn btn-default btn-sm" onclick="deletefood(\''+table+'\',\''
											+ row.id
											+ '\')"><span class="glyphicon glyphicon-remove"></span> 删除</button>'
								}
							} ],
				})
$("#food6table")
		.bootstrapTable(
				{
					idField : "id",
					uniqueId : "id",
					cache : false,
					pagination : false,
					striped : false,
					height : 205,
					columns : [
							{
								field : "id",
								visible : false,
							},
							{
								field : "foodname",
								title : "食物名称",
								align : "center",
								valign : "middle",
								cellStyle : function(value, row, index, field) {
									return {
										css : {
											"color" : "#2c87f0"
										}
									}
								},
							},
							{
								field : "foodquantity",
								title : "参考量(克)",
								align : "center",
								valign : "middle",
								cellStyle : function(value, row, index, field) {
									return {
										css : {
											"color" : "#2c87f0"
										}
									}
								},
							},
							{
								field : "type",
								title : "餐饮类别",
								align : "center",
								valign : "middle",
								cellStyle : function(value, row, index, field) {
									return {
										css : {
											"color" : "#2c87f0"
										}
									}
								},
							},
							{
								field : "operate",
								title : "操作",
								align : "center",
								valign : "middle",
								formatter : function operate(value, row, index) {
									var table = "#food6table";
									return '<button type="button" class="btn btn-default btn-sm" onclick="deletefood(\''+table+'\',\''
											+ row.id
											+ '\')"><span class="glyphicon glyphicon-remove"></span> 删除</button>'
								}
							} ],
				})
$("#food7table")
		.bootstrapTable(
				{
					idField : "id",
					uniqueId : "id",
					cache : false,
					pagination : false,
					striped : false,
					height : 205,
					columns : [
							{
								field : "id",
								visible : false,
							},
							{
								field : "foodname",
								title : "食物名称",
								align : "center",
								valign : "middle",
								cellStyle : function(value, row, index, field) {
									return {
										css : {
											"color" : "#2c87f0"
										}
									}
								},
							},
							{
								field : "foodquantity",
								title : "参考量(克)",
								align : "center",
								valign : "middle",
								cellStyle : function(value, row, index, field) {
									return {
										css : {
											"color" : "#2c87f0"
										}
									}
								},
							},
							{
								field : "type",
								title : "餐饮类别",
								align : "center",
								valign : "middle",
								cellStyle : function(value, row, index, field) {
									return {
										css : {
											"color" : "#2c87f0"
										}
									}
								},
							},
							{
								field : "operate",
								title : "操作",
								align : "center",
								valign : "middle",
								formatter : function operate(value, row, index) {
									var table = "#food7table";
									return '<button type="button" class="btn btn-default btn-sm" onclick="deletefood(\''+table+'\',\''
											+ row.id
											+ '\')"><span class="glyphicon glyphicon-remove"></span> 删除</button>'
								}
							} ],
				})
/* 获取会员健康信息 */
function healthinfo(id) {
	$.ajax({
		url : "/vip/getuserhealthinfo/" + id,
		async : false,
		success : function(data) {
			if (data.status == 200) {
				$("#showvipModal #username").val(data.data.username);
				$("#showvipModal #height").val(data.data.height + "cm");
				$("#showvipModal #weight").val(data.data.weight + "kg");
				$("#showvipModal #dietprefe").val(data.data.dietprefe);
				$("#showvipModal #notlikefoods").val(data.data.notlikefoods);
				$("#showvipModal #healstatus").val(data.data.healstatus);
				$("#showvipModal #medhis").val(data.data.medhis);
				$("#showvipModal #senfoods").val(data.data.senfoods);
				$("#showvipModal").modal();
			} else
				alert("查看失败!");
		}
	})
}
/* 删除会员 */
function deletevip(id) {
	isDel = window.confirm("确定删除该会员?");
	if (isDel == true) {
		$.ajax({
			url : "/vip/deletevip/" + id,
			async : false,
			success : function(data) {
				if (data.status == 200) {
					$("#viptable").bootstrapTable('removeByUniqueId',
							parseInt(id));
					alert(data.msg);
				} else
					alert(data.msg);
			}
		})
	}
}
/* 打开健康信息提醒框 */
function messageremind(id) {
	$("#messageModal #userid").val(id);
	$("#messageModal #message").val("");
	$("#messageModal").modal();
}
/* 保存健康信息提醒 */
function savemessage() {
	$.ajax({
		url : "/vip/addmessageremind",
		asnyc : false,
		type : "post",
		data : {
			uid : $("#messageModal #userid").val(),
			message : $("#messageModal #message").val(),
			nid : $("#userId").text(),
			messagetime : getcurrenttime(),
		},
		success : function(data) {
			$("#messageModal").modal('hide'), alert(data.msg);
		}
	})
}
/* 打开健康计划框 */
function addhealthplan(id) {
	/*
	 * var $table = $("#viptable");
	 * alert(JSON.stringify($table.bootstrapTable('getData')));
	 */
	$("#vipid").val(id);
	$("#food2").empty();
	$("#food2").append("<option>请选择</option>");
	$.ajax({
		url : "/food/getmaterial",
		asnyc : false,
		success : function(data) {
			if (data.status == 200) {
				for (var i = 0; i < data.data.length; i++) {
					var option = "<option value=" + data.data[i].id + ">"
							+ data.data[i].materialname + "</option>";
					$("#food2").append(option);
				}
			}
		}
	});
	$("#jkplanModal").modal();
}
/* 根据不同的类别显示不同的计划 */
/* 显示饮食计划 */
function showdietpian() {
	$("#diet").css({
		'background' : '#C0C0C0'
	});
	$("#sport").css({
		'background' : '#FFF'
	});
	$("#sportplan").hide();
	$("#dietplan").show();
}
/* 显示运动计划 */
function showsportplan() {
	$("#diet").css({
		'background' : '#FFF'
	});
	$("#sport").css({
		'background' : '#C0C0C0'
	});
	$("#dietplan").hide();
	$("#sportplan").show();
}
function showfoodday1() {
	$("#foodplanday1").css({
		'background' : '#C0C0C0'
	});
	$("#foodplanday2").css({
		'background' : '#FFF'
	});
	$("#foodplanday3").css({
		'background' : '#FFF'
	});
	$("#foodplanday4").css({
		'background' : '#FFF'
	});
	$("#foodplanday5").css({
		'background' : '#FFF'
	});
	$("#foodplanday6").css({
		'background' : '#FFF'
	});
	$("#foodplanday7").css({
		'background' : '#FFF'
	});
	$("#foodplan1").show();
	$("#foodplan2").hide();
	$("#foodplan3").hide();
	$("#foodplan4").hide();
	$("#foodplan5").hide();
	$("#foodplan6").hide();
	$("#foodplan7").hide();
	
	$("#savefoodplan").text("保存第一天饮食计划");

}
function showfoodday2() {
	$("#foodplanday1").css({
		'background' : '#FFF'
	});
	$("#foodplanday2").css({
		'background' : '#C0C0C0'
	});
	$("#foodplanday3").css({
		'background' : '#FFF'
	});
	$("#foodplanday4").css({
		'background' : '#FFF'
	});
	$("#foodplanday5").css({
		'background' : '#FFF'
	});
	$("#foodplanday6").css({
		'background' : '#FFF'
	});
	$("#foodplanday7").css({
		'background' : '#FFF'
	});
	$("#foodplan1").hide();
	$("#foodplan2").show();
	$("#foodplan3").hide();
	$("#foodplan4").hide();
	$("#foodplan5").hide();
	$("#foodplan6").hide();
	$("#foodplan7").hide();
	
	$("#savefoodplan").text("保存第二天饮食计划");
}
function showfoodday3() {
	$("#foodplanday1").css({
		'background' : '#FFF'
	});
	$("#foodplanday2").css({
		'background' : '#FFF'
	});
	$("#foodplanday3").css({
		'background' : '#C0C0C0'
	});
	$("#foodplanday4").css({
		'background' : '#FFF'
	});
	$("#foodplanday5").css({
		'background' : '#FFF'
	});
	$("#foodplanday6").css({
		'background' : '#FFF'
	});
	$("#foodplanday7").css({
		'background' : '#FFF'
	});
	$("#foodplan1").hide();
	$("#foodplan2").hide();
	$("#foodplan3").show();
	$("#foodplan4").hide();
	$("#foodplan5").hide();
	$("#foodplan6").hide();
	$("#foodplan7").hide();
	
	$("#savefoodplan").text("保存第三天饮食计划");
}
function showfoodday4() {
	$("#foodplanday1").css({
		'background' : '#FFF'
	});
	$("#foodplanday2").css({
		'background' : '#FFF'
	});
	$("#foodplanday3").css({
		'background' : '#FFF'
	});
	$("#foodplanday4").css({
		'background' : '#C0C0C0'
	});
	$("#foodplanday5").css({
		'background' : '#FFF'
	});
	$("#foodplanday6").css({
		'background' : '#FFF'
	});
	$("#foodplanday7").css({
		'background' : '#FFF'
	});
	$("#foodplan1").hide();
	$("#foodplan2").hide();
	$("#foodplan3").hide();
	$("#foodplan4").show();
	$("#foodplan5").hide();
	$("#foodplan6").hide();
	$("#foodplan7").hide();
	
	$("#savefoodplan").text("保存第四天饮食计划");
}
function showfoodday5() {
	$("#foodplanday1").css({
		'background' : '#FFF'
	});
	$("#foodplanday2").css({
		'background' : '#FFF'
	});
	$("#foodplanday3").css({
		'background' : '#FFF'
	});
	$("#foodplanday4").css({
		'background' : '#FFF'
	});
	$("#foodplanday5").css({
		'background' : '#C0C0C0'
	});
	$("#foodplanday6").css({
		'background' : '#FFF'
	});
	$("#foodplanday7").css({
		'background' : '#FFF'
	});
	$("#foodplan1").hide();
	$("#foodplan2").hide();
	$("#foodplan3").hide();
	$("#foodplan4").hide();
	$("#foodplan5").show();
	$("#foodplan6").hide();
	$("#foodplan7").hide();
	
	$("#savefoodplan").text("保存第五天饮食计划");
}
function showfoodday6() {
	$("#foodplanday1").css({
		'background' : '#FFF'
	});
	$("#foodplanday2").css({
		'background' : '#FFF'
	});
	$("#foodplanday3").css({
		'background' : '#FFF'
	});
	$("#foodplanday4").css({
		'background' : '#FFF'
	});
	$("#foodplanday5").css({
		'background' : '#FFF'
	});
	$("#foodplanday6").css({
		'background' : '#C0C0C0'
	});
	$("#foodplanday7").css({
		'background' : '#FFF'
	});
	$("#foodplan1").hide();
	$("#foodplan2").hide();
	$("#foodplan3").hide();
	$("#foodplan4").hide();
	$("#foodplan5").hide();
	$("#foodplan6").show();
	$("#foodplan7").hide();
	
	$("#savefoodplan").text("保存第六天饮食计划");
}
function showfoodday7() {
	$("#foodplanday1").css({
		'background' : '#FFF'
	});
	$("#foodplanday2").css({
		'background' : '#FFF'
	});
	$("#foodplanday3").css({
		'background' : '#FFF'
	});
	$("#foodplanday4").css({
		'background' : '#FFF'
	});
	$("#foodplanday5").css({
		'background' : '#FFF'
	});
	$("#foodplanday6").css({
		'background' : '#FFF'
	});
	$("#foodplanday7").css({
		'background' : '#C0C0C0'
	});
	$("#foodplan1").hide();
	$("#foodplan2").hide();
	$("#foodplan3").hide();
	$("#foodplan4").hide();
	$("#foodplan5").hide();
	$("#foodplan6").hide();
	$("#foodplan7").show();
	
	$("#savefoodplan").text("保存第七天饮食计划");
}
/* 删除已选择食物 */
function deletefood(table, id) {
	$(table).bootstrapTable('removeByUniqueId', parseInt(id));
	table = table + " .no-records-found td";
	$(table).html("暂无食物");
}
/*保存每一天的饮食计划*/
function saveeverydayfoodplan(){
	if (!$("#foodplan1").is(':hidden')){
		var $table = $("#food1table");
		$.ajax({
			url:"/food/addfoodplan",
		    async:false,
		    type:"post",
		    data:{
		    	userid:$("#vipid").val(),
		    	nutritionistid:$("#userId").text(),
		    	plandate:$("#foodplandate").val(),
		    	food:JSON.stringify($table.bootstrapTable('getData')),		    	
		    }
		})
	}
}
/* 获取当前时间 */
function getcurrenttime() {
	var date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	var day = date.getDate();
	var hour = date.getHours();
	var minute = date.getMinutes();
	var second = date.getSeconds();
	if (month < 10)
		month = "0" + month;
	if (day < 10)
		day = "0" + day;
	if (hour < 10)
		hour = "0" + hour;
	if (minute < 10)
		minute = "0" + minute;
	if (second < 10)
		second = "0" + second;
	var currentDate = year + "-" + month + "-" + day + " " + hour + ":"
			+ minute + ":" + second;
	return currentDate;
}
/* 初始化函数 */
$(function() {
	/* 隐藏所有计划 */
	$("#diet").css({
		'background' : '#FFF'
	});
	$("#sport").css({
		'background' : '#FFF'
	});
	$("#dietplan").hide();
	$("#sportplan").hide();
	/* 隐藏每一天的饮食计划 */
	/* 默认显示第一天的饮食计划 */
	$("#foodplan1").show();
	$("#foodplan2").hide();
	$("#foodplan3").hide();
	$("#foodplan4").hide();
	$("#foodplan5").hide();
	$("#foodplan6").hide();
	$("#foodplan7").hide();
	/* 为每一天的饮食计划的button添加css样式 */
	$("#foodplanday1").css({
		'background' : '#C0C0C0'
	});
	$("#foodplanday2").css({
		'background' : '#FFF'
	});
	$("#foodplanday3").css({
		'background' : '#FFF'
	});
	$("#foodplanday4").css({
		'background' : '#FFF'
	});
	$("#foodplanday5").css({
		'background' : '#FFF'
	});
	$("#foodplanday6").css({
		'background' : '#FFF'
	});
	$("#foodplanday7").css({
		'background' : '#FFF'
	});

	/* 当没有食物被选中的时候bootstrapTable中显示的文字信息 */
	$("#food1table .no-records-found td").html("第一天的饮食计划中暂无食物");
	$("#food2table .no-records-found td").html("第二天的饮食计划中暂无食物");
	$("#food3table .no-records-found td").html("第三天的饮食计划中暂无食物");
	$("#food4table .no-records-found td").html("第四天的饮食计划中暂无食物");
	$("#food5table .no-records-found td").html("第五天的饮食计划中暂无食物");
	$("#food6table .no-records-found td").html("第六天的饮食计划中暂无食物");
	$("#food7table .no-records-found td").html("第七天的饮食计划中暂无食物");
	
	/*为保存按钮赋初值*/
	$("#savefoodplan").text("保存第一天饮食计划");

	/* 初始化时间插件 */
	$('.form_date').datetimepicker({
		language : 'zh-CN',
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		minView : 2,
		forceParse : 0,
		format : 'yyyy-mm-dd',
	});

	$("#food2").click(
			function() {
				if ($("#food2").find("option:selected").text() != "请选择") {
					$("#food3").empty();
					$("#food3").append("<option>请选择</option>");
					$.ajax({
						url : "/food/getfoods/"
								+ $("#food2").find("option:selected").val(),
						async : false,
						success : function(data) {
							if (data.status == 200) {
								for (var i = 0; i < data.data.length; i++) {
									var option = "<option value="
											+ data.data[i].id + ">"
											+ data.data[i].foodname
											+ "</option>";
									$("#food3").append(option);
								}
							}
						}
					})
				}
			})
	$("#food3")
			.change(
					function() {
						if ($("#food3").find("option:selected").text() != "请选择") {

							$
									.ajax({
										url : "/food/getfood/"
												+ $("#food3").find(
														"option:selected")
														.val(),
										async : false,
										success : function(data) {
											if (data.status == 200) {
												// $("#food4").val(data.data.foodquantity);
												if (!$("#foodplan1").is(
														':hidden')) {
													$("#food1table")
															.bootstrapTable(
																	'prepend',
																	{
																		id : $(
																				"#food3")
																				.find(
																						"option:selected")
																				.val(),
																		foodquantity : data.data.foodquantity,
																		foodname : $(
																				"#food3")
																				.find(
																						"option:selected")
																				.text(),
																		type : $(
																				"#food1")
																				.find(
																						"option:selected")
																				.text(),
																	});
												}
												if (!$("#foodplan2").is(
														':hidden')) {
													$("#food2table")
															.bootstrapTable(
																	'prepend',
																	{
																		id : $(
																				"#food3")
																				.find(
																						"option:selected")
																				.val(),
																		foodquantity : data.data.foodquantity,
																		foodname : $(
																				"#food3")
																				.find(
																						"option:selected")
																				.text(),
																		type : $(
																				"#food1")
																				.find(
																						"option:selected")
																				.text(),
																	});
												}
												if (!$("#foodplan3").is(
														':hidden')) {
													$("#food3table")
															.bootstrapTable(
																	'prepend',
																	{
																		id : $(
																				"#food3")
																				.find(
																						"option:selected")
																				.val(),
																		foodquantity : data.data.foodquantity,
																		foodname : $(
																				"#food3")
																				.find(
																						"option:selected")
																				.text(),
																		type : $(
																				"#food1")
																				.find(
																						"option:selected")
																				.text(),
																	});
												}
												if (!$("#foodplan4").is(
														':hidden')) {
													$("#food4table")
															.bootstrapTable(
																	'prepend',
																	{
																		id : $(
																				"#food3")
																				.find(
																						"option:selected")
																				.val(),
																		foodquantity : data.data.foodquantity,
																		foodname : $(
																				"#food3")
																				.find(
																						"option:selected")
																				.text(),
																		type : $(
																				"#food1")
																				.find(
																						"option:selected")
																				.text(),
																	});
												}
												if (!$("#foodplan5").is(
														':hidden')) {
													$("#food5table")
															.bootstrapTable(
																	'prepend',
																	{
																		id : $(
																				"#food3")
																				.find(
																						"option:selected")
																				.val(),
																		foodquantity : data.data.foodquantity,
																		foodname : $(
																				"#food3")
																				.find(
																						"option:selected")
																				.text(),
																		type : $(
																				"#food1")
																				.find(
																						"option:selected")
																				.text(),
																	});
												}
												if (!$("#foodplan6").is(
														':hidden')) {
													$("#food6table")
															.bootstrapTable(
																	'prepend',
																	{
																		id : $(
																				"#food3")
																				.find(
																						"option:selected")
																				.val(),
																		foodquantity : data.data.foodquantity,
																		foodname : $(
																				"#food3")
																				.find(
																						"option:selected")
																				.text(),
																		type : $(
																				"#food1")
																				.find(
																						"option:selected")
																				.text(),
																	});
												}
												if (!$("#foodplan7").is(
														':hidden')) {
													$("#food7table")
															.bootstrapTable(
																	'prepend',
																	{
																		id : $(
																				"#food3")
																				.find(
																						"option:selected")
																				.val(),
																		foodquantity : data.data.foodquantity,
																		foodname : $(
																				"#food3")
																				.find(
																						"option:selected")
																				.text(),
																		type : $(
																				"#food1")
																				.find(
																						"option:selected")
																				.text(),
																	});
												}
											}
										}
									})
						}
					})
})