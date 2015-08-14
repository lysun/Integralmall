package com.doublev2v.foundation.core.dto;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.doublev2v.foundation.core.entity.Identified;
import com.doublev2v.foundation.core.model.PagedList;
import com.doublev2v.foundation.core.service.PagingService;

public abstract class DtoPagingService<D extends Identified<ID>, T extends Identified<ID>, ID extends Serializable> 
	extends DtoCrudService<D, T, ID>
	implements PagingService<T, ID>{
	
	public void setPagingAndSortingRepository(PagingAndSortingRepository<D, ID> repository) {
		super.setRepository(repository);
	}

	@Override
	public PagingAndSortingRepository<D, ID> getRepository() {
		return (PagingAndSortingRepository<D, ID>)super.getRepository();
	}
	
	@Override
	public PagedList<T> findPage(int page, int size) {
		PageRequest request=new PageRequest(page-1, size);
		Page<D> list=getRepository().findAll(request);
		Page<T> result=list.map(converter);
		return new PagedList<>(result);
	}
}
