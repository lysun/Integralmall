package com.doublev2v.integralmall.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.doublev2v.integralmall.auth.user.User;

public class UserSecurityContext {

	/**
	 * 获取spring security中的user
	 * @return
	 */
	public static User getUser(){
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null){
			return (User)auth.getPrincipal();
		}
		return null;
	}
	
}
