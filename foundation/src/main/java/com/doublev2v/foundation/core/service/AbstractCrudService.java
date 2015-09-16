package com.doublev2v.foundation.core.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public abstract class AbstractCrudService<T,ID extends Serializable> implements CrudService<T, ID> {
	
	private CrudRepository<T, ID> repository;
	

	public CrudRepository<T, ID> getRepository() {
		return repository;
	}

	@Autowired
	public void setRepository(CrudRepository<T, ID> repository) {
		this.repository = repository;
	}

	@Override
	public T add(T entity) {
		if(entity==null)return null;
		return getRepository().save(entity);
	}

	@Override
	public Iterable<T> addAll(Iterable<T> entities) {
		if(entities==null)return null;
		return getRepository().save(entities);
	}
	
	@Override
	public T update(T entity) {
		if(entity==null)return null;
		return getRepository().save(entity);
	}
	
	@Override
	public T findOne(ID id) {
		if(id==null)return null;
		return getRepository().findOne(id);
	}

	@Override
	public boolean exists(ID id) {
		if(id==null)return false;
		return getRepository().exists(id);
	}

	@Override
	public Iterable<T> findAll() {
		return getRepository().findAll();
	}

	@Override
	public Iterable<T> findAll(Iterable<ID> ids) {
		if(ids==null)return null;
		return getRepository().findAll(ids);
	}

	@Override
	public long count() {
		return getRepository().count();
	}
	/**
	 * 所有的删除方法都是调用的这个删除，如果重写删除方法，只要重写这个方法就可以了
	 */
	@Override
	public void delete(T entity) {
		if(entity==null)return;
		getRepository().delete(entity);
	}

	@Override
	public final void delete(ID id) {
		if(id==null)return;
		T t=getRepository().findOne(id);
		if(t==null)return;
		delete(t);
	}

	@Override
	public final void delete(Iterable<? extends T> entities) {
		if(entities==null)return;
		for(T t:entities){
			delete(t);
		}
	}

	@Override
	public final void deleteAll(Iterable<ID> ids) {
		if(ids==null)return;
		for (ID id : ids) {
			delete(id);
		}
	}
}
