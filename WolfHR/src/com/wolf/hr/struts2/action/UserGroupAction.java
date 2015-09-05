package com.wolf.hr.struts2.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.wolf.hr.domain.UserGroup;
import com.wolf.hr.service.UserGroupService;
import com.wolf.hr.struts2.action.base.BaseAction;




@Controller("userGroupAction")
@Scope("prototype")
public class UserGroupAction extends BaseAction<UserGroup>{
	@Resource(name="userGroupService")
	private UserGroupService userGroupService;
	public String getAllUserGroup(){
		Collection<UserGroup> UserGroupList = this.userGroupService.getAllUserGroup();
		ActionContext.getContext().put("UserGroupList", UserGroupList);
		return listAction;
	}
	
	public String addUI(){
		return addUI;
	}
	
	public String add(){
		UserGroup UserGroup = new UserGroup();
		BeanUtils.copyProperties(this.getModel(), UserGroup);
		this.userGroupService.saveUserGroup(UserGroup);
		return action2action;
	}
	
	public String delete(){
		this.userGroupService.deleteUserGroup(this.getModel().getUgid());
		return action2action;
	}
	
	public String updateUI(){
		UserGroup UserGroup = this.userGroupService.getUserGroupById(this.getModel().getUgid());
		ActionContext.getContext().getValueStack().pop();
		ActionContext.getContext().getValueStack().push(UserGroup);
		return updateUI;
	}
	
	public String update(){
		UserGroup UserGroup = this.userGroupService.getUserGroupById(this.getModel().getUgid());
		BeanUtils.copyProperties(this.getModel(), UserGroup);
		this.userGroupService.updateUserGroup(UserGroup);
		return action2action;
	}
}
