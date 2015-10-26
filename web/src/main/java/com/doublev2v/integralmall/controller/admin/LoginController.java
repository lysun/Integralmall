package com.doublev2v.integralmall.controller.admin;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.doublev2v.integralmall.auth.menu.MenuService;
import com.doublev2v.integralmall.auth.user.UserService;
import com.doublev2v.integralmall.util.RequestResult;

@Controller
public class LoginController{
	
	@Autowired
	private UserService userService;
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)  
	public ModelAndView submit(String username, String password) {
	    try {
        	UsernamePasswordToken token = new UsernamePasswordToken(username, password);  
            Subject subject = SecurityUtils.getSubject();  
            subject.login(token);
            if(subject.isPermitted("user:list"))
            	return new ModelAndView("redirect:/admin/user");
            else
            	return new ModelAndView("redirect:/admin/merchandise"); 
        } catch (Exception e) {  
            e.printStackTrace();  
        }
        return new ModelAndView("redirect:/login");  
    } 
	    
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView loginView(){
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/admin",method=RequestMethod.GET)
	public ModelAndView admin(){
		ModelAndView view=new ModelAndView("admin/index");
		view.addObject("top", menuService.getTopMenus());
		view.addObject("subMenu", menuService.getSecondMenus("user"));
		return view;
	}
	
	@RequestMapping(value="/changepassword",method=RequestMethod.GET)
	public ModelAndView changepassword(){
		ModelAndView view=new ModelAndView("admin/changepassword");
		return view;
	}
	@RequestMapping(value="/passwordchange",method=RequestMethod.POST)
	@ResponseBody
	public String passwordchange(String password){
		userService.changePassword(SecurityUtils.getSubject().getPrincipal().toString(),password);
		return RequestResult.success(null).toJson();
	}
	
}
