var sportArray = new Array();
var sportflag=0;
$("#sport1table")
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
						field : "sportname",
						title : "运动项目",
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
					},					
					{
						field : "operate",
						title : "操作",
						align : "center",
						valign : "middle",
						formatter : function operate(value, row, index) {
							var table = "#sport1table";
							return '<button type="button" class="btn btn-default btn-sm" onclick="deletesport(\''+table+'\',\''
									+ row.id
									+ '\')"><span class="glyphicon glyphicon-remove"></span> 删除</button>'
						}
					} ],
		})
$("#sport2table")
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
						field : "sportname",
						title : "运动项目",
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
					},					
					{
						field : "operate",
						title : "操作",
						align : "center",
						valign : "middle",
						formatter : function operate(value, row, index) {
							var table = "#sport2table";
							return '<button type="button" class="btn btn-default btn-sm" onclick="deletesport(\''+table+'\',\''
									+ row.id
									+ '\')"><span class="glyphicon glyphicon-remove"></span> 删除</button>'
						}
					} ],
		})
$("#sport3table")
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
						field : "sportname",
						title : "运动项目",
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
					},					
					{
						field : "operate",
						title : "操作",
						align : "center",
						valign : "middle",
						formatter : function operate(value, row, index) {
							var table = "#sport3table";
							return '<button type="button" class="btn btn-default btn-sm" onclick="deletesport(\''+table+'\',\''
									+ row.id
									+ '\')"><span class="glyphicon glyphicon-remove"></span> 删除</button>'
						}
					} ],
		})
$("#sport4table")
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
						field : "sportname",
						title : "运动项目",
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
					},					
					{
						field : "operate",
						title : "操作",
						align : "center",
						valign : "middle",
						formatter : function operate(value, row, index) {
							var table = "#sport4table";
							return '<button type="button" class="btn btn-default btn-sm" onclick="deletesport(\''+table+'\',\''
									+ row.id
									+ '\')"><span class="glyphicon glyphicon-remove"></span> 删除</button>'
						}
					} ],
		})
$("#sport5table")
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
						field : "sportname",
						title : "运动项目",
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
					},					
					{
						field : "operate",
						title : "操作",
						align : "center",
						valign : "middle",
						formatter : function operate(value, row, index) {
							var table = "#sport5table";
							return '<button type="button" class="btn btn-default btn-sm" onclick="deletesport(\''+table+'\',\''
									+ row.id
									+ '\')"><span class="glyphicon glyphicon-remove"></span> 删除</button>'
						}
					} ],
		})
$("#sport6table")
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
						field : "sportname",
						title : "运动项目",
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
					},					
					{
						field : "operate",
						title : "操作",
						align : "center",
						valign : "middle",
						formatter : function operate(value, row, index) {
							var table = "#sport6table";
							return '<button type="button" class="btn btn-default btn-sm" onclick="deletesport(\''+table+'\',\''
									+ row.id
									+ '\')"><span class="glyphicon glyphicon-remove"></span> 删除</button>'
						}
					} ],
		})
$("#sport7table")
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
						field : "sportname",
						title : "运动项目",
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
					},					
					{
						field : "operate",
						title : "操作",
						align : "center",
						valign : "middle",
						formatter : function operate(value, row, index) {
							var table = "#sport7table";
							return '<button type="button" class="btn btn-default btn-sm" onclick="deletesport(\''+table+'\',\''
									+ row.id
									+ '\')"><span class="glyphicon glyphicon-remove"></span> 删除</button>'
						}
					} ],
		})
