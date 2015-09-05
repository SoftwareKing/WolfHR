package com.wolf.hr.dao.impl;




import java.util.Collection;

import org.springframework.stereotype.Repository;


import com.wolf.hr.dao.UserEduDao;
import com.wolf.hr.dao.base.impl.BaseDaoImpl;
import com.wolf.hr.domain.UserEdu;

@Repository("usereduDao")
public class UserEduDaoImpl extends BaseDaoImpl<UserEdu> implements UserEduDao<UserEdu>{

	
	public Collection<UserEdu> getEduByUser(Long uid) {
		// TODO Auto-generated method stub
		return super.hibernateTemplate.find("From UserEdu where uid=?",uid);
	}



}
