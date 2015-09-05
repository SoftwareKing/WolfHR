package com.wolf.hr.service;

import java.io.Serializable;
import java.util.Collection;

import com.wolf.hr.domain.Department;



public interface DepartmentService {
	public void saveDepartment(Department department);

	public void updateDeparment(Department department);

	public void deleteDepartmentByID(Serializable id,String deleteMode);

	public Collection<Department> getAllDepartment();

	public Department getDepartmentById(Serializable id);
}
