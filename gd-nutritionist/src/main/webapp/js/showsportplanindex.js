/**
 * 
 */
$("#sportplanindextable")
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
									return "运动计划";
								}
							},
							{
								field : "operate",
								title : "操作",
								align : "center",
								valign : "middle",
								formatter : function operate(value, row, index) {									
									return '<button type="button" class="btn btn-default btn-sm" onclick="sportplandetail(\''
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
$("#sporttable")
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
						field : "sportname",
						title : "运动名称",
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
						field : "sportdescribe",
						title : "运动描述",
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
function sportplandetail(indexid,userid,nutritiionistid,startdate,enddate){
	$("#sporttable").bootstrapTable('removeAll');
	$("#dietplandate .btn-group").empty();
	$("#planid").val(indexid);
    startdate = startdate.substr(0,10);	
    enddate = enddate.substr(0,10);
	for(var i=0;i<7;i++){
		var str = '<button type="button" class="btn btn-default" onclick="showeverydaysportplan(\''+startdate+'\')">'+startdate+'</button>';
		$("#dietplandate .btn-group").append(str); 				
		if(startdate == enddate){			
			break;
		}	
		startdate = checkdate(startdate,1);
	}	
	$("#dietplanModal").modal();
}
function showeverydaysportplan(date){
	$("#sporttable").bootstrapTable('refresh',{url:'/plan/geteverydaysportplan/'+$("#uid").val()+'/'+$("#nid").val()+'/'+$("#planid").val()+'/'+date});
}

$(function(){
	$("#sportplanindextable").bootstrapTable('refresh',{url:'/plan/getsportplanindex/'+$("#uid").val()+'/'+$("#nid").val()})
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