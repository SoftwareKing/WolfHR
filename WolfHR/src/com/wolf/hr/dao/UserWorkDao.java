package com.wolf.hr.dao;


import java.util.Collection;

import com.wolf.hr.dao.base.BaseDao;
import com.wolf.hr.domain.UserWork;

public interface UserWorkDao<T> extends BaseDao<T>{

	public Collection<UserWork> getUserWorkByUser(Long uid) ;
}
