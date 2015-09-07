package com.doublev2v.integralmall.activity.converter;

import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.polymorphism.SimplePolymorphismConverter;
import com.doublev2v.integralmall.activity.entity.ActivityGift;
import com.doublev2v.integralmall.activity.entity.ActivityMerchandise;
import com.doublev2v.integralmall.merchandise.Gift;
import com.doublev2v.integralmall.merchandise.Merchandise;
import com.doublev2v.integralmall.util.DateUtil;
@Component
public class ActivityGiftConverter extends SimplePolymorphismConverter<Gift, ActivityGift,Merchandise,ActivityMerchandise> {

	@Override
	public ActivityMerchandise convert(Merchandise d) {
		ActivityGift t = new ActivityGift();
		t.setBrief(d.getBrief());
		if(d.getEndDate()!=null)
			t.setEnd(DateUtil.format(d.getEndDate()).substring(0, 10));
		if(d.getStartDate()!=null)
			t.setStart(DateUtil.format(d.getStartDate()).substring(0,10));
		t.setIntegralCount(String.valueOf(d.getIntegralCount()));
		if(d.getMainPicMedia()!=null){
			t.setMainPic(d.getMainPicMedia().getUrl());
		}
		t.setId(d.getId());
		t.setName(d.getName());
		t.setStock(String.valueOf(d.getStock()));
		return t;
	}
	@Override
	public ActivityMerchandise convertSimple(Merchandise d) {
		ActivityGift t = new ActivityGift();
		t.setIntegralCount(String.valueOf(d.getIntegralCount()));
		t.setBrief(d.getBrief());
		if(d.getEndDate()!=null)
			t.setEnd(DateUtil.format(d.getEndDate()).substring(0, 10));
		if(d.getStartDate()!=null)
			t.setStart(DateUtil.format(d.getStartDate()).substring(0,10));
		if(d.getMainPicMedia()!=null){
			t.setMainPic(d.getMainPicMedia().getUrl());
		}
		t.setId(d.getId());
		t.setName(d.getName());
		t.setStock(String.valueOf(d.getStock()));
		return t;
	}
	
}
