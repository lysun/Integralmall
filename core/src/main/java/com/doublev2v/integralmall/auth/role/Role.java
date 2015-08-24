package com.doublev2v.integralmall.auth.role;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

import com.doublev2v.integralmall.auth.permission.Permission;
import com.doublev2v.integralmall.auth.user.User;


@Entity
public class Role{

	private String id;
	private String name;
	private String description;
	private Set<Permission> perms;
	private Set<User> users;
	@Id
	@GenericGenerator(name="idGenerator",strategy="uuid")
	@GeneratedValue(generator="idGenerator")
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
	
	
}
