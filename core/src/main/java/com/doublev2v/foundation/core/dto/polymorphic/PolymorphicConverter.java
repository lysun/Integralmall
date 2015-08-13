package com.doublev2v.foundation.core.dto.polymorphic;

import org.springframework.core.convert.converter.Converter;

/**
 * 多态转换接口
 * @author pc
 *
 * @param <S>
 * @param <T>
 */
public interface PolymorphicConverter<D,T> extends Converter<D, T> {

	/**
	 * 是否支持实际参数类型
	 * @param source
	 * @return
	 */
	boolean support(D d);
	
	/**
	 * 进行参数转换
	 * @param source
	 * @return T的子类
	 */
	T convert(D d);
	/**
	 * 转换列表中的少量数据
	 * @param source
	 * @return T的子类
	 */
	T convertSimple(D d);
}
