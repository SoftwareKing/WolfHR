package com.wolf.hr.service.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wolf.hr.dao.UserMangerDao;
import com.wolf.hr.domain.UserManger;
import com.wolf.hr.service.UserMangerService;




@Service("usermangerService")
public class UserMangerServiceImpl implements UserMangerService{
	@Resource(name="usermangerDao")
	private UserMangerDao usermangerDao;

	@Transactional(readOnly=false)
	public void deleteUserMangerByID(Serializable id, String deleteMode) {
		// TODO Auto-generated method stub
		this.usermangerDao.deleteEntry(id);
		
	}

	public Collection<UserManger> getAllUserManger() {
		// TODO Auto-generated method stub
		return this.usermangerDao.getAllEntry();
	}

	public UserManger getUserMangerById(Serializable id) {
		// TODO Auto-generated method stub
	
		return (UserManger)this.usermangerDao.getEntryById(id);
		
	}
	@Transactional(readOnly=false)
	public void saveUserManger(UserManger UserManger) {
		// TODO Auto-generated method stub
		this.usermangerDao.saveEntry(UserManger);
		
	}

	@Transactional(readOnly=false)
	public void updateUserManger(UserManger UserManger) {
		// TODO Auto-generated method stub
		this.usermangerDao.updateEntry(UserManger);
	}


	
}
