var fileHrefBaseValue = null;
var addressHrefBaseValue = null;
var leftPoint = (screen.availWidth - 790) * 0.5;
var topPoint = (screen.availHeight - 670) * 0.5;

function desktop_openWin(url, pWidth, pHeight, winName) {
	var varOption = "toolbar=no,location=no,status=yes,menubar=no,resizable=yes,scrollbars=yes,"
		+ "width=" + pWidth + ",height=" + pHeight + ",left=" + leftPoint + ",top=" + topPoint;
	if(!winName) winName = "showMsg";
	window.open(url, winName, varOption);
}

//网上调查--查看投票
function actViewVotting(indexId) {
	if (indexId == "") return;
	var url = document.getElementById('viewVotting').href + "?indexId=" + indexId;
	desktop_openWin(url, 800, 600);
}

//网上调查--投票
function actSubmitVotting(indexId, btnObj) {
	var s = ";";
	var detailAry = document.getElementsByName("vottingOption");
	for (var i = 0; i < detailAry.length; i++) {
		var obj = detailAry[i];
		if (obj.checked) s += obj.value + ";";
	}
	if (s == ";") {
		alert(plsVotting);
		return false;
	}
	for (var i = 0; i < detailAry.length; i++) {
		var obj = detailAry[i];
		obj.disabled = true;
	}
	var url = document.getElementById('submitVotting').href + "?indexId=" + indexId + "&detailList=" + s;
	desktop_openWin(url, 800, 600);
    btnObj.disabled = true;
}

//通讯录查询
function actAddressQueryBtn() {
	var obj = document.getElementById('addressQuery');
	if(!obj) return false;
	var queryNameObj = document.getElementById('addressQuery_name');
	var queryCompanyObj = document.getElementById('addressQuery_company');
	var queryName = queryNameObj ? queryNameObj.value : "";
	var queryCompany = queryCompanyObj ? queryCompanyObj.value : "";
	if (addressHrefBaseValue == null) addressHrefBaseValue = obj.href;
	obj.href = addressHrefBaseValue + "?queryName=" + encodeURI(queryName) + "&queryCompany=" + encodeURI(queryCompany);
	document.location = obj.href;
}

//下载文件
function downloadFile2(fileId) {
	var obj = document.getElementById('fileDownload');
	if(!obj) return false;
	if (fileHrefBaseValue == null) fileHrefBaseValue = obj.href;
	obj.href = fileHrefBaseValue + "?RECORDID=" + fileId;
//	obj.click();
	document.location = obj.href;
}

//更多按钮、快捷方式
function actMoreBtn(urlValue, urlName) {
	if (urlValue == null) return false;
	if (urlValue == 'actOasp1903') {
	    urlValue = 'actOasp1903_1';	
	} else if (urlValue == 'Oasp1213') {
	    urlValue = 'actOasp1213_1';		
    }
	parent.menu.actionPage("DE_" + urlValue, urlName);
}

// lihao 20120625 不允许打开多个审批单 strart
//打开消息类
function actionMsg(msgId) {
	if (msgId == "") return;
	var imgObj = document.getElementById("newImg" + msgId);
    var linkTypeObj = document.getElementById("linktype" + msgId);
	if (imgObj != null) imgObj.parentNode.removeChild(imgObj);
    if (linkTypeObj && linkTypeObj.value.startsWith('trace')) {
        win = window.open("", "traceWindow", "");
        if (win.location.href == "about:blank") {
            //窗口不存在
	var url = document.getElementById('msgQuery').href + "?RECORDID=" + msgId + "&TYPE=MSG";
            desktop_openWin(url, 800, 600, "traceWindow");
            refreshMode("FUNC00001");
        } else {
            //窗口以已经存在了
            alert("当前已经存在打开的审批单，请先关闭审批窗口后才能够打开新的审批单继续审批。");
            win.focus();
        }
    } else {
        var url = document.getElementById('msgQuery').href + "?RECORDID=" + msgId + "&TYPE=MSG";
	desktop_openWin(url, 800, 600);
	refreshMode("FUNC00001");
    }
}
// lihao 20120625 不允许打开多个审批单 end

//打开消息类 
function actionMsgMsg(msgId, w, h) {
	if (msgId == "") return;
	var imgObj = document.getElementById("newImg" + msgId);
	if (imgObj != null) imgObj.parentNode.removeChild(imgObj);
	var url = document.getElementById('msgQuery').href + "?RECORDID=" + msgId + "&TYPE=MSG";
	desktop_openWin(url, w, h);
	refreshMode("FUNC00001");
}

//打开邮件
function actionMail(msgId) {
	if (msgId == "") return;
	var imgObj = document.getElementById("newImg" + msgId);
	if (imgObj != null) imgObj.parentNode.removeChild(imgObj);
	var url = document.getElementById('msgQuery').href + "?RECORDID=" + msgId + "&TYPE=MailMessage";
	desktop_openWin(url, 800, 600);
}

