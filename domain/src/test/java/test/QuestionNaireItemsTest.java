package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.doublev2v.foundation.core.rest.RequestResult;
import com.doublev2v.integralmall.questionnaire.facade.QuestionNaireItemsService;
import com.doublev2v.integralmall.questionnaire.facade.QuestionNaireItemsVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class QuestionNaireItemsTest {

	@Autowired
	private QuestionNaireItemsService service;
	
	@Test
	public void findOne() {
		QuestionNaireItemsVo vo=service.findOne(0L);		
		QuestionNaireItemsVo vo1=service.findOne(0L);
		System.out.println(RequestResult.success(vo).toJson());
		System.out.println(RequestResult.success(vo1).toJson());
	}
	
	//@Test
	public void save() {
		QuestionNaireItemsVo vo=new QuestionNaireItemsVo();
		List<String> age=list("25-29岁,30-34岁,40-49岁,50岁以上");
		List<String> color=list("黑色,白色,蓝色,红色,绿色,黄色,灰色,紫色");
		List<String> occupation=list("公务员,医生,老师 ,白领,自由职业");
		List<String> pants=list("长裤,阔腿裤,锥形裤,七分裤/九分裤,短裤");
		List<String> price=list("1000元以下,1000-2000,2000-3000,3000以上");
		List<String> shirt=list("衬衫,针织衫,西服,短外套,大衣/风衣,皮衣,羽绒服,T恤");
		List<String> size=list("XS,S,M,L,XL,XXL");
		List<String> skirt=list("连衣裙,半裙");
		List<String> style=list("优雅,商务,性感,OL,通勤,简约,淑女 ");
		vo.setAge(age);
		vo.setColor(color);
		vo.setOccupation(occupation);
		vo.setPants(pants);
		vo.setPrice(price);
		vo.setShirt(shirt);
		vo.setSize(size);
		vo.setSkirt(skirt);
		vo.setStyle(style);
		service.save(0L, vo);
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
