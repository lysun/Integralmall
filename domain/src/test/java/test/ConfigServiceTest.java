package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.doublev2v.integralmall.config.ConfigService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ConfigServiceTest {

	@Autowired
	private ConfigService service;
	
	@Test
	public void saveAddress() {
		service.saveLiveAddress(
				"http://114.112.74.76/live.butel.com/i61f317eeeda44dddb29d11e559189c53.flv", 
				"http://114.112.74.76/live.butel.com/i61f317eeeda44dddb29d11e559189c53.flv");
	}
}
