package com.wolf.hr.dao;

import java.util.Collection;

import com.wolf.hr.dao.base.BaseDao;
import com.wolf.hr.domain.Performance;
import com.wolf.hr.domain.User;

public interface UserDao<T> extends BaseDao<T>{
	public Collection<User> getUsers();
	public User getUserByUserByID();
	public Collection<User> getUserByJobnumber(String jobnumber);
	public Collection<User> getUserByUsername(String username);
	//public Collection<User> getUserBydepartment(String username);
	public Collection<User> getUserBydid(Long did);
	
	
}
