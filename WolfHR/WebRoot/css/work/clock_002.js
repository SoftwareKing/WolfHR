var Frw=150;
var Frh=50;
var Frs=1; 
var Hid=true;

document.writeln('<Div id=Clock scrolling="no" style="color: #2b333c; font-size: 14px; padding: 10px; border:1px solid #EEEEEE; position: absolute; background: #FFFFFF; width: '+Frw+'; z-index: 200; filter :\'progid:DXImageTransform.Microsoft.Shadow(direction=135,color=#AAAAAA,strength='+Frs+')\' ;display: none"></Div>');

function TimeIsTrue(srcObj) {
	 var inputValue1 = srcObj.value;
	 if (inputValue1 == "") return true;
	 var lsTime = inputValue1;
	 var loTime = lsTime.split(":");
	 if (loTime.length!=2) return false;
	 var liHours = parseFloat(loTime[0]);
	 var liMinutes = parseFloat(loTime[1]);
	 if ((loTime[0].length>2)||(loTime[1].length>2)) return false;
	 if (isNaN(liHours)||isNaN(liMinutes)) return false;
	 if ((liHours<0)||(liHours>=24)) return false;
	 if ((liMinutes>=60)||(liMinutes<0)) return false;
	 return !isNaN(Date.UTC(liHours,liMinutes));
}

function TimeOnBlur(srcObj) {
	if (!TimeIsTrue(srcObj)) {
		alert(""+timeErr+"");
	 	srcObj.focus();
	 	srcObj.select();
	}
}

function textOnSelect(thisText) {
	thisText.select();
}

function InputValue1(InputBox,hours,minutes) {
    if (hours < 10) { 
    	hours = '0' + hours;
    }
    if (minutes < 10) {
    	minutes = '0' + minutes;
    }
  	InputBox.value= hours + ':' + minutes
  	HiddenClock();
}

function Nextminutes(InputBox,hours,minutes) {
    minutes = minutes-1;
    if (minutes < 0)
    {
        minutes = 59;
        hours = hours-1;
        if (hours < 0)
            hours = 23;
    }
  	Hid=false;
  	ShowClock(InputBox,hours,minutes)
}

function Forwardminutes(InputBox,hours,minutes) {
    minutes = minutes+1;
    if (minutes > 59)
    {
        minutes = 0;
        hours = hours + 1;
        if (hours > 23)
            hours = 0;
    }
  	Hid=false;
  	ShowClock(InputBox,hours,minutes)
}

function Nexthours(InputBox,hours,minutes) {
    hours = hours-1;
    if (hours < 1)
        hours = 23;
  	Hid=false;
  	ShowClock(InputBox,hours,minutes)
}

function Forwardhours(InputBox,hours,minutes) {
    hours = hours + 1;
    if (hours > 23)
        hours = 0;
  	Hid=false;
  	ShowClock(InputBox,hours,minutes)
}

function OpenTime(where) {
 	GetTimes(where);
 	clo_hideElementAll(document.getElementById("Clock"));
}

function GetTimes(where) {
    Hid=false;
    var Box_Name=where.name;
    var Box_value=where.value;
    if (Box_value != "") {
	    loDate = Box_value.split(":");
	    H = parseFloat(loDate[0]);
	    M = parseFloat(loDate[1]);
	    ShowClock(where,H,M);
    }  else  {
	    time = new Date();
	    h = time.getHours();
	    m = time.getMinutes();
	    ShowClock(where,h,m);
  }
}

function getNowTime() {
    var time = new Date();
    var h = "" + time.getHours();
    var m = "" + time.getMinutes();
    if (h.length == 1) h = "0" + h;
    if (m.length == 1) m = "0" + m;
    return h + ":" + m;
}

function HiddenClock() {
	var colckObj = document.getElementById("Clock");
	colckObj.style.display="none";
	clo_ShowElement();
}

function CloseClock() {
	if (Hid){
		var colckObj = document.getElementById("Clock");
	    colckObj.style.display="none";
    	clo_ShowElement();
    	}
	Hid=true;
}

