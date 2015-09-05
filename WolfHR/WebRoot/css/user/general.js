function onLoad() {
	try {
		transformView();
	} catch (ex) {
	}
	init();
	menu();
	loadIFrameContent();
}

function submitButton(linkType) {
	var functionNameObj = document.getElementById("functionName");
	if (!functionNameObj) functionNameObj = document.getElementsByName("functionName")[0];
	if (functionNameObj) functionNameObj.value = linkType;
	try {
		saveFrame();
	} catch (ex) { }
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

function link_onclick(linkType, indexId) {
	content_onclick("d" + indexId);
	submitButton(linkType);
}
