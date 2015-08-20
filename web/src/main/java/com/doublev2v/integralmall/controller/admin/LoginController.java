package com.doublev2v.integralmall.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController{
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView loginView(){
		return new ModelAndView("login");
	}

	
}
