package com.doublev2v.integralmall.shop;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ShopRepository extends PagingAndSortingRepository<Shop, String>,
	JpaSpecificationExecutor<Shop>{
}
