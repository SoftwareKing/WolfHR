package com.wolf.hr.dao.impl;

import org.springframework.stereotype.Repository;

import com.wolf.hr.dao.FormDao;
import com.wolf.hr.dao.base.impl.BaseDaoImpl;
import com.wolf.hr.domain.Form;



@Repository("formDao")
public class FormDaoImpl extends BaseDaoImpl<Form> implements FormDao<Form>{

}
