package com.doublev2v.foundation.dics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doublev2v.foundation.core.service.AbstractPagingAndSortingService;

@Service
@Transactional
public class CategoryItemService extends AbstractPagingAndSortingService<CategoryItem, String> {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	public void setCategoryItemRepository(CategoryItemRepository repository) {
		super.setRepository(repository);
	}
	
	@Override
	public CategoryItemRepository getRepository() {
		return (CategoryItemRepository)super.getRepository();
	}
	
	public List<CategoryItem> getCategoryItemsByType(String type) {
		return getRepository().findByCategoryType(type);
	}
	public CategoryItem getCategoryItemsByTypeAndName(String type,String name) {
		return getRepository().findByCategoryTypeAndName(type, name);
	}
	public CategoryItem create(String type,String name){
		Category category=categoryRepository.getByType(type);
		CategoryItem item=new CategoryItem();
		item.setName(name);
		item.setCategory(category);
		return getRepository().save(item);
	}
}
