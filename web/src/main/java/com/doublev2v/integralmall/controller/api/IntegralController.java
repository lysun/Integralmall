package com.doublev2v.integralmall.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doublev2v.integralmall.integral.IntegralService;
import com.doublev2v.integralmall.util.RequestResult;
@RestController("integralRestController")
public class IntegralController{
	@Autowired
	private IntegralService service;
	/**
	 * 获取用户可用积分
	 */
	@RequestMapping(value="/user/{id}/integral",method=RequestMethod.GET)
	public String getUserIntegral(@PathVariable String id) {
		return RequestResult.success(service.getIntegralCount(id)).toJson();
	}
}
