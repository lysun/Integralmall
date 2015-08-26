package com.doublev2v;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.doublev2v.integralmall.controller.api.IntegralController;
import com.doublev2v.integralmall.controller.api.IntegralOrderController;
import com.doublev2v.integralmall.controller.api.MerchandiseController;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-shiro-test.xml",
									"classpath:applicationContext.xml"})
public class ApiControllerTest {
	
	private MockMvc mockMvc;
	@Autowired
	private DefaultSecurityManager securityManager;//注入securityManager
	@Autowired
	IntegralController icontroller;
	@Resource
	com.doublev2v.integralmall.controller.admin.IntegralOrderController integralOrderController;
	@Resource
	IntegralOrderController integralOrderRestController;
	@Autowired
	MerchandiseController mcontroller;
	
	@Before
	public void init(){
		System.out.println("----init----");
		//设置securityManager
		SecurityUtils.setSecurityManager(securityManager);
		mockMvc = MockMvcBuilders.standaloneSetup(icontroller,integralOrderController,integralOrderRestController
				,mcontroller).build();
	}
	/**
	 * 用户的积分
	 * @throws Exception
	 */
	@Test
	public void test() throws Exception { 
	    MvcResult result = mockMvc
	    		.perform(MockMvcRequestBuilders
	    				.get("/myIntegral")
	    				.param("token", "82bcf8fbe4e94f6a9031d4d802250beb"))
	    		.andExpect(MockMvcResultMatchers.status().isOk()) 
	    		.andDo(MockMvcResultHandlers.print())  
		        .andReturn();  
	    String str=result.getResponse().getContentAsString();
	    System.out.println(str);//打印返回结果
	}
	
	/**
	 * 实物商品列表
	 * @throws Exception
	 */
	@Test
	public void test5() throws Exception { 
	    MvcResult result = mockMvc
	    		.perform(MockMvcRequestBuilders
	    				.get("/giftsList"))
	    		.andExpect(MockMvcResultMatchers.status().isOk()) 
	    		.andDo(MockMvcResultHandlers.print())  
		        .andReturn();  
	    String str=result.getResponse().getContentAsString();
	    System.out.println(str);//打印返回结果
	}
	/**
	 * 附近商家列表
	 * @throws Exception
	 */
	@Test
	public void test6() throws Exception { 
	    MvcResult result = mockMvc
	    		.perform(MockMvcRequestBuilders
	    				.get("/couponList")
	    				.param("localAddress", "116.1,37"))
	    		.andExpect(MockMvcResultMatchers.status().isOk()) 
	    		.andDo(MockMvcResultHandlers.print())  
		        .andReturn();  
	    String str=result.getResponse().getContentAsString();
	    System.out.println(str);//打印返回结果
	}
	/**
	 * 实物商品详情
	 * @throws Exception
	 */
	@Test
	public void test7() throws Exception { 
	    MvcResult result = mockMvc
	    		.perform(MockMvcRequestBuilders
	    				.get("/giftDetail")
	    				.param("id", "4040409e4ef31284014ef314eff50004"))
	    		.andExpect(MockMvcResultMatchers.status().isOk()) 
	    		.andDo(MockMvcResultHandlers.print())
		        .andReturn();  
	    String str=result.getResponse().getContentAsString();
	    System.out.println(str);//打印返回结果
	}
	/**
	 * 附近商家详情
	 * @throws Exception
	 */
	@Test
	public void test8() throws Exception { 
	    MvcResult result = mockMvc
	    		.perform(MockMvcRequestBuilders
	    				.get("/couponDetail")
	    				.param("id", "4040409e4ed941b6014ed944a03e0000"))
	    		.andExpect(MockMvcResultMatchers.status().isOk()) 
	    		.andDo(MockMvcResultHandlers.print())
		        .andReturn();  
	    String str=result.getResponse().getContentAsString();
	    System.out.println(str);//打印返回结果
	}
	/**
	 * 创建订单
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception { 
	    MvcResult result = mockMvc
	    		.perform(MockMvcRequestBuilders
	    				.post("/exchangeCoupon")
	    				.param("merchandiseId", "4040409e4f63fd6f014f63fee8350006")
	    				.param("addressId", "ddddddd")
	    				.param("token", "82bcf8fbe4e94f6a9031d4d802250beb"))
	    		.andExpect(MockMvcResultMatchers.status().isOk()) 
	    		.andDo(MockMvcResultHandlers.print())  
		        .andReturn();  
	    String str=result.getResponse().getContentAsString();
	    System.out.println(str);//打印返回结果
	}
	/**
	 * 获取我的列表
	 * @throws Exception
	 */
	@Test
	public void test22() throws Exception { 
	    MvcResult result = mockMvc
	    		.perform(MockMvcRequestBuilders
	    				.get("/myCouponsList")
	    				.param("token", "82bcf8fbe4e94f6a9031d4d802250beb"))
	    		.andExpect(MockMvcResultMatchers.status().isOk()) 
	    		.andDo(MockMvcResultHandlers.print())  
		        .andReturn();  
	    String str=result.getResponse().getContentAsString();
	    System.out.println(str);//打印返回结果
	}
	/**
	 * 我的详情
	 * @throws Exception
	 */
	@Test
	public void test9() throws Exception { 
	    MvcResult result = mockMvc
	    		.perform(MockMvcRequestBuilders
	    				.get("/myCouponDetail")
	    				.param("id", "4040409e4ee2c05b014ee2c0611e0000"))
	    		.andExpect(MockMvcResultMatchers.status().isOk()) 
	    		.andDo(MockMvcResultHandlers.print())
		        .andReturn();  
	    String str=result.getResponse().getContentAsString();
	    System.out.println(str);//打印返回结果
	}

	/**
	 * 取消订单
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception { 
	    MvcResult result = mockMvc
	    		.perform(MockMvcRequestBuilders
	    				.post("/cancelCoupon")
	    				.param("id", "4040409e4ef166e7014ef166ece10000"))
	    		.andExpect(MockMvcResultMatchers.status().isOk()) 
	    		.andDo(MockMvcResultHandlers.print())  
		        .andReturn();
	    MockHttpServletResponse response=result.getResponse();
	    System.out.println(response.getContentAsString());//打印返回结果
	}

}
