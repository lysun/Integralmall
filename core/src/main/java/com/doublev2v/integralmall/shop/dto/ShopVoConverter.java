package com.doublev2v.integralmall.shop.dto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.common.SimpleDtoConverter;
import com.doublev2v.integralmall.merchandise.dto.MerchandiseVo;
import com.doublev2v.integralmall.merchandise.dto.MerchandiseVoConverter;
import com.doublev2v.integralmall.shop.Shop;

@Component
public class ShopVoConverter extends SimpleDtoConverter<Shop, ShopVo> {

	@Autowired
	private MerchandiseVoConverter merchandiseVoConverter;
	
	@Override
	public ShopVo convert(Shop d) {
		ShopVo t=new ShopVo();
		t.setId(d.getId());
		t.setShopName(d.getShopName());
		t.setPicUrl(d.getMainPic().getUrl());
		Set<MerchandiseVo> set=new HashSet<MerchandiseVo>(merchandiseVoConverter.convertTs(d.getMerchs()));
		t.setMerchs(set);
		return t;
	}
	@Override
	public ShopVo convertSimple(Shop d) {
		ShopVo t=new ShopVo();
		t.setId(d.getId());
		t.setShopName(d.getShopName());
		t.setPicUrl(d.getMainPic().getUrl());
		return t;
	}

}
