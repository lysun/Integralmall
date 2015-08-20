package com.doublev2v.integralmall.integral;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.rest.ErrorCodeException;
import com.doublev2v.integralmall.integral.detail.IntegralDetailService;
import com.doublev2v.integralmall.userinfo.UserInfo;
import com.doublev2v.integralmall.util.SystemErrorCodes;
@Service
@Transactional
public class IntegralService {
	@Autowired
	private IntegralRepository repository;
	@Autowired
	IntegralDetailService integralDetailService;
	
	public Integral createIntegral(UserInfo user,long totalcount){
		Integral integral=new Integral();
		integral.setUser(user);
		integral.setTotalcount(totalcount);
		return repository.save(integral);
	}
	/**
	 * 获取用户可用积分
	 * @param user
	 * @return
	 */
	public long getIntegralCount(UserInfo user){
		Integral integral=repository.findIntegralByUser(user);
		if(integral==null){
			integral=createIntegral(user,0);
		}
		return integral.getTotalcount();
	}
	
	/**
	 * 扣减用户积分,并记录明细
	 * @param user
	 * @return
	 */
	public Integral minusIntegralCount(UserInfo user,long usedCount,String origin){
		Integral integral=repository.findIntegralByUser(user);
		if(integral==null){
			integral=createIntegral(user,0);
		}
		if(integral.getTotalcount()<usedCount)
			throw new ErrorCodeException(SystemErrorCodes.NOTENOUGH_INTEGRAL,"积分不足");
		integral.setTotalcount(integral.getTotalcount()-usedCount);
		repository.save(integral);
		//生成积分明细记录
		integralDetailService.createIntegralDetail(integral, 0-usedCount,origin);
		return integral;
	}
	
	/**
	 * 增加用户积分,并记录明细
	 * @param user
	 * @return
	 */
	public Integral plusIntegralCount(UserInfo user,long count,String origin){
		Integral integral=repository.findIntegralByUser(user);
		if(integral==null){
			integral=createIntegral(user,0);
		}
		integral.setTotalcount(integral.getTotalcount()+count);
		repository.save(integral);
		//生成积分明细记录
		integralDetailService.createIntegralDetail(integral,count,origin);
		return integral;
	}
}
