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
<link rel="stylesheet" href="/css/bootstrap-editable.css"
	type="text/css" media="screen">
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-table.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript" src="/js/bootstrap-editable.js"></script>
<script type="text/javascript" src="/js/bootstrap-table-editable.js"></script>
</head>
<body>
	<div class="route_bg">
		<a>食材管理</a>&nbsp;<i class="glyphicon glyphicon-chevron-right"></i><a>&nbsp;食材信息</a>
	</div>
	<div>
		<div id="toolbar">
			<button id="add" onclick="addfood()" type="button"
				class="btn btn-default">
				<span class="glyphicon glyphicon-plus"></span>新增
			</button>
		</div>
		<table id="foodtable">
			<thead style="background-color: #003D79; color: #FFF">
			</thead>
		</table>
	</div>

	<!-- 展示食物营养成分 -->
	<div class="modal fade" id="showyyinfoModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width: 700px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">营养成分</h4>
				</div>
				<div class="modal-body">					
					<input type="hidden" id="foodnutritionid">
					<table class="table table-bordered">
						<caption>每100克所含各元素分量</caption>
						<tbody>
							<tr>
								<td>能量(千焦)</td>
								<td style="padding: 0px; margin: 0px;" width="58px;"><input
									id="nengliang" type="text"
									style="width: 58px; height: 39px; border: 0px; margin: 0px;"></td>
								<td>水分(克)</td>
								<td style="padding: 0px; margin: 0px;" width="58px;"><input id="water"
									type="text"
									style="width: 58px; height: 39px; border: 0px; margin: 0px;"></td>
								<td>蛋白质(克)</td>
								<td style="padding: 0px; margin: 0px;" width="58px;"><input
									id="danbaizhi" type="text"
									style="width: 58px; height: 39px; border: 0px; margin: 0px;"></td>
								<td>脂肪(克)</td>
								<td style="padding: 0px; margin: 0px;" width="58px;"><input id="zhifang"
									type="text"
									style="width: 58px; height: 39px; border: 0px; margin: 0px;"></td>
							</tr>
							<tr>
								<td>膳食纤维(克)</td>
								<td style="padding: 0px; margin: 0px;" width="58px;"><input id="xianwei"
									type="text"
									style="width: 58px; height: 39px; border: 0px; margin: 0px;"></td>
								<td>碳水化合物(克)</td>
								<td style="padding: 0px; margin: 0px;" width="58px;"><input id="tanshui"
									type="text"
									style="width: 58px; height: 39px; border: 0px; margin: 0px;"></td>
								<td>维生素A(克)</td>
								<td style="padding: 0px; margin: 0px;" width="58px;"><input id="wA"
									type="text"
									style="width: 58px; height: 39px; border: 0px; margin: 0px;"></td>
								<td>维生素B1(克)</td>
								<td style="padding: 0px; margin: 0px;" width="58px;"><input id="wB1"
									type="text"
									style="width: 58px; height: 39px; border: 0px; margin: 0px;"></td>
							</tr>
							<tr>
								<td>维生素B2(克)</td>
								<td style="padding: 0px; margin: 0px;" width="58px;"><input id="wB2"
									type="text"
									style="width: 58px; height: 39px; border: 0px; margin: 0px;"></td>
								<td>维生素C(克)</td>
								<td style="padding: 0px; margin: 0px;" width="58px;"><input id="wC"
									type="text"
									style="width: 58px; height: 39px; border: 0px; margin: 0px;"></td>
								<td>维生素E(克)</td>
								<td style="padding: 0px; margin: 0px;" width="58px;"><input id="wE"
									type="text"
									style="width: 58px; height: 39px; border: 0px; margin: 0px;"></td>
								<td>盐酸(克)</td>
								<td style="padding: 0px; margin: 0px;" width="58px;"><input id="yansuan"
									type="text"
									style="width: 58px; height: 39px; border: 0px; margin: 0px;"></td>
							</tr>
							<tr>
								<td>钠(克)</td>
								<td style="padding: 0px; margin: 0px;" width="58px;"><input id="na"
									type="text"
									style="width: 58px; height: 39px; border: 0px; margin: 0px;"></td>
								<td>钙(克)</td>
								<td style="padding: 0px; margin: 0px;" width="58px;"><input id="gai"
									type="text"
									style="width: 58px; height: 39px; border: 0px; margin: 0px;"></td>
								<td>铁(克)</td>
								<td style="padding: 0px; margin: 0px;" width="58px;"><input id="tie"
									type="text"
									style="width: 58px; height: 39px; border: 0px; margin: 0px;"></td>
								<td>胆固醇(克)</td>
								<td style="padding: 0px; margin: 0px;" width="58px;"><input
									id="danguchun" type="text"
									style="width: 58px; height: 39px; border: 0px; margin: 0px;"></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" id="submitInfor" class="btn btn-primary"
						onclick="savefoodnutrition()">保存修改</button>
					<button type="button" id="closeModal" class="btn btn-default"
						data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 添加食物 -->
	<div class="modal fade" id="addfoodModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width: 700px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">添加食物</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="name">食物名称</label><input type="text"
							class="form-control" id="foodname">
					</div>
					<div class="form-group">
						<label for="name">参考用量(克)</label><input type="text"
							class="form-control" id="foodquantity">
					</div>

					<div class="form-group">
						<label for="name">食物种类:</label> <select class="form-control"
							id="material">
						</select>
					</div>
					<table class="table table-bordered">
						<caption>每100克所含各元素分量</caption>
						<tbody>
							<tr>
								<td>能量(千焦)</td>
								<td style="padding: 0px; margin: 0px;"><input
									id="nengliang" type="text"
									style="width: 58px; height: 39px; border: 0px; margin: 0px;"></td>
								<td>水分(克)</td>
								<td style="padding: 0px; margin: 0px;"><input id="water"
									type="text"
									style="width: 58px; height: 39px; border: 0px; margin: 0px;"></td>
								<td>蛋白质(克)</td>
								<td style="padding: 0px; margin: 0px;"><input
									id="danbaizhi" type="text"
									style="width: 58px; height: 39px; border: 0px; margin: 0px;"></td>
								<td>脂肪(克)</td>
								<td style="padding: 0px; margin: 0px;"><input id="zhifang"
									type="text"
									style="width: 58px; height: 39px; border: 0px; margin: 0px;"></td>
							</tr>
							<tr>
								<td>膳食纤维(克)</td>
								<td style="padding: 0px; margin: 0px;"><input id="xianwei"
									type="text"
									style="width: 58px; height: 39px; border: 0px; margin: 0px;"></td>
								<td>碳水化合物(克)</td>
								<td style="padding: 0px; margin: 0px;"><input id="tanshui"
									type="text"
									style="width: 58px; height: 39px; border: 0px; margin: 0px;"></td>
								<td>维生素A(克)</td>
								<td style="padding: 0px; margin: 0px;"><input id="wA"
									type="text"
									style="width: 58px; height: 39px; border: 0px; margin: 0px;"></td>
								<td>维生素B1(克)</td>
								<td style="padding: 0px; margin: 0px;"><input id="wB1"
									type="text"
									style="width: 58px; height: 39px; border: 0px; margin: 0px;"></td>
							</tr>
							<tr>
								<td>维生素B2(克)</td>
								<td style="padding: 0px; margin: 0px;"><input id="wB2"
									type="text"
									style="width: 58px; height: 39px; border: 0px; margin: 0px;"></td>
								<td>维生素C(克)</td>
								<td style="padding: 0px; margin: 0px;"><input id="wC"
									type="text"
									style="width: 58px; height: 39px; border: 0px; margin: 0px;"></td>
								<td>维生素E(克)</td>
								<td style="padding: 0px; margin: 0px;"><input id="wE"
									type="text"
									style="width: 58px; height: 39px; border: 0px; margin: 0px;"></td>
								<td>盐酸(克)</td>
								<td style="padding: 0px; margin: 0px;"><input id="yansuan"
									type="text"
									style="width: 58px; height: 39px; border: 0px; margin: 0px;"></td>
							</tr>
							<tr>
								<td>钠(克)</td>
								<td style="padding: 0px; margin: 0px;"><input id="na"
									type="text"
									style="width: 58px; height: 39px; border: 0px; margin: 0px;"></td>
								<td>钙(克)</td>
								<td style="padding: 0px; margin: 0px;"><input id="gai"
									type="text"
									style="width: 58px; height: 39px; border: 0px; margin: 0px;"></td>
								<td>铁(克)</td>
								<td style="padding: 0px; margin: 0px;"><input id="tie"
									type="text"
									style="width: 58px; height: 39px; border: 0px; margin: 0px;"></td>
								<td>胆固醇(克)</td>
								<td style="padding: 0px; margin: 0px;"><input
									id="danguchun" type="text"
									style="width: 58px; height: 39px; border: 0px; margin: 0px;"></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" id="submitInfor" class="btn btn-primary"
						onclick="savefood()">添加食物</button>
					<button type="button" id="closeModal" class="btn btn-default"
						data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>

