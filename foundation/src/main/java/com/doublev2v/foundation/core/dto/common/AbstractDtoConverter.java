package com.doublev2v.foundation.core.dto.common;

import com.doublev2v.foundation.core.dto.adapter.AbstractDtoAdapter;

/**
 * 一般dto转换器实现
 * @author Administrator
 *
 * @param <D>
 * @param <T>
 */
public abstract class AbstractDtoConverter<D, T> extends AbstractDtoAdapter<D, T>
	implements DtoConverter<D, T>{


}