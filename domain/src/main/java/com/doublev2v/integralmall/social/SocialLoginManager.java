package com.doublev2v.integralmall.social;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doublev2v.integralmall.client.Client;
import com.doublev2v.integralmall.userinfo.UserInfo;
import com.doublev2v.integralmall.userinfo.UserInfoRepository;

@Service
public class SocialLoginManager {

	@Autowired
	private SocialLoginMapper mapper;
	@Autowired
	private UserInfoRepository userInfoRepository;
	private Client client=Client.getInstance();
	
	public LoginResult login(String id) {
		UserProfile profile=mapper.getProfileBySocialId(id);
		return LoginResult.getResult(profile);
	}
	
	public LoginResult bind(String account, String socialId, int type) {
		UserInfo userInfo=userInfoRepository.findByAccount(account);
		//如果为空，需要先注册
		if(userInfo==null) {
			regist(account, type);
		}
		mapper.bindSocialAccount(account, socialId);
		return login(socialId);
	}
	
	private void regist(String account, int type) {
		Map<String, String> params=new HashMap<>();
		params.put("username", account);
		params.put("account", account);
		params.put("type", Integer.toString(type));
		client.post("http://122.112.15.152:8094/jefen/user/register.action", params);
	}
	
	public static class LoginResult {
		
		private UserProfile userInfo;
		private int isRegister;
		public UserProfile getUserInfo() {
			return userInfo;
		}
		public void setUserInfo(UserProfile userInfo) {
			this.userInfo = userInfo;
		}
		public int getIsRegister() {
			return isRegister;
		}
		public void setIsRegister(int isRegister) {
			this.isRegister = isRegister;
		}
		
		public static LoginResult getResult(UserProfile profile) {
			LoginResult result=new LoginResult();
			if(profile==null) {
				result.isRegister=0;
			} else {
				result.isRegister=1;
				result.userInfo=profile;
			}
			return result;
		}
	}
}
