package com.doublev2v.foundation.core.dto;

/**
 * 一般转换器，自定义重写方法
 * @author Administrator
 *
 * @param <D>
 * @param <T>
 */
public class SimpleDtoConverter<D, T> extends AbstractDtoConverter<D, T>{

	public T postConvert(D d,T t){
		return t;
	}
	public D postConvertD(T t,D d){
		return d;
	}
	public D postUpdate(T t,D d){
		return d;
	}


}
