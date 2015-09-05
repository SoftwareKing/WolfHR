package com.wolf.hr.dao.impl;




import org.springframework.stereotype.Repository;

import com.wolf.hr.dao.DepartmentDao;
import com.wolf.hr.dao.base.impl.BaseDaoImpl;
import com.wolf.hr.domain.Department;


@Repository("departmentDao")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao<Department>{



}
