package com.doublev2v.integralmall.user;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.rest.ErrorCodeException;
import com.doublev2v.foundation.core.service.AbstractPagingAndSortingService;
import com.doublev2v.integralmall.util.SystemErrorCodes;
@Service
@Transactional
public class UserTokenService extends AbstractPagingAndSortingService<User, String>{

	@Autowired
	private UserTokenRepository repository;
	/**
	 * 根据token获取用户信息
	 * @param token
	 * @return
	 */
	public User getUser(String token){
		UserToken userToken=repository.findByToken(token);
		if(userToken==null||userToken.getUser()==null){
			throw new ErrorCodeException(SystemErrorCodes.UNLOGIN,"用户没有登录");
		}
		return userToken.getUser();
	}
	
	@Override
	public User update(User entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
