//对页面底部的状态栏的操作。主要是每隔5分钟取一次在线用户数，及用户定义网址等功能的轮流显示等。

var resizeOldWidth;
var showLeftMenuFlg = true;


function onLoad() {
	getOnlineUsers();
	
	//取得左侧菜单原有宽度
	resizeOldWidth = parent.document.getElementById("resize").cols;
	if (resizeOldWidth == "0, *") resizeOldWidth = "175,*";
}

//取得用户数
function getOnlineUsers() {
	try {
		var buffalo = new Buffalo(endPointTop);
	        buffalo.remoteCall("desktopService.getOnlineUserCount", [], function(reply) {
	            var str = reply.getResult();
				document.getElementById("onlineUserNum").innerHTML = "&nbsp;" + str + "&nbsp;";
	        });
	} catch (ex) {
		alert(ex.message);
	}
	//每5分钟刷新一次
	setTimeout("getOnlineUsers()", 1000 * 60 * 10);
}

//打开便笺画面，便于用户录入
function openText() {
	
}


//更改左侧菜单显示方式
function changeLeftMenu() {
	var resizeObj = parent.document.getElementById("resize");
	if (showLeftMenuFlg) {
		resizeObj.cols = "0, *";
		document.getElementById("leftMenu").src = hiddenImg;
		document.getElementById("leftMenu").alt = title_menu_expand;
	} else {
		resizeObj.cols = "180, *";
		document.getElementById("leftMenu").src = showImg;
		document.getElementById("leftMenu").alt = title_menu_folded;
	}
	showLeftMenuFlg = !showLeftMenuFlg;
}
