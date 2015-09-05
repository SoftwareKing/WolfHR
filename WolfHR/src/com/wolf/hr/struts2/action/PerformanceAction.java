package com.wolf.hr.struts2.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.wolf.hr.domain.PageBean;
import com.wolf.hr.domain.Performance;
import com.wolf.hr.domain.User;
import com.wolf.hr.service.PerformanceService;
import com.wolf.hr.struts2.action.base.BaseAction;
import com.wolf.hr.utils.HqlHelper;




@Controller("performanceAction")
@Scope("prototype")
public class PerformanceAction extends BaseAction<Performance>{
	
	@Resource(name="performanceService")
	private PerformanceService performanceService;
	
	private File resource;
	
	
	
   public File getResource() {
		return resource;
	}

	public void setResource(File resource) {
		this.resource = resource;
	}

	private String jobnumbers;
	

	public String getJobnumbers() {
		return jobnumbers;
	}

	public void setJobnumbers(String jobnumbers) {
		this.jobnumbers = jobnumbers;
	}

	public String getAllPerformance(){
		HqlHelper hqlHelper = new HqlHelper(Performance.class, "pf");
		
		// 2，查询分页信息
		PageBean pageBean = this.performanceService.getPageBean(pageNum, hqlHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		
	   Collection<Performance> performanceList = this.performanceService.getAllPerformance();
		
		//把一个对象存放到map栈中
		ActionContext.getContext().put("performanceList",performanceList);
		
		return listAction;
	}
	
	public String QueryPerformancebyJobnumber(){
         // 1，构建查询条件
		
		HqlHelper hqlHelper = new HqlHelper(Performance.class, "pf");
		 
		// 2，查询分页信息
		PageBean pageBean = this.performanceService.getPageBean(pageNum, hqlHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		Collection<Performance> performanceList = this.performanceService.getPerformanceByJobnumber(jobnumbers);
		
		//把一个对象存放到map栈中
		ActionContext.getContext().put("performanceList",performanceList);
		return listAction;
	}
	
	public String deletePerformance(){
		
		this.performanceService.deletePerformanceByID(this.getModel().getPfid());
		
		return action2action;
	}
	
	public String addUI(){
		return addUI;
	}
	
	public String add(){
		
		Performance performance = new Performance();
		
		BeanUtils.copyProperties(this.getModel(), performance);
		
		this.performanceService.savePerformance(performance);
		return action2action;
	}
	/**
	 * 一般情况下，如果数据进行回显，则把数据放入到对象栈中，页面上可以根据name属性的值进行回显
	 * 如果把数据放入到了map栈，则页面根据value的值进行回显，而且value="%{ognl表达式}"
	 * @return
	 */
	public String updateUI(){
		Performance performance = this.performanceService.getPerformanceById(this.getModel().getPfid());
		ActionContext.getContext().getValueStack().getRoot().add(0,performance);
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
		Performance performance = this.performanceService.getPerformanceById(this.getModel().getPfid());
		BeanUtils.copyProperties(this.getModel(),performance);
		this.performanceService.updatePerformance(performance);
        return action2action;
	}
	
	public String importexcelUI(){
		
		
		return "importUI";
	}
    public String importdata(){
	  
	   
	    Performance performance=new Performance();
	   
		this.performanceService.savePerforUserWithExcel(performance,resource);
		
		
		return "action2action";
	}
    public String personalpf()
    {
    	User user=(User)ServletActionContext.getRequest().getSession().getAttribute("user");
    
    	
    	Collection<Performance> performancelist = this.performanceService.getPerformanceByJobnumber(user.getJobnumber());
    	
    	ActionContext.getContext().put("performancelist",performancelist);
    	return "person";
    	
    }
   
    
  
}
