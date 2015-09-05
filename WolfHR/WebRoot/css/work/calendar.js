/*基本参数*/
var Frw = 150; //日历宽度
var Frh = 137; //日历高度
var Frs = 4;   //影子大小
var Hid = true;//日历是否打开

/*创建框架*/
document.writeln('<Div id=Calendar scrolling="no" style="border:0px solid #EEEEEE ;position: absolute; width: '+Frw+'; height: '+Frh+'; z-index: 200; filter :\'progid:DXImageTransform.Microsoft.Shadow(direction=135,color=#AAAAAA,strength='+Frs+')\' ;display: none"></Div>');

/*取得今日日期*/
function GetTodayDate() {
	var today = new Date();
	var year = today.getYear();
	if(year < 1900) year += 1900;
	var month = today.getMonth() + 1;
	if (month < 10) month = '0' + month;
	var day = today.getDate();
	if ( day < 10) day = '0' + day;
	return year + '-' + month + '-' + day;
}

/*输入今天日期*/
function SetTodayDate(InputBox)  {
	HiddenCalendar();
	InputBox.value = GetTodayDate();
	//对自定义平台宏控件的追加处理，显示自定义格式
	if (InputBox.getAttribute("showStyle")) {
		dateFamate(InputBox);
	}
}

/*取某年某月第一天的星期值(月份-1)*/
function GetFirstWeek(The_Year,The_Month) {
	return (new Date(The_Year, The_Month-1, 1)).getDay();
}

/*取某年某月中总天数*/
function GetThisDays(The_Year, The_Month) {
	return (new Date(The_Year, The_Month, 0)).getDate();
}

/*取某年某月上个月中总天数*/
function GetLastDays(The_Year, The_Month) {
	return (new Date(The_Year, The_Month-1, 0)).getDate()
}

/*判断是否是闰年*/
function RunNian(The_Year) {
	if ((The_Year%400 == 0) || ((The_Year%4 == 0) && (The_Year % 100 != 0)))
		return true;
	return false;
}

/* 判断日期(YYYY-MM-DD)的日期是否正确 */
function DateIsTrue(srcObj) {
	 var inputValue = srcObj.value;
	 if (inputValue == "") return true;
	 var lsDate  = inputValue;
	 var loDate  = lsDate.split("-");
	 if (loDate.length != 3) return false;
	 var liYear  = parseInt(loDate[0]);
	 var liMonth = parseFloat(loDate[1]);
	 var liDay   = parseInt(loDate[2]);
	 if ((loDate[0].length > 4) || (loDate[1].length > 2)|| (loDate[2].length > 2)) return false;
	 if (isNaN(liYear) || isNaN(liMonth) || isNaN(liDay)) return false;
	 if ((liYear < 1800) || (liYear > 2500)) return false;
	 if ((liMonth > 12) || (liMonth <= 0))   return false;
	 if (GetThisDays(liYear, liMonth) < liDay) return false;
	 return !isNaN(Date.UTC(liYear, liMonth, liDay));
}

//输入框 onBlur
function TextOnBlur(srcObj) {
	if (!DateIsTrue(srcObj)) {
	 	srcObj.focus();
	 	srcObj.select();
	 	alert(dateErr);
	 	setTimeout(function() { srcObj.focus(); srcObj.select(); }, 0);
	}
}

/*取某年某月的周值*/
function GetCountWeeks(The_Year, The_Month) {
	var Allday;
	Allday = 0;
	if (The_Year > 2000) {
		for (i=2000 ;i < The_Year; i++) 
		if (RunNian(i)) 
			Allday += 366;
		else
			Allday += 365;
		for (i = 2; i <= The_Month; i++) {
			switch (i) {
				case 2 : 
					Allday += 28;
					if (RunNian(The_Year)) Allday += 1;
					break;
				case 3  : Allday += 31; break;
				case 4  : Allday += 30; break;
				case 5  : Allday += 31; break;
				case 6  : Allday += 30; break;
				case 7  : Allday += 31; break;
				case 8  : Allday += 31; break;
				case 9  : Allday += 30; break;
				case 10 : Allday += 31; break;
				case 11 : Allday += 30; break;
				case 12 : Allday += 31; break;
			}
		}
	}
	return (Allday + 6) % 7;
}

