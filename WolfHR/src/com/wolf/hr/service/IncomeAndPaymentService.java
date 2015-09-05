package com.wolf.hr.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import com.wolf.hr.domain.IncomeAndPayment;
import com.wolf.hr.domain.SalaryType;

public interface IncomeAndPaymentService {

	public Collection<IncomeAndPayment> getAllIncomeAndPayments() ;
	public void saveIncomeAndPayment(IncomeAndPayment incomeAndPayment) ;
	public void updateIncomeAndPayment(IncomeAndPayment incomeAndPayment) ;
	public IncomeAndPayment getIncomeAndPaymentById(Serializable id) ;
	public Collection<IncomeAndPayment> getAllIncomeAndPayments(String adress) ;
	public Collection<IncomeAndPayment> getAllIncomeAndPaymentsByAdress();
	public Set<IncomeAndPayment> getIncomeAndPaymentsByIds(Long[] ipids);
	
	
	public Collection<IncomeAndPayment> getALLIncomeAndPayment();
	public void deleteIncomeAndPaymentById(Serializable id);
	
	
	
}
