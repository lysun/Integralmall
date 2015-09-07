package com.doublev2v.integralmall.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doublev2v.foundation.dics.CategoryItemService;
import com.doublev2v.integralmall.util.Dics;
import com.doublev2v.integralmall.util.RequestResult;
@RestController("categoryItemRestController")
public class CategoryItemController{
	@Autowired
	private CategoryItemService service;
	
	@RequestMapping(value="/shopTags",method=RequestMethod.GET)
	public String getTags(){
		return RequestResult.success(service.getCategoryItemsByType(Dics.SHOP_CLASSIFY_TYPE)).toJson();
	}
}