/*输入框显示*/
function InputValue(InputBox, Year, Month, Day) {
	if (Month < 10) Month = '0' + Month;
	if (Day < 10) Day = '0' + Day;
	InputBox.value = Year + "-" + Month + "-" + Day;
	//对自定义平台宏控件的追加处理，显示自定义格式
	if (InputBox.getAttribute("showStyle")) {
		dateFamate(InputBox);
	}
}

//上一月
function ForwardMonth(InputBox, Year, Month, Day) {
    Month = Month - 1;
    if (Month < 1) {
        Month = 12;
        Year = Year - 1;
        if (Year < 1800) Year = 2500;
	}
	Day = ((GetThisDays(Year, Month) < Day) ? GetThisDays(Year, Month) : Day);
	Hid = false;
	ShowCalendar(InputBox, Year, Month, Day); 
}

//下一月
function NextMonth(InputBox, Year, Month, Day) {
    Month = Month + 1;
    if (Month > 12) {
        Month = 1;
        Year = Year + 1;
        if (Year > 2500) Year = 1800;
    }
	Day = ((GetThisDays(Year, Month) < Day) ? GetThisDays(Year, Month) : Day);
	Hid = false;
	ShowCalendar(InputBox, Year, Month, Day); 
}

//上一年
function ForwardYear(InputBox, Year, Month, Day) {
    Year = Year - 1;
    if (Year < 1800) Year = 2500;
	Day = ((GetThisDays(Year, Month) < Day) ? GetThisDays(Year, Month) : Day);
	Hid = false;
	ShowCalendar(InputBox, Year, Month, Day); 
}

//下一年
function NextYear(InputBox, Year, Month, Day) {
    Year = Year + 1;
    if (Year > 2500) Year=1800;
	Day = ((GetThisDays(Year, Month) < Day) ? GetThisDays(Year, Month) : Day);
	Hid = false;
	ShowCalendar(InputBox, Year, Month, Day); 
}

/*其它事件显示日历*/
function OpenDate(where) {	
 	GetCalendar(where);
 	cal_hideElementAll(document.getElementById("Calendar"));
}

/*根据输入框中的日期显示日历*/
function GetCalendar(where) {
    Hid = false;
    var Box_Name = where.name;
    var Box_value = where.value;
	if (Box_value != "" && DateIsTrue(where)) {
		var loDate = Box_value.split("-");
		var Year = parseFloat(loDate[0]);
		var Month = parseFloat(loDate[1]);
		var Day = parseFloat(loDate[2]);
		ShowCalendar(where, Year, Month, Day);
    } else {
		var today = new Date();
		var year = today.getYear();
		if(year < 1900) year += 1900;
		var month = (today.getMonth() + 1);
		var day = today.getDate();
		ShowCalendar(where, year, month, day);
	}
}

/*隐藏日历*/
function HiddenCalendar() {	
	document.getElementById("Calendar").style.display = "none";
	cal_ShowElement();
}

function CloseCalendar() {
	if (Hid) {
		cal_ShowElement();
		document.getElementById("Calendar").style.display="none";
	}
	Hid = true;
}

