package com.doublev2v.integralmall.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doublev2v.integralmall.merchandise.dto.MerchandiseVoConverter;
import com.doublev2v.integralmall.merchandise.dto.MerchandiseVoService;
import com.doublev2v.integralmall.util.Constant;
import com.doublev2v.integralmall.util.RequestResult;

@RestController("merchandiseRestController")
public class MerchandiseController{

	@Autowired
	private MerchandiseVoService service;
	@Autowired
	private MerchandiseVoConverter voConverter;
	/**
	 * 获取实物商品列表
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value="/giftsList",method=RequestMethod.GET)
	public String merchandises(@RequestParam(defaultValue="1") Integer page, 
			@RequestParam(defaultValue="5") Integer size) {
		return RequestResult.success(service.getActual(page, size, Constant.ACTUAL)).toJson();
	}
	/**
	 * 获取附近商家列表
	 * @param page
	 * @param size
	 * @param localAddress
	 * @return
	 */
	@RequestMapping(value="/couponList",method=RequestMethod.GET)
	public String merchandises(@RequestParam(defaultValue="1") Integer page,
			@RequestParam(defaultValue="5") Integer size,String localAddress) {
		return RequestResult.success(service.getVirtual(page, size,Constant.VIRTUAL,localAddress)).toJson();
	}
	/**
	 * 获取实物商品详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/giftDetail",method=RequestMethod.GET)
	public String giftDetail(String id) {
		return RequestResult.success(service.findOne(id)).toJson();
	}
	/**
	 * 获取某个商品
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/couponDetail",method=RequestMethod.GET)
	public String couponDetail(String id) {
		return RequestResult.success(service.findOne(id)).toJson();
	}
	
	
}
