package com.doublev2v.integralmall.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doublev2v.integralmall.coupons.CouponsService;
import com.doublev2v.integralmall.coupons.Coupons.CouponsType;

@Controller
public class CouponsController {
	
	@Autowired
	private CouponsService service;

	@RequestMapping(value="coupons/check",method=RequestMethod.GET)
	public ModelAndView checkCoupons() {
		return new ModelAndView("coupons/check");
	}
	
	@RequestMapping(value="coupons/result",method=RequestMethod.POST)
	public ModelAndView checkResult(String account, CouponsType type) {
		ModelAndView view=new ModelAndView("coupons/result");
		boolean hasUsed=service.hasUsed(account, type);
		view.addObject("account", account);
		view.addObject("type", type);
		view.addObject("hasUsed", hasUsed);
		return view;
	}
	
	@RequestMapping(value="coupons/use",method=RequestMethod.POST)
	public ModelAndView useCoupons(String account, CouponsType type) {
		service.useCoupons(account, type);
		return new ModelAndView("coupons/success");
	}
}
