<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="/css/main.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="/css/bootstrap-table.min.css"
	type="text/css" media="screen">
<link rel="stylesheet" href="/css/bootstrap-datetimepicker.min.css"
	type="text/css" media="screen" />
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/jquery.cookie.js"></script>
<script type="text/javascript" src="/js/userinfo.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-table.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript" src="/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript"
	src="/js/bootstrap-datetimepicker.zh-CN.js"></script>
</head>
<body>
	<div class="route_bg">
		<a>用户审核</a>&nbsp;<i class="glyphicon glyphicon-chevron-right"></i><a>&nbsp;商家审核</a>
	</div>


	<div>
		<table id="sellertable">
			<thead style="background-color: #003D79; color: #FFF"></thead>
		</table>
	</div>
</body>
<script>
	$("#sellertable").bootstrapTable(
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
						url : "/seller/getsellerapplication",
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
									field : "ownname",
									title : "店主",
									align : "center",
									valign : "middle",
									cellStyle : function(value, row, index,field){
										return {
											css : {
												"color" : "#2c87f0"
											}
										}
									},
								},
								{
									field:"uid",
									title:"身份证",
									align:"center",
									valign:"middle",
								},
								{
									field:"storelicenseid",
									title:"营业执照",
									align:"center",
									valign:"middle",
								},
								{
									field:"storetype",
									title:"店铺类型",
									align:"center",
									valign:"middle",
								},
								{
									field : "sqdate",
									title : "申请日期",
									align : "center",
									valign : "middle",
								},
								{
									field : "operate",
									title : "operate",
									align : "center",
									valign : "middle",
									formatter : function operate(value, row,index) {
										return '<button type="button" class="btn btn-default btn-sm" onclick="accept(\''
												+ row.id
												+ '\',\''+row.userid+'\')"> <span class="glyphicon glyphicon-ok"></span> 同意</button>&nbsp<button type="button" class="btn btn-default btn-sm" onclick="refuse(\''
												+ row.id
												+ '\',\''+row.userid+'\')"><span class="glyphicon glyphicon-remove"></span> 拒绝</button>'
									}
								} ],

					})
	function accept(id,userId) {
        isAccept = window.confirm("确定同意其成为商家?");
        if(isAccept==true){
        	$.ajax({
        		url:"/seller/updatesellerapplication",        		
        		async:false,
        		type:"post",
        		data:{
        			id:id,
        			userid:userId,
        			sqStatus:"1",
        			updatedTime:getcurrenttime(),
        		},
        	success:function(data){
        		if(data.status==200){
					$("#sellertable").bootstrapTable('remove', {
						field : 'id',
						values : [ parseInt(id) ]
					});
					alert(data.msg);
				} 	
				else
					alert(data.msg);      		
        	}
        	})
        }
	}
	function refuse(id,userId){
		isRefuse = window.confirm("确定拒绝其成为商家?");
		if(isRefuse==true){
			$.ajax({
				url : "/seller/updatesellerapplication",
				data:{
					id:id,
        			userid:userId,
        			sqStatus:"0",
        			updatedTime:getcurrenttime(),						
				},
				async : false,
				type:"post",
				success : function(data) {						
					if(data.status==200){
						$("#sellertable").bootstrapTable('remove', {
							field : 'id',
							values : [ parseInt(id) ]
						});
						alert(data.msg);
					} 	
					else
						alert(data.msg);   						
				}
			});				
		}			
	}
	/*获取当前时间*/
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
</script>
</html>