function showsportday1() {
	$("#sportplanday1").css({
		'background' : '#C0C0C0'
	});
	$("#sportplanday2").css({
		'background' : '#FFF'
	});
	$("#sportplanday3").css({
		'background' : '#FFF'
	});
	$("#sportplanday4").css({
		'background' : '#FFF'
	});
	$("#sportplanday5").css({
		'background' : '#FFF'
	});
	$("#sportplanday6").css({
		'background' : '#FFF'
	});
	$("#sportplanday7").css({
		'background' : '#FFF'
	});
	$("#sportplan1").show();
	$("#sportplan2").hide();
	$("#sportplan3").hide();
	$("#sportplan4").hide();
	$("#sportplan5").hide();
	$("#sportplan6").hide();
	$("#sportplan7").hide();
		
	$("#sportplandate").val(sportArray[0]);
	$("#savesportplan").text("保存第一天运动计划");

}
function showsportday2() {
	$("#sportplanday1").css({
		'background' : '#FFF'
	});
	$("#sportplanday2").css({
		'background' : '#C0C0C0'
	});
	$("#sportplanday3").css({
		'background' : '#FFF'
	});
	$("#sportplanday4").css({
		'background' : '#FFF'
	});
	$("#sportplanday5").css({
		'background' : '#FFF'
	});
	$("#sportplanday6").css({
		'background' : '#FFF'
	});
	$("#sportplanday7").css({
		'background' : '#FFF'
	});
	$("#sportplan1").hide();
	$("#sportplan2").show();
	$("#sportplan3").hide();
	$("#sportplan4").hide();
	$("#sportplan5").hide();
	$("#sportplan6").hide();
	$("#sportplan7").hide();
	
	$("#sportplandate").val(sportArray[1]);
	
	$("#savesportplan").text("保存第二天运动计划");
}
function showsportday3() {
	$("#sportplanday1").css({
		'background' : '#FFF'
	});
	$("#sportplanday2").css({
		'background' : '#FFF'
	});
	$("#sportplanday3").css({
		'background' : '#C0C0C0'
	});
	$("#sportplanday4").css({
		'background' : '#FFF'
	});
	$("#sportplanday5").css({
		'background' : '#FFF'
	});
	$("#sportplanday6").css({
		'background' : '#FFF'
	});
	$("#sportplanday7").css({
		'background' : '#FFF'
	});
	$("#sportplan1").hide();
	$("#sportplan2").hide();
	$("#sportplan3").show();
	$("#sportplan4").hide();
	$("#sportplan5").hide();
	$("#sportplan6").hide();
	$("#sportplan7").hide();
		
	$("#sportplandate").val(sportArray[2]);
	$("#savesportplan").text("保存第三天运动计划");
}
function showsportday4() {
	$("#sportplanday1").css({
		'background' : '#FFF'
	});
	$("#sportplanday2").css({
		'background' : '#FFF'
	});
	$("#sportplanday3").css({
		'background' : '#FFF'
	});
	$("#sportplanday4").css({
		'background' : '#C0C0C0'
	});
	$("#sportplanday5").css({
		'background' : '#FFF'
	});
	$("#sportplanday6").css({
		'background' : '#FFF'
	});
	$("#sportplanday7").css({
		'background' : '#FFF'
	});
	$("#sportplan1").hide();
	$("#sportplan2").hide();
	$("#sportplan3").hide();
	$("#sportplan4").show();
	$("#sportplan5").hide();
	$("#sportplan6").hide();
	$("#sportplan7").hide();
	
	$("#sportplandate").val(sportArray[3]);
	
	$("#savesportplan").text("保存第四天运动计划");
}
function showsportday5() {
	$("#sportplanday1").css({
		'background' : '#FFF'
	});
	$("#sportplanday2").css({
		'background' : '#FFF'
	});
	$("#sportplanday3").css({
		'background' : '#FFF'
	});
	$("#sportplanday4").css({
		'background' : '#FFF'
	});
	$("#sportplanday5").css({
		'background' : '#C0C0C0'
	});
	$("#sportplanday6").css({
		'background' : '#FFF'
	});
	$("#sportplanday7").css({
		'background' : '#FFF'
	});
	$("#sportplan1").hide();
	$("#sportplan2").hide();
	$("#sportplan3").hide();
	$("#sportplan4").hide();
	$("#sportplan5").show();
	$("#sportplan6").hide();
	$("#sportplan7").hide();
	
	$("#sportplandate").val(sportArray[4]);
	
	$("#savesportplan").text("保存第五天运动计划");
}
function showsportday6() {
	$("#sportplanday1").css({
		'background' : '#FFF'
	});
	$("#sportplanday2").css({
		'background' : '#FFF'
	});
	$("#sportplanday3").css({
		'background' : '#FFF'
	});
	$("#sportplanday4").css({
		'background' : '#FFF'
	});
	$("#sportplanday5").css({
		'background' : '#FFF'
	});
	$("#sportplanday6").css({
		'background' : '#C0C0C0'
	});
	$("#sportplanday7").css({
		'background' : '#FFF'
	});
	$("#sportplan1").hide();
	$("#sportplan2").hide();
	$("#sportplan3").hide();
	$("#sportplan4").hide();
	$("#sportplan5").hide();
	$("#sportplan6").show();
	$("#sportplan7").hide();
		
	$("#sportplandate").val(sportArray[5]);
	
	$("#savesportplan").text("保存第六天运动计划");
}
function showsportday7() {
	$("#sportplanday1").css({
		'background' : '#FFF'
	});
	$("#sportplanday2").css({
		'background' : '#FFF'
	});
	$("#sportplanday3").css({
		'background' : '#FFF'
	});
	$("#sportplanday4").css({
		'background' : '#FFF'
	});
	$("#sportplanday5").css({
		'background' : '#FFF'
	});
	$("#sportplanday6").css({
		'background' : '#FFF'
	});
	$("#sportplanday7").css({
		'background' : '#C0C0C0'
	});
	$("#sportplan1").hide();
	$("#sportplan2").hide();
	$("#sportplan3").hide();
	$("#sportplan4").hide();
	$("#sportplan5").hide();
	$("#sportplan6").hide();
	$("#sportplan7").show();	
	
	$("#sportplandate").val(sportArray[6]);
	
	
	$("#savesportplan").text("保存第七天运动计划");
}
/* 删除已选择运动项目 */
function deletesport(table, id) {
	$(table).bootstrapTable('removeByUniqueId', parseInt(id));
	table = table + " .no-records-found td";
	$(table).html("暂无运动项目");
}
/*保存每一天的运动计划*/
function saveeverydaysportplan(){
	if($("#sportplandate").val()==null||$("#sportplandate").val()==''){
		alert("运动计划日期不能为空!");
	}
	else{
		if (!$("#sportplan1").is(':hidden')){			
			var $table = $("#sport1table");
			if($table.bootstrapTable('getData')==''){
				alert("请选择运动项目!");
			}
			else{				
	    		$.ajax({
					url:"/plan/addsportplan",
				    async:false,
				    type:"post",
				    data:{
				    	userid:$("#uid").val(),				    	
				    	plandate:$("#sportplandate").val(),
				    	sport:JSON.stringify($table.bootstrapTable('getData')),		    	
				    },
				    success:function(data){						    							    		
				    	alert(data.msg);
				    	if(data.status==200)
				    		$("#sportplanday2").attr("disabled",false);
				    }			    		
				})					   
			}			
			if(sportflag==0){
				sportArray.push($("#sportplandate").val()),
				sportArray.push(checkdate($("#sportplandate").val(),1)),
				sportArray.push(checkdate($("#sportplandate").val(),2)),
				sportArray.push(checkdate($("#sportplandate").val(),3)),
				sportArray.push(checkdate($("#sportplandate").val(),4)),
				sportArray.push(checkdate($("#sportplandate").val(),5)),
				sportArray.push(checkdate($("#sportplandate").val(),6)),
				sportflag++;
			}				
		}
		if (!$("#sportplan2").is(':hidden')){
			var $table = $("#sport2table");
			if($table.bootstrapTable('getData')==''){
				alert("请选择运动项目!");
			}
			else{
				$.ajax({
				url:"/plan/addsportplan",
			    async:false,
			    type:"post",
			    data:{
			    	userid:$("#uid").val(),			    	
			    	plandate:$("#sportplandate").val(),
			    	sport:JSON.stringify($table.bootstrapTable('getData')),		    	
			    },
			    success:function(data){						    							    		
			    	alert(data.msg);
			    	if(data.status==200)
			    		$("#sportplanday3").attr("disabled",false);
			    }				
			})
			}						
		}
		if (!$("#sportplan3").is(':hidden')){
			var $table = $("#sport3table");
			if($table.bootstrapTable('getData')==''){
				alert("请选择运动项目!");
			}
			else{
				$.ajax({
				url:"/plan/addsportplan",
			    async:false,
			    type:"post",
			    data:{
			    	userid:$("#uid").val(),
			    	plandate:$("#sportplandate").val(),
			    	sport:JSON.stringify($table.bootstrapTable('getData')),		    	
			    },
			    success:function(data){						    							    		
			    	alert(data.msg);
			    	if(data.status==200)
			    		$("#sportplanday4").attr("disabled",false);
			    }	
			})
			}					
		}
		if (!$("#sportplan4").is(':hidden')){
			var $table = $("#sport4table");
			if($table.bootstrapTable('getData')==''){
				alert("请选择运动项目!");
			}
			else{
				$.ajax({
				url:"/plan/addsportplan",
			    async:false,
			    type:"post",
			    data:{
			    	userid:$("#uid").val(),
			    	plandate:$("#sportplandate").val(),
			    	sport:JSON.stringify($table.bootstrapTable('getData')),		    	
			    },
			    success:function(data){						    							    		
			    	alert(data.msg);
			    	if(data.status==200)
			    		$("#sportplanday5").attr("disabled",false);
			    }	
			})
			}			
		}
		if (!$("#sportplan5").is(':hidden')){
			var $table = $("#sport5table");
			if($table.bootstrapTable('getData')==''){
				alert("请选择运动项目!");
			}
			else{
				$.ajax({
				url:"/plan/addsportplan",
			    async:false,
			    type:"post",
			    data:{
			    	userid:$("#uid").val(),
			    	plandate:$("#sportplandate").val(),
			    	sport:JSON.stringify($table.bootstrapTable('getData')),		    	
			    },
			    success:function(data){						    							    		
			    	alert(data.msg);
			    	if(data.status==200)
			    		$("#sportplanday6").attr("disabled",false);
			    }	
			})
			}			
		}
		if (!$("#sportplan6").is(':hidden')){
			var $table = $("#sport6table");
			if($table.bootstrapTable('getData')==''){
				alert("请选择运动项目!");
			}
			else{
				$.ajax({
				url:"/plan/addsportplan",
			    async:false,
			    type:"post",
			    data:{
			    	userid:$("#uid").val(),
			    	plandate:$("#sportplandate").val(),
			    	sport:JSON.stringify($table.bootstrapTable('getData')),		    	
			    },
			    success:function(data){						    							    		
			    	alert(data.msg);
			    	if(data.status==200)
			    		$("#sportplanday7").attr("disabled",false);
			    }	
			})	
			}			
		}
		if (!$("#sportplan7").is(':hidden')){
			var $table = $("#sport7table");			
			if($table.bootstrapTable('getData')==''){
				alert("请选择运动项目!");
			}
			else{
				$.ajax({
				url:"/plan/addsportplan",
			    async:false,
			    type:"post",
			    data:{
			    	userid:$("#uid").val(),
			    	plandate:$("#sportplandate").val(),
			    	sport:JSON.stringify($table.bootstrapTable('getData')),		    	
			    },
			    success:function(data){						    							    		
			    	alert(data.msg);
			    	if(data.status==200)
			    		$("#completesportplan").attr("disabled",false);
			    }	
			})
			}		
			
		}		
	}	
}
/*点击完成运动周期计划按钮时执行的函数*/
function completesport(){
	/*清空session中的缓存数据*/
	$.ajax({
		url:"/plan/delsportplanindex",
		async:false,
	})
	/*标志清0*/
	sportflag=0;
	/*数组清空*/
	sportArray.splice(0,sportArray.length);	
	/*清空每一天表格中的数据*/
	$('#sport1table').bootstrapTable('removeAll');
	$('#sport2table').bootstrapTable('removeAll');
	$('#sport3table').bootstrapTable('removeAll');
	$('#sport4table').bootstrapTable('removeAll');
	$('#sport5table').bootstrapTable('removeAll');
	$('#sport6table').bootstrapTable('removeAll');
	$('#sport7table').bootstrapTable('removeAll');
	/*清空日期输入框*/
	$("#sportplandate").val("");		
	/* 隐藏每一天的运动计划 */
	/* 默认显示第一天的运动计划 */
	$("#sportplan1").show();
	$("#sportplan2").hide();
	$("#sportplan3").hide();
	$("#sportplan4").hide();
	$("#sportplan5").hide();
	$("#sportplan6").hide();
	$("#sportplan7").hide();
	/* 为每一天的运动计划的button添加css样式 */
	$("#sportplanday1").css({
		'background' : '#C0C0C0'
	});
	
	$("#sportplanday2").css({
		'background' : '#FFF'
	}).attr("disabled",true);	
	
	$("#sportplanday3").css({
		'background' : '#FFF'
	}).attr("disabled",true);
	
	$("#sportplanday4").css({
		'background' : '#FFF'
	}).attr("disabled",true);
	
	$("#sportplanday5").css({
		'background' : '#FFF'
	}).attr("disabled",true);
	
	$("#sportplanday6").css({
		'background' : '#FFF'
	}).attr("disabled",true);
	
	$("#sportplanday7").css({
		'background' : '#FFF'
	}).attr("disabled",true);
	
	//$("#addsport").attr("disabled",true);
	$("#completesportplan").attr("disabled",true);
	
	/* 当没有运动项目被选中的时候bootstrapTable中显示的文字信息 */
	$("#sport1table .no-records-found td").html("第一天的运动计划中暂无运动项目");
	$("#sport2table .no-records-found td").html("第二天的运动计划中暂无运动项目");
	$("#sport3table .no-records-found td").html("第三天的运动计划中暂无运动项目");
	$("#sport4table .no-records-found td").html("第四天的运动计划中暂无运动项目");
	$("#sport5table .no-records-found td").html("第五天的运动计划中暂无运动项目");
	$("#sport6table .no-records-found td").html("第六天的运动计划中暂无运动项目");
	$("#sport7table .no-records-found td").html("第七天的运动计划中暂无运动项目");
	
	/*为保存按钮赋初值*/
	$("#savesportplan").text("保存第一天运动计划");				
}

