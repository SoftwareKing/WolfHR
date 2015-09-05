package com.wolf.hr.service;

import java.io.Serializable;
import java.util.Collection;

import com.wolf.hr.domain.UserGroup;





public interface UserGroupService {
	public Collection<UserGroup> getAllUserGroup();
	
	public void updateUserGroup(UserGroup usergroup);
	
	public void saveUserGroup(UserGroup usergroup);
	
	public void deleteUserGroup(Serializable id);
	
	public UserGroup getUserGroupById(Serializable id);
}
