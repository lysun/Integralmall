package com.doublev2v.integralmall.find.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.common.SimpleDtoConverter;
import com.doublev2v.integralmall.activity.converter.ActivityMerchandiseConverter;
import com.doublev2v.integralmall.activity.entity.ActivityBranchShop;
import com.doublev2v.integralmall.activity.entity.ActivityMerchandise;
import com.doublev2v.integralmall.merchandise.Merchandise;
import com.doublev2v.integralmall.shop.branch.BranchShop;

@Component
public class BranchShopVoConverter extends SimpleDtoConverter<BranchShop, ActivityBranchShop> {

	@Autowired
	private ActivityMerchandiseConverter merchandiseConverter;
	
	@Override
	public ActivityBranchShop convert(BranchShop d) {
		ActivityBranchShop t=new ActivityBranchShop();
		t.setId(d.getId());
		t.setName(d.getName());
		t.setPicUrl(d.getShop().getMainPic().getUrl());
		t.setAddress(d.getAddress());
		t.setDescr(d.getDescription());
		Set<ActivityMerchandise> set=new HashSet<ActivityMerchandise>(merchandiseConverter.convertTs(d.getMerchs()));
		t.setList(set);
		return t;
	}
	@Override
	public ActivityBranchShop convertSimple(BranchShop d) {
		ActivityBranchShop t=new ActivityBranchShop();
		t.setId(d.getId());
		t.setName(d.getName());
		t.setPicUrl(d.getShop().getMainPic().getUrl());
		t.setAddress(d.getAddress());
		t.setDescr(d.getDescription());
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
