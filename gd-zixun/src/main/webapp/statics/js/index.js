$(function() {
	//我们一开始就隐藏所有的下拉菜单
	$('#dropdown_nav li').find('.sub_nav').hide();

	//当鼠标悬停在主导航链接，我们发现下拉菜单中的相应链接。
	$('#dropdown_nav li').hover(function() {
		$(this).find('.sub_nav').fadeIn(100);
		//$(this).find(".sub_link").addClass("cur");
	}, function() {
		$(this).find('.sub_nav').fadeOut(50);
		//$(this).find(".sub_link").removeClass("cur");
	});
});
function ChgTab(strDivIdBlock,strListIdBlock,strDivStyleBlock,strDivStyleNone,displayNumber,allNumber)
{
    for (var i = 1; i <= allNumber; i++) {
    	document.getElementById(strDivIdBlock + i).className = strDivStyleNone;
		document.getElementById(strListIdBlock + i).style.display = "none";
    }
	document.getElementById(strDivIdBlock + displayNumber).className = strDivStyleBlock;
	document.getElementById(strListIdBlock + displayNumber).style.display = "block";
}

function setContentTab(name, curr, n,cla) {
    for (i = 1; i <= n; i++) {
        var menu = document.getElementById(name + i);
        var cont = document.getElementById("con_" + name + "_" + i);
        menu.className = i == curr ? cla : "";
        if (i == curr) {
            cont.style.display = "block";
            //lazyloadForPart($(cont));
        } else {
            cont.style.display = "none";
        }
    }
}

//导航BEGIN

var TP_menu_popup;
var LSN_menu_popup;

