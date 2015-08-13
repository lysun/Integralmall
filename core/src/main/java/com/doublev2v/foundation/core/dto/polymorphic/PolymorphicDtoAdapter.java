package com.doublev2v.foundation.core.dto.polymorphic;

/**
 * 多态互相转换
 * @author pc
 *
 * @param <S>
 * @param <T>
 */
public interface PolymorphicDtoAdapter<D,T> extends PolymorphicConverter<D, T> {

	boolean supportT(T t);

	D reConvert(T t);
	
	/**
	 * 
	 * @param t dto对象
	 * @param d 业务对象
	 * @return
	 */
	D update(T t, D d);
}
