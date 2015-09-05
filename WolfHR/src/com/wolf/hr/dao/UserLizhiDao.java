package com.wolf.hr.dao;


import java.util.Collection;

import com.wolf.hr.dao.base.BaseDao;
import com.wolf.hr.domain.UserLizhi;

public interface UserLizhiDao<T> extends BaseDao<T>{
	public Collection<UserLizhi> getUserLizhiByJobnumber(String jobnumber);
}
