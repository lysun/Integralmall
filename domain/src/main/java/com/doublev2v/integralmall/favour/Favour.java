package com.doublev2v.integralmall.favour;

import javax.persistence.Entity;

import com.doublev2v.foundation.core.entity.UUIDBaseModel;
@Entity
public class Favour extends UUIDBaseModel{

	private String originId;//被点赞的源id
	private long totalCount;
	
	public String getOriginId() {
		return originId;
	}
	public void setOriginId(String originId) {
		this.originId = originId;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	
	
}