/*显示日历*/
function ShowCalendar(InputBox, The_Year, The_Month, The_Day) {
    var Now_Year = (The_Year == null ? 2004 : The_Year);
    var Now_Month = (The_Month == null ? 1 : The_Month);
    var Now_Day = (The_Day == null ? 1 : The_Day);
    var Box_Name = 'document.all.' + InputBox.name;
    var fw = GetFirstWeek(Now_Year, Now_Month);
    var ld = GetLastDays(Now_Year, Now_Month);
    var td = GetThisDays(Now_Year, Now_Month);
    var isnd = false; //是否是下个月的日期
    var d = 1,w = 1;
    var FrameContent;
    /*显示的位置*/
	Winw = document.body.offsetWidth;
	Winh = document.body.offsetHeight;
	y1 = document.body.scrollTop;
	x = InputBox.getBoundingClientRect().left - 2;
	y = InputBox.getBoundingClientRect().bottom + y1;
	if (((x + Frw + Frs) > Winw) && ((Frw + Frs) < Winw)) {
  		x = Winw - Frw - Frs;
  	}
  //时间控件弹出超过一个滚动画面位置错误  2012-03-12 田禹修改
	//if (((y1 + Winh + Frh + Frs) > 2 * Winh) && ((Frh + Frs) < Winh)) {
  //		y = 2 * (Winh - Frh - Frs);
	//}
	var calendarObj = document.getElementById("Calendar");
	calendarObj.style.display = "";
	calendarObj.style.left = x;
	calendarObj.style.top = y;
	
	//显示日历内容
	FrameContent = "<table border='0' cellpadding='0' cellspacing='0' bgcolor='#FFFBD1' width='100%' height='15' style='font-weight:bolder;border:0px solid;'>";
	FrameContent += "<tr>";
	FrameContent += "<td width=8 title=" + lastyear + " style='background-color: #FFFBD1;font-weight: bold;font-family: 宋体;font-size: 9pt;'>";
	FrameContent += "<font size=0 style='cursor:pointer;' onclick='ForwardYear (document.all." + InputBox.name + ", " + Now_Year+ "," + Now_Month + ", " + Now_Day + ")'>&lt;&lt;</font>";
	FrameContent += "</td>";
	FrameContent += "<td vAlign=middle align='center'>";
	FrameContent += Now_Year + "" + year + "";
	FrameContent += "</td>";
	FrameContent += "<td width=8 title=" + nextyear + ">";
	FrameContent += "<font size=0 style='cursor:pointer' onclick='NextYear (document.all." + InputBox.name + ", " + Now_Year + "," + Now_Month + ", " + Now_Day + ")'>&gt;&gt;</font>";
	FrameContent += "</td>";
	FrameContent += "<td width=8 title=" + lastmonth + ">";
	FrameContent += "<font size=0 style='cursor:pointer' onclick='ForwardMonth (document.all." + InputBox.name + ", " + Now_Year + ", " + Now_Month + ", " + Now_Day + ")'>&lt;&lt;</font>";
	FrameContent += "</td>";
	FrameContent += "<td vAlign=middle align='center' width='16'>";
	FrameContent += Now_Month;
	FrameContent += "</td>";
	FrameContent += "<td vAlign=middle align='center' width='13'>";
	FrameContent += "" + month + "";
	FrameContent += "</td>";
	FrameContent += "<td width=8 title=" + nextmonth + ">";
	FrameContent += "<font size=0 style='cursor:pointer' onclick='NextMonth (document.all." + InputBox.name + ", " + Now_Year + "," + Now_Month + ", " + Now_Day + ")'>&gt;&gt;</font>";
	FrameContent += "</td>";
	FrameContent += "</tr>";
	FrameContent += "</table>";
	
	FrameContent += "<table onselectstart='return false;' border='1' cellpadding='1' cellspacing='1' width='100%' bgcolor='#B0B0FF' bordercolorlight='#184785' bordercolordark='#FFFFFF'>";
	FrameContent += "<tr style='background-color: #DBEAE8;font-family: 宋体;font-size: 10pt;cursor:pointer;'>";
	FrameContent += "<td><center>" + num1 + "</center></td>";
	FrameContent += "<td><center>" + num2 + "</center></td>";
	FrameContent += "<td><center>" + num3 + "</center></td>";
	FrameContent += "<td><center>" + num4 + "</center></td>";
	FrameContent += "<td><center>" + num5 + "</center></td>";
	FrameContent += "<td><center>" + num6 + "</center></td>";
	FrameContent += "<td><center><font color='#FF0000'>" + num7 + "</font></center></td>";
	FrameContent += "</tr>";

	//如果本月第一天是星期一或星期天.应加上七.保证可以看到上个月的日期
	if ( fw < 2)
		tf = fw + 7;
	else
		tf = fw;
	FrameContent += "<tr bgcolor='#B0B0FF'>";
	//第一行上月日期
	for (l = (ld - tf + 2); l <= ld; l++) {
		FrameContent += "<td onclick='ForwardMonth (document.all." + InputBox.name + ", " + Now_Year + ", " + Now_Month + ", " + l +")' style='cursor:pointer'><center><font color='#BBBBBB'>"+l+"</font></center></td>";
		w++;
	}
	//第一行本月日期
	for (f = tf; f <= 7; f++) {
		//星期天但非输入日期
		if (((w % 7) == 0) && (d != Now_Day)) {
			FrameContent += "<td onMouseOver=\"this.style.background=\'#B0B0FF\'\" onMouseOut=\"this.style.background=\'#B0B0FF\'\" onClick=\"InputValue(document.all."+InputBox.name+","+Now_Year+","+Now_Month+","+d+");HiddenCalendar()\" style='cursor:pointer'><center><font color='#FF0000'>"+d+"</font></center></td>";
		//日期为输入日期
        } else if (d == Now_Day) {
			FrameContent += "<td style=\"background:#B0B0FF;cursor:pointer\" onClick=\"InputValue(document.all."+InputBox.name+","+Now_Year+","+Now_Month+","+d+");HiddenCalendar()\"><center><font color='#FFFFFF'>"+d+"</font></center></td>";
		//其它
        } else {
           FrameContent += "<td onMouseOver=\"this.style.background=\'#B0B0FF\'\" onMouseOut=\"this.style.background=\'#B0B0FF\'\" onClick=\"InputValue(document.all."+InputBox.name+","+Now_Year+","+Now_Month+","+d+");HiddenCalendar()\" style='cursor:pointer'><center>"+d+"</center></td>";
        }
        d++;
        w++;
	}
	FrameContent += "</tr>";
	w = 1;
	for (i = 2;i < 7; i++) {
		FrameContent += "<tr bgcolor='#B0B0FF'>";
		for (j = 1;j < 8; j++) {
			if (isnd) { //下个月的日期
				FrameContent += "<td style='cursor:pointer' onclick=\"NextMonth (document.all."+InputBox.name+","+Now_Year+","+Now_Month+","+d+")\"><center><font color='#BBBBBB'>"+d+"</font></center></td>";
			} else { //本月的日期
				//星期天但非输入日期
				if (((w % 7) == 0) && (d != Now_Day)) {
					FrameContent += "<td onMouseOver=\"this.style.background=\'#B0B0FF\'\" onMouseOut=\"this.style.background=\'#B0B0FF\'\" onClick=\"InputValue(document.all."+InputBox.name+","+Now_Year+","+Now_Month+","+d+");HiddenCalendar()\" style='cursor:pointer'><center><font color='#FF0000'>"+d+"</font></center></td>";
				} else if (d == Now_Day) { //日期为输入日期
					FrameContent += "<td style=\"background:#420042;cursor:pointer\" onClick=\"InputValue(document.all."+InputBox.name+","+Now_Year+","+Now_Month+","+d+");HiddenCalendar()\"><center><font color='#FFFFFF'>"+d+"</font></center></td>";
				} else { //其它
		             FrameContent += "<td onMouseOver=\"this.style.background=\'#B0B0FF\'\" onMouseOut=\"this.style.background=\'#B0B0FF\'\" onClick=\"InputValue(document.all."+InputBox.name+","+Now_Year+","+Now_Month+","+d+");HiddenCalendar()\" style='cursor:pointer'><center>"+d+"</center></td>";
		        }
			}
			//判断是否为本月的日期
			if (d == td) {
				isnd = true;
				d = 0;
			}
			w++;
			d++;
		}
		FrameContent += "</tr>";
	}
	FrameContent += "</table>";

	FrameContent += "<table onselectstart='return false;' cellpadding='0' cellspacing='0' bgcolor='#F5F5F5' width='100%' height='15'>";
	FrameContent += "<tr>";
	FrameContent += "<td title='" + toThisDay + "" + GetTodayDate() + "' style='cursor:pointer' onclick='SetTodayDate(document.all." + InputBox.name + ")'>";
	FrameContent += "<font color=red>" + toThisDay + "</font>" + GetTodayDate();
	FrameContent += "</td>";
	FrameContent += "<td title=" + guanbi + ">";
	FrameContent += "<span style='cursor:pointer;' onclick='HiddenCalendar()'>" + cancelImg + "</span>";
	FrameContent += "</td>";
	FrameContent += "</tr>";
	FrameContent += "</table>";
	calendarObj.innerHTML = FrameContent;
	calendarObj.style.display = "";
}

