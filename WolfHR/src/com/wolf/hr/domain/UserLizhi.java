package com.wolf.hr.domain;

import java.util.Date;

public class UserLizhi {
	
      private Long lzid;//离职ID
      private String Jobnumber;//员工工号
  	  private String username;//员工姓名
  	  private String department;//离职部门
  	  private String  post;//离职岗位
  	  private String time;//离职时间
  	  private String lizhixingzhi;//离职行者
  	  private String reason;//离职的原因
  	  private String description;//备注
	public Long getLzid() {
		return lzid;
	}
	public void setLzid(Long lzid) {
		this.lzid = lzid;
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
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getLizhixingzhi() {
		return lizhixingzhi;
	}
	public void setLizhixingzhi(String lizhixingzhi) {
		this.lizhixingzhi = lizhixingzhi;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
  	  
      
}
