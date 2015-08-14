package com.doublev2v.foundation.core.dto.polymorphism;

/**
 * 多态转换器，自定义重写方法
 * @author Administrator
 *
 * @param <S>
 * @param <G>
 * @param <D>
 * @param <T>
 */
public class SimplePolymorphismConverter<S extends D,G extends T,D,T> 
	extends AbstractPolymorphismConverter<S, G, D, T>{

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
