package com.doublev2v.integralmall.merchandise.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class MerchandiseVO {

	private String id;
	private String name;
	private long integralCount;//所需积分
	private long stock;
	@JsonInclude(Include.NON_NULL)//如果为空就不参与序列化
	private String mainPic;
	@JsonInclude(Include.NON_NULL)//如果为空就不参与序列化
	private Set<String> pics;
	@JsonInclude(Include.NON_NULL)
	private String remark;//简介
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
	public long getIntegralCount() {
		return integralCount;
	}
	public void setIntegralCount(long integralCount) {
		this.integralCount = integralCount;
	}
	public long getStock() {
		return stock;
	}
	public void setStock(long stock) {
		this.stock = stock;
	}
	public String getMainPic() {
		return mainPic;
	}
	public void setMainPic(String mainPic) {
		this.mainPic = mainPic;
	}
	public Set<String> getPics() {
		return pics;
	}
	public void setPics(Set<String> pics) {
		this.pics = pics;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
