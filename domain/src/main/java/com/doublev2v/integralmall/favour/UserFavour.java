package com.doublev2v.integralmall.favour;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.doublev2v.foundation.core.entity.UUIDBaseModel;
import com.doublev2v.integralmall.userinfo.UserInfo;
@Entity
public class UserFavour extends UUIDBaseModel{
	private UserInfo user;
	private int count;//该用户点赞次数
	private Favour favour;
	
	@ManyToOne
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@ManyToOne
	public Favour getFavour() {
		return favour;
	}
	public void setFavour(Favour favour) {
		this.favour = favour;
	}
	
}
