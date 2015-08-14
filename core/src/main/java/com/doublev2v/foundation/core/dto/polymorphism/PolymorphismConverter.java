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
	 * 判断是否是D对象(继承时泛型继承D，判断是否是子类)
	 * @param d
	 * @return
	 */
	public boolean supportD(D d);
	/**
	 * 判断是否是T对象(继承时泛型继承T，判断是否是子类)
	 * @param t
	 * @return
	 */
	public boolean supportT(T t);
}
