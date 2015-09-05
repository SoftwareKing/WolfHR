package com.wolf.hr.service;

import java.io.Serializable;
import java.util.Collection;


import com.wolf.hr.domain.UserManger;



public interface UserMangerService {
	public void saveUserManger(UserManger usermanger);

	public void updateUserManger(UserManger usermanger);

	public void deleteUserMangerByID(Serializable id,String deleteMode);

	public Collection<UserManger> getAllUserManger();

	public UserManger getUserMangerById(Serializable id);
	
}
