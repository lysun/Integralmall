package com.doublev2v.integralmall.order.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.SimpleAbstractDtoAdater;
import com.doublev2v.integralmall.merchandise.dto.MerchandiseDtoAdapter;
import com.doublev2v.integralmall.order.OrderMerchandise;
@Component
public class OrderMerchandiseDtoAdapter extends SimpleAbstractDtoAdater<OrderMerchandise, OrderMerchandiseDto>{

	@Autowired
	private MerchandiseDtoAdapter merchandiseDtoAdapter;
	@Override
	public OrderMerchandiseDto postConvert(OrderMerchandise d,
			OrderMerchandiseDto t) {
		if(d.getExpiryDate()!=null){
			t.setExpiryDateTime(d.getExpiryDate());
		}
		t.setMerchandise(merchandiseDtoAdapter.convert(d.getMerchandise()));
		t.setOrderId(d.getOrder().getId());
		return t;
	}


}
