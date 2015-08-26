package com.doublev2v.integralmall.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.dto.AbstractDtoPagingService;
import com.doublev2v.integralmall.merchandise.MerchandiseService;
import com.doublev2v.integralmall.shop.dto.ShopDto;
import com.doublev2v.integralmall.shop.dto.ShopDtoConverter;
@Service
public class ShopDtoService extends AbstractDtoPagingService<Shop,ShopDto,String>{
	@Autowired
	private ShopDtoConverter dtoConverter;
	@Autowired
	private MerchandiseService service;

	
}
