package com.wolf.hr.struts2.action;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.wolf.hr.domain.User;
import com.wolf.hr.service.LoginService;
import com.wolf.hr.struts2.action.base.BaseAction;
import com.wolf.hr.utils.HRUtils;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BaseAction<User>{
	@Resource(name="loginService")
	private LoginService loginService;
	
    private String validate;
	
	public String getValidate() {
		return validate;
	}
	public void setValidate(String validate) {
		this.validate = validate;
	}
	//为了安全性考虑，代码jsp页面全部放在了WEB-INF下面，所以首先得跳转登录页面
	public String loginUI()
	{
		
		return "loginUI";
	}
	//执行登录验证的方法
	public String login(){
		
		User user = this.loginService.checkUAndP(this.getModel().getUsername(),this.getModel().getPassword());
		if(user!=null){//成功
			//从session中取出RandomAction.java 中生成的验证码random   
			String arandom=(String)(ActionContext.getContext().getSession().get("securityCode"));   
			//validate
			  if(arandom.equals(this.getValidate())) 
				  { 
				     HRUtils.putUser2Session(user);
			         return "index";
				  }
				  else
				  {
					  addFieldError("login1","验证码不正确");
					  return "loginUI"; 
				  }
				
		}else{//失败
			//自己实现
			addFieldError("login2","用户名或密码不正确");
	        return "loginUI";
		}
	}
	//执行登出的方法
	public String Loginout()
	{
		ActionContext.getContext().getSession().remove("user");
		return "loginout";
	}
}
