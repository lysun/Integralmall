package com.doublev2v.integralmall.controller.api;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doublev2v.foundation.core.model.PagedList;
import com.doublev2v.integralmall.order.IntegralOrderService;
import com.doublev2v.integralmall.order.dto.IntegralOrderDetail;
import com.doublev2v.integralmall.util.RequestResult;

@RestController("integralOrderRestController")
public class IntegralOrderController{

	@Autowired
	private IntegralOrderService service;
	
	/**
	 * 创建积分订单
	 */
	@RequestMapping(value="/integralOrder",method=RequestMethod.POST)
	public String createIntegralOrder(String merchandiseId,String userId) {
		service.order(merchandiseId,userId);
		return RequestResult.success(null).toJson();
	}
	
	/**
	 * 获取积分订单列表
	 * @param page
	 * @param size
	 * @param userId
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value="/user/{userId}/integralOrders",method=RequestMethod.GET)
	public String integralOrders(@RequestParam(defaultValue="1") Integer page, @RequestParam(defaultValue="5") Integer size,
			@PathVariable String userId) throws ParseException {
		PagedList<IntegralOrderDetail> list=service.getList(page, size, userId);
		return RequestResult.success(list).toJson();
	}
	/**
	 * 取消积分订单
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/cancelIntegralOrder/{id}",method=RequestMethod.POST)
	public String cancelIntegralOrder(@PathVariable String id) {
		service.cancelOrder(id);
		return RequestResult.success(null).toJson();
	}
	
	/**
	 * 获取某个订单
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/integralOrder/{id}",method=RequestMethod.GET)
	public String integralOrder(@PathVariable String id) {
		return RequestResult.success(service.getIntegralOrderDetail(id)).toJson();
	}
	
}
