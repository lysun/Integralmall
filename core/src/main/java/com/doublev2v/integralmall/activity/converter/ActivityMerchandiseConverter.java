package com.doublev2v.integralmall.activity.converter;

import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.common.SimpleDtoConverter;
import com.doublev2v.integralmall.activity.entity.ActivityMerchandise;
import com.doublev2v.integralmall.merchandise.Merchandise;
import com.doublev2v.integralmall.util.DateUtil;

@Component
public class ActivityMerchandiseConverter extends SimpleDtoConverter<Merchandise, ActivityMerchandise> {
	@Override
	public ActivityMerchandise convert(Merchandise d) {
		ActivityMerchandise t = new ActivityMerchandise();
		t.setBrief(d.getBrief());
		if(d.getEndDate()!=null)
			t.setEnd(DateUtil.format(d.getEndDate()).substring(0, 10));
		if(d.getStartDate()!=null)
			t.setStart(DateUtil.format(d.getStartDate()).substring(0, 10));
		t.setIntegralCount(String.valueOf(d.getIntegralCount()));
		if(d.getMainPicMedia()!=null){
			t.setMainPic(d.getMainPicMedia().getUrl());
		}
		t.setId(d.getId());
		t.setName(d.getName());
		t.setStock(String.valueOf(d.getStock()));
		t.setType(d.getType());
		return t;
	}
	@Override
	public ActivityMerchandise convertSimple(Merchandise d) {
		ActivityMerchandise t = new ActivityMerchandise();
		t.setBrief(d.getBrief());
		if(d.getEndDate()!=null)
			t.setEnd(DateUtil.format(d.getEndDate()).substring(0, 10));
		if(d.getStartDate()!=null)
			t.setStart(DateUtil.format(d.getStartDate()).substring(0, 10));
		t.setIntegralCount(String.valueOf(d.getIntegralCount()));
		if(d.getMainPicMedia()!=null){
			t.setMainPic(d.getMainPicMedia().getUrl());
		}
		t.setId(d.getId());
		t.setName(d.getName());
		t.setStock(String.valueOf(d.getStock()));
		t.setType(d.getType());
		return t;
	}
	
}
