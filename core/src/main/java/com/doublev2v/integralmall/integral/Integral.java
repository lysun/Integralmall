package com.doublev2v.integralmall.integral;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.doublev2v.foundation.core.entity.UUIDBaseModel;
import com.doublev2v.integralmall.user.User;
@Entity
public class Integral extends UUIDBaseModel{

	private User user;
	private long totalcount;//总积分
	@OneToOne
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public long getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(long totalcount) {
		this.totalcount = totalcount;
	}
	
	
	
}
