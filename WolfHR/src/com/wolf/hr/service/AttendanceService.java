package com.wolf.hr.service;

import java.io.Serializable;
import java.util.Collection;

import com.wolf.hr.domain.Attendance;

public interface AttendanceService {

	
	public Collection<Attendance> getAllByAttType(String attType) ;
	public void saveAttendance(Attendance attendance);
	
	public Collection<Attendance> getAll() ;
	public Collection<Attendance> getAllByUser() ;
	
	public void updateAttendance(Attendance attendance) ;
	public Attendance getAttendanceById(Serializable id) ;
	public void deleteAttendance(Serializable id) ;
	public Double getLeaveHours(String time ,Serializable uid);
	public Double getLateHours(String time,Serializable uid);
	public Double getAbsentHours(String time,Serializable uid);
}
