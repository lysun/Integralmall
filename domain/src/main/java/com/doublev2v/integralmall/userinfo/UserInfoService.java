package com.doublev2v.integralmall.userinfo;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.rest.ErrorCodeException;
import com.doublev2v.foundation.core.service.AbstractPagingAndSortingService;
import com.doublev2v.integralmall.util.SystemErrorCodes;
@Service
@Transactional
public class UserInfoService extends AbstractPagingAndSortingService<UserInfo, String>{
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	public UserInfo findByAccount(String account) {
		if(StringUtils.isBlank(account))throw new IllegalArgumentException("传入账户错误");
		UserInfo user=userInfoRepository.findByAccount(account);
		if(user==null){
			throw new ErrorCodeException(SystemErrorCodes.NONE_ACCOUNT);
		}
		return user;

	}

}
