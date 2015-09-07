package com.doublev2v.integralmall.auth.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.session.Session;

import com.doublev2v.integralmall.auth.user.User;

public class ShiroContext {

	/**
	 * 返回当前用户，没有就返回null
	 * @return
	 */
	public static User getCurrentUser(){
		Session session=SecurityUtils.getSubject().getSession();
		return (User)session.getAttribute("user");
	}
	/**
	 * 返回当前用户，没有就抛出异常
	 * @return
	 */
	public static User getAuthorizatedUser(){
		User user=getCurrentUser();
		if(user==null)
			throw new AuthorizationException("您没有登录");
		 return user;
	}
}
