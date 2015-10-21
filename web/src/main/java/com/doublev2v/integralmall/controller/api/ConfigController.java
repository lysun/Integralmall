package com.doublev2v.integralmall.controller.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doublev2v.integralmall.config.ConfigService;
import com.doublev2v.integralmall.util.RequestResult;

@RestController
public class ConfigController {

	@Autowired
	private ConfigService service;
	
	@RequestMapping(value="liveAddress",method=RequestMethod.GET)
	public String getAddress() {
		Map<String, String> result=service.getLiveAddress();
		return RequestResult.success(result).toJson();
	}
}
