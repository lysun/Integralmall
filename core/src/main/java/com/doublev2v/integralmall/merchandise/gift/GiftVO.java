package com.doublev2v.integralmall.merchandise.gift;

import com.doublev2v.integralmall.merchandise.dto.MerchandiseVO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class GiftVO extends MerchandiseVO {
	@JsonInclude(Include.NON_NULL)
	private String classifyName;
	@JsonInclude(Include.NON_NULL)
	private String brandName;
	@JsonInclude(Include.NON_NULL)
	private String price;//价格
	
	public String getClassifyName() {
		return classifyName;
	}
	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
