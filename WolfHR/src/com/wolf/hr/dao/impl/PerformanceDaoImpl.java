package com.wolf.hr.dao.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.wolf.hr.dao.PerformanceDao;
import com.wolf.hr.dao.base.impl.BaseDaoImpl;
import com.wolf.hr.domain.Performance;
import com.wolf.hr.domain.User;



@Repository("performanceDao")
public class PerformanceDaoImpl extends BaseDaoImpl<Performance> implements PerformanceDao<Performance>{

	public Collection<Performance> getPerformanceByJobnumber(String jobnumber) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from Performance where jobnumber=?",jobnumber);
	}

}
