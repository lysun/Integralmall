package com.doublev2v.integralmall.merchandise.gift.dto;

import com.doublev2v.integralmall.merchandise.dto.MerchandiseDto;

public class GiftDto extends MerchandiseDto{
	private String price;//价格

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
}
