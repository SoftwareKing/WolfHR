package com.wolf.hr.service.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wolf.hr.dao.SalaryTypeDao;
import com.wolf.hr.domain.SalaryType;
import com.wolf.hr.service.SalaryTypeService;

@Service("salaryTypeService")
public class SalaryTypeServiceImpl implements SalaryTypeService {

	@Resource(name = "salaryTypeDao")
	private SalaryTypeDao salaryTypeDao;

	public Collection<SalaryType> getAllSalaryTypes() {
		return this.salaryTypeDao.getAllEntry();
	}

	public SalaryType getSalaryTypeById(Serializable id) {
		return (SalaryType) this.salaryTypeDao.getEntryById(id);
	}

	@Transactional(readOnly = false)
	public void saveSalaryType(SalaryType salaryType) {
		this.salaryTypeDao.saveEntry(salaryType);
	}
	@Transactional(readOnly = false)
	public void updateSalaryType(SalaryType salaryType) {
		this.salaryTypeDao.updateEntry(salaryType);
	}

	@Transactional(readOnly = false)
	public void deleteSalaryTypeById(Serializable id) {
     this.salaryTypeDao.deleteEntry(id);		
	}

}