function ShowClock(InputBox,thisHours,thisMinutes) {
    var NowHours=(thisHours == null? 23:thisHours);
    var NowMinutes=(thisMinutes == null? 0:thisMinutes);
    var Box_Name='document.all.'+InputBox.name;
    var FrameContent = "";
    var Frl,Frt,Winw,Winh;
	/*显示位置*/
	Winw=document.body.offsetWidth;
	Winh=document.body.offsetHeight;
	y1=document.body.scrollTop;
	x=InputBox.getBoundingClientRect().left-2;
	y=InputBox.getBoundingClientRect().bottom+y1;
	if (((x+Frw+Frs)>Winw)&&((Frw+Frs)<Winw)) {
  		x=Winw-Frw-Frs;
  	}
	if (((y1+Winh+Frh+Frs)>2*Winh)&&((Frh+Frs)<Winh)) {
  		y=2*(Winh-Frh-Frs);
	}
	var colckObj = document.getElementById("Clock");
	colckObj.style.display="";
	colckObj.style.left=x;
	colckObj.style.top=y;
	//显示内容
	FrameContent += "<div id=nowHoursDiv style='cursor:pointer; float:left; padding-left: 10px;'  onmouseover='OpenDiv(120,60,"+NowHours+",0);' onclick='noAction();'>";
	FrameContent += NowHours + hours;
	FrameContent += "</div>";
	FrameContent += "<div id=ChangeYear style='float:left; padding-top:3px;padding-left:2px;'><table cellpadding=0 cellspacing=0 border=0 width=10>";
	FrameContent += "	<tr><td height=4 onclick=\"Forwardhours (document.all."+InputBox.name+","+NowHours+","+NowMinutes+")\">" + upImg + "</td><tr>";
	FrameContent += "	<tr><td height=4 onclick=\"Nexthours (document.all."+InputBox.name+","+NowHours+","+NowMinutes+")\">" + downImg + "</td><tr>";
	FrameContent += "</table></div>";
	FrameContent += "<div id=nowMinDiv style='cursor:pointer; float:left; padding-left: 10px;' onmouseover='OpenDiv(120,60,"+NowMinutes+",1);' onclick='noAction();'>";
	FrameContent += NowMinutes + minutes;
	FrameContent += "</div>";
	FrameContent += "<div id=ChangeYear style='padding-top:3px;padding-left:2px;'><table cellpadding=0 cellspacing=0 border=0 width=10>";
	FrameContent += "	<tr><td height=4 onclick=\"Forwardminutes (document.all."+InputBox.name+","+NowHours+","+NowMinutes+")\">" + upImg + "</td><tr>";
	FrameContent += "	<tr><td height=4 onclick=\"Nextminutes (document.all."+InputBox.name+","+NowHours+","+NowMinutes+")\">" + downImg + "</td><tr>";
	FrameContent += "</table></div>";
	FrameContent += "<div id='hourDiv' style='display:none; padding-left:2;'><hr><table width='100%'; style='text-align:center;'>";
	for (h = 0; h <= 23; h=h+6) {
		FrameContent += "<tr>";
		FrameContent += "<td style='cursor:pointer;' onmouseover=\"this.style.background='#A0CD66'\" onmouseout=\"this.style.background='#ffffff'\" onclick='setHourMin(document.all."+InputBox.name+","+h+","+NowMinutes+")'>"+eval(h)+"</td>";
		FrameContent += "<td style='cursor:pointer;' onmouseover=\"this.style.background='#A0CD66'\" onmouseout=\"this.style.background='#ffffff'\" onclick='setHourMin(document.all."+InputBox.name+","+eval(h+1)+","+NowMinutes+")'>"+eval(h+1)+"</td>";
		FrameContent += "<td style='cursor:pointer;' onmouseover=\"this.style.background='#A0CD66'\" onmouseout=\"this.style.background='#ffffff'\" onclick='setHourMin(document.all."+InputBox.name+","+eval(h+2)+","+NowMinutes+")'>"+eval(h+2)+"</td>";
		FrameContent += "<td style='cursor:pointer;' onmouseover=\"this.style.background='#A0CD66'\" onmouseout=\"this.style.background='#ffffff'\" onclick='setHourMin(document.all."+InputBox.name+","+eval(h+3)+","+NowMinutes+")'>"+eval(h+3)+"</td>";
		FrameContent += "<td style='cursor:pointer;' onmouseover=\"this.style.background='#A0CD66'\" onmouseout=\"this.style.background='#ffffff'\" onclick='setHourMin(document.all."+InputBox.name+","+eval(h+4)+","+NowMinutes+")'>"+eval(h+4)+"</td>";
		FrameContent += "<td style='cursor:pointer;' onmouseover=\"this.style.background='#A0CD66'\" onmouseout=\"this.style.background='#ffffff'\" onclick='setHourMin(document.all."+InputBox.name+","+eval(h+5)+","+NowMinutes+")'>"+eval(h+5)+"</td>";
		FrameContent += "</tr>"
	}
	FrameContent += "</table></div>";
	FrameContent += "<div id='minDiv' style='display:none;'><hr><table width='100%' style='text-align:center;'>";
	FrameContent += "<tr>";
	for (m = 0; m <= 25; m=m+5) {		
		FrameContent += "<td style='cursor:pointer;' onmouseover=\"this.style.background='#A0CD66'\" onmouseout=\"this.style.background='#ffffff'\" onclick='setHourMin(document.all."+InputBox.name+","+NowHours+","+m+")'>"+m+"</td>";
	}
	FrameContent += "</tr>";
	FrameContent += "<tr>";
	for (m = 30; m <= 59; m=m+5) {		
		FrameContent += "<td style='cursor:pointer;' onmouseover=\"this.style.background='#A0CD66'\" onmouseout=\"this.style.background='#ffffff'\" onclick='setHourMin(document.all."+InputBox.name+","+NowHours+","+m+")'>"+m+"</td>";
	}
	FrameContent += "</tr>"
	FrameContent += "</table></div>";
	FrameContent += "<div style='float:right; margin-top: 25px;'>";
		FrameContent+="<table cellpadding='0' cellspacing='0' border='0' bgcolor='#FFFFFF'>";
		FrameContent+="<tr>\n";
		FrameContent+="<td width=59 align=right title="+queding+" style='cursor:pointer;' onclick=\"InputValue1(document.all."+InputBox.name+","+NowHours+","+NowMinutes+")\">";
		FrameContent+=saveImg;
		FrameContent+="</td>\n";
		FrameContent+="<td width=15>";
		FrameContent+="</td>\n";
		FrameContent+="<td title="+guanbi+" style='cursor:pointer;' onclick=\"HiddenClock()\">";
		FrameContent+=cancelImg;
		FrameContent+="</td>\n";
		FrameContent+="<td width=5>";
		FrameContent+="</td>\n";
		FrameContent+="</tr>\n";
		FrameContent+="</table>";
	FrameContent += "</div>";
	
	var colckObj = document.getElementById("Clock");
	colckObj.innerHTML=FrameContent;
	colckObj.style.display="";
}

