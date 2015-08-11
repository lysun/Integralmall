package com.doublev2v.foundation.core.dto;

public class SimpleAbstractDtoAdater<D, T> extends AbstractDtoAdapter<D, T>{

	@Override
	public T postConvert(D d, T t) {
		return null;
	}

	@Override
	public T convertSimple(D d) {
		return null;
	}

	@Override
	public D postConvertToDo(T t, D d) {
		return null;
	}

	@Override
	public D postUpdate(T t, D d) {
		return null;
	}
	

}
