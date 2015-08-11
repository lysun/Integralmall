package com.doublev2v.integralmall.integral;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.doublev2v.integralmall.user.User;

public interface IntegralRepository extends PagingAndSortingRepository<Integral, String>{
	/**
	 * 获取用户的可用积分
	 */
	public Integral findIntegralByUser_id(String userId);
	public Integral findIntegralByUser(User user);
}
