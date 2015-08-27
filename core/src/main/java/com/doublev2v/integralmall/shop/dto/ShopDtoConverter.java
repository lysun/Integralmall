package com.doublev2v.integralmall.shop.dto;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.common.SimpleDtoConverter;
import com.doublev2v.foundation.dics.CategoryItem;
import com.doublev2v.foundation.dics.CategoryItemRepository;
import com.doublev2v.foundation.dics.dto.CategoryItemDtoConverter;
import com.doublev2v.foundation.media.MediaContent;
import com.doublev2v.foundation.media.MediaContentDto;
import com.doublev2v.foundation.media.MediaService;
import com.doublev2v.integralmall.shop.Shop;
import com.doublev2v.integralmall.tag.Tag;
import com.doublev2v.integralmall.tag.TagRepository;
@Component
public class ShopDtoConverter extends SimpleDtoConverter<Shop, ShopDto>{
	
	@Autowired
	private MediaService mediaService;
	@Autowired
	private CategoryItemRepository categoryItemRepository;
	@Autowired
	private CategoryItemDtoConverter categoryItemDtoConverter;
	@Autowired
	private TagRepository tagRepository;
	public ShopDto postConvert(Shop d,ShopDto t){
		if(d.getMainPic()!=null){
			MediaContentDto md=new MediaContentDto();
			md.setId(d.getMainPic().getId());
			md.setUrl(d.getMainPic().getUrl());
			t.setMainPicDto(md);
		}
		if(d.getClassify()!=null){
			t.setClassifyDto(categoryItemDtoConverter.convert(d.getClassify()));
			t.setClassifyId(d.getClassify().getId());
		}
		return t;
	}
	public Shop postConvertD(ShopDto t,Shop d){
		return postUpdate(t, d);
	}
	public Shop postUpdate(ShopDto t,Shop d){
		try {
			if(StringUtils.isNotBlank(t.getMainpicFile().getOriginalFilename())){
				MediaContent media=mediaService.save(t.getMainpicFile());
				d.setMainPic(media);
			}
			if(StringUtils.isNotBlank(t.getClassifyId())){
				CategoryItem classify=categoryItemRepository.findOne(t.getClassifyId());
				d.setClassify(classify);
			}
			if(t.getTagIds()!=null){
				Set<Tag> set=new HashSet<Tag>();
				for(String tagId:t.getTagIds()){
					System.out.println(tagId);
					set.add(tagRepository.findOne(tagId));
				}
				d.setTags(set);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return d;
	}
}
