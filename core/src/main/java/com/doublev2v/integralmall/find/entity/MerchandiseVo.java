package com.doublev2v.integralmall.find.entity;

import java.util.Set;

import com.doublev2v.foundation.core.entity.Identified;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class MerchandiseVo implements Identified<String>{

	private String id;
	private String name;
	@JsonInclude(Include.NON_NULL)
	private String classifyName;
	@JsonInclude(Include.NON_NULL)
	private String brandName;
	private String integralCount;//所需积分
	private String stock;
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
	public String getIntegralCount() {
		return integralCount;
	}
	public void setIntegralCount(String integralCount) {
		this.integralCount = integralCount;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
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
	
	
}
