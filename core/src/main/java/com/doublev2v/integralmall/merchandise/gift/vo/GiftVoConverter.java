package com.doublev2v.integralmall.merchandise.gift.vo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.polymorphism.SimplePolymorphismConverter;
import com.doublev2v.foundation.media.MediaContent;
import com.doublev2v.integralmall.merchandise.Merchandise;
import com.doublev2v.integralmall.merchandise.dto.MerchandiseVO;
import com.doublev2v.integralmall.merchandise.gift.Gift;
@Component
public class GiftVoConverter extends SimplePolymorphismConverter<Gift, GiftVO,Merchandise,MerchandiseVO> {

	/**
	 * 重写实体转换
	 */
	@Override
	public MerchandiseVO convert(Merchandise d) {
		Gift g=(Gift)d;
		GiftVO t=new GiftVO();
		t.setId(g.getId());
		t.setName(g.getName());
		t.setIntegralCount(g.getIntegralCount());
		t.setStock(g.getStock());
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
	public MerchandiseVO convertSimple(Merchandise d) {
		Gift g=(Gift)d;
		GiftVO t=new GiftVO();
		t.setId(g.getId());
		t.setName(g.getName());
		t.setIntegralCount(g.getIntegralCount());
		t.setStock(g.getStock());
		if(g.getBrand()!=null){
			t.setBrandName(g.getBrand().getName());
		}
		if(d.getClassify()!=null){
			t.setClassifyName(g.getClassify().getName());
		}
		if(d.getMainPicMedia()!=null){
			t.setMainPic(g.getMainPicMedia().getUrl());
		}
		t.setPrice(g.getPrice());
		return t;
	}
	
	
}
