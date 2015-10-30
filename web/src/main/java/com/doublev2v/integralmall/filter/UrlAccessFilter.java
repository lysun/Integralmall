package com.doublev2v.integralmall.filter;


import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;

import com.doublev2v.integralmall.auth.permission.UrlAccessDefinition;
import com.doublev2v.integralmall.auth.permission.UrlAccessDefinitionManager;
import com.doublev2v.integralmall.controller.admin.ApiExceptionHandlerAdvice;

/**
 * 用于拦截当前请求并并匹配url表达式，判断当前用户是否有进入此请求的角色及权限
 * 如果未登录，转到登录界面
 * 如果没权限，输出error access
 * 
 * @author Administrator
 *
 */
public class UrlAccessFilter extends PathMatchingFilter{  
	Logger logger = LogManager.getLogger(ApiExceptionHandlerAdvice.class);
	
	private UrlAccessDefinitionManager urlAccessDefinitionManager;
	
	public void setUrlAccessDefinitionManager(
			UrlAccessDefinitionManager urlAccessDefinitionManager) {
		this.urlAccessDefinitionManager = urlAccessDefinitionManager;
	}

	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response)
			throws Exception {
		Subject subject = SecurityUtils.getSubject();
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		HttpSession session=req.getSession();
		String requestUrl=req.getServletPath();
		if(!subject.isAuthenticated()){//如果用户没登录跳转到登录页面，并在session中记录登陆成功后需要重定向的请求
			session.setAttribute("successUrl", requestUrl);
			res.sendRedirect(getLoginUrl(req));
			return false;
		}
		Iterable<UrlAccessDefinition> list=urlAccessDefinitionManager.findAll();
		if(list!=null){
			for(UrlAccessDefinition u:list){//遍历所有url权限数据，如果url匹配当前请求，则判断当前用户是否拥有此url所具备的角色或权限
				if(pathMatcher.matches(u.getUrl(), requestUrl)){					
					boolean role=true;
					if(StringUtils.isNotBlank(u.getRole())){
						role=SecurityUtils.getSubject().hasRole(u.getRole());
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
   
	private String getLoginUrl(HttpServletRequest req){
		return req.getContextPath()+"/login";
	}
	
}  