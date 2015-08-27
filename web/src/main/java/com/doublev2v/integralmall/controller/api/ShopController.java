package com.doublev2v.integralmall.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doublev2v.foundation.core.model.PagedList;
import com.doublev2v.integralmall.shop.dto.ShopVo;
import com.doublev2v.integralmall.shop.dto.ShopVoService;
import com.doublev2v.integralmall.util.RequestResult;
@RestController("shopRestController")
public class ShopController{
	@Autowired
	private ShopVoService service;
	
	@RequestMapping(value="/getShops",method=RequestMethod.GET)
	public String getShops(@RequestParam(defaultValue="1")Integer page,
			@RequestParam(defaultValue="5")Integer size
			,String classifyId,String tagId){
		PagedList<ShopVo> list=service.findPage(page, size,classifyId,tagId); 
		return RequestResult.success(list).toJson();
	}
	
	@RequestMapping(value="/getShop",method=RequestMethod.GET)
	public String getShop(String id){
		return RequestResult.success(service.findOne(id)).toJson();
	}
}
