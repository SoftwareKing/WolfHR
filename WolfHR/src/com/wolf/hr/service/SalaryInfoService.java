package com.wolf.hr.service;

import java.io.Serializable;
import java.util.Collection;

import com.wolf.hr.domain.SalaryInfo;

public interface SalaryInfoService {

	public Collection<SalaryInfo> getAllSalaryInfos();

	public SalaryInfo getSalaryInfoById(Serializable id);

	public SalaryInfo getSalaryInfoByUser(String time);

	public void saveSalaryInfo(SalaryInfo salaryInfo);

	public Collection<SalaryInfo> getAllByUser();

	public Collection<SalaryInfo> getAllByLastMonth(String time);

	public void updateSalaryInfo(SalaryInfo salaryInfo);
	
	public Collection<SalaryInfo> getSalaryInfoByUserByMonth(String time);

	public Collection<SalaryInfo> getSalaryInfoByUserByYear(String time);
}
