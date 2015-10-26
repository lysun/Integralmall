package com.doublev2v.integralmall.social;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SocialLogin {

	private String social_id;
	@JsonIgnore
	private String social_avatar;
	private String user_id;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getSocial_id() {
		return social_id;
	}
	public void setSocial_id(String social_id) {
		this.social_id = social_id;
	}
	public String getSocial_avatar() {
		return social_avatar;
	}
	public void setSocial_avatar(String social_avatar) {
		this.social_avatar = social_avatar;
	}
	
}
