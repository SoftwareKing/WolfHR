package com.wolf.hr.service.impl;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wolf.hr.dao.PerformanceDao;
import com.wolf.hr.domain.PageBean;
import com.wolf.hr.domain.Performance;
import com.wolf.hr.service.PerformanceService;
import com.wolf.hr.utils.Configuration;
import com.wolf.hr.utils.GenerateSqlFromExcel;
import com.wolf.hr.utils.HqlHelper;




@Service("performanceService")
public class PerformanceServiceImpl implements PerformanceService {
	
	@Resource(name="performanceDao")
	private PerformanceDao performancedao;

	@Resource
	private SessionFactory sessionFactory;
	
    private File file;
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
     @Transactional(readOnly=false)
	public void deletePerformanceByID(Serializable id) {
		// TODO Auto-generated method stub
		this.performancedao.deleteEntry(id);
		

	}

	public Collection<Performance> getAllPerformance() {
		// TODO Auto-generated method stub
		return this.performancedao.getAllEntry();
	}

	public Performance getPerformanceById(Serializable id) {
		// TODO Auto-generated method stub
		return (Performance) this.performancedao.getEntryById(id);
	}
	@Transactional(readOnly=false)
	public void savePerformance(Performance Performance) {
		// TODO Auto-generated method stub
		    this.performancedao.saveEntry(Performance);
           
	}
	@Transactional(readOnly=false)
	public void updatePerformance(Performance performance) {
		// TODO Auto-generated method stub
           this.performancedao.updateEntry(performance);
	}
     public PageBean getPageBean(int pageNum, HqlHelper hqlHelper) {
		

		List<Object> parameters = hqlHelper.getParameters();
		int pageSize = Configuration.getPageSize();

		// 查询总记录数
		Query countQuery = getSession().createQuery(hqlHelper.getQueryCountHql()); // 生成查询对象
		for (int i = 1; i < parameters.size(); i++) { // 设置参数
			countQuery.setParameter(i, parameters.get(i));
		}
		int count = ((Long) countQuery.uniqueResult()).intValue();

		// 查询一段数据列表
		Query listQuery = getSession().createQuery(hqlHelper.getQueryListHql()); // 生成查询对象
		for (int i = 0; i < parameters.size(); i++) { // 设置参数
			listQuery.setParameter(i, parameters.get(i));
		}
		listQuery.setFirstResult((pageNum - 1) * pageSize);
		listQuery.setMaxResults(pageSize);
		List list = listQuery.list(); // 查询

		return new PageBean(pageNum, pageSize, count, list);
	}
	/**
	 * 获取当前可用的Session
	 * 
	 * @return
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void savePerforUserWithExcel(Performance performance,File file) {
		try {
			
			
			GenerateSqlFromExcel generater = new GenerateSqlFromExcel();
			ArrayList<String[]> arrayList = generater.generateStationBugSql(file);
			 for(int i=0;arrayList!=null && i<arrayList.size();i++){
				String[] data = arrayList.get(i);
				//实例化PO对象，用PO对象进行保存
				Performance per=new Performance();
				per.setJobnumber(data[0].toString());
				per.setUsername(data[1].toString());
				per.setDepartment(data[2].toString());
				per.setPost(data[3].toString());
				per.setTaskdescription(data[4].toString());
				per.setBaifenbi(data[5].toString());
				per.setStarttime(data[6].toString());
				per.setPlanendtime(data[7].toString());
				per.setCompletetime(data[8].toString());
				per.setDescription(data[9].toString());
				
				this.performancedao.saveEntry(per);
			}
			
			
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public Collection<Performance> getPerformanceByJobnumber(String jobnumber) {
		// TODO Auto-generated method stub
	  return this.performancedao.getPerformanceByJobnumber(jobnumber);
	}

}


