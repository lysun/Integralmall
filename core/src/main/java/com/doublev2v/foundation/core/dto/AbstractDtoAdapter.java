package com.doublev2v.foundation.core.dto;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/**
 * 用于简化IConverter转换器的各子接口实现的适配器
 * @author Administrator
 *
 * @param <D>
 * @param <T>
 */
public abstract class AbstractDtoAdapter<D, T>{

	public T convert(D d) {
		if(d==null)return null;
		T t=BeanMapper.map(d, getTClass());
		return postConvert(d, t);
	}
	
	/**
	 * 在dozer转换完一般属性之后，将do对象的特殊属性转换给dto
	 * @param d
	 * @param t
	 * @return
	 */
	public abstract T postConvert(D d, T t);

	public D convertD(T t) {
		if(t==null)return null;
		D d=BeanMapper.map(t, getDClass());
		return postConvertD(t, d);
	}

	public abstract D postConvertD(T t,D d);
	
	public D update(T t, D d) {
		BeanMapper.copy(t, d);
		return postUpdate(t,d);
	}
	/**
	 * 子类继承用于提供额外的属性转换
	 * @param d
	 * @param t
	 * @return
	 */
	public abstract D postUpdate(T t,D d);

	public T convertSimple(D d){
		if(d==null)return null;
		T t=BeanMapper.map(d, getTClass());
		return postConvert(d, t);
	}

	public Collection<D> convertDs(Iterable<? extends T> ts) {
		if(ts==null)return null;
		List<D> ds=new ArrayList<D>();
		for(T t:ts){
			ds.add(convertD(t));
		}
		return ds;
	}

	public Collection<T> convertTs(Iterable<? extends D> ds) {
		if(ds==null)return null;
		List<T> ts=new ArrayList<T>();
		for(D d:ds){
			ts.add(convert(d));
		}
		return ts;
	}

	public Collection<T> convertSimples(Iterable<? extends D> ds) {
		if(ds==null)return null;
		List<T> ts=new ArrayList<T>();
		for(D d:ds){
			ts.add(convertSimple(d));
		}
		return ts;
	}

	/**
	 * 获取do运行时类型
	 * @return
	 */
	protected Class<D> getDClass() {
		Type t = getClass().getGenericSuperclass();
		Type[] p=((ParameterizedType)t).getActualTypeArguments();
		Class<D> dClass=(Class<D>)p[0];
        return dClass;
	}
	
	/**
	 * 获取dto运行时类型
	 * @return
	 */
	protected Class<T> getTClass() {
		Type t = getClass().getGenericSuperclass();
		Type[] p=((ParameterizedType)t).getActualTypeArguments();
		Class<T> tClass=(Class<T>)p[1];
        return tClass;
	}
}
