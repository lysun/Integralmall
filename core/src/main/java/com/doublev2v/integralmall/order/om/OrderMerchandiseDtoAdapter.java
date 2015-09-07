package com.doublev2v.integralmall.order.om;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.common.SimpleDtoConverter;
import com.doublev2v.integralmall.merchandise.dto.MerchandiseDtoConverter;
@Component
public class OrderMerchandiseDtoAdapter extends SimpleDtoConverter<OrderMerchandise, OrderMerchandiseDto>{

	@Autowired
	private MerchandiseDtoConverter merchandiseDtoAdapter;
	@Override
	public OrderMerchandiseDto postConvert(OrderMerchandise d,
			OrderMerchandiseDto t) {
		t.setMerchandise(merchandiseDtoAdapter.convert(d.getMerchandise()));
		t.setOrderId(d.getOrder().getId());
		return t;
	}


}