function show(str,obj){
	popupNoClose();

	var w3c=(document.getElementById)? true:false;
	var ns6=(w3c && (navigator.appName=="Netscape"))? true: false;
	var left,top,ele;
	
	if (!ns6){
		var nLt = 0;
		var nTp = 0;
		var offsetParent = obj;
		while (offsetParent!=null && offsetParent!=document.body) {
			nLt += offsetParent.offsetLeft;
			nTp += offsetParent.offsetTop;
			offsetParent=offsetParent.offsetParent;
		}
		left = nLt;
		top = nTp + obj.offsetHeight + 3;
	} else {
		left = obj.offsetLeft;
		top = obj.offsetTop + obj.offsetHeight + 3;
	}
	
	for(var i=1;i<=2;i++)
	{
		document.getElementById("s"+i).style.display = "none";
	}
	ele = document.getElementById("s"+str);
	TP_menu_popup = ele;
	
ele.style.display = "block";
	//ele.style.top = top + "px";
	//ele.style.left = left + "px";
}
function popupClose(){
	LSN_menu_popup = window.setTimeout(function(){
		TP_menu_popup.style.display = "none";
	},100);
}
function popupNoClose(){
	if(LSN_menu_popup) window.clearTimeout(LSN_menu_popup);
}
//导航OVER
var sWeek = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
var dNow = new Date();
var CalendarData = new Array(100);
var madd = new Array(12);
var tgString = "甲乙丙丁戊己庚辛壬癸";
var dzString = "子丑寅卯辰巳午未申酉戌亥";
var numString = "一二三四五六七八九十";
var monString = "正二三四五六七八九十冬腊";
var weekString = "日一二三四五六";
var sx = "鼠牛虎兔龙蛇马羊猴鸡狗猪";
var cYear, cMonth, cDay, TheDate;
CalendarData = new Array(
0xA4B, 0x5164B, 0x6A5, 0x6D4, 0x415B5, 0x2B6, 0x957, 0x2092F, 0x497, 0x60C96,
0xD4A, 0xEA5, 0x50DA9, 0x5AD, 0x2B6, 0x3126E, 0x92E, 0x7192D, 0xC95, 0xD4A,
0x61B4A, 0xB55, 0x56A, 0x4155B, 0x25D, 0x92D, 0x2192B, 0xA95, 0x71695, 0x6CA,
0xB55, 0x50AB5, 0x4DA, 0xA5B, 0x30A57, 0x52B, 0x8152A, 0xE95, 0x6AA, 0x615AA,
0xAB5, 0x4B6, 0x414AE, 0xA57, 0x526, 0x31D26, 0xD95, 0x70B55, 0x56A, 0x96D,
0x5095D, 0x4AD, 0xA4D, 0x41A4D, 0xD25, 0x81AA5, 0xB54, 0xB6A, 0x612DA, 0x95B,
0x49B, 0x41497, 0xA4B, 0xA164B, 0x6A5, 0x6D4, 0x615B4, 0xAB6, 0x957, 0x5092F,
0x497, 0x64B, 0x30D4A, 0xEA5, 0x80D65, 0x5AC, 0xAB6, 0x5126D, 0x92E, 0xC96,
0x41A95, 0xD4A, 0xDA5, 0x20B55, 0x56A, 0x7155B, 0x25D, 0x92D, 0x5192B, 0xA95,
0xB4A, 0x416AA, 0xAD5, 0x90AB5, 0x4BA, 0xA5B, 0x60A57, 0x52B, 0xA93, 0x40E95);
madd[0] = 0; madd[1] = 31; madd[2] = 59; madd[3] = 90;
madd[4] = 120; madd[5] = 151; madd[6] = 181; madd[7] = 212;
madd[8] = 243; madd[9] = 273; madd[10] = 304; madd[11] = 334;
function GetBit(m, n) { return (m >> n) & 1; }
function e2c() {
    TheDate = (arguments.length != 3) ? new Date() : new Date(arguments[0], arguments[1], arguments[2]);
    var total, m, n, k;
    var isEnd = false;
    var tmp = TheDate.getFullYear();
    total = (tmp - 1921) * 365 + Math.floor((tmp - 1921) / 4) + madd[TheDate.getMonth()] + TheDate.getDate() - 38; if (TheDate.getYear() % 4 == 0 && TheDate.getMonth() > 1) { total++; } for (m = 0; ; m++) { k = (CalendarData[m] < 0xfff) ? 11 : 12; for (n = k; n >= 0; n--) { if (total <= 29 + GetBit(CalendarData[m], n)) { isEnd = true; break; } total = total - 29 - GetBit(CalendarData[m], n); } if (isEnd) break; } cYear = 1921 + m; cMonth = k - n + 1; cDay = total; if (k == 12) { if (cMonth == Math.floor(CalendarData[m] / 0x10000) + 1) { cMonth = 1 - cMonth; } if (cMonth > Math.floor(CalendarData[m] / 0x10000) + 1) { cMonth--; } }
}
function GetcDateString() {
    var tmp = "农历"; tmp += tgString.charAt((cYear - 4) % 10);
    tmp += dzString.charAt((cYear - 4) % 12);
    tmp += "年 ";
    if (cMonth < 1) { tmp += "(闰)"; tmp += monString.charAt(-cMonth - 1); } else { tmp += monString.charAt(cMonth - 1); } tmp += "月"; tmp += (cDay < 11) ? "初" : ((cDay < 20) ? "十" : ((cDay < 30) ? "廿" : "三十"));
    if (cDay % 10 != 0 || cDay == 10) { tmp += numString.charAt((cDay - 1) % 10); } return tmp;
}
function GetLunarDay(solarYear, solarMonth, solarDay) {
    if (solarYear < 1921 || solarYear > 2020) {
        return "";
    } else { solarMonth = (parseInt(solarMonth) > 0) ? (solarMonth - 1) : 11; e2c(solarYear, solarMonth, solarDay); return GetcDateString(); }
}
var D = new Date();
var yy = D.getFullYear();
var mm = D.getMonth() + 1;
var dd = D.getDate();
var ww = D.getDay();
var ss = parseInt(D.getTime() / 1000);
function getFullYear(d) {// 修正firefox下year错误   
    yr = d.getYear(); if (yr < 1000)
        yr += 1900; return yr;
}
function showDate() {
    timeString = new Date().toLocaleTimeString();
    var sValue = getFullYear(dNow) + "年" + (dNow.getMonth() + 1) + "月" + dNow.getDate() + "日 "; // + " " + timeString + " "
    sValue += GetLunarDay(yy, mm, dd);
    var svalue1 = getFullYear(dNow) + "年" + (dNow.getMonth() + 1) + "月" + dNow.getDate() + "日";
    var svalue2 = timeString;
    var svalue3 = GetLunarDay(yy, mm, dd);
    var sx2 = sx.substr(dzString.indexOf(svalue3.substr(1, 1)), 1);
    var svalue33 = svalue3.substr(0, 3)
    var svalue333 = svalue33.substr(0, 2) + "(" + sx2 + ")" + svalue33.substr(2, 1);
    var sx22 = "农历" + svalue3.substr(4, 6);
    document.write(sValue);
}
$(function(){
	$("#fbig").click(function(){
		$("#fbox").css("font-size","18px");						  
	});	
	$("#fsma").click(function(){
		$("#fbox").css("font-size","14px")						  
	});
});