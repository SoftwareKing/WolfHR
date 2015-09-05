package com.wolf.hr.dao.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.wolf.hr.dao.PrivilegeDao;
import com.wolf.hr.dao.UserDao;
import com.wolf.hr.dao.base.impl.BaseDaoImpl;
import com.wolf.hr.domain.Menuitem;
import com.wolf.hr.domain.User;

@Repository("privilegeDao")
public class PrivilegeDaoImpl extends BaseDaoImpl<Menuitem> implements PrivilegeDao<Menuitem>{
	
	@Resource(name="userDao")
	private UserDao userDao;

	public Collection<Menuitem> getMenuitemsByUID(Long uid) {
		// TODO Auto-generated method stub
		/*
		 * 如果是admin则把所有的菜单的checked设置为true
		 * 如果不是amdin,则先遍历所有的菜单项，再遍历用户能访问到的菜单项，然后把所有的菜单项中，用户能够访问到的checked设置为true
		 */
		/**
		 * 当user被提取出来以后，session已经关闭了
		 */
		User user = (User)this.userDao.getEntryById(uid);
		Collection<Menuitem> menuitemList = this.getAllEntry();
		Collection<Menuitem> menuitems = this.hibernateTemplate.find("from Menuitem m inner join fetch m.users u where u.uid=?",uid);
		if("admin".equals(user.getUsername())){
			for(Menuitem menuitem:menuitemList){
				menuitem.setChecked(true);
			}
		}else{
			for(Menuitem menuitem:menuitemList){
				for(Menuitem menuitem2:menuitems){
					if(menuitem.getMid().longValue()==menuitem2.getMid().longValue()){
						menuitem.setChecked(true);
					}
				}
			}
		}
		return menuitemList;
	}
	
}
