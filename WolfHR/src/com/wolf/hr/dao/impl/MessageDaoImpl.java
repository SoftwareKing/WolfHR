package com.wolf.hr.dao.impl;

import java.util.Collection;

import org.springframework.stereotype.Controller;

import com.wolf.hr.dao.MessageDao;
import com.wolf.hr.dao.base.impl.BaseDaoImpl;
import com.wolf.hr.domain.Message;
import com.wolf.hr.domain.User;
import com.wolf.hr.utils.HRUtils;


@Controller("messageDao")
public class MessageDaoImpl extends BaseDaoImpl<Message> implements MessageDao<Message> {


	public Collection<Message> getDraftMessge() {
		// TODO Auto-generated method stub
		//return this.hibernateTemplate.find("From Message m Where m.status=1 and m.senderId=?");
		User user = HRUtils.fromSession() ;
		return super.hibernateTemplate.find("From Message m Where status=1 and senderId=?",user.getUid()); 
	}

	public Collection<Message> getReceiveMessage() {
		// TODO Auto-generated method stub
		User user = HRUtils.fromSession() ;
		return super.hibernateTemplate.find("From Message m Where status=0 and deleteFromInbox=false and receiverId=?",user.getUid());
		
	}

	public Collection<Message> getSendMessage() {
		// TODO Auto-generated method stub
		User user = HRUtils.fromSession() ;
		return super.hibernateTemplate.find("From Message m Where m.status=0 and m.deleteFromOutbox=false and senderId=?",user.getUid());
	}
}