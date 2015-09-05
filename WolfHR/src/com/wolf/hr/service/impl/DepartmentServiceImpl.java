package com.wolf.hr.service.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wolf.hr.dao.DepartmentDao;
import com.wolf.hr.domain.Department;
import com.wolf.hr.service.DepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{
	@Resource(name="departmentDao")
	private DepartmentDao departmentDao;

	@Transactional(readOnly=false)
	public void saveDepartment(Department department) {
		// TODO Auto-generated method stub
		this.departmentDao.saveEntry(department);
	}
	@Transactional(readOnly=false)
	public void updateDeparment(Department department) {
		// TODO Auto-generated method stub
		//this.departmentDao.updateDeparment(department);
		this.departmentDao.updateEntry(department);
	}
	@Transactional(readOnly=false)
	public void deleteDepartmentByID(Serializable id,String deleteMode) {
		// TODO Auto-generated method stub
		//this.departmentDao.deleteDepartmentByID(id,deleteMode);
		this.departmentDao.deleteEntry(id);
	}

	public Collection<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return this.departmentDao.getAllEntry();
	}

	public Department getDepartmentById(Serializable id) {
		// TODO Auto-generated method stub
		//return this.departmentDao.getDepartmentById(id);
		return (Department)this.departmentDao.getEntryById(id);
		
	}
	
}
