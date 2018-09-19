<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<STYLE type=text/css>
 
A:link {
	COLOR: black; TEXT-DECORATION: none
}
A:visited {
	COLOR: black; TEXT-DECORATION: none
}
A:hover {
	COLOR: #ef9b11; TEXT-DECORATION: underline
}
 
</STYLE>

	<div class="content_right">
		<div class="content_right_title">
			<center><span>营养师列表</span></center>
		</div>
		<div class="content_right_bottom">

			<div style="margin-left: 30px;">
				<div>
					<table id="nutritionisttable"></table>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$("#nutritionisttable")
	.bootstrapTable(
			{
				idField : "id",
				uniqueId : "id",
				pagination : true,
				striped : true,
				search : true,
				showRefresh : true,
				cache : false,				
				pageNumber : 1,
				pageSize : 5,
				pageList : [ 5, 10, 15 ],
				url : "/nutritionist/getallnutritionist",
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
							field : "username",
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
								return '<button type="button" class="btn btn-default btn-sm" onclick="selectnutritionist(\''
										+ row.id
										+ '\')"><span class="glyphicon glyphicon-align-justify"></span> 选择</button>'
							}
						} ],

			})	
    /*会员选择营养师*/
	function selectnutritionist(nid){
		$.ajax({
			url:"/nutritionist/selectnutritionist",
			async:false,
			type:"post",
			data:{
				userId:$(".title_bottom .title_bottom_menu #userid").val(),
				dietitianId:nid,
				userName:$(".title_bottom #showusername").text(),
				sqDate:getcurrenttime(),
				sqStatus:2,
			},
			success:function(data){
				alert(data.msg);								
			}
		})
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
 