package com.wolf.hr.service.impl;

import java.io.File;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wolf.hr.dao.UserDao;
import com.wolf.hr.dao.UserEduDao;
import com.wolf.hr.dao.UserMangerDao;
import com.wolf.hr.dao.UserWorkDao;
import com.wolf.hr.domain.PageBean;
import com.wolf.hr.domain.User;
import com.wolf.hr.domain.UserEdu;
import com.wolf.hr.domain.UserManger;
import com.wolf.hr.domain.UserWork;
import com.wolf.hr.service.UserService;
import com.wolf.hr.utils.Configuration;
import com.wolf.hr.utils.HqlHelper;
import com.wolf.hr.utils.UploadUtils;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource(name="userDao")
	private UserDao userDao;
	
	@Resource(name="usermangerDao")
	private UserMangerDao usermangerDao;
	
	@Resource(name="userworkDao")
	private UserWorkDao userworkDao ;
	@Resource(name="usereduDao")
	private UserEduDao usereduDao ;
	
	@Resource
	private SessionFactory sessionFactory;
	
	public Collection<User> getAllUser() {
		// TODO Auto-generated method stub
		return this.userDao.getUsers();
	}

	@Transactional(readOnly=false)
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		this.userDao.saveEntry(user);
	}

	public User getUserById(Serializable id) {
		// TODO Auto-generated method stub
		return (User)this.userDao.getEntryById(id);
		
	}
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=false)
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
		this.userDao.updateEntry(user);
	}

	@Transactional(readOnly=false)
	public void updateUserFile(User user,File photo,File jianli) {
		// TODO Auto-generated method stub
		String urlp = UploadUtils.saveUploadFile(photo);
		String urlj = UploadUtils.saveUploadFile(jianli);
		user.setPhotourl(urlp);
		user.setJianliurl(urlj);
		this.userDao.updateEntry(user);
	}
	@Transactional(readOnly=false)
	public void updateUserphoto(User user,File photo) {
		// TODO Auto-generated method stub
		String urlp = UploadUtils.saveUploadFile(photo);
		user.setPhotourl(urlp);
		this.userDao.updateEntry(user);
	}
	@Transactional(readOnly=false)
	public void updateUserjianli(User user,File jianli) {
		String urlj = UploadUtils.saveUploadFile(jianli);
		user.setJianliurl(urlj);
		this.userDao.updateEntry(user);
	}
	
	
	@Transactional(readOnly=false)
	public void deleteUserByID(Serializable id, String deleteMode) {
		// TODO Auto-generated method stub
		this.userDao.deleteEntry(id);
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

	public User getUser() {
		
		User user = userDao.getUserByUserByID() ;
		if(user != null){
			
			Set<UserEdu> edus = new HashSet(usereduDao.getEduByUser(user.getUid())) ;
			Set<UserWork> works = new HashSet(userworkDao.getUserWorkByUser(user.getUid())) ;
			UserManger userManger = usermangerDao.getMangerByUser(user.getUid());
			user.setUseredu(edus);
			user.setUsermanger(userManger) ;
			user.setUserwork(works) ;
		}
		
		return user;
	}
	@Transactional(readOnly=false)
	public void saveUserFile(User user, File photo, File jianli) {
		// TODO Auto-generated method stub
		String urlp = UploadUtils.saveUploadFile(photo);
		String urlj = UploadUtils.saveUploadFile(jianli);
		user.setPhotourl(urlp);
		user.setJianliurl(urlj);
		this.userDao.saveEntry(user);
	}

	public Collection<User> getUserByJobnumber(String jobnumber) {
		// TODO Auto-generated method stub
		return this.userDao.getUserByJobnumber(jobnumber);
	}

	public Collection<User> getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return this.userDao.getUserByUsername(username);
	}

	public Collection<User> getUserBydid(Long did) {
		// TODO Auto-generated method stub
		return this.userDao.getUserBydid(did);
	}

	
}
