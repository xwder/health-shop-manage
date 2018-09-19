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
		<div class="content_right_title" style="margin-bottom: 20px;">
			<center><span>我的营养师</span></center>
		</div>
		<div class="content_right_bottom">

			<div style="margin-left: 30px;">
				<div>
					<table id="mynutritionisttable"></table>
				</div>
			</div>
		</div>
	</div>
	<!-- 留言模态框 -->
	<div class="modal fade" id="commentModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="commentModalLabel">留言</h4>
				</div>
				<div class="modal-body">
					<div class="form-group" style="display: none">
						<input type="text" class="form-control" id="nutritionistid">
					</div>
					<div class="form-group" id="reply">
						<label for="name">留言内容</label>
						<textarea class="form-control" rows="5" id="commentcontent"></textarea>
						<div class="tools-box">
							<div class="operator-box-btn">
								<span class="face-icon">☺</span>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" id="closeModal" class="btn btn-default"
						data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" onclick="savecomment()">保存留言</button>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">	
	
		$("#mynutritionisttable")
				.bootstrapTable(
						{
							idField : "id",
							uniqueId : "id",
							pagination : false,
							striped : false,
							search : false,
							showRefresh : false,
							cache : false,
							url : "/nutritionist/getmynutritionist/"+$(".title_bottom .title_bottom_menu #userid").val(),
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
										cellStyle : function(value, row, index,
												field) {
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
										formatter : function operate(value,
												row, index) {
											return '<button type="button" class="btn btn-default btn-sm" onclick="comment(\''
													+ row.id
													+ '\')"><span class="glyphicon glyphicon-align-justify"></span> 留言</button>'
										}
									}],

						})
		/*打开留言框*/
		function comment(id) {
			$("#commentModal #nutritionistid").val(id),
			$("#commentModal").modal();
		}
		/*保存留言*/
		function savecomment(){
			if($.trim($("#commentcontent").val())=='')
				alert("请输入留言内容!");
			else{
				 $.ajax({
						url : "/nutritionist/comment",
						data : {
							uid :$(".title_bottom .title_bottom_menu #userid").val(), 
							nid :$("#commentModal #nutritionistid").val(),
							commentcontent : AnalyticEmotion($('#commentcontent').val()),
							commenttime : getcurrenttime(),							 
						},
						type : "post",
						async : false,
						success : function(data) {
							if (data.status == 200) {								
								$("#commentModal").modal('hide'), 
								$("#commentModal #commentcontent").val(''),
								alert(data.msg);
							} else
								alert(data.msg);
						}
					})						
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
		$(function() {
			$('.face-icon').SinaEmotion($('#commentcontent'));
			$("#mynutritionisttable .no-records-found td").html("暂无专属营养师的信息");
		})
	</script>
 