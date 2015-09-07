package com.doublev2v.foundation.core.dto;

import java.util.Collection;

import org.springframework.core.convert.converter.Converter;

public interface IConverter<D, T> extends Converter<D,T>{
	/**
	 * T转换D
	 * @param t
	 * @return
	 */
	public D convertD(T t);
	/**
	 * 更新D
	 * @param t
	 * @param d
	 * @return
	 */
	public D update(T t,D d);
	/**
	 * 针对转换时只需要部分数据的转换要求
	 * @param d
	 * @return
	 */
	public T convertSimple(D d);
	/**
	 * 集合T转D
	 * @param ts
	 * @return
	 */
	public Collection<D> convertDs(Iterable<? extends T> ts);
	/**
	 * 集合D转T
	 * @param ds
	 * @return
	 */
	public Collection<T> convertTs(Iterable<? extends D> ds);
	/**
	 * 集合D转换T，T中只有较少的数据
	 * @param ds
	 * @return
	 */
	public Collection<T> convertSimples(Iterable<? extends D> ds);
}
