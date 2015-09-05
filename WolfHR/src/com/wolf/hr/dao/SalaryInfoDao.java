package com.wolf.hr.dao;

import java.util.Collection;

import com.wolf.hr.dao.base.BaseDao;
import com.wolf.hr.domain.SalaryInfo;

public interface SalaryInfoDao<T> extends BaseDao<T>{

	public SalaryInfo getSalaryInfoByUser(String time) ;
	public Collection<SalaryInfo> getSalaryInfoByUserByYear(String time) ;
	public Collection<SalaryInfo> getSalaryInfoByUserByMonth(String time) ;
	public Collection<SalaryInfo> getSalaryInfoByLastMonth(String time) ;
	public Collection<SalaryInfo> getSalaryInfosByUser() ;
}
