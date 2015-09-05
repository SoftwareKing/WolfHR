package com.wolf.hr.dao;

import java.util.Collection;
import java.util.Set;

import com.wolf.hr.dao.base.BaseDao;
import com.wolf.hr.domain.Menuitem;



public interface MenuitemDao<T> extends BaseDao<T>{
	public Collection<Menuitem> getMenuitemsByPid(Long pid);
	
	public Set<Menuitem> getMenuitemsByIDS(Long[] ids);
	
	public Collection<Menuitem> getMenuitemsByUser();
}
