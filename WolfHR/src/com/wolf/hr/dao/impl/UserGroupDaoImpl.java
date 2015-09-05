package com.wolf.hr.dao.impl;

import org.springframework.stereotype.Repository;

import com.wolf.hr.dao.UserGroupDao;
import com.wolf.hr.dao.base.impl.BaseDaoImpl;
import com.wolf.hr.domain.UserGroup;





@Repository("userGroupDao")
public class UserGroupDaoImpl extends BaseDaoImpl<UserGroup> implements UserGroupDao<UserGroup>{

}
