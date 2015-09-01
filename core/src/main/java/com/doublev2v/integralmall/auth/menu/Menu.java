package com.doublev2v.integralmall.auth.menu;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.doublev2v.foundation.core.entity.UUIDBaseModel;
import com.doublev2v.integralmall.auth.role.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Menu extends UUIDBaseModel{

	private String name;
	private String url;
	private String tab;//用于获取菜单的标记
	private Menu parent;
	@JsonIgnore
	private Set<Menu> childs;
	@JsonIgnore
	private Set<Role> roles;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@ManyToOne
	public Menu getParent() {
		return parent;
	}
	public void setParent(Menu parent) {
		this.parent = parent;
	}
	@OneToMany(mappedBy="parent",fetch=FetchType.EAGER)
	@OrderBy("tab")
	public Set<Menu> getChilds() {
		return childs;
	}
	public void setChilds(Set<Menu> childs) {
		this.childs = childs;
	}
	@ManyToMany(mappedBy="menus")
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public String getTab() {
		return tab;
	}
	public void setTab(String tab) {
		this.tab = tab;
	}
	
	
}