/*显示输入框*/
function DateBox(sBoxName, sDfltValue) {
    if (sBoxName == null) sBoxName='Date_Box'
    if ((sDfltValue == null) || !(DateIsTrue(sDfltValue))) {
		sDfltValue= GetTodayDate();
    } else {
		DateStr = sDfltValue.split("-");
		y = parseFloat(DateStr[0]);
		M = (parseFloat(DateStr[1]) < 10) ? ('0' + parseFloat(DateStr[1])) : parseFloat(DateStr[1]);
		D = (parseFloat(DateStr[2]) < 10) ? ('0' + parseFloat(DateStr[2])) : parseFloat(DateStr[2]);
		sDfltValue = y + '-' + M + '-' + D;
    }
    document.write("<input size='10' readonly class='inputdate' name='"+sBoxName+"' value='"+sDfltValue+"' onclick='GetCalendar(document.all."+sBoxName+")' >");
}

var HideElementTemp = new Array();

//点击菜单时，调用此的函数,菜单对象
function cal_hideElementAll(obj){ 
	cal_HideElement("SELECT",obj);
	cal_HideElement("iframe",obj);
}

function cal_HideElement(strElementTagName,obj) {
	try {
		var showDivElement = obj;
		var calendarDiv = obj;
		var intDivLeft = cal_GetOffsetLeft(showDivElement);
		var intDivTop = cal_GetOffsetTop(showDivElement);	//+showDivElement.offsetHeight;

		var strElementTagNameAry = document.getElementsByTagName(strElementTagName);
		for(var i = 0; i < strElementTagNameAry.length; i++) {
			var objTemp = strElementTagNameAry[i];
			if(!objTemp || !objTemp.offsetParent) continue;
			var intObjTop = cal_GetOffsetTop(objTemp);
			var intObjLeft = cal_GetOffsetLeft(objTemp);
			if((intObjTop + objTemp.clientHeight) <= intDivTop) continue;
			if((intObjLeft + objTemp.clientWidth) <= intDivLeft) continue;
			if(intObjLeft >= (intDivLeft + calendarDiv.style.posWidth)) continue;
			if(intObjTop >= (intDivTop + calendarDiv.style.posHeight + showDivElement.offsetHeight)) continue;
			HideElementTemp[HideElementTemp.length] = objTemp;
			objTemp.style.visibility = "hidden";
		}
	} catch(e){}
}

