package com.wolf.hr.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.wolf.hr.dao.base.BaseDao;


public class BaseDaoImpl<T> implements BaseDao<T>{
	private Class classt;
	
	@Resource
	private SessionFactory sessionFactory;
	/**
	 * 1、在父类中要执行一段代码，这个代码的执行时间为子类创建对象的时候，这段代码已经执行完了，根据这个需求，有两种方案供选择
	 *      *  利用static语句块
	 *      *  利用父类的构造函数
	 * 2、分析：
	 *      因为得到ParameterizedType需要用到this关键字，而this关键字不能出现在static语句块中
	 *    所以只能选择父类的构造器
	 */
	public BaseDaoImpl(){
		/**
		 * ParameterizedType就是泛型
		 */
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		this.classt = (Class)type.getActualTypeArguments()[0];//<T>
		System.out.println(type.getRawType());
	}
	
	@Resource(name="hibernateTemplate")
	public HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public Collection<T> getAllEntry() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from "+this.classt.getName());
	}

	public T getEntryById(Serializable id) {
		// TODO Auto-generated method stub
		return (T)this.hibernateTemplate.get(this.classt, id);
	}

	public void saveEntry(T t) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.save(t);
	}

	public void updateEntry(T t) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.update(t);
	}

	public void deleteEntry(Serializable id) {
		// TODO Auto-generated method stub
		T t = this.getEntryById(id);
		this.hibernateTemplate.delete(t);
	}

	
}
