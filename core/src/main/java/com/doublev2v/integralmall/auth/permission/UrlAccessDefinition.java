package com.doublev2v.integralmall.auth.permission;

import javax.persistence.Entity;

import com.doublev2v.foundation.core.entity.UUIDBaseModel;
@Entity(name="url_perm")
public class UrlAccessDefinition extends UUIDBaseModel{

	private String url;//对应url，比如/admin/**
	private String role;//角色code
	private String perm;//权限code
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPerm() {
		return perm;
	}
	public void setPerm(String perm) {
		this.perm = perm;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
