package com.wolf.hr.dao.base;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author xujin
 * @Eamil :Software_King@qq.com
 * @Description 用泛型设计基本的Dao实现CRUD操作
 * 
 */
public interface BaseDao<T>{
	public Collection<T> getAllEntry();//查询所有的对象
	public T getEntryById(Serializable id);//按ID获对象
	public void saveEntry(T t);//保存
	public void updateEntry(T t);//更新操作
	public void deleteEntry(Serializable id);//删除操作
	
	
  
}
