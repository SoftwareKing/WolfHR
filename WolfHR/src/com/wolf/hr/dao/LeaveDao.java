package com.wolf.hr.dao;

import java.util.Collection;

import com.wolf.hr.dao.base.BaseDao;

public interface LeaveDao<T> extends BaseDao<T> {

	public Collection<T> getAllFromMonth() ;
	public Collection<T> getAllFromNowMonth() ;
	public Collection<T> getAllFromByYear() ;
}
