package com.doublev2v.integralmall.favour;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.doublev2v.integralmall.userinfo.UserInfo;

public interface UserFavourRepository extends PagingAndSortingRepository<UserFavour, String>,
	JpaSpecificationExecutor<UserFavour>{

	public UserFavour findByUserAndFavour(UserInfo user,Favour favour);
}
