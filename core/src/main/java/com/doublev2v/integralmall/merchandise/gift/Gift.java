package com.doublev2v.integralmall.merchandise.gift;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.doublev2v.integralmall.merchandise.Merchandise;

@Entity
@DiscriminatorValue("1")
public class Gift extends Merchandise{
	private String price;//价格

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
}
