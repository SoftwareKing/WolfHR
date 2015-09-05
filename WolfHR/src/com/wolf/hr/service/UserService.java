package com.wolf.hr.service;

import java.io.File;
import java.io.Serializable;
import java.util.Collection;

import com.wolf.hr.domain.PageBean;
import com.wolf.hr.domain.User;
import com.wolf.hr.utils.HqlHelper;

public interface UserService {
	public Collection<User> getAllUser();
	
	public User getUserById(Serializable id);
	
	public void saveUser(User user);
	
	public void updateUser(User user);
	public void updateUserFile(User user,File photo,File jianli);
	public void updateUserphoto(User user,File photo);
	public void updateUserjianli(User user,File jianli);
	
	public void deleteUserByID(Serializable id,String deleteMode);
	
	
	PageBean getPageBean(int pageNum, HqlHelper hqlHelper);
	
	public void saveUserFile(User user,File photo,File jianli);
	
	public User getUser();
	
	public Collection<User> getUserByJobnumber(String jobnumber);
	public Collection<User> getUserByUsername(String username);
	public Collection<User> getUserBydid(Long  did);
}
