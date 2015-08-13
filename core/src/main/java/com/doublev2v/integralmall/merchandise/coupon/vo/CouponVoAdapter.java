package com.doublev2v.integralmall.merchandise.coupon.vo;

import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.polymorphic.SimplePolymorphicConverter;
import com.doublev2v.foundation.media.MediaContent;
import com.doublev2v.integralmall.merchandise.Merchandise;
import com.doublev2v.integralmall.merchandise.coupon.Coupon;
import com.doublev2v.integralmall.merchandise.dto.MerchandiseVO;
@Component
public class CouponVoAdapter extends SimplePolymorphicConverter<Coupon, CouponVO,Merchandise,MerchandiseVO> {

	@Override
	public MerchandiseVO convert(Merchandise d) {
		CouponVO t=new CouponVO();
		Coupon c=(Coupon)d;
		t.setId(c.getId());
		t.setName(c.getName());
		t.setIntegralCount(c.getIntegralCount());
		t.setStock(c.getStock());
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
	public MerchandiseVO convertSimple(Merchandise d) {
		Coupon c=(Coupon)d;
		CouponVO t=new CouponVO();
		t.setId(d.getId());
		t.setName(d.getName());
		t.setIntegralCount(d.getIntegralCount());
		t.setStock(d.getStock());
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
