package com.doublev2v.integralmall.auth.token;

import org.springframework.data.repository.CrudRepository;

import com.doublev2v.integralmall.auth.user.User;

public interface UserTokenRepository  extends CrudRepository<UserToken, String> {

	public UserToken findByUser(User user);
	
	public UserToken findByToken(String token);
}
