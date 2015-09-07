package com.doublev2v.integralmall.merchandise;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MerchandiseRepository extends PagingAndSortingRepository<Merchandise, String>,
		JpaSpecificationExecutor<Merchandise>{
 
}
