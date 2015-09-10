package com.doublev2v.foundation.core.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/**
 * 需要逻辑删除的repository继承此接口
 * @author Administrator
 *
 * @param <T>
 * @param <ID>
 */
public interface LogicDeleteRepository<T, ID extends Serializable> {
	public List<T> findByDeleted(boolean deleted);
	public Page<T> findByDeleted(boolean deleted,Pageable page);
}
