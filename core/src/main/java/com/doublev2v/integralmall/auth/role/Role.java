package com.doublev2v.integralmall.auth.role;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.doublev2v.foundation.core.entity.UUIDBaseModel;
import com.doublev2v.integralmall.auth.menu.Menu;
import com.doublev2v.integralmall.auth.permission.Permission;
import com.doublev2v.integralmall.auth.user.User;


@Entity
public class Role extends UUIDBaseModel{

	private String name;
	private String code;
	private String description;
	private Set<Permission> perms;
	private Set<Menu> menus;
	private Set<User> users;
	private RoleType type;
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
	public RoleType getType() {
		return type;
	}
	public void setType(RoleType type) {
		this.type = type;
	}
	@ManyToMany
	@JoinTable(name="role_menu")
	public Set<Menu> getMenus() {
		return menus;
	}
	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return code;
	}
}