function cal_ShowElement(){
    for(var i = 0; i< HideElementTemp.length; i++){
		 var objTemp = HideElementTemp[i]
		 if(!objTemp || !objTemp.offsetParent) continue;
		 objTemp.style.visibility = '';
    }
    HideElementTemp = new Array();
}

function cal_GetOffsetLeft(src){
    var set=0;
    if(src && src.name!="divMain"){
		if (src.offsetParent){
			set+=src.offsetLeft+cal_GetOffsetLeft(src.offsetParent);
		}
		if(src.tagName.toUpperCase()!="BODY"){
			var x=parseInt(src.scrollLeft,10);
			if(!isNaN(x)) set-=x;
		}
    }
    return set;
}

function cal_GetOffsetTop(src){
    var set = 0;
	if(src && src.name != "divMain"){
		if (src.offsetParent){
			set+=src.offsetTop+cal_GetOffsetTop(src.offsetParent);
		}
		if(src.tagName.toUpperCase()!="BODY"){
			var y = parseInt(src.scrollTop,10);
			if(!isNaN(y)) set-=y;
		}
    }
    return set;
}

document.onclick = CloseCalendar;

//以下方法是日期的扩展
var now = new Date();                    //当前日期       
var nowDayOfWeek = now.getDay();         //今天本周的第几天       
var nowDay = now.getDate();              //当前日       
var nowMonth = now.getMonth();           //当前月       
var nowYear = now.getYear();             //当前年       
nowYear += (nowYear < 2000) ? 1900 : 0;
      
//格式化日期：yyyy-MM-dd       
function formatDate(date) {
   if (date==undefined) return "";       
    var myyear = date.getFullYear();
    var mymonth = date.getMonth() + 1;       
    var myweekday = date.getDate();
    if(mymonth < 10) mymonth = "0" + mymonth;
    if(myweekday < 10) myweekday = "0" + myweekday;
    return (myyear + "-" + mymonth + "-" + myweekday);
}

//取得今日月份 YYYYMM
function getTodayMonth() {
	var today = new Date();
	var year = today.getYear();
	var month = (today.getMonth() + 1);
	if(month < 10) month = '0' + month;
	return year + '' + month;
}

