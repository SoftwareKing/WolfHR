package com.wolf.hr.dao.impl;

import org.springframework.stereotype.Repository;

import com.wolf.hr.dao.FormTemplateDao;
import com.wolf.hr.dao.base.impl.BaseDaoImpl;
import com.wolf.hr.domain.FormTemplate;



@Repository("formTemplateDao")
public class FormTemplateDaoImpl extends BaseDaoImpl<FormTemplate> implements FormTemplateDao<FormTemplate>{

}
