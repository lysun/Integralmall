package com.doublev2v.foundation.core.dto.polymorphism;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.doublev2v.foundation.core.dto.AbstractDtoAdapter;
import com.doublev2v.foundation.core.dto.BeanMapper;
/**
 * 多态转换器实现
 * @author Administrator
 *
 * @param <S>
 * @param <G>
 * @param <D>
 * @param <T>
 */
public abstract class AbstractPolymorphismConverter<S extends D,G extends T,D,T> 
	extends AbstractDtoAdapter<D,T> implements PolymorphismConverter<D,T>{
	
	@Override
	public boolean supportD(D d) {
		if(d==null)return false;
		return d.getClass().equals(getSClass());
	}

	@Override
	public boolean supportT(T t) {
		if(t==null)return false;
		return t.getClass().equals(getGClass());
	}

	@Override
	public T convert(D d) {
		T t=BeanMapper.map(d, getGClass());
		return postConvert(d, t);
	}
	/**
	 * 子类继承用于提供额外的属性转换
	 * @param d
	 * @param t
	 * @return
	 */
	public abstract T postConvert(D d,T t);
	
	@Override
	public D convertD(T t) {
		D d=BeanMapper.map(t, getSClass());
		return postConvertD(t,d);
	}
	/**
	 * 子类继承用于提供额外的属性转换
	 * @param d
	 * @param t
	 * @return
	 */
	public abstract D postConvertD(T t,D d);
	
	private Class<S> getSClass(){
		Class<S> entityClass = null;
	    Type t = getClass().getGenericSuperclass();
	    Type[] p = ((ParameterizedType)t).getActualTypeArguments();
	    entityClass = (Class<S>)p[0];
	    return entityClass;
	}
	
	private Class<G> getGClass(){
		Class<G> entityClass = null;
	    Type t = getClass().getGenericSuperclass();
	    Type[] p = ((ParameterizedType)t).getActualTypeArguments();
	    entityClass = (Class<G>)p[1];
	    return entityClass;
	}
	
	
}
