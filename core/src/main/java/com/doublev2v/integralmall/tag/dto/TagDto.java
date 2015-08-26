package com.doublev2v.integralmall.tag.dto;

import com.doublev2v.foundation.core.entity.Identified;

public class TagDto implements Identified<String>{

	private String id;
	private String name;
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
	
}
