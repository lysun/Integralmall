package com.doublev2v;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.doublev2v.foundation.core.model.PagedList;
import com.doublev2v.integralmall.merchandise.MerchandiseService;
import com.doublev2v.integralmall.merchandise.dto.MerchandiseDto;
import com.doublev2v.integralmall.order.IntegralOrderRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml" })
public class ServiceTest {

	@Autowired
	private IntegralOrderRepository r;
	@Autowired
	private MerchandiseService m;
	
	@Test
	public void test(){
		PagedList<MerchandiseDto> list=m.getList(1, 1, "false", "", "", Direction.DESC);
		for(MerchandiseDto m:list.getResult()){
			System.out.println(m.getId());
			
		}
	}
}
