// JavaScript Document
$(window).bind("scroll",function(){
		if( $(document).scrollTop() + $(window).height() > $(document).height() - 600 ){			
             $(".mouse_down_a").css("display","none");
		}
		else{
			$(".mouse_down_a").css("display","block");}
	});
	
function zc_return_top(){
			$(document).scrollTop(0);
		}
var zc_return_top_time_timer = setInterval("zc_return_top_time()",500);
function zc_return_top_time(){
	var zc_return_top_time_scrolltop = $(document).scrollTop();
	var zc_return_top_time_window = parseInt($(window).height()/3);
	if	(zc_return_top_time_scrolltop > zc_return_top_time_window){
		$(".zc_return_top").css("display","block");
		//$("#buy").css("display","block");
		//$("#Social").css("display","block");
	}else{
		$(".zc_return_top").css("display","none");
		//$("#buy").css("display","block");
		//$("#Social").css("display","block");
	}
}

function skua_scroll(scroll_target_name,salt,scroll_target_time){
	
	$('html,body').stop(true,false).animate({
		"scrollTop":$(scroll_target_name).offset().top-salt},scroll_target_time
	);
	return false;
};