package com.doublev2v.integralmall.auth.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doublev2v.foundation.core.dto.AbstractDtoPagingService;
import com.doublev2v.integralmall.auth.user.dto.UserDto;
import com.doublev2v.integralmall.auth.user.dto.UserDtoConverter;

@Service
@Transactional
public class UserDtoService extends AbstractDtoPagingService<User,UserDto, String>{
	@Autowired
	private UserDtoConverter dtoConverter;
	@Autowired
	public UserService service;
	
	
	
	
}
