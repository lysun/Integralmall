package com.doublev2v.integralmall.order;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderMerchandiseRepository extends PagingAndSortingRepository<OrderMerchandise, String>{

	public OrderMerchandise findByCouponCode(String couponCode);
}
