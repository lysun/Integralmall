package com.doublev2v.integralmall.auth.role;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.doublev2v.foundation.core.entity.UUIDBaseModel;
import com.doublev2v.integralmall.auth.permission.Permission;
import com.doublev2v.integralmall.auth.user.User;


@Entity
public class Role extends UUIDBaseModel{

	private String name;
	private String code;
	private String description;
	private Set<Permission> perms;
	private Set<User> users;
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
	@ManyToMany
	@JoinTable(name="role_perm")
	public Set<Permission> getPerms() {
		return perms;
	}
	public void setPerms(Set<Permission> perms) {
		this.perms = perms;
	}
	@ManyToMany(mappedBy="roles")
	public Set<User> getUsers() {
		return users;
	}
	
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return code;
	}
}
