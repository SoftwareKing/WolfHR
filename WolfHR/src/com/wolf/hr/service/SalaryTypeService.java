package com.wolf.hr.service;

import java.io.Serializable;
import java.util.Collection;

import com.wolf.hr.domain.SalaryType;

public interface SalaryTypeService {

	public void saveSalaryType(SalaryType salaryType) ;
	public void updateSalaryType(SalaryType salaryType) ;
	public Collection<SalaryType> getAllSalaryTypes();
	public SalaryType getSalaryTypeById(Serializable id) ;
	public void deleteSalaryTypeById(Serializable id) ;
}
