
(function(jQuery){
    $.confirm = function(confirJson){
		$("a").each(function(){
			if($(this).text()=="删除"){
				$(this).unbind("click");
				$(this).bind("click",function(){
					confirJson.callback();
					return window.confirm(confirJson.message);
				});
			}
		});
	}
})(jQuery);

(function (jQuery){
		   $.confirm = function (Json){
			   }
		   
		   
		   
})(jQuery)