package com.doublev2v.integralmall.order.om.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.SimpleDtoConverter;
import com.doublev2v.integralmall.merchandise.dto.MerchandiseDtoConverter;
import com.doublev2v.integralmall.order.om.OrderMerchandise;
@Component
public class OrderMerchandiseDtoAdapter extends SimpleDtoConverter<OrderMerchandise, OrderMerchandiseDto>{

	@Autowired
	private MerchandiseDtoConverter merchandiseDtoAdapter;
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