//打开通讯录
function actAddress(addressId) {
	if (addressId == "") return;
	var url = document.getElementById('msgQuery').href + "?RECORDID=" + addressId + "&TYPE=Address";
	desktop_openWin(url, 800, 600);
}

//打开今日工作安排
function getTodayWork(calendarDetailId) {
	if (calendarDetailId == "") return;
	var url = document.getElementById('msgQuery').href + "?RECORDID=" + calendarDetailId + "&TYPE=CalendarDetail";
	desktop_openWin(url, 800, 600);
}

//打开审批
function actionTrace(indexId) {
	if (indexId == "") return;
    var varOption = "toolbar=no,location=no,status=yes,menubar=no,resizable=yes,scrollbars=yes,width="
    		 + screen.availWidth + ",height=" + screen.availHeight + ",left=" + leftPoint + ",top=" + topPoint;
    win = window.open("", "traceWindow", varOption);
    if (win.location.href === "about:blank") {
        //窗口不存在
        return window.open(document.getElementById('msgQuery').href + "?RECORDID=" + indexId + "&TYPE=TraceInstanceIndex", "traceWindow", varOption);
    } else {
        //窗口以已经存在了
        alert("当前已经存在打开的审批单，请先关闭审批窗口后才能够打开新的审批单继续审批。");
        win.focus();
    }
}

//打开挂网公文
function actionViewIssueTraceDocument(documentId) {
	if (documentId == "") return;
    var varOption = "toolbar=no,location=no,status=yes,menubar=no,resizable=yes,scrollbars=yes,width="
    		 + screen.availWidth + ",height=" + screen.availHeight + ",left=" + leftPoint + ",top=" + topPoint;
    window.open(document.getElementById('msgQuery').href + "?RECORDID=" + documentId + "&TYPE=ViewIssueTraceDocument", "showMsg", varOption);
}

//打开会议
function actMeeting(indexId) {
	if (indexId == "") return;
	var url = document.getElementById('msgQuery').href + "?RECORDID=" + indexId + "&TYPE=MeetingIndex";
	desktop_openWin(url, 800, 600);
}

//打开论坛
function actForumArticleIndex(indexId) {
	if (indexId == "") return;
	var url = document.getElementById('msgQuery').href + "?RECORDID=" + indexId + "&TYPE=ForumArticleIndex";
	desktop_openWin(url, 800, 600);
}

//打开工作计划
function actWORK(indexId) {
	if (indexId == "") return;
	var url = document.getElementById('msgQuery').href + "?RECORDID=" + indexId + "&TYPE=WORK";
	desktop_openWin(url, 800, 600);
}

//打开我的考试
function actMyExamination(indexId) {
	if (indexId == "") return;
	var url = document.getElementById('msgQuery').href + "?RECORDID=" + indexId + "&TYPE=MyExamination";
	desktop_openWin(url, 800, 600);
}

//打开培训提醒
function actTrainingRemind(indexId) {
	if (indexId == "") return;
	var url = document.getElementById('msgQuery').href + "?RECORDID=" + indexId + "&TYPE=TrainingRemind";
	desktop_openWin(url, 800, 600);
}

//打开生日提醒
function actBirthday(indexId) {
	if (indexId == "") return;
	var url = document.getElementById('msgQuery').href + "?RECORDID=" + indexId + "&TYPE=Birthday";
	
	desktop_openWin(url, 800, 600);
}

function actTrainingRemind2(indexId) {
	if (indexId == "") return;
	var url = document.getElementById('msgQuery').href + "?RECORDID=" + indexId + "&TYPE=TrainingRemind2";
	location.href(url);
}

//----------- 部门门户 ---------
// 部门栏目：部门发文库
function actionDeptSendDocument(indexId) {
	if (indexId == "") return;
	var url = document.getElementById('companyTraceHandout').href + "?RECORDID=" + indexId + "&TYPE=MeetingIndex";
	desktop_openWin(url, 800, 600);
}

// 部门栏目：部门收文库
function actionDeptReceiveDocument(indexId) {
	if (indexId == "") return;
	var url = document.getElementById('companyTraceHandout').href + "?RECORDID=" + indexId + "&TYPE=MeetingIndex";
	desktop_openWin(url, 800, 600);
}

// 部门门户自定义栏目
function actionDeptCustomcolumn(indexId) {
	if (indexId == "") return;
	var url = document.getElementById('deptCustomColumn').href + "?RECORDID=" + indexId;
	desktop_openWin(url, 800, 600);
}

//----------- 公司门户 ----------
// 公司栏目：发文
function actionCompanySendDocument(indexId) {
	if (indexId == "") return;
	var url = document.getElementById('companyTraceHandout').href + "?RECORDID=" + indexId + "&TYPE=MeetingIndex";
	desktop_openWin(url, 800, 600);
}

// 公司栏目：收文
function actionCompanyReceiveDocument(indexId) {
	if (indexId == "") return;
	var url = document.getElementById('companyTraceHandout').href + "?RECORDID=" + indexId + "&TYPE=MeetingIndex";
	desktop_openWin(url, 800, 600);
}

// 公司栏目：通知公告
function actionCompanyNotice(indexId) {
	if (indexId == "") return;
	var url = document.getElementById('companyTraceHandout').href + "?RECORDID=" + indexId + "&TYPE=MeetingIndex";
	desktop_openWin(url, 800, 600);
}

// 公司栏目：党群新闻
function actionCompanyDQNews(indexId) {
	if (indexId == "") return;
	var url = document.getElementById('companyTraceHandout').href + "?RECORDID=" + indexId + "&TYPE=MeetingIndex";
	desktop_openWin(url, 800, 600);
}

// 公司栏目：待开会议
function actionCompanyMeeting(indexId) {
	if (indexId == "") return;
	var url = document.getElementById('companyTraceHandout').href + "?RECORDID=" + indexId + "&TYPE=MeetingIndex";
	desktop_openWin(url, 800, 600);
}

//----------------------------
// 部门自定义栏目-“更多”按钮
function actDeptCustomColumnMoreBtn(functionId) {
	var obj = document.getElementById('deptColumnMore');
	if (fileHrefBaseValue == null) fileHrefBaseValue = obj.href;
	obj.href = fileHrefBaseValue + "?FUNCTIONID=" + functionId;
//	obj.click();
	document.location = obj.href;
}

//------------------------------
// 公司栏目
function actCompanyColumnMoreBtn(functionId) {
	var obj = document.getElementById('companyColumnMore');
	if (fileHrefBaseValue == null) fileHrefBaseValue = obj.href;
	obj.href = fileHrefBaseValue + "?FUNCTIONID=" + functionId;
//	obj.click();
	document.location = obj.href;
}

//-----------------------------
// 二级栏目
function actionPortalGroup(indexId, urlvalue, urlname) {
	if (indexId == "") return;

	if (isCompanyColumn(indexId + "MAX")) {
		// 公司栏目
		actCompanyColumnMoreBtn(indexId);
		return;
	}
	
	if (indexId.charAt(0) == 'D') {
		// 部门栏目
		actDeptCustomColumnMoreBtn(indexId + "MAX");
		return;
	}
	
	if (urlvalue && urlvalue != "") {
		actMoreBtn(urlvalue, urlname);
		return;
	}
	var url = document.getElementById('msgQuery').href + "?RECORDID=" + indexId + "&TYPE=PortalGroup";
	desktop_openWin(url, 800, 600, "showMsg1");
}

//截取字符串长度   
//dealStr要截取的字符串   
//maxLength 截取的长度
function widthCheck(dealStr, maxLength){   
        if(!maxLength){   
            maxLength = 20;   
        }   
        if(dealStr==null||dealStr.length<1){   
            return ["", ""];   
        }   
        var w = 0;//字符串长度，一个汉字长度为2   
        var s = 0;//汉字个数   
        var p = false;//判断字符串当前循环的前一个字符是否为汉字   
        var b = false;//判断字符串当前循环的字符是否为汉字   
        var nameSub;   
        for (var i=0; i<dealStr.length; i++) {   
           if(i>1 && b==false){   
                p = false;   
           }   
           if(i>1 && b==true){   
                p = true;   
           }   
           var c = dealStr.charCodeAt(i);   
           //单字节加1   
           if ((c >= 0x0001 && c <= 0x007e) || (0xff60<=c && c<=0xff9f)) {   
                w++;   
                b = false;   
           }else {   
                w+=2;   
                s++;   
                b = true;   
           }   
           if(w>maxLength && i<=dealStr.length-1){   
                if(b==true && p==true){   
                    nameSub = dealStr.substring(0,i-2)+"...";   
                }   
                if(b==false && p==false){   
                    nameSub = dealStr.substring(0,i-3)+"...";   
                }   
                if(b==true && p==false){   
                    nameSub = dealStr.substring(0,i-2)+"...";   
                }   
                if(p==true){   
                    nameSub = dealStr.substring(0,i-2)+"...";   
                }   
                break;   
           }   
        }   
        if(w<=maxLength){   
            return [dealStr, ""];   
        }   
        return nameSub;   
    }

//个人考勤
  function actionAttendance(attendanceType, recordId) {
     if (recordId == "") return;
	 var obj = document.getElementById('attendance');
	 if(!obj) return false;
	 if (addressHrefBaseValue == null) addressHrefBaseValue = obj.href;
	 obj.href = addressHrefBaseValue + "?attendanceType=" + attendanceType + "&recordId=" + recordId;
	 document.location = obj.href;
  }

//部门主页--文章浏览
function actDeptHomePageIndex(indexId) {
	if (indexId == "") return;
	var url = document.getElementById('viewDeptBlogPage').href + "?indexId=" + indexId;
	desktop_openWin(url, 800, 600);
}

