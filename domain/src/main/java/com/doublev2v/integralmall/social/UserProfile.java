package com.doublev2v.integralmall.social;

/**
 * 
 * @author pc
 *
 */
public class UserProfile {

	private String userId;
	private String userToken;
	private String account;
	private int recordbodysize;
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
	public int getRecordbodysize() {
		return recordbodysize;
	}
	public void setRecordbodysize(int recordbodysize) {
		this.recordbodysize = recordbodysize;
	}
}
