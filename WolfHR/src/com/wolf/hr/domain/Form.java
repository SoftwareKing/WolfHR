package com.wolf.hr.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Form implements Serializable{
	
	private Long fid;//表单ID
	private String title;//标题
	private String applicator;//申请人 注：应该是User
	private Date applicatetime;//申请时间
	private String state;//审批的当前状态
	
	private String url;//模板上传的路径
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Long getFid() {
		return fid;
	}
	public void setFid(Long fid) {
		this.fid = fid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getApplicator() {
		return applicator;
	}
	public void setApplicator(String applicator) {
		this.applicator = applicator;
	}
	public Date getApplicatetime() {
		return applicatetime;
	}
	public void setApplicatetime(Date applicatetime) {
		this.applicatetime = applicatetime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public FormTemplate getFormTemplate() {
		return formTemplate;
	}
	public void setFormTemplate(FormTemplate formTemplate) {
		this.formTemplate = formTemplate;
	}
	public Set<Approve> getApproves() {
		return approves;
	}
	public void setApproves(Set<Approve> approves) {
		this.approves = approves;
	}
    private FormTemplate formTemplate;//表单模板
	private Set<Approve> approves;//审批信息
}
