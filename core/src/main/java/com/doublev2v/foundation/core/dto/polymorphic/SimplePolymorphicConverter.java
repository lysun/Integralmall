package com.doublev2v.foundation.core.dto.polymorphic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.doublev2v.foundation.core.dto.BeanMapper;

public class SimplePolymorphicConverter<S extends D,G extends T,D,T>
implements PolymorphicConverter<D, T>{

	@Override
	public boolean support(D d) {
		if(d==null)return false;
		if(d.getClass().equals(getSClass()))return true;
		return false;
	}

	@Override
	public T convert(D d) {
		T t=BeanMapper.map(d, getGClass());
		return postConvert(d, t);
	}
	@Override
	public T convertSimple(D d) {
		T t=BeanMapper.map(d, getGClass());
		return postConvert(d, t);
	}
	/**
	 * 子类可以重写postConvert方法，转换特殊字段
	 * @param d
	 * @param t
	 * @return
	 */
	protected T postConvert(D d, T t) {
		return t;
	}
	
	protected Class<S> getSClass() {
		Class<S> entityClass = null;
	    Type t = getClass().getGenericSuperclass();
	    Type[] p = ((ParameterizedType)t).getActualTypeArguments();
	    entityClass = (Class<S>)p[0];
	    return entityClass;
	}
	
	protected Class<G> getGClass() {
		Class<G> entityClass = null;
	    Type t = getClass().getGenericSuperclass();
	    Type[] p = ((ParameterizedType)t).getActualTypeArguments();
	    entityClass = (Class<G>)p[1];
	    return entityClass;
	}

	
}