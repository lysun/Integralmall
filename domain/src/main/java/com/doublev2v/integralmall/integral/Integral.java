package com.doublev2v.integralmall.integral;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.doublev2v.foundation.core.entity.UUIDBaseModel;
import com.doublev2v.integralmall.userinfo.UserInfo;
@Entity
public class Integral extends UUIDBaseModel{

	private UserInfo user;
	private long totalcount;//总积分
	@OneToOne
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
	public long getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(long totalcount) {
		this.totalcount = totalcount;
	}
	
	
	
}
