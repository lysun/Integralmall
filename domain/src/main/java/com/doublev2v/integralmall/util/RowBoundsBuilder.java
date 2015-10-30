package com.doublev2v.integralmall.util;

import org.apache.ibatis.session.RowBounds;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class RowBoundsBuilder {

	/**
	 * 
	 * @param page 页号，从1开始
	 * @param size 页码，应该大于0
	 * @return
	 */
	public static RowBounds page(int page, int size) {
		Pageable pageable=new PageRequest(page-1, size);
		return new RowBounds(pageable.getOffset(),pageable.getPageSize());
	}
}