</body>
<script>
	$(function() {
		$("#showyyinfoModal input").blur(function() {
			var v = $(this).val();
			if (isNaN(v))
				alert('请输入正确的数值!');
		})
	})
	$("#foodtable")
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
						toolbar : "#toolbar",
						url : "/food/getallfood",
						pageNumber : 1,
						pageSize : 5,
						pageList : [ 5, 10, 15 ],
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
								},
								{
									field : "foodquantity",
									title : "参考用量",
									align : "center",
									valign : "middle",
									editable : {
										type : 'text',
										title : '参考用量',
										validate : function(v) {
											if (isNaN(v))
												return '请输入正确的数值!';
										},
									}
								},
								{
									field : "materialid",
									title : "类别",
									align : "center",
									valign : "middle",
									editable : {
										type : 'select',
										title : '食物类别',
										source : function() {
											var result = [];
											$
													.ajax({
														url : '/food/getmaterial',
														async : false,
														success : function(data) {
															for (var i = 0; i < data.data.length; i++) {
																result
																		.push({
																			value : data.data[i].id,
																			text : data.data[i].materialname
																		});
															}
														}
													});
											return result;
										}
									}
								},
								{
									field : "operate",
									title : "操作",
									align : "center",
									valign : "middle",
									formatter : function operate(value, row,
											index) {
										return '<button type="button" class="btn btn-default btn-sm" onclick="fooddetail(\''
												+ row.id
												+ '\')"> <span class="glyphicon glyphicon-align-justify"></span> 营养信息</button>&nbsp;&nbsp;<button type="button" class="btn btn-default btn-sm" onclick="onremove(\''
												+ row.id
												+ '\')"> <span class="glyphicon glyphicon-remove"></span> 删除食材</button>'
									}
								} ],
						onEditableSave : function(field, row, oldValue, $el) {
							$.ajax({
								type : "post",
								url : "/food/modifyfood",
								data : row,
								success : function(data) {
									if (data.status == 200) {
										alert(data.msg);
									}
								},
							});
						}
					})
	function onremove(id) {
		isDel = window.confirm("确定删除此条数据？");
		if (isDel == true) {
			$.ajax({
				url : "/food/delfood/" + id,
				async : false,
				success : function(data) {
					if (data.status == 200) {
						$("#foodtable").bootstrapTable('remove', {
							field : 'id',
							values : [ parseInt(id) ]
						});
						alert(data.msg);
					} else {
						alert(data.msg);
					}
				}
			});
		}
	};
	/*获取某一种食物的营养成分*/
	function fooddetail(id) {
		$.ajax({
			url : "/food/getfoodnutrition/" + id,
			async : false,			
			success : function(data) {
				if (data.data != null) {
					$("#showyyinfoModal #foodnutritionid").val(data.data[0].id);
					$("#showyyinfoModal #nengliang").val(data.data[0].energy);
					$("#showyyinfoModal #water").val(data.data[0].watercontent);
					$("#showyyinfoModal #danbaizhi").val(data.data[0].protein);
					$("#showyyinfoModal #zhifang").val(data.data[0].fat);
					$("#showyyinfoModal #xianwei").val(data.data[0].dietaryfiber);
					$("#showyyinfoModal #tanshui").val(data.data[0].carbohydrate);
					$("#showyyinfoModal #wA").val(data.data[0].vitaminsa);
					$("#showyyinfoModal #wB1").val(data.data[0].vitaminsb1);
					$("#showyyinfoModal #wB2").val(data.data[0].vitaminsb2);
					$("#showyyinfoModal #wC").val(data.data[0].vitaminsc);
					$("#showyyinfoModal #wE").val(data.data[0].vitaminse);
					$("#showyyinfoModal #yansuan").val(data.data[0].niacin);
					$("#showyyinfoModal #na").val(data.data[0].na);
					$("#showyyinfoModal #gai").val(data.data[0].calcium);
					$("#showyyinfoModal #tie").val(data.data[0].iron);
					$("#showyyinfoModal #danguchun").val(data.data[0].cholesterol);
					$("#showyyinfoModal").modal();
				} else
					alert("获取数据出错!");
			}
		})
	}
	/*保存修改过的某一种食物的营养成分*/
	function savefoodnutrition() {
		isSave = window.confirm("确定修改?");
		if (isSave == true) {
			$.ajax({
				url : "/food/modifyfoodnutrition",
				async : false,
				type : "post",
				data : {
					foodnutritionid : $("#showyyinfoModal #foodnutritionid").val(),
					nengliang : $("#showyyinfoModal #nengliang").val(),
					water : $("#showyyinfoModal #water").val(),
					danbaizhi : $("#showyyinfoModal #danbaizhi").val(),
					zhifang : $("#showyyinfoModal #zhifang").val(),
					xianwei : $("#showyyinfoModal #xianwei").val(),
					tanshui : $("#showyyinfoModal #tanshui").val(),
					wA : $("#showyyinfoModal #wA").val(),
					wB1 : $("#showyyinfoModal #wB1").val(),
					wB2 : $("#showyyinfoModal #wB2").val(),
					wC : $("#showyyinfoModal #wC").val(),
					wE : $("#showyyinfoModal #wE").val(),
					yansuan : $("#showyyinfoModal #yansuan").val(),
					na : $("#showyyinfoModal #na").val(),
					gai : $("#showyyinfoModal #gai").val(),
					tie : $("#showyyinfoModal #tie").val(),
					danguchun : $("#showyyinfoModal #danguchun").val(),
				},
				success : function(data) {
					alert(data.msg);
				}
			})

		}
	}
	/*点击添加食物按钮时*/
	function addfood(){
		$("#material").empty();
		$("#material").append("<option>请选择</option>");
		$.ajax({
			url : "/food/getmaterial",
			asnyc : false,
			success : function(data) {
				if (data.status == 200) {
					for (var i = 0; i < data.data.length; i++) {
						var option = "<option value=" + data.data[i].id + ">"
								+ data.data[i].materialname + "</option>";
						$("#material").append(option);
					}
				}
			}
		});
		$("#addfoodModal").modal();
	}
	/*确定添加食物时*/
	function savefood(){
		isSave = window.confirm("确定添加该食物?");
		if (isSave == true) {
			$.ajax({
				url : "/food/addfood",
				async : false,
				type : "post",
				data : {
					foodname:$("#foodname").val(),
					foodquantity:$("#foodquantity").val(),
					materialid:$("#material").find("option:selected").val(),					
					nengliang : $("#addfoodModal #nengliang").val(),
					water : $("#addfoodModal #water").val(),
					danbaizhi : $("#addfoodModal #danbaizhi").val(),
					zhifang : $("#addfoodModal #zhifang").val(),
					xianwei : $("#addfoodModal #xianwei").val(),
					tanshui : $("#addfoodModal #tanshui").val(),
					wA : $("#addfoodModal #wA").val(),
					wB1 : $("#addfoodModal #wB1").val(),
					wB2 : $("#addfoodModal #wB2").val(),
					wC : $("#addfoodModal #wC").val(),
					wE : $("#addfoodModal #wE").val(),
					yansuan : $("#addfoodModal #yansuan").val(),
					na : $("#addfoodModal #na").val(),
					gai : $("#addfoodModal #gai").val(),
					tie : $("#addfoodModal #tie").val(),
					danguchun : $("#addfoodModal #danguchun").val(),
				},
				success : function(data) {
					alert(data.msg);
				}
			})
		}		
	}
</script>
</html>