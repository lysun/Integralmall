package com.doublev2v.integralmall.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.common.SimpleDtoConverter;
import com.doublev2v.integralmall.entity.BranchShopDto;
import com.doublev2v.integralmall.shop.ShopRepository;
import com.doublev2v.integralmall.shop.branch.BranchShop;
@Component
public class BranchShopDtoConverter extends SimpleDtoConverter<BranchShop, BranchShopDto>{
	@Autowired
	private ShopRepository shopRepository;
	
	public BranchShopDto postConvert(BranchShop d,BranchShopDto t){
		t.setShopId(d.getShop().getId());
		return t;
	}
	public BranchShop postConvertD(BranchShopDto t,BranchShop d){
		return postUpdate(t, d);
	}
	public BranchShop postUpdate(BranchShopDto t,BranchShop d){
		if(StringUtils.isNotBlank(t.getShopId())){
			d.setShop(shopRepository.findOne(t.getShopId()));
		}
		return d;
	}
}
