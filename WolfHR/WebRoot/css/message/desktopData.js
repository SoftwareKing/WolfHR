//刷新某个画面的数据
function refreshMode(modeId) {
	var thisEle = getObj(modeId);
	if (thisEle == null) return false;
	if (thisEle.getAttribute("minflg") == "1") revertMode(modeId);
	var str = ";";
	var blockObjAry = new Array();
	blockObjAry.push(thisEle);
	var count = thisEle.getAttribute("recordcount");
	if (count == undefined) count = 0;	
	str += thisEle.getAttribute("functionid") + "|" + count + ";";
	try {
		var buffalo = new Buffalo(endPointTop);
	        buffalo.remoteCall("desktopService.getAllData", [str, userId, deptId, systemSend, languageStr, noSubject], function(reply) {
	            var dataAry = reply.getResult();
	            writeBlock(dataAry, blockObjAry);
	        });
	} catch (ex) {
	}
}

//取得画面数据
function getPageData() {
	//取得当前画面上全部的块
	var divAry = document.getElementsByTagName("DIV");
	//每个模块取值
	for (var i = 0; i < divAry.length; i++) {
		if (divAry[i].className != "DesktopBlock") continue;
		if (divAry[i].id != null) {
			refreshMode(divAry[i].id);
		}
	}
	//全部一次性取值
/*
	var str = ";";
	var blockObjAry = new Array();
	for (var i = 0; i < divAry.length; i++) {
		if (divAry[i].className != "DesktopBlock") continue;
		if (divAry[i].id != null) {
			blockObjAry.push(divAry[i]);
			str += divAry[i].id + "|" + divAry[i].recordcount + ";";
		}
	}
	if (str == ";") return false;
	try {
		var buffalo = new Buffalo(endPointTop);
	        buffalo.remoteCall("desktopService.getAllData", [str, userId, deptId, systemSend, languageStr, noSubject], function(reply) {
	            var dataAry = reply.getResult();
	            writeBlock(dataAry, blockObjAry);
	        });
	} catch (ex) {
	}
*/
}

//取出每个块对象及数据数组
function writeBlock(dataAry, blockObjAry) {
	if (dataAry == null || dataAry.length == 0) return false;
	for (var i = 0; i < blockObjAry.length; i++) {
		obj = blockObjAry[i];
		var foundFlg = false;
		var j = 0; 
		while (j < dataAry.length) {
			var functionid = dataAry[j++];
			var blockDataAry = dataAry[j++];
			if (functionid == obj.getAttribute("functionid")) {
				writeBlockData(blockDataAry, obj);
				foundFlg = true;
			}
		}
		if (!foundFlg) writeBlockData(new Array(), obj);
	}
}

//根据functionid转向不同写数据的方法体内
function writeBlockData(blockDataAry, blockObj) {
	var functionid = blockObj.getAttribute("functionid");
	//取出写数据的区域
	var obj = document.getElementById(functionid + "MAX");
	if(!obj) return false;
	obj.setAttribute("recordcount", blockObj.getAttribute("recordcount") );
	obj.setAttribute("urlvalue", blockObj.getAttribute("urlvalue"));
	obj.setAttribute("urlname", blockObj.getAttribute("urlname"));
    //短消息
    if ("FUNC00001" == functionid) {
        return writeMsg(blockDataAry, obj);
    }
    //已收文件
    if ("FUNC00002" == functionid) {
        return writeMsg(blockDataAry, obj);
    }
    //通知
    if ("FUNC00003" == functionid) {
        return writeMsg(blockDataAry, obj);
    }
    //公告
    if ("FUNC00004" == functionid) {
        return writeMsg(blockDataAry, obj);
    }
    //新闻
    if ("FUNC00005" == functionid) {
        return writeMsg(blockDataAry, obj);
    }
    //常用网址
    if ("FUNC00006" == functionid) {
        return writeUserTools(blockDataAry, obj);
    }
    //公司格言
    if ("FUNC00007" == functionid) {
        return writeCompanyAdage(blockDataAry[0], obj);
    }
    //网上调查
    if ("FUNC00008" == functionid) {
        return writeVotting(blockDataAry, obj);
    }
    //最新上传文件
    if ("FUNC00009" == functionid) {
        return writeFile(blockDataAry, obj);
    }
    //快捷方式
    if ("FUNC00010" == functionid) {
        return writeQuick(blockDataAry, obj);
    }
    //待办提醒
    if ("FUNC00012" == functionid) {
        return writeAwoke(blockDataAry, obj);
    }
    //绩效考核
    if ("FUNC00027" == functionid) {
        return writePreformance(blockDataAry, obj);
    }
    //个人考勤
    if ("FUNC00030" == functionid) {
        return writeAttendance(blockDataAry, obj);
    }
    //通讯录查询
    if ("FUNC00013" == functionid) {
        return writeAddressQuery(blockDataAry, obj);
    }
    //邮件
    if ("FUNC00014" == functionid) {
        return writeMail(blockDataAry, obj);
    }
    //个人通讯录
    if ("FUNC00015" == functionid) {
        return writeAddress(blockDataAry, obj);
    }
    //公司通讯录
    if ("FUNC00016" == functionid) {
        return writeAddress(blockDataAry, obj);
    }
    //公共通讯录
    if ("FUNC00017" == functionid) {
        return writeAddress(blockDataAry, obj);
    }
    //今日工作安排
    if ("FUNC00018" == functionid) {
        return writeTodayWork(blockDataAry, obj);
    }
    //待我审批
    if ("FUNC00019" == functionid) {
        return writeWaitTrace(blockDataAry, obj);
    }
    //工作计划
    if ("FUNC00020" == functionid) {
        return writeWorkPlan(blockDataAry, obj);
    }
    //我的考试
    if ("FUNC00028" == functionid) {
        return writeMyExamination(blockDataAry, obj);
    }
    //培训提醒
    if ("FUNC00029" == functionid) {
        return writeTrainingRemind(blockDataAry, obj);
    }
    //生日提醒
    if ("FUNC00031" == functionid) {
        return writeBirthday(blockDataAry, obj);
    }
    //电子期刊
    if ("FUNC00021" == functionid) {
        return writeEBook(blockDataAry, obj);
    }
    //我的会议
    if ("FUNC00023" == functionid) {
        return writeMeeting(blockDataAry, obj);
    }
    //论坛
    if ("FUNC00024" == functionid) {
        return writeForum(blockDataAry, obj);
    }
    //桌面新闻
    if ("FUNC00025" == functionid) {
        return writePictureNews(blockDataAry, obj);
    }
    //天气预报
    if ("FUNC00026" == functionid) {
        return writeWeather(blockDataAry, obj);
    }
    //部门主页
    if ("FUNC00028" == functionid) {
        return writeDeptHomePage(blockDataAry, obj);
    }
    //公司值班表
    if ("FUNC00027" == functionid) {
        return writeOnDuty(blockDataAry, obj);
    }
    //公司栏目：发文库
    if ("FUNC10000" == functionid) {
    	return writeCompanySendDocument(blockDataAry, obj);
    }
    
    //公司栏目：收文库
    if ("FUNC10001" == functionid) {
    	return writeCompanyReceiveDocument(blockDataAry, obj);
    }

    //公司栏目：通知公告
    if ("FUNC10002" == functionid) {
    	return writeCompanyNotice(blockDataAry, obj);
    }
    
    //公司栏目：党群新闻
    if ("FUNC10003" == functionid) {
    	return writeCompanyDQNews(blockDataAry, obj);
    }
    
    //公司栏目：待开会议
    if ("FUNC10004" == functionid) {
    	return writeCompanyMeeting(blockDataAry, obj);
    }
    
    //部门栏目：部门发文库
    if ("FUNC11000" == functionid) {
    	return writeDeptSendDocument(blockDataAry, obj);
    }
    
    //部门栏目：部门收文库
    if ("FUNC11001" == functionid) {
    	return writeDeptReceiveDocument(blockDataAry, obj);
    }
    
    if ("FUNC10006" == functionid) {
    	obj.recordcount = 8;
        return writeMyTask(blockDataAry, obj);
    }    
    
    //挂网公文
    if ("FUNC00032" == functionid) {
    	return writeIssueTraceDocument(blockDataAry, obj);
    }
    
    // 部门自定义栏目
    if (functionid.charAt(0) == 'D') {
    	return writeDeptCustomColumn(blockDataAry, obj);
    }

	// 二级栏目    
    if (functionid.charAt(0) == 'G') {
    	return writePortalGroup(blockDataAry, obj);
    }
}

// 二级栏目
function writePortalGroup(blockDataAry, obj) {
	var str	 = "<DIV ID=BlockDetail>\n";
	str 	+= "<ul>\n";
	for (var i = 0; i < blockDataAry.length; i++) {
		var record = blockDataAry[i];
		
		str	+= "<LI class='DetailLine'>\n";
		str += "<DIV CLASS=DetailLineInfo>";
		str	+= "<img border=0 width=8 height=8 src='" + listImg + "'> ";
		var msgTitle = record.msg_title;
		str += "<a onClick=\"actionPortalGroup('" + record.function_id + "', '" + record.urlvalue + "', '" + record.urlname + "');\" href=\"#\">" + msgTitle + "</a>";
		str += "</DIV>\n";
		str	+= "</LI>\n";
	}
	if (blockDataAry.length < 3) {
		str += "<LI class='EndDetailLine'><DIV></DIV></LI>\n";
	}
	str 	+= "</ul>\n";
	str 	+= "</DIV>\n";
	str 	+= writeFoot(0, obj);
	obj.innerHTML = str;
	obj.style.padding = 0;
}
//张佳斌修改2010-1-28
//部门栏目：部门收文库
function writeDeptReceiveDocument(blockDataAry, obj){
	//取出当前记录数及最大记录数
	var currentrecordcount = blockDataAry.length;
	var maxrecordcount = obj.getAttribute("recordcount");
	//如果当前记录数少于最大记录数，计算出空行数量
	var blankCount = 0;
	if (currentrecordcount < maxrecordcount) blankCount = maxrecordcount - currentrecordcount;
	//写信息块的主体数据，写时要注意两个问题：1、最后一行与前面行的CSS不同；2、空行的处理
	var str	 = "<DIV ID=BlockDetail>\n";
	str 	+= "<ul>\n";
	for (var i = 0; i < currentrecordcount; i++) {
		var record = blockDataAry[i];
		var cssName;
		if (blankCount > 0) {
			cssName = "DetailLine";
		} else {
			cssName = (i + 1) == currentrecordcount ? "EndDetailLine" : "DetailLine";
		}
		str	+= "<LI class=" + cssName + ">\n";
		str += "<DIV CLASS=DetailLineInfo>";
		str	+= "<img border=0 width=8 height=8 src='" + listImg + "'> ";	
		str += "<a onClick=\"actionDeptReceiveDocument('" + record.trace_handout_id + "');\" href=\"#\">" + getTopFlag(record) + record.trace_title + "</a>";
		
		var handoutDate = new Date(record.handout_date);
		var deadDate = new Date(handoutDate);
		deadDate.setDate(deadDate.getDate()+1); 
		var tDate = new Date();
		//设置是否显示new图标
		if(Date.parse(deadDate) - Date.parse(tDate)>=0){
			str += " <img id='newImg" + record.msg_id + "' border=0 src='" + newImg + "'>";
		}
		
		str += "</DIV>\n";
		str += "<DIV CLASS=DetailLineTime>" + (handoutDate.getMonth()+1) +"-"+ handoutDate.getDate() + "</DIV>\n";
//		str += "<DIV CLASS=DetailLineName>" + record.handout_user + "</DIV>\n";
		str	+= "</LI>\n";
	}
	if (blankCount > 0) {
		for (var i = 0; i < blankCount; i++) {
			var cssName = (i + 1) == blankCount ? "EndDetailLine" : "DetailLine";
			str += "<LI class=" + cssName + "><DIV></DIV></LI>\n";
		}
	}
	str 	+= "</ul>\n";
	str 	+= "</DIV>\n";
	str 	+= writeFoot(blankCount, obj);
	obj.innerHTML = str;
	obj.style.padding = 0;
}

