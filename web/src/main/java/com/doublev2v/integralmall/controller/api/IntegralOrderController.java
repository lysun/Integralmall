package com.doublev2v.integralmall.controller.api;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doublev2v.foundation.core.model.PagedList;
import com.doublev2v.integralmall.order.IntegralOrderService;
import com.doublev2v.integralmall.order.dto.IntegralOrderVO;
import com.doublev2v.integralmall.order.dto.IntegralOrderVoService;
import com.doublev2v.integralmall.user.token.UserTokenService;
import com.doublev2v.integralmall.util.RequestResult;

@RestController("integralOrderRestController")
public class IntegralOrderController{

	@Autowired
	private IntegralOrderVoService voService;
	@Autowired
	private IntegralOrderService service;
	@Autowired
	private UserTokenService userTokenService;
	/**
	 * 兑换商品
	 */
	@RequestMapping(value="/exchangeCoupon",method=RequestMethod.POST)
	public String createIntegralOrder(String merchandiseId,String token,String addressId) {
		String userId=userTokenService.getUser(token).getId();
		service.order(merchandiseId,userId,addressId);
		return RequestResult.success(null).toJson();
	}
	
	/**
	 * 获取我的列表
	 * @param page
	 * @param size
	 * @param userId
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value="/myCouponsList",method=RequestMethod.GET)
	public String integralOrders(@RequestParam(defaultValue="1") Integer page,
			@RequestParam(defaultValue="5") Integer size,String token) throws ParseException {
		String userId=userTokenService.getUser(token).getId();
		PagedList<IntegralOrderVO> list=voService.getList(page, size, userId);
		return RequestResult.success(list).toJson();
	}

	/**
	 * 获取某个订单
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/myCouponDetail",method=RequestMethod.GET)
	public String integralOrder(String id) {
		return RequestResult.success(voService.findOne(id)).toJson();
	}
	
	/**
	 * 取消积分订单
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/cancelCoupon",method=RequestMethod.POST)
	public String cancelIntegralOrder(String id) {
		service.cancelOrder(id);
		return RequestResult.success(null).toJson();
	}
	
}
