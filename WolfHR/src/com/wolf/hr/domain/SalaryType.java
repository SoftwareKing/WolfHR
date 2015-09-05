package com.wolf.hr.domain;

import java.util.Set;

public class SalaryType {

	private Long id;
	private String category;
	private Double baseSalary; // 基本工资
	private Double postSalary; // 岗位工资
	private Double addWorkMoney;
	private Double absentMoney;
	private Double leaveMoney;
	private Double lateMoney;
	private Set<SalaryInfo> infos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Double getPostSalary() {
		return postSalary;
	}

	public void setPostSalary(Double postSalary) {
		this.postSalary = postSalary;
	}

	public Double getAddWorkMoney() {
		return addWorkMoney;
	}

	public void setAddWorkMoney(Double addWorkMoney) {
		this.addWorkMoney = addWorkMoney;
	}

	public Double getAbsentMoney() {
		return absentMoney;
	}

	public void setAbsentMoney(Double absentMoney) {
		this.absentMoney = absentMoney;
	}

	public Double getLeaveMoney() {
		return leaveMoney;
	}

	public void setLeaveMoney(Double leaveMoney) {
		this.leaveMoney = leaveMoney;
	}

	public Double getLateMoney() {
		return lateMoney;
	}

	public void setLateMoney(Double lateMoney) {
		this.lateMoney = lateMoney;
	}

	public Set<SalaryInfo> getInfos() {
		return infos;
	}

	public void setInfos(Set<SalaryInfo> infos) {
		this.infos = infos;
	}

}
