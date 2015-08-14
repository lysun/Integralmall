package com.doublev2v.integralmall.order.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.common.SimpleDtoConverter;
import com.doublev2v.integralmall.order.IntegralOrder;
import com.doublev2v.integralmall.order.om.dto.OrderMerchandiseDtoAdapter;

@Component
public class IntegralOrderDtoConverter extends SimpleDtoConverter<IntegralOrder, IntegralOrderDto> {

	@Autowired
	private OrderMerchandiseDtoAdapter orderMerchandiseDtoAdapter;
	@Override
	public IntegralOrderDto postConvert(IntegralOrder d, IntegralOrderDto t) {
		t.setOrderMerchandiseDto(orderMerchandiseDtoAdapter.convert(d.getOrderMerchandise()));
		t.setUser(d.getUser());
		return t;
	}

	@Override
	public IntegralOrder postConvertD(IntegralOrderDto t, IntegralOrder d) {
		return postUpdate(t,d);
	}

	@Override
	public IntegralOrder postUpdate(IntegralOrderDto t, IntegralOrder d) {
		d.setOrderMerchandise(orderMerchandiseDtoAdapter.convertD(t.getOrderMerchandiseDto()));
		d.setUser(t.getUser());
		return d;
	}
	
	
}
