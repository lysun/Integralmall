package com.doublev2v.integralmall.find.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class GiftVo extends MerchandiseVo {
	@JsonInclude(Include.NON_NULL)
	private String price;//价格
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
