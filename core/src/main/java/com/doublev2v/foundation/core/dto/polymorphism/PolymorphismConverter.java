package com.doublev2v.foundation.core.dto.polymorphism;

import com.doublev2v.foundation.core.dto.IConverter;
/**
 * 多态转换器
 * @author Administrator
 *
 * @param <D>
 * @param <T>
 */
public interface PolymorphismConverter<D,T> extends IConverter<D,T>{

	/**
	 * 判断传入对象的类型是否是该转换器D泛型的子类型S(实现PolymorphismConverter的类需要加上两个泛型D的子类型S和T的子类型G)，
	 * 如果是则调用该转换器进行转换操作
	 * @param d
	 * @return
	 */
	public boolean supportD(D d);
	/**
	 * 判断传入对象的类型是否是该转换器T泛型的子类型G(实现PolymorphismConverter的类需要加上两个泛型D的子类型S和T的子类型G)，
	 * 如果是则调用该转换器进行转换操作
	 * @param t
	 * @return
	 */
	public boolean supportT(T t);
}
