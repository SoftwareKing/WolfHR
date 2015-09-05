package com.wolf.hr.service.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wolf.hr.dao.UserWorkDao;
import com.wolf.hr.domain.UserWork;
import com.wolf.hr.service.UserWorkService;




@Service("userworkService")
public class UserWorkServiceImpl implements UserWorkService{
	@Resource(name="userworkDao")
	private UserWorkDao userworkDao;

	@Transactional(readOnly=false)
	public void deleteUserWorkByID(Serializable id, String deleteMode) {
		// TODO Auto-generated method stub
		this.userworkDao.deleteEntry(id);
		
	}

	public Collection<UserWork> getAllUserWork() {
		// TODO Auto-generated method stub
		return this.userworkDao.getAllEntry();
	}

	public UserWork getUserWorkById(Serializable id) {
		// TODO Auto-generated method stub
	
		return (UserWork)this.userworkDao.getEntryById(id);
		
	}
	@Transactional(readOnly=false)
	public void saveUserWork(UserWork userwork) {
		// TODO Auto-generated method stub
		this.userworkDao.saveEntry(userwork);
		
	}

	@Transactional(readOnly=false)
	public void updateUserWork(UserWork userwork) {
		// TODO Auto-generated method stub
		this.userworkDao.updateEntry(userwork);
	}

}
