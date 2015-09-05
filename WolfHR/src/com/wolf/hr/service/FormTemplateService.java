package com.wolf.hr.service;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Collection;

import com.wolf.hr.domain.FormTemplate;
import com.wolf.hr.domain.User;


public interface FormTemplateService {
	public Collection<FormTemplate> getAllFormTemplate();
	
	public void saveFormTemplate(FormTemplate formTemplate,File resource);
	
	public InputStream download(Long ftid) throws Exception;
	
	public void deleteFormTemplate(Long ftid);
	public void updateFormTemplate(FormTemplate formTemplate,File resource);

	
	public FormTemplate getFormTemplateByID(Serializable id);
}
