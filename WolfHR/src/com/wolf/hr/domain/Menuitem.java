package com.wolf.hr.domain;

import java.io.Serializable;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

public class Menuitem implements Serializable{
	private Long mid;
	private Long pid;//父节点ID
	private String name;//树上的节点的名称
	private Boolean isParent;//是否为文件夹节点
	private String icon;//图标图片的路径
	
	private Boolean checked;
	
	private String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	private String target;
	
	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}


	public Long getMid() {
		return mid;
	}

	public void setMid(Long mid) {
		this.mid = mid;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
   /*
	private Set<UserGroup> usergroups;
	@JSON(serialize=false)
	public Set<UserGroup> getUsergroups() {
		return usergroups;
	}

	public void setUsergroups(Set<UserGroup> usergroups) {
		this.usergroups = usergroups;
	}
	*/
	private Set<User> users;
	
	@JSON(serialize=false)
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
