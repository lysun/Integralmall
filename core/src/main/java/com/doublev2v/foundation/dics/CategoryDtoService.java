package com.doublev2v.foundation.dics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doublev2v.foundation.core.dto.service.AbstractDtoPagingService;
import com.doublev2v.foundation.dics.dto.CategoryDto;
import com.doublev2v.foundation.dics.dto.CategoryDtoConverter;

@Service
@Transactional
public class CategoryDtoService extends AbstractDtoPagingService<Category, CategoryDto, String> {

	@Autowired
	private CategoryService service;
	@Autowired
	private CategoryDtoConverter dtoConverter;
	public CategoryDto getByType(String type) {
		Category d=service.getByType(type);
		return dtoConverter.convert(d);
	}
}
