package com.wolf.hr.domain;


import java.io.Serializable;
import java.util.Set;




public class UserWork implements Serializable{
	private Long uwid;//员工工作经历ID
	private String companyname;//公司名称
	private String majorwork;//负责工作
	private String starttime;//开始时间
	private String endtime;//结束时间
	private String yeji;//主要业绩
	private String description;//备注
	public Long getUwid() {
		return uwid;
	}
	public void setUwid(Long uwid) {
		this.uwid = uwid;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getMajorwork() {
		return majorwork;
	}
	public void setMajorwork(String majorwork) {
		this.majorwork = majorwork;
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
	public String getYeji() {
		return yeji;
	}
	public void setYeji(String yeji) {
		this.yeji = yeji;
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