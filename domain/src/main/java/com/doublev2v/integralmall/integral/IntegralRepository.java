package com.doublev2v.integralmall.integral;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.doublev2v.integralmall.userinfo.UserInfo;

public interface IntegralRepository extends PagingAndSortingRepository<Integral, String>,
	JpaSpecificationExecutor<Integral>{
	/**
	 * 获取用户的可用积分
	 */
	public Integral findByUser_id(String userId);
	public Integral findByUser(UserInfo user);
	public Integral findByUser_account(String account);
}
