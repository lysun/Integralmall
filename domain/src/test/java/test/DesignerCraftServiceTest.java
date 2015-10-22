package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.doublev2v.integralmall.designerCraft.DesignerCraft;
import com.doublev2v.integralmall.designerCraft.DesignerMapper;
import com.doublev2v.integralmall.util.RequestResult;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DesignerCraftServiceTest {

	@Autowired
	private DesignerMapper mapper;
	
	@Test
	public void test(){
		List<DesignerCraft> result=mapper.findCrafts(list("1,2"),"000000004b213cde014b34c1bd68028c");
		System.out.println(RequestResult.success(result).toJson());
	}
	
	private List<String> list(String str) {
		String[] items=str.split(",");
		List<String> list=new ArrayList<String>();
		for (String item : items) {
			list.add(item.trim());
		}
		return list;
	}
}
