package com.wolf.hr.struts2.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.wolf.hr.domain.Menuitem;
import com.wolf.hr.service.MenuitemService;
import com.wolf.hr.struts2.action.base.BaseAction;

@Controller("menuitemAction")
@Scope("prototype")
public class MenuitemAction extends BaseAction<Menuitem>{
	@Resource(name="menuitemService")
	private MenuitemService menuitemService;
	
	private Collection<Menuitem> menuitemList;
	

	public Collection<Menuitem> getMenuitemList() {
		return menuitemList;
	}


	@JSON(serialize=false)
	public String getAllMenuitem(){
		this.menuitemList = this.menuitemService.getAllMenuitem();
		return SUCCESS;
	}
	
	public String showMenuitemsByPid(){
		this.menuitemList  = this.menuitemService.getMenuitemsByPid(this.getModel().getPid());
		return SUCCESS;
	}
	
	public String showMenuitemsByUser(){
		this.menuitemList = this.menuitemService.getMenuitemsByUser();
		return SUCCESS;
	}
}
