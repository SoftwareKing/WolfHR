package com.wolf.hr.test;

import org.jbpm.api.ProcessEngine;
import org.junit.Test;

public class ProcessEngineTest  extends  BaseSpring{
	@Test
	public void testProcessEngine(){
		ProcessEngine processEngine = (ProcessEngine)context.getBean("processEngine");
	}
}