//张佳斌修改2010-1-28
//部门栏目：部门发文库
function writeDeptSendDocument(blockDataAry, obj) {
	//取出当前记录数及最大记录数
	var currentrecordcount = blockDataAry.length;
	var maxrecordcount = obj.getAttribute("recordcount");
	//如果当前记录数少于最大记录数，计算出空行数量
	var blankCount = 0;
	if (currentrecordcount < maxrecordcount) blankCount = maxrecordcount - currentrecordcount;
	//写信息块的主体数据，写时要注意两个问题：1、最后一行与前面行的CSS不同；2、空行的处理
	var str	 = "<DIV ID=BlockDetail>\n";
	str 	+= "<ul>\n";
	for (var i = 0; i < currentrecordcount; i++) {
		var record = blockDataAry[i];
		var cssName;
		if (blankCount > 0) {
			cssName = "DetailLine";
		} else {
			cssName = (i + 1) == currentrecordcount ? "EndDetailLine" : "DetailLine";
		}
		str	+= "<LI class=" + cssName + ">\n";
		str += "<DIV CLASS=DetailLineInfo>";
		str	+= "<img border=0 width=8 height=8 src='" + listImg + "'> ";
		str += "<a onClick=\"actionDeptSendDocument('" + record.trace_handout_id + "');\" href=\"#\">" + getTopFlag(record) + record.trace_title + "</a>";
		
		var handoutDate = new Date(record.handout_date);
		var deadDate = new Date(handoutDate);
		deadDate.setDate(deadDate.getDate()+1); 
		var tDate = new Date();
		//设置是否显示new图标
		if(Date.parse(deadDate) - Date.parse(tDate)>=0){
			str += " <img id='newImg" + record.msg_id + "' border=0 src='" + newImg + "'>";
		}
		
		str += "</DIV>\n";
		str += "<DIV CLASS=DetailLineTime>" + (handoutDate.getMonth()+1) +"-"+ handoutDate.getDate() + "</DIV>\n";
		//str += "<DIV CLASS=DetailLineName>" + record.handout_user + "</DIV>\n";
		str	+= "</LI>\n";
	}
	if (blankCount > 0) {
		for (var i = 0; i < blankCount; i++) {
			var cssName = (i + 1) == blankCount ? "EndDetailLine" : "DetailLine";
			str += "<LI class=" + cssName + "><DIV></DIV></LI>\n";
		}
	}
	str 	+= "</ul>\n";
	str 	+= "</DIV>\n";
	str 	+= writeFoot(blankCount, obj);
	obj.innerHTML = str;
	obj.style.padding = 0;
}

//公司栏目：待开会议
function writeCompanyMeeting(blockDataAry, obj) {
	//取出当前记录数及最大记录数
	var currentrecordcount = blockDataAry.length;
	var maxrecordcount = obj.getAttribute("recordcount");
	//如果当前记录数少于最大记录数，计算出空行数量
	var blankCount = 0;
	if (currentrecordcount < maxrecordcount) blankCount = maxrecordcount - currentrecordcount;
	//写信息块的主体数据，写时要注意两个问题：1、最后一行与前面行的CSS不同；2、空行的处理
	var str	 = "<DIV ID=BlockDetail>\n";
	str 	+= "<ul>\n";
	for (var i = 0; i < currentrecordcount; i++) {
		var record = blockDataAry[i];
		var cssName;
		if (blankCount > 0) {
			cssName = "DetailLine";
		} else {
			cssName = (i + 1) == currentrecordcount ? "EndDetailLine" : "DetailLine";
		}
		str	+= "<LI class=" + cssName + ">\n";
		str += "<DIV CLASS=DetailLineInfo>";
		str	+= "<img border=0 width=8 height=8 src='" + listImg + "'> ";
		//设置是否显示[重要]等信息
		if (record.important == 1) str += importance;
		var topic = record.topic;
		if (record.is_today == 1) {
			topic = "<span style='color:red'>" + topic + "</span>";
		}
		str += "<a onClick=\"actionCompanyMeeting('" + record.meeting_id + "');\" href=\"#\">" + topic + "</a>";
		str += "</DIV>\n";
		str += "<DIV CLASS=DetailLineName>" + record.start_time + "</DIV>\n";
		str	+= "</LI>\n";
	}
	if (blankCount > 0) {
		for (var i = 0; i < blankCount; i++) {
			var cssName = (i + 1) == blankCount ? "EndDetailLine" : "DetailLine";
			str += "<LI class=" + cssName + "><DIV></DIV></LI>\n";
		}
	}
	str 	+= "</ul>\n";
	str 	+= "</DIV>\n";
	//写块尾
	str 	+= writeFoot(blankCount, obj);
	obj.innerHTML = str;
	obj.style.padding = 0;
}
//张佳斌修改2010-1-28
//公司栏目：党群新闻
function writeCompanyDQNews(blockDataAry, obj) {
	//取出当前记录数及最大记录数
	var currentrecordcount = blockDataAry.length;
	var maxrecordcount = obj.getAttribute("recordcount");
	//如果当前记录数少于最大记录数，计算出空行数量
	var blankCount = 0;
	if (currentrecordcount < maxrecordcount) blankCount = maxrecordcount - currentrecordcount;
	//写信息块的主体数据，写时要注意两个问题：1、最后一行与前面行的CSS不同；2、空行的处理
	var str	 = "<DIV ID=BlockDetail>\n";
	str 	+= "<ul>\n";
	for (var i = 0; i < currentrecordcount; i++) {
		var record = blockDataAry[i];
		var cssName;
		if (blankCount > 0) {
			cssName = "DetailLine";
		} else {
			cssName = (i + 1) == currentrecordcount ? "EndDetailLine" : "DetailLine";
		}
		str	+= "<LI class=" + cssName + ">\n";
		str += "<DIV CLASS=DetailLineInfo>";
		str	+= "<img border=0 width=8 height=8 src='" + listImg + "'> ";
		str += "<a onClick=\"actionCompanyDQNews('" + record.trace_handout_id + "');\" href=\"#\">" + getTopFlag(record) + record.trace_title + "</a>";
		
		var handoutDate = new Date(record.handout_date);
		var deadDate = new Date(handoutDate);
		deadDate.setDate(deadDate.getDate()+1); 
		var tDate = new Date();
		//设置是否显示new图标
		if(Date.parse(deadDate) - Date.parse(tDate)>=0){
			str += " <img id='newImg" + record.msg_id + "' border=0 src='" + newImg + "'>";
		}
		
		str += "</DIV>\n";
		str += "<DIV CLASS=DetailLineTime>" + (handoutDate.getMonth()+1) +"-"+ handoutDate.getDate() + "</DIV>\n";
		//str += "<DIV CLASS=DetailLineName>" + record.handout_user + "</DIV>\n";
		str	+= "</LI>\n";
	}
	if (blankCount > 0) {
		for (var i = 0; i < blankCount; i++) {
			var cssName = (i + 1) == blankCount ? "EndDetailLine" : "DetailLine";
			str += "<LI class=" + cssName + "><DIV></DIV></LI>\n";
		}
	}
	str 	+= "</ul>\n";
	str 	+= "</DIV>\n";
	str 	+= writeFoot(blankCount, obj);
	obj.innerHTML = str;
	obj.style.padding = 0;
}
//张佳斌修改2010-1-28
//公司栏目：通知公告
function writeCompanyNotice(blockDataAry, obj) {
	//取出当前记录数及最大记录数
	var currentrecordcount = blockDataAry.length;
	var maxrecordcount = obj.getAttribute("recordcount");
	//如果当前记录数少于最大记录数，计算出空行数量
	var blankCount = 0;
	if (currentrecordcount < maxrecordcount) blankCount = maxrecordcount - currentrecordcount;
	//写信息块的主体数据，写时要注意两个问题：1、最后一行与前面行的CSS不同；2、空行的处理
	var str	 = "<DIV ID=BlockDetail>\n";
	str 	+= "<ul>\n";
	for (var i = 0; i < currentrecordcount; i++) {
		var record = blockDataAry[i];
		var cssName;
		if (blankCount > 0) {
			cssName = "DetailLine";
		} else {
			cssName = (i + 1) == currentrecordcount ? "EndDetailLine" : "DetailLine";
		}
		str	+= "<LI class=" + cssName + ">\n";
		str += "<DIV CLASS=DetailLineInfo>";
		str	+= "<img border=0 width=8 height=8 src='" + listImg + "'> ";
		str += "<a onClick=\"actionCompanyNotice('" + record.trace_handout_id + "');\" href=\"#\">" + getTopFlag(record) + record.trace_title + "</a>";

		var handoutDate = new Date(record.handout_date);
		var deadDate = new Date(handoutDate);
		deadDate.setDate(deadDate.getDate()+1); 
		var tDate = new Date();
		//设置是否显示new图标
		if(Date.parse(deadDate) - Date.parse(tDate)>=0){
			str += " <img id='newImg" + record.msg_id + "' border=0 src='" + newImg + "'>";
		}

		str += "</DIV>\n";
		str += "<DIV CLASS=DetailLineTime>" + (handoutDate.getMonth()+1) +"-"+ handoutDate.getDate()+ "</DIV>\n";
		//str += "<DIV CLASS=DetailLineName>" + record.handout_user + "</DIV>\n";
		str	+= "</LI>\n";

	}
	if (blankCount > 0) {
		for (var i = 0; i < blankCount; i++) {
			var cssName = (i + 1) == blankCount ? "EndDetailLine" : "DetailLine";
			str += "<LI class=" + cssName + "><DIV></DIV></LI>\n";
		}
	}
	str 	+= "</ul>\n";
	str 	+= "</DIV>\n";
	str 	+= writeFoot(blankCount, obj);
	obj.innerHTML = str;
	obj.style.padding = 0;
}
//张佳斌修改2010-1-28
//公司栏目：收文库
function writeCompanyReceiveDocument(blockDataAry, obj) {
	//取出当前记录数及最大记录数
	var currentrecordcount = blockDataAry.length;
	var maxrecordcount = obj.getAttribute("recordcount");
	//如果当前记录数少于最大记录数，计算出空行数量
	var blankCount = 0;
	if (currentrecordcount < maxrecordcount) blankCount = maxrecordcount - currentrecordcount;
	//写信息块的主体数据，写时要注意两个问题：1、最后一行与前面行的CSS不同；2、空行的处理
	var str	 = "<DIV ID=BlockDetail>\n";
	str 	+= "<ul>\n";
	for (var i = 0; i < currentrecordcount; i++) {
		var record = blockDataAry[i];
		var cssName;
		if (blankCount > 0) {
			cssName = "DetailLine";
		} else {
			cssName = (i + 1) == currentrecordcount ? "EndDetailLine" : "DetailLine";
		}
		str	+= "<LI class=" + cssName + ">\n";
		str += "<DIV CLASS=DetailLineInfo>";
		str	+= "<img border=0 width=8 height=8 src='" + listImg + "'> ";
		str += "<a onClick=\"actionCompanyReceiveDocument('" + record.trace_handout_id + "');\" href=\"#\">" + getTopFlag(record) + record.trace_title + "</a>";
		
		var handoutDate = new Date(record.handout_date);
		var deadDate = new Date(handoutDate);
		deadDate.setDate(deadDate.getDate()+1); 
		var tDate = new Date();
		//设置是否显示new图标
		if(Date.parse(deadDate) - Date.parse(tDate)>=0){
			str += " <img id='newImg" + record.msg_id + "' border=0 src='" + newImg + "'>";
		}
		
		str += "</DIV>\n";
		str += "<DIV CLASS=DetailLineTime>" + (handoutDate.getMonth()+1) +"-"+ handoutDate.getDate() + "</DIV>\n";
		//str += "<DIV CLASS=DetailLineName>" + record.handout_user + "</DIV>\n";
		str	+= "</LI>\n";
	}
	if (blankCount > 0) {
		for (var i = 0; i < blankCount; i++) {
			var cssName = (i + 1) == blankCount ? "EndDetailLine" : "DetailLine";
			str += "<LI class=" + cssName + "><DIV></DIV></LI>\n";
		}
	}
	str 	+= "</ul>\n";
	str 	+= "</DIV>\n";
	str 	+= writeFoot(blankCount, obj);
	obj.innerHTML = str;
	obj.style.padding = 0;
}
//张佳斌修改2010-1-28
//公司栏目：发文库
function writeCompanySendDocument(blockDataAry, obj) {
	//取出当前记录数及最大记录数
	var currentrecordcount = blockDataAry.length;
	var maxrecordcount = obj.getAttribute("recordcount");
	//如果当前记录数少于最大记录数，计算出空行数量
	var blankCount = 0;
	if (currentrecordcount < maxrecordcount) blankCount = maxrecordcount - currentrecordcount;
	//写信息块的主体数据，写时要注意两个问题：1、最后一行与前面行的CSS不同；2、空行的处理
	var str	 = "<DIV ID=BlockDetail>\n";
	str 	+= "<ul>\n";
	for (var i = 0; i < currentrecordcount; i++) {
		var record = blockDataAry[i];
		var cssName;
		if (blankCount > 0) {
			cssName = "DetailLine";
		} else {
			cssName = (i + 1) == currentrecordcount ? "EndDetailLine" : "DetailLine";
		}
		str	+= "<LI class=" + cssName + ">\n";
		str += "<DIV CLASS=DetailLineInfo>";
		str	+= "<img border=0 width=8 height=8 src='" + listImg + "'> ";
		str += "<a onClick=\"actionCompanySendDocument('" + record.trace_handout_id + "');\" href=\"#\">" + getTopFlag(record) + record.trace_title + "</a>";
		
		var handoutDate = new Date(record.handout_date);
		var deadDate = new Date(handoutDate);
		deadDate.setDate(deadDate.getDate()+1); 
		var tDate = new Date();
		//设置是否显示new图标
		if(Date.parse(deadDate) - Date.parse(tDate)>=0){
			str += " <img id='newImg" + record.msg_id + "' border=0 src='" + newImg + "'>";
		}
		
		str += "</DIV>\n";
		str += "<DIV CLASS=DetailLineTime>" + (handoutDate.getMonth()+1) +"-"+ handoutDate.getDate() + "</DIV>\n";
		//str += "<DIV CLASS=DetailLineName>" + record.handout_user + "</DIV>\n";
		str	+= "</LI>\n";
	}
	if (blankCount > 0) {
		for (var i = 0; i < blankCount; i++) {
			var cssName = (i + 1) == blankCount ? "EndDetailLine" : "DetailLine";
			str += "<LI class=" + cssName + "><DIV></DIV></LI>\n";
		}
	}
	str 	+= "</ul>\n";
	str 	+= "</DIV>\n";
	str 	+= writeFoot(blankCount, obj);
	obj.innerHTML = str;
	obj.style.padding = 0;
}

