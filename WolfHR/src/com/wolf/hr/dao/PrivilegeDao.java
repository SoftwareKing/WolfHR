package com.wolf.hr.dao;

import java.util.Collection;

import com.wolf.hr.dao.base.BaseDao;
import com.wolf.hr.domain.Menuitem;

public interface PrivilegeDao<T> extends BaseDao<T>{
	public Collection<Menuitem> getMenuitemsByUID(Long uid);
}
