package com.doublev2v.integralmall.order.om;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.rest.ErrorCodeException;
import com.doublev2v.integralmall.order.IntegralOrder;
import com.doublev2v.integralmall.order.IntegralOrderRepository;
import com.doublev2v.integralmall.util.Constant;
import com.doublev2v.integralmall.util.SystemErrorCodes;
@Service
@Transactional
public class OrderMerchandiseService {

	@Autowired
	private OrderMerchandiseRepository orderMerchandiseRepository;
	@Autowired
	private IntegralOrderRepository repository;
	/**
	 * 根据兑换码使用商品
	 * @param couponCode
	 */
	public void useCashCoupon(String couponCode){
		OrderMerchandise orderMerchandise=orderMerchandiseRepository.findByCouponCode(couponCode);
		IntegralOrder integralOrder=orderMerchandise.getOrder();
		if(Constant.UNUSED.equals(integralOrder.getStatus())){
			integralOrder.setStatus(Constant.USED);
			orderMerchandise.setUsageDate(new Date());
			orderMerchandiseRepository.save(orderMerchandise);
			repository.save(integralOrder);
		}else{
			throw new ErrorCodeException(SystemErrorCodes.COUPONCODE_CANNOT_USE,"兑换码不可用");
		}
	}
	
}
