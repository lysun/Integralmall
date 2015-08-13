package com.doublev2v.foundation.core.dto.polymorphic;

import com.doublev2v.foundation.core.dto.BeanMapper;

public class SimplePolymorphicDtoAdapter<S extends D,G extends T,D,T> 
	extends SimplePolymorphicConverter<S,G,D,T>
	implements PolymorphicDtoAdapter<D,T>{
	
	@Override
	public boolean supportT(T t) {
		if(t==null)return false;
		if(t.getClass().equals(getGClass()))return true;
		return false;
	}
	
	@Override
	public D reConvert(T t) {
		if(!supportT(t))throw new IllegalArgumentException("不支持的参数类型");
		D d=BeanMapper.map(t, getSClass());
		return postReConvert(t, d);
	}
	
	public D postReConvert(T t, D d) {
		return d;
	}
	
	@Override
	public D update(T t, D d) {
		if(!(supportT(t) && support(d)))throw new IllegalArgumentException("不支持的参数类型");
		BeanMapper.copy(t, d);
		return postUpdate(t, d);
	}
	
	public D postUpdate(T t, D d) {
		return d;
	}


}
