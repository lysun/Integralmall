package com.doublev2v.integralmall.coupons;

import javax.persistence.Entity;

import com.doublev2v.foundation.core.entity.UUIDBaseModel;

@Entity
public class Coupons extends UUIDBaseModel {

	private String account;
	private CouponsType type;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public CouponsType getType() {
		return type;
	}
	public void setType(CouponsType type) {
		this.type = type;
	}

	public static enum CouponsType {
		代金券,
		折扣;
	}
}
