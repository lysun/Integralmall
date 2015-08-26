package com.doublev2v.integralmall.tag.shop;

import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.polymorphism.SimplePolymorphismConverter;
import com.doublev2v.integralmall.tag.Tag;
import com.doublev2v.integralmall.tag.dto.TagDto;
@Component
public class ShopTagDtoConverter extends SimplePolymorphismConverter<ShopTag,ShopTagDto,Tag, TagDto> {
	
}
