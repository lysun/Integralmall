package com.doublev2v;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.doublev2v.foundation.core.rest.RequestResult;
import com.doublev2v.integralmall.controller.api.AccountController;
import com.doublev2v.integralmall.social.SocialLoginManager;
import com.doublev2v.integralmall.social.SocialLoginManager.LoginResult;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SocialLoginTest {

	@Autowired
	private SocialLoginManager manager;
	@Autowired
	private AccountController controller;
	
	//@Test
	public void login() {
		LoginResult result=manager.login("1");
		System.out.println(RequestResult.success(result).toJson());
	}
	
	//@Test
	public void bind() {
		LoginResult result=manager.bind("18612444099", "1", 1, "易天明", null);
		System.out.println(RequestResult.success(result).toJson());
	}
	
	//@Test
	public void  cbind() {
		String result=controller.socialBind("5657187826", "18618420117", 0, "北京双丰网络科技有限公司", "iconUrl");
		System.out.println(result);
	}
	
	@Test
	public void clogin() {
		String result=controller.socialLogin("56571878");
		System.out.println(result);
	}
}
