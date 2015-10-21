package com.doublev2v.integralmall.favour;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FavourRepository extends PagingAndSortingRepository<Favour, String>,
	JpaSpecificationExecutor<Favour>{
	
	public Favour findByOriginId(String originId);
	
}
