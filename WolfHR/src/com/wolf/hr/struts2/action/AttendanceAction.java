package com.wolf.hr.struts2.action;

import java.util.Collection;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.wolf.hr.domain.Attendance;
import com.wolf.hr.domain.User;
import com.wolf.hr.service.AttendanceService;
import com.wolf.hr.service.UserService;
import com.wolf.hr.struts2.action.base.BaseAction;
import com.wolf.hr.utils.DateFormat;
import com.wolf.hr.utils.HRUtils;

/***日常考勤*****/

@Controller("attendanceAction")
@Scope("prototype")
public class AttendanceAction extends BaseAction<Attendance>{

	@Resource(name="attendanceService")
	private AttendanceService attendanceService ;
	@Resource(name="userService")
	private UserService userService ;
	
	/***********添加日常考勤UI*******************/
	public String addUI(){
		
		Collection<User> userList = this.userService.getAllUser() ;
		ActionContext.getContext().put("userList", userList);
		return addUI ;
	}
	
	/***********添加日常考勤*******************/
	public String addAttendance(){
		
		Attendance attendance = new Attendance() ;
		BeanUtils.copyProperties(this.getModel(), attendance);
		User user = userService.getUserById(attendance.getUser().getUid());
		attendance.setUser(user) ;
		attendance.setMonth(DateFormat.toStringWork(new Date()));
		attendance.setAttUser(HRUtils.fromSession());
		attendanceService.saveAttendance(attendance); 
		return action2action;
	}
	
	/***********所有的日常考勤列表*******************/
	public String attendancesList(){
		Collection<Attendance> attendances = this.attendanceService.getAll();
		
		ActionContext.getContext().put("attendances", attendances);
		return "actionList" ;
	}
	
	
	/***********按用户查询日常考勤*******************/
	public String listByUser(){
		
		Collection<Attendance> attendances = this.attendanceService.getAllByUser();
		
		ActionContext.getContext().put("attendances", attendances);
		System.out.println(attendances.size());
		return "userList";
	}
	
	/***********按日期查询日常考勤*******************/
	public String listByLate(){
		Collection<Attendance> attendances = this.attendanceService.getAllByAttType("late");
		
		ActionContext.getContext().put("attendances", attendances);
		return "userList";
	}
	
	public String listByLeave(){
		Collection<Attendance> attendances = this.attendanceService.getAllByAttType("leave");
		
		ActionContext.getContext().put("attendances", attendances);
		return "userList";
	}
	public String listByAbsent(){
		Collection<Attendance> attendances = this.attendanceService.getAllByAttType("absent");
		
		ActionContext.getContext().put("attendances", attendances);
		return "userList";
	}
	
	public String updateAttendance(){
		Attendance attendance = attendanceService.getAttendanceById(this.getModel().getId());
		attendanceService.updateAttendance(attendance) ;
		return action2action;
	}
	
	public String deleteAttendance(){
		attendanceService.deleteAttendance(this.getModel().getId()) ;
		return action2action;
	}
}

