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
		          <ul class="dropdown-menu dropdown-light pull-right"  style="left:;">
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
			data-url="/manager/record/pbrowselist" data-pagination="true"
			data-striped="true" data-show-refresh="true" data-search="true"
			data-show-Columns="true" data-height="">
			<colgroup>
				<col style="width: 5%;">
				<col style="width: 25%;">
				<col style="width: 5%;">
				<col style="width: 10%;">
				<col style="width: 10%;">
				<col style="width: 10%;">
				<col style="width: 10%;">
				<col style="width: 20%;">
			</colgroup>
			<thead style="background-color: #003D79; color: #FFF">
				<tr>
					<th data-field="pid" data-align="center" data-sortable="true">商品编号</th>
					<th data-field="pname" data-align="center" data-sortable="true" data-formatter="name">商品名称</th>
					<th data-field="browsetime" data-align="center" data-sortable="true">浏览时间</th>
					<th data-field="username" data-align="center" data-sortable="true" data-formatter="name">用户名</th>
					<th data-field="strusertype" data-align="center" data-sortable="true">用户类型</th>
					<th data-field="userip" data-align="center" data-sortable="true">用户IP</th>
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
		var status = row.isSell;
		if(status == 1){
			return '<button type="button" class="btn btn-default btn-sm" onclick="xiajia('
			+ row.id 
			+ ')"> <span class="glyphicon glyphicon-arrow-down"></span>下架</button>&nbsp<button type="button" class="btn btn-default btn-sm" onclick="edit('
			+ row.id  
			+ ')"><span class="glyphicon glyphicon-edit"></span>编辑</button>&nbsp<button type="button" class="btn btn-default btn-sm" onclick="xiangqing('
			+ row.id  
			+ ')"><span class="glyphicon glyphicon-edit"></span>详情预览 </button>';
		}
		if(status == 0){
			return '<button type="button" class="btn btn-default btn-sm" onclick="shangjia('
			+ row.id 
			+ ')"> <span class="glyphicon glyphicon-arrow-up"></span>上架</button>&nbsp<button type="button" class="btn btn-default btn-sm" onclick="edit('
			+ row.id  
			+ ')"><span class="glyphicon glyphicon-edit"></span>编辑</button>&nbsp<button type="button" class="btn btn-default btn-sm" onclick="xiangqing('
			+ row.id  
			+ ')"><span class="glyphicon glyphicon-edit"></span>详情预览</button>';
		}
	}
	function name(value, row, index) {
		if (value != null && value.length > 20) {
			return value.substr(0, 26) + "......"
		}
		return value;
	}

	 
	 
	
</script>
</html>
