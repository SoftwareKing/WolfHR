package com.wolf.hr.domain;

import java.util.Set;

public class SalaryInfo {
	private Long id;
	private String workerCategory; // 职位类别
	private String time; // 核算时间 。
	private Double actualSalary; // 实发工资
	private Double addWorkSalary; 
	private Double leaveSalary; // 早退扣款
	private Double lateSalary;// 迟到扣款
	private Double absentSalary;// 矿工扣款
	private User user;
	private Set<IncomeAndPayment> ips;
	private SalaryType salaryType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWorkerCategory() {
		return workerCategory;
	}

	public void setWorkerCategory(String workerCategory) {
		this.workerCategory = workerCategory;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Double getActualSalary() {
		return actualSalary;
	}

	public void setActualSalary(Double actualSalary) {
		this.actualSalary = actualSalary;
	}

	public Double getAddWorkSalary() {
		return addWorkSalary;
	}

	public void setAddWorkSalary(Double addWorkSalary) {
		this.addWorkSalary = addWorkSalary;
	}

	public Double getLeaveSalary() {
		return leaveSalary;
	}

	public void setLeaveSalary(Double leaveSalary) {
		this.leaveSalary = leaveSalary;
	}

	public Double getLateSalary() {
		return lateSalary;
	}

	public void setLateSalary(Double lateSalary) {
		this.lateSalary = lateSalary;
	}

	public Double getAbsentSalary() {
		return absentSalary;
	}

	public void setAbsentSalary(Double absentSalary) {
		this.absentSalary = absentSalary;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<IncomeAndPayment> getIps() {
		return ips;
	}

	public void setIps(Set<IncomeAndPayment> ips) {
		this.ips = ips;
	}

	public SalaryType getSalaryType() {
		return salaryType;
	}

	public void setSalaryType(SalaryType salaryType) {
		this.salaryType = salaryType;
	}

}
