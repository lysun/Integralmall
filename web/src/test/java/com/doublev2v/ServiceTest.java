package com.doublev2v;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.doublev2v.integralmall.auth.menu.Menu;
import com.doublev2v.integralmall.auth.menu.MenuService;
import com.doublev2v.integralmall.order.IntegralOrderRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-shiro-test.xml",
									"classpath:applicationContext.xml"})
public class ServiceTest {
	@Autowired
	private DefaultSecurityManager securityManager;//注入securityManager
	@Autowired
	private IntegralOrderRepository r;
	@Autowired
	private MenuService m;
	
	@Before
	public void init(){
		//设置securityManager
		SecurityUtils.setSecurityManager(securityManager);
	}
	@Test
	public void test(){
		
	}
}
