package com.doublev2v.foundation.core.service;

import java.io.Serializable;

import com.doublev2v.foundation.core.entity.LogicDeleteModel;
import com.doublev2v.foundation.core.model.PagedList;

public interface LogicDeleteService<T extends LogicDeleteModel, ID extends Serializable> {
	public void delete(ID id);
	public void delete(T entity);
	public void delete(Iterable<? extends T> entities);
	public void deleteAll(Iterable<ID> ids);
	public Iterable<T> findAll();
	public long count();
	public PagedList<T> findPage(int page, int size);
}
