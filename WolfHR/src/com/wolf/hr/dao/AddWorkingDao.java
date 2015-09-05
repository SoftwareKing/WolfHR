package com.wolf.hr.dao;

import java.io.Serializable;
import java.util.Collection;

import com.wolf.hr.dao.base.BaseDao;

public interface AddWorkingDao<T> extends BaseDao<T>{

	public Collection<T> getAllFromMonth() ;
	public Collection<T> getAllFromNowMonth() ;
	public Collection<T> getAllByUser() ;
	public Double getAllHours(String month,Serializable uid);
	
}
