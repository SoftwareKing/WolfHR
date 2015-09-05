package com.wolf.hr.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wolf.hr.dao.PrivilegeDao;
import com.wolf.hr.domain.Menuitem;
import com.wolf.hr.service.PrivilegeService;

@Service("privilegeService")
public class PrivilegeServiceImpl implements PrivilegeService{
	@Resource(name="privilegeDao")
	private PrivilegeDao privilegeDao;

	public Collection<Menuitem> getPrivileges(Long uid) {
		// TODO Auto-generated method stub
		return this.privilegeDao.getMenuitemsByUID(uid);
	}
}
