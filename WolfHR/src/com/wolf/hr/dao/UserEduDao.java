package com.wolf.hr.dao;


import java.util.Collection;

import com.wolf.hr.dao.base.BaseDao;
import com.wolf.hr.domain.UserEdu;

public interface UserEduDao<T> extends BaseDao<T>{

	public Collection<UserEdu>  getEduByUser(Long uid) ;
}