/*添加运动项目*/
function addsportitem(){
	if($("#sportdescribe").val()==null||$("#sportdescribe").val()==''){	
		alert("请填写运动说明!");	
	}
	else{
		if (!$("#sportplan1").is(':hidden')) {
            $("#sport1table").bootstrapTable('prepend',{
				id : $("#sport1").find("option:selected").val(),
				sportname : $("#sport1").find("option:selected").text(),
				sportdescribe: $("#sportdescribe").val(),						
			});}
		if (!$("#sportplan2").is(':hidden')) {
            $("#sport2table").bootstrapTable('prepend',{
				id : $("#sport1").find("option:selected").val(),
				sportname : $("#sport1").find("option:selected").text(),
				sportdescribe: $("#sportdescribe").val(),						
			});}
		if (!$("#sportplan3").is(':hidden')) {
            $("#sport3table").bootstrapTable('prepend',{
				id : $("#sport1").find("option:selected").val(),
				sportname : $("#sport1").find("option:selected").text(),
				sportdescribe: $("#sportdescribe").val(),						
			});}
		if (!$("#sportplan4").is(':hidden')) {
            $("#sport4table").bootstrapTable('prepend',{
				id : $("#sport1").find("option:selected").val(),
				sportname : $("#sport1").find("option:selected").text(),
				sportdescribe: $("#sportdescribe").val(),						
			});}
		if (!$("#sportplan5").is(':hidden')) {
            $("#sport5table").bootstrapTable('prepend',{
				id : $("#sport1").find("option:selected").val(),
				sportname : $("#sport1").find("option:selected").text(),
				sportdescribe: $("#sportdescribe").val(),						
			});}
		if (!$("#sportplan6").is(':hidden')) {
            $("#sport6table").bootstrapTable('prepend',{
				id : $("#sport1").find("option:selected").val(),
				sportname : $("#sport1").find("option:selected").text(),
				sportdescribe: $("#sportdescribe").val(),						
			});}
		if (!$("#sportplan7").is(':hidden')) {
            $("#sport7table").bootstrapTable('prepend',{
				id : $("#sport1").find("option:selected").val(),
				sportname : $("#sport1").find("option:selected").text(),
				sportdescribe: $("#sportdescribe").val(),						
			});}
	}	
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
	completesport();
	/* 隐藏每一天的运动计划 */
	/* 默认显示第一天的运动计划 */
	$("#sportplan1").show();
	$("#sportplan2").hide();
	$("#sportplan3").hide();
	$("#sportplan4").hide();
	$("#sportplan5").hide();
	$("#sportplan6").hide();
	$("#sportplan7").hide();
	/* 为每一天的运动计划的button添加css样式 */
	$("#sportplanday1").css({
		'background' : '#C0C0C0'
	});
	
	$("#sportplanday2").css({
		'background' : '#FFF'
	}).attr("disabled",true);	
	
	$("#sportplanday3").css({
		'background' : '#FFF'
	}).attr("disabled",true);
	
	$("#sportplanday4").css({
		'background' : '#FFF'
	}).attr("disabled",true);
	
	$("#sportplanday5").css({
		'background' : '#FFF'
	}).attr("disabled",true);
	
	$("#sportplanday6").css({
		'background' : '#FFF'
	}).attr("disabled",true);
	
	$("#sportplanday7").css({
		'background' : '#FFF'
	}).attr("disabled",true);
	
	$("#completesportplan").attr("disabled",true);
	
	/* 当没有运动项目被选中的时候bootstrapTable中显示的文字信息 */
	$("#sport1table .no-records-found td").html("第一天的运动计划中暂无运动项目");
	$("#sport2table .no-records-found td").html("第二天的运动计划中暂无运动项目");
	$("#sport3table .no-records-found td").html("第三天的运动计划中暂无运动项目");
	$("#sport4table .no-records-found td").html("第四天的运动计划中暂无运动项目");
	$("#sport5table .no-records-found td").html("第五天的运动计划中暂无运动项目");
	$("#sport6table .no-records-found td").html("第六天的运动计划中暂无运动项目");
	$("#sport7table .no-records-found td").html("第七天的运动计划中暂无运动项目");
	
	/*为保存按钮赋初值*/
	$("#savesportplan").text("保存第一天运动计划");
	
	$("#sport1").change(function(){		
		if ($("#sport1").find("option:selected").text() != "请选择") {
			$("#addsport").attr("disabled",false);
			$.ajax({
			    url : "/item/sport/getsportitembyid/"+ $("#sport1").find("option:selected").val(),
				async : false,
				success : function(data) {
					if(data.status==200)
						$("#sportdescribe").val(data.data.sportdescribe);					
				}
			})
		}
		else{
			
			$("#sportdescribe").val("");
			$("#addsport").attr("disabled",true);
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