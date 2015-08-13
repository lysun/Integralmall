package com.doublev2v.integralmall.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doublev2v.foundation.core.model.PagedList;
import com.doublev2v.integralmall.merchandise.MerchandiseService;
import com.doublev2v.integralmall.merchandise.dto.MerchandiseVO;
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
	@RequestMapping(value="/giftsList",method=RequestMethod.GET)
	public String merchandises(@RequestParam(defaultValue="1") Integer page, 
			@RequestParam(defaultValue="5") Integer size) {
		PagedList<MerchandiseVO> list=service.getMerchandiseVOs(page, size, Constant.ACTUAL);
		return RequestResult.success(list).toJson();
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
		PagedList<MerchandiseVO> list=service.getNearByMerchandises(page, size,localAddress);
		return RequestResult.success(list).toJson();
	}
	/**
	 * 获取实物商品详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/giftDetail",method=RequestMethod.GET)
	public String giftDetail(String id) {
		return RequestResult.success(service.getMerchandiseVO(id)).toJson();
	}
	/**
	 * 获取某个商品
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/couponDetail",method=RequestMethod.GET)
	public String couponDetail(String id) {
		return RequestResult.success(service.getMerchandiseVO(id)).toJson();
	}
	
	
}
