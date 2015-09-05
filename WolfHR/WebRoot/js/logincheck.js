var login = {
    formValidate: function(){
        $("input[type='image']").unbind("click");
        $("input[type='image']").bind("click", function(){
            
					if($("#message").text()=="该用户名已经存在"){
						alert("请输入合理的用户名");
						return false;
					}else{
						return true;	
					}
				}
           
        );
    },
    inintEvent: function(){
        $("input[name='username']").unbind("blur");
        $("input[name='username']").bind("blur", function(){
           	user.checkUser($(this).val());
        });
        $("input[name='password]").unbind("blur");
        $("input[name='password']").bind("blur", function(){
           	user.checkpasswordbyUser($(this).val());
        });
    },
	checkUser:function(username){
		var parameter = {
			username:username
		};
		$.ajax({
			type:"POST",
			url:'loginJSONAction_checkUsername.action',
			data:parameter,
			success:function(){
				alert("该用户名正确，请输入您的密码！");
			},
			error:function(){
				alert("该用户名输入错误，请您重新输入!");
			}
		});
	},
	checkpasswordbyUser:function(username,password){
		var parameter = {
			username:username,
			password:password
		};
		$.ajax({
			type:"POST",
			url:'loginJSONAction_checkpasswordbyUsername.action',
			data:parameter,
			success:function(){
				alert("该密码正确!");
			},
			error:function(){
				alert("该密码错误！");
			}
		});
	}
};
$().ready(function(){
	login.formValidate();
	login.inintEvent();
});
