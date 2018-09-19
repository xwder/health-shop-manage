
//为导出功能设置数据源
function setExportDataAttr() {
    $(".export-csv").attr("data-table","#resulttable");
    $(".export-tsv").attr("data-table","#resulttable");
    $(".export-pdf").attr("data-table","#resulttable");
    $(".export-png").attr("data-table","#resulttable");
    $(".export-excel").attr("data-table","#resulttable");
    $(".export-xlsx").attr("data-table","#resulttable");
    $(".export-doc").attr("data-table","#resulttable");
    $(".export-powerpoint").attr("data-table","#resulttable");
    $(".export-txt").attr("data-table","#resulttable");
    $(".export-xml").attr("data-table","#resulttable");
    $(".export-sql").attr("data-table","#resulttable");
    $(".export-json").attr("data-table","#resulttable");

    $(".export-csv").attr("data-filename","export");
    $(".export-tsv").attr("data-filename","export");
    $(".export-pdf").attr("data-filename","export");
    $(".export-png").attr("data-filename","export");
    $(".export-excel").attr("data-filename","export");
    $(".export-xlsx").attr("data-filename","export");
    $(".export-doc").attr("data-filename","export");
    $(".export-powerpoint").attr("data-filename","export");
    $(".export-txt").attr("data-filename","export");
    $(".export-xml").attr("data-filename","export");
    $(".export-sql").attr("data-filename","export");
    $(".export-json").attr("data-filename","export");
};

setExportDataAttr();
