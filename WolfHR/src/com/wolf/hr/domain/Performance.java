package com.wolf.hr.domain;

import java.io.File;
import java.io.InputStream;



public class Performance {
	
      private Long pfid;//离职ID
      private String Jobnumber;//员工工号
  	  private String username;//员工姓名
  	  private String department;//部门
  	  private String post;//岗位
  	  private String taskdescription;//任务描述
  	  private String baifenbi;//百分比
  	  private String starttime;//开始时间
  	  private String planendtime;//计划结束时间
  	  private String completetime;//完成时间
  	  private String description;//备注
  
	 public Long getPfid() {
		return pfid;
	}
	public void setPfid(Long pfid) {
		this.pfid = pfid;
	}
	public String getJobnumber() {
		return Jobnumber;
	}
	public void setJobnumber(String jobnumber) {
		Jobnumber = jobnumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getTaskdescription() {
		return taskdescription;
	}
	public void setTaskdescription(String taskdescription) {
		this.taskdescription = taskdescription;
	}
	public String getBaifenbi() {
		return baifenbi;
	}
	public void setBaifenbi(String baifenbi) {
		this.baifenbi = baifenbi;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getPlanendtime() {
		return planendtime;
	}
	public void setPlanendtime(String planendtime) {
		this.planendtime = planendtime;
	}
	public String getCompletetime() {
		return completetime;
	}
	public void setCompletetime(String completetime) {
		this.completetime = completetime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
  	  
	//用于配置下载的属性
	private InputStream inputStreamx;

	public InputStream getInputStreamx() {
		return inputStreamx;
	}
	public void setInputStreamx(InputStream inputStreamx) {
		this.inputStreamx = inputStreamx;
	}
	
	
}
