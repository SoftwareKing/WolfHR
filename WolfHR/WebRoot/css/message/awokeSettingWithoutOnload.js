var parentWin;
var currentDetail;
function awokeSettingLoad() {
	//Modified by xiaogang 2012-01-09 增加try catch 事务设置画面 弹出JS错误
	try{
	
		var pathAry = parentWin.parent.pathAry;
		var step_id = parentWin.document.all.pathOrder.value;
		count = pathAry.length;
		for (var i = 0; i < count; i ++) {
			var detail = pathAry[i];
			
			if (detail.stepId == step_id) {
	    		currentDetail = detail;
				indexInPathAry = i;
				break;
			}
		}
	    //取得主表字段
	    var mainFieldAry = parentWin.parent.mainFieldArray;
	    //取得细表字段
	    var listClassAry = parentWin.parent.listFieldArray;
	    //初始化基本字段属性--主表
	    if (mainFieldAry != null && mainFieldAry.length > 0) {
	    	var count = mainFieldAry.length;
			var eItem = document.createElement ("OPTION");
			document.actForm.selectedGamenParts.add (eItem);
			eItem.innerText = title_no_select;
			eItem.value = "";
	    	for (var i = 0; i < count; i++) {
	    		var field = mainFieldAry[i];
	    		if (field == "") continue;
	    		var fieldValue = field.fieldName;
	        	createOptionJudge(document.actForm.selectedGamenParts, field.fieldName, fieldValue,document.getElementById("selectGamenPart").value);
	    	}
	    }
	}catch(Ex){
	}
	
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
function createOptionJudge (s, txt, v, sel) {
	var eItem = document.createElement ("OPTION");
	s.add (eItem);
	eItem.innerText = txt;
	eItem.value = v;
	if(v == sel) eItem.selected = true;
}

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

// 超时提醒 超时处理 超时统计checkbox控制 （放弃超时处理功能）
function checkBoxChange () {		
    var div1 = document.getElementById("warnSetting1");
    var div2 = document.getElementById("warnSetting2");
//	var div3 = document.getElementById("timeoutDetailSetting");
	div1.style.display = "none";
	div2.style.display = "none";
//	div3.style.display = "none";
	
	var firstObj = document.getElementById("warnCheck");
	var secondObj = document.getElementById("timeoutCheck");
//	var thirdObj = document.getElementById("timeoutDetailCheck");
	if (firstObj.checked) {
	     div1.style.display = "";
	     div2.style.display = "";
	} 
	if (secondObj.checked) {	
	     div1.style.display = "";
	} 
//	if (thirdObj.checked) {
//	    div1.style.display = "";
//	    div3.style.display = "";
//
//        }
    if (firstObj.checked) {
	     secondObj.checked = true;
	}
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

function setGamenPart(){
document.getElementById("selectGamenPart").value = document.getElementById("selectedGamenParts").value;

}