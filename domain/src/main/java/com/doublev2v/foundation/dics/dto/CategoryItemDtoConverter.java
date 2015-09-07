package com.doublev2v.foundation.dics.dto;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.common.SimpleDtoConverter;
import com.doublev2v.foundation.dics.Category;
import com.doublev2v.foundation.dics.CategoryItem;
import com.doublev2v.foundation.dics.CategoryRepository;

@Component
public class CategoryItemDtoConverter extends SimpleDtoConverter<CategoryItem, CategoryItemDto> {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public CategoryItemDto postConvert(CategoryItem d, CategoryItemDto t) {
		t.setCategoryid(d.getCategory().getId());
		return t;
	}

	@Override
	public CategoryItem postConvertD(CategoryItemDto t, CategoryItem d) {
		String type=t.getType();
		Category category=null;
		if(StringUtils.isNotEmpty(type)) {
			category=categoryRepository.getByType(type);
		} else {
			String categoryId=t.getCategoryid();
			if(StringUtils.isNotEmpty(categoryId)) {
				category=categoryRepository.findOne(categoryId);
			}
		}
		d.setCategory(category);
		return d;
	}

	@Override
	public CategoryItem postUpdate(CategoryItemDto t, CategoryItem d) {
		return d;
	}
}
