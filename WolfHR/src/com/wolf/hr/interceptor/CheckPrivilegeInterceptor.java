package com.wolf.hr.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.wolf.hr.domain.User;

@SuppressWarnings("serial")
public class CheckPrivilegeInterceptor implements Interceptor {

	public void init() {
		System.out.println("CheckPrivilegeInterceptor ********* init()");

	}

	public String intercept(ActionInvocation invocation) throws Exception {
		
		Object obj = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		
		if(obj==null||obj.equals("")){
			return "privilegeError";
		}else{
			
			return invocation.invoke(); // 放行";
		}
	}
	
	public void destroy() {
		System.out.println("CheckPrivilegeInterceptor ********* destroy()");

	}

}



