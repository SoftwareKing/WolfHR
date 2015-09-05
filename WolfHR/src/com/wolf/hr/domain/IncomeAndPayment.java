package com.wolf.hr.domain;

import java.util.Set;

public class IncomeAndPayment {

	private Long id;
	private String activatyName;
	private Double activatyMoney;
	private int state;
	private String address;
	private Set<SalaryInfo> infos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActivatyName() {
		return activatyName;
	}

	public void setActivatyName(String activatyName) {
		this.activatyName = activatyName;
	}

	public Double getActivatyMoney() {
		return activatyMoney;
	}

	public void setActivatyMoney(Double activatyMoney) {
		this.activatyMoney = activatyMoney;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Set<SalaryInfo> getInfos() {
		return infos;
	}

	public void setInfos(Set<SalaryInfo> infos) {
		this.infos = infos;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
