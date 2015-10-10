package com.doublev2v.integralmall.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doublev2v.integralmall.integral.IntegralService;
import com.doublev2v.integralmall.integral.detail.IntegralOrigin;
import com.doublev2v.integralmall.userinfo.UserInfoService;
import com.doublev2v.integralmall.userinfo.token.UserInfoTokenService;
import com.doublev2v.integralmall.util.RequestResult;
@RestController("integralRestController")
public class IntegralController{
	@Autowired
	private IntegralService service;
	@Autowired
	private UserInfoTokenService userInfoTokenService;
	@Autowired
	private UserInfoService userInfoService;
	/**
	 * 获取用户可用积分
	 */
	@RequestMapping(value="/myIntegral",method=RequestMethod.GET)
	public String getUserIntegral(String token) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("integral",String.valueOf(service.getIntegralCount(userInfoTokenService.getUser(token))));
		return RequestResult.success(map).toJson();
	}
	
	/**
	 * 获取用户可用积分
	 */
	@RequestMapping(value="/myIntegralCount",method=RequestMethod.GET)
	public String getUserIntegralCount(String userId) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("integral",String.valueOf(service.getIntegralCount(userInfoService.findOne(userId))));
		return RequestResult.success(map).toJson();
	}
	
	/**
	 * 购买商品后给用户添加积分
	 * @param token 用户token
	 * @param integral 增加的积分数
	 * @param origin 积分来源(传入数字)
	 * @return
	 */
	@RequestMapping(value="/plusUserIntegral",method=RequestMethod.GET)
	public String plusUserIntegral(String shopId,String token,String integral) {
		service.plusUserIntegral(shopId,userInfoTokenService.getUser(token), Long.valueOf(integral),IntegralOrigin.BUY_ONLINE);
		return RequestResult.success(null).toJson();
	}
	@RequestMapping(value="/plusUserIntegralCount",method=RequestMethod.GET)
	public String plusUserIntegralCount(String shopId,String userId,String integral) {
		service.plusUserIntegral(shopId,userInfoService.findOne(userId), Long.valueOf(integral),IntegralOrigin.BUY_ONLINE);
		return RequestResult.success(null).toJson();
	}
}
