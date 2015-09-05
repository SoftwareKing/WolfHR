package com.wolf.hr.service.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wolf.hr.dao.SalaryInfoDao;
import com.wolf.hr.domain.SalaryInfo;
import com.wolf.hr.service.SalaryInfoService;

@Service("salaryInfoService")
public class SalaryInfoServiceImpl implements SalaryInfoService {

	@Resource(name = "salaryInfoDao")
	private SalaryInfoDao salaryInfoDao;

	public Collection<SalaryInfo> getAllByUser() {
		return this.salaryInfoDao.getSalaryInfosByUser();
	}

	public Collection<SalaryInfo> getAllSalaryInfos() {
		return this.salaryInfoDao.getAllEntry();
	}

	public SalaryInfo getSalaryInfoById(Serializable id) {
		return (SalaryInfo) salaryInfoDao.getEntryById(id);
	}

	public SalaryInfo getSalaryInfoByUser(String time) {
		return salaryInfoDao.getSalaryInfoByUser(time);
	}

	@Transactional(readOnly = false)
	public void saveSalaryInfo(SalaryInfo salaryInfo) {
		salaryInfoDao.saveEntry(salaryInfo);
	}

	@Transactional(readOnly = false)
	public void updateSalaryInfo(SalaryInfo salaryInfo) {
		salaryInfoDao.updateEntry(salaryInfo);
	}

	public Collection<SalaryInfo> getAllByLastMonth(String time) {
		return salaryInfoDao.getSalaryInfoByLastMonth(time);
	}

	public Collection<SalaryInfo> getSalaryInfoByUserByYear(String time) {
		// TODO Auto-generated method stub
		return this.salaryInfoDao.getSalaryInfoByUserByYear(time);
	}

	public Collection<SalaryInfo> getSalaryInfoByUserByMonth(String time) {
		// TODO Auto-generated method stub
		return this.salaryInfoDao.getSalaryInfoByUserByMonth(time);
	}

}
