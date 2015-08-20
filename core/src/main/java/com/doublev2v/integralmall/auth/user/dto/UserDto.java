package com.doublev2v.integralmall.auth.user.dto;

import com.doublev2v.foundation.core.entity.Identified;
import com.doublev2v.integralmall.auth.role.Role;

public class UserDto implements Identified<String>{

	private String id;
	private String username;
	private String password;
	private Role userRole;
	private String roleId;
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
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public Role getUserRole() {
		return userRole;
	}
	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}
	
}
