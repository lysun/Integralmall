package com.doublev2v.integralmall.user.token;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserTokenRepository extends PagingAndSortingRepository<UserToken, String>{

	public UserToken findByToken(String token);
}