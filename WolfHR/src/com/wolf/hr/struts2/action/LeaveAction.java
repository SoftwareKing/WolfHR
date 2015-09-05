package com.wolf.hr.struts2.action;

import java.util.Collection;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.wolf.hr.domain.Form;
import com.wolf.hr.domain.Leave;
import com.wolf.hr.domain.PageBean;
import com.wolf.hr.domain.User;
import com.wolf.hr.service.LeaveService;
import com.wolf.hr.struts2.action.base.BaseAction;
import com.wolf.hr.utils.DateFormat;
import com.wolf.hr.utils.HRUtils;
import com.wolf.hr.utils.HqlHelper;

/***请假考勤****/
@Controller("leaveAction")
@Scope("prototype")
public class LeaveAction extends BaseAction<Leave> {

	@Resource(name="leaveService")
	private LeaveService leaveService ;
	
	/***********保存请假考勤*******************/
	public String saveLeave() {
		
		Leave leave = new Leave() ;
		BeanUtils.copyProperties(this.getModel(), leave) ;
		leave.setMonth(DateFormat.toStringMonth(new Date()));
		leave.setUser(HRUtils.fromSession());
		leave.setAgree(0) ;
		this.leaveService.saveLeave(leave);
		return action2action ;
	}
	
	/***********增加请假考勤UI页面*******************/
	public String addUI(){
		return addUI ;
	}
	
	/***********所有的请假考勤列表*******************/
	public String getAllLeaves(){
		
		// 1，构建查询条件
		// FROM Form f WHERE f.applicant=? ORDER BY f.applyTime DESC
		HqlHelper hqlHelper = new HqlHelper(Leave.class, "l")
		.addOrderByProperty("l.startDate", false);//按申请时间降序
		          
		// 2，查询分页信息
		PageBean pageBean = this.leaveService.getPageBean(pageNum, hqlHelper);
		ActionContext.getContext().getValueStack().push(pageBean);

		Collection<Leave> leaveList = leaveService.getAllFromMonth();
		int  times = leaveService.getAllByYear().size() ;
		ActionContext.getContext().put("leaveList", leaveList);
		ActionContext.getContext().put("times", times);
		return listAction ;
		
	}
	
	/***********当前的请假考勤列表*******************/
	public String getAllNowLeaves(){
			
			Collection<Leave> leaveList = leaveService.getAllFromNowMonth();
			int  times = leaveService.getAllByYear().size() ;
			ActionContext.getContext().put("leaveList", leaveList);
			ActionContext.getContext().put("times", times);
			return listAction ;
			
		}
	
	public String getAllLeaves_audit() {//查看审核所有

		Collection<Leave> leaveList = leaveService.getAllLeaves() ;
		ActionContext.getContext().put("leaveList", leaveList);
		return "updateList";

	}

	public String auditLeavesagree() {  //审核加班
		Leave leave = this.leaveService.findById(this.getModel().getId()) ;
		leave.setAgree(1); //情况属实，同意。
		this.leaveService.update(leave);
		return "listAll";
	}
	public String auditLeavesnotagree() {  //审核加班
		Leave leave = this.leaveService.findById(this.getModel().getId()) ;
		leave.setAgree(2); //情况属实，不同意。
		this.leaveService.update(leave);
		return "listAll";
	}
}
