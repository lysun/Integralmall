package com.doublev2v.integralmall.shop;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.doublev2v.foundation.core.repository.LogicDeleteRepository;

public interface ShopRepository extends PagingAndSortingRepository<Shop, String>,
	LogicDeleteRepository<Shop, String>,
	JpaSpecificationExecutor<Shop>{
	
}
