package com.wolf.hr.service.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.wolf.hr.dao.UserEduDao;

import com.wolf.hr.domain.UserEdu;
import com.wolf.hr.service.UserEduService;


@Service("usereduService")
public class UserEduServiceImpl implements UserEduService{
	@Resource(name="usereduDao")
	private UserEduDao usereduDao;
     @Transactional(readOnly=false)
	public void deleteUserEduByID(Serializable id, String deleteMode) {
		// TODO Auto-generated method stub
		this.usereduDao.deleteEntry(id);
		
	}

	public Collection<UserEdu> getAllUserEdu() {
		// TODO Auto-generated method stub
		return this.usereduDao.getAllEntry();
	}

	public UserEdu getUserEduById(Serializable id) {
		// TODO Auto-generated method stub
	
		return (UserEdu)this.usereduDao.getEntryById(id);
		
	}
	@Transactional(readOnly=false)
	public void saveUserEdu(UserEdu useredu) {
		// TODO Auto-generated method stub
		this.usereduDao.saveEntry(useredu);
		
	}
	@Transactional(readOnly=false)
	public void updateUserEdu(UserEdu useredu) {
		// TODO Auto-generated method stub
		this.usereduDao.updateEntry(useredu);
	}


	
}