var HideElementTemp = new Array();

//点击菜单时，调用此的函数,菜单对象
function clo_hideElementAll(obj){ 
	clo_HideElement("SELECT",obj);
	clo_HideElement("iframe",obj);
}

function clo_HideElement(strElementTagName,obj){
	try {
		var showDivElement = obj;
		var cloendarDiv = obj;
		var intDivLeft = clo_GetOffsetLeft(showDivElement);
		var intDivTop = clo_GetOffsetTop(showDivElement);//+showDivElement.offsetHeight;
		//HideElementTemp=new Array()
		for(i=0;i<window.document.all.tags(strElementTagName).length; i++){
			var objTemp = window.document.all.tags(strElementTagName)[i];
			if(!objTemp||!objTemp.offsetParent) continue;
			var intObjLeft=clo_GetOffsetLeft(objTemp);
			var intObjTop=clo_GetOffsetTop(objTemp);
			if(((intObjLeft+objTemp.clientWidth)>intDivLeft)&&
				(intObjLeft<intDivLeft+cloendarDiv.style.posWidth)&&
				(intObjTop+objTemp.clientHeight>intDivTop)&&
				(intObjTop<intDivTop+cloendarDiv.style.posHeight+showDivElement.offsetHeight)){
				//var intTempIndex=HideElementTemp.length;//已经有的长度
				//save elementTagName is stutas
				//HideElementTemp[intTempIndex]=new Array(objTemp,objTemp.style.visibility);
				HideElementTemp[HideElementTemp.length]=objTemp
				objTemp.style.visibility="hidden";
			}
		}
	} catch(e){}
}

