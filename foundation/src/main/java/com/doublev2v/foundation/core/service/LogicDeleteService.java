package com.doublev2v.foundation.core.service;

import java.io.Serializable;

import com.doublev2v.foundation.core.model.PagedList;

public interface LogicDeleteService<T, ID extends Serializable> {
	public void logicDelete(ID id);
	public void logicDelete(T t);
	public void logicDelete(Iterable<T> ts);
	public void logicDeleteAll(Iterable<ID> ids);
	public Iterable<T> findAll();
	public long count();
	public PagedList<T> findPage(int page, int size);
}
