package com.wolf.hr.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wolf.hr.dao.AddWorkingDao;
import com.wolf.hr.dao.base.impl.BaseDaoImpl;
import com.wolf.hr.domain.AddWorking;
import com.wolf.hr.utils.DateFormat;
import com.wolf.hr.utils.HRUtils;


@Repository("addWorkingDao")
public class AddWorkingDaoImpl extends BaseDaoImpl<AddWorking> implements AddWorkingDao<AddWorking> {

	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate ;
	
	public Collection<AddWorking> getAllFromMonth() {
		String hql = "From AddWorking where userId=? and month=?" ;
		return this.hibernateTemplate.find(hql, new Object[]{HRUtils.fromSession().getUid(),DateFormat.toStringWork(new Date())});
		
	}

	public Collection<AddWorking> getAllFromNowMonth() {
		String hql = "From AddWorking where userId=? and month=?" ;
		return this.hibernateTemplate.find(hql, new Object[]{HRUtils.fromSession().getUid(),DateFormat.toStringMonth(new Date())});
	}

	public Collection<AddWorking> getAllByUser() {
		String hql = "From AddWorking where userId=?" ;
		return this.hibernateTemplate.find(hql, new Object[]{HRUtils.fromSession().getUid()});
	}
	public Double getAllHours(String month,Serializable uid) {
		List<Double> allHours = this.hibernateTemplate.find("select sum(hours) From AddWorking ad where agree=1 and ad.month=? and userId=?",new Object[]{month,uid});
		if(!allHours.isEmpty()){
			return allHours.get(0) ;
		}
		return 0.0 ;
	}
}
