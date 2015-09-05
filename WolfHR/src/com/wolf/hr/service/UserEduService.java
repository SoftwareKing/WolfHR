package com.wolf.hr.service;

import java.io.Serializable;
import java.util.Collection;


import com.wolf.hr.domain.UserEdu;



public interface UserEduService {
	public void saveUserEdu(UserEdu useredu);

	public void updateUserEdu(UserEdu useredu);

	public void deleteUserEduByID(Serializable id,String deleteMode);

	public Collection<UserEdu> getAllUserEdu();

	public UserEdu getUserEduById(Serializable id);
	
}
