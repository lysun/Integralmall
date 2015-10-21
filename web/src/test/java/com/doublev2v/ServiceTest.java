package com.doublev2v;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.doublev2v.integralmall.designerCraft.DesignerCraftService;
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
	private DesignerCraftService s;
	
	@Before
	public void init(){
		//设置securityManager
		SecurityUtils.setSecurityManager(securityManager);
	}
	@Test
	public void test(){
		List<String> list=new ArrayList<String>();
		list.add("000000004ab16834014ab17442410004");
		s.findAll(list);
	}
}
