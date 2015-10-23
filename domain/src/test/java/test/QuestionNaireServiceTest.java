package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.doublev2v.integralmall.questionnaire.QuestionNaire;
import com.doublev2v.integralmall.questionnaire.QuestionNaireRepository;
import com.doublev2v.integralmall.questionnaire.facade.QuestionNaireService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class QuestionNaireServiceTest {

	@Autowired
	private QuestionNaireService service;
	@Autowired
	private QuestionNaireRepository repository;
	
	//@Test
	public void exist() {
		boolean exist=service.hasAnswered("1");
		System.out.println(exist);
	}
	
	//@Test
	public void save() {
		QuestionNaire qn=new QuestionNaire();
		qn.setUserId("test");
		qn.setAge("30~50");
		qn.setColor(list("红色"));
		qn.setName("易天明");
		boolean result=service.save(qn);
		System.out.println(result);
	}
	
	@Test
	public void clear() {
		repository.deleteAll();
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
