package com.wolf.hr.service.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wolf.hr.dao.AttendanceDao;
import com.wolf.hr.domain.Attendance;
import com.wolf.hr.service.AttendanceService;


@Service("attendanceService")
public class AttendanceServiceImpl implements AttendanceService {

	@Resource(name="attendanceDao")
	private AttendanceDao attendanceDao;
	
	public Collection<Attendance> getAllByAttType(String attType) {
		return attendanceDao.getAllByAttType(attType);
	}
	@Transactional(readOnly=false)
	public void saveAttendance(Attendance attendance) {
		attendanceDao.saveEntry(attendance);
	}

	public Collection<Attendance> getAll() {
		return attendanceDao.getAllEntry();
	}
	public Collection<Attendance> getAllByUser() {
		return attendanceDao.getAllByUser();
	}
	public Attendance getAttendanceById(Serializable id) {
		return (Attendance) attendanceDao.getEntryById(id);
	}
	public void updateAttendance(Attendance attendance) {
		attendanceDao.updateEntry(attendance);
	}
	@Transactional(readOnly=false)
	public void deleteAttendance(Serializable id) {
		attendanceDao.deleteEntry(id);
	}
	public Double getAbsentHours(String time,Serializable uid) {
		Double x = attendanceDao.getALlHoursByAttType(time,"absent",uid);
		if(x!=null){
			return x ;
		} else 
		return  0.0 ;
	}
	public Double getLateHours(String time,Serializable uid) {
		Double x = attendanceDao.getALlHoursByAttType(time,"late",uid);
		if(x!=null){
			return x ;
		} else 
		return  0.0 ;
	}
	public Double getLeaveHours(String time,Serializable uid) {
		Double x = attendanceDao.getALlHoursByAttType(time,"leave",uid);
		if(x!=null){
			return x ;
		} else 
		return  0.0 ;
	}
}
