package com.wolf.hr.dao.impl;




import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.wolf.hr.dao.UserWorkDao;
import com.wolf.hr.dao.base.impl.BaseDaoImpl;
import com.wolf.hr.domain.UserWork;




@Repository("userworkDao")
public class UserWorkDaoImpl extends BaseDaoImpl<UserWork> implements UserWorkDao<UserWork>{

	public Collection<UserWork> getUserWorkByUser(Long uid) {
		return super.hibernateTemplate.find("From UserWork where uid=?",uid);
	}



}
