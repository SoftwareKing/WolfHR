package com.wolf.hr.dao.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.wolf.hr.dao.SalaryInfoDao;
import com.wolf.hr.dao.base.impl.BaseDaoImpl;
import com.wolf.hr.domain.SalaryInfo;
import com.wolf.hr.utils.HRUtils;

@Repository("salaryInfoDao")
public class SalaryInfoDaoImpl extends BaseDaoImpl<SalaryInfo> implements
		SalaryInfoDao<SalaryInfo> {

	public SalaryInfo getSalaryInfoByUser(String time) {
		String hql = "From SalaryInfo where time=? and userId=? ";
		List<SalaryInfo> infos = super.hibernateTemplate.find(hql,
				new Object[] { time, HRUtils.fromSession().getUid() });
		if(!infos.isEmpty()){
			return infos.get(0);
		} else return null ;
	}

	public Collection<SalaryInfo> getSalaryInfosByUser() {
		String hql = "From SalaryInfo where userId=? ";

		return super.hibernateTemplate.find(hql, new Object[] { HRUtils
				.fromSession().getUid() });
	}

	public Collection<SalaryInfo> getSalaryInfoByLastMonth(String time) {
		String hql = "From SalaryInfo where time=? ";
		return super.hibernateTemplate.find(hql,
				new Object[] { time});
	}

	public Collection<SalaryInfo> getSalaryInfoByUserByYear(String time) {
		String hql = "From SalaryInfo where time like ? and userId=? ";
		return super.hibernateTemplate.find(hql,
				new Object[] {time+"%", HRUtils.fromSession().getUid() });
		
		
	}


	public Collection<SalaryInfo> getSalaryInfoByUserByMonth(String time) {
		String hql = "From SalaryInfo where time=? and userId=? ";
		return  super.hibernateTemplate.find(hql,
				new Object[] { time, HRUtils.fromSession().getUid() });
	}

}
