package com.wolf.hr.dao;


import java.util.Collection;

import com.wolf.hr.dao.base.BaseDao;
import com.wolf.hr.domain.Performance;


public interface PerformanceDao<T> extends BaseDao<T>{
	
	public Collection<Performance> getPerformanceByJobnumber(String jobnumber);
}
