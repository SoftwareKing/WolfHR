package com.wolf.hr.dao.impl;

import java.util.Collection;

import org.springframework.stereotype.Controller;

import com.wolf.hr.dao.MailDao;
import com.wolf.hr.dao.base.impl.BaseDaoImpl;
import com.wolf.hr.domain.Mail;
import com.wolf.hr.domain.User;
import com.wolf.hr.utils.HRUtils;


@Controller("mailDao")
public class MailDaoImpl extends BaseDaoImpl<Mail> implements MailDao<Mail> {


	public Collection<Mail> getDraftMail() {
		User user = HRUtils.fromSession() ;
		return super.hibernateTemplate.find("From Mail m Where status=1 and senderId=?",user.getUid()); 
	}

	public Collection<Mail> getReceiveMail() {
		// TODO Auto-generated method stub
		User user = HRUtils.fromSession() ;
		return super.hibernateTemplate.find("From Mail m Where status=0 and deleteFromInbox=false and receiverId=?",user.getUid());
		
	}

	public Collection<Mail> getSendMail() {
		// TODO Auto-generated method stub
		User user = HRUtils.fromSession() ;
		return super.hibernateTemplate.find("From Mail m Where m.status=0 and m.deleteFromOutbox=false and senderId=?",user.getUid());
	}
}