package com.doublev2v.integralmall.shop;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.doublev2v.integralmall.auth.user.User;

public interface ShopRepository extends PagingAndSortingRepository<Shop, String>{
 
	public Shop findByUser(User user);
	
	/**
	 * 为了和列表显示有一样的效果
	 * @param user
	 * @param page
	 * @return
	 */
	public Page<Shop> findByUser(User user,Pageable page);
}
