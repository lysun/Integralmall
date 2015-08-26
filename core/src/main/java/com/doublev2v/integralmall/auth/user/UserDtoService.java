package com.doublev2v.integralmall.auth.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doublev2v.foundation.core.dto.AbstractDtoPagingService;
import com.doublev2v.integralmall.auth.user.dto.UserDto;

@Service
@Transactional
public class UserDtoService extends AbstractDtoPagingService<User,UserDto, String>{

	
}
