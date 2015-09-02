package com.doublev2v.integralmall.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doublev2v.foundation.core.model.PagedList;
import com.doublev2v.integralmall.shop.branch.BranchShopVo;
import com.doublev2v.integralmall.shop.branch.BranchShopVoService;
import com.doublev2v.integralmall.util.RequestResult;
@RestController("shopRestController")
public class BranchShopController{
	@Autowired
	private BranchShopVoService service;
	/**
	 * 根据标签或分类获取商户信息
	 * @param page
	 * @param size
	 * @param classifyId
	 * @param tagId
	 * @return
	 */
	@RequestMapping(value="/getShops",method=RequestMethod.GET)
	public String getShops(@RequestParam(defaultValue="1")Integer page,
			@RequestParam(defaultValue="5")Integer size
			,String classifyId,String tagId){
		PagedList<BranchShopVo> list=service.findPage(page, size,classifyId,tagId); 
		return RequestResult.success(list).toJson();
	}
	
	@RequestMapping(value="/getShop",method=RequestMethod.GET)
	public String getShop(String id){
		return RequestResult.success(service.findOne(id)).toJson();
	}
}
