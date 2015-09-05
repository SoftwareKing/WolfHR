package com.wolf.hr.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wolf.hr.dao.MessageDao;
import com.wolf.hr.domain.Message;
import com.wolf.hr.domain.PageBean;
import com.wolf.hr.service.MessageService;
import com.wolf.hr.utils.Configuration;
import com.wolf.hr.utils.HqlHelper;


@Service("messageService")
public class MessageServiceImpl implements MessageService{

	@Resource(name="messageDao")
	private  MessageDao messageDao ;
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly=false)
	public void deleteDraftMessage(Serializable id) {
		// TODO Auto-generated method stub
		this.messageDao.deleteEntry(id);
	}
	@Transactional(readOnly=false)
	public void deleteReceiveMessage(Serializable id) {
		// TODO Auto-generated method stub
		this.messageDao.deleteEntry(id);
	}
	@Transactional(readOnly=false)
	public void deleteSendMessage(Serializable id) {
		// TODO Auto-generated method stub
		this.messageDao.deleteEntry(id);
	}

	

	public Collection<Message> getDraftMessge() {
		// TODO Auto-generated method stub
		return this.messageDao.getDraftMessge();
	}

	public Collection<Message> getReceiveMessage() {
		// TODO Auto-generated method stub
		return this.messageDao.getReceiveMessage();
	}
	
	public Message getMessage(Serializable id) {
		// TODO Auto-generated method stub
		return (Message) this.messageDao.getEntryById(id);
	}

	@Transactional(readOnly=false)
	public void updateMessage(Message message) {
		// TODO Auto-generated method stub
		this.messageDao.updateEntry(message);
	}

	@Transactional(readOnly=false)
	public void saveMessage(Message message) {
		// TODO Auto-generated method stub
		this.messageDao.saveEntry(message);
	}


	public Collection<Message> getSendMessage() {
		// TODO Auto-generated method stub
		return this.messageDao.getSendMessage();
	}

}
