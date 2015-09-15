package com.doublev2v.integralmall.controller.api;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doublev2v.foundation.core.model.PagedList;
import com.doublev2v.integralmall.find.entity.IntegralOrderVo;
import com.doublev2v.integralmall.find.service.IntegralOrderVoService;
import com.doublev2v.integralmall.order.IntegralOrderService;
import com.doublev2v.integralmall.userinfo.token.UserInfoTokenService;
import com.doublev2v.integralmall.util.RequestResult;

@RestController("integralOrderRestController")
public class IntegralOrderController{

	@Autowired
	private IntegralOrderVoService voService;
	@Autowired
	private IntegralOrderService service;
	@Autowired
	private UserInfoTokenService userInfoTokenService;
	/**
	 * 兑换商品
	 */
	@RequestMapping(value="/exchangeCoupon",method=RequestMethod.POST)
	public String createIntegralOrder(String merchandiseId,String token,String addressId) {
		service.order(userInfoTokenService.getUser(token),merchandiseId,addressId);
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
			@RequestParam(defaultValue="5") Integer size,String token,String localAddress) throws ParseException {
		PagedList<IntegralOrderVo> list=voService.getList(page, size, userInfoTokenService.getUser(token),localAddress);
		return RequestResult.success(list).toJson();
	}

	/**
	 * 获取某个订单
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/myCouponOrGoodDetail",method=RequestMethod.GET)
	public String integralOrder(String id,String localAddress) {
		return RequestResult.success(voService.findOne(id,localAddress)).toJson();
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
