package com.wolf.hr.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cache.ReadOnlyCache;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wolf.hr.dao.MailDao;
import com.wolf.hr.domain.Mail;
import com.wolf.hr.domain.Message;
import com.wolf.hr.domain.PageBean;
import com.wolf.hr.service.MailService;
import com.wolf.hr.service.MessageService;
import com.wolf.hr.utils.Configuration;
import com.wolf.hr.utils.HqlHelper;


@Service("mailService")
public class MailServiceImpl implements MailService{

	@Resource(name="mailDao")
	private  MailDao mailDao ;
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly=false)
	public void deleteDraftMail(Serializable id) {
		this.mailDao.deleteEntry(id);
	}
	@Transactional(readOnly=false)
	public void deleteReceiveMail(Serializable id) {
		this.mailDao.deleteEntry(id);
	}
	@Transactional(readOnly=false)
	public void deleteSendMail(Serializable id) {
		this.mailDao.deleteEntry(id);
	}

	

	public Collection<Mail> getDraftMail() {
		return this.mailDao.getDraftMail();
	}

	public Collection<Mail> getReceiveMail() {
		return this.mailDao.getReceiveMail();
	}
	
	public Mail getMail(Serializable id) {
		return (Mail) this.mailDao.getEntryById(id);
	}

	@Transactional(readOnly=false)
	public void updateMail(Mail mail) {
		this.mailDao.updateEntry(mail);
	}

	@Transactional(readOnly=false)
	public void saveMail(Mail mail) {
		this.mailDao.saveEntry(mail);
	}
	public Collection<Mail> getSendMail() {
		return this.mailDao.getSendMail();
	}
	public Collection<Mail> getALLmail() {
		// TODO Auto-generated method stub
		return this.mailDao.getAllEntry();
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
	 
	@Transactional(readOnly=false)
	public void deleteMail(Serializable id) {
		// TODO Auto-generated method stub
		this.mailDao.deleteEntry(id);
	}


}
