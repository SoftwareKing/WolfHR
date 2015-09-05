package com.wolf.hr.service;

import java.io.Serializable;
import java.util.Collection;

import com.wolf.hr.domain.Message;
import com.wolf.hr.domain.PageBean;
import com.wolf.hr.utils.HqlHelper;


public interface MessageService {

	public Collection<Message> getReceiveMessage();  //收件箱
	public Collection<Message> getSendMessage(); //发件箱
	public Collection<Message> getDraftMessge(); //草稿箱
	
	public void saveMessage(Message message);
	
	public void updateMessage(Message message);
	
	public void deleteSendMessage(Serializable id);
	public void deleteReceiveMessage(Serializable id) ;
	public void deleteDraftMessage(Serializable id) ;
	
	public Message getMessage(Serializable id);
	
}
