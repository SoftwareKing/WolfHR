package com.wolf.hr.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wolf.hr.dao.AttendanceDao;
import com.wolf.hr.dao.base.impl.BaseDaoImpl;
import com.wolf.hr.domain.Attendance;
import com.wolf.hr.utils.DateFormat;
import com.wolf.hr.utils.HRUtils;


@Repository("attendanceDao")
public class AttendanceDaoImpl extends BaseDaoImpl<Attendance> implements AttendanceDao<Attendance> {

	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate ;
	public Collection<Attendance> getAllByAttType(String attType) {
		return hibernateTemplate.find("From Attendance where userId=? and attType=? and month=?",new Object[]{HRUtils.fromSession(),attType,DateFormat.toStringWork(new Date())});
	}
	public Collection<Attendance> getAllByUser() {
		return hibernateTemplate.find("From Attendance where userId=? and month=?",new Object[]{HRUtils.fromSession(),DateFormat.toStringWork(new Date())});
	}
	public Double getALlHoursByAttType(String time, String string,Serializable uid) {
		List<Double> hours = hibernateTemplate.find("select sum(attHours) From Attendance where attType=? and month=? and userId=?",new Object[]{string,time,uid});
		if(!hours.isEmpty()){
			return hours.get(0) ;
		}
		return 0.0;
	}

}
