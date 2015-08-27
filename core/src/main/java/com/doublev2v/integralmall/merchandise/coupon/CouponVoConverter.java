package com.doublev2v.integralmall.merchandise.coupon;

import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.polymorphism.SimplePolymorphismConverter;
import com.doublev2v.foundation.media.MediaContent;
import com.doublev2v.integralmall.merchandise.Merchandise;
import com.doublev2v.integralmall.merchandise.dto.MerchandiseVo;
@Component
public class CouponVoConverter extends SimplePolymorphismConverter<Coupon, CouponVo,Merchandise,MerchandiseVo> {

	@Override
	public MerchandiseVo convert(Merchandise d) {
		CouponVo t=new CouponVo();
		Coupon c=(Coupon)d;
		t.setId(c.getId());
		t.setName(c.getName());
		t.setIntegralCount(String.valueOf(c.getIntegralCount()));
		t.setStock(String.valueOf(c.getStock()));
		t.setRemark(c.getRemark());
		if(d.getMedias()!=null){
			Set<String> set=new HashSet<String>();
			for(MediaContent media:c.getMedias()){
				set.add(media.getUrl());
				t.setPics(set);
			}
		}
		if(c.getBrand()!=null){
			t.setBrandName(c.getBrand().getName());
		}
		if(c.getClassify()!=null){
			t.setClassifyName(c.getClassify().getName());
		}
		if(c.getExpiryDate()!=null){
			t.setExpiryTime(c.getExpiryDate().format(DateTimeFormatter.ISO_DATE));
		}else{
			t.setExpiryTime("");
		}
		t.setAddress(c.getAddress());
		t.setShopName(c.getShopName());
		t.setLongitude(c.getLongitude());
		t.setLatitude(c.getLatitude());
		return t;
	}
	@Override
	public MerchandiseVo convertSimple(Merchandise d) {
		Coupon c=(Coupon)d;
		CouponVo t=new CouponVo();
		t.setId(c.getId());
		t.setName(c.getName());
		t.setIntegralCount(String.valueOf(c.getIntegralCount()));
		t.setStock(String.valueOf(c.getStock()));
		if(c.getBrand()!=null){
			t.setBrandName(c.getBrand().getName());
		}
		if(c.getClassify()!=null){
			t.setClassifyName(c.getClassify().getName());
		}
		if(c.getMainPicMedia()!=null){
			t.setMainPic(c.getMainPicMedia().getUrl());
		}
		if(c.getExpiryDate()!=null){
			t.setExpiryTime(c.getExpiryDate().format(DateTimeFormatter.ISO_DATE));
		}else{
			t.setExpiryTime("");
		}
		t.setAddress(c.getAddress());
		t.setShopName(c.getShopName());
		t.setLongitude(c.getLongitude());
		t.setLatitude(c.getLatitude());
		return t;
	}
	
}