//张佳斌修改2010-1-28
//部门自定义栏目-消息
function writeDeptCustomColumn_news(blockDataAry, obj){ 
	//取出当前记录数及最大记录数
	var currentrecordcount = blockDataAry.length;
	var maxrecordcount = obj.getAttribute("recordcount");
	//如果当前记录数少于最大记录数，计算出空行数量
	var blankCount = 0;
	if (currentrecordcount < maxrecordcount) blankCount = maxrecordcount - currentrecordcount;
	//写信息块的主体数据，写时要注意两个问题：1、最后一行与前面行的CSS不同；2、空行的处理
	var str	 = "<DIV ID=BlockDetail>\n";
	str 	+= "<ul>\n";
	for (var i = 0; i < currentrecordcount; i++) {
		var record = blockDataAry[i];
		var cssName;
		if (blankCount > 0) {
			cssName = "DetailLine";
		} else {
			cssName = (i + 1) == currentrecordcount ? "EndDetailLine" : "DetailLine";
		}
		str	+= "<LI class=" + cssName + ">\n";
		str += "<DIV CLASS=DetailLineInfo>";
		str	+= "<img border=0 width=8 height=8 src='" + listImg + "'> ";
		//设置是否显示[置顶][重要]等信息
		var msgTitle = record.msg_title;
		if (record.flag == 1) {
			str += toTop;
			msgTitle = "<font color='red'>" + msgTitle + "</font>";
		}
		if (record.msg_importance == 1) str += importance;
		str += "<a onClick=\"actionDeptCustomcolumn('" + record.depart_portal_msg_id + "');\" href=\"#\">" + msgTitle + "</a>";
		//设置是否显示new图标
		//if (record.received.indexOf(";" + userId + ";") == -1) {
		//	str += " <img id='newImg" + record.msg_id + "' border=0 src='" + newImg + "'>";
		//}
		str += "</DIV>\n";
		str += "<DIV CLASS=DetailLineTime>" + record.senddatetime + "</DIV>\n";
		//str += "<DIV CLASS=DetailLineName>" + record.sender + "</DIV>\n";
		str	+= "</LI>\n";
	}
	if (blankCount > 0) {
		for (var i = 0; i < blankCount; i++) {
			var cssName = (i + 1) == blankCount ? "EndDetailLine" : "DetailLine";
			str += "<LI class=" + cssName + "><DIV></DIV></LI>\n";
		}
	}
	str 	+= "</ul>\n";
	str 	+= "</DIV>\n";
	str 	+= writeFoot(blankCount, obj);
	obj.innerHTML = str;
	obj.style.padding = 0;
}

//部门自定义栏目-图片新闻
function writeDeptCustomColumn_picNews(blockDataAry, obj){
	var fid = obj.id;
	//取出图片显示区
	var s1 = "";
	var s2 = "";
	var s = "<div class=container id=idTransformView" + fid + "> \n";
	s	 += "<ul class=slider id=idSlider" + fid + ">\n";
    for (var i = 0; i < blockDataAry.length; i++) {
		var record = blockDataAry[i];
        s1 += "<li><a onclick=actionDeptCustomcolumn('" + record.depart_portal_msg_id + "')>\n";
        s1 += "<img alt='" + record.msg_title + "' src='" + record.full_path + "'></a></li>\n";
        s2 += " <li>" + (i + 1) + "</li>\n";
    }
    s += s1;
    s += "</ul>";
    s += " <ul class=num id=idNum" +fid + ">\n";
    s += s2;
    s += "</ul>";
    s += "</div>";
    
    var content="";
    for (var i = 0; i < blockDataAry.length; i++) {
	    var record = blockDataAry[i];
	    if(i==0){
	    	content+= "<DIV id=focusContent" + fid + i + " style='display: block;text-align:left;'>"
	    }else{
	        content+= "<DIV id=focusContent" + fid + i + " style='display: none;text-align:left;'>"
        }
	    	
	    content+= "<ul id='pictureContent" +fid + "'>";	
	    
	    content+= "<li style='text-indent: 0;'><a STYLE='cursor:pointer;' onclick=actionDeptCustomcolumn('" + record.depart_portal_msg_id + "')> <b>" + record.msg_title + "</b></a></li>";	    
	    var simpleContent = record.simple_content;
	    if(simpleContent == null) simpleContent = "";
	    content+= "<li>" + simpleContent + "</li>";
	    content+= "</ul>";
	    content+= "</DIV>";

        
    }
    //开始拼组
    //图片部分
    var str  = "<div style='width: 100%;padding-right: 5px;padding-left: 5px;padding-top: 5px;padding-bottom:5px;float:left'>";
    str		+= "<div style='width:50%; float:left'>";
    str 	+= s;
    str		+= "</div>";    
    
    //标题和内容
    str		+= content;
    
    
    str		+= "</div>";
    str		+= "<br>";

    if (blockDataAry.length == 6) {
    	// 更多
		str += writeFoot(0, obj)    	
    }

	obj.innerHTML = str;
	obj.style.padding = 0;
	try {
		transformView(fid);
	} catch (ex) {
	}
}

// 部门自定义栏目 - 没有数据的时候显示,主要用于异常的时候使用
function writeDeptCustomColumn_nodata(blockDataAry, obj){
	obj.innerHTML = ""; 
}
// 部门自定义栏目
function writeDeptCustomColumn(blockDataAry, obj) {
	if (obj.msg_type == "1") // 1：消息
		writeDeptCustomColumn_news(blockDataAry, obj);
	else if (obj.msg_type == "9") // 9：图片新闻
		writeDeptCustomColumn_picNews(blockDataAry, obj);
	else
		writeDeptCustomColumn_nodata(new Array(), obj);
}

