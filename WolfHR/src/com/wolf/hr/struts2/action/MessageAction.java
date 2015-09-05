package com.wolf.hr.struts2.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.wolf.hr.domain.Message;
import com.wolf.hr.domain.PageBean;
import com.wolf.hr.domain.User;
import com.wolf.hr.service.MessageService;
import com.wolf.hr.service.UserService;
import com.wolf.hr.struts2.action.base.BaseAction;
import com.wolf.hr.utils.DateFormat;
import com.wolf.hr.utils.HRUtils;
import com.wolf.hr.utils.HqlHelper;



@Controller("messageAction")
@Scope("prototype")
public class MessageAction extends BaseAction<Message>{
	
	@Resource(name="messageService")
	private MessageService messageService ; 
	
	@Resource(name="userService")
	private UserService userService ;
	
	
	/**************收件箱--已接收消息*****************/
	public String inboxList(){
		
		
		
		Collection<Message> inboxList =  new ArrayList<Message>();
		for (Message message :this.messageService.getReceiveMessage()) {
			 //System.out.println(message.getSendTime());
			try {
				message.setShowTime(DateFormat.marshal(message.getSendTime())) ;
				inboxList.add(message);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ActionContext.getContext().put("inboxList", inboxList);
		return "inbox" ;
	}
	
	/**************发送收消息*****************/
	public String sendMessage(){
		Collection<User> userList = this.userService.getAllUser() ;
		ActionContext.getContext().put("userList", userList);
		User user = HRUtils.fromSession() ;
		ActionContext.getContext().put("user", user);
		return addUI ;
	}
	
	/**************消息保存到草稿箱*****************/
	public String saveSendMessage(){
		Message message = new Message() ;
		BeanUtils.copyProperties(this.getModel(), message);
		
		User receiver = this.userService.getUserById(message.getReceiver().getUid());
		message.setReceiver(receiver);
		System.out.println(message.getContent());
		User sender = HRUtils.fromSession();
		message.setSender(sender);
		message.setDeleteFromInbox(false);
		message.setDeleteFromOutbox(false);
		message.setHasRead(false);
		message.setSendTime(new Date());
		message.setStatus(0);
		this.messageService.saveMessage(message);
		return action2action ;
	}
	
	/**************已发的消息*****************/
	public String outboxList(){
		
		
			Collection<Message> outboxList = new ArrayList<Message>();
			for (Message message : this.messageService.getSendMessage()) {
				 
				try {
					message.setShowTime(DateFormat.marshal(message.getSendTime())) ;
					outboxList.add(message);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
			ActionContext.getContext().put("outboxList", outboxList);
			return "outbox" ;
	}
	/**************草稿箱*****************/
	public String draftboxList(){
		
		
		Collection<Message> draftboxList = new ArrayList<Message>();
		for (Message message :  this.messageService.getDraftMessge()) {
			
			try {
				message.setShowTime(DateFormat.marshal(message.getSendTime())) ;
				draftboxList.add(message);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ActionContext.getContext().put("draftboxList", draftboxList);
		return "draftbox" ;
	}
	
	/**************删除已接收的消息*****************/
	public String  deleteFrominbox(){
		
		System.out.println(this.getModel().getId());
		Message message = this.messageService.getMessage(this.getModel().getId());
		if(message != null){
			message.setDeleteFromInbox(true);
			this.messageService.updateMessage(message);
			if(message.isDeleteFromInbox()&&message.isDeleteFromOutbox()){
				this.messageService.deleteReceiveMessage(message.getId());
			}
		}
		return "inbox" ;
	}
	
	/**************删除已发送的的消息*****************/
	public String deleteFromoutbox(){
		System.out.println(this.getModel().getId());
		Message message = this.messageService.getMessage(this.getModel().getId());
		
		if(message != null){
			message.setDeleteFromOutbox(true);
			this.messageService.updateMessage(message);
			if(message.isDeleteFromInbox()&&message.isDeleteFromOutbox()){
				this.messageService.deleteSendMessage(message.getId());
			}
		}
		return action2action ;
	}
	
	/**************保存到草稿箱的*****************/
	public String saveDraftMessage(){
		Message message = new Message() ;
		BeanUtils.copyProperties(this.getModel(), message);
		User receiver = this.userService.getUserById(message.getReceiver().getUid());
		
		
		message.setReceiver(receiver);
		User sender = HRUtils.fromSession();
		message.setSender(sender);
		message.setDeleteFromInbox(false);
		message.setDeleteFromOutbox(false);
		message.setHasRead(false);
		message.setSendTime(new Date());
		message.setStatus(1);
		this.messageService.saveMessage(message);
		return "draftboxList" ;
	}
	/**************删除草稿箱*****************/
	public String deleteDraftMessage(){   
		Message message = this.messageService.getMessage(this.getModel().getId());
		if(message != null){
				this.messageService.deleteReceiveMessage(message.getId());
		}
		return "draftboxList" ;
	}
	
	/**************回复消息*****************/
	public String reSendMessage(){   
		Message message = this.messageService.getMessage(this.getModel().getId());
		ActionContext.getContext().put("user", message.getSender());
		return "update";
	}
	
	/**************发送草稿箱中的消息*****************/
	public String sendFromDraftbox(){
		Message message = this.messageService.getMessage(this.getModel().getId());
		message.setStatus(0);
		this.messageService.saveMessage(message);
		return action2action;
	}
	
	/**************查看想查看的所有消息*****************/
	public String seeMessage(){
		System.out.println("路径是："+this.getClass().getClassLoader().getResource(""));
		Message message = this.messageService.getMessage(this.getModel().getId());
		
		try {
			message.setShowTime(DateFormat.marshal(message.getSendTime()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ActionContext.getContext().put("message", message);
		
		return "seeMessage";
	}
	
}
