package com.wolf.hr.service;

import java.io.Serializable;
import java.util.Collection;

import com.wolf.hr.domain.PageBean;
import com.wolf.hr.domain.UserLizhi;
import com.wolf.hr.utils.HqlHelper;



public interface UserLizhiService {


	public void saveUserLizhi(UserLizhi userlizhi);

	public void updateUserLizhi(UserLizhi userLizhi);

	public void deleteUserLizhiByID(Serializable id);

	public Collection<UserLizhi> getAllUserLizhi();

	public UserLizhi getUserLizhiById(Serializable id);
	
	PageBean getPageBean(int pageNum, HqlHelper hqlHelper);
	public Collection<UserLizhi> getUserLizhiByJobnumber(String jobnumber);
}
