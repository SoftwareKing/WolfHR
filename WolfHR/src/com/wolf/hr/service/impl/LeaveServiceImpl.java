package com.wolf.hr.service.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wolf.hr.dao.LeaveDao;
import com.wolf.hr.domain.Leave;
import com.wolf.hr.domain.PageBean;
import com.wolf.hr.service.LeaveService;
import com.wolf.hr.utils.Configuration;
import com.wolf.hr.utils.HqlHelper;


@Service("leaveService")
public class LeaveServiceImpl implements LeaveService {

	@Resource(name="leaveDao")
	private LeaveDao leaveDao;
	
	@Resource
	private SessionFactory sessionFactory;
	
	public Collection<Leave> getAllFromMonth() {
		// TODO Auto-generated method stub
		return leaveDao.getAllFromMonth();
	}

	public Collection<Leave> getAllFromNowMonth() {
		// TODO Auto-generated method stub
		return leaveDao.getAllFromNowMonth();
	}

	@Transactional(readOnly=false)
	public void saveLeave(Leave leave) {
		// TODO Auto-generated method stub
		leaveDao.saveEntry(leave);
	}

	public Collection<Leave> getAllByYear() {
		// TODO Auto-generated method stub
		return leaveDao.getAllFromByYear();
	}

	public Leave findById(Long id) {
		// TODO Auto-generated method stub
		return (Leave) leaveDao.getEntryById(id);
	}

	public Collection<Leave> getAllLeaves() {
		// TODO Auto-generated method stub
		return leaveDao.getAllEntry();
	}
	@Transactional(readOnly=false)
	public void update(Leave leave) {
		// TODO Auto-generated method stub
		leaveDao.updateEntry(leave) ;
	}
public PageBean getPageBean(int pageNum, HqlHelper hqlHelper) {
		

		List<Object> parameters = hqlHelper.getParameters();
		int pageSize = Configuration.getPageSize();

		// 查询总记录数
		Query countQuery = getSession().createQuery(hqlHelper.getQueryCountHql()); // 生成查询对象
		for (int i = 0; i < parameters.size(); i++) { // 设置参数
			countQuery.setParameter(i, parameters.get(i));
		}
		int count = ((Long) countQuery.uniqueResult()).intValue();

		// 查询一段数据列表
		Query listQuery = getSession().createQuery(hqlHelper.getQueryListHql()); // 生成查询对象
		for (int i = 0; i < parameters.size(); i++) { // 设置参数
			listQuery.setParameter(i, parameters.get(i));
		}
		listQuery.setFirstResult((pageNum - 1) * pageSize);
		listQuery.setMaxResults(pageSize);
		List list = listQuery.list(); // 查询

		return new PageBean(pageNum, pageSize, count, list);
	}
	/**
	 * 获取当前可用的Session
	 * 
	 * @return
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
