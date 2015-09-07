package com.doublev2v.integralmall.merchandise.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.common.SimpleDtoConverter;
import com.doublev2v.foundation.core.dto.polymorphism.PolymorphismConverter;
import com.doublev2v.integralmall.merchandise.Merchandise;

@Component
public class ActivityMerchandiseConverter extends SimpleDtoConverter<Merchandise, ActivityMerchandise> {
	@Autowired
	private List<PolymorphismConverter<Merchandise, ActivityMerchandise>> converters;
	
	public ActivityMerchandise convert(Merchandise d) {
		for (PolymorphismConverter<Merchandise, ActivityMerchandise> converter : converters) {
			if(converter.supportD(d)) {
				return converter.convert(d);
			}
		}
		throw new RuntimeException("没有合适的转换器");
	}
	
	@Override
	public ActivityMerchandise convertSimple(Merchandise d) {
		for (PolymorphismConverter<Merchandise, ActivityMerchandise> converter : converters) {
			if(converter.supportD(d)) {
				ActivityMerchandise dto=converter.convertSimple(d);
				return dto;
			}
		}
		throw new RuntimeException("没有合适的转换器");
	}
}
