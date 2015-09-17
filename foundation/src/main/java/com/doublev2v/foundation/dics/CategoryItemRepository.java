package com.doublev2v.foundation.dics;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryItemRepository extends PagingAndSortingRepository<CategoryItem, String> {
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<CategoryItem> findByCategoryType(String type);
	/**
	 * 获取同一类型下某个条目名称的CategoryItem(返回null则表示没有此名字的条目)
	 * @param type
	 * @param name
	 * @return
	 */
	CategoryItem findByCategoryTypeAndName(String type,String name);
}
