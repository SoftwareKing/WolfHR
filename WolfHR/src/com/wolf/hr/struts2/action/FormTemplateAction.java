package com.wolf.hr.struts2.action;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;


import javax.annotation.Resource;

import org.jbpm.api.ProcessDefinition;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.opensymphony.xwork2.ActionContext;

import com.wolf.hr.domain.FormTemplate;

import com.wolf.hr.service.FormTemplateService;
import com.wolf.hr.service.PDManager;
import com.wolf.hr.struts2.action.base.BaseAction;

@Controller("formTemplateAction")
@Scope("prototype")
public class FormTemplateAction extends BaseAction<FormTemplate>{
	@Resource(name="formTemplateService")
	private FormTemplateService formTemplateService;
	
	@Resource(name="pdManager")
	private PDManager pdManager;
	
	private File resource;
	
	private InputStream inputStream;
	
	public InputStream getInputStream() {
		return inputStream;
	}

	public File getResource() {
		return resource;
	}

	public void setResource(File resource) {
		this.resource = resource;
	}

	public String getAllFormTemplate(){
		Collection<FormTemplate> ftList = this.formTemplateService.getAllFormTemplate();
		ActionContext.getContext().put("ftList", ftList);
		return listAction;
	}
	
	public String addUI(){
		Collection<ProcessDefinition> pdList = this.pdManager.getLasterVersions();
		ActionContext.getContext().put("pdList", pdList);
		return addUI;
	}
	
	public String add(){
		FormTemplate formTemplate = new FormTemplate();
		BeanUtils.copyProperties(this.getModel(), formTemplate);
		this.formTemplateService.saveFormTemplate(formTemplate, resource);
		return action2action;
	}
	
	public String delete()
	{
		
	   
		FormTemplate formTemplate=this.formTemplateService.getFormTemplateByID(this.getModel().getFtid());
		//①删除数据库中的记录
		this.formTemplateService.deleteFormTemplate(this.getModel().getFtid());
		
		//②删除在服务器上的文件
		File file= new File(formTemplate.getUrl());
		if(file.exists())
		{
			file.delete();
			
		}
		
		return action2action;
	}
	
	//表单模板更新页面
	public String updateUI()
	{
		
		
		//准备数据
		Collection<ProcessDefinition> pdList = this.pdManager.getLasterVersions();
		ActionContext.getContext().put("pdList", pdList);
		
		//准备回显的数据
		FormTemplate formTemplate=this.formTemplateService.getFormTemplateByID(this.getModel().getFtid());
		ActionContext.getContext().put("formTemplate", formTemplate);
		return updateUI;
		
	}
	public String update()
	{
		
	    FormTemplate formTemplate=this.formTemplateService.getFormTemplateByID(this.getModel().getFtid());
		
		
		//设置要修改的属性，有些属性可能没有更改
		formTemplate.setName(this.getModel().getName());
		formTemplate.setProcessKey(this.getModel().getProcessKey());
		
		
		
		if(resource != null)//如果文件上传了
		{
			File file= new File(formTemplate.getUrl());
			if(file.exists())
			  {
				file.delete();
				
			 }
				
			//使用新文件，更新到数据库中
			this.formTemplateService.updateFormTemplate(formTemplate,resource);
			
		}
		
		
		return action2action;
		
	}
	//表单模板管理
	public String download() throws Exception{
		this.inputStream = this.formTemplateService.download(this.getModel().getFtid());
		return SUCCESS;
	}
}