//天气预报
function writeWeather(blockDataAry, obj) {
	var str = "";
	if (blockDataAry != null && blockDataAry.length > 0) {
		var record = blockDataAry[0];
		str		+= "<TABLE BORDER=0 CELLSPACING=0 CELLPADDING=3 HEIGHT=100% WIDTH=100%>\n";
		str		+= "<tr>\n<td width=140 align=middle valign=center>";
		if (record.img1 != "99") {
			str += "<img alt='" + record.img_title1 + "' src=" + weatherImgPath + "b_" + record.img1 + ".gif> ";
		}
		if (record.img2 != "99") {
			str += "<img alt='" + record.img_title2 + "' src=" + weatherImgPath + "b_" + record.img2 + ".gif>";
		}
		str		+= "<DIV class=WeatherCity>\n";
		str 	+= record.city + " &nbsp;" + record.date_y + "<br>" + record.date + " &nbsp;" + record.week;
		str		+= "</DIV>\n";
		str		+= "</td>\n<td>\n";
		str 	+= "<DIV class=WeatherCurrent>";
		str 	+= record.weather1  + "<br>" + record.temp1;
		str 	+= "</DIV>\n";
		str 	+= "<ul id=WeatherDetail>";
		str 	+= "<li>" + weather_td3_title3 + record.wind1 + "</li>";
		str 	+= "<li>" + weather_td3_title4 + record.index_uv + "</li>";
		str 	+= "<li>" + weather_td3_title5 + record.index_xc + "</li>";
		str 	+= "</ul>\n";
		str		+= "<DIV class=WeatherMemo>\n";
		str 	+= weather_td3_title2 + record.index_d;
		str		+= "</DIV>\n";
		str		+= "</td>\n</tr>\n";
		str		+= "</TABLE>\n";
	}
	obj.innerHTML = str;
	obj.style.padding = 0;
}
//公司值班表
function writeOnDuty(blockDataAry, obj) {		
	var str = "";
	if (blockDataAry != null && blockDataAry.length > 0) {
		var record = blockDataAry[0];
		str	+= "<DIV ID=BlockDetail>\n";
		str 	+= "<ul>\n";
		str	+= "<LI >\n";
		str     += "<DIV CLASS=DetailLineInfo>"+ leader_on_duty + record.p_code1;
		str	+= "<LI >\n";
		str     += "<DIV CLASS=DetailLineInfo>" + phone_on_duty;
		str	+= "<LI >\n";
		str     += "<DIV CLASS=DetailLineInfo>" + leader_cellphone;
		str	+= "<LI >\n";
		str     += "<DIV CLASS=DetailLineInfo>" + phone_scene;
		str	+= "<LI >\n";
		str     += "<DIV CLASS=DetailLineInfo>" + flying_seat;
		str	+= "<LI >\n";
		str     += "<DIV CLASS=DetailLineInfo>" + crew_seat;
		str	+= "<LI >\n";
		str     += "<DIV CLASS=DetailLineInfo>" + market_seat;
		str	+= "<LI >\n";
		str	+= "<LI >\n";
		str     += "<DIV CLASS=DetailLineInfo>" + flying_dispatch;
		str	+= "<LI >\n";
		str     += "<DIV CLASS=DetailLineInfo>" ;
		//str 	+= "<a href=\"#\" onClick=\"actMoreBtn('phone_out', '" + address_list + "');\">" + phone_out + "</a>";
		str 	+= "<a href=\"/htoa/phone_out.htm\" >" + phone_out + "</a>";
		str 	+= "</DIV>\n";
		str	+= "</LI>\n";
		str 	+= "</ul>\n";
		str 	+= "</DIV>\n";
	}
	obj.innerHTML = str;
	obj.style.padding = 0;
}

//桌面新闻
function writePictureNews(blockDataAry, obj) {
	var fid = obj.id;
	//取出图片显示区
	var picStr = "";
	var numStr = "";
	var picDivStr = "<div class=container id=idTransformView" + fid + "> \n";
	picDivStr	 += "<ul class=slider id=idSlider" + fid + ">\n";
    for (var i = 0; i < blockDataAry.length; i++) {
		var record = blockDataAry[i];
        picStr += "<li><a onclick=actionMsg('" + record.msg_id + "')>\n";
        picStr += "<img alt='" + record.msg_title + "' src='" + record.full_path + "'></a></li>\n";
        numStr += " <li>" + (i + 1) + "</li>\n";
    }
    picDivStr += picStr;
    picDivStr += "</ul>";
    picDivStr += " <ul class=num id=idNum" + fid + ">\n";
    picDivStr += numStr;
    picDivStr += "</ul>";
    picDivStr += "</div>";
    
    var content="";
    for (var i = 0; i < blockDataAry.length; i++) {
	    var record = blockDataAry[i];
	    if(i==0){
	    	content+= "<DIV id=focusContent" + fid + i + " style='display: block;'>"
	    }else{
	        content+= "<DIV id=focusContent" + fid + i + " style='display: none;'>"
        }
	    content+= "<ul id='pictureContent" + fid + "'>";	
	    content+= "<li  class=DetailLine style='border-bottom:none;'><a style='cursor:pointer;' onclick=actionMsg('" + record.msg_id + "')> <b>" + record.msg_title + "</b></a></li>";
	    var simpleContent = record.simple_content;
	    if(simpleContent == null) simpleContent = "";
	    content+= "<li class=DetailLine style='font-size:10pt;border-bottom:none;'>" + simpleContent + "</li>";
	    content+= "</ul>";
	    content+= "</DIV>";
    }
    
    //开始拼组
    //图片部分
    var htmlStr = "<table width=100% border=0 cellspacing=0 cellpadding=0><tr>";
    htmlStr += "<td width=250px>" + picDivStr + "</td>";
    htmlStr += "<td>" + content + "</td>";    //标题和内容
    htmlStr += "</tr></table>";
    
    if (blockDataAry.length == 6) {
    	// 更多
		str += writeFoot(0, obj)    	
    }
	obj.innerHTML = htmlStr;
	obj.style.padding = 0;
	obj.style.height = 175 + "px";
	try {
		transformView(fid);
	} catch (ex) {
	}
}

//论坛
function writeForum(blockDataAry, obj) {
	//取出当前记录数及最大记录数
	var currentrecordcount = blockDataAry.length;
	var maxrecordcount = obj.getAttribute("recordcount");
	//如果当前记录数少于最大记录数，计算出空行数量
	var blankCount = 0;
	if (currentrecordcount < maxrecordcount) blankCount = maxrecordcount - currentrecordcount;
	//写信息块的主体数据，写时要注意两个问题：1、最后一行与前面行的CSS不同；2、空行的处理
	var str	 = "<DIV ID=BlockDetail>\n";
	str 	+= "<ul>\n";
	for (var i = 0; i < currentrecordcount; i++) {
		var record = blockDataAry[i];
		var cssName;
		if (blankCount > 0) {
			cssName = "DetailLine";
		} else {
			cssName = (i + 1) == currentrecordcount ? "EndDetailLine" : "DetailLine";
		}
		str	+= "<LI class=" + cssName + ">\n";
		str += "<DIV CLASS=DetailLineInfo>";
		str	+= "<img border=0 width=8 height=8 src='" + listImg + "'> ";
		//显示版块名称
		str += "[" + record.pagetitle + "]";
		str += "<a onClick=\"actForumArticleIndex('" + record.forum_article_index_id + "');\" href=\"#\">" + record.indextitle + "</a>";
		str += "</DIV>\n";
		str += "<DIV CLASS=DetailLineTime>" + record.creat_time + "</DIV>\n";
		str += "<DIV CLASS=DetailLineName>" + record.author + "</DIV>\n";
		str	+= "</LI>\n";
	}
	if (blankCount > 0) {
		for (var i = 0; i < blankCount; i++) {
			var cssName = (i + 1) == blankCount ? "EndDetailLine" : "DetailLine";
			str += "<LI class=" + cssName + "><DIV></DIV></LI>\n";
		}
	}
	str 	+= "</ul>\n";
	str 	+= "</DIV>\n";
	//写块尾
	str 	+= writeFoot(blankCount, obj);
	obj.innerHTML = str;
	obj.style.padding = 0;
}

//我的会议
function writeMeeting(blockDataAry, obj) {
	//取出当前记录数及最大记录数
	var currentrecordcount = blockDataAry.length;
	var maxrecordcount = obj.getAttribute("recordcount");
	//如果当前记录数少于最大记录数，计算出空行数量
	var blankCount = 0;
	if (currentrecordcount < maxrecordcount) blankCount = maxrecordcount - currentrecordcount;
	//写信息块的主体数据，写时要注意两个问题：1、最后一行与前面行的CSS不同；2、空行的处理
	var str	 = "<DIV ID=BlockDetail>\n";
	str 	+= "<ul>\n";
	for (var i = 0; i < currentrecordcount; i++) {
		var record = blockDataAry[i];
		var cssName;
		if (blankCount > 0) {
			cssName = "DetailLine";
		} else {
			cssName = (i + 1) == currentrecordcount ? "EndDetailLine" : "DetailLine";
		}
		str	+= "<LI class=" + cssName + ">\n";
		str += "<DIV CLASS=DetailLineInfo>";
		str	+= "<img border=0 width=8 height=8 src='" + listImg + "'> ";
		//设置是否显示[重要]等信息
		if (record.important == 1) str += importance;
		var topic = record.topic;
		if (record.is_today == 1) {
			topic = "<span style='color:red'>" + topic + "</span>";
		}
		str += "<a onClick=\"actMeeting('" + record.meeting_id + "');\" href=\"#\">" + topic + "</a>";
		str += "</DIV>\n";
		str += "<DIV CLASS=DetailLineName>" + record.start_time + "</DIV>\n";
		str	+= "</LI>\n";
	}
	if (blankCount > 0) {
		for (var i = 0; i < blankCount; i++) {
			var cssName = (i + 1) == blankCount ? "EndDetailLine" : "DetailLine";
			str += "<LI class=" + cssName + "><DIV></DIV></LI>\n";
		}
	}
	str 	+= "</ul>\n";
	str 	+= "</DIV>\n";
	//写块尾
	str 	+= writeFoot(blankCount, obj);
	obj.innerHTML = str;
	obj.style.padding = 0;
}

//电子期刊
function writeEBook(blockDataAry, obj) {
	//取出当前记录数及最大记录数
	var currentrecordcount = blockDataAry.length;
	var maxrecordcount = obj.getAttribute("recordcount");
	//如果当前记录数少于最大记录数，计算出空行数量
	var blankCount = 0;
	if (currentrecordcount < maxrecordcount) blankCount = maxrecordcount - currentrecordcount;
	//写信息块的主体数据，写时要注意两个问题：1、最后一行与前面行的CSS不同；2、空行的处理
	var str	 = "<DIV ID=BlockDetail>\n";
	str 	+= "<ul>\n";
	for (var i = 0; i < currentrecordcount; i++) {
		var record = blockDataAry[i];
		var cssName;
		if (blankCount > 0) {
			cssName = "DetailLine";
		} else {
			cssName = (i + 1) == currentrecordcount ? "EndDetailLine" : "DetailLine";
		}
		str	+= "<LI class=" + cssName + ">\n";
		str += "<DIV CLASS=DetailLineInfo>";
		str	+= "<img border=0 width=8 height=8 src='" + listImg + "'> ";
		str += "<a onClick=\"downloadFile2 ('" + record.file_storage_id + "');\" href=\"#\">" + record.file_name + "</a>";
		str += "(" + record.asize + ")";
		str += "</DIV>\n";
		str += "<DIV CLASS=DetailLineTime>" + record.modified_time + "</DIV>\n";
		str += "<DIV CLASS=DetailLineName>" + record.creator_id + "</DIV>\n";
		str	+= "</LI>\n";
	}
	if (blankCount > 0) {
		for (var i = 0; i < blankCount; i++) {
			var cssName = (i + 1) == blankCount ? "EndDetailLine" : "DetailLine";
			str += "<LI class=" + cssName + "><DIV></DIV></LI>\n";
		}
	}
	str 	+= "</ul>\n";
	str 	+= "</DIV>\n";
	//写块尾
	str 	+= writeFoot(blankCount, obj);
	obj.innerHTML = str;
	obj.style.padding = 0;
}

