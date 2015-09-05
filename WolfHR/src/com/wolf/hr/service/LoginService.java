package com.wolf.hr.service;

import com.wolf.hr.domain.User;

public interface LoginService {
	public User checkUAndP(String username,String password);
}
