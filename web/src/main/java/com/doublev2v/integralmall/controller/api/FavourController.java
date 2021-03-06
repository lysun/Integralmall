package com.doublev2v.integralmall.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doublev2v.integralmall.favour.FavourService;
import com.doublev2v.integralmall.userinfo.UserInfoService;
import com.doublev2v.integralmall.util.RequestResult;
@RestController("favourRestController")
public class FavourController{
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private FavourService favourService;
	/**
	 * 点赞
	 * @param userId
	 * @param originId
	 * @return
	 */
	@RequestMapping(value="/clickFavour",method=RequestMethod.POST)
	public String clickFavour(String userId,String originId) {
		favourService.clickFavour(userInfoService.findOne(userId),originId);
		Map<String,String> map=new HashMap<String,String>();
		map.put("leftCount", String.valueOf(5-favourService.getUserFavourCount(userInfoService.findOne(userId))));
		return RequestResult.success(map).toJson();
	}
	
	/**
	 * 取消点赞
	 * @param userId
	 * @param originId
	 * @return
	 */
	@RequestMapping(value="/cancelFavour",method=RequestMethod.POST)
	public String cancelFavour(String userId,String originId) {
		favourService.cancelFavour(userInfoService.findOne(userId), originId);
		return RequestResult.success(null).toJson();
	}
	
	/**
	 * 获取某个用户的点赞数
	 * @param userId
	 * @param originId
	 * @return
	 */
	@RequestMapping(value="/getUserFavourCount",method=RequestMethod.GET)
	public String getUserFavourCount(String userId) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("count", String.valueOf(favourService.getUserFavourCount(userInfoService.findOne(userId))));
		return RequestResult.success(map).toJson();
	}
	
	/**
	 * 获取某个用户对某个的点赞数,0或者1
	 * @param userId
	 * @param originId
	 * @return
	 */
	@RequestMapping(value="/isClickFavour",method=RequestMethod.GET)
	public String getUserFavourCount(String userId,String originId) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("count", String.valueOf(favourService.getUserFavourCount(userInfoService.findOne(userId), originId)));
		return RequestResult.success(map).toJson();
	}
}
