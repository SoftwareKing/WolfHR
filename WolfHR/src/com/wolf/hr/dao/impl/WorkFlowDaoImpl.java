package com.wolf.hr.dao.impl;

import org.springframework.stereotype.Repository;

import com.wolf.hr.dao.WorkFlowDao;
import com.wolf.hr.dao.base.impl.BaseDaoImpl;
import com.wolf.hr.domain.Form;


@Repository("workFlowDao")
public class WorkFlowDaoImpl extends BaseDaoImpl<Form> implements WorkFlowDao<Form>{

}
