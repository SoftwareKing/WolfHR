package com.wolf.hr.domain;

import java.io.File;
import java.io.Serializable;
import java.util.Set;



public class UserEdu implements Serializable{
	private Long ueid;//员工基本信息ID
	private String xueli;//学历
	private String school;//学校
	private String major;//专业
	private String starttime;//开始时间
	private String endtime;//结束时间
	private String description;//备注
	
	public Long getUeid() {
		return ueid;
	}
	public void setUeid(Long ueid) {
		this.ueid = ueid;
	}
	public String getXueli() {
		return xueli;
	}
	public void setXueli(String xueli) {
		this.xueli = xueli;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	private User users;

	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}

	
	
	
	
	
	


}