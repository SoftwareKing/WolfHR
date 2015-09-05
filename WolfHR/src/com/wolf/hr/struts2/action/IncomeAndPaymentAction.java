package com.wolf.hr.struts2.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.wolf.hr.domain.IncomeAndPayment;
import com.wolf.hr.service.IncomeAndPaymentService;
import com.wolf.hr.struts2.action.base.BaseAction;

@Controller("incomeAndPaymentAction")
public class IncomeAndPaymentAction extends BaseAction<IncomeAndPayment>{

	
	@Resource(name="incomeAndPaymentService")
	private IncomeAndPaymentService incomeAndPaymentService  ;
	
	/***********列表************/
	public String getALLIncomeAndPayment()
	{
		Collection<IncomeAndPayment> incomeandpaymentList =this.incomeAndPaymentService.getALLIncomeAndPayment();
		ActionContext.getContext().put("incomeandpaymentList", incomeandpaymentList);
		return listAction;
	}
	/***********添加UI界面************/
	public String addUI(){
		return addUI ;
	}
	/***********添加操作************/
	public String addIncomeAndPayment(){
		IncomeAndPayment incomeAndPayment = new IncomeAndPayment() ;
		BeanUtils.copyProperties(this.getModel(), incomeAndPayment) ;
		incomeAndPaymentService.saveIncomeAndPayment(incomeAndPayment) ;
		return action2action ;
	}
	
	/***********删除操作************/
    public String deleteIncomeAndPayment()
    {
    	
    	this.incomeAndPaymentService.deleteIncomeAndPaymentById(this.getModel().getId());
    	return action2action;
    }
    /***********修改UI界面************/
    public String updateUI()
    {
    	IncomeAndPayment incomeAndPayment =this.incomeAndPaymentService.getIncomeAndPaymentById(this.getModel().getId());
    	
    	ActionContext.getContext().getValueStack().getRoot().add(0, incomeAndPayment);
    	return updateUI;
    }
    /***********修改操作************/
    public String update()
    {
    	
    	IncomeAndPayment incomeAndPayment =this.incomeAndPaymentService.getIncomeAndPaymentById(this.getModel().getId());
    	BeanUtils.copyProperties(this.getModel(), incomeAndPayment);
    	this.incomeAndPaymentService.updateIncomeAndPayment(incomeAndPayment);
    	return action2action;
    }
    
    
}

