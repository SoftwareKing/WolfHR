package com.wolf.hr.dao.impl;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.wolf.hr.dao.UserLizhiDao;
import com.wolf.hr.dao.base.impl.BaseDaoImpl;
import com.wolf.hr.domain.UserLizhi;

@Repository("userlizhiDao")
public class UserLizhiDaoImpl extends BaseDaoImpl<UserLizhi> implements UserLizhiDao<UserLizhi>{

	public Collection<UserLizhi> getUserLizhiByJobnumber(String jobnumber) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from UserLizhi where jobnumber=?",jobnumber);
	}


}
