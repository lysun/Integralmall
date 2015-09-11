package com.doublev2v.foundation.core.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.doublev2v.foundation.core.repository.LogicDeleteRepository;

public abstract class AbstractLogicDeleteService<T,ID extends Serializable> 
	extends AbstractPagingAndSortingService<T, ID> implements LogicDeleteService<T, ID>{
	@Override
	public PagingAndSortingRepository<T, ID> getRepository() {
		return (PagingAndSortingRepository<T, ID>)super.getRepository();
	}
	@Autowired
	protected LogicDeleteRepository<T,ID> repository;
	
	
	@Override
	public void logicDelete(ID id) {
		if(id==null)return;
		repository.logicDelete(id);
	}

	@Override
	public void logicDeleteAll(Iterable<ID> ids) {
		if(ids==null)return;
		for (ID id : ids) {
			logicDelete(id);
		}
	}
}
