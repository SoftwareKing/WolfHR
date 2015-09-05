package com.wolf.hr.dao;

import java.io.Serializable;
import java.util.Collection;

import com.wolf.hr.dao.base.BaseDao;

public interface AttendanceDao<T> extends BaseDao<T>{

	public Collection<T> getAllByAttType(String attType) ;
	public Collection<T> getAllByUser();
	public Double getALlHoursByAttType(String time, String string,Serializable uid);
}
