package com.wolf.hr.test;

import org.junit.Test;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.wolf.hr.domain.User;
import com.wolf.hr.service.UserService;
import com.wolf.hr.service.impl.UserServiceImpl;

public class UserTest extends BaseSpring{

	private UserService userService = new UserServiceImpl() ;
	@Test
	public void test1(){
		User user = userService.getUser() ;
		System.out.println("工作经历 ："+user.getUserwork().size());
		System.out.println("教育经历 ："+user.getUseredu().size());
		System.out.println(user.getUsermanger().getDanganhao());
	}
	@Test
	public void test2(){
		HibernateTemplate hibernateTemplate = (HibernateTemplate) context.getBean("hibernateTemplate") ;
		User user = (User) hibernateTemplate.find("From User where uid=?",3L).get(0) ;
		System.out.println(user.getUsername());
	}
	
}
