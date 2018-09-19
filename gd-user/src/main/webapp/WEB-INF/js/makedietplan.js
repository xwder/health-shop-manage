/**
 * 
 */
var dateArray = new Array();
var dietflag = 0;
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
								editable : {
									type : 'text',
									title : '参考用量',
									validate : function(v) {
										if (isNaN(v))
											return '请输入正确的数值!';
									},
								}
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
									return '<button type="button" class="btn btn-default btn-sm" onclick="deletefood(\''
											+ table
											+ '\',\''
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
								editable : {
									type : 'text',
									title : '参考用量',
									validate : function(v) {
										if (isNaN(v))
											return '请输入正确的数值!';
									},
								}
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
									return '<button type="button" class="btn btn-default btn-sm" onclick="deletefood(\''
											+ table
											+ '\',\''
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
								editable : {
									type : 'text',
									title : '参考用量',
									validate : function(v) {
										if (isNaN(v))
											return '请输入正确的数值!';
									},
								}
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
									return '<button type="button" class="btn btn-default btn-sm" onclick="deletefood(\''
											+ table
											+ '\',\''
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
								editable : {
									type : 'text',
									title : '参考用量',
									validate : function(v) {
										if (isNaN(v))
											return '请输入正确的数值!';
									},
								}
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
									return '<button type="button" class="btn btn-default btn-sm" onclick="deletefood(\''
											+ table
											+ '\',\''
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
								editable : {
									type : 'text',
									title : '参考用量',
									validate : function(v) {
										if (isNaN(v))
											return '请输入正确的数值!';
									},
								}
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
									return '<button type="button" class="btn btn-default btn-sm" onclick="deletefood(\''
											+ table
											+ '\',\''
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
								editable : {
									type : 'text',
									title : '参考用量',
									validate : function(v) {
										if (isNaN(v))
											return '请输入正确的数值!';
									},
								}
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
									return '<button type="button" class="btn btn-default btn-sm" onclick="deletefood(\''
											+ table
											+ '\',\''
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
								editable : {
									type : 'text',
									title : '参考用量',
									validate : function(v) {
										if (isNaN(v))
											return '请输入正确的数值!';
									},
								}
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
									return '<button type="button" class="btn btn-default btn-sm" onclick="deletefood(\''
											+ table
											+ '\',\''
											+ row.id
											+ '\')"><span class="glyphicon glyphicon-remove"></span> 删除</button>'
								}
							} ],
				})

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

	$("#foodplandate").val(dateArray[0]);
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
	
	$("#foodplandate").val(dateArray[1]);

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

	$("#foodplandate").val(dateArray[2]);
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

	$("#foodplandate").val(dateArray[3]);

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

	$("#foodplandate").val(dateArray[4]);

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

	$("#foodplandate").val(dateArray[5]);

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

	$("#foodplandate").val(dateArray[6]);

	$("#savefoodplan").text("保存第七天饮食计划");
}
/* 删除已选择食物 */
function deletefood(table, id) {
	$(table).bootstrapTable('removeByUniqueId', parseInt(id));
	table = table + " .no-records-found td";
	$(table).html("暂无食物");
}
/* 保存每一天的饮食计划 */
function saveeverydayfoodplan() {
	if ($("#foodplandate").val() == null || $("#foodplandate").val() == '') {
		alert("饮食计划日期不能为空!");
	} else {
		if (!$("#foodplan1").is(':hidden')) {
			var $table = $("#food1table");
			if ($table.bootstrapTable('getData') == '') {
				alert("请选择食物!");
			} else {
				$
						.ajax({
							url : "/plan/addfoodplan",
							async : false,
							type : "post",
							data : {
								userid : $("#uid").val(),								
								plandate : $("#foodplandate").val(),
								food : JSON.stringify($table
										.bootstrapTable('getData')),
							},
							success : function(data) {
								alert(data.msg);
								if(data.status==200)
									$("#foodplanday2").attr("disabled", false);
							}
						})
			}
			if (dietflag == 0) {
				dateArray.push($("#foodplandate").val()), dateArray
						.push(checkdate($("#foodplandate").val(), 1)),
						dateArray.push(checkdate($("#foodplandate").val(), 2)),
						dateArray.push(checkdate($("#foodplandate").val(), 3)),
						dateArray.push(checkdate($("#foodplandate").val(), 4)),
						dateArray.push(checkdate($("#foodplandate").val(), 5)),
						dateArray.push(checkdate($("#foodplandate").val(), 6)),
						dietflag++;
			}
			
		}
		if (!$("#foodplan2").is(':hidden')) {
			var $table = $("#food2table");
			if ($table.bootstrapTable('getData') == '') {
				alert("请选择食物!");
			} else {
				$
						.ajax({
							url : "/plan/addfoodplan",
							async : false,
							type : "post",
							data : {
								userid : $("#uid").val(),								
								plandate : $("#foodplandate").val(),
								food : JSON.stringify($table
										.bootstrapTable('getData')),
							},
							success : function(data) {
								alert(data.msg);
								if(data.status==200)
									$("#foodplanday3").attr("disabled", false);
							}
						})
			}			
		}
		if (!$("#foodplan3").is(':hidden')) {
			var $table = $("#food3table");
			if ($table.bootstrapTable('getData') == '') {
				alert("请选择食物!");
			} else {
				$
						.ajax({
							url : "/plan/addfoodplan",
							async : false,
							type : "post",
							data : {
								userid : $("#uid").val(),								
								plandate : $("#foodplandate").val(),
								food : JSON.stringify($table
										.bootstrapTable('getData')),
							},
							success : function(data) {
								alert(data.msg);
								if(data.status==200)
									$("#foodplanday4").attr("disabled", false);
							}
						})
			}			
		}
		if (!$("#foodplan4").is(':hidden')) {
			var $table = $("#food4table");
			if ($table.bootstrapTable('getData') == '') {
				alert("请选择食物!");
			} else {
				$
						.ajax({
							url : "/plan/addfoodplan",
							async : false,
							type : "post",
							data : {
								userid : $("#uid").val(),								
								plandate : $("#foodplandate").val(),
								food : JSON.stringify($table
										.bootstrapTable('getData')),
							},
							success : function(data) {
								alert(data.msg);
								if(data.status==200)
									$("#foodplanday5").attr("disabled", false);
							}
						})
			}			
		}
		if (!$("#foodplan5").is(':hidden')) {
			var $table = $("#food5table");
			if ($table.bootstrapTable('getData') == '') {
				alert("请选择食物!");
			} else {
				$
						.ajax({
							url : "/plan/addfoodplan",
							async : false,
							type : "post",
							data : {
								userid : $("#uid").val(),								
								plandate : $("#foodplandate").val(),
								food : JSON.stringify($table
										.bootstrapTable('getData')),
							},
							success : function(data) {
								alert(data.msg);
								if(data.status==200)
									$("#foodplanday6").attr("disabled", false);
							}
						})
			}			
		}
		if (!$("#foodplan6").is(':hidden')) {
			var $table = $("#food6table");
			if ($table.bootstrapTable('getData') == '') {
				alert("请选择食物!");
			} else {
				$
						.ajax({
							url : "/plan/addfoodplan",
							async : false,
							type : "post",
							data : {
								userid : $("#uid").val(),								
								plandate : $("#foodplandate").val(),
								food : JSON.stringify($table
										.bootstrapTable('getData')),
							},
							success : function(data) {
								alert(data.msg);
								if(data.status==200)
									$("#foodplanday7").attr("disabled", false);
							}
						})
			}			
		}
		if (!$("#foodplan7").is(':hidden')) {
			var $table = $("#food7table");
			if ($table.bootstrapTable('getData') == '') {
				alert("请选择食物!");
			} else {
				$
						.ajax({
							url : "/plan/addfoodplan",
							async : false,
							type : "post",
							data : {
								userid : $("#uid").val(),								
								plandate : $("#foodplandate").val(),
								food : JSON.stringify($table
										.bootstrapTable('getData')),
							},
							success : function(data) {
								alert(data.msg);
								if(data.status==200)
									$("#completedietplan").attr("disabled", false);
							}
						})
			}			
		}
	}
}
/* 点击完成饮食周期计划按钮时执行的函数 */
function completediet() {
	/* 清空session中的缓存数据 */
	$.ajax({
		url : "/plan/deldietplanindex",
		async : false,
	})
	/* 标志清0 */
	dietflag = 0;
	/* 数组清空 */
	dateArray.splice(0, dateArray.length);
	/* 清空每一天表格中的数据 */
	$('#food1table').bootstrapTable('removeAll');
	$('#food2table').bootstrapTable('removeAll');
	$('#food3table').bootstrapTable('removeAll');
	$('#food4table').bootstrapTable('removeAll');
	$('#food5table').bootstrapTable('removeAll');
	$('#food6table').bootstrapTable('removeAll');
	$('#food7table').bootstrapTable('removeAll');
	/* 清空日期输入框 */
	$("#foodplandate").val("");
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
	}).attr("disabled", true);

	$("#foodplanday3").css({
		'background' : '#FFF'
	}).attr("disabled", true);

	$("#foodplanday4").css({
		'background' : '#FFF'
	}).attr("disabled", true);

	$("#foodplanday5").css({
		'background' : '#FFF'
	}).attr("disabled", true);

	$("#foodplanday6").css({
		'background' : '#FFF'
	}).attr("disabled", true);

	$("#foodplanday7").css({
		'background' : '#FFF'
	}).attr("disabled", true);

	$("#completedietplan").attr("disabled", true);

	/* 当没有食物被选中的时候bootstrapTable中显示的文字信息 */
	$("#food1table .no-records-found td").html("第一天的饮食计划中暂无食物");
	$("#food2table .no-records-found td").html("第二天的饮食计划中暂无食物");
	$("#food3table .no-records-found td").html("第三天的饮食计划中暂无食物");
	$("#food4table .no-records-found td").html("第四天的饮食计划中暂无食物");
	$("#food5table .no-records-found td").html("第五天的饮食计划中暂无食物");
	$("#food6table .no-records-found td").html("第六天的饮食计划中暂无食物");
	$("#food7table .no-records-found td").html("第七天的饮食计划中暂无食物");

	/* 为保存按钮赋初值 */
	$("#savefoodplan").text("保存第一天饮食计划");
}
/* 初始化函数 */
$(function() {
	/* 初始化时间插件 */
	$(function(){
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
	})
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
	completediet();
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
	}).attr("disabled", true);

	$("#foodplanday3").css({
		'background' : '#FFF'
	}).attr("disabled", true);

	$("#foodplanday4").css({
		'background' : '#FFF'
	}).attr("disabled", true);

	$("#foodplanday5").css({
		'background' : '#FFF'
	}).attr("disabled", true);

	$("#foodplanday6").css({
		'background' : '#FFF'
	}).attr("disabled", true);

	$("#foodplanday7").css({
		'background' : '#FFF'
	}).attr("disabled", true);

	$("#completedietplan").attr("disabled", true);

	/* 当没有食物被选中的时候bootstrapTable中显示的文字信息 */
	$("#food1table .no-records-found td").html("第一天的饮食计划中暂无食物");
	$("#food2table .no-records-found td").html("第二天的饮食计划中暂无食物");
	$("#food3table .no-records-found td").html("第三天的饮食计划中暂无食物");
	$("#food4table .no-records-found td").html("第四天的饮食计划中暂无食物");
	$("#food5table .no-records-found td").html("第五天的饮食计划中暂无食物");
	$("#food6table .no-records-found td").html("第六天的饮食计划中暂无食物");
	$("#food7table .no-records-found td").html("第七天的饮食计划中暂无食物");

	/* 为保存按钮赋初值 */
	$("#savefoodplan").text("保存第一天饮食计划");
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
/* 手动改变日期 */
function checkdate(date, days) {
	if (days != null) {
		var d = new Date(date);
		d.setDate(d.getDate() + days);
		var month = d.getMonth() + 1;
		var day = d.getDate();
		if (month < 10) {
			month = "0" + month;
		}
		if (day < 10) {
			day = "0" + day;
		}
		var val = d.getFullYear() + "-" + month + "-" + day;
		return val;
	} else
		return date;
}