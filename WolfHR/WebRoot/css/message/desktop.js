var initFlg = true;
var imagePathtemp="";

function onLoad() {
	init();
	menu();
	//取得当前画面的高度
	getcontentHeight();
	//取得画面数据
	getPageData();
	initFlg= false;
}

//取得当前画面的高度
function getcontentHeight() {
	document.getElementById("Content").style.height = document.body.clientHeight-20;
}

window.noresize = getcontentHeight;

function getObj(functionid) {
	var divAry = document.getElementsByTagName("DIV");
	for (var i = 0; i < divAry.length; i++) {
		var obj = divAry[i];
		if (obj.className != "DesktopBlock") continue;
		if (obj.id == null) continue;
		if (obj.id == functionid) return obj;
	}
	return null;
}

function minMode(modeId) {
	if (initFlg) return true;
	var thisEle = getObj(modeId);
	if (thisEle == null) return false;
	if (thisEle.minflg == "1") return revertMode(modeId);
	if (!minModeConfirm()) return true;
	thisEle.minflg = "1";
	document.getElementById(modeId + "Min").src = revertImg;
	thisEle = document.getElementById(modeId + "MAX");
	if (thisEle != null) {
		thisEle.style.display = "none";
	}
	try {
		var buffalo = new Buffalo(endPointTop);
	        buffalo.remoteCall("desktopService.saveDesktop", [userId, modeId, 1], function(reply) {
	            reply.getResult();
	        });
	} catch (ex) {
	}
}

function revertMode(modeId) {
	if (initFlg) return true;
	var thisEle = getObj(modeId);
	if (thisEle == null) return false;
	document.getElementById(modeId + "Min").src = minImg;
	thisEle.setAttribute("minflg", "0");
	thisEle = document.getElementById(modeId + "MAX");
	if (thisEle != null) {
		thisEle.style.display = "";
	}
	try {
		var buffalo = new Buffalo(endPointTop);
	        buffalo.remoteCall("desktopService.saveDesktop", [userId, modeId, 0], function(reply) {
	            reply.getResult();
	        });
	} catch (ex) {
	}
}

function closeMode(modeId) {
	if (initFlg) return true;
	var thisEle = getObj(modeId);
	if (thisEle == null) return false;
	if (closeModeConfirm()) {
		thisEle.parentNode.removeChild(thisEle);
		try {
			var buffalo = new Buffalo(endPointTop);
		        buffalo.remoteCall("desktopService.saveDesktop", [userId, modeId], function(reply) {
		            reply.getResult();
		        });
		} catch (ex) {
		}
	}
}

function initDesktop() {
	if (initFlg) return true;
	document.actForm.style.height = document.body.clientHeight;
	var allId = ";";
	var subS = ";";
	var rightS = ";";
	var minS = ";";
	var i = 0;
	var objAry = document.getElementsByTagName("DIV");
	while (objAry.length > i) {
		var thisEle = objAry[i];
		if (thisEle.className == "DesktopBlock") {
			if (thisEle.style.visibility == "hidden") {
				thisEle.parentNode.removeChild(thisEle);
				continue;
			}
			if (allId.indexOf(";" + thisEle.id + ";") == -1) {
				allId += thisEle.id + ";";
				if (thisEle.parentNode.id == "sub") {
					subS += thisEle.id + ";";
				} else {
					rightS += thisEle.id + ";";
				}
			}
			var minflg = thisEle.getAttribute("minflg");
			if (minflg && minflg == "1") minS += thisEle.id + ";";
		}
		i++;
	}
	saveDesktop(subS, rightS, minS);
}

function saveDesktop(subS, rightS, minS) {
	try {
		var buffalo = new Buffalo(endPointTop);
	        buffalo.remoteCall("desktopService.saveDesktop", [userId, subS, rightS, minS], function(reply) {
	            reply.getResult();
	        });
	} catch (ex) {
	}
}
