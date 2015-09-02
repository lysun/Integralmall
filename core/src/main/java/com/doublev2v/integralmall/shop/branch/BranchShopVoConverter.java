package com.doublev2v.integralmall.shop.branch;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.common.SimpleDtoConverter;
import com.doublev2v.integralmall.merchandise.Merchandise;
import com.doublev2v.integralmall.merchandise.dto.MerchandiseVo;
import com.doublev2v.integralmall.merchandise.dto.MerchandiseVoConverter;

@Component
public class BranchShopVoConverter extends SimpleDtoConverter<BranchShop, BranchShopVo> {

	@Autowired
	private MerchandiseVoConverter merchandiseVoConverter;
	
	@Override
	public BranchShopVo convert(BranchShop d) {
		BranchShopVo t=new BranchShopVo();
		t.setId(d.getId());
		t.setName(d.getName());
		t.setPicUrl(d.getShop().getMainPic().getUrl());
		t.setAddress(d.getAddress());
		t.setDescription(d.getDescription());
		Set<MerchandiseVo> set=new HashSet<MerchandiseVo>(merchandiseVoConverter.convertTs(d.getMerchs()));
		t.setMerchs(set);
		return t;
	}
	@Override
	public BranchShopVo convertSimple(BranchShop d) {
		BranchShopVo t=new BranchShopVo();
		t.setId(d.getId());
		t.setName(d.getName());
		t.setPicUrl(d.getShop().getMainPic().getUrl());
		t.setAddress(d.getAddress());
		t.setDescription(d.getDescription());
		t.setTel(d.getTel());
		//获取该分店下所有商品的最低积分
		long leastIntegral=0;
		if(d.getMerchs()!=null){
			for(Merchandise merch:d.getMerchs()){
				if(merch.getIntegralCount()<leastIntegral){
					leastIntegral=merch.getIntegralCount();
				}
			}
		}
		t.setLeastIntegral(String.valueOf(leastIntegral));
		return t;
	}

}
