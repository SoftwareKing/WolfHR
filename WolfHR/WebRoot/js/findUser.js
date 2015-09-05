
function findUser(){
		var jobnumber = document.getElementById("jobnumbers").value;
		var username = document.getElementById("usernames").value;
		var did = document.getElementById("did").value;
		if(jobnumber!=""&&username==""&&did==""){
			formUser.action = "userAction_getUserByJobnumber.action";
			formUser.submit() ;
		} else if(username != ""&&jobnumber==""&&did==""){
			formUser.action = "userAction_getUserByUsername.action";
			formUser.submit();
		} else if(did != ""&&username == ""&&jobnumber==""){
			formUser.action = "userAction_getUserBydid.action";
			formUser.submit();
		}
	}





