$("#dietplanindextable")
		.bootstrapTable(
				{
					idField : "id",
					uniqueId : "id",
					pagination : true,
					striped : true,
					search : true,
					showRefresh : true,
					cache : false,
					toolbar : "#toolbar",
					height : 500,
					pageNumber : 1,
					pageSize : 5,
					pageList : [ 5, 10, 15 ],			
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
								field : "nutritionistid",
								visible : false,
							},							
							{
								field : "startdate",
								title : "开始日期",
								align : "center",
								valign : "middle",
								formatter : function formatterdate(value) {
									return value.substr(0, 10);
								}
							},
							{
								field : "enddate",
								title : "截止日期",
								align : "center",
								valign : "middle",
								formatter : function formatterdate(value) {
									return value.substr(0, 10);
								}
							},
							{
								field : "plantype",
								title : "计划类型",
								align : "center",
								valign : "middle",
								formatter : function formatterdate(value) {									
									return "饮食计划";
								}
							},
							{
								field : "operate",
								title : "操作",
								align : "center",
								valign : "middle",
								formatter : function operate(value, row, index) {									
									return '<button type="button" class="btn btn-default btn-sm" onclick="dietplandetail(\''
									+ row.id
									+ '\',\''
											+ row.userid
											+ '\',\''
											+ row.nutritionistid
											+ '\',\''
											+ row.startdate
											+ '\',\''
											+ row.enddate
											+ '\')"><span class="glyphicon glyphicon-align-justify"></span> 查看详情</button>'
								}
							} ],
				})
$("#foodtable")
.bootstrapTable(
		{
			idField : "id",
			uniqueId : "id",
			cache : false,
			pagination : false,
			striped : false,
			height : 300,
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
					}],
		})
function fanhui(){
	$.ajax({
		url : "/jsp/showjiankangplan.html",
		async : false,
		success : function(data) {
			$("#layout_right_content").html(data);
		}
	});
}
function dietplandetail(indexid,userid,nutritiionistid,startdate,enddate){
	$("#foodtable").bootstrapTable('removeAll');
	$("#dietplandate .btn-group").empty();
	$("#planid").val(indexid);
    startdate = startdate.substr(0,10);	
    enddate = enddate.substr(0,10);
	for(var i=0;i<7;i++){
		var str = '<button type="button" class="btn btn-default" onclick="showeverydaydietplan(\''+startdate+'\')">'+startdate+'</button>';
		$("#dietplandate .btn-group").append(str); 				
		if(startdate == enddate){			
			break;
		}	
		startdate = checkdate(startdate,1);
	}	
	$("#dietplanModal").modal();
}
function showeverydaydietplan(date){
	$("#foodtable").bootstrapTable('refresh',{url:'/plan/geteverydaydietplan/'+$("#uid").val()+'/'+$("#nid").val()+'/'+$("#planid").val()+'/'+date});
}

$(function(){
	$("#dietplanindextable").bootstrapTable('refresh',{url:'/plan/getdietplanindex/'+$("#uid").val()+'/'+$("#nid").val()});
})
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