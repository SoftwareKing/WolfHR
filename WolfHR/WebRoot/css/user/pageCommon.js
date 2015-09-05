//******************************************************
// USER NAME			大连华天
// SYSTEM NAME		OA8000
// SUB SYSTEM NAME	COMMON COMPONENT
// FILE NAME			pageCommon.js
/**
* 窗口隐含域处理
* @AUTHOR	sissi
* @VERSION 	2004.10.18 新建
*/
//******************************************************
// 20120116 lihao 画面加载时保存加载时间
var gamenInitTime = null;

function init() {
    // 20120116 lihao 画面加载时保存加载时间
    gamenInitTime = new Date().getTime();
    if(window.opener) self.focus();
	setTopTitle();
	showAlert();
	showConfirm();
	openNewWindow();
	openNewUrl();
	writeCookie("");
	writeQuickIdeaDefault();
	getFrameHeight();
	window.inerror = false;
	var functionNameObj = document.getElementById("functionName");
	if (!functionNameObj) functionNameObj = document.getElementsByName("functionName")[0];
	if (functionNameObj != null && opener != null) {
		if (functionNameObj.value == "^^0509CLOSE") {
			functionNameObj.value = "";
			opener.document.actForm.submit();
			window.close();
			return true;
		}
		//个人设置保存后关闭弹出窗口
		if (functionNameObj.value == "^^1205CLOSE") {
			functionNameObj.value = "";
			window.close();
			return true;
		}
		if (functionNameObj.value == "^^SwfUploadCLOSE") {
			functionNameObj.value = "";
			window.close();
			return true;
		}
	}
}

function menu() {
	st_onload();
}

//******************************************************
/**
* 初使化窗口时，根据父窗口传的值设置窗口标题
*/
//******************************************************
function setTopTitle() {
	if (document.homeForm.topTitle.value != "") {
		top.document.title = document.homeForm.topTitle.value;
	}
}

function showAlert() {
	if (document.homeForm.alertMsg.value != "") {
		alert(document.homeForm.alertMsg.value);
		document.homeForm.alertMsg.value = "";
	}
}

function openNewUrl() {
	if (document.homeForm.newUrl.value != "") {
		openUrl(document.homeForm.newUrl.value);
		document.homeForm.newUrl.value = "";
	}
}

function openUrl(urlStr) {
	window.open(urlStr, 'newWindow',
			   'toolbar=yes,location=yes,directories=yes,status=yes,menubar=yes,scrollbars=yes,resizable=yes');
}

function openNewWindow() {
	if (document.homeForm.newWindow.value != "") {
	    var varOption = "toolbar=no,location=no,status=yes,menubar=no,resizable=yes,scrollbars=yes,width=" + screen.availWidth + ",height=" + screen.availHeight + ",left=0,top=0";
	    window.open(document.homeForm.newWindow.value, 'autoOpenWin', varOption);
	    document.homeForm.newWindow.value = "";
	}
}

function showConfirm() {
	if (document.homeForm.confirmMsg.value != "") {
		if (confirm(document.homeForm.confirmMsg.value)) {
    			document.homeForm.submit();
		}
		document.homeForm.confirmMsg.value = "";
	}
}

function openWindow(url, pWidth, pHeight, winName) {
	if(!url) return null;
	var winWidth = window.screen.availWidth; 
	var winHeight = window.screen.availHeight;
	if(!pWidth) pWidth = winWidth;
	if(!pHeight) pHeight = winHeight;
	var pleft = (winWidth - pWidth) / 2;
	if(pleft < 1) {
		pleft = 0;
		pWidth = winWidth;
	}
	var ptop = (winHeight - pHeight) / 2;
	if(ptop < 1) {
		ptop = 1;
		pHeight = winHeight;
	}
	var varOption = "dependent,toolbar=no,location=no,status=yes,menubar=no,resizable=no,scrollbars=yes,"
				+ "width=" + pWidth + "px,height=" + pHeight + "px,left=" + pleft + "px,top=" + ptop + "px;";
	if(winName == null) winName = "newWindow"; 
    // lihao 20120625 不允许打开多个审批单 strart
    win = window.open("", winName, varOption);
    if (winName == "traceWindow") {
        if (win.location.href === "about:blank") {
            //窗口不存在
	return  window.open(url, winName, varOption);
        } else {
            //窗口以已经存在了
            alert("当前已经存在打开的审批单，请先关闭审批窗口后才能够打开新的审批单继续审批。");
            win.focus();
        }
    } else {
        return window.open(url, winName, varOption);
    }
    // lihao 20120625 不允许打开多个审批单 end
}

//******************************************************
/**
* 输入框内的提示文字显示与设置
*/
//******************************************************
function inputAreaClick(inputElement, showText) {
	if (inputElement.value == showText) {
		inputElement.value = "";
	}
	inputElement.select;
}

function inputAreaBlur(inputElement, showText) {
	if (inputElement.value == "") {
		inputElement.value = showText;
	}
}

function writeCookie(str) {
	var expdate = new Date();
	SetCookie("oaDesktop", str, expdate, "/");
}

function SetCookie (nameValue, valueValue) {
	var argv = SetCookie.arguments;
	var argc = SetCookie.arguments.length;
	var expires = (argc > 2) ? argv[2] : null;
	var path = (argc > 3) ? argv[3] : null;
	var domain = (argc > 4) ? argv[4] : null;
	var secure = (argc > 5) ? argv[5] : false;
	document.cookie = nameValue + "=" + escape (valueValue) +
		((expires == null) ? "" : ("; expires=" + expires.toGMTString())) +
		((path == null) ? "" : ("; path=" + path)) +
		((domain == null) ? "" : ("; domain=" + domain)) +
		((secure == true) ? "; secure" : "");
}

//打印
function printDOC() {
	var hkey_root,hkey_path,hkey_key;
	hkey_root="HKEY_CURRENT_USER";
	hkey_path="\\Software\\Microsoft\\Internet Explorer\\PageSetup\\";
	try{
	  var RegWsh = new ActiveXObject("WScript.Shell") ;
	  hkey_key="header" ;
	  RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"") ;
	  hkey_key="footer" ;
	  RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"") ;
	  }
	 catch(e){}
	window.print();
}
//打印按钮
function printBtn() {
	document.all.WEB_PVX.printing.Print(true);
//	window.print();
}

//打印预览
function privewDOC() {
	var hkey_root,hkey_path,hkey_key;
	hkey_root="HKEY_CURRENT_USER";
	hkey_path="\\Software\\Microsoft\\Internet Explorer\\PageSetup\\";
	try{
	  var RegWsh = new ActiveXObject("WScript.Shell") ;
	  hkey_key="header" ;
	  RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"") ;
	  hkey_key="footer" ;
	  RegWsh.RegWrite(hkey_root+hkey_path+hkey_key,"") ;
	  }
	 catch(e){}
	var obj = document.all.WebBrowser;
 	obj.ExecWB(7,1);
}

//打印预览按钮
function privewBtn() {
	var printObj = document.getElementById("WEB_PVX");
	try {
		var printViewModelSetObj = document.getElementById("printViewModelSet");
		if(printViewModelSetObj) {
			var setObj = jsonToObject(printViewModelSetObj.value);
			if(setObj != null) {
				if(setObj.portrait != null) printObj.printing.portrait = setObj.portrait == "ZX"; //横向 false; 纵向 true;
			}
		}
	} catch(e) {}
//  printObj.printing.header = "This is 页眉";
//    printObj.printing.footer = "Printing by ScriptX This is 页脚";
//    printObj.printing.portrait = false;		//横向 false; 纵向 true;
//    printObj.printing.leftMargin = 5.0;
//    printObj.printing.topMargin = 50.0;
//    printObj.printing.rightMargin = 5.0;
//    printObj.printing.bottomMargin = 5.0;
    printObj.printing.Preview(); 
}

function writeQuickIdeaDefault() {
	var ideaTextObj = $("ideaText");
	var quickIdeaListObj = $("quickIdeaList");
	if (quickIdeaListObj == null || ideaTextObj == null) return ;
    //add 赵健 审批表单时，审批页面带有快捷意见，例如，选择了快捷意见，并做修改，点【保存】按钮后，无效。修改的意见，保存不上 start
    if (ideaTextObj.value != "") return;
    //add 赵健 审批表单时，审批页面带有快捷意见，例如，选择了快捷意见，并做修改，点【保存】按钮后，无效。修改的意见，保存不上 end
    if (quickIdeaListObj.length == 0) return ;
	var count = document.all.quickIdeaList.length;
	for (var i = 0; i < count; i++) {
		if (quickIdeaListObj.options[i].value == 1) {
			ideaTextObj.value = quickIdeaListObj.options[i].text;
			quickIdeaListObj.selectedIndex = i;
			break;
		}
	}
}

function writeQuickIdea() {
	var ideaTextObj = $("ideaText");
	var quickIdeaListObj = $("quickIdeaList");
	if (quickIdeaListObj == null || ideaTextObj == null) return ;
	var selectedItem = quickIdeaListObj.selectedIndex;
	if (selectedItem == -1) return ;
	if (quickIdeaListObj.value == "WONoSelectionString") {
		ideaTextObj.value = '';
	} else {
		ideaTextObj.value = quickIdeaListObj.options[selectedItem].text;
	}
}

function showQueryArea() {
	var queryAreaObj = $("queryArea");
	var quickQueryStateObj = $("quickQueryState");
	queryAreaObj.style.display = "none";
	quickQueryStateObj.value = "display:none";
	if (queryAreaObj.style.display == "none") {
		queryAreaObj.style.display = "";
		quickQueryStateObj.value = "";
	}
}

function getFrameHeight() {
	var obj = $("msgFrame");
	if (obj == null || obj.style == undefined) return;
	var formHeight = document.body.clientHeight;
	obj.style.height = formHeight - 210;
	obj = $("bgImg");
	if (obj != null && obj.style != undefined) {
		obj.width = document.body.clientWidth;
		obj.height = document.body.clientHeight;
	}
}

window.onresize = getFrameHeight

var hrefBaseValue = null;

//编辑器文件下载
function downloadFile(downloadSrc, uploadFileName) {
	var obj = document.getElementById("downloadLnk");
	if (hrefBaseValue == null) hrefBaseValue = obj.href;
	obj.href = hrefBaseValue + "?downloadSrc=" + downloadSrc + "&fileName=" + encodeURI(uploadFileName);
	obj.target = "_blank";
	obj.click();

}

//对于HTML编辑部品，打开窗口画面
function openW(elementName){
	if (eWebEditor == null) return;
	eWebEditor.dialogOpen_formInsert(elementName);
}

//替换字符串中全部包含内容
function replaceStr(str, findKey, replaceKey) {
	if (str == null || findKey == null) return str;
	var site = str.indexOf(findKey);
	while (site > -1) {
		str = str.substring(0, site) + replaceKey + str.substring(site + findKey.length);
		site = str.indexOf(findKey);
	}
	return str;
}

//去除主机地址
function removeLocationAddress(html) {
	var hostAdd = window.location.protocol + "//" + window.location.host;
	var findSite = html.indexOf(hostAdd);
	while(findSite > -1) {
		html = html.substring(0, findSite) + html.substring(findSite + hostAdd.length);
		findSite = html.indexOf(hostAdd);
	}
	return html;
}

//***********************************
// 一些通用 方法
//***********************************

//创建下拉列表的一个子项
function createOption(s, txt, v) {
	if(!s || s.options == null) return ;
	if (txt == null && v == null) return ;
	v = v == null ? txt : v;
	s.options.add(new Option(txt, v));
}

// 基本信息提示，得到焦点并选定
function baseAlert(theText, notice){
	if(notice) alert(notice);
	try {
		theText.focus();
		theText.select();
	} catch(e) {}
	return false;
}

//获取页面对象
var $ = function(id) {
	var obj = document.getElementById(id);
	if(obj) return obj;
	obj = document.getElementsByName(id)[0];
	return obj;
};
/*
function content_onclick(objId) {
	var obj = document.getElementById(objId);
	if(!obj) return false;
	var others = obj.parentNode.children;
       	for (var i = 0; i < others.length; i++) {
		var ClickTrObj = others[i];
		ClickTrObj.className ="TableDetail2";
		ClickTrObj.children[0].children[0].checked=false;
	    }
    	obj.className = "selectLine";
	obj.children[0].children[0].checked=true;
	// var currentIndex = objId.substring(1, objId.length);
	// var currentTrCheckBoxObj = document.actForm.checkBox[parseInt(currentIndex) + 1];
	// var hasCheckedFlg = (currentTrCheckBoxObj.checked == true);
	//currentTrCheckBoxObj.checked = true;
	// var lastClickTrObj = document.getElementById("d" + lastclickid);
	//if(!lastClickTrObj) {
	//	lastclickid = currentIndex;
	//	return false;
	//}
	// var lastTrCheckBoxObj = document.actForm.checkBox[parseInt(lastclickid) + 1];
    //if(!hasCheckedFlg) lastTrCheckBoxObj.checked = false;
	//lastClickTrObj.className = lastclickid %2 == 0 ? "TableDetail2" : "TableDetail1";
	//lastclickid = currentIndex;
}
*/
//点击行
function content_onclick(objId) {
	//行对象
	var obj = document.getElementById(objId);
	if(!obj) return ;
	//复选框数组
	var boxObjAry = document.getElementsByName("checkBox");
	if (boxObjAry == null || boxObjAry.length == 0) return;
	var currentIndex = objId.substring(1, objId.length);
	if(lastclickid == currentIndex) return ;
    obj.className = "selectLine";
	var currentTrCheckBoxObj = boxObjAry[parseInt(currentIndex) + 1];
	var hasCheckedFlg = false;
	if (currentTrCheckBoxObj) {
		hasCheckedFlg = (currentTrCheckBoxObj.checked);
		currentTrCheckBoxObj.checked = true;
	}
	var lastClickTrObj = document.getElementById("d" + lastclickid);
	if(!lastClickTrObj) {
		lastclickid = currentIndex;
		return ;
	}
	lastClickTrObj.className = lastclickid %2 == 0 ? "TableDetail2" : "TableDetail1";
	var lastTrCheckBoxObj = boxObjAry[parseInt(lastclickid) + 1];
	if (lastTrCheckBoxObj && !hasCheckedFlg) lastTrCheckBoxObj.checked = false;
	lastclickid = currentIndex;
}

//上次选择的行号
var lastclickid = -1;

//点击全选
function checkAll() {
	var checkBoxObjAry = document.getElementsByName("checkBox");
	var count = checkBoxObjAry.length;
	var selectAllObj = $("selectAll");
	var selectAllFlg = false;
	if(selectAllObj) selectAllFlg = selectAllObj.checked;
	for (var i = 0; i < count; i++) {
		checkBoxObjAry[i].checked = selectAllFlg;
	}
	var lastClickTrObj = document.getElementById("d" + lastclickid);
	if(!lastClickTrObj) return ;
	lastClickTrObj.className = lastclickid %2 == 0 ? "TableDetail2" : "TableDetail1";
	lastclickid = -1;
}

function loadIFrameContent() {
	var frameSectionObj = document.getElementById("frameSection");
	if (frameSectionObj == null) return;
	var frmValueObj = document.getElementById("frmValue");
	if (frmValueObj == null) return;
	var obj = document.frames["frameSection"].document;
	obj.open();
	obj.write(frmValueObj.value);
}

//给页面OnLoad增加执行方法
function addLoadEvent(func) {
	if (document.all) { //IE浏览器分支
		window.attachEvent("onload", func);
	} else {  //非IE浏览器分支
		window.addEventListener("load", func, false);
	}
}

//******************************************
//		提醒设置		BGN
//******************************************

function awokeSettingLoad() {
	var changeObj = "";
	var popUpSelect = "";
	var sectIndex = "";
	var state1 = "";
	var state2 = "";
	var obj1 = "";
	var obj2 = "";
	try {
		if(document.all.beforeCheck.checked){
			changeObj = document.getElementById("beforeSetting");
			changeObj.style.display = "";	
			
		        popUpSelect = document.getElementById("beforeSelect");	
			sectIndex = popUpSelect.selectedIndex;
			if (sectIndex == 0) {
				state1 = "none";
				state2 = "none";
			} else if (sectIndex == 1) {
				state1 = "";
				state2 = "none";
			} else if (sectIndex == 2) {
				state1 = "none";
				state2 = "";
			}
			obj1 = document.getElementById("before1");
			obj2 = document.getElementById("before2");
			obj1.style.display = state1;		
			obj2.style.display = state2;			
		}
	} catch(ex) {
	}
	try {
		if(document.all.endCheck.checked){
			changeObj = document.getElementById("endSetting");
			changeObj.style.display = "";	
				
		        popUpSelect = document.getElementById("endSelect");	
			sectIndex = popUpSelect.selectedIndex;
			if (sectIndex == 0) {
				state1 = "none";
				state2 = "none";
			} else if (sectIndex == 1) {
				state1 = "";
				state2 = "none";
			} else if (sectIndex == 2) {
				state1 = "none";
				state2 = "";
			}
			obj1 = document.getElementById("end1");
			obj2 = document.getElementById("end2");
			obj1.style.display = state1;		
			obj2.style.display = state2;			
		}
	} catch(ex) {
	}
	try {
		if(document.all.beyondCheck.checked){
			changeObj = document.getElementById("beyondSetting");
			changeObj.style.display = "";		
				
		        popUpSelect = document.getElementById("beyondSelect");	
			sectIndex = popUpSelect.selectedIndex;
			if (sectIndex == 0) {
				state1 = "none";
				state2 = "none";
			} else if (sectIndex == 1) {
				state1 = "";
				state2 = "none";
			} else if (sectIndex == 2) {
				state1 = "none";
				state2 = "";
			}
			obj1 = document.getElementById("beyond1");
			obj2 = document.getElementById("beyond2");
			obj1.style.display = state1;		
			obj2.style.display = state2;			
		}
	} catch(ex) {
	}
}

//******************************************
//		提醒设置
//******************************************

function settingChange (categoryName) {
	var checkboxChange = "";
	if (categoryName == "beforeSetting") {
		checkboxChange = document.getElementById("beforeCheck");
	} else if (categoryName == "endSetting") {
		checkboxChange = document.getElementById("endCheck");
	} else if (categoryName == "beyondSetting") {
		checkboxChange = document.getElementById("beyondCheck");
	}
	var playState = "";
	if (checkboxChange.checked) {
		playState = "";	
	} else {
		playState = "none";
	}
	var changeObj = document.getElementById(categoryName);
	changeObj.style.display = playState;		
}

function awokeCategorySelect(awokeCategory) {
	var selectObjName = "";
	var obj1 = "";
	var obj2 = "";
	if (awokeCategory == "before") {
		selectObjName = "beforeSelect";
		obj1 = document.getElementById("before1");
		obj2 = document.getElementById("before2");
	} else if (awokeCategory == "end") {
		selectObjName = "endSelect";
		obj1 = document.getElementById("end1");
		obj2 = document.getElementById("end2");
	} else if (awokeCategory == "beyond") {
		selectObjName = "beyondSelect";
		obj1 = document.getElementById("beyond1");
		obj2 = document.getElementById("beyond2");
	}
	var popUpSelect = document.getElementById(selectObjName);	
	var sectIndex = popUpSelect.selectedIndex;
	var state1 = "";
	var state2 = "";
	if (sectIndex == 0) {
		state1 = "none";
		state2 = "none";
	} else if (sectIndex == 1) {
		state1 = "";
		state2 = "none";
	} else if (sectIndex == 2) {
		state1 = "none";
		state2 = "";
	}
	obj1.style.display = state1;		
	obj2.style.display = state2;			
}

//******************************************
//		提醒设置		END
//******************************************

//在当前页面创建Input节点
function creatInputElement(type, name) {
	//IE浏览器分支   
	if(document.all) return document.createElement("<input type='" + type +"' name='" + name +"'/>" );
	//非IE浏览器分支 
	var inputObj = document.createElement("input");
	inputObj.type = type;
	inputObj.name = name;
	return inputObj;
}

//未设置的返回 ""
function convertUndefinToStr(o) {
	if (typeof(o) == "undefined") return "";
	if (o == null) return "";
	return o;
}

//获得节点页面的显示位置 横坐标
function getObj_OffSetLeft(obj) {
    var set = 0;
	if (obj.offsetParent){
		set += obj.offsetLeft + getObj_OffSetLeft(obj.offsetParent);
	}
	if (obj.tagName.toUpperCase()!= "BODY"){
		var x = parseInt(obj.scrollLeft,10);
		if(!isNaN(x)) set -= x;
	}
    return set;
}

//获得节点页面的显示位置 纵坐标
function getObj_OffSetTop(obj) {
    var set = 0;
	if (obj.offsetParent){
		set += obj.offsetTop + getObj_OffSetTop(obj.offsetParent);
	}
	if (obj.tagName.toUpperCase()!= "BODY"){
		var y = parseInt(obj.scrollTop,10);
		if(!isNaN(y)) set -= y;
	}
    return set;
}

//判断str 是否是 以 findStr 结尾
function endWith(str, findStr) {
	if(str == null || findStr == null || findStr == "") return true;
	findStr += ""; 
	if(str.length < findStr.length) return false;
	str = str.substring((str.length - findStr.length), str.length);
	return str.indexOf(findStr) == 0;
}
//1203专用
function changeCompany(obj) {
	var nIndex = obj.selectedIndex;
	if (nIndex == -1) submitButton('COMPANY');
	if (obj.options[nIndex].text.indexOf("======") == 0) return ;
	submitButton('COMPANY');
}

//转入系统画面
function gotoSystemPage(urlValue, urlName) {
	if (urlValue == null) return ;
	parent.menu.actionPage(urlValue, urlName);
}

//******************************************
//		部门下拉列表设置
//******************************************

	//显示部门选择
//	changDeptShow(deptEmtName);


function changDeptShow(deptEmtName) {
	return false;
	var deptEmt = document.getElementById(deptEmtName);
	if (!deptEmt) return false;
	var deptShowEmt = document.getElementById(deptEmtName + "_showHtml");
	if (!deptShowEmt) return false;
	deptEmt.style.display = "none";
	deptShowEmt.style.display = "none";
	var showValueObj = document.getElementById(deptEmtName + "_showValue");
	if (!showValueObj) {
		showValueObj = document.createElement("Input");
		showValueObj.id = deptEmt.id + "_showValue";
		showValueObj.className = "InputStyle";
		showValueObj.readOnly = true;
		showValueObj.value = deptEmt.item(deptEmt.selectedIndex).text;
		deptEmt.parentNode.appendChild(showValueObj);
		showValueObj.onclick = function () {
			createEdptShowDiv(this);
		}
	}
	return true;
}

//创建部门选择区域
function createEdptShowDiv(deptShowValueObj) {
	var deptEmtId = deptShowValueObj.id.replace("_showValue", "");
	var deptEmt = document.getElementById(deptEmtId);
	if (!deptEmt) return false;
	var deptShowEmt = document.getElementById(deptEmtId + "_showHtml");
	if (!deptShowEmt) return false;

	var deptEmtDivObj = document.getElementById(deptEmtId + "_div");
	if (deptEmtDivObj) deptEmtDivObj.parentNode.removeChild(deptEmtDivObj);

	//区域
	deptEmtDivObj = initDeptShowDiv(deptShowValueObj);
	//内容
	var tableObj = getShowContentTableObj(deptShowEmt);
	deptEmtDivObj.appendChild(tableObj);
	return true;
}

