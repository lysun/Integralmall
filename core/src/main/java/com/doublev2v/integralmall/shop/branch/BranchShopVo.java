package com.doublev2v.integralmall.shop.branch;

import java.util.Set;

import com.doublev2v.foundation.core.entity.Identified;
import com.doublev2v.integralmall.merchandise.dto.MerchandiseVo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class BranchShopVo implements Identified<String>{
	private String id;
	private String name;
	private String description;//商家介绍
	private String picUrl;
	private String address;//具体地址
	@JsonInclude(Include.NON_NULL)
	private String tel;//联系电话
	@JsonInclude(Include.NON_NULL)
	private Set<MerchandiseVo> merchs;
	private String leastIntegral;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLeastIntegral() {
		return leastIntegral;
	}
	public void setLeastIntegral(String leastIntegral) {
		this.leastIntegral = leastIntegral;
	}
	

}
