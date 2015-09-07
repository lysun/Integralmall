package com.doublev2v.integralmall.auth.user;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, String> {
	
	public User findByUsername(String username);
}
