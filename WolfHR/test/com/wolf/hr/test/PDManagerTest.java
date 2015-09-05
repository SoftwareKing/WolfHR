package com.wolf.hr.test;

import org.junit.Test;

import com.wolf.hr.service.PDManager;



public class PDManagerTest extends BaseSpring{
	@Test
	public void testPDManager(){
		PDManager pdManager = (PDManager)context.getBean("pdManager");
		pdManager.getLasterVersions();
	}
}
