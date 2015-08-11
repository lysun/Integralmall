package com.doublev2v.integralmall.merchandise.dto;

import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.SimpleAbstractDtoAdater;
import com.doublev2v.foundation.media.MediaContent;
import com.doublev2v.integralmall.merchandise.Merchandise;
import com.doublev2v.integralmall.util.Constant;

@Component
public class MerchandiseDetailAdapter extends SimpleAbstractDtoAdater<Merchandise, MerchandiseDetail> {

	/**
	 * 重写实体转换
	 */
	@Override
	public MerchandiseDetail convert(Merchandise d) {
		MerchandiseDetail t=new MerchandiseDetail();
		t.setId(d.getId());
		t.setName(d.getName());
		t.setIntegralCount(d.getIntegralCount());
		t.setStock(d.getStock());
		t.setRemark(d.getRemark());
		if(d.getMedias()!=null){
			Set<String> set=new HashSet<String>();
			for(MediaContent media:d.getMedias()){
				set.add(media.getUrl());
				t.setPics(set);
			}
		}
		if(Constant.VIRTUAL.equals(d.getIsActual())){
			if(d.getBrand()!=null){
				t.setBrandName(d.getBrand().getName());
			}
			if(d.getClassify()!=null){
				t.setClassifyName(d.getClassify().getName());
			}
			if(d.getExpiryDate()!=null){
				t.setExpiryTime(d.getExpiryDate().format(DateTimeFormatter.ISO_DATE));
			}else{
				t.setExpiryTime("");
			}
			t.setAddress(d.getAddress());
			t.setShopName(d.getShopName());
			t.setLongitude(d.getLongitude());
			t.setLatitude(d.getLatitude());
		}
		return t;
	}
	
	@Override
	public MerchandiseDetail convertSimple(Merchandise d) {
		MerchandiseDetail t=new MerchandiseDetail();
		t.setId(d.getId());
		t.setName(d.getName());
		t.setIntegralCount(d.getIntegralCount());
		t.setStock(d.getStock());
		if(d.getBrand()!=null){
			t.setBrandName(d.getBrand().getName());
		}
		if(d.getClassify()!=null){
			t.setClassifyName(d.getClassify().getName());
		}
		if(d.getMainPicMedia()!=null){
			t.setMainPic(d.getMainPicMedia().getUrl());
		}
		//实物商品才有的信息
		if(Constant.ACTUAL.equals(d.getIsActual())){
			t.setPrice(d.getPrice());
		}
		//代金券才有的信息
		if(Constant.VIRTUAL.equals(d.getIsActual())){
			if(d.getExpiryDate()!=null){
				t.setExpiryTime(d.getExpiryDate().format(DateTimeFormatter.ISO_DATE));
			}else{
				t.setExpiryTime("");
			}
			t.setAddress(d.getAddress());
			t.setShopName(d.getShopName());
			t.setLongitude(d.getLongitude());
			t.setLatitude(d.getLatitude());
		}
		return t;
	}
	
}
