package com.wolf.hr.dao.impl;

import org.springframework.stereotype.Repository;

import com.wolf.hr.dao.SalaryTypeDao;
import com.wolf.hr.dao.base.impl.BaseDaoImpl;
import com.wolf.hr.domain.SalaryType;

@Repository("salaryTypeDao")
public class SalaryTypeDaoImpl extends BaseDaoImpl<SalaryType> implements SalaryTypeDao<SalaryType>{

}
