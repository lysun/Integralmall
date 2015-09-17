package com.doublev2v.integralmall.entity;

import java.util.Set;

import com.doublev2v.foundation.core.entity.Identified;

public class UserDto implements Identified<String>{

	private String id;
	private String username;
	private String password;
	private Set<RoleDto> roleDtos;
	private Set<String> roleIds;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<RoleDto> getRoleDtos() {
		return roleDtos;
	}
	public void setRoleDtos(Set<RoleDto> roleDtos) {
		this.roleDtos = roleDtos;
	}
	public Set<String> getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(Set<String> roleIds) {
		this.roleIds = roleIds;
	}
	
	
}
