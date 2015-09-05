package com.wolf.hr.domain;

import java.io.Serializable;
import java.util.Date;

public class Approve implements Serializable{
	private Long aid;//审批信息ID
	private String approvename;//审批人
	private Date approvetime;//审批时间
	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public String getApprovename() {
		return approvename;
	}

	public void setApprovename(String approvename) {
		this.approvename = approvename;
	}

	public Date getApprovetime() {
		return approvetime;
	}

	public void setApprovetime(Date approvetime) {
		this.approvetime = approvetime;
	}

	public String getIsapprove() {
		return isapprove;
	}

	public void setIsapprove(String isapprove) {
		this.isapprove = isapprove;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	private String isapprove;//是否同意
	private String comment;//审批意见
	
	private Form form;//表单
}
