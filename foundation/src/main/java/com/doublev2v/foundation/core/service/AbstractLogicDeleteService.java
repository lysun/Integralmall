package com.doublev2v.foundation.core.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.doublev2v.foundation.core.entity.LogicDeleteModel;
import com.doublev2v.foundation.core.model.PagedList;
import com.doublev2v.foundation.core.repository.LogicDeleteRepository;

public class AbstractLogicDeleteService<T extends LogicDeleteModel,ID extends Serializable> 
	extends AbstractPagingAndSortingService<T, ID> implements LogicDeleteService<T, ID>{
	@Override
	public PagingAndSortingRepository<T, ID> getRepository() {
		return (PagingAndSortingRepository<T, ID>)super.getRepository();
	}
	@Autowired
	protected LogicDeleteRepository<T,ID> repository;
	/**
	 * 所有的删除方法都是调用的这个删除，如果重写删除方法，只要重写这个方法就可以了
	 */
	@Override
	public void delete(T entity) {
		if(entity==null)return;
		entity.setDeleted(true);
		getRepository().save(entity);
	}
	
	@Override
	public void delete(ID id) {
		if(id==null)return;
		T t=getRepository().findOne(id);
		delete(t);
	}

	@Override
	public void delete(Iterable<? extends T> entities) {
		if(entities==null)return;
		for(T t:entities){
			delete(t);
		}
	}

	@Override
	public void deleteAll(Iterable<ID> ids) {
		if(ids==null)return;
		for (ID id : ids) {
			delete(id);
		}
	}
	public Iterable<T> findAll(){
		return repository.findByDeleted(false);
	}
	public long count(){
		return repository.findByDeleted(false).size();
	}
	public PagedList<T> findPage(int page, int size){
		PageRequest pageable=new PageRequest(page-1, size);
		Page<T> result=repository.findByDeleted(false, pageable);
		return new PagedList<T>(result);
	}
}
