package com.doublev2v.integralmall.auth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.doublev2v.integralmall.auth.user.User;
@Component(value="tokenAuthFilter")
public class TokenFilter extends GenericFilterBean{

	@Autowired
	private UserAuthService service;
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		SecurityContext context=SecurityContextHolder.getContext();
		Authentication oldAuthentication = context.getAuthentication();

		HttpServletRequest req=(HttpServletRequest)request;
		System.out.println(req.getServletPath());//获取请求的uri
		
		//如果SecurityContext中已经有auth信息，则不会再次验证
		if(oldAuthentication!=null && oldAuthentication.isAuthenticated()) {
			chain.doFilter(request, response);
			return;
		}
		String token=request.getParameter("token");
		if(token==null){
			
			chain.doFilter(request, response);
			return;
		}
		User user=service.authenticate(token);//根据token验证用户信息
		if(user!=null){
			//自定义登陆认证，将权限及用户信息存入SecurityContext
			UsernamePasswordAuthenticationToken auth=
					new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword(),user.getAuthorities());
			auth.setDetails(user);
			context.setAuthentication(auth);
			SecurityContextHolder.setContext(context);
		}
		chain.doFilter(request, response);
		
	}

	

}