//工作计划
function writeWorkPlan(blockDataAry, obj) {
	//取出当前记录数及最大记录数
	var currentrecordcount = blockDataAry.length;
	var maxrecordcount = obj.getAttribute("recordcount");
	//如果当前记录数少于最大记录数，计算出空行数量
	var blankCount = 0;
	if (currentrecordcount < maxrecordcount) blankCount = maxrecordcount - currentrecordcount;
	//写信息块的主体数据，写时要注意两个问题：1、最后一行与前面行的CSS不同；2、空行的处理
	var str	 = "<DIV ID=BlockDetail>\n";
	str 	+= "<ul>\n";
	for (var i = 0; i < currentrecordcount; i++) {
		var record = blockDataAry[i];
		var cssName;
		if (blankCount > 0) {
			cssName = "DetailLine";
		} else {
			cssName = (i + 1) == currentrecordcount ? "EndDetailLine" : "DetailLine";
		}
		str	+= "<LI class=" + cssName + ">\n";
		str += "<DIV CLASS=DetailLineInfo>";
		str	+= "<img border=0 width=8 height=8 src='" + listImg + "'> ";
		str += "<a onClick=\"actWORK('" + record.forum_article_index_id + "');\" href=\"#\">" + record.title + "</a>";
		str += "</DIV>\n";
		str += "<DIV CLASS=DetailLineTime>" + record.creat_time + "</DIV>\n";
		str += "<DIV CLASS=DetailLineName>" + record.author + "</DIV>\n";
		str	+= "</LI>\n";
	}
	if (blankCount > 0) {
		for (var i = 0; i < blankCount; i++) {
			var cssName = (i + 1) == blankCount ? "EndDetailLine" : "DetailLine";
			str += "<LI class=" + cssName + "><DIV></DIV></LI>\n";
		}
	}
	str 	+= "</ul>\n";
	str 	+= "</DIV>\n";
	//写块尾
	str 	+= writeFoot(blankCount, obj);
	obj.innerHTML = str;
	obj.style.padding = 0;
}

//我的考试
function writeMyExamination(blockDataAry, obj) {

	//取出当前记录数及最大记录数
	var currentrecordcount = blockDataAry.length;
	var maxrecordcount = obj.getAttribute("recordcount");
	//如果当前记录数少于最大记录数，计算出空行数量
	var blankCount = 0;
	if (currentrecordcount < maxrecordcount) blankCount = maxrecordcount - currentrecordcount;
	//写信息块的主体数据，写时要注意两个问题：1、最后一行与前面行的CSS不同；2、空行的处理
	var str	 = "<DIV ID=BlockDetail>\n";
	str 	+= "<ul>\n";
	for (var i = 0; i < currentrecordcount; i++) {
		var record = blockDataAry[i];
		var cssName;
		if (blankCount > 0) {
			cssName = "DetailLine";
		} else {
			cssName = (i + 1) == currentrecordcount ? "EndDetailLine" : "DetailLine";
		}
		str += "<LI class=" + cssName + ">\n";
		str += "<DIV CLASS=DetailLineInfo>";
		str += "<img border=0 width=8 height=8 src='" + listImg + "'> ";
		//str += "<a onClick=\"actMyExamination('" + record.test_detail_id + "');\" href=\"#\">" + record.test_name + "</a>";
        str += record.test_name;
		var handoutDate = new Date(record.start_date);
		var deadDate = new Date(handoutDate);
		deadDate.setDate(deadDate.getDate()+1); 
		var tDate = new Date();
		//设置是否显示new图标
		if(Date.parse(deadDate) - Date.parse(tDate)>=0){
			str += " <img id='newImg" + record.test_detail_id + "' border=0 src='" + newImg + "'>";
		}

		str += "</DIV>\n";
		str += "<DIV CLASS=DetailLineTime>" + record.start_date + "</DIV>\n";
		//str += "<DIV CLASS=DetailLineTime>" + (handoutDate.getMonth()+1) +"-"+ handoutDate.getDate()+ "</DIV>\n";
		//str += "<DIV CLASS=DetailLineName>" + record.test_paper_name + "</DIV>\n";
		str += "</LI>\n";

	}
	if (blankCount > 0) {
		for (var i = 0; i < blankCount; i++) {
			var cssName = (i + 1) == blankCount ? "EndDetailLine" : "DetailLine";
			str += "<LI class=" + cssName + "><DIV></DIV></LI>\n";
		}
	}
	str 	+= "</ul>\n";
	str 	+= "</DIV>\n";
	str 	+= writeFoot(blankCount, obj);
	obj.innerHTML = str;
	obj.style.padding = 0;
}

//培训提醒
function writeTrainingRemind(blockDataAry, obj) {

	//取出当前记录数及最大记录数
	var currentrecordcount = blockDataAry.length;
	var maxrecordcount = obj.getAttribute("recordcount");
	//如果当前记录数少于最大记录数，计算出空行数量
	var blankCount = 0;
	if (currentrecordcount < maxrecordcount) blankCount = maxrecordcount - currentrecordcount;
	//写信息块的主体数据，写时要注意两个问题：1、最后一行与前面行的CSS不同；2、空行的处理
	var str	 = "<DIV ID=BlockDetail>\n";
	str 	+= "<ul>\n";
	for (var i = 0; i < currentrecordcount; i++) {
		var record = blockDataAry[i];
		var cssName;
		if (blankCount > 0) {
			cssName = "DetailLine";
		} else {
			cssName = (i + 1) == currentrecordcount ? "EndDetailLine" : "DetailLine";
		}
		str += "<LI class=" + cssName + ">\n";
		str += "<DIV CLASS=DetailLineInfo>";
		str += "<img border=0 width=8 height=8 src='" + listImg + "'> ";
		//str += "<a onClick=\"actTrainingRemind('" + record.hr_training_course_forward_id + "');\" href=\"#\">" + record.hr_course_chinese_name + "</a>";
		str += "<a onClick=\"actTrainingRemind('" + record.hr_training_course_forward_id + "');\" href=\"#\">" + record.hr_course_chinese_name + "</a>";
		str += "<a onClick=\"actTrainingRemind2('" + record.hr_training_course_forward_id + "');\" href=\"#\"> 报名 </a>";
		var handoutDate = new Date(record.hr_training_course_forward_id);
		var deadDate = new Date(handoutDate);
		deadDate.setDate(deadDate.getDate()+1); 
		var tDate = new Date();
		//设置是否显示new图标
		if(Date.parse(deadDate) - Date.parse(tDate)>=0){
			str += " <img id='newImg" + record.hr_training_course_forward_id + "' border=0 src='" + newImg + "'>";
		}

		str += "</DIV>\n";
		// 后面显示开课时间
		str += "<DIV CLASS=DetailLineDateTime>" + record.course_begin_date + "</DIV>\n";
		//str += "<DIV CLASS=DetailLineTime>" + record.course_begin_date + "</DIV>\n";
		//str += "<DIV CLASS=DetailLineTime>" + (handoutDate.getMonth()+1) +"-"+ handoutDate.getDate()+ "</DIV>\n";
		//str += "<DIV CLASS=DetailLineName>" + record.test_paper_name + "</DIV>\n";
		str += "</LI>\n";
		

	}
	if (blankCount > 0) {
		for (var i = 0; i < blankCount; i++) {
			var cssName = (i + 1) == blankCount ? "EndDetailLine" : "DetailLine";
			str += "<LI class=" + cssName + "><DIV></DIV></LI>\n";
		}
	}
	str 	+= "</ul>\n";
	str 	+= "</DIV>\n";
	str 	+= writeFoot(blankCount, obj);
	obj.innerHTML = str;
	obj.style.padding = 0;
}

//生日提醒
function writeBirthday(blockDataAry, obj) {

	//取出当前记录数及最大记录数
	var currentrecordcount = blockDataAry.length;
	var maxrecordcount = obj.getAttribute("recordcount");
	//如果当前记录数少于最大记录数，计算出空行数量
	var blankCount = 0;
	if (currentrecordcount < maxrecordcount) blankCount = maxrecordcount - currentrecordcount;
	//写信息块的主体数据，写时要注意两个问题：1、最后一行与前面行的CSS不同；2、空行的处理
	var str	 = "<DIV ID=BlockDetail>\n";
	str 	+= "<ul>\n";
	for (var i = 0; i < currentrecordcount; i++) {
		var record = blockDataAry[i];
		var cssName;
		if (blankCount > 0) {
			cssName = "DetailLine";
		} else {
			cssName = (i + 1) == currentrecordcount ? "EndDetailLine" : "DetailLine";
		}
		str += "<LI class=" + cssName + ">\n";
		str += "<DIV CLASS=DetailLineInfo>";
		str += "<img border=0 width=8 height=8 src='" + listImg + "'> ";
		str += record.hr_name;
		//str += "<a onClick=\"actBirthday('" + record.hr_employee_records_id + "');\" href=\"#\">" + record.hr_name + "</a>";
		
		var tDate = new Date();     
		if(((tDate.getMonth()+1)+"-"+tDate.getDate()) == record.birthday){
			str += "&nbsp;&nbsp;今天生日&nbsp;&nbsp;";
		}
		
		str += "</DIV>\n";
		// 后面显示开课时间
		str += "<DIV CLASS=DetailLineTime>" + record.birthday + "</DIV>\n";
		str += "</LI>\n";
		

	}
	if (blankCount > 0) {
		for (var i = 0; i < blankCount; i++) {
			var cssName = (i + 1) == blankCount ? "EndDetailLine" : "DetailLine";
			str += "<LI class=" + cssName + "><DIV></DIV></LI>\n";
		}
	}
	str 	+= "</ul>\n";
	str 	+= "</DIV>\n";
	str 	+= writeFoot(blankCount, obj);
	obj.innerHTML = str;
	obj.style.padding = 0;
}


//待我审批
function writeWaitTrace(blockDataAry, obj) {
	//取出当前记录数及最大记录数
	var currentrecordcount = blockDataAry.length;
	var maxrecordcount = obj.getAttribute("recordcount");
	//如果当前记录数少于最大记录数，计算出空行数量
	var blankCount = 0;
	if (currentrecordcount < maxrecordcount) blankCount = maxrecordcount - currentrecordcount;
	//写信息块的主体数据，写时要注意两个问题：1、最后一行与前面行的CSS不同；2、空行的处理
	var str	 = "<DIV ID=BlockDetail>\n";
	str 	+= "<ul>\n";
	for (var i = 0; i < currentrecordcount; i++) {
		var record = blockDataAry[i];
		var cssName;
		if (blankCount > 0) {
			cssName = "DetailLine";
		} else {
			cssName = (i + 1) == currentrecordcount ? "EndDetailLine" : "DetailLine";
		}
		str	+= "<LI class=" + cssName + ">\n";
		str += "<DIV CLASS=DetailLineInfo>";
		str	+= "<img border=0 width=8 height=8 src='" + listImg + "'> ";
		//设置是否显示[重要]等信息
		if (record.trace_priority == 1) str += importance;
		str += "<a onClick=\"actionTrace('" + record.trace_instance_index_id + "');\" href=\"#\">" + record.trace_title + "</a>";
		str += "</DIV>\n";
		str += "<DIV CLASS=DetailLineTime>" + record.trace_start_time + "</DIV>\n";
		str += "<DIV CLASS=DetailLineName>" + record.create_user_id + "</DIV>\n";
		str	+= "</LI>\n";
	}
	if (blankCount > 0) {
		for (var i = 0; i < blankCount; i++) {
			var cssName = (i + 1) == blankCount ? "EndDetailLine" : "DetailLine";
			str += "<LI class=" + cssName + "><DIV></DIV></LI>\n";
		}
	}
	str 	+= "</ul>\n";
	str 	+= "</DIV>\n";
	//写块尾
	str 	+= writeFoot(blankCount, obj);
	obj.innerHTML = str;
	obj.style.padding = 0;
}

