package com.doublev2v.integralmall.shop.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.dto.AbstractDtoPagingService;
import com.doublev2v.foundation.core.model.PagedList;
import com.doublev2v.integralmall.shop.Shop;
import com.doublev2v.integralmall.shop.ShopService;
@Service
public class ShopDtoService extends AbstractDtoPagingService<Shop,ShopDto,String>{

	@Autowired
	public ShopService service;
	@Autowired
	public ShopDtoConverter dtoConverter;
	
	public PagedList<ShopDto> findPage(int pageNo, int pageSize,String search) {
		Pageable page=new PageRequest(pageNo-1, pageSize);
		Page<Shop> list=service.findPage(page, search, null, null);
		Page<ShopDto> result=list.map(dtoConverter);
		return new PagedList<ShopDto>(result);
	}
}
