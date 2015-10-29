package com.doublev2v.integralmall.controller.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value="admin/liveAddress",method=RequestMethod.GET)
	public ModelAndView manageAddress() {
		Map<String, String> result=service.getLiveAddress();
		ModelAndView view=new ModelAndView("config/liveAddress", result);
		return view;
	}
	
	@RequestMapping(value="admin/liveAddress",method=RequestMethod.POST)
	public @ResponseBody String saveAddress(String live, String backup) {
		service.saveLiveAddress(live, backup);
		return RequestResult.success("保存成功").toJson();
	}
}
