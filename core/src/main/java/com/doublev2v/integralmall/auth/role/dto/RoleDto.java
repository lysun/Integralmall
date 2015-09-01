package com.doublev2v.integralmall.auth.role.dto;

import java.util.Set;

import com.doublev2v.foundation.core.entity.Identified;
import com.doublev2v.integralmall.auth.menu.Menu;
import com.doublev2v.integralmall.auth.permission.Permission;
import com.doublev2v.integralmall.auth.role.RoleType;

public class RoleDto implements Identified<String>{

	private String id;
	private String name;
	private String code;
	private String description;
	private RoleType type;
	private Set<Permission> perms;//简单的对象交给Dozer转换
	private Set<Menu> menus;//简单的对象交给Dozer转换
	private Set<String> permIds;
	private Set<String> menuIds;
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
	public RoleType getType() {
		return type;
	}
	public void setType(RoleType type) {
		this.type = type;
	}
	public Set<Menu> getMenus() {
		return menus;
	}
	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}
	public Set<String> getMenuIds() {
		return menuIds;
	}
	public void setMenuIds(Set<String> menuIds) {
		this.menuIds = menuIds;
	}
	
}
