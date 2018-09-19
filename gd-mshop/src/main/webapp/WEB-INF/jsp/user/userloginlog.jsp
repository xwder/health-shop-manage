<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<link rel="stylesheet" href="/css/main.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css" media="screen" />
<link rel="stylesheet" type="text/css" href="/css/bootstrap-table.min.css">
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/tendina.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/bootstrap-table.min.js"></script>
<script src="/js/bootstrap-table-zh-CN.js"></script>
 
<body>
	<div>
		<div style="margin-top: 10px; margin-bottom: -44px;" class="btn-group pull-left">
				 
				<button  data-toggle="dropdown" class="btn btn-default btn-sm">
					  <span class="glyphicon glyphicon-circle-arrow-down"></span> 导出数据
				</button>
		          <ul class="dropdown-menu dropdown-light pull-right">
                    <li>
                        <a href="#" class="export-csv">
                            Save as CSV
                        </a>
                    </li>
                    <li>
                        <a href="#" class="export-tsv">
                            Save as TSV
                        </a>
                    </li>
                    <!-- <li>
                        <a href="#" class="export-pdf">
                            Save as PDF
                        </a>
                    </li> -->
                    <li>
                        <a href="#" class="export-png">
                            Save as PNG
                        </a>
                    </li>
                    <li>
                        <a href="#" class="export-excel">
                            Save as XLS
                        </a>
                    </li>
                    <li>
                        <a href="#" class="export-xlsx">
                            Save as XLSX
                        </a>
                    </li>
                    <li>
                        <a href="#" class="export-doc">
                            Save as DOC
                        </a>
                    </li>
                    <!--<li>-->
                    <!--<a href="#" class="export-powerpoint">-->
                    <!--Save as PPT-->
                    <!--</a>-->
                    <!--</li>-->
                    <li>
                        <a href="#" class="export-txt">
                            Save as TXT
                        </a>
                    </li>
                    <li>
                        <a href="#" class="export-xml">
                            Save as XML
                        </a>
                    </li>
                    <li>
                        <a href="#" class="export-sql">
                            Export to SQL
                        </a>
                    </li>
                    <li>
                        <a href="#" class="export-json">
                            Export to JSON
                        </a>
                    </li>
                </ul>
		</div>
		         
		<table id="resulttable" data-toggle="table"
			data-url="/manager/user/loginrecord" data-pagination="true"
			data-striped="true" data-show-refresh="true" data-search="true"
			data-show-Columns="true" data-height="">
			<colgroup>
				<col style="width: 10%;">
				<col style="width: 10%;">
				<col style="width: 20%;">
				<col style="width: 15%;">
				<col style="width: 10%;">
				<col style="width: 20%;">
				<col style="width: 5%;">
			</colgroup>
			<thead style="background-color: #003D79; color: #FFF">
				<tr>
					<th data-field="uid" data-align="center" data-sortable="true">用户ID</th>
					<th data-field="username" data-align="center" data-sortable="true" data-formatter="name">用户名</th>
					<th data-field="logindate" data-align="center" data-sortable="true">登录日期</th>
					<th data-field="loginip" data-align="center" data-sortable="true">登录IP</th>
					<th data-field="strloginstatus" data-align="center" data-sortable="true">登录状态</th>
					<th data-field="loginps" data-align="center" data-sortable="true" data-formatter="name">备注</th>
					<th data-field="" data-align="center" data-formatter="operate" >操作</th>
				</tr>
			</thead>
		</table>
 	</div>
</body>

<script src="/js/CustomExportJs/table.js"></script>
<script src="/js/tableExport/libs/pdfMake/pdfmake.min.js"></script>

<!-- <script type="text/javascript">
document.write("<scr"+"ipt src=\"/js/tableExport/libs/pdfMake/vfs_fonts.js\" language=\"JavaScript\"></sc"+"ript>")
</script> -->

<!-- <script src="/js/tableExport/libs/pdfMake/vfs_fonts.js"></script>
 -->
<script type="text/javascript" src="/js/tableExport/libs/FileSaver/FileSaver.min.js"></script>
<script type="text/javascript" src="/js/tableExport/libs/js-xlsx/xlsx.core.min.js"></script>
<script type="text/javascript" src="/js/tableExport/libs/jsPDF/jspdf.min.js"></script>
<script type="text/javascript" src="/js/tableExport/libs/jsPDF-AutoTable/jspdf.plugin.autotable.js"></script>
<script type="text/javascript" src="/js/tableExport/libs/html2canvas/html2canvas.min.js"></script>
<script type="text/javascript" src="/js/tableExport/tableExport.js"></script>
<script src="/js/CustomExportJs/table-export.js"></script>

<script>
    jQuery(document).ready(function () {
        TableExport.init();
    });
</script>

<script>

	function operate(value, row, index) {
			return '<button type="button" class="btn btn-default btn-sm" onclick="changepw('
			+ ')"> <span class="glyphicon glyphicon-edit"></span>修改密码</button>';
	}
	function name(value, row, index) {
		if (value != null && value.length > 20) {
			return value.substr(0, 20) + "......"
		}
		return value;
	}

	function xiajia(id) {
		$.ajax({
			url : "/manager/item/issell/" + id + "/" + 0,
			async : false,
			success : function(data) {
				if(data.status == 200){
					alert("下架成功！");
					url ="/manager/item/itemlistpage.html";
					//window.location.href=url;
					 $resulttable.bootstrapTable('refresh', {url: '/manager/item/itemlistpage.html'});  
				}else{
					alert("下架失败！");
				}
			}
		});
	}
	function shangjia(id ) {
		$.ajax({
			url : "/manager/item/issell/" + id + "/" + 1,
			async : false,
			success : function(data) {
				 
					if(data.status == 200){
						alert("上架成功！");
						url ="/manager/item/itemlistpage.html";
						window.location.href=url;
					}else{
						alert("商家失败！");
					}
			}
		});
	}
	function edit(id) {
			var url = "/manager/item/getitem/"+ id +".html" ;
			window.location.href=url;
	}
	function changepw() {
			var url = "/manager/user/changepwpage.html" ;
			window.location.href=url;
	}
	
	$("#btn_add").click(function(){
		window.location.href="/manager/item/addpage.html";
	});
	

	function xiangqing(id) {
		var url ="/manager/item/itemdetail/"+id+".html";
		window.location.href=url;
	}
	
	 
	
</script>
</html>
