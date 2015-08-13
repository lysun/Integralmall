package com.doublev2v.integralmall.merchandise.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.SimpleAbstractDtoAdater;
import com.doublev2v.foundation.core.dto.polymorphic.PolymorphicConverter;
import com.doublev2v.integralmall.merchandise.Merchandise;

@Component
public class MerchandiseVoAdapter extends SimpleAbstractDtoAdater<Merchandise, MerchandiseVO> {
	@Autowired
	private List<PolymorphicConverter<Merchandise, MerchandiseVO>> converters;
	
	public MerchandiseVO convert(Merchandise d) {
		for (PolymorphicConverter<Merchandise, MerchandiseVO> converter : converters) {
			if(converter.support(d)) {
				return converter.convert(d);
			}
		}
		throw new RuntimeException("没有合适的转换器");
	}
	
	@Override
	public MerchandiseVO convertSimple(Merchandise d) {
		for (PolymorphicConverter<Merchandise, MerchandiseVO> converter : converters) {
			if(converter.support(d)) {
				MerchandiseVO dto=converter.convertSimple(d);
				return dto;
			}
		}
		throw new RuntimeException("没有合适的转换器");
	}
}
