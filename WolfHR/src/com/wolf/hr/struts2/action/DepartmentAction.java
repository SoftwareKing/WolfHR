package com.wolf.hr.struts2.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import com.wolf.hr.domain.Department;
import com.wolf.hr.service.DepartmentService;
import com.wolf.hr.struts2.action.base.BaseAction;
import com.wolf.hr.utils.DeleteMode;

@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department>{
	
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	
	public String getAllDepartment(){
		System.out.println(this.getModel());
		Collection<Department> departmentList = this.departmentService.getAllDepartment();
		
		//把一个对象存放到map栈中
		ActionContext.getContext().put("departmentList", departmentList);
		Object action = ActionContext.getContext().getActionInvocation().getAction();
		action.getClass().getDeclaredFields();
		return listAction;
	}
	
	public String deleteDepartment(){
		this.departmentService.deleteDepartmentByID(this.getModel().getDid(), DeleteMode.DEL_PRE_RELEASE);
		return action2action;
	}
	
	public String addUI(){
		return addUI;
	}
	
	public String add(){
		/**
		 * 1、新建一个department
		 * 2、把模型驱动中的值赋值到department中
		 * 3、执行save方法保存
		 */
		Department department = new Department();
		/**
		 * 对象的属性的赋值的过程
		 */
		BeanUtils.copyProperties(this.getModel(), department);
		this.departmentService.saveDepartment(department);
		return action2action;
	}
	/**
	 * 一般情况下，如果数据进行回显，则把数据放入到对象栈中，页面上可以根据name属性的值进行回显
	 * 如果把数据放入到了map栈，则页面根据value的值进行回显，而且value="%{ognl表达式}"
	 * @return
	 */
	public String updateUI(){
		Department department = this.departmentService.getDepartmentById(this.getModel().getDid());
		ActionContext.getContext().getValueStack().getRoot().add(0,department);
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
		Department department = this.departmentService.getDepartmentById(this.getModel().getDid());
		BeanUtils.copyProperties(this.getModel(),department);
		this.departmentService.updateDeparment(department);
		return action2action;
	}
}
