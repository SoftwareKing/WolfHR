package com.wolf.hr.service;

import java.util.Collection;

import com.wolf.hr.domain.Leave;
import com.wolf.hr.domain.PageBean;
import com.wolf.hr.utils.HqlHelper;

public interface LeaveService {

	public void saveLeave(Leave leave);

	public Collection<Leave> getAllFromMonth();

	public Collection<Leave> getAllFromNowMonth();
	public Collection<Leave> getAllByYear();
	
	public Collection<Leave> getAllLeaves();

	public Leave findById(Long id);

	public void update(Leave leave);
	
	PageBean getPageBean(int pageNum, HqlHelper hqlHelper);
}
