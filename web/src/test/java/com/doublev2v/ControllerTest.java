package com.doublev2v;

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
@ContextConfiguration(locations = { "classpath:applicationContext.xml"})
public class ControllerTest {
	@Autowired
	IntegralController icontroller;
	@Autowired
	IntegralOrderController iocontroller;
	@Autowired
	MerchandiseController mcontroller;
	private MockMvc mockMvc;
	@Before
	public void init(){
		System.out.println("----init----");
		mockMvc = MockMvcBuilders.standaloneSetup(icontroller,iocontroller,mcontroller).build();
	}
	/**
	 * 用户的积分
	 * @throws Exception
	 */
	@Test
	public void test() throws Exception { 
	    MvcResult result = mockMvc
	    		.perform(MockMvcRequestBuilders
	    				.get("/user/4040409e4d044c24014d046c34c10001/integral"))
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
	    				.post("/integralOrder")
	    				.param("merchandiseId", "4040409e4efc0b39014efc0cb0e10003")
	    				.param("userId", "000000004aec8fac014af623d46b002f"))
	    		.andExpect(MockMvcResultMatchers.status().isOk()) 
	    		.andDo(MockMvcResultHandlers.print())  
		        .andReturn();  
	    String str=result.getResponse().getContentAsString();
	    System.out.println(str);//打印返回结果
	}
	/**
	 * 后台获取订单列表
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception { 
	    MvcResult result = mockMvc
	    		.perform(MockMvcRequestBuilders
	    				.get("/integralOrders")
	    				.param("search", ""))
	    		.andExpect(MockMvcResultMatchers.status().isOk()) 
	    		.andDo(MockMvcResultHandlers.print())  
		        .andReturn();  
	    String str=result.getResponse().getContentAsString();
	    System.out.println(str);//打印返回结果
	}
	/**
	 * 客户端获取订单列表
	 * @throws Exception
	 */
	@Test
	public void test22() throws Exception { 
	    MvcResult result = mockMvc
	    		.perform(MockMvcRequestBuilders
	    				.get("/user/4040409e4d044c24014d046c34c10001/integralOrders"))
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
	    				.post("/cancelIntegralOrder/4040409e4ed8021c014ed80223d20000"))
	    		.andExpect(MockMvcResultMatchers.status().isOk()) 
	    		.andDo(MockMvcResultHandlers.print())  
		        .andReturn();
	    MockHttpServletResponse response=result.getResponse();
	    System.out.println(response.getContentAsString());//打印返回结果
	}
	/**
	 * 后台商品列表获取
	 * @throws Exception
	 */
	@Test
	public void test4() throws Exception { 
	    MvcResult result = mockMvc
	    		.perform(MockMvcRequestBuilders
	    				.get("/merchandises"))
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
	    				.get("/merchandises/actual"))
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
	    				.get("/merchandises/nearby")
	    				.param("localAddress", "116,37"))
	    		.andExpect(MockMvcResultMatchers.status().isOk()) 
	    		.andDo(MockMvcResultHandlers.print())  
		        .andReturn();  
	    String str=result.getResponse().getContentAsString();
	    System.out.println(str);//打印返回结果
	}
	@Test
	public void test7() throws Exception { 
	    MvcResult result = mockMvc
	    		.perform(MockMvcRequestBuilders
	    				.get("/merchandise/4040409e4ed801d6014ed803ae0d0000"))
	    		.andExpect(MockMvcResultMatchers.status().isOk()) 
	    		.andDo(MockMvcResultHandlers.print())  
		        .andReturn();  
	    String str=result.getResponse().getContentAsString();
	    System.out.println(str);//打印返回结果
	}
}
