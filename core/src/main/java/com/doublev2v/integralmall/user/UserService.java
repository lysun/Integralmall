package com.doublev2v.integralmall.user;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.service.AbstractPagingAndSortingService;
@Service
@Transactional
public class UserService extends AbstractPagingAndSortingService<User, String>{

	@Override
	public User update(User entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
