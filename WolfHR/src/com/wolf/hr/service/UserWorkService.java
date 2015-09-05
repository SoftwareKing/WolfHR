package com.wolf.hr.service;

import java.io.Serializable;
import java.util.Collection;


import com.wolf.hr.domain.UserWork;
public interface UserWorkService {
	public void saveUserWork(UserWork userwok);

	public void updateUserWork(UserWork userwok);

	public void deleteUserWorkByID(Serializable id,String deleteMode);

	public Collection<UserWork> getAllUserWork();

	public UserWork getUserWorkById(Serializable id);
	
}
