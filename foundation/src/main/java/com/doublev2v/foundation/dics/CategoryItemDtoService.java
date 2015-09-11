package com.doublev2v.foundation.dics;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doublev2v.foundation.core.dto.AbstractPagingDtoService;
import com.doublev2v.foundation.dics.dto.CategoryItemDtoConverter;
import com.doublev2v.foundation.dics.dto.CategoryItemDto;

@Service
@Transactional
public class CategoryItemDtoService extends AbstractPagingDtoService<CategoryItem, CategoryItemDto, String> {
	@Autowired
	private CategoryItemService service;
	@Autowired
	private CategoryItemDtoConverter dtoConverter;

	public List<CategoryItemDto> getCategoryItemsByType(String type) {
		List<CategoryItem> list=service.getCategoryItemsByType(type);
		return new ArrayList<CategoryItemDto>(dtoConverter.convertTs(list));
	}
}
