package com.doublev2v.integralmall.auth.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doublev2v.foundation.core.service.AbstractPagingAndSortingService;
import com.doublev2v.integralmall.auth.UserAuthService;
import com.doublev2v.integralmall.auth.role.RoleRepository;

@Service
@Transactional
public class UserService extends AbstractPagingAndSortingService<User, String>{

	@Autowired
	public UserRepository repository;
	@Autowired
	public RoleRepository roleRepository;
	@Autowired
	public UserAuthService userAuthService;
	/**
	 * 后台没有用UserAuthService中的注册、登陆方法，后期需要再加上token的登陆方式
	 */
	public User add(User user){
		user.setVerified(true);
		return repository.save(user);
	}
	
}
