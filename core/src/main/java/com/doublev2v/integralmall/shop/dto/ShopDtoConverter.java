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
import com.doublev2v.foundation.dics.CategoryItemService;
import com.doublev2v.foundation.dics.dto.CategoryItemDto;
import com.doublev2v.foundation.dics.dto.CategoryItemDtoConverter;
import com.doublev2v.foundation.media.MediaContent;
import com.doublev2v.foundation.media.MediaContentDto;
import com.doublev2v.foundation.media.MediaService;
import com.doublev2v.integralmall.shop.Shop;
import com.doublev2v.integralmall.shop.branch.BranchShopDto;
import com.doublev2v.integralmall.shop.branch.BranchShopDtoConverter;
import com.doublev2v.integralmall.util.Dics;
@Component
public class ShopDtoConverter extends SimpleDtoConverter<Shop, ShopDto>{
	
	@Autowired
	private MediaService mediaService;
	@Autowired
	private CategoryItemRepository categoryItemRepository;
	@Autowired
	private CategoryItemDtoConverter categoryItemDtoConverter;
	@Autowired
	private CategoryItemService categoryItemService;
	@Autowired
	private BranchShopDtoConverter branchShopDtoConverter;
	
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
		if(d.getBranchShops()!=null){
			Set<BranchShopDto> set=new HashSet<BranchShopDto>(
					branchShopDtoConverter.convertTs(d.getBranchShops()));
			t.setBranchs(set);
		}
		if(d.getTags()!=null){
			Set<CategoryItemDto> set=new HashSet<CategoryItemDto>(
					categoryItemDtoConverter.convertTs(d.getTags()));
			t.setTags(set);
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
			if(StringUtils.isNotBlank(t.getTagName())){
				Set<CategoryItem> set=new HashSet<CategoryItem>();
				for(String name:t.getTagName().split("[ ]+")){
					if(StringUtils.isNotBlank(name)){
						CategoryItem tag=categoryItemRepository.findByCategoryTypeAndName(Dics.SHOP_CLASSIFY_TYPE,name);
						if(tag==null){
							tag=categoryItemService.create(Dics.SHOP_CLASSIFY_TYPE, name);
						}
						set.add(tag);
					}
					
				}
				d.setTags(set);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return d;
	}
}
