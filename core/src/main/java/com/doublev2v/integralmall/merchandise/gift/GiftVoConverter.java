package com.doublev2v.integralmall.merchandise.gift;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.polymorphism.SimplePolymorphismConverter;
import com.doublev2v.foundation.media.MediaContent;
import com.doublev2v.integralmall.merchandise.Merchandise;
import com.doublev2v.integralmall.merchandise.dto.MerchandiseVo;
@Component
public class GiftVoConverter extends SimplePolymorphismConverter<Gift, GiftVo,Merchandise,MerchandiseVo> {

	/**
	 * 重写实体转换
	 */
	@Override
	public MerchandiseVo convert(Merchandise d) {
		Gift g=(Gift)d;
		GiftVo t=new GiftVo();
		t.setId(g.getId());
		t.setName(g.getName());
		t.setIntegralCount(String.valueOf(g.getIntegralCount()));
		t.setStock(String.valueOf(g.getStock()));
		t.setRemark(g.getRemark());
		if(g.getMedias()!=null){
			Set<String> set=new HashSet<String>();
			for(MediaContent media:g.getMedias()){
				set.add(media.getUrl());
				t.setPics(set);
			}
		}
		return t;
	}
	
	@Override
	public MerchandiseVo convertSimple(Merchandise d) {
		Gift g=(Gift)d;
		GiftVo t=new GiftVo();
		t.setId(g.getId());
		t.setName(g.getName());
		t.setIntegralCount(String.valueOf(g.getIntegralCount()));
		t.setStock(String.valueOf(g.getStock()));
		if(g.getBrand()!=null){
			t.setBrandName(g.getBrand().getName());
		}
		if(d.getClassify()!=null){
			t.setClassifyName(g.getClassify().getName());
		}
		if(d.getMainPicMedia()!=null){
			t.setMainPic(g.getMainPicMedia().getUrl());
		}
		t.setPrice(String.valueOf(g.getPrice()));
		return t;
	}
	
	
}
