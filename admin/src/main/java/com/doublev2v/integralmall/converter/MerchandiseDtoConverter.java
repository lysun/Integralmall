package com.doublev2v.integralmall.converter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.common.SimpleDtoConverter;
import com.doublev2v.foundation.core.dto.polymorphism.PolymorphismConverter;
import com.doublev2v.integralmall.entity.MerchandiseDto;
import com.doublev2v.integralmall.merchandise.Merchandise;

@Component
public class MerchandiseDtoConverter extends SimpleDtoConverter<Merchandise, MerchandiseDto> {
	
	@Autowired
	private List<PolymorphismConverter<Merchandise,MerchandiseDto>> adapters;

	@Override
	public MerchandiseDto convert(Merchandise d) {
		for (PolymorphismConverter<Merchandise, MerchandiseDto> adapter : adapters) {
			if(adapter.supportD(d)){
				return adapter.convert(d);
			}
		}
		throw new RuntimeException("没有合适的转换器");
	}
	
	
	@Override
	public Merchandise convertD(MerchandiseDto t) {
		for (PolymorphismConverter<Merchandise, MerchandiseDto> adapter : adapters) {
			if(adapter.supportT(t)){
				return adapter.convertD(t);
			}
		}
		throw new RuntimeException("没有合适的转换器");
	}
	
	@Override
	public Merchandise update(MerchandiseDto t, Merchandise d) {
		for (PolymorphismConverter<Merchandise, MerchandiseDto> adapter : adapters) {
			if(adapter.supportT(t)){
				return adapter.update(t,d);
			}
		}
		throw new RuntimeException("没有合适的转换器");
	}
	
}
