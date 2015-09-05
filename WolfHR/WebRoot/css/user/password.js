function onLoad() {
	init();
	menu();
	if (document.all.actForm.functionName.value == "^^CLOSE") window.close();
}

function submitButton(linkType) {
	if(linkType == "SAVE") {
		var pwdLimitKey = document.getElementById("passwordStrengthLimit").value;
		var pwdMark = passwordGrade(document.getElementById("newPwd").value);
		if (pwdLimitKey=="1" &&  pwdMark <= 10)
		{
			alert(can_not_save_weak_password);
			return false;
		}
	}
	if (document.all.actForm.functionName != null) {
		document.all.actForm.functionName.value = pwdMark;
	}
	if (changePwd()) document.all.actForm.submit();
}

function changePwd() {
	//处理KEY
	if (document.actForm.needKey.value != "1") return true;
	if (document.actForm.newPwd.value != document.actForm.reNewPwd.value) {
		alert(title_password_twos_not_right);
		return false;
	}
	var hCard;
	try {
		hCard = htactx.OpenDevice(1);
	} catch(ex) {
		alert(title_update_password_inner_key);
		return false;
	}
	try {
		htactx.VerifyUserPin(hCard, document.actForm.oldPwd.value);
		htactx.ChangeUserPin(hCard, document.actForm.oldPwd.value, document.actForm.newPwd.value);
		htactx.CloseDevice(hCard);
	} catch (ex) {
		alert(titel_user_or_password_error);
		htactx.CloseDevice(hCard);
		return false;
	}
	return true;
}

//以下是密码强度校验
ratingMsgs = new Array(5);
ratingMsgColors = new Array(5);
barColors = new Array(5);

ratingMsgs[0] = "太短";
ratingMsgs[1] = "弱";
ratingMsgs[2] = "一般";
ratingMsgs[3] = "很好";
ratingMsgs[4] = "极佳";

ratingMsgColors[0] = "#676767";
ratingMsgColors[1] = "#aa0033";
ratingMsgColors[2] = "#f5ac00";
ratingMsgColors[3] = "#6699cc";
ratingMsgColors[4] = "#008000";

barColors[0] = "#dddddd";
barColors[1] = "#aa0033";
barColors[2] = "#ffcc33";
barColors[3] = "#6699cc";
barColors[4] = "#008000";

function passwordGrade(pwd) 
{
    var score = 0;
    var regexArr = ['[0-9]', '[a-z]', '[A-Z]', '[\\W_]'];
	//简单密码数组，这些密码不被允许保存
	var specialPwdAry = ['123456'];
	for (var j = 0; j < specialPwdAry.length ; j++)
	{
		if(pwd == specialPwdAry[j]) return 0;
	}
    var repeatCount = 0;
    var prevChar = '';
    //长度一个加一分，大于18按18算 
    var len = pwd.length;
    score += len > 18 ? 18 : len;
    //字符类型多一个加4分 
    for (var i = 0, num = regexArr.length; i < num; i++) {
        if (eval('/' + regexArr[i] + '/').test(pwd)) {
            score += 4;
        }
    }
    for (var i = 0, num = regexArr.length; i < num; i++) 
    {
        if (pwd.match(eval('/' + regexArr[i] + '/g')) && pwd.match(eval('/' + regexArr[i] + '/g')).length >= 2) {
            score += 2;
        }
        if (pwd.match(eval('/' + regexArr[i] + '/g')) && pwd.match(eval('/' + regexArr[i] + '/g')).length >= 5) {
            score += 2;
        }
    }
    //重复一次减一分
    for (var i = 0, num = pwd.length; i < num; i++) {
        if (pwd.charAt(i) == prevChar) {
            if(num > 18) continue;
			repeatCount++;
        }
        else {
            prevChar = pwd.charAt(i);
        }
    }
    score -= repeatCount * 1;
    return score;
}

//pwStrength函数 
//当用户放开键盘或密码输入框失去焦点时,根据不同的级别显示不同的颜色
function pwStrength(pwd)
{
    if (pwd == null || pwd == '') {
        resetBar();
    }
    else
    {
        if (pwd.length < 6) {
            DrawBar(0);
            return;
        }
        var S_level;
        mark = passwordGrade(pwd);
        //弱
        if (mark <= 10) {
            S_level = 1;
        }
        //一般
        if (mark > 10 && mark <= 20) {
            S_level = 2;
        }
        //很好
        if (mark > 20 && mark <= 30) {
            S_level = 3;
        }
        //极佳
        if (mark > 30) {
            S_level = 4;
        }
        DrawBar(S_level);
    }
    return;
}

function DrawBar(rating) 
{
    var posbar = getElement('posBar');
    var negbar = getElement('negBar');
    var passwdRating = getElement('passwdRating');
    var barLength = getElement('passwdBarDiv').width;
    if (rating >= 0 && rating <= 4) {
        posbar.style.width = barLength  / 4 * rating;
        negbar.style.width = barLength  / 4 * (4 - rating);
    }
    else {
        posbar.style.width = 0;
        negbar.style.width = barLength;
        rating = 5;
    }
    posbar.style.background = barColors[rating];
    passwdRating.innerHTML = "<font color='" + ratingMsgColors[rating] + "'>" + ratingMsgs[rating] + "</font>";
}

function resetBar() 
{
    var posbar = getElement('posBar');
    var negbar = getElement('negBar');
    var passwdRating = getElement('passwdRating');
    var barLength = getElement('passwdBar').width;
    posbar.style.width = "0px";
    negbar.style.width = barLength + "px";
    passwdRating.innerHTML = "";
}

function getElement(name) 
{
    if (document.all) {
        return document.all(name);
    }
    return document.getElementById(name);
}