//今日工作安排
function writeTodayWork(blockDataAry, obj) {
	//取出当前记录数及最大记录数
	var currentrecordcount = blockDataAry.length;
	var maxrecordcount = obj.getAttribute("recordcount");
	//如果当前记录数少于最大记录数，计算出空行数量
	var blankCount = 0;
	if (currentrecordcount < maxrecordcount) blankCount = maxrecordcount - currentrecordcount;
	//写信息块的主体数据，写时要注意两个问题：1、最后一行与前面行的CSS不同；2、空行的处理
	var str	 = "<DIV ID=BlockDetail>\n";
	str 	+= "<ul>\n";
	for (var i = 0; i < currentrecordcount; i++) {
		var record = blockDataAry[i];
		var cssName;
		if (blankCount > 0) {
			cssName = "DetailLine";
		} else {
			cssName = (i + 1) == currentrecordcount ? "EndDetailLine" : "DetailLine";
		}
		str	+= "<LI class=" + cssName + ">\n";
		str += "<DIV CLASS=DetailLineInfo>";
		str	+= "<img border=0 width=8 height=8 src='" + listImg + "'> ";
		if (record.important == 0) {
			str += calendar0;
		} else if (record.important == 1) {
			str += calendar1;
		} else if (record.important == 2) {
			str += calendar2;
		}
		str += "<a onClick=\"getTodayWork('" + record.calendar_detail_id + "');\" href=\"#\">" + widthCheck(record.memo, 50) + "</a>";
		str += "</DIV>\n";
		str += "<DIV CLASS=DetailLineTime>";
		if (record.state == 0) {
			str += notdo;
		} else if (record.state == 1) {
			str += done;
		}
		str += "</DIV>\n";
		str	+= "</LI>\n";
	}
	if (blankCount > 0) {
		for (var i = 0; i < blankCount; i++) {
			var cssName = (i + 1) == blankCount ? "EndDetailLine" : "DetailLine";
			str += "<LI class=" + cssName + "><DIV></DIV></LI>\n";
		}
	}
	str 	+= "</ul>\n";
	str 	+= "</DIV>\n";
	//写块尾
	str 	+= writeFoot(blankCount, obj);
	obj.innerHTML = str;
	obj.style.padding = 0;
}

//通讯录
function writeAddress(blockDataAry, obj) {
	//取出当前记录数及最大记录数
	var currentrecordcount = blockDataAry.length;
	var maxrecordcount = obj.getAttribute("recordcount");
	//如果当前记录数少于最大记录数，计算出空行数量
	var blankCount = 0;
	if (currentrecordcount < maxrecordcount) blankCount = maxrecordcount - currentrecordcount;
	//写信息块的主体数据，写时要注意两个问题：1、最后一行与前面行的CSS不同；2、空行的处理
	var str	 = "<DIV ID=BlockDetail>\n";
	str 	+= "<ul>\n";
	for (var i = 0; i < currentrecordcount; i++) {
		var record = blockDataAry[i];
		var cssName;
		if (blankCount > 0) {
			cssName = "DetailLine";
		} else {
			cssName = (i + 1) == currentrecordcount ? "EndDetailLine" : "DetailLine";
		}
		str	+= "<LI class=" + cssName + ">\n";
		str += "<DIV CLASS=DetailLineInfo>";
		str	+= "<img border=0 width=8 height=8 src='" + listImg + "'> ";
		str += "<a onClick=\"actAddress('" + record.address_list_detail_id + "');\" href=\"#\">" + record.personnel_name + "</a>";
		str += "</DIV>\n";
		str	+= "</LI>\n";
	}
	if (blankCount > 0) {
		for (var i = 0; i < blankCount; i++) {
			var cssName = (i + 1) == blankCount ? "EndDetailLine" : "DetailLine";
			str += "<LI class=" + cssName + "><DIV></DIV></LI>\n";
		}
	}
	str 	+= "</ul>\n";
	str 	+= "</DIV>\n";
	//写块尾
	str 	+= writeFoot(blankCount, obj);
	obj.innerHTML = str;
	obj.style.padding = 0;
}

//邮件
function writeMail(blockDataAry, obj) {
	//取出当前记录数及最大记录数
	var currentrecordcount = blockDataAry.length;
	var maxrecordcount = obj.getAttribute("recordcount");
	//如果当前记录数少于最大记录数，计算出空行数量
	var blankCount = 0;
	if (currentrecordcount < maxrecordcount) blankCount = maxrecordcount - currentrecordcount;
	//写信息块的主体数据，写时要注意两个问题：1、最后一行与前面行的CSS不同；2、空行的处理
	var str	 = "<DIV ID=BlockDetail>\n";
	str 	+= "<ul>\n";
	for (var i = 0; i < currentrecordcount; i++) {
		var record = blockDataAry[i];
		var cssName;
		if (blankCount > 0) {
			cssName = "DetailLine";
		} else {
			cssName = (i + 1) == currentrecordcount ? "EndDetailLine" : "DetailLine";
		}
		str	+= "<LI class=" + cssName + ">\n";
		str += "<DIV CLASS=DetailLineInfo>";
		str	+= "<img border=0 width=8 height=8 src='" + listImg + "'> ";
		//设置是否显示[重要]等信息
		if (record.priority == 1) str += importance;
		str += "<a onClick=\"actionMail('" + record.mail_message_id + "');\" href=\"#\">" + record.subject + "</a>";
		//设置是否显示new图标
		if (record.read_mark == 0) {
			str += " <img id='newImg" + record.mail_message_id + "' border=0 src='" + newImg + "'>";
		}
		str += "</DIV>\n";
		str += "<DIV CLASS=DetailLineTime>" + record.sent_date + "</DIV>\n";
		str += "<DIV CLASS=DetailLineName>" + record.sender + "</DIV>\n";
		str	+= "</LI>\n";
	}
	if (blankCount > 0) {
		for (var i = 0; i < blankCount; i++) {
			var cssName = (i + 1) == blankCount ? "EndDetailLine" : "DetailLine";
			str += "<LI class=" + cssName + "><DIV></DIV></LI>\n";
		}
	}
	str 	+= "</ul>\n";
	str 	+= "</DIV>\n";
	//写块尾
	str 	+= writeFoot(blankCount, obj);
	obj.innerHTML = str;
	obj.style.padding = 0;
}

//通讯录查询
function writeAddressQuery(blockDataAry, obj) {
	var str	 = "<DIV class=BlockDetailByAddressQuery> ";
	str		+= addressQuery_name;
	str		+= " <input class=InputStyle style='width:20%;' onfocus='this.select();' type=text name=addressQuery_name id=addressQuery_name> ";
	str		+= addressQuery_company;
	str		+= " <input class=InputStyle style='width:20%;' onfocus='this.select();' type=text name=addressQuery_company id=addressQuery_company> ";
	str		+= " <input class=QueryButton type=button value='" + addressQuery_search + "' name=addressQuery_search onClick='actAddressQueryBtn();'>";
	str		+= "</DIV>\n";
	str		+= "<DIV ID=BlockFoot>\n";
	str		+= "</DIV>";
	obj.innerHTML = str;
	obj.style.height = "90px";
	obj.style.padding = 0;
}

//待办提醒
function writeAwoke(blockDataAry, obj) {
	var traceCount = 0;
	var readCount = 0;
	var taskCount = 0;
	var calendarCount = 0;
	if (blockDataAry != null && blockDataAry.length == 4) {
		traceCount = blockDataAry[0];
		readCount = blockDataAry[1];
		taskCount = blockDataAry[2];
		calendarCount = blockDataAry[3];
	}
	var str	 = "<DIV class=BlockDetailByAwoke>\n";
	str		+= "<TABLE BORDER=0 CELLSPACING=0 CELLPADDING=5 HEIGHT=100%>\n";
	str		+= "<tr>\n<td>";
	str		+= "<DIV class=AwokeButton onClick=\"actMoreBtn('Oasp9006', '" + awoke_trace + "');\">" + awoke_trace + " (<span class=AwokeNum>" + traceCount + "</span>)" + "</DIV>";
	str		+= "</td>\n<td>";
	str		+= "<DIV class=AwokeButton onClick=\"actMoreBtn('Oasp9014', '" + awoke_read + "');\">" + awoke_read + " (<span class=AwokeNum>" + readCount + "</span>)" + "</DIV>";
	str		+= "</td>\n</tr>\n<tr>\n<td>";
	str		+= "<DIV class=AwokeButton onClick=\"actMoreBtn('actOasp5162_2', '" + awoke_task + "');\">" + awoke_task + " (<span class=AwokeNum>" + taskCount + "</span>)" + "</DIV>";
	str		+= "</td>\n<td>";
	str		+= "<DIV class=AwokeButton onClick=\"actMoreBtn('actOasp1001', '" + awoke_calendar + "');\">" + awoke_calendar + " (<span class=AwokeNum>" + calendarCount + "</span>)" + "</DIV>";
	str		+= "</td>\n</tr>\n";
	str		+= "</TABLE>\n";
	str		+= "</DIV>\n";
	obj.innerHTML = str;
	obj.style.padding = 3;
}

//绩效考核
function writePreformance(blockDataAry, obj) {
	var traceCount = 0;
	var readCount = 0;
	if (blockDataAry != null && blockDataAry.length == 2) {
		traceCount = blockDataAry[0];
		readCount = blockDataAry[1];
	}
	var str	 = "<DIV class=BlockDetailByAwoke>\n";
	str		+= "<TABLE BORDER=0 CELLSPACING=0 CELLPADDING=5 HEIGHT=100%>\n";
	str		+= "<tr>\n<td>";
	str		+= "<DIV class=AwokeButton onClick=\"actMoreBtn('Oasp5718', '" + preformance_trace + "');\">" + preformance_trace + " (<span class=AwokeNum>" + traceCount + "</span>)" + "</DIV>";
	str		+= "</td>\n<td>";
	str		+= "<DIV class=AwokeButton onClick=\"actMoreBtn('Oasp5719', '" + preformance_read + "');\">" + preformance_read + " (<span class=AwokeNum>" + readCount + "</span>)" + "</DIV>";
	str		+= "</td>\n</tr>\n";
	str		+= "</TABLE>\n";
	str		+= "</DIV>\n";
	obj.innerHTML = str;
	obj.style.padding = 3;
}

