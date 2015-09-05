var sendDocDataUseFlg = false;
function onLoad() {
	var returnedValue = checkCloseWindow();
	if (!returnedValue) {
		init();
		loadIFrameContent();
	}
	try {
		var sendDocData = document.getElementsByName("sendDocData")[0];
		if(sendDocData) sendDocData.value = "";
	} catch (ex) {
	}
	awokeSettingLoad();
}

function submitButton(linkType) {
	if (sendDocDataUseFlg) {
		try {
			var sendDocData = document.getElementsByName("sendDocData")[0];
			if(sendDocData) sendDocData.value = "";
		} catch (ex) {
		}
	}
	var functionName = document.getElementsByName("functionName")[0];
	functionName.value = linkType;
	try {
		saveFrame();
	} catch (ex) {
	}	
	document.all.actForm.submit();
}

function saveFrame() {
	try {
		var html = eWebEditor.getHTML ();
		var hostAdd = window.location.protocol + "//" + window.location.host;
		var findSite = html.indexOf(hostAdd);
		while(findSite > -1) {
			html = html.substring(0, findSite) + html.substring(findSite + hostAdd.length);
			findSite = html.indexOf(hostAdd);
		}
		document.all.contentMemo.value = html;
	} catch(ex){}
//	if (document.HTMLEditor != null) save();
	if (document.all("TANGER_OCX") != null) savedoc();
}

function save() {
}

//判断当前窗口是否需要关闭
function checkCloseWindow() {
	var functionNameObj = document.getElementsByName("functionName")[0];
	if (functionNameObj == null) return false;
	var functionName = functionNameObj.value;
	if (functionName.indexOf("^^") > -1) {
		functionNameObj.value = "";
		if (opener != null) {
			if (opener.document.actForm.functionName != null) {
				opener.document.actForm.functionName.value = functionName.substring(2);
			}
			if (document.homeForm.alertMsg.value != "") opener.alert(document.homeForm.alertMsg.value);
			document.homeForm.alertMsg.value = "";
			opener.document.actForm.submit();
		}
		window.close();
		return true;
	}
	return false;
}
