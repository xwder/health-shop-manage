<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
	<input id="nid" type="hidden">
	<input id="planid" type="hidden">
	<div class="content_right">
		<div class="content_right_title">
			<!-- <span style="margin-left: 30px;">显示运动计划</span> -->
		</div>
		<div class="content_right_bottom">
			<div style="margin-left: 30px;">
				<div>
					<table id="sportplanindextable">
					</table>
				</div>
			</div>
		</div>
	</div>

	<!-- 显示饮食计划模态框 -->
	<div class="modal fade" id="sportplanModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width: 800px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">饮食计划</h4>
				</div>
				<div class="modal-body" style="height: 400px;">
					<center>
						<div style="margin-bottom: 15px; display: block;"
							id="sportplandate">
							<div class="btn-group"></div>
						</div>
					</center>
					<center>
						<div style="width: 80%; display: block;">
							<div id="sportplan">
								<table id="sporttable">
								</table>
							</div>
						</div>
					</center>
				</div>

				<div class="modal-footer">
					<button type="button" id="closeModal" class="btn btn-default"
						data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
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
										formatter : function formatterdate(
												value) {
											return value.substr(0, 10);
										}
									},
									{
										field : "enddate",
										title : "截止日期",
										align : "center",
										valign : "middle",
										formatter : function formatterdate(
												value) {
											return value.substr(0, 10);
										}
									},
									{
										field : "plantype",
										title : "计划类型",
										align : "center",
										valign : "middle",
										formatter : function formatterdate(
												value) {
											return "运动计划";
										}
									},
									{
										field : "operate",
										title : "操作",
										align : "center",
										valign : "middle",
										formatter : function operate(value,
												row, index) {
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
		$("#sporttable").bootstrapTable({
			idField : "id",
			uniqueId : "id",
			cache : false,
			pagination : false,
			striped : false,
			height : 300,
			columns : [ {
				field : "id",
				visible : false,
			}, {
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
			}, {
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
			} ],
		})
		function sportplandetail(indexid, userid, nutritiionistid, startdate,
				enddate) {
			$("#sportplan").hide();
			$("#sportplandate .btn-group").empty();
			$("#nid").val(nutritiionistid);
			$("#planid").val(indexid);
			startdate = startdate.substr(0, 10);
			enddate = enddate.substr(0, 10);
			for (var i = 0; i < 7; i++) {
				var str = '<button type="button" class="btn btn-default" onclick="showeverydaysportplan(\''
						+ startdate + '\')">' + startdate + '</button>';
				$("#sportplandate .btn-group").append(str);
				if (startdate == enddate) {
					break;
				}
				startdate = checkdate(startdate, 1);
			}
			$("#sportplanModal").modal();
		}
		function showeverydaysportplan(date) {
			$("#sporttable").bootstrapTable(
					'refresh',
					{
						url : '/nutritionist/geteverydaysportplan/'
								+ $(".title_bottom .title_bottom_menu #userid")
										.val() + '/' + $("#nid").val() + '/'
								+ $("#planid").val() + '/' + date
					});
			$("#sportplan").show();
		}

		$(function() {
			$("#sportplanindextable").bootstrapTable(
					'refresh',
					{
						url : '/nutritionist/getsportplanindex/'
								+ $(".title_bottom .title_bottom_menu #userid")
										.val()
					});
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
	</script>
 