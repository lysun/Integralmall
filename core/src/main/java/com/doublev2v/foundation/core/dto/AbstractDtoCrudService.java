package com.doublev2v.foundation.core.dto;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.doublev2v.foundation.core.dto.common.DtoConverter;
import com.doublev2v.foundation.core.entity.Identified;
import com.doublev2v.foundation.core.service.AbstractCrudService;
import com.doublev2v.foundation.core.service.CrudService;

/**
 * 专门用于转换数据的service层
 * @author Administrator
 *
 * @param <D>
 * @param <T>
 * @param <ID>
 */
@Transactional
public class AbstractDtoCrudService<D extends Identified<ID>, T extends Identified<ID>, ID extends Serializable>
	implements CrudService<T, ID>{
	
	@Autowired
	protected AbstractCrudService<D, ID> service;
	@Autowired
	protected DtoConverter<D, T> converter;
	@Override
	public T add(T t) {
		if(t==null) return null;
		D d=converter.convertD(t);
		service.add(d);
		return converter.convert(d);
	}
	@Override
	public T update(T t) {
		if(t==null) return null;
		ID id=t.getId();
		D d=service.findOne(id);
		if(d==null) return null;
		d=converter.update(t, d);
		d=service.update(d);
		t=converter.convert(d);
		return t;
	}
	@Override
	public Iterable<T> addAll(Iterable<T> entities) {
		if(entities==null) return null;
		Iterable<D> ds=converter.convertDs(entities);
		ds=service.addAll(ds);
		return converter.convertTs(ds);
	}
	@Override
	public T findOne(ID id) {
		if(id==null) return null;
		D d=service.findOne(id);
		if(d==null) return null;
		return converter.convert(d);
	}
	@Override
	public boolean exists(ID id) {
		if(id==null) return false;
		return service.exists(id);
	}
	@Override
	public Iterable<T> findAll() {
		Iterable<D> all=service.findAll();
		if(all==null)return null;
		return converter.convertTs(all);
	}
	@Override
	public Iterable<T> findAll(Iterable<ID> ids) {
		if(ids==null)return null;
		Iterable<D> all=service.findAll(ids);
		if(all==null)return null;
		return converter.convertTs(all);
	}
	@Override
	public long count() {
		return service.count();
	}
	@Override
	public void delete(ID id) {
		if(id==null)return;
		service.delete(id);
		
	}
	@Override
	public void delete(T entity) {
		if(entity==null)return;
		service.delete(entity.getId());
	}
	@Override
	public void delete(Iterable<? extends T> entities) {
		if(entities==null)return;
		for (T t : entities) {
			delete(t);
		}
	}
	@Override
	public void deleteAll(Iterable<ID> ids) {
		if(ids==null)return;
		service.deleteAll(ids);
	}
	
	

}
