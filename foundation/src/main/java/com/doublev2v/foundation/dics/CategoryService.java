package com.doublev2v.foundation.dics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doublev2v.foundation.core.service.AbstractPagingAndSortingService;

@Service
@Transactional
public class CategoryService extends AbstractPagingAndSortingService<Category, String> {

	@Autowired
	public void setCategoryRepository(CategoryRepository repository) {
		super.setRepository(repository);
	}
	
	@Override
	public CategoryRepository getRepository() {
		return (CategoryRepository)super.getRepository();
	}
	
	/**
	 * 根据类别名称获取字典信息
	 * @param type
	 * @return
	 */
	public Category getByType(String type) {
		Category d=getRepository().getByType(type);
		return d;
	}
	
	public void deleteByType(String type) {
		if(type==null)return;
		getRepository().deleteByType(type);
	}
}
