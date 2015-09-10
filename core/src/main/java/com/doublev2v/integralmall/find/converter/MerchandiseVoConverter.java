package com.doublev2v.integralmall.find.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.common.SimpleDtoConverter;
import com.doublev2v.foundation.media.MediaContent;
import com.doublev2v.integralmall.converter.BranchShopDtoConverter;
import com.doublev2v.integralmall.entity.BranchShopDto;
import com.doublev2v.integralmall.find.entity.CouponVo;
import com.doublev2v.integralmall.find.entity.GiftVo;
import com.doublev2v.integralmall.find.entity.MerchandiseVo;
import com.doublev2v.integralmall.merchandise.Merchandise;
import com.doublev2v.integralmall.util.Constant;
import com.doublev2v.integralmall.util.DateUtil;

@Component
public class MerchandiseVoConverter extends SimpleDtoConverter<Merchandise, MerchandiseVo> {
	@Autowired
	private BranchShopDtoConverter branchShopDtoConverter;
	@Override
	public MerchandiseVo convert(Merchandise d) {
		MerchandiseVo t=null;
		if(d.getType().equals(Constant.VIRTUAL)){
			CouponVo couponVo=new CouponVo();
			t=couponVo;
			if(d.getBrand()!=null){
				couponVo.setBrandName(d.getBrand().getName());
			}
			if(d.getClassify()!=null){
				couponVo.setClassifyName(d.getClassify().getName());
			}
			if(d.getEndDate()!=null){
				couponVo.setExpiryTime(DateUtil.format(d.getEndDate()).substring(0, 10));
			}
			if(d.getShops()!=null){//将shopDto信息转过去用于比较哪个距离短
				Set<BranchShopDto> set=new HashSet<BranchShopDto>(branchShopDtoConverter.convertTs(d.getShops()));
				couponVo.setShopDtos(set);
			}
		}
		if(d.getType().equals(Constant.ACTUAL)){
			GiftVo giftVo=new GiftVo();
			t=giftVo;
		}
		t.setId(d.getId());
		t.setName(d.getName());
		t.setIntegralCount(String.valueOf(d.getIntegralCount()));
		t.setStock(String.valueOf(d.getStock()));
		t.setRemark(d.getRemark());
		if(d.getMedias()!=null){
			Set<String> set=new HashSet<String>();
			for(MediaContent media:d.getMedias()){
				set.add(media.getUrl());
				t.setPics(set);
			}
		}
		return t;
	}
	@Override
	public MerchandiseVo convertSimple(Merchandise d) {
		MerchandiseVo t=null;
		if(d.getType().equals(Constant.VIRTUAL)){
			CouponVo couponVo=new CouponVo();
			t=couponVo;
			
			if(d.getEndDate()!=null){
				couponVo.setExpiryTime(DateUtil.format(d.getEndDate()).substring(0,10));
			}
			if(d.getShops()!=null){//将shopDto信息转过去用于比较哪个距离短
				Set<BranchShopDto> set=new HashSet<BranchShopDto>(branchShopDtoConverter.convertTs(d.getShops()));
				couponVo.setShopDtos(set);
			}
			
		}
		if(d.getType().equals(Constant.ACTUAL)){
			GiftVo giftVo=new GiftVo();
			t=giftVo;
			giftVo.setPrice(String.valueOf(d.getPrice()));
		}
		t.setId(d.getId());
		t.setName(d.getName());
		t.setIntegralCount(String.valueOf(d.getIntegralCount()));
		t.setStock(String.valueOf(d.getStock()));
		if(d.getBrand()!=null){
			t.setBrandName(d.getBrand().getName());
		}
		if(d.getClassify()!=null){
			t.setClassifyName(d.getClassify().getName());
		}
		if(d.getMainPicMedia()!=null){
			t.setMainPic(d.getMainPicMedia().getUrl());
		}
		
		return t;
	}
	
}
