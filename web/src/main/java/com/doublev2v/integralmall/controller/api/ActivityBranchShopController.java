package com.doublev2v.integralmall.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doublev2v.foundation.core.model.PagedList;
import com.doublev2v.foundation.dics.CategoryItemDtoService;
import com.doublev2v.integralmall.activity.entity.ActivityBranchShop;
import com.doublev2v.integralmall.activity.service.ActivityBranchShopService;
import com.doublev2v.integralmall.util.RequestResult;
@RestController("shopRestController")
public class ActivityBranchShopController{
	@Autowired
	private ActivityBranchShopService service;
	@Autowired
	private CategoryItemDtoService categoryItemService;
	
	/**
	 * 根据标签获取商户信息
	 * @param page
	 * @param size
	 * @param classifyId
	 * @param tagId
	 * @return
	 */
	@RequestMapping(value="/getShops",method=RequestMethod.GET)
	public String getShops(@RequestParam(defaultValue="1")Integer page,
			@RequestParam(defaultValue="5")Integer size,String tagId){
		PagedList<ActivityBranchShop> list=service.findPage(page, size,tagId); 
		return RequestResult.success(list).toJson();
	}
	
	@RequestMapping(value="/getShop",method=RequestMethod.GET)
	public String getShop(String shopId){
		return RequestResult.success(service.findOne(shopId)).toJson();
	}
}
