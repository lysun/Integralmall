package com.doublev2v.integralmall.filter;


import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;

import com.doublev2v.integralmall.auth.permission.UrlAccessDefinition;
import com.doublev2v.integralmall.auth.permission.UrlAccessDefinitionManager;
import com.doublev2v.integralmall.controller.admin.ApiExceptionHandlerAdvice;


public class UrlAccessFilter extends PathMatchingFilter{  
	Logger logger = LogManager.getLogger(ApiExceptionHandlerAdvice.class);
	
	private UrlAccessDefinitionManager urlAccessDefinitionManager;
	
	public void setUrlAccessDefinitionManager(
			UrlAccessDefinitionManager urlAccessDefinitionManager) {
		this.urlAccessDefinitionManager = urlAccessDefinitionManager;
	}

	private String getLoginUrl(HttpServletRequest req){
		return req.getContextPath()+"/login";
	}
	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response)
			throws Exception {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		String requestUrl=req.getServletPath();
		Iterable<UrlAccessDefinition> list=urlAccessDefinitionManager.findAll();
		if(list!=null){
			for(UrlAccessDefinition u:list){
				if(pathMatcher.matches(u.getUrl(), requestUrl)){
					if(!SecurityUtils.getSubject().isAuthenticated()){
						res.sendRedirect(getLoginUrl(req));
						return false;
					}
					boolean role=true;
					if(StringUtils.isNotBlank(u.getRole())){
						role=SecurityUtils.getSubject().hasRole(u.getRole());;
					}
					boolean perm=true;
					if(StringUtils.isNotBlank(u.getPerm())){
						perm=SecurityUtils.getSubject().isPermitted(u.getPerm());
					}
					if(!(role&&perm)){
						res.getWriter().write("error access");
						return false;
					}	
					
				}
			}
		}
		return true;
	}
   
  
}  