package com.wolf.hr.test;

import org.hibernate.SessionFactory;
import org.junit.Test;

public class SessionFactoryTest extends BaseSpring{
	@Test
	public void testSessionFactory(){
		SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory");
	}
}
