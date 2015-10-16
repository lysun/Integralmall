package com.doublev2v.integralmall.social;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author pc
 *
 */
public class UserProfile {

	private String userId;
	private String userToken;
	private String account;
	private String nickname;
	private String avatar;
	@JsonIgnore
	private String socialAvatar;
	private String recordbodysize;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserToken() {
		return userToken;
	}
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAvatar() {
//		if(avatar!=null) {
//			return avatar;
//		} else {
//			return socialAvatar;
//		}
		return avatar;
	}
	public void setAvatar(String avatar) {
		if(avatar==null) {
			return;
		}
		else {
			this.avatar="http://122.112.15.152/jefen/images/"+avatar;
		}
	}
	public String getSocialAvatar() {
		return socialAvatar;
	}
	public void setSocialAvatar(String socialAvatar) {
		this.socialAvatar = socialAvatar;
	}
	public String getRecordbodysize() {
		return recordbodysize;
	}
	public void setRecordbodysize(String recordbodysize) {
		this.recordbodysize = recordbodysize;
	}
}
