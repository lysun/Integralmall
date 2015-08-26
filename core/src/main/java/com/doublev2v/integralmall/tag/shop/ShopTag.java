package com.doublev2v.integralmall.tag.shop;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.doublev2v.integralmall.shop.Shop;
import com.doublev2v.integralmall.tag.Tag;
@Entity
@DiscriminatorValue("SHOP")
public class ShopTag extends Tag{
	private Set<Shop> shops;

	@ManyToMany(mappedBy="tags")
	public Set<Shop> getShops() {
		return shops;
	}

	public void setShops(Set<Shop> shops) {
		this.shops = shops;
	}
	
	
}
