package com.doublev2v.integralmall.tag;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface TagRepository extends PagingAndSortingRepository<Tag, String>{
	public Tag findByName(String name);
}