function clo_ShowElement(){
    var i;
    for(i=0;i<HideElementTemp.length; i++){
 var objTemp = HideElementTemp[i]
 if(!objTemp||!objTemp.offsetParent)
     continue;
 objTemp.style.visibility='';
    }
    HideElementTemp=new Array();
}

function clo_GetOffsetLeft(src){
	var set = 0;
	if (src && src.name != "divMain") {
		if (src.offsetParent) {
			set += src.offsetLeft + clo_GetOffsetLeft(src.offsetParent);
		}
		if (src.tagName.toUpperCase() != "BODY") {
			var x = parseInt(src.scrollLeft,10);
			if(!isNaN(x)) set -= x;
		}
	}
    return set;
}

function clo_GetOffsetTop(src){
	var set = 0;
	if (src && src.name != "divMain") {
		if (src.offsetParent) {
			set += src.offsetTop + clo_GetOffsetTop(src.offsetParent);
		}
		if (src.tagName.toUpperCase() != "BODY") {
			var y = parseInt(src.scrollTop,10);
			if(!isNaN(y)) set -= y;
		}
	}
    return set;
}

document.onclick = CloseClock;

//增加
function $(){return document.getElementById?document.getElementById(arguments[0]):eval(arguments[0]);}

var OverH,OverW,ChangeDesc,ChangeH=50,ChangeW=50;
var objName;

function OpenDiv(_Dw,_Dh,_Desc,key) {
	var divHeight;
	if (key == 0) {
		document.getElementById("nowHoursDiv").style.fontSize=16+"px";
		document.getElementById("nowMinDiv").style.fontSize=14+"px";
		objName = "hourDiv"; 
		CloseDiv(1);
	}
	else {
		document.getElementById("nowMinDiv").style.fontSize=16+"px";
		document.getElementById("nowHoursDiv").style.fontSize=14+"px";
		objName = "minDiv";
		CloseDiv(0);
	}
//	$(objName).innerHTML="";
	OverH=_Dh;
	OverW=_Dw;
	ChangeDesc=_Desc;

	$(objName).style.display='';
	if(_Dw>_Dh){ChangeH=Math.ceil((_Dh-10)/((_Dw-10)/50))}else if(_Dw<_Dh){ChangeW=Math.ceil((_Dw-10)/((_Dh-10)/50))}
	$(objName).style.top=(document.documentElement.clientHeight-10)/2+"px";
	$(objName).style.left=(document.documentElement.clientWidth-10)/2+"px";
	OpenNow(objName)
}

var Nw=10,Nh=10;

function OpenNow(objName) {
	if (Nw>OverW-ChangeW) ChangeW=2;
	if (Nh>OverH-ChangeH) ChangeH=2;
	Nw=Nw+ChangeW;
	Nh=Nh+ChangeH;

if(OverW>Nw||OverH>Nh) {
	if(OverW>Nw) {
	$(objName).style.width=Nw+"px";
	$(objName).style.left=(document.documentElement.clientWidth-Nw)/2+"px";
	}
	if(OverH>Nh) {
	$(objName).style.height=Nh+"px";
	$(objName).style.top=(document.documentElement.clientHeight-Nh)/2+"px"
	}
	window.setTimeout("OpenNow('"+objName+"')",10)
   }else{
	Nw=10;Nh=10;ChangeH=50;ChangeW=50;
//	$(objName).innerHTML=ChangeDesc;
 }
}

function CloseDiv(key) {
	if(key == 0) $("hourDiv").style.display = "none";
	else $("minDiv").style.display = "none";
}

function setHourMin(InputBox,hours,minutes) {
  	Hid=false;
  	ShowClock(InputBox,hours,minutes)	
}

function noAction() {
	Hid=false;
}
