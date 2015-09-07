package com.doublev2v.integralmall.userinfo.token;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserInfoTokenRepository extends PagingAndSortingRepository<UserInfoToken, String>{

	public UserInfoToken findByToken(String token);
}