//个人考勤
function writeAttendance(blockDataAry, obj) {
	var traceCount = 0;
	var readCount = 0;


	for(var i = 0;i<blockDataAry.length;i++) {
	  var record = blockDataAry[i];
	  //alert(record.attendance_group);
	}
	if (blockDataAry != null && blockDataAry.length == 2) {
		traceCount = blockDataAry[0];
		readCount = blockDataAry[1];
	}
    

	var str	 = "<DIV class=BlockDetailByAwoke>\n";
	if(blockDataAry.length > 0) {
	  str		+= "<TABLE BORDER=0 CELLSPACING=0 CELLPADDING=5 HEIGHT=100%>\n";
	  str		+= "<tr>\n<td rowSpan=2 WIDTH=30%><DIV CLASS=AwokeNum><span class=WeatherCurrent>考勤组" + record.attendance_group + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>";
      str		+= "</td>\n<td>";
      if(record.attendance_time_on == null)
	    str		+= "<DIV class=AwokeButton onClick=\"actionAttendance('ON', '" + record.attendance_log_id + "');\">" + "上班签到" +  "</DIV>";
      else 
        str     +="<div><span class=WeatherCurrent>" + record.attendance_time_on + "</span></div>";
	  str		+= "</td>\n</tr>\n<tr>\n<td>";
      if(record.attendance_time_off == null)
	    str		+= "<DIV class=AwokeButton onClick=\"actionAttendance('OFF', '" + record.attendance_log_id + "');\">" + "下班签退" + "</DIV>";
	  else
	    str     +="<div><span class=WeatherCurrent>" + record.attendance_time_off + "</span></div>";
	  str		+= "</td>\n</tr>\n";
	  str		+= "</TABLE>\n";
	  }
	str		+= "</DIV>\n";
	obj.innerHTML = str;
	obj.style.padding = 3;
}

//快捷方式
function writeQuick(blockDataAry, obj) {
	//取出当前记录数及最大记录数
	var currentrecordcount = blockDataAry.length;
	var maxrecordcount = obj.getAttribute("recordcount");
	//如果当前记录数少于最大记录数，计算出空行数量
	var blankCount = 0;
	if (currentrecordcount < maxrecordcount) blankCount = maxrecordcount - currentrecordcount;
	//写信息块的主体数据，写时要注意两个问题：1、最后一行与前面行的CSS不同；2、空行的处理
	var str	 = "<DIV ID=BlockDetail>\n";
	str 	+= "<ul>\n";
	for (var i = 0; i < currentrecordcount; i++) {
		//大于 最大记录数 不显示
        //delete 赵健 去掉桌面显示快捷方式最大条数限制 start
//		if(i == maxrecordcount) break;
        //delete 赵健 去掉桌面显示快捷方式最大条数限制 end
		var record = blockDataAry[i];
		var cssName;
		if (blankCount > 0) {
			cssName = "DetailLine";
		} else {
			cssName = (i + 1) == currentrecordcount ? "EndDetailLine" : "DetailLine";
		}
		str	+= "<LI class=" + cssName + ">\n";
		str += "<DIV CLASS=DetailLineInfo>";
		str	+= "<img border=0 width=8 height=8 src='" + listImg + "'> ";
		str += "<a onClick=\"actMoreBtn('" + record.actFunc + "', '" + record.name + "');\" href=\"#\">" + record.name + "</a>";
		str += "</DIV>\n";
		str	+= "</LI>\n";
	}
	if (blankCount > 0) {
		for (var i = 0; i < blankCount; i++) {
			var cssName = (i + 1) == blankCount ? "EndDetailLine" : "DetailLine";
			str += "<LI class=" + cssName + "><DIV></DIV></LI>\n";
		}
	}
	str 	+= "</ul>\n";
	str 	+= "</DIV>\n";
	//写块尾--不要转，直接在画面上全显示
	str 	+= "<DIV ID=BlockFoot>\n";//writeFoot(blankCount, obj);
	obj.innerHTML = str;
	obj.style.padding = 0;
}

//最新上传文件
function writeFile(blockDataAry, obj) {
	//取出当前记录数及最大记录数
	var currentrecordcount = blockDataAry.length;
	var maxrecordcount = obj.getAttribute("recordcount");
	//如果当前记录数少于最大记录数，计算出空行数量
	var blankCount = 0;
	if (currentrecordcount < maxrecordcount) blankCount = maxrecordcount - currentrecordcount;
	//写信息块的主体数据，写时要注意两个问题：1、最后一行与前面行的CSS不同；2、空行的处理
	var str	 = "<DIV ID=BlockDetail>\n";
	str 	+= "<ul>\n";
	for (var i = 0; i < currentrecordcount; i++) {
		var record = blockDataAry[i];
		var cssName;
		if (blankCount > 0) {
			cssName = "DetailLine";
		} else {
			cssName = (i + 1) == currentrecordcount ? "EndDetailLine" : "DetailLine";
		}
		str	+= "<LI class=" + cssName + ">\n";
		str += "<DIV CLASS=DetailLineInfo>";
		str	+= "<img border=0 width=8 height=8 src='" + listImg + "'> ";
		str += "<a onClick=\"downloadFile2('" + record.file_storage_id + "');\" href=\"#\">" + record.file_name + "</a>";
		str += "</DIV>\n";
		str += "<DIV CLASS=DetailLineName>" + record.asize + "</DIV>\n";
		str	+= "</LI>\n";
	}
	if (blankCount > 0) {
		for (var i = 0; i < blankCount; i++) {
			var cssName = (i + 1) == blankCount ? "EndDetailLine" : "DetailLine";
		str += "<LI class=" + cssName + "><DIV></DIV></LI>\n";
		}
	}
	str 	+= "</ul>\n";
	str 	+= "</DIV>\n";
	//写块尾
	str 	+= writeFoot(blankCount, obj);
	obj.innerHTML = str;
	obj.style.padding = 0;
}

//网上调查
function writeVotting(blockDataAry, obj) {
	var votingTitle = blockDataAry.length == 0 ? noVoting : blockDataAry[0].title;
	var singleFlg = false;
	if (blockDataAry.length > 0) {
		singleFlg = !(blockDataAry[0].options == 1);
	}
	//取得是否允许投票——只要有项目被投，就不允许再次投票
	var isAlreadyVoting = false;
	for (var i = 0; i < blockDataAry.length; i++) {
		var record = blockDataAry[i];
		if (!isAlreadyVoting) isAlreadyVoting = record.voter_list.indexOf(";" + userId + ";") > -1;
		if (isAlreadyVoting) break;
	}
	var disabledStr = isAlreadyVoting ? "disabled" : "";
	var str	 = "<ul id=Votting>\n";
	str		+= "<li id=VottingHeader>" + votingTitle + "</li>";
	for (var i = 0; i < blockDataAry.length; i++) {
		var record = blockDataAry[i];
		str	+= "<li>";
		if (singleFlg) {
			str += "<input type=radio value='" + record.voting_detail_id + "' name='vottingOption' " + disabledStr + "> ";
		} else {
			str += "<input type=checkbox value='" + record.voting_detail_id + "' name='vottingOption' " + disabledStr + "> ";
		}
		str += record.item_name + " </li>\n";
	}
	if (blockDataAry.length > 0) {
		str	+= "<li style='padding-top: 5px;'><center>";
		str += "<input class=ButtonStyle name='submitvot' type=button onClick=\"actSubmitVotting('" + record.voting_index_id + "', this);\" value='" + submitVotting + "' " + disabledStr + "> ";
		str += "<input class=ButtonStyle name='viewvot' type=button onClick=\"actViewVotting('" + record.voting_index_id + "');\" value='" + viewVotting + "'> ";
		str += "</center></li>";
	}
	str		+= "</ul>\n";
	obj.innerHTML = str;
	obj.style.padding = 0;
	if(blockDataAry.length >= 3) obj.style.height = (blockDataAry.length * 25 + 100) + "px";
}

//公司格言
function writeCompanyAdage(adage, obj) {
	obj.setAttribute("style","height:auto;");
	var adageContent = (adage == null || adage.func_list == null) ? "&nbsp;" : adage.func_list;
	var str	 = "<TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0 WIDTH=100% style=' height:175px;'>";
	str 	+= "<tr height=3><td colspan=5></td></tr>"
	str 	+= "<tr height=5><td width=3px></td><td width=5 class=AdageTopLeft></td>"
	str 	+= "<td class=BlockDetailByAdage></td>"
	str 	+= "<td width=5 class=AdageTopRight></td>"
	str 	+= "<td width=3 ></td>"
	str		+= "</tr><tr>";
	str 	+= "<td width=3px></td>"
	str 	+= "<td class=BlockDetailByAdage></td>";
	str 	+= "<td class=BlockDetailByAdage align=left>" + adageContent + "</td>";
	str 	+= "<td class=BlockDetailByAdage></td>";
	str 	+= "<td width=3px></td>"
	str		+= "</tr><tr height=5>";
	str 	+= "<td width=3px></td>"
	str 	+= "<td width=5 class=AdageBottomLeft></td>"
	str 	+= "<td class=BlockDetailByAdage></td>"
	str 	+= "<td width=5 class=AdageBottomRight></td>"
	str 	+= "<td width=3 ></td>"
	str		+= "</tr><tr>";
	str		+= "<td colspan=5 height=3></td>";
	str		+= "</tr></TABLE>\n";
	obj.innerHTML = str;
	obj.style.padding = 0;
}


//常用网址
function writeUserTools(blockDataAry, obj) {
	//取出当前记录数及最大记录数
	var currentrecordcount = blockDataAry.length;
	var maxrecordcount = obj.getAttribute("recordcount");
	//如果当前记录数少于最大记录数，计算出空行数量
	var blankCount = 0;
	if (currentrecordcount < maxrecordcount) blankCount = maxrecordcount - currentrecordcount;
	//写信息块的主体数据，写时要注意两个问题：1、最后一行与前面行的CSS不同?、空行的处理
	var str	 = "<DIV ID=BlockDetail>\n";
	str 	+= "<ul>\n";
	for (var i = 0; i < currentrecordcount; i++) {
		var record = blockDataAry[i];
		var cssName;
		if (blankCount > 0) {
			cssName = "DetailLine";
		} else {
			cssName = (i + 1) == currentrecordcount ? "EndDetailLine" : "DetailLine";
		}
		var address = record.link_address;
		if (address == "") continue;
		// sissi upate 20120705 连接地址前不加http:// 时打开链接会报错
		if (address.indexOf("http://") == -1) address = "http://" + address;
		str	+= "<LI class=" + cssName + ">\n";
		str += "<DIV CLASS=DetailLineInfo>";
		str	+= "<img border=0 width=8 height=8 src='" + listImg + "'> ";
		str += "<a target='_blank' href=\"" + address + "\">" + record.link_name + "</a>";
		str += "</DIV>\n";
		str	+= "</LI>\n";
	}
	if (blankCount > 0) {
		for (var i = 0; i < blankCount; i++) {
			var cssName = (i + 1) == blankCount ? "EndDetailLine" : "DetailLine";
		str += "<LI class=" + cssName + "><DIV></DIV></LI>\n";
		}
	}
	str 	+= "</ul>\n";
	str 	+= "</DIV>\n";
	//写块宿
	str 	+= writeFoot(blankCount, obj);
	obj.innerHTML = str;
	obj.style.padding = 0;
}

//消息类数拿
function writeMsg(blockDataAry, obj) {
	//取出当前记录数及最大记录数
	var currentrecordcount = blockDataAry.length;
	var maxrecordcount = obj.getAttribute("recordcount");
	//如果当前记录数少于最大记录数，计算出空行数量
	var blankCount = 0;
	if (currentrecordcount < maxrecordcount) blankCount = maxrecordcount - currentrecordcount;
	//写信息块的主体数据，写时要注意两个问题：1、最后一行与前面行的CSS不同?、空行的处理
	var str	 = "<DIV ID=BlockDetail>\n";
	str 	+= "<ul>\n";
	for (var i = 0; i < currentrecordcount; i++) {
		var record = blockDataAry[i];
		var cssName;
		if (blankCount > 0) {
			cssName = "DetailLine";
		} else {
			cssName = (i + 1) == currentrecordcount ? "EndDetailLine" : "DetailLine";
		}
		str	+= "<LI class=" + cssName + ">\n";
		str += "<DIV CLASS=DetailLineInfo>";
		str	+= "<img border=0 width=8 height=8 src='" + listImg + "'> ";
		//设置是否显示[置顶][重要]等信息
		if (record.flag == 1) str += toTop;
		if (record.msg_importance == 1) str += importance;
		//Modified by xiaogang 2011-12-28 
		var sender = record.sender;
//		if(sender =="") sender = title_system_send;  sissi update at 20120117 陈意见，桌面上不要显示“系统发送”
		if (sender == "SYSMSGSEND") {
			str += "<a onClick=\"actionMsgMsg('" + record.msg_id + "', screen.availWidth, screen.availHeight);\" href=\"#\">" + record.msg_title + "</a>";
		} else {
			str += "<a onClick=\"actionMsgMsg('" + record.msg_id + "', 800, 600);\" href=\"#\">" + record.msg_title + "</a>";
		}
		//设置是否显示new图标
		if (record.received.indexOf(";" + userId + ";") == -1) {
			str += " <img id='newImg" + record.msg_id + "' border=0 src='" + newImg + "'>";
		}
		// lihao 20120625 不允许打开多个审批单
        str += " <input id='linktype" + record.msg_id + "' type='hidden' value='"+ record.linktype +"'>";
		str += "</DIV>\n";
		str += "<DIV CLASS=DetailLineTime>" + record.senddatetime + "</DIV>\n";
		str += "<DIV CLASS=DetailLineName>" + sender + "</DIV>\n";
		str	+= "</LI>\n";
	}
	if (blankCount > 0) {
		for (var i = 0; i < blankCount; i++) {
			var cssName = (i + 1) == blankCount ? "EndDetailLine" : "DetailLine";
			str += "<LI class=" + cssName + "><DIV></DIV></LI>\n";
		}
	}
	str 	+= "</ul>\n";
	str 	+= "</DIV>\n";
	str 	+= writeFoot(blankCount, obj);
	obj.innerHTML = str;
	obj.style.padding = 0;
}

//写块宿
function writeFoot(blankCount, obj) {
	var str  = "";
	str		+= "<DIV ID=BlockFoot>\n";
	if (blankCount == 0) {
		str += "<DIV ID=BlockFootMore>";
		var functionId = obj.id;
		if (isCompanyColumn(functionId)) {
			// 公司栏目
			str += "<img border=0 width=9 height=8 src='" + moreImg + "'> ";
			str += "<a href='#' onClick=\"actCompanyColumnMoreBtn('" + functionId + "');\">" + more + "</a>";
			str += "</DIV>"
		} else {
			
			var urlvalue = obj.getAttribute("urlvalue");
			if ("actOasp1903" == urlvalue) urlvalue += '_1'; 
			if (urlvalue != null && urlvalue != "undefined" && urlvalue != "") {
				var urlname = obj.getAttribute("urlname");
				str += "<img border=0 width=9 height=8 src='" + moreImg + "'> ";
			    str += "<a href='#' onClick=\"actMoreBtn('" + urlvalue + "', '" + urlname + "');\">" + more + "</a>";
				str += "</DIV>"
			}
			
			if (functionId != null && functionId.charAt(0) == 'D') {
				// 部门的自定义栏目
				str += "<img border=0 width=9 height=8 src='" + moreImg + "'> ";
				str += "<a href='#' onClick=\"actDeptCustomColumnMoreBtn('" + functionId + "');\">" + more + "</a>";
				str += "</DIV>"
			}
		}
	}
	str		+= "</DIV>";
	return str;
}

// 判断fid是不是公司栏癿
function isCompanyColumn(fid) {
	if (fid == "FUNC10000MAX" || fid== "FUNC10001MAX" || fid== "FUNC10002MAX"
			|| fid== "FUNC10003MAX" || fid== "FUNC10004MAX" || fid== "FUNC10005MAX" 
			|| fid== "FUNC11000MAX" || fid== "FUNC11001MAX")
		return true;
	else
		return false;
}

//判断是否需要增加置響
function getTopFlag(record) {
	if (record.top_flag == null) return "";
	return record.top_flag == 1 ? "[置顶]" : "";
}


//政务督办
function writeMyTask(blockDataAry, obj) {
	//取出当前记录数及最大记录数
	var currentrecordcount = blockDataAry.length;
	var maxrecordcount = obj.getAttribute("recordcount");
	//如果当前记录数少于最大记录数，计算出空行数量
	var blankCount = 0;
	if (currentrecordcount < maxrecordcount) blankCount = maxrecordcount - currentrecordcount;
	//写信息块的主体数据，写时要注意两个问题：1、最后一行与前面行的CSS不同?、空行的处理
	var str	 = "<DIV ID=BlockDetail>\n";
	str 	+= "<ul>\n";
	for (var i = 0; i < currentrecordcount; i++) {
		var record = blockDataAry[i];
		var cssName;
		if (blankCount > 0) {
			cssName = "DetailLine";
		} else {
			cssName = (i + 1) == currentrecordcount ? "EndDetailLine" : "DetailLine";
		}
		str	+= "<LI class=" + cssName + ">\n";
		str += "<DIV CLASS=DetailLineInfo>";
		str	+= "<img border=0 width=8 height=8 src='" + listImg + "'> ";
		if (record.important == 0) {
			str += calendar0;
		} else if (record.important == 1) {
			str += calendar1;
		} else if (record.important == 2) {
			str += calendar2;
		}
		str += "<a onClick=\"getTask('" + record.task_list_id + "');\" href=\"#\">" + record.title + "</a>";
		str += "</DIV>\n";
		str += "<DIV CLASS=DetailLineTime>";
		str += record.managerName;
		str += "</DIV>\n";
		str	+= "</LI>\n";
	}
	if (blankCount > 0) {
		for (var i = 0; i < blankCount; i++) {
			var cssName = (i + 1) == blankCount ? "EndDetailLine" : "DetailLine";
			str += "<LI class=" + cssName + "><DIV></DIV></LI>\n";
		}
	}
	str 	+= "</ul>\n";
	str 	+= "</DIV>\n";
	//写块宿
	str 	+= writeFoot(blankCount, obj);
	obj.innerHTML = str;
	obj.style.padding = 0;
}

//公文库
function writeIssueTraceDocument(blockDataAry, obj) {
	//取出当前记录数及最大记录数
	var currentrecordcount = blockDataAry.length;
	var maxrecordcount = obj.getAttribute("recordcount");
	//如果当前记录数少于最大记录数，计算出空行数量
	var blankCount = 0;
	if (currentrecordcount < maxrecordcount) blankCount = maxrecordcount - currentrecordcount;
	//写信息块的主体数据，写时要注意两个问题：1、最后一行与前面行的CSS不同；2、空行的处理
	var str	 = "<DIV ID=BlockDetail>\n";
	str 	+= "<ul>\n";
	for (var i = 0; i < currentrecordcount; i++) {
		var record = blockDataAry[i];
		var cssName;
		if (blankCount > 0) {
			cssName = "DetailLine";
		} else {
			cssName = (i + 1) == currentrecordcount ? "EndDetailLine" : "DetailLine";
		}
		str	+= "<LI class=" + cssName + ">\n";
		str += "<DIV CLASS=DetailLineInfo>";
		str	+= "<img border=0 width=8 height=8 src='" + listImg + "'> ";
		str += "<a onClick=\"actionViewIssueTraceDocument('" + record.trace_document_base_id + "');\" href=\"#\">" + record.trace_title + "</a>";
		str += "</DIV>\n";
		str += "<DIV CLASS=DetailLineTime>" + record.document_issue_time + "</DIV>\n";
		str += "<DIV CLASS=DetailLineName>" + record.issue_manager + "</DIV>\n";
		str	+= "</LI>\n";
	}
	if (blankCount > 0) {
		for (var i = 0; i < blankCount; i++) {
			var cssName = (i + 1) == blankCount ? "EndDetailLine" : "DetailLine";
			str += "<LI class=" + cssName + "><DIV></DIV></LI>\n";
		}
	}
	str 	+= "</ul>\n";
	str 	+= "</DIV>\n";
	//写块尾
	str 	+= writeFoot(blankCount, obj);
	obj.innerHTML = str;
	obj.style.padding = 0;
}

//乔国宇新增2012-05-22
//部门主页
function writeDeptHomePage(blockDataAry, obj) {
	//取出当前记录数及最大记录数
	var currentrecordcount = blockDataAry.length;
	var maxrecordcount = obj.getAttribute("recordcount");
	//如果当前记录数少于最大记录数，计算出空行数量
	var blankCount = 0;
	if (currentrecordcount < maxrecordcount) blankCount = maxrecordcount - currentrecordcount;
	//写信息块的主体数据，写时要注意两个问题：1、最后一行与前面行的CSS不同；2、空行的处理
	var str	 = "<DIV ID=BlockDetail>\n";
	str 	+= "<ul>\n";	
	for (var i = 0; i < currentrecordcount; i++) {
		var record = blockDataAry[i];
		var cssName;
		if (blankCount > 0) {
			cssName = "DetailLine";
		} else {
			cssName = (i + 1) == currentrecordcount ? "EndDetailLine" : "DetailLine";
		}
		str	+= "<LI class=" + cssName + ">\n";
		str += "<DIV CLASS=DetailLineInfo>";
		str	+= "<img border=0 width=8 height=8 src='" + listImg + "'> ";			
		str += "<a onClick=\"actDeptHomePageIndex('" + record.dept_blog_page_id + "');\" href=\"#\">" + record.dept_blog_page_title + 
		//文章所属部门
		"[" + record.dept_name + "]</a>";
		str += "</DIV>\n";
		str += "<DIV CLASS=DetailLineTime>" + record.creatdate + "</DIV>\n";
		str += "<DIV CLASS=DetailLineName>" + record.author + "</DIV>\n";
		str	+= "</LI>\n";
	}
	if (blankCount > 0) {
		for (var i = 0; i < blankCount; i++) {
			var cssName = (i + 1) == blankCount ? "EndDetailLine" : "DetailLine";
			str += "<LI class=" + cssName + "><DIV></DIV></LI>\n";
		}
	}
	str 	+= "</ul>\n";
	str 	+= "</DIV>\n";
	//写块尾
	str 	+= writeFoot(blankCount, obj);
	obj.innerHTML = str;
	obj.style.padding = 0;
}

