package com.wolf.hr.service.impl;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.wolf.hr.dao.UserLizhiDao;
import com.wolf.hr.domain.PageBean;
import com.wolf.hr.domain.UserLizhi;
import com.wolf.hr.service.UserLizhiService;
import com.wolf.hr.utils.Configuration;
import com.wolf.hr.utils.HqlHelper;

@Service("userlizhiService")
public class UserLizhiServiceImpl implements UserLizhiService {
	
	@Resource(name="userlizhiDao")
	private UserLizhiDao userlizhiDao;

	@Resource
	private SessionFactory sessionFactory;
	
     @Transactional(readOnly=false)
	public void deleteUserLizhiByID(Serializable id) {
		// TODO Auto-generated method stub
		this.userlizhiDao.deleteEntry(id);
		

	}

	public Collection<UserLizhi> getAllUserLizhi() {
		// TODO Auto-generated method stub
		return this.userlizhiDao.getAllEntry();
	}

	public UserLizhi getUserLizhiById(Serializable id) {
		// TODO Auto-generated method stub
		return (UserLizhi) this.userlizhiDao.getEntryById(id);
	}
	@Transactional(readOnly=false)
	public void saveUserLizhi(UserLizhi userlizhi) {
		// TODO Auto-generated method stub
		    this.userlizhiDao.saveEntry(userlizhi);
           
	}
	@Transactional(readOnly=false)
	public void updateUserLizhi(UserLizhi UserLizhi) {
		// TODO Auto-generated method stub
           this.userlizhiDao.updateEntry(UserLizhi);
	}
public PageBean getPageBean(int pageNum, HqlHelper hqlHelper) {
		

		List<Object> parameters = hqlHelper.getParameters();
		int pageSize = Configuration.getPageSize();

		// 查询总记录数
		Query countQuery = getSession().createQuery(hqlHelper.getQueryCountHql()); // 生成查询对象
		for (int i = 1; i < parameters.size(); i++) { // 设置参数
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

	public Collection<UserLizhi> getUserLizhiByJobnumber(String jobnumber) {
		// TODO Auto-generated method stub
		return this.userlizhiDao.getUserLizhiByJobnumber(jobnumber);
	}

	

}
