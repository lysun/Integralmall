package com.doublev2v.integralmall.favour;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.rest.ErrorCodeException;
import com.doublev2v.foundation.core.service.AbstractPagingAndSortingService;
import com.doublev2v.integralmall.userinfo.UserInfo;
import com.doublev2v.integralmall.userinfo.UserInfoService;
import com.doublev2v.integralmall.util.SystemErrorCodes;
@Service
@Transactional
public class UserFavourService extends AbstractPagingAndSortingService<UserFavour, String>{
	
	@Autowired
	private UserFavourRepository userFavourRepository;
	@Autowired
	private FavourService favourService;
	@Autowired
	private UserInfoService userInfoService;

	public UserFavour createUserFavour(Favour favour,UserInfo user){
		UserFavour userFavour=new UserFavour();
		userFavour.setFavour(favour);
		userFavour.setUser(user);
		userFavour.setCount(0);
		return userFavour;
	}
	public UserFavour clickFavour(String originId,UserInfo user) {
		if(user==null)throw new IllegalArgumentException("获取不到用户");
		Favour favour=favourService.findByOriginId(originId);
		UserFavour userFavour=null;
		if(favour==null){
			favour=favourService.createFavour(originId);
			userFavour=createUserFavour(favour,user);
		}else{
			userFavour=userFavourRepository.findByUserAndFavour(user, favour);
			if(userFavour==null){
				userFavour=createUserFavour(favour,user);
			}
			if(userFavour.getCount()>=5)
				throw new ErrorCodeException(SystemErrorCodes.USER_FAVOUR_ENOUGH);
		}
		favourService.plusFavour(favour);
		userFavour.setCount(userFavour.getCount()+1);
		return userFavourRepository.save(userFavour);
		
	}
	/**
	 * 查询用户某个商品的点赞数
	 * @param originId
	 * @param userInfoId
	 * @return
	 */
	public int queryFavour(String originId,UserInfo user){
		if(user==null)throw new IllegalArgumentException("获取不到用户");
		Favour favour=favourService.findByOriginId(originId);
		if(favour==null)
			return 0;
		UserFavour userFavour=userFavourRepository.findByUserAndFavour(user, favour);
		if(userFavour==null)
			return 0;
		return userFavour.getCount();
	}
}
