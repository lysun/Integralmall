package com.doublev2v.integralmall.favour;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.doublev2v.foundation.core.entity.UUIDBaseModel;
import com.doublev2v.integralmall.userinfo.UserInfo;
@Entity
public class Favour extends UUIDBaseModel{
	private Set<UserInfo> users;
	private String originId;//被点赞的源id	
	private long totalCount;
	
	@ManyToMany
	@JoinTable(name="user_favour")
	public Set<UserInfo> getUsers() {
		return users;
	}
	public void setUsers(Set<UserInfo> users) {
		this.users = users;
	}
	public String getOriginId() {
		return originId;
	}
	public void setOriginId(String originId) {
		this.originId = originId;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	
	
}
