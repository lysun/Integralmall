package com.doublev2v.integralmall.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doublev2v.integralmall.favour.UserFavourService;
import com.doublev2v.integralmall.userinfo.UserInfoService;
import com.doublev2v.integralmall.util.RequestResult;
@RestController("userFavourRestController")
public class UserFavourController{
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private UserFavourService userFavourService;
	/**
	 * 点赞
	 * @param userId
	 * @param originId
	 * @return
	 */
	@RequestMapping(value="/clickFavour",method=RequestMethod.POST)
	public String clickFavour(String userId,String originId) {
		userFavourService.clickFavour(originId, userInfoService.findOne(userId));
		return RequestResult.success(null).toJson();
	}
	/**
	 * 获取某个用户某个商品的点赞数
	 * @param userId
	 * @param originId
	 * @return
	 */
	@RequestMapping(value="/getUserFavourCount",method=RequestMethod.GET)
	public String getUserFavourCount(String userId,String originId) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("count", String.valueOf(userFavourService.queryFavour(originId, userInfoService.findOne(userId))));
		return RequestResult.success(map).toJson();
	}
	
}
