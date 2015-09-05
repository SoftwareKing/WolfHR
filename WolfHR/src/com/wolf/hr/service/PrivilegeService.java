package com.wolf.hr.service;

import java.util.Collection;

import com.wolf.hr.domain.Menuitem;

public interface PrivilegeService {
	public Collection<Menuitem> getPrivileges(Long uid);
}
