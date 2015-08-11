package com.doublev2v.foundation.dics;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryItemRepository extends PagingAndSortingRepository<CategoryItem, String> {
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<CategoryItem> findByCategoryType(String type);
}
