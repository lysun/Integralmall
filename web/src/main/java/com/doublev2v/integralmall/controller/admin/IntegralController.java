package com.doublev2v.integralmall.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doublev2v.foundation.core.service.PagingService;
import com.doublev2v.integralmall.integral.Integral;
import com.doublev2v.integralmall.integral.IntegralService;
import com.doublev2v.integralmall.util.RequestResult;

@Controller
@RequestMapping("/admin/integral")
public class IntegralController extends SimpleController<Integral> {
	
	@Autowired
	private IntegralService service;
	
	@Override
	protected PagingService<Integral, String> getService() {
		return service;
	}

	@Override
	protected String getMenuTab() {
		return "integral";
	}

	@RequestMapping(value="/getlistdata",method=RequestMethod.GET)
	@ResponseBody
	public String getlist(@RequestParam(defaultValue="1") Integer page, @RequestParam(defaultValue="12") Integer size,
			String search) {
		return RequestResult.success(service.findPage(page, size,search)).toJson();
	}
	
	@RequestMapping(value="/validateAccount",method=RequestMethod.GET)
	@ResponseBody
	public String validateForm(String account){
		service.validateForm(account);
		return RequestResult.success(null).toJson();
	}
}