//取得今日季度 YYYYQ(1234)
function getTodayQuarter() {
	var today = new Date();
	var year = today.getYear();
	var quarter = Math.ceil(today.getMonth()/3);
	//20120111 zhangyi 对1季度的计算有错误
	if(quarter==0) quarter=1;
	return year + 'Q' + quarter;
}
      
//获得某月的天数
function getMonthDays(myMonth) {
    var monthStartDate = new Date(nowYear, myMonth, 1);
    var monthEndDate = new Date(nowYear, myMonth + 1, 1);
    var days = (monthEndDate - monthStartDate)/(1000 * 60 * 60 * 24);
    return days;
}
      
//获得本季度的开始月份       
function getQuarterStartMonth(){       
    var quarterStartMonth = 0;       
    if(nowMonth<3){       
        quarterStartMonth = 0;
     }       
    if(2<nowMonth && nowMonth<6){       
        quarterStartMonth = 3;       
     }       
    if(5<nowMonth && nowMonth<9){       
        quarterStartMonth = 6;       
     }       
    if(nowMonth>8){       
        quarterStartMonth = 9;       
     }       
    return quarterStartMonth;       
}
      
//获得本周的开始日期       
function getWeekStartDate() {
    var weekStartDate = new Date(nowYear, nowMonth, nowDay - nowDayOfWeek);        
    return formatDate(weekStartDate);       
}
      
//获得本周的结束日期       
function getWeekEndDate() {        
    var weekEndDate = new Date(nowYear, nowMonth, nowDay + (6 - nowDayOfWeek));        
    return formatDate(weekEndDate);       
}
      
//获得本月的开始日期       
function getMonthStartDate(){       
    var monthStartDate = new Date(nowYear, nowMonth, 1);        
    return formatDate(monthStartDate);       
}       
      
//获得本月的结束日期       
function getMonthEndDate(){       
    var monthEndDate = new Date(nowYear, nowMonth, getMonthDays(nowMonth));        
    return formatDate(monthEndDate);       
}       
      
//获得本季度的开始日期       
function getQuarterStartDate(){       
    var quarterStartDate = new Date(nowYear, getQuarterStartMonth(), 1);        
    return formatDate(quarterStartDate);       
}       
      
//获得本季度的结束日期       
function getQuarterEndDate(){       
    var quarterEndMonth = getQuarterStartMonth() + 2;       
    var quarterStartDate = new Date(nowYear, quarterEndMonth, getMonthDays(quarterEndMonth));        
    return formatDate(quarterStartDate);       
}

//获得本年的开始日期       
function getYearStartDate(){       
    var yearStartDate = new Date(nowYear, 0, 1);
    return formatDate(yearStartDate);
}

//获得本年的结束日期       
function getYearEndDate(){       
    var yearEndDate = new Date(nowYear, 11, 31);
    return formatDate(yearEndDate);
}

//获得计算的日期
//calDate : 待计算日期
//addYear ：增加的年数
//addMonth ：增加的月数
//addDay ：增加的天数
function getCalDate(calDate, addYear, addMonth, addDay) {
	var useDate = calDate ? calDate : new Date();
	var year = useDate.getYear();           //年份
	if (year < 1900) year += 1900;
	if (addYear) year += addYear;
	var month = useDate.getMonth();         //月份
	if (addMonth) month += addMonth;
	var day = useDate.getDate();          	//日期
	if (addDay) day += addDay;
    var calDate = new Date(year, month, day);
    return formatDate(calDate);
}

//获得计算的月份
//calDate : 待计算日期
//addYear ：增加的年数
//addMonth ：增加的月数
function getCalMonth(calDate, addYear, addMonth) {
	var useDate = calDate ? calDate : new Date();
	var year = useDate.getYear();           //年份
	if (year < 1900) year += 1900;
	if (addYear) year += addYear;
	var month = useDate.getMonth();         //月份
	if (addMonth) month += addMonth;
	//计算后的年月
    var calDate = new Date(year, month, 1);
    var calYear = calDate.getYear();           //年份
	if (calYear < 1900) calYear += 1900;
	var calMonth = calDate.getMonth() + 1;     //月份
    if(calMonth < 10) calMonth = "0" + calMonth;
	return calYear + '' + calMonth;
}
