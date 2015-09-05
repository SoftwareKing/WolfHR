package com.wolf.hr.service;

import java.io.Serializable;
import java.util.Collection;

import com.wolf.hr.domain.Mail;
import com.wolf.hr.domain.PageBean;
import com.wolf.hr.utils.HqlHelper;



public interface MailService {

	public Collection<Mail> getReceiveMail();  //收件箱
	public Collection<Mail> getSendMail(); //发件箱
	public Collection<Mail> getDraftMail(); //草稿箱
	
	public void saveMail(Mail mail);
	
	public void updateMail(Mail mail);
	
	public void deleteSendMail(Serializable id);
	public void deleteReceiveMail(Serializable id) ;
	public void deleteDraftMail(Serializable id) ;
	
	public Mail getMail(Serializable id);
	
	public Collection<Mail> getALLmail();
	
	public void deleteMail(Serializable id);
	
	PageBean getPageBean(int pageNum, HqlHelper hqlHelper);
	
}
