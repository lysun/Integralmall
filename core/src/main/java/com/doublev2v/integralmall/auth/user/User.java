package com.doublev2v.integralmall.auth.user;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.doublev2v.foundation.core.entity.UUIDBaseModel;
import com.doublev2v.integralmall.auth.role.Role;
@Entity
public class User extends UUIDBaseModel{

	private String username;
	private String password;
	private Set<Role> roles;
	
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
	
	@ManyToMany
	@JoinTable(name="user_role")
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
