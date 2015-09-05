package com.wolf.hr.utils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountOnlineNumberListener implements HttpSessionListener {
	public void sessionCreated(HttpSessionEvent se) {
		ServletContext sc = se.getSession().getServletContext();
		Object o = sc.getAttribute("num");
		if(o==null){
			sc.setAttribute("num", 1);
		}else{
			int num = (Integer)o;
			num++;
			sc.setAttribute("num", num);
		}
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		ServletContext sc = se.getSession().getServletContext();
		Object o = sc.getAttribute("num");
		if(o==null){
			sc.setAttribute("num", 1);
		}else{
			int num = (Integer)o;
			num--;
			sc.setAttribute("num", num);
		}
	}

}




