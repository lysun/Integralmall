package com.doublev2v.foundation.core.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.doublev2v.foundation.core.repository.LogicDeleteRepository;

public abstract class AbstractLogicDeleteService<T,ID extends Serializable> 
	extends AbstractPagingAndSortingService<T, ID> implements LogicDeleteService<T, ID>{
	
	@Autowired
	public void setRepository(LogicDeleteRepository<T, ID> repository) {
		super.setRepository(repository);
	}
	public LogicDeleteRepository<T, ID> getRepository() {
		return (LogicDeleteRepository<T, ID>)super.getRepository();
	}
	
	/**
	 * 如果需要重写删除方法，只需要重写此方法就可以，其他方法都是调用的此方法进行逻辑删除的
	 */
	@Override
	public void logicDelete(T t) {
		if(t==null)return;
		getRepository().logicDelete(t);
	}
	@Override
	public final void logicDelete(ID id) {//抽象类中final修饰的方法内获取注入的实例是null，需要用到注入实例的地方必须用get方法，让子类注入具体实例
		if(id==null)return;
		T t=getRepository().findOne(id);
		if(t==null)return;
		logicDelete(t);
	}
	@Override
	public final void logicDelete(Iterable<T> ts){
		if(ts==null)return;
		for(T t:ts){
			logicDelete(t);
		}
	}
	@Override
	public final void logicDeleteAll(Iterable<ID> ids) {
		if(ids==null)return;
		for (ID id : ids) {
			logicDelete(id);
		}
	}
}
