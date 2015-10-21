package com.doublev2v.integralmall.favour;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface FavourRepository extends PagingAndSortingRepository<Favour, String>{

	public Favour findByOriginId(String originId);
}
