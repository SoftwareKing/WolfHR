package com.wolf.hr.service;

import java.util.Collection;
import java.util.Set;

import com.wolf.hr.domain.Menuitem;



public interface MenuitemService {
	public Collection<Menuitem> getAllMenuitem();
	
	public Collection<Menuitem> getMenuitemsByPid(Long pid);
	
	public Set<Menuitem> getMenuitemsByIDS(Long[] ids);
	
	public Collection<Menuitem> getMenuitemsByUser();
}
