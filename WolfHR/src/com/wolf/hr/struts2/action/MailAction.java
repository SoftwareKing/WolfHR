package com.wolf.hr.struts2.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.annotation.Resource;


import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.wolf.hr.domain.Form;
import com.wolf.hr.domain.Mail;
import com.wolf.hr.domain.PageBean;


import com.wolf.hr.domain.User;
import com.wolf.hr.service.MailService;
import com.wolf.hr.service.UserService;
import com.wolf.hr.struts2.action.base.BaseAction;
import com.wolf.hr.utils.DateFormat;
import com.wolf.hr.utils.HRUtils;
import com.wolf.hr.utils.HqlHelper;

@Controller("mailAction")
@Scope("prototype")
public class MailAction extends BaseAction<Mail>{

	private File myFile ;
	private String myFileFileName;
	private String myFileContentType ;
	
	
	public String getMyFileContentType() {
		return myFileContentType;
	}
	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}
	public String getMyFileFileName() {
		return myFileFileName;
	}
	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}
	public File getMyFile() {
		return myFile;
	}
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	@Resource(name="mailService")
	private MailService mailService ; 
	
	@Resource(name="userService")
	private UserService userService ;
	
	
	public String getALLmail()
	{
		
		Collection<Mail> mailList= new ArrayList<Mail>();
		for (Mail mail :this.mailService.getALLmail()) {
			try {
				mail.setShowTime(DateFormat.marshal(mail.getSendTime())) ;
				mailList.add(mail);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		HqlHelper hqlHelper = new HqlHelper(Mail.class,"m");
		// 2，查询分页信息
		PageBean pageBean = this.mailService.getPageBean(pageNum, hqlHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		ActionContext.getContext().put("mailList", mailList);
		return listAction;
	}
	
	public String deleteMail()
	{
		
		this.mailService.deleteMail(this.getModel().getId());
		
		return "getALLmail";
	}
	/**************收件箱--已接收邮件*****************/
	public String inboxList(){
		
		
		Collection<Mail> inboxList =  new ArrayList<Mail>();
		for (Mail mail :this.mailService.getReceiveMail()) {
			try {
				mail.setShowTime(DateFormat.marshal(mail.getSendTime())) ;
				inboxList.add(mail);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ActionContext.getContext().put("inboxList", inboxList);
		return "inbox" ;
	}
	
	/**************发送邮件*****************/
	public String sendMail(){
		Collection<User> userList = this.userService.getAllUser() ;
		ActionContext.getContext().put("userList", userList);
		return addUI ;
	}
	
	/**************保存已发送的邮件到已发邮件箱*****************/
	public String saveSendMail() throws IOException{
		Mail mail = new Mail() ;
		BeanUtils.copyProperties(this.getModel(), mail);
		
		mail.setMyFile(this.myFile);
		mail.setFileSend(myFileFileName);
		System.out.println(mail.getFileSend());
		String path = ServletActionContext.getServletContext().getRealPath("/file");
		path = path.replace("\\", "/");
		if(mail.getMyFile() != null){
			FileUtils.copyFile(mail.getMyFile(), new File(path+"/"+this.myFileFileName));
		}
		mail.setContentType(this.myFileContentType);
		User receiver = this.userService.getUserById(mail.getReceiver().getUid());
		mail.setReceiver(receiver);
		System.out.println(mail.getContent());
		User sender = HRUtils.fromSession();
		mail.setSender(sender);
		mail.setDeleteFromInbox(false);
		mail.setDeleteFromOutbox(false);
		mail.setHasRead(false);
		mail.setSendTime(new Date());
		mail.setStatus(0);
		this.mailService.saveMail(mail);
		return action2action ;
	}
	
	/**************已发邮件箱*****************/
	public String outboxList(){
		
		
			Collection<Mail> outboxList =  new ArrayList<Mail>();
			for (Mail mail :this.mailService.getSendMail()) {
				 //System.out.println(mail.getSendTime());
				try {
					mail.setShowTime(DateFormat.marshal(mail.getSendTime())) ;
					outboxList.add(mail);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			ActionContext.getContext().put("outboxList", outboxList);
			return "outbox" ;
	}
	
	/**************草稿邮件箱*****************/
	public String draftboxList(){
		
		Collection<Mail> draftboxList =  new ArrayList<Mail>();
		for (Mail mail :this.mailService.getDraftMail()) {
			 //System.out.println(mail.getSendTime());
			try {
				mail.setShowTime(DateFormat.marshal(mail.getSendTime())) ;
				draftboxList.add(mail);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ActionContext.getContext().put("draftboxList", draftboxList);
		return "draftbox" ;
	}
	
	/**************从已接收的邮件中删除邮件*****************/
	public String  deleteFrominbox(){
		
		System.out.println(this.getModel().getId());
		Mail mail = this.mailService.getMail(this.getModel().getId());
		if(mail != null){
			mail.setDeleteFromInbox(true);
			this.mailService.updateMail(mail);
			if(mail.isDeleteFromInbox()&&mail.isDeleteFromOutbox()){
				this.mailService.deleteReceiveMail(mail.getId());
			}
		}
		return "inbox" ;
	}
	
	/**************从已发出的的邮件中删除邮件*****************/
	public String deleteFromoutbox(){
		
		Mail mail = this.mailService.getMail(this.getModel().getId());
		
		if(mail != null){
			mail.setDeleteFromOutbox(true);
			this.mailService.updateMail(mail);
			if(mail.isDeleteFromInbox()&&mail.isDeleteFromOutbox()){
				this.mailService.deleteSendMail(mail.getId());
			}
		}
		return action2action ;
	}
	/**************保存草稿邮件*****************/
	public String saveDraftMail() throws IOException{
		Mail mail = new Mail() ;
		BeanUtils.copyProperties(this.getModel(), mail);
		User receiver = this.userService.getUserById(mail.getReceiver().getUid());
		mail.setMyFile(this.myFile);
		mail.setFileSend(myFileFileName);
		System.out.println(mail.getFileSend());
		String path = ServletActionContext.getServletContext().getRealPath("/file");
		path = path.replace("\\", "/");
		if(mail.getMyFile() != null){
			FileUtils.copyFile(mail.getMyFile(), new File(path+"/"+this.myFileFileName));
		}
		mail.setContentType(this.myFileContentType);
		mail.setReceiver(receiver);
		User sender = HRUtils.fromSession();
		mail.setSender(sender);
		mail.setDeleteFromInbox(false);
		mail.setDeleteFromOutbox(false);
		mail.setHasRead(false);
		mail.setSendTime(new Date());
		mail.setStatus(1);
		this.mailService.saveMail(mail);
		return "draftboxList" ;
	}
	
	/**************删除草稿箱*****************/
	public String deleteDraftMail(){   
		Mail mail = this.mailService.getMail(this.getModel().getId());
		if(mail != null){
				this.mailService.deleteReceiveMail(mail.getId());
		}
		return "draftboxList" ;
	}
	
	
	/**************回复邮件*****************/
	public String reSendMail(){  
		Mail mail = this.mailService.getMail(this.getModel().getId());
		ActionContext.getContext().put("user", mail.getSender());
		return "update";
	}
	
	/**************发送草稿箱中的邮件*****************/
	public String sendFromDraftbox(){
		Mail mail = this.mailService.getMail(this.getModel().getId());
		mail.setStatus(0);
		this.mailService.saveMail(mail);
		return action2action;
	}
	
	/**************查看邮件*****************/
	public String seeMail(){
		Mail mail = this.mailService.getMail(this.getModel().getId());
		try {
			mail.setShowTime(DateFormat.marshal(mail.getSendTime()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ActionContext.getContext().put("mail", mail);
		return "seemail";
	}
	public String DownFile(){
		return "success" ;
	}
	public InputStream getStream() throws FileNotFoundException{
		
		Mail mail = this.mailService.getMail(this.getModel().getId());
		
		String path = ServletActionContext.getServletContext().getRealPath("/file");
		path = path.replace("\\", "/")+"/"+mail.getFileSend();
		ActionContext.getContext().put("myFileContentType",mail.getContentType());
		ActionContext.getContext().put("myFileFileName", mail.getFileSend());
		InputStream stream = new FileInputStream(new File(path));
		return stream ;
	}
	
}
