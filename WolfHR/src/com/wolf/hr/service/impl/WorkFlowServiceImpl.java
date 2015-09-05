package com.wolf.hr.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.task.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.wolf.hr.dao.FormDao;
import com.wolf.hr.dao.FormTemplateDao;
import com.wolf.hr.dao.WorkFlowDao;
import com.wolf.hr.domain.Approve;
import com.wolf.hr.domain.Form;
import com.wolf.hr.domain.FormTemplate;
import com.wolf.hr.domain.PageBean;
import com.wolf.hr.domain.TaskView;
import com.wolf.hr.domain.User;
import com.wolf.hr.service.WorkFlowService;
import com.wolf.hr.utils.Configuration;
import com.wolf.hr.utils.HRUtils;
import com.wolf.hr.utils.HqlHelper;
import com.wolf.hr.utils.UploadUtils;


@Service("workFlowService")
public class WorkFlowServiceImpl implements WorkFlowService{
	@Resource(name="workFlowDao")
	private WorkFlowDao workFlowDao;
	
	@Resource(name="formTemplateDao")
	private FormTemplateDao formTemplateDao;
	
	@Resource(name="formDao")
	private FormDao formDao;
	
	@Resource(name="processEngine")
	private ProcessEngine processEngine;
	
	@Resource
	private SessionFactory sessionFactory;

	//格式化时间数据
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Transactional(readOnly=false)
	public void submit(Long ftid,File resource) {
		/**
		 *  *  上传表单
         *     往form表中插入一行数据
                      applicatetime  当前时间
                      applicator   就是登入系统的人
                      state        审批中
                      url          上传表单以后可以生成该值
                      ftid         表单模板ID(在页面上应该用隐藏域)
         *     jbpm
             *  启动流程实例
                	根据pdkey启动流程实例，因为页面上传递到后台的参数只有pdkey
                	把form作为流程变量，保存到流程实例中
             *  完成请假申请的任务
                completeTask(String taskId);
		 */
		
		//文件的上传
		String url = UploadUtils.saveUploadFile(resource);
		/********************************************************************************************/
				/**
				 * 保存form
				 */
			//从session中提取user
			User user = HRUtils.fromSession();
			//往form表中插入一行数据
			Form form = new Form();
			form.setApplicatetime(new Date());
			form.setApplicator(user.getUsername());
			form.setState("申请中");
			
			//把formTempalte提取出来
			FormTemplate formTemplate = (FormTemplate)this.formTemplateDao.getEntryById(ftid);
			//建立form与formTemplate之间的关系
			form.setFormTemplate(formTemplate);
			
			String title = formTemplate.getName()+"_"+user.getUsername()+"_"+sdf.format(new Date());
			form.setTitle(title);
			form.setUrl(url);
			this.workFlowDao.saveEntry(form);
		/********************************************************************************************/
			/**
			 * jbpm的事情
			 */
			//启动流程实例,设置流程变量
			Map<String, Form> variables = new HashMap<String, Form>();
			variables.put("form", form);
			ProcessInstance pi = this.processEngine.getExecutionService()
			.startProcessInstanceByKey(formTemplate.getProcessKey(), variables);
			/**
			 * 根据当前正在执行的实例获取正在执行的任务
			 */
			Task task = this.processEngine.getTaskService()
			.createTaskQuery()
			.executionId(pi.getId())
			.uniqueResult();
			//完成请假申请的任务
			this.processEngine.getTaskService()
			.completeTask(task.getId());
		/********************************************************************************************/
	}

	public Collection<TaskView> getAllFormByAssignee() {
		// TODO Auto-generated method stub
		/**
		 * 1、根据登录人查询当前执行的所有的任务
		 * 2、遍历所有的任务，得到executionId
		 * 3、通过executionId和"form"的值把流程变量form提取出来
		 * 4、form和task共同组成taskView
		 */
		User user = HRUtils.fromSession();
		List<Task> taskList = this.processEngine.getTaskService()
		.createTaskQuery()
		.assignee(user.getUsername())
		.list();
		List<TaskView> taskViewList = new ArrayList<TaskView>();
		for(Task task:taskList){
			TaskView taskView = new TaskView();
			Form form = (Form)this.processEngine.getExecutionService().getVariable(task.getExecutionId(), "form");
			taskView.setForm(form);
			taskView.setTask(task);
			taskViewList.add(taskView);
		}
		return taskViewList;
	}

	@Transactional(readOnly=false)
	public void approve(String taskId,Approve approve,String outcome) {
		// TODO Auto-generated method stub
		/**
		 * 1、插入一行数据到approve中
		 * 2、如果页面点击的是不同意
		 *      则流程实例直接结束
		 *      把相应的form表中的状态变成"未通过"
		 *   如果页面点击的是同意
		 *      *  完成任务
		 *      *  判断该流程实例是否结束
		 *          如果结束，把相应的form表的状态变成"已完成"
		 */
		Task task = this.processEngine.getTaskService()
		.getTask(taskId);
		if("不同意".equals(approve.getIsapprove())){
			this.processEngine.getExecutionService()
			.endProcessInstance(task.getExecutionId(), "ended");
			approve.getForm().setState("未通过");
		}else{
			//完成任务
			if (outcome == null) {
			   processEngine.getTaskService().completeTask(taskId);
			}else {
				processEngine.getTaskService().completeTask(taskId, outcome);
			}
			//得到流程实例
			
			ProcessInstance pi = this.processEngine.getExecutionService()
		
			.createProcessInstanceQuery()
			.processInstanceId(task.getExecutionId())
			.uniqueResult();
			if(pi==null){//该流程实例已经结束了
				approve.getForm().setState("已通过");
			}
		}
		
		this.workFlowDao.saveEntry(approve);//保存审批信息
	}

	public Form getFormById(Long fid) {
		// TODO Auto-generated method stub
		return (Form)this.workFlowDao.getEntryById(fid);
	}
	public Set<String> getOutcomesByTaskId(String taskId) {
		return processEngine.getTaskService().getOutcomes(taskId);
	}
	
	public PageBean getPageBean(int pageNum, HqlHelper hqlHelper) {
		

		List<Object> parameters = hqlHelper.getParameters();
		int pageSize = Configuration.getPageSize();

		// 查询总记录数
		Query countQuery = getSession().createQuery(hqlHelper.getQueryCountHql()); // 生成查询对象
		for (int i = 0; i < parameters.size(); i++) { // 设置参数
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

	public InputStream download(Long fid) throws Exception {
		Form formte = (Form)this.formDao.getEntryById(fid);
		String fileName = URLEncoder.encode(formte.getTitle(), "utf-8");
		ActionContext.getContext().put("fileName",fileName);
		return new FileInputStream(new File(formte.getUrl()));
	}

}
