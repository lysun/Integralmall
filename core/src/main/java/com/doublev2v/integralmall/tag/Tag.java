package com.doublev2v.integralmall.tag;

import javax.persistence.Entity;

import com.doublev2v.foundation.core.entity.UUIDBaseModel;
@Entity
public class Tag extends UUIDBaseModel{
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
