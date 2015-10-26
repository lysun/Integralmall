package com.doublev2v.integralmall.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.doublev2v.integralmall.util.RequestResult;

@RestController("extraRestController")
public class ExtraController {
	
	@RequestMapping(value="/nikankan",method=RequestMethod.GET)
	public ModelAndView nikankan(){
		ModelAndView view=new ModelAndView("qn/nikankan");
		return view;
	}
	
	@RequestMapping(value="/checking",method=RequestMethod.GET)
	public String checking(){
		Map<String,String> map=new HashMap<String,String>();
		map.put("isChecking","0");
		return RequestResult.success(map).toJson();
	}
}
