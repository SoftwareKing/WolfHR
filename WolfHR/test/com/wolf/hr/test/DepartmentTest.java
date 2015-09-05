package com.wolf.hr.test;

import java.util.Collection;

import org.junit.Test;

import com.wolf.hr.domain.Department;
import com.wolf.hr.service.DepartmentService;


public class DepartmentTest extends BaseSpring{
	@Test
	public void testQuery(){
		DepartmentService departmentService = (DepartmentService)context.getBean("departmentService");
		Collection<Department> departmentList = departmentService.getAllDepartment();
	}
}
