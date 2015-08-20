package com.doublev2v.integralmall.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doublev2v.integralmall.integral.IntegralService;
import com.doublev2v.integralmall.userinfo.token.UserInfoTokenService;
import com.doublev2v.integralmall.util.RequestResult;
@RestController("integralRestController")
public class IntegralController{
	@Autowired
	private IntegralService service;
	@Autowired
	private UserInfoTokenService userTokenService;
	/**
	 * 获取用户可用积分
	 */
	@RequestMapping(value="/myIntegral",method=RequestMethod.GET)
	public String getUserIntegral(String token) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("integral",String.valueOf(service.getIntegralCount(userTokenService.getUser(token))));
		return RequestResult.success(map).toJson();
	}
}
