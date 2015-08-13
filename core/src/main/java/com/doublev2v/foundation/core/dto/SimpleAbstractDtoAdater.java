package com.doublev2v.foundation.core.dto;

public abstract class SimpleAbstractDtoAdater<D, T> extends AbstractDtoAdapter<D, T>{

	@Override
	public T postConvert(D d, T t) {
		return t;
	}

	@Override
	public T convertSimple(D d) {
		return convert(d);
	}

	@Override
	public D postConvertToDo(T t, D d) {
		return d;
	}

	@Override
	public D postUpdate(T t, D d) {
		return d;
	}
	

}
