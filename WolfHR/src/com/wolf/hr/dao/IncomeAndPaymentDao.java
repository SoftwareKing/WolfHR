package com.wolf.hr.dao;

import java.util.Collection;
import java.util.Set;

import com.wolf.hr.dao.base.BaseDao;
import com.wolf.hr.domain.IncomeAndPayment;

public interface IncomeAndPaymentDao<T> extends BaseDao<T>{

	Collection<IncomeAndPayment> getAllByAdress(String address);

	Collection<String> getAllAdress();

	Set<IncomeAndPayment> getIncomeAndPaymentsByIds(Long[] ipids);

}
