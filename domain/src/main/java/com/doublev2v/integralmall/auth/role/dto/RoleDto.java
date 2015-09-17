package com.doublev2v.integralmall.auth.role.dto;

import java.util.Set;

import com.doublev2v.foundation.core.entity.Identified;
import com.doublev2v.integralmall.auth.permission.Permission;

public class RoleDto implements Identified<String>{

	private String id;
	private String name;
	private String code;
	private String description;
	private Set<Permission> perms;//简单的对象交给Dozer转换
	private Set<String> permIds;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<Permission> getPerms() {
		return perms;
	}
	public void setPerms(Set<Permission> perms) {
		this.perms = perms;
	}
	public Set<String> getPermIds() {
		return permIds;
	}
	public void setPermIds(Set<String> permIds) {
		this.permIds = permIds;
	}
	
}
