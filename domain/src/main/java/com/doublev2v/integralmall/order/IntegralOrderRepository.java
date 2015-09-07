package com.doublev2v.integralmall.order;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IntegralOrderRepository extends PagingAndSortingRepository<IntegralOrder, String>,
		JpaSpecificationExecutor<IntegralOrder>{
	
}
