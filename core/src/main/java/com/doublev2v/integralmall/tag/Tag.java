package com.doublev2v.integralmall.tag;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.doublev2v.foundation.core.entity.UUIDBaseModel;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING)
public class Tag extends UUIDBaseModel{
	
	private String name;
	private String type;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="type",insertable=false,updatable=false)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
