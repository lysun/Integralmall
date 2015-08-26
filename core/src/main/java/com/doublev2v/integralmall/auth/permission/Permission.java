package com.doublev2v.integralmall.auth.permission;

import javax.persistence.Entity;

import com.doublev2v.foundation.core.entity.UUIDBaseModel;

@Entity
public class Permission extends UUIDBaseModel{
	private String name;
	private String code;
	private String description;
	private PermType type;

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

	public PermType getType() {
		return type;
	}

	public void setType(PermType type) {
		this.type = type;
	}
	
	
}
