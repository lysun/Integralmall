package com.doublev2v.integralmall.merchandise.gift;

import com.doublev2v.integralmall.merchandise.dto.MerchandiseDto;

public class GiftDto extends MerchandiseDto{
	private double price;//价格

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
