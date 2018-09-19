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
	<div class="content_right">
		<div class="content_right_title">
			<center><span style="margin-left: 30px;">消息提醒</span></center>
		</div>
		<div class="content_right_bottom">
			<div style="margin-left: 30px;">
				<div>
					<table id="messageremindtable"></table>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$("#messageremindtable")
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
				url : "/nutritionist/messageremind/"+ $(".title_bottom .title_bottom_menu #userid").val(),
				columns : [
						{
							field : "id",
							visible : false,
						},
						{
							field : "nid",
							visible : false,
						},
						{
							field : "message",
							title : "消息内容",
							align : "center",
							valign : "middle",
							formatter:function(value,
									row, index){
								if(value.length>30)
									return value.substr(0,30);
								return value;
							}
						},
						{
							field : "messagetime",
							title : "发布时间",
							align : "center",
							valign : "middle",
						},						
						],
			})
	</script>
 