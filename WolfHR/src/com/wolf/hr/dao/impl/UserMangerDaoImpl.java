package com.wolf.hr.dao.impl;




import java.util.List;

import org.springframework.stereotype.Repository;

import com.wolf.hr.dao.UserMangerDao;
import com.wolf.hr.dao.base.impl.BaseDaoImpl;
import com.wolf.hr.domain.UserManger;





@Repository("usermangerDao")
public class UserMangerDaoImpl extends BaseDaoImpl<UserManger> implements UserMangerDao<UserManger>{

	public UserManger getMangerByUser(Long uid) {
		List<UserManger> mangers =  super.hibernateTemplate.find("From UserManger where uid=?",uid);
		if(!mangers.isEmpty()){
			return mangers.get(0);
		}
		return null ;
	}



}
