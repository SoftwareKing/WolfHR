package com.wolf.hr.dao;

import java.util.Collection;

import com.wolf.hr.dao.base.BaseDao;
import com.wolf.hr.domain.Message;


public interface MessageDao<T> extends BaseDao<T>{

	public Collection<Message> getReceiveMessage();  //收件箱
	public Collection<Message> getSendMessage(); //发件箱
	public Collection<Message> getDraftMessge(); //草稿箱
	
}
