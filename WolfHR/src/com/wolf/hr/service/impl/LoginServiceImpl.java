package com.wolf.hr.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wolf.hr.dao.LoginDao;
import com.wolf.hr.domain.User;
import com.wolf.hr.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService{
	@Resource(name="loginDao")
	private LoginDao loginDao;

	public User checkUAndP(String username, String password) {
		// TODO Auto-generated method stub
		return this.loginDao.getUserByUAndP(username, password);
	}
}
