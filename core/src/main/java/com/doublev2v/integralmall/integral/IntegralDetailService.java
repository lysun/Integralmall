package com.doublev2v.integralmall.integral;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class IntegralDetailService {

	@Autowired
	IntegralDetailRepository integralDetailRepository;
	/**
	 * 创建积分明细记录
	 * @param integral
	 * @param origin
	 * @param count
	 * @return
	 */
	public IntegralDetail createIntegralDetail(Integral integral,long count,String origin){
		IntegralDetail detail=new IntegralDetail();
		detail.setIntegral(integral);
		detail.setCount(count);
		detail.setOrigin(origin);
		return integralDetailRepository.save(detail);
	}
}
