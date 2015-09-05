package com.wolf.hr.dao.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.wolf.hr.dao.IncomeAndPaymentDao;
import com.wolf.hr.dao.base.impl.BaseDaoImpl;
import com.wolf.hr.domain.IncomeAndPayment;

@Repository("incomeAndPaymentDao")
public class IncomeAndPaymentDaoImpl extends BaseDaoImpl<IncomeAndPayment>
		implements IncomeAndPaymentDao<IncomeAndPayment> {

	public Collection<IncomeAndPayment> getAllByAdress(String address) {
		return super.hibernateTemplate.find("From IncomeAndPayment where address=?",address);
	}

	public Collection<String> getAllAdress() {
		List<String> address = super.hibernateTemplate.find("Select address From IncomeAndPayment"); 
		
		return new HashSet<String>(address) ;
	}

	public Set<IncomeAndPayment> getIncomeAndPaymentsByIds(Long[] ipids) {
		StringBuffer sb = new StringBuffer() ;
		sb.append("From IncomeAndPayment where id in(") ;
		for (int i = 0; i < ipids.length; i++) {
			if(i<ipids.length-1){
				sb.append(ipids[i]+",");
			} else {
				sb.append(ipids[i]) ;
			}
		}
		sb.append(")")  ;
		String hql = sb.toString() ;
		List<IncomeAndPayment> ipsid = super.hibernateTemplate.find(hql);
		return new HashSet<IncomeAndPayment>(ipsid) ;
	}

}
