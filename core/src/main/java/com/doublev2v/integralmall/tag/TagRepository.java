package com.doublev2v.integralmall.tag;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface TagRepository extends PagingAndSortingRepository<Tag, String>{
	
	public List<Tag> findByType(String type);
}
