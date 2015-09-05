package com.wolf.hr.dao;

import com.wolf.hr.domain.User;

public interface LoginDao {
	public User getUserByUAndP(String username,String password);
}
