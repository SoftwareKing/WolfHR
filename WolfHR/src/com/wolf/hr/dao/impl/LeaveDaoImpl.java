package com.wolf.hr.dao.impl;

import java.util.Collection;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wolf.hr.dao.LeaveDao;
import com.wolf.hr.dao.base.impl.BaseDaoImpl;
import com.wolf.hr.domain.Leave;
import com.wolf.hr.utils.DateFormat;
import com.wolf.hr.utils.HRUtils;

@Repository("leaveDao")
public class LeaveDaoImpl extends BaseDaoImpl<Leave> implements LeaveDao<Leave> {

	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate ;
	
	public Collection<Leave> getAllFromMonth() {
		//String hql = "From Leave where userId=? and month=?" ;
		//return this.hibernateTemplate.find(hql, new Object[]{HRUtils.fromSession().getUid(),DateFormat.toStringWork(new Date())});
		String hql = "From Leave where userId=? " ;
		return this.hibernateTemplate.find(hql, new Object[]{HRUtils.fromSession().getUid()});
	}

	public Collection<Leave> getAllFromNowMonth() {
		String hql = "From Leave where userId=? and month=?" ;
		return this.hibernateTemplate.find(hql, new Object[]{HRUtils.fromSession().getUid(),DateFormat.toStringMonth(new Date())});
	}

	public Collection<Leave> getAllFromByYear() {
		String hql = "From Leave where userId=? and agree=?" ;
		return this.hibernateTemplate.find(hql, new Object[]{HRUtils.fromSession().getUid(),1});
	}

}
