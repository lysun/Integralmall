package com.doublev2v.integralmall.config;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.doublev2v.foundation.core.entity.BaseModel;

@Entity
public class Config extends BaseModel {

	private String id;	
	private String value;
	
	public Config() {}
	
	public Config(String id, String value) {
		this.id=id;
		this.value=value;
	}
	
	@Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
