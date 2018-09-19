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
											+ '\')"><span class="glyphicon glyphicon-align-justify"></span> 健康信息</button>&nbsp<button type="button" class="btn btn-default btn-sm" onclick="addhealthplan(\''
											+ row.id
											+ '\')"><span class="glyphicon glyphicon-plus"></span> 健康计划</button>&nbsp<button type="button" class="btn btn-default btn-sm" onclick="messageremind(\''
											+ row.id
											+ '\')"><span class="glyphicon glyphicon-plus"></span> 消息提醒</button>&nbsp<button type="button" class="btn btn-default btn-sm" onclick="deletevip(\''
											+ row.id
											+ '\')"><span class="glyphicon glyphicon-remove"></span> 删除会员</button>'
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
			url : "/vip/deletevip/" + id + "/" + $("#userId").text(),
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
	$("#sport1").empty();
	$("#sport1").append("<option>请选择</option>");
	$.ajax({
		url : "/item/sport/getsportitem",
		asnyc : false,
		success : function(data) {
			if (data.status == 200) {
				for (var i = 0; i < data.data.length; i++) {
					var option = "<option value=" + data.data[i].id + ">"
							+ data.data[i].sportname + "</option>";
					$("#sport1").append(option);
				}
			}
		}
	});
	completediet();
	completesport();
	$("#jkplanModal").modal();
}
/* 根据不同的类别显示不同的计划 */
/* 显示饮食计划 */
function showdietplan() {
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

$(function(){
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
	/* 隐藏所有计划 */
	$("#diet").css({
		'background' : '#FFF'
	});
	$("#sport").css({
		'background' : '#FFF'
	});
	$("#dietplan").hide();
	$("#sportplan").hide();
})
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
/* 手动改变日期 */
function checkdate(date,days){
	if(days!=null){
		var d=new Date(date); 
		d.setDate(d.getDate()+days); 
		var month=d.getMonth()+1; 
		var day = d.getDate(); 
		if(month<10){ 
		month = "0"+month; 
		} 
		if(day<10){ 
		day = "0"+day; 
		} 
		var val = d.getFullYear()+"-"+month+"-"+day; 
		return val; 
	}
	else
		return date;
}
