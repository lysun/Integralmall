package com.doublev2v.integralmall.questionnaire;

import javax.persistence.Entity;

import com.doublev2v.foundation.core.entity.UUIDBaseModel;

@Entity
public class OrderedItem extends UUIDBaseModel {

	private int ordernum;
	private String value;
	public int getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
