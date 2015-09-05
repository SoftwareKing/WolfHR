package com.wolf.hr.domain;

import java.io.Serializable;
import java.util.Set;

public class UserGroup implements Serializable{
	private Long ugid;
	private String ugname;
	private String description;
	
	public Long getUgid() {
		return ugid;
	}

	public void setUgid(Long ugid) {
		this.ugid = ugid;
	}

	public String getUgname() {
		return ugname;
	}

	public void setUgname(String ugname) {
		this.ugname = ugname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	private Set<User> users;
}
