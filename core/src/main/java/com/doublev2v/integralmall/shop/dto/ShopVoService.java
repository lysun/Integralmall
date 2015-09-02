package com.doublev2v.integralmall.shop.dto;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.dto.AbstractDtoPagingService;
import com.doublev2v.foundation.core.model.PagedList;
import com.doublev2v.foundation.dics.CategoryItem;
import com.doublev2v.foundation.dics.CategoryItemService;
import com.doublev2v.integralmall.shop.Shop;
import com.doublev2v.integralmall.shop.ShopService;
import com.doublev2v.integralmall.tag.Tag;
import com.doublev2v.integralmall.tag.TagService;
@Service
public class ShopVoService extends AbstractDtoPagingService<Shop,ShopVo,String>{
	@Autowired
	private ShopVoConverter voConverter;
	@Autowired
	private ShopService service;
	@Autowired
	private CategoryItemService categoryItemService;
	@Autowired
	private TagService tagService;
	
	public PagedList<ShopVo> findPage(Integer pageNo,Integer pageSize,String classifyId,String tagId){
		Pageable page=new PageRequest(pageNo-1, pageSize);
		CategoryItem classify=null;
		Tag tag=null;
		if(StringUtils.isNotBlank(classifyId)){
			classify=categoryItemService.findOne(classifyId);
		}
		if(StringUtils.isNotBlank(tagId)){
			tag=tagService.findOne(tagId);
		}
		Page<Shop> list=service.findPage(page, null,classify,tag);
		List<ShopVo> listDetail=
				new ArrayList<ShopVo>(voConverter.convertSimples(list.getContent()));
		Page<ShopVo> result=new PageImpl<ShopVo>(listDetail,page,list.getTotalElements());
		return new PagedList<ShopVo>(result);
	}
}
