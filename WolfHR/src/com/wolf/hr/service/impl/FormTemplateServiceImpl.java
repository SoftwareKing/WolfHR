package com.wolf.hr.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.wolf.hr.dao.FormTemplateDao;
import com.wolf.hr.domain.FormTemplate;
import com.wolf.hr.service.FormTemplateService;
import com.wolf.hr.utils.UploadUtils;



@Service("formTemplateService")
public class FormTemplateServiceImpl implements FormTemplateService{
	@Resource(name="formTemplateDao")
	private FormTemplateDao formTemplateDao;

	public Collection<FormTemplate> getAllFormTemplate() {
		// TODO Auto-generated method stub
		return this.formTemplateDao.getAllEntry();
	}

	@Transactional(readOnly=false)
	public void saveFormTemplate(FormTemplate formTemplate, File resource) {
		// TODO Auto-generated method stub
		/**
		 * 1、文件上传
		 * 2、保存数据到formtemplate表中
		 */
		String url = UploadUtils.saveUploadFile(resource);
		formTemplate.setUrl(url);
		this.formTemplateDao.saveEntry(formTemplate);
	}

	public InputStream download(Long ftid) throws Exception{
		// TODO Auto-generated method stub
		FormTemplate formTemplate = (FormTemplate)this.formTemplateDao.getEntryById(ftid);
		String fileName = URLEncoder.encode(formTemplate.getName(), "utf-8");
		ActionContext.getContext().put("fileName",fileName);
		return new FileInputStream(new File(formTemplate.getUrl()));
	}
	@Transactional(readOnly=false)
	public void deleteFormTemplate(Long ftid) {
		// TODO Auto-generated method stub
		
		
		//①删除数据库记录
		this.formTemplateDao.deleteEntry(ftid);
		
		
	}

	@Transactional(readOnly=false)
	public void updateFormTemplate(FormTemplate formTemplate,File resource) {
		
		String url = UploadUtils.saveUploadFile(resource);
		formTemplate.setUrl(url);
		this.formTemplateDao.updateEntry(formTemplate);
	}
	
	public FormTemplate getFormTemplateByID(Serializable id) {
		// TODO Auto-generated method stub
		return (FormTemplate) this.formTemplateDao.getEntryById(id);
		
	}
}
