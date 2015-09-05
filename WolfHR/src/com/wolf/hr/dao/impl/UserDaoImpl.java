package com.wolf.hr.dao.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.wolf.hr.dao.UserDao;
import com.wolf.hr.dao.base.impl.BaseDaoImpl;
import com.wolf.hr.domain.User;
import com.wolf.hr.utils.HRUtils;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao<User>{

	public Collection<User> getUsers() {
		// TODO Auto-generated method stub
		List<User> useList =  this.hibernateTemplate.find("from User u left join fetch u.department d left join fetch u.posts p");
		return new HashSet<User>(useList);
	}
	public Collection<User> getUserByUsername(String username) {
		// TODO Auto-generated method stub
	        return this.hibernateTemplate.find("from User where username=?",username);
		
	}
	public User getUserByUserByID() {
		
		List<User> userList  = this.hibernateTemplate.find("from User where uid=?",HRUtils.fromSession().getUid()) ;
		if(userList.size()==0){
			return null;
		}else{
			return userList.get(0);
		}
	}
	public Collection<User> getUserByJobnumber(String jobnumber) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from User where Jobnumber=?", jobnumber);
	}
	/*public Collection<User> getUserBydepartment(String username) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from User where username=?", username);
	}*/
	public Collection<User> getUserBydid(Long did) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from User where department.did=?", did);
	}

}
