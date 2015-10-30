package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.doublev2v.integralmall.favour.CraftFavour;
import com.doublev2v.integralmall.favour.FavourMapper;
import com.doublev2v.integralmall.favour.UserFavour;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class FavourTest {

	@Autowired
	private FavourMapper mapper;
	
//	@Test
	public void getUserFavours(){
		List<UserFavour> favours=mapper.userFavours();
		for (UserFavour userFavour : favours) {
			System.out.println("手机号码\t\t点赞数量");
			System.out.println(userFavour.getTelephone()+"\t"+userFavour.getCount());
		}
	}
	
	@Test
	public void getCraftFavours() {
		List<CraftFavour> favours=mapper.craftFavours();
		for (CraftFavour favour : favours) {
			System.out.println("id\t\t\t\t\t序号\t名称\t\t点赞数量");
			System.out.println(favour.getId()+"\t"
					+favour.getIndex()+"\t"+favour.getName()+"\t"+favour.getCount());
		}
	}
}
