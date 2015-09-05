var user = {
    formValidate: function(){
        $("input[type='image']").unbind("click");
        $("input[type='image']").bind("click", function(){
            if ($("select[name='did'] option:selected").attr("value") == "") {
                alert("请选择部门");
                return false;
            }
            else {
                if (!$("select[name='pids'] option:selected").attr("value")) {
                    alert("请选择岗位");
					return false;
                }else{
					if($("#message").text()=="该用户名已经存在"){
						alert("请输入合理的用户名");
						return false;
					}else{
						return true;	
					}
				}
                return true;
            }
        });
    },
    inintEvent: function(){
        $("input[name='username']").unbind("blur");
        $("input[name='username']").bind("blur", function(){
           	user.checkUser($(this).val());
        });
    },
	checkUser:function(username){
		var parameter = {
			username:username
		};
//		$.post("userJSONAction_checkUsername.action",parameter,function(data){
//			$("#message").text(data.message);
//			if(data.message=="该用户名可以使用"){
//				$("#message").css("color","blue");
//			}else{
//				$("#message").css("color","red");
//			}
//		});	
		$.ajax({
			type:"POST",
			url:'userJSONAction_checkUsername.action',
			data:parameter,
			success:function(){
				alert("该用户名可以用!");
			},
			error:function(){
				alert("该密码错误！");
			}
		});
	}
};
$().ready(function(){
	user.formValidate();
	user.inintEvent();
});
