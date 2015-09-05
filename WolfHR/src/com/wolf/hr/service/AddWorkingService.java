package com.wolf.hr.service;


import java.io.Serializable;
import java.util.Collection;

import com.wolf.hr.domain.AddWorking;


public interface AddWorkingService {

	
    public void saveAddWorking(AddWorking addWorking) ;
	
	public Collection<AddWorking> getAllFromMonth() ;
	public Collection<AddWorking> getAllFromNowMonth() ;

	public AddWorking findById(Long id);

	public void update(AddWorking addWorking);

	public Collection<AddWorking> getAllWork();
	public Collection<AddWorking> getAllWorkByUser();
	
	public Double getAllHours(String month,Serializable uid) ;//根据月份统计加班总时长
}
