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
			<center><span>留言记录</span></center>
		</div>
		<div class="content_right_bottom">
			<div style="margin-left: 30px;">
				<div>
					<table id="uncommentrecordtable"></table>
				</div>
			</div>
		</div>
	</div>
	<!-- 留言详情模态框 -->
	<div class="modal fade" id="commentModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="commentModalLabel">留言详情</h4>
				</div>
				<div class="modal-body">
					<div class="form-group" style="height: 120px;">
						<label for="name">留言内容</label>
						<div class="form-control" id="commentcontent"
							style="height: 90%; overflow-y: auto;"></div>
					</div>
					<div class="form-group" style="height: 120px;">
						<label for="name">回复内容</label>
						<div class="form-control" id="replycontent"
							style="height: 90%; overflow-y: auto;"></div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" id="closeModal" class="btn btn-default"
						data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$("#uncommentrecordtable")
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
							url : "/nutritionist/getcommentrecord/"+ $(".title_bottom .title_bottom_menu #userid").val(),
							columns : [
									{
										field : "id",
										visible : false,
									},
									{
										field : "nid",
										title : "营养师编号",
										align : "center",
										valign : "middle",
									},
									{
										field : "commentcontent",
										visible : false,
									},
									{
										field : "commenttime",
										title : "留言时间",
										align : "center",
										valign : "middle",
									},
									{
										field : "replycontent",
										visible : false,
									},
									{
										field : "replytime",
										title : "回复时间",
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
											return '<button type="button" class="btn btn-default btn-sm" onclick="commentdetail(\''
													+ row.id
													+ '\')"><span class="glyphicon glyphicon-align-justify"></span> 留言详情</button>';
										}
									} ],
						})
		function commentdetail(id) {
			$.ajax({
				url : "/nutritionist/getsinglecomment/" + id,
				async : false,
				success : function(data) {
					if (data!=null) {
						$("#commentModal #commentcontent").html(data.commentcontent), 
						$("#commentModal #replycontent").html(data.replycontent),
						$("#commentModal").modal();
					} else
						alert("数据获取失败!");
				}
			})
		}
	</script>
 