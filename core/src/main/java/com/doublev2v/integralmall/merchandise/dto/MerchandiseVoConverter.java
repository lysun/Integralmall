package com.doublev2v.integralmall.merchandise.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.SimpleDtoConverter;
import com.doublev2v.foundation.core.dto.polymorphism.PolymorphismConverter;
import com.doublev2v.integralmall.merchandise.Merchandise;

@Component
public class MerchandiseVoConverter extends SimpleDtoConverter<Merchandise, MerchandiseVO> {
	@Autowired
	private List<PolymorphismConverter<Merchandise, MerchandiseVO>> converters;
	
	public MerchandiseVO convert(Merchandise d) {
		for (PolymorphismConverter<Merchandise, MerchandiseVO> converter : converters) {
			if(converter.supportD(d)) {
				return converter.convert(d);
			}
		}
		throw new RuntimeException("没有合适的转换器");
	}
	
	@Override
	public MerchandiseVO convertSimple(Merchandise d) {
		for (PolymorphismConverter<Merchandise, MerchandiseVO> converter : converters) {
			if(converter.supportD(d)) {
				MerchandiseVO dto=converter.convertSimple(d);
				return dto;
			}
		}
		throw new RuntimeException("没有合适的转换器");
	}
}
