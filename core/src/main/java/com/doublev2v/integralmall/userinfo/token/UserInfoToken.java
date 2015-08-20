package com.doublev2v.integralmall.userinfo.token;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.doublev2v.integralmall.userinfo.UserInfo;

@Entity
@Table(catalog="jefen",name="userinfotoken")
public class UserInfoToken {
	private String id;
	private UserInfo user;
	private String token;
	@Id
	@GenericGenerator(name="idGenerator",strategy="uuid")
	@GeneratedValue(generator="idGenerator")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@OneToOne
	@JoinColumn(name="userinfoid")
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
