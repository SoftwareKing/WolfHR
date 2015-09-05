package com.wolf.hr.struts2.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionContext;

import com.wolf.hr.domain.Form;
import com.wolf.hr.domain.PageBean;
import com.wolf.hr.domain.UserLizhi;
import com.wolf.hr.service.UserLizhiService;
import com.wolf.hr.struts2.action.base.BaseAction;
import com.wolf.hr.utils.HqlHelper;




@Controller("userlizhiAction")
@Scope("prototype")
public class UserLizhiAction extends BaseAction<UserLizhi>{
	
	@Resource(name="userlizhiService")
	private UserLizhiService userlizhiService;
	
	private String jobnumbers;
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getJobnumbers() {
		return jobnumbers;
	}

	public void setJobnumbers(String jobnumbers) {
		this.jobnumbers = jobnumbers;
	}

	public String getAllUserLizhi(){
		
		// 1，构建查询条件
		// FROM Form f WHERE f.applicant=? ORDER BY f.applyTime DESC
		HqlHelper hqlHelper = new HqlHelper(UserLizhi.class);
		
		
		
		// 2，查询分页信息
		PageBean pageBean = this.userlizhiService.getPageBean(pageNum, hqlHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		Collection<UserLizhi> userlizhiList = this.userlizhiService.getAllUserLizhi();
		
		//把一个对象存放到map栈中
		ActionContext.getContext().put("userlizhiList", userlizhiList);
		
		return listAction;
	}
	
      public String QueryUserLizhi(){
		
		// 1，构建查询条件
		// FROM Form f WHERE f.applicant=? ORDER BY f.applyTime DESC
		HqlHelper hqlHelper = new HqlHelper(UserLizhi.class);
		// 2，查询分页信息
		PageBean pageBean = this.userlizhiService.getPageBean(pageNum, hqlHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		Collection<UserLizhi> userlizhiList = this.userlizhiService.getUserLizhiByJobnumber(jobnumbers);
		
		//把一个对象存放到map栈中
		ActionContext.getContext().put("userlizhiList", userlizhiList);
		
		return listAction;
	}
	public String deleteUserLizhi(){
		
		this.userlizhiService.deleteUserLizhiByID(this.getModel().getLzid());
		
		return action2action;
	}
	
	public String addUI(){
		return addUI;
	}
	
	public String add(){
		
		UserLizhi userlizhi = new UserLizhi();
		
		BeanUtils.copyProperties(this.getModel(), userlizhi);
		
		this.userlizhiService.saveUserLizhi(userlizhi);
		return action2action;
	}
	/**
	 * 一般情况下，如果数据进行回显，则把数据放入到对象栈中，页面上可以根据name属性的值进行回显
	 * 如果把数据放入到了map栈，则页面根据value的值进行回显，而且value="%{ognl表达式}"
	 * @return
	 */
	public String updateUI(){
		UserLizhi userlizhi = this.userlizhiService.getUserLizhiById(this.getModel().getLzid());
		ActionContext.getContext().getValueStack().getRoot().add(0,userlizhi);
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
		UserLizhi userlizhi = this.userlizhiService.getUserLizhiById(this.getModel().getLzid());
		BeanUtils.copyProperties(this.getModel(),userlizhi);
		this.userlizhiService.updateUserLizhi(userlizhi);
        return action2action;
	}
	
	
}
