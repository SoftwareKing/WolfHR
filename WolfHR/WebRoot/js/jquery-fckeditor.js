(function(jQuery){
	$.fckeditor = function(name){
		var oFCKeditor = new FCKeditor(name);
		oFCKeditor.BasePath	= "fckeditor/" ;
		oFCKeditor.ToolbarSet = "simple";
		oFCKeditor.ReplaceTextarea() ;
	}
})(jQuery);
