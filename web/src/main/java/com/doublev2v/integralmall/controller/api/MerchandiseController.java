package com.doublev2v.integralmall.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doublev2v.foundation.core.model.PagedList;
import com.doublev2v.integralmall.merchandise.MerchandiseService;
import com.doublev2v.integralmall.merchandise.dto.MerchandiseDetail;
import com.doublev2v.integralmall.util.Constant;
import com.doublev2v.integralmall.util.RequestResult;
@RestController("merchandiseRestController")
public class MerchandiseController{

	@Autowired
	private MerchandiseService service;

	/**
	 * 获取实物商品列表
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value="/merchandises/actual",method=RequestMethod.GET)
	public String merchandises(@RequestParam(defaultValue="1") Integer page, @RequestParam(defaultValue="5") Integer size) {
		PagedList<MerchandiseDetail> list=service.getMerchandiseDetails(page, size, Constant.ACTUAL);
		return RequestResult.success(list).toJson();
	}
	/**
	 * 获取附近商家列表
	 * @param page
	 * @param size
	 * @param localAddress
	 * @return
	 */
	@RequestMapping(value="/merchandises/nearby",method=RequestMethod.GET)
	public String merchandises(@RequestParam(defaultValue="1") Integer page, @RequestParam(defaultValue="5") Integer size,
			String localAddress) {
		PagedList<MerchandiseDetail> list=service.getNearByMerchandises(page, size,localAddress);
		return RequestResult.success(list).toJson();
	}
	/**
	 * 获取某个商品
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/merchandise/{id}",method=RequestMethod.GET)
	public String merchandise(@PathVariable String id) {
		return RequestResult.success(service.getMerchandiseDetail(id)).toJson();
	}
	
	
	
}
