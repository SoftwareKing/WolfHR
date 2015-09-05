package com.wolf.hr.struts2.action;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wolf.hr.domain.Mail;
import com.wolf.hr.domain.Message;
import com.wolf.hr.domain.TaskView;
import com.wolf.hr.service.MailService;
import com.wolf.hr.service.MessageService;
import com.wolf.hr.service.WorkFlowService;
import com.wolf.hr.utils.DateFormat;

public class ForwardAction extends ActionSupport{
	
	@Resource(name="mailService")
	private MailService mailService ; 
	
	@Resource(name="messageService")
	private MessageService messageService ; 
	
	@Resource(name="workFlowService")
	private WorkFlowService workFlowService;
	
	public String left(){
		return "left";
	}
	
	public String right(){
		
		Collection<Mail> maillist=new ArrayList<Mail>();
		for(Mail mail:this.mailService.getReceiveMail())
		{
			try {
				mail.setShowTime(DateFormat.marshal(mail.getSendTime())) ;
				maillist.add(mail);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
			this.mailService.getReceiveMail();
		ActionContext.getContext().put("maillist", maillist);
		
		
		Collection<Message> messagelist=new ArrayList<Message>();
		for (Message message :this.messageService.getReceiveMessage()) {
			try {
				message.setShowTime(DateFormat.marshal(message.getSendTime())) ;
				messagelist.add(message);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
		ActionContext.getContext().put("messagelist", messagelist);
		
		
		/** 待我审批（我的任务列表） */
		Collection<TaskView> taskViewList = this.workFlowService.getAllFormByAssignee();
		ActionContext.getContext().put("taskViewList", taskViewList);
		return "right";
	}
	
	public String top(){
		return "top";
	}
	
	public String bottom(){
		return "bottom";
	}
	
	public String kynamic(){
		return "kynamic";
	}
	
	
	
}
