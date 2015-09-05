package com.wolf.hr.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wolf.hr.dao.IncomeAndPaymentDao;
import com.wolf.hr.domain.IncomeAndPayment;
import com.wolf.hr.service.IncomeAndPaymentService;

@Service("incomeAndPaymentService")
public class IncomeAndPaymentServiceImpl implements IncomeAndPaymentService {

	@Resource(name = "incomeAndPaymentDao")
	private IncomeAndPaymentDao incomeAndPaymentDao;

	public Collection<IncomeAndPayment> getAllIncomeAndPayments() {
		return incomeAndPaymentDao.getAllEntry();
	}

	public IncomeAndPayment getIncomeAndPaymentById(Serializable id) {
		return (IncomeAndPayment) incomeAndPaymentDao.getEntryById(id);
	}

	@Transactional(readOnly = false)
	public void saveIncomeAndPayment(IncomeAndPayment incomeAndPayment) {

		incomeAndPaymentDao.saveEntry(incomeAndPayment);
	}

	@Transactional(readOnly = false)
	public void updateIncomeAndPayment(IncomeAndPayment incomeAndPayment) {
		incomeAndPaymentDao.updateEntry(incomeAndPayment);
	}

	public Collection<IncomeAndPayment> getAllIncomeAndPayments(String address) {
		return incomeAndPaymentDao.getAllByAdress(address);
	}

	public Collection<IncomeAndPayment> getAllIncomeAndPaymentsByAdress() {
		// TODO Auto-generated method stub
		Collection<String> add = incomeAndPaymentDao.getAllAdress();
		Collection<IncomeAndPayment> address = new ArrayList<IncomeAndPayment>();
		for (String  adds : add) {
			IncomeAndPayment incomeAndPayment = new IncomeAndPayment() ;
			incomeAndPayment.setAddress(adds) ;
			address.add(incomeAndPayment) ;
		}
		return address ;
	}

	public Set<IncomeAndPayment> getIncomeAndPaymentsByIds(Long[] ipids) {
		
		return incomeAndPaymentDao.getIncomeAndPaymentsByIds(ipids);
	}
	@Transactional(readOnly = false)
	public void deleteIncomeAndPaymentById(Serializable id) {
        this.incomeAndPaymentDao.deleteEntry(id);
        
	}
	@Transactional(readOnly = false)
	public Collection<IncomeAndPayment> getALLIncomeAndPayment() {
		// TODO Auto-generated method stub
		return this.incomeAndPaymentDao.getAllEntry();
	}

}
