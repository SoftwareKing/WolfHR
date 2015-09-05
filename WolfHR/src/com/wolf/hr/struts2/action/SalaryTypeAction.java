package com.wolf.hr.struts2.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.wolf.hr.domain.Department;
import com.wolf.hr.domain.SalaryType;
import com.wolf.hr.service.SalaryTypeService;
import com.wolf.hr.struts2.action.base.BaseAction;
import com.wolf.hr.utils.DeleteMode;

@Controller("salaryTypeAction")
@Scope("prototype")
public class SalaryTypeAction extends BaseAction<SalaryType> {

	@Resource(name="salaryTypeService")
	private SalaryTypeService salaryTypeService ;
	
	/*************显示所有的薪资类型***************/
	public String getAllSalaryType()
	{
		
		Collection<SalaryType> salaryTypelist= this.salaryTypeService.getAllSalaryTypes();
	    ActionContext.getContext().put("salaryTypelist", salaryTypelist);
		
		return listAction;
	}
	
	/*************添加薪资类型UI***************/
	public String addUI(){
		return addUI ;
	}
	/*************添加薪资类型***************/
	public String addSalaryType(){ //保存
		SalaryType salaryType = new SalaryType() ;
		BeanUtils.copyProperties(this.getModel(), salaryType) ;
		salaryTypeService.saveSalaryType(salaryType) ;
		
		return action2action ;
	}
	
	/*************删除薪资类型***************/
	public String deleteSalaryType(){
		this.salaryTypeService.deleteSalaryTypeById(this.getModel().getId());
		return action2action;
	}
	/**
	 * 一般情况下，如果数据进行回显，则把数据放入到对象栈中，页面上可以根据name属性的值进行回显
	 * 如果把数据放入到了map栈，则页面根据value的值进行回显，而且value="%{ognl表达式}"
	 * @return
	 */
	/*************更新薪资类型UI***************/
	public String updateUI(){
		
		SalaryType salarytype=this.salaryTypeService.getSalaryTypeById(this.getModel().getId());
		ActionContext.getContext().getValueStack().getRoot().add(0,salarytype);
		return updateUI;
	}
	
	/**
	 * 修改
	 * @return
	 */
	/*************更新薪资类型***************/
	public String update(){
		/**
		 * 1、先根据id把该数据从数据库中提取出来(或者从session的缓存中)
		 * 2、把修改以后的数据赋值到该对象中
		 * 3、针对该对象进行update操作
		 */
		SalaryType salarytype =this.salaryTypeService.getSalaryTypeById(this.getModel().getId());
		BeanUtils.copyProperties(this.getModel(),salarytype);
		this.salaryTypeService.updateSalaryType(salarytype);
		return action2action;
	}
}
