package com.wolf.hr.struts2.action;

import java.util.Collection;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.wolf.hr.domain.AddWorking;
import com.wolf.hr.service.AddWorkingService;
import com.wolf.hr.struts2.action.base.BaseAction;
import com.wolf.hr.utils.DateFormat;
import com.wolf.hr.utils.HRUtils;

/********* 加班考勤 *************/
@Controller("addWorkingAction")
@Scope("prototype")
public class AddWorkingAction extends BaseAction<AddWorking> {

	@Resource(name = "addWorkingService")
	private AddWorkingService addWorkingService;

	public String saveAddWorking() {
		AddWorking addWorking = new AddWorking();
		BeanUtils.copyProperties(this.getModel(), addWorking);
		addWorking.setMonth(DateFormat.toStringMonth(new Date()));
		addWorking.setUser(HRUtils.fromSession());
		addWorking.setAgree(0);
		this.addWorkingService.saveAddWorking(addWorking);
		return action2action;
	}

	public String addUI() {
		return addUI;
	}

	public String getAllAddWorking() {

		Collection<AddWorking> addWorkingList = addWorkingService
				.getAllFromMonth();

		ActionContext.getContext().put("addWorkingList", addWorkingList);
		return listAction;

	}

	public String getAllNowAddWorking() {

		Collection<AddWorking> addWorkingList = addWorkingService
				.getAllFromNowMonth();
		ActionContext.getContext().put("addWorkingList", addWorkingList);
		return listAction;

	}

	public String getAllAddWorkingByUser() {

		Collection<AddWorking> addWorkingList = addWorkingService
				.getAllWorkByUser();
		ActionContext.getContext().put("addWorkingList", addWorkingList);
		return listAction;

	}

	public String getAllAddWorking_audit() {// 查看审核所有

		Collection<AddWorking> addWorkingList = addWorkingService.getAllWork();

		ActionContext.getContext().put("addWorkingList", addWorkingList);
		return "updateList";

	}

	public String audit_Working_agree() { // 审核加班
		AddWorking addWorking = this.addWorkingService.findById(this.getModel()
				.getId());
		addWorking.setAgree(1); // 情况属实，同意。
		this.addWorkingService.update(addWorking);
		return "listAll";
	}

	public String audit_Working_notagree() { // 审核加班
		AddWorking addWorking = this.addWorkingService.findById(this.getModel()
				.getId());
		addWorking.setAgree(2); // 情况属实，不同意。
		this.addWorkingService.update(addWorking);
		return "listAll";
	}
}
