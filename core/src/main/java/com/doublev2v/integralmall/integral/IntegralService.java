package com.doublev2v.integralmall.integral;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.rest.ErrorCodeException;
import com.doublev2v.integralmall.user.User;
import com.doublev2v.integralmall.util.Constant;
import com.doublev2v.integralmall.util.SystemErrorCodes;
@Service
@Transactional
public class IntegralService {
	@Autowired
	private IntegralRepository repository;
	@Autowired
	IntegralDetailService integralDetailService;
	/**
	 * 获取用户可用积分
	 * @param user
	 * @return
	 */
	public long getIntegralCount(String userId){
		if(StringUtils.isBlank(userId)){
			return 0;
		}
		Integral integral=repository.findIntegralByUser_id(userId);
		if(integral==null){
			return 0;
		}
		return integral.getTotalcount();
	}
	
	/**
	 * 扣减用户积分,并记录明细
	 * @param user
	 * @return
	 */
	public Integral minusIntegralCount(User user,long usedCount){
		Integral integral=repository.findIntegralByUser(user);
		if(integral==null||integral.getTotalcount()<usedCount)
			throw new ErrorCodeException(SystemErrorCodes.NOTENOUGH_INTEGRAL,"积分不足");
		integral.setTotalcount(integral.getTotalcount()-usedCount);
		repository.save(integral);
		//生成积分明细记录
		integralDetailService.createIntegralDetail(integral,
				Constant.CONVERT_MERCHANDISE, 0-usedCount);
		return integral;
	}
	
	/**
	 * 增加用户积分,并记录明细
	 * @param user
	 * @return
	 */
	public Integral plusIntegralCount(User user,long count){
		Integral integral=repository.findIntegralByUser(user);
		integral.setTotalcount(integral.getTotalcount()+count);
		repository.save(integral);
		//生成积分明细记录
		integralDetailService.createIntegralDetail(integral,
						Constant.CONVERT_MERCHANDISE_CANCEL,count);
		return integral;
	}
}
