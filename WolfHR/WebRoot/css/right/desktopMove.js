var dragElement = null;	//当前要被移动的模块
var tmpElement = null;	//拖动时模块的阴影
var refElement = null;	//被移动模块要放置的位置原有模块
var rightFlg;			//被移动的模块当前属于左半边还是右半边
var dragingFlg = false;	//当前是否移动状态
var dragElementHeight;	//被移动的模块的总高度
var dragElementWidth;	//被移动的模块的总宽度
var dragActiveFlg = false;	//已经等待好被拖移的状态
//移动过程中寻找位置的方块
var box = document.createElement("div");
box.id = "insertBox";
box.style.border = "2px dotted #aaaaaa";

var downX,downY,tmp_o_x,tmp_o_y;	//位置确认
	
//被移动容器的onMouseDown事件
function readyDrag(eventId){
	dragActiveFlg = true;
	dragingFlg = false;;
	dragElement = document.getElementById(eventId);
	if (dragElement == null) return;
	dragElementHeight = dragElement.offsetHeight;
	dragElementWidth = dragElement.offsetWidth;
	tmpElement = dragElement.cloneNode(true);
	tmpElement.style.filter = "alpha(opacity=60)";
	tmpElement.style.zIndex = 2;
	tmpElement.style.width = dragElementWidth;
	tmpElement.style.Height = dragElementHeight;
	rightFlg = dragElement.parentNode.id == "right";
	dragElement.style.zIndex = 1;
	tmpElement.style.position="absolute";
	if(dragElement.parentNode.tagName!="BODY"){
		dragElement.style.left=dragElement.offsetLeft+dragElement.parentNode.style.pixelLeft;
		dragElement.style.top=dragElement.offsetTop+dragElement.parentNode.style.pixelTop;
	}
	var e = arguments.callee.caller.arguments[0] || event;
	downX = e.clientX;
	downY = e.clientY;
	tmp_o_x=downX - 150;
	tmp_o_y=downY;
	tmpElement.style.visibility="hidden";
	document.body.appendChild(tmpElement);
	document.onmousemove = startDrag;
	document.onmouseup = endDrag;
}

//被移动容器的onmousemove事件
function startDrag(e){
	if (!dragActiveFlg) return;
	var e = e || event;
	if(e.button == 1 && dragElement != null && tmpElement != null){
		tmpElement.style.visibility="visible";
		tmpElement.style.left = tmp_o_x + event.clientX-downX;
		tmpElement.style.top = tmp_o_y + event.clientY-downY;
		document.body.style.cursor = "move";
		dragingFlg = true;
	}
}

//被移动容器的onmouseup事件
function endDrag(){
	if(dragingFlg && dragActiveFlg && refElement!=null && tmpElement!=null && dragElement != null) {
		if (refElement.id == "sub" || refElement.id == "right" || refElement.id == "Content") {
			refElement.insertBefore(dragElement);
		} else {
			refElement.parentNode.insertBefore(dragElement, refElement);
		}
	}
	if (tmpElement != null) tmpElement.parentNode.removeChild(tmpElement);
	dragingFlg = false;
	dragActiveFlg = false;
	document.body.style.cursor="default";
	var boxEle = document.getElementById("insertBox");
	if (boxEle != null) boxEle.removeNode(true);
	dragElement=null;
	tmpElement=null;
	refElement = null;
	downX = 0;
	downY=0;
	tmp_o_x=0;
	tmp_o_y=0;
	initDesktop();
}

document.onselectstart=function(){return false}
document.onmouseover = overInfo;

//当容器移动过程中，遇到其它对象时，在对象的前面要加上一个当前移动对象的虚框
function overInfo(e) {
	if (!dragingFlg) return false;
	var e = e || event;
	var obj = e.srcElement || e.target;
	if (!obj) return false;
	while(obj != null) {
		if(obj.className == "DesktopBlock" && obj.id != dragElement.id) {
			box.style.width = dragElementWidth;
			box.style.height = dragElementHeight;
			obj.parentNode.insertBefore(box, obj);
			refElement = obj;
			return true;
		}
		if (obj.id == "sub" || obj.id == "right") {
			box.style.width = dragElementWidth;
			box.style.height = dragElementHeight;
			obj.insertBefore(box);
			refElement = obj;
			return true;
		}
		obj = obj.parentNode;
	}
}
