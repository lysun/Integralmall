package com.doublev2v.integralmall.shop.dto;

import java.util.Set;

import com.doublev2v.foundation.core.entity.Identified;
import com.doublev2v.integralmall.merchandise.dto.MerchandiseVo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ShopVo implements Identified<String>{
	private String id;
	private String shopName;
	private String picUrl;
	@JsonInclude(Include.NON_NULL)
	private Set<MerchandiseVo> merchs;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public Set<MerchandiseVo> getMerchs() {
		return merchs;
	}
	public void setMerchs(Set<MerchandiseVo> merchs) {
		this.merchs = merchs;
	}
	
	

}
