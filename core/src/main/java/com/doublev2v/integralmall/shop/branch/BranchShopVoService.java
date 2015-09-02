package com.doublev2v.integralmall.shop.branch;

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
import com.doublev2v.integralmall.tag.Tag;
import com.doublev2v.integralmall.tag.TagService;
@Service
public class BranchShopVoService extends AbstractDtoPagingService<BranchShop,BranchShopVo,String>{
	@Autowired
	private BranchShopVoConverter voConverter;
	@Autowired
	private BranchShopService service;
	@Autowired
	private CategoryItemService categoryItemService;
	@Autowired
	private TagService tagService;
	
	public PagedList<BranchShopVo> findPage(Integer pageNo,Integer pageSize,String classifyId,String tagId){
		Pageable page=new PageRequest(pageNo-1, pageSize);
		CategoryItem classify=null;
		Tag tag=null;
		if(StringUtils.isNotBlank(classifyId)){
			classify=categoryItemService.findOne(classifyId);
		}
		if(StringUtils.isNotBlank(tagId)){
			tag=tagService.findOne(tagId);
		}
		Page<BranchShop> list=service.findPage(page, null,classify,tag);
		List<BranchShopVo> listDetail=
				new ArrayList<BranchShopVo>(voConverter.convertSimples(list.getContent()));
		Page<BranchShopVo> result=new PageImpl<BranchShopVo>(listDetail,page,list.getTotalElements());
		return new PagedList<BranchShopVo>(result);
	}
}
