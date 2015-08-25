package com.doublev2v.integralmall.controller.admin;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doublev2v.integralmall.auth.user.User;
import com.doublev2v.integralmall.auth.user.UserService;

@Controller
public class LoginController{
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView loginView(){
		return new ModelAndView("login");
	}
	@RequestMapping(value="/admin",method=RequestMethod.GET)
	public ModelAndView admin(){
		return new ModelAndView("admin/index");
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)  
	public ModelAndView submit(String username, String password) {
	    User user = userService.findByUsername(username);
    	if(user==null)
    		throw new IllegalArgumentException("传入参数错误");
        try {
            // 如果登陆成功  
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user  
                        .getPassword());  
                Subject subject = SecurityUtils.getSubject();  
                subject.login(token);
                subject.getSession().setTimeout(1000*60*30);//设置session有效时间为30分钟
                return new ModelAndView("redirect:/admin");  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return new ModelAndView("redirect:/login");  
    } 
	    
	
}
