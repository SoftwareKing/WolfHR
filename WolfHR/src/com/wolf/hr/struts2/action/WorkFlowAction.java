package com.wolf.hr.struts2.action;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.wolf.hr.domain.Approve;
import com.wolf.hr.domain.Form;
import com.wolf.hr.domain.FormTemplate;
import com.wolf.hr.domain.PageBean;
import com.wolf.hr.domain.TaskView;
import com.wolf.hr.domain.User;
import com.wolf.hr.service.FormTemplateService;
import com.wolf.hr.service.WorkFlowService;
import com.wolf.hr.struts2.action.base.BaseAction;
import com.wolf.hr.utils.HRUtils;
import com.wolf.hr.utils.HqlHelper;


import com.wolf.hr.struts2.action.base.BaseAction;;
@Controller("workFlowAction")
@Scope("prototype")
public class WorkFlowAction extends BaseAction<Form>{
	@Resource(name="formTemplateService")
	private FormTemplateService formTemplateService;
	
	@Resource(name="workFlowService")
	private WorkFlowService workFlowService;
	
   private InputStream inputStream;
	
	public InputStream getInputStream() {
		return inputStream;
	}
	
	
	private Long ftid;
	
	private Long fid;
	
	private String taskId;
	
	private String outcome;
	
	private String state;
	
	private Long formTemplateId;
	private String status;
	
	
	public Long getFormTemplateId() {
		return formTemplateId;
	}

	public void setFormTemplateId(Long formTemplateId) {
		this.formTemplateId = formTemplateId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getFid() {
		return fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	private String comment;
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getIsapprove() {
		return isapprove;
	}

	public void setIsapprove(String isapprove) {
		this.isapprove = isapprove;
	}

	private String isapprove;
	
	public Long getFtid() {
		return ftid;
	}

	public void setFtid(Long ftid) {
		this.ftid = ftid;
	}

	public File getResource() {
		return resource;
	}

	public void setResource(File resource) {
		this.resource = resource;
	}

	private File resource;
	
	/** 起草申请（表单模板列表） */
	public String getAllFormTemplate(){
		Collection<FormTemplate> ftList = this.formTemplateService.getAllFormTemplate();
		ActionContext.getContext().put("ftList", ftList);
		return "workFlow_formTemplateList";
	}
	/** 提交申请页面 */
	public String submitUI(){
		return "submitUI";
	}
	
	/** 提交申请 */
	public String submit(){
		this.workFlowService.submit(ftid, resource);
		return "tomySubmittedList";
	
	}
	/** 我的申请查询 */
	public String mySubmittedList()
	{
		User user = HRUtils.fromSession();
		// 1，构建查询条件
		// FROM Form f WHERE f.applicant=? ORDER BY f.applyTime DESC
		HqlHelper hqlHelper = new HqlHelper(Form.class, "f")//
		.addWhereCondition("f.applicator=?", user.getUsername())//
		.addWhereCondition(formTemplateId != null, "f.formTemplate.ftid=?", formTemplateId)//
		.addWhereCondition(StringUtils.isNotBlank(status), "f.state=?",status)//
		
		.addOrderByProperty("f.applicatetime", false);//按申请时间降序
		          
		// 2，查询分页信息
		PageBean pageBean = this.workFlowService.getPageBean(pageNum, hqlHelper);
		ActionContext.getContext().getValueStack().push(pageBean);

		// 3，准备数据：formTemplateList
		List<FormTemplate> formTemplateList = (List<FormTemplate>) this.formTemplateService.getAllFormTemplate();
		ActionContext.getContext().put("formTemplateList", formTemplateList);

		
		return "submitlist";
		
	}
	
	/** 待我审批（我的任务列表） */
	public String myTaskList(){
		Collection<TaskView> taskViewList = this.workFlowService.getAllFormByAssignee();
		ActionContext.getContext().put("taskViewList", taskViewList);
		return "myTaskList";
	}
	
	/** 审批处理页面 */
	public String approveUI(){
		Set<String> outcomes = workFlowService.getOutcomesByTaskId(taskId);
		ActionContext.getContext().put("outcomes", outcomes);
		return "approveUI";
	}
	
	/** 审批处理 */
	public String approve(){
		//生成一个Approve对象，表示本次的审批信息
		Approve approve = new Approve();
		
		approve.setComment(this.comment);//本次的意见，本次是否同意
		
		approve.setIsapprove(this.isapprove);
		
		Form form = this.workFlowService.getFormById(this.getModel().getFid());
		
		User user = HRUtils.fromSession();
		
		approve.setApprovename(user.getUsername());//设置审批人
		approve.setApprovetime(new Date());//审批时间
		approve.setForm(form);//设置表单
		approve.setApprovename(user.getUsername());
		
		// 对表单进行审批处理（保存审批信息、完成任务、维护表单状态）
		this.workFlowService.approve(taskId,approve,outcome);
		
		return "tomyTaskList";
	}
	
	/** 查看流转记录 ，然后按时间排序*/
	public String approvedHistory() {
		
		Form form=this.workFlowService.getFormById(this.getModel().getFid());
		ActionContext.getContext().put("Approves",form.getApproves());
		return "approvedHistory";
	}
	
	//表单模板管理
	public String download() throws Exception{
		this.inputStream = this.workFlowService.download(this.getModel().getFid());
		return SUCCESS;
	}
	
	
}
