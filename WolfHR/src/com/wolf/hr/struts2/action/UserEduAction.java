package com.wolf.hr.struts2.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;


import com.wolf.hr.dao.UserDao;
import com.wolf.hr.dao.UserEduDao;
import com.wolf.hr.domain.Department;
import com.wolf.hr.domain.Mail;
import com.wolf.hr.domain.Post;
import com.wolf.hr.domain.User;
import com.wolf.hr.domain.UserEdu;
import com.wolf.hr.service.UserEduService;
import com.wolf.hr.service.UserService;
import com.wolf.hr.struts2.action.base.BaseAction;
import com.wolf.hr.utils.DateFormat;
import com.wolf.hr.utils.DeleteMode;

@Controller("usereduAction")
@Scope("prototype")
public class UserEduAction extends BaseAction<UserEdu>{
	
	@Resource(name="usereduService")
	private UserEduService usereduService;
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="usereduDao")
	private UserEduDao usereduDao ;
	
	private Long uid;
	
	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getAllUserEdu(){
		
	
		Collection<User> users =this.userService.getAllUser();
		List<User> userEdus = new ArrayList<User>();
		for (User user : users) {
			if(user.getUseredu().size()!=0){
				userEdus.add(user) ;
			}
		}
		ActionContext.getContext().put("user", userEdus);
		//把一个对象存放到map栈中
		
		
		return listAction;
	}
	
	public String deleteUserEdu(){
		this.usereduService.deleteUserEduByID(this.getModel().getUeid(), DeleteMode.DEL_PRE_RELEASE);
		return action2action;
	}
	
	public String addUI(){
		
		Collection<User> userList = this.userService.getAllUser();
		ActionContext.getContext().put("userList", userList);
		return addUI;
	}
	
	public String add(){
		/**
		 * 1、新建一个UserEdu
		 * 2、把模型驱动中的值赋值到UserEdu中
		 * 3.建立user对象和UserEdu之间的关系
		 * 4、执行save方法保存
		 */
		UserEdu useredu = new UserEdu();
		/**
		 * 对象的属性的赋值的过程
		 */
		BeanUtils.copyProperties(this.getModel(), useredu);
		User users = this.userService.getUserById(this.uid);
		useredu.setUsers(users);
		this.usereduService.saveUserEdu(useredu);
		return action2action;
	}
	/**
	 * 一般情况下，如果数据进行回显，则把数据放入到对象栈中，页面上可以根据name属性的值进行回显
	 * 如果把数据放入到了map栈，则页面根据value的值进行回显，而且value="%{ognl表达式}"
	 * @return
	 */
	public String updateUI(){
		UserEdu useredu = this.usereduService.getUserEduById(this.getModel().getUeid());
		ActionContext.getContext().getValueStack().getRoot().add(0,useredu);
		//BeanUtils.copyProperties(department, this.getModel());
		//ActionContext.getContext().put("department", department);
		return updateUI;
	}
	
	/**
	 * 修改
	 * @return
	 */
	public String update(){
		/**
		 * 1、先根据id把该数据从数据库中提取出来(或者从session的缓存中)
		 * 2、把修改以后的数据赋值到该对象中
		 * 3、针对该对象进行update操作
		 */
		UserEdu useredu = this.usereduService.getUserEduById(this.getModel().getUeid());
		BeanUtils.copyProperties(this.getModel(),useredu);
		this.usereduService.updateUserEdu(useredu);
		return action2action;
	}
}
