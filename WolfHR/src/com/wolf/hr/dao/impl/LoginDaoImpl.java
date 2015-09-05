package com.wolf.hr.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wolf.hr.dao.LoginDao;
import com.wolf.hr.domain.User;

@Repository("loginDao")
public class LoginDaoImpl  implements LoginDao{
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	public User getUserByUAndP(String username, String password) {
		// TODO Auto-generated method stub
		
		String loginpassword=password;
		//因为loginpassword已经是字符串了，所以不能写成String md5password=DigestUtils.md5Hex("loginpassword");
		//否则会报错
		////使用明文的MD5加密,加密后和数据库中的加密密码匹配
		String md5password=DigestUtils.md5Hex(loginpassword);
		//System.out.println(md5password);
		List<User> userList =  this.hibernateTemplate.find("from User where username=? and password=?",new Object[]{username,md5password});
		if(userList.size()!=0){
			return userList.get(0);
		}else{
			return null;
		}
	}
}
