package com.wolf.hr.utils;

import java.util.Arrays;
import java.util.Collections;

import org.apache.struts2.ServletActionContext;

import com.wolf.hr.domain.User;



public class HRUtils {
	public static Long[] string2Longs(String ids){
		String[] s = ids.split(",");
		Long[] aa = new Long[s.length];
		int index = 0;
		for(String string:s){
			aa[index] = Long.valueOf(string);
			index++;
		}
		return aa;
	}
	
	public static User fromSession(){
		return (User)ServletActionContext.getRequest().getSession().getAttribute("user");
	}
	
	public static void putUser2Session(User user){
		ServletActionContext.getRequest().getSession().setAttribute("user", user);
	}
	
}
