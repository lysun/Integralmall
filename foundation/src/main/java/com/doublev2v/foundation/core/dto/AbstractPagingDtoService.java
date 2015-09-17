package com.doublev2v.foundation.core.dto;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.doublev2v.foundation.core.entity.Identified;
import com.doublev2v.foundation.core.model.PagedList;
import com.doublev2v.foundation.core.service.AbstractPagingAndSortingService;
import com.doublev2v.foundation.core.service.PagingService;

public class AbstractPagingDtoService <D extends Identified<ID>, T extends Identified<ID>, ID extends Serializable> 
	extends AbstractCrudDtoService<D, T, ID> implements PagingService<T, ID>{
	@Autowired
	protected AbstractPagingAndSortingService<D, ID> service;
	@Override
	public PagedList<T> findPage(int page, int size) {
		PagedList<D> list=service.findPage(page, size);
		Page<T>  result=new PageImpl<T>(new ArrayList<T>(converter.convertTs(list.getList())),new PageRequest(page-1, size),list.getTotalCount());
		return new PagedList<T>(result);
	}
	
}
