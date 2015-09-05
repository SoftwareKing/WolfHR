package com.wolf.hr.service.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wolf.hr.dao.AddWorkingDao;
import com.wolf.hr.domain.AddWorking;
import com.wolf.hr.service.AddWorkingService;

@Service("addWorkingService")
public class AddWorkingServiceImpl implements AddWorkingService{


	@Resource(name="addWorkingDao")
	private AddWorkingDao addWorkingDao ;
	
	@Transactional(readOnly=false)
	public void saveAddWorking(AddWorking addWorking) {
		// TODO Auto-generated method stub
		addWorkingDao.saveEntry(addWorking);
	}

	public Collection<AddWorking> getAllFromMonth() {
		// TODO Auto-generated method stub
		return addWorkingDao.getAllFromMonth();
	}

	public Collection<AddWorking> getAllFromNowMonth() {
		// TODO Auto-generated method stub
		return addWorkingDao.getAllFromNowMonth();
	}

	public AddWorking findById(Long id) {
		// TODO Auto-generated method stub
		return (AddWorking) addWorkingDao.getEntryById(id) ;
	}
	
	@Transactional(readOnly=false)
	public void update(AddWorking addWorking) {
		this.addWorkingDao.updateEntry(addWorking) ;
	}

	public Collection<AddWorking> getAllWork() {
		return this.addWorkingDao.getAllEntry();
	}

	public Collection<AddWorking> getAllWorkByUser() {
		return this.addWorkingDao.getAllByUser();
	}

	public Double getAllHours(String month,Serializable uid) {
		// TODO Auto-generated method stub
		Double x =  this.addWorkingDao.getAllHours(month,uid);
		if(x!=null){
			return x ;
		} else return 0.0 ;
	}
}
