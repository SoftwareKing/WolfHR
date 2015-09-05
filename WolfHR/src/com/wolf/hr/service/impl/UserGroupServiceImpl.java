package com.wolf.hr.service.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wolf.hr.dao.UserGroupDao;
import com.wolf.hr.domain.UserGroup;
import com.wolf.hr.service.UserGroupService;



@Service("userGroupService")
public class UserGroupServiceImpl implements UserGroupService{
	@Resource(name="userGroupDao")
	private UserGroupDao userGroupDao;

	public Collection<UserGroup> getAllUserGroup() {
		// TODO Auto-generated method stub
		return this.userGroupDao.getAllEntry();
	}

	@Transactional(readOnly=false)
	public void updateUserGroup(UserGroup UserGroup) {
		// TODO Auto-generated method stub
		this.userGroupDao.updateEntry(UserGroup);
	}

	@Transactional(readOnly=false)
	public void saveUserGroup(UserGroup UserGroup) {
		// TODO Auto-generated method stub
		this.userGroupDao.saveEntry(UserGroup);
	}

	@Transactional(readOnly=false)
	public void deleteUserGroup(Serializable id) {
		// TODO Auto-generated method stub
		this.userGroupDao.deleteEntry(id);
	}

	public UserGroup getUserGroupById(Serializable id) {
		// TODO Auto-generated method stub
		return (UserGroup)this.userGroupDao.getEntryById(id);
	}
	
}
