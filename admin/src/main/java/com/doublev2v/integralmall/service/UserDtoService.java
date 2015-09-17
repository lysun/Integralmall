package com.doublev2v.integralmall.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doublev2v.foundation.core.dto.AbstractPagingDtoService;
import com.doublev2v.integralmall.auth.user.User;
import com.doublev2v.integralmall.entity.UserDto;

@Service
@Transactional
public class UserDtoService extends AbstractPagingDtoService<User,UserDto, String>{

	
}
