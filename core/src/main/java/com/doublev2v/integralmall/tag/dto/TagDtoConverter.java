package com.doublev2v.integralmall.tag.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.common.SimpleDtoConverter;
import com.doublev2v.foundation.core.dto.polymorphism.PolymorphismConverter;
import com.doublev2v.integralmall.tag.Tag;
@Component
public class TagDtoConverter extends SimpleDtoConverter<Tag, TagDto>{
	@Autowired
	private List<PolymorphismConverter<Tag,TagDto>> adapters;

	@Override
	public TagDto convert(Tag d) {
		for (PolymorphismConverter<Tag, TagDto> adapter : adapters) {
			if(adapter.supportD(d)){
				return adapter.convert(d);
			}
		}
		throw new RuntimeException("没有合适的转换器");
	}
	
	
	@Override
	public Tag convertD(TagDto t) {
		for (PolymorphismConverter<Tag, TagDto> adapter : adapters) {
			if(adapter.supportT(t)){
				return adapter.convertD(t);
			}
		}
		throw new RuntimeException("没有合适的转换器");
	}
	
	@Override
	public Tag update(TagDto t, Tag d) {
		for (PolymorphismConverter<Tag, TagDto> adapter : adapters) {
			if(adapter.supportT(t)){
				return adapter.update(t,d);
			}
		}
		throw new RuntimeException("没有合适的转换器");
	}
	
}
