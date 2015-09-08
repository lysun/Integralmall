package com.doublev2v.integralmall.activity.entity;

import com.doublev2v.foundation.core.entity.Identified;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ActivityMerchandise implements Identified<String>{
	@JsonProperty("merchId")
	private String id;
	private String name;
	private String integralCount;//所需积分
	@JsonIgnore
	private String stock;
	private String mainPic;
	private String brief;//简介
	private String start;//商品活动开始时间
	private String end;//商品活动结束时间
	private String type;
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
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