//初始化显示区域
function initDeptShowDiv(deptShowValueObj) {

	var showPageW = 210; //宽度
	var showPageH = 250; //高度
	var Frs = 4;   //影子大小

	/*显示的位置*/
	var Winw = document.body.offsetWidth;
	var Winh = document.body.offsetHeight;
	var scrollTop = document.body.scrollTop;

	showPageW = deptShowValueObj.getBoundingClientRect().right - deptShowValueObj.getBoundingClientRect().left;

	if (showPageW < 180) showPageW = 180;

	var left = deptShowValueObj.getBoundingClientRect().left;
	var top = deptShowValueObj.getBoundingClientRect().bottom + scrollTop;
	if (((left + showPageW + Frs) > Winw) && ((showPageW + Frs) < Winw)) {
		left = Winw - showPageW - Frs;
	}
	if (((scrollTop + Winh + showPageH + Frs) > 2 * Winh) && ((showPageH + Frs) < Winh)) {
		top = 2 * (Winh - showPageH - Frs);
	}
//	if (Winh + scrollTop - top < showPageH) showPageH = Winh + scrollTop - top - 5;
	if (Winh + scrollTop - top < showPageH) {
		if (Winh + scrollTop - top < 150) {
			top = deptShowValueObj.getBoundingClientRect().top + scrollTop - showPageH;
		} else {
			showPageH = Winh + scrollTop - top - 5;
		}
	}

	//区域
	var divObj = document.createElement("div");
	divObj.id = deptShowValueObj.id.replace("_showValue", "_div");
	document.body.appendChild(divObj);


	divObj.style.left = left + "px";
	divObj.style.top = top + "px";
	divObj.style.zIndex = 999;
	divObj.style.width = showPageW + "px";                     
	divObj.style.height = showPageH + "px";
	divObj.style.position = "absolute";
	divObj.style.overflowY = "auto";
	//区域边框
	divObj.style.borderWidth = "1px";
	divObj.style.borderStyle = "solid";
	divObj.style.borderColor = "#91c0e3";
	//区域背景
	divObj.style.background = "#fff";

	divObj.setAttribute("show", "show");
	divObj.style.display = "";

	divObj.onmouseover = function () {
		divObj.setAttribute("show", "show");
	};
	divObj.onmouseout = function () {
		divObj.setAttribute("show", "");
		setTimeout(
			function () {
				if (divObj.getAttribute("show") == "show") return false;
				divObj.style.display = "none";
			},
			1000
		);
	};

	return divObj;
}

function getShowContentTableObj(deptShowEmt) {
	var tableObj = document.createElement("table");
	tableObj.width = "100%";
	var count = deptShowEmt.options.length;
	if (count == 0) return tableObj;
	for (var i = 1; i < count; i++) {
		var eoOpt = deptShowEmt.options[i];
		var parentid = eoOpt.getAttribute("parentdeptid");
		var tr = tableObj.insertRow(i-1);
		tr.height = "18px";
		tr.style.cursor = "pointer";
		tr.style.backgroundColor = "#e4f0f9";
		tr.setAttribute("parentid", parentid);
		tr.setAttribute("deptid", eoOpt.value);
		if (parentid != "0" && parentid != "ROOT") tr.style.display = "none";
		var td = tr.insertCell(0);
		if (hasDownDept(deptShowEmt, eoOpt.value)) {
			td.innerHTML = deptRightImg;
			td.id = eoOpt.value;
			td.setAttribute("show", "");
			td.onclick = function () {
				selectDivShowDownDept(this);
			}
		}
		td = tr.insertCell(1);
		td.innerHTML = eoOpt.text;
		td.setAttribute("value", eoOpt.value)
		td.onclick = function () {
			selectDivShowDept(this);
		}
	}
	return tableObj;
}

//判断此部门是否有下级部门
function hasDownDept(deptShowEmt, deptId) {
	//第一级部门总是打开
	if (deptId == "ROOT") return false;
	var count = deptShowEmt.options.length;
	for (var i = 1; i < count; i++) {
		var eoOpt = deptShowEmt.options[i];
		var parentid = eoOpt.getAttribute("parentdeptid");
		if (parentid == deptId) return true;
	}
	return false;
}

