package com.doublev2v.foundation.dics.dto;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.common.SimpleDtoConverter;
import com.doublev2v.foundation.dics.Category;
import com.doublev2v.foundation.dics.CategoryItem;
import com.doublev2v.foundation.dics.CategoryRepository;

@Component
public class CategoryDtoConverter extends SimpleDtoConverter<Category, CategoryDto> {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CategoryItemDtoConverter categoryItemDTOAdapter;
	

	@Override
	public CategoryDto postConvert(Category d, CategoryDto t) {
		Category parent=d.getParent();
		String parentid=parent==null?null:parent.getId();
		t.setParentid(parentid);
		Set<CategoryItem> items=d.getItems();
		if(items!=null) {
			Set<CategoryItemDto> tItems=new HashSet<CategoryItemDto>();
			tItems.addAll(categoryItemDTOAdapter.convertTs(items));
			t.setItems(tItems);
		}		
		Set<Category> subCategorys=d.getSubCategories();
		if(subCategorys!=null) {
			Set<CategoryDto> subCategoryDTOs=new HashSet<CategoryDto>();
			subCategoryDTOs.addAll(convertTs(subCategorys));
			t.setSubCategories(subCategoryDTOs);
		}		
		return t;
	}

	@Override
	public Category postConvertD(CategoryDto t, Category d) {
		return postUpdate(t,d);
	}

	@Override
	public Category postUpdate(CategoryDto t, Category d) {
		String parentid=t.getParentid();
		Category parent=null;
		if(StringUtils.isNotEmpty(parentid)) {
			parent=categoryRepository.findOne(parentid);
		} else {
			String parentType=t.getParentType();
			if(StringUtils.isNotEmpty(parentType)) {
				parent=categoryRepository.getByType(parentType);
			}
		}
		d.setParent(parent);
		return d;
	}
}
