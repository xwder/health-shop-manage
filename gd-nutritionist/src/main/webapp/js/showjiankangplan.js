/**
 * 
 */
$("#jkplantable")
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
					url : "/plan/getVipBasicInfo/" + $("#userId").text(),
					columns : [
							{
								field : "id",
								visible : false,
							},
							{
								field : "userid",
								visible : false,
							},
							{
								field : "username",
								title : "用户名",
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
								field : "height",
								title : "身高(cm)",
								align : "center",
								valign : "middle",

							},
							{
								field : "weight",
								title : "体重(kg)",
								align : "center",
								valign : "middle",

							},
							{
								field : "birthday",
								title : "出生日期",
								align : "center",
								valign : "middle",
								formatter : function formatterdate(value) {
									return value.substr(0, 10);
								}
							},
							{
								field : "operate",
								title : "操作",
								align : "center",
								valign : "middle",
								formatter : function operate(value, row, index) {									
									return '<button type="button" class="btn btn-default btn-sm" onclick="showdietplanindex(\''
											+ row.userid
											+ '\')"><span class="glyphicon glyphicon-align-justify"></span> 查看饮食计划</button>&nbsp<button type="button" class="btn btn-default btn-sm" onclick="showsportplanindex(\''
											+ row.userid
											+ '\')"><span class="glyphicon glyphicon-align-justify"></span> 查看运动计划</button>'
								}
							} ],
				})
function showdietplanindex(id){
	$.ajax({
		url :"/plan/showdietplanindex/"+id+"/"+$("#userId").text(),
		async:false,
		success:function(data){
			$("#layout_right_content").html(data);
		}
	})
	
}
function showsportplanindex(id){
	$.ajax({
		url :"/plan/showsportplanindex/"+id+"/"+$("#userId").text(),
		async:false,
		success:function(data){
			$("#layout_right_content").html(data);
		}
	})
}
