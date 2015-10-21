package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.doublev2v.integralmall.designerCraft.DesignerCraftService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DesignerCraftServiceTest {

	@Autowired
	private DesignerCraftService s;
	
	@Test
	public void test(){
		List<String> list=new ArrayList<String>();
		list.add("000000004ab16834014ab17442410004");
		s.findList(list);
	}
}
