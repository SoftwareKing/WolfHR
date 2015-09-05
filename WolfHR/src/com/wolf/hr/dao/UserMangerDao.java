package com.wolf.hr.dao;



import com.wolf.hr.dao.base.BaseDao;
import com.wolf.hr.domain.UserManger;

public interface UserMangerDao<T> extends BaseDao<T>{

	public UserManger getMangerByUser(Long uid) ;
}
