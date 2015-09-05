package com.wolf.hr.domain;

public class Attendance {

	private Long id ;
	private String month ;
	private String startDate ;
	private String attType ;
	private double attHours ;
	private String time ;
	private User user ;
	
	private User attUser ;
	
	
	public User getAttUser() {
		return attUser;
	}
	public void setAttUser(User attUser) {
		this.attUser = attUser;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getAttType() {
		return attType;
	}
	public void setAttType(String attType) {
		this.attType = attType;
	}
	public double getAttHours() {
		return attHours;
	}
	public void setAttHours(double attHours) {
		this.attHours = attHours;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
