package com.wolf.hr.service;

import java.io.File;
import java.io.Serializable;
import java.util.Collection;

import com.wolf.hr.domain.PageBean;
import com.wolf.hr.domain.Performance;
import com.wolf.hr.utils.HqlHelper;



public interface PerformanceService {


	public void savePerformance(Performance performance);

	public void updatePerformance(Performance performance);

	public void deletePerformanceByID(Serializable id);

	public Collection<Performance> getAllPerformance();

	public Performance getPerformanceById(Serializable id);
	
	PageBean getPageBean(int pageNum, HqlHelper hqlHelper);
	public void savePerforUserWithExcel(Performance performance,File file);
	
	public Collection<Performance> getPerformanceByJobnumber(String jobnumber);
}
