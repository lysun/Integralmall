package com.doublev2v.foundation.core.dto;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.doublev2v.foundation.core.entity.Identified;
import com.doublev2v.foundation.core.service.AbstractLogicDeleteService;
import com.doublev2v.foundation.core.service.LogicDeleteService;

/**
 * 专门用于转换数据的service层
 * @author Administrator
 *
 * @param <D>
 * @param <T>
 * @param <ID>
 */
public class AbstractLogicDeleteDtoService<D extends Identified<ID>, T extends Identified<ID>, ID extends Serializable>
	extends AbstractPagingDtoService<D, T, ID> implements LogicDeleteService<T, ID>{
	
	@Autowired
	protected AbstractLogicDeleteService<D, ID> service;

	@Override
	public void logicDelete(ID id) {
		if(id==null)return;
		service.logicDelete(id);
		
	}
	
	@Override	
	public void logicDeleteAll(Iterable<ID> ids) {
		if(ids==null)return;
		service.logicDeleteAll(ids);
	}
	

}
