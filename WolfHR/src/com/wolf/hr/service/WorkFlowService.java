package com.wolf.hr.service;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.Set;

import com.wolf.hr.domain.Approve;
import com.wolf.hr.domain.Form;
import com.wolf.hr.domain.PageBean;
import com.wolf.hr.domain.TaskView;
import com.wolf.hr.utils.HqlHelper;


public interface WorkFlowService {
	public void submit(Long ftid,File resource);
	
	public Collection<TaskView> getAllFormByAssignee();
	
	public void approve(String taskId,Approve approve,String outcome);
	
	public Form getFormById(Long fid);
	
	/**
	 * 获取某任务节点中所有流出连线的名称
	 * 
	 * @param taskId
	 * @return
	 */
	Set<String> getOutcomesByTaskId(String taskId);
	PageBean getPageBean(int pageNum, HqlHelper hqlHelper);
	public InputStream download(Long fid) throws Exception;
}
