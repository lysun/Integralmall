package com.doublev2v.integralmall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.dto.AbstractLogicDeleteDtoService;
import com.doublev2v.integralmall.converter.BranchShopDtoConverter;
import com.doublev2v.integralmall.entity.BranchShopDto;
import com.doublev2v.integralmall.shop.branch.BranchShop;
import com.doublev2v.integralmall.shop.branch.BranchShopService;
@Service
public class BranchShopDtoService extends AbstractLogicDeleteDtoService<BranchShop,BranchShopDto,String>{
	
	@Autowired
	private BranchShopService service;
	@Autowired
	private BranchShopDtoConverter dtoConverter;
	
	public List<BranchShopDto> findByShopId(String shopId){
		List<BranchShopDto> list=new ArrayList<BranchShopDto>(dtoConverter.convertTs(service.findByShopId(shopId)));
		return list;
	}
}