//选择部门显示下级部门
function selectDivShowDownDept(tdObj) {
	var showFlg = (tdObj.getAttribute("show") == "");
	var tdHtml = showFlg ? deptDownImg : deptRightImg;
	var displayStr = showFlg ? "" : "none";
	tdObj.setAttribute("show", showFlg ? "none" : "");
	tdObj.innerHTML = tdHtml;
	var hiddenParentIdStr = ";" + tdObj.id + ";";
	var showTrAry = document.getElementsByTagName("tr");
	var count = showTrAry == null ? 0 : showTrAry.length;
	for (var i = 0; i < count; i++) {
		var trObj = showTrAry[i];
		var parentid = trObj.getAttribute("parentid");
		if (hiddenParentIdStr.indexOf(";" + parentid + ";") == -1) continue;
		trObj.style.display = displayStr;
		if (showFlg) continue;
		//隐藏时把所有子对象都隐藏，并且替换图片
		hiddenParentIdStr += trObj.getAttribute("deptid") + ";";
		if(trObj.firstChild.innerHTML == "") continue;
		trObj.firstChild.innerHTML = deptRightImg;
	}
}

//选择部门
function selectDivShowDept(tdObj) {
	var deptId = tdObj.getAttribute("value");
	var divObj = tdObj.parentNode.parentNode.parentNode.parentNode;
	var depEmtId = divObj.id.substr(0, divObj.id.length - 4);
	var showDeptObj = document.getElementById(depEmtId + "_showValue");
	showDeptObj.value = tdObj.innerHTML;
	var deptEmt = document.getElementById(depEmtId);
	deptEmt.value = deptId;
	try {
		deptEmt.onchange();
	} catch(ex) {}
	if (divObj) divObj.parentNode.removeChild(divObj);
//	divObj.setAttribute("show", "");
//	divObj.style.display = "none";
}

// 20120116 lihao 打开画面中带有链接的onclick方法
function actOpenWindowBtn(linkName,width,height) {
    //调整页面的 URL
    var hrefObj = document.getElementById(linkName);
    var strHrefUrl = hrefObj.href
    // lihao 20120625 不允许打开多个审批单
    openWindow(strHrefUrl, width, height, "traceWindow");
}

/* 
 * 用来遍历指定对象所有的属性名称和值 可以用于调试js代码时使用
 * obj 需要遍历的对象 
 * author: sissi 20120523
 * 
 */ 
function showAllPrpos(obj) { 
    // 用来保存所有的属性名称和值 
    var props = ""; 
    // 开始遍历 
    for(var p in obj){  
        // 方法 
        if(typeof(obj[p])=="function"){  
            obj[p](); 
        }else{  
        if (obj[p] != null)
            // p 为属性名称，obj[p]为对应属性的值 
            props+= p + "=" + obj[p] + "\n"; 
        }  
    }  
    // 最后显示所有的属性 
    prompt("传入对象的属性包括：", props); 
}

/* 
 * 附件部品向父画面显示添加的新的附件
 * fileNameList 要显示的文件名列表数组 
 * author: sissi 20120523
 * 
 */ 
function addFileByAttachment(fileNameList) {
	var obj = document.getElementsByName("FileList")[0];
	if (!obj) return false;
	//删除原来父窗口列表中的子项，需要保留第0项
	while(obj.length > 1) {
		obj.remove(1);
	}
	//如果当前窗口中没有子项，则父窗口的列表不显示
	if (fileNameList.length == 0) {
		obj.style.display = "none";
		return true;
	}
	obj.style.display = "";
	//拷贝当前窗口中的子项到父窗口
	for (var i = 0; i < fileNameList.length; i++) {
		var eItem = document.createElement ("OPTION");
		obj.options.add (eItem);
		eItem.innerHTML = fileNameList[i];
		eItem.value = i;
	}
	return true;
}

