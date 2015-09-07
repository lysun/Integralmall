package com.doublev2v.integralmall.userinfo.token;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.rest.ErrorCodeException;
import com.doublev2v.foundation.core.service.AbstractPagingAndSortingService;
import com.doublev2v.integralmall.userinfo.UserInfo;
import com.doublev2v.integralmall.util.SystemErrorCodes;
@Service
@Transactional
public class UserInfoTokenService extends AbstractPagingAndSortingService<UserInfo, String>{

	@Autowired
	private UserInfoTokenRepository repository;
	/**
	 * 根据token获取用户信息
	 * @param token
	 * @return
	 */
	public UserInfo getUser(String token){
		UserInfoToken userToken=repository.findByToken(token);
		if(userToken==null||userToken.getUser()==null){
			throw new ErrorCodeException(SystemErrorCodes.UNLOGIN,"用户没有登录");
		}
		return userToken.getUser();
	}
	
	@Override
	public UserInfo update(UserInfo entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
