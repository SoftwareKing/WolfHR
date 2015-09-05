package com.wolf.hr.dao;

import java.util.Collection;

import com.wolf.hr.dao.base.BaseDao;
import com.wolf.hr.domain.Mail;


public interface MailDao<T> extends BaseDao<T>{

	public Collection<Mail> getReceiveMail();  //收件箱
	public Collection<Mail> getSendMail(); //发件箱
	public Collection<Mail> getDraftMail(); //草稿箱
	
}
