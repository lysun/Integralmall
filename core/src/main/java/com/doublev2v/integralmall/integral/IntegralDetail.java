package com.doublev2v.integralmall.integral;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.doublev2v.foundation.core.entity.UUIDBaseModel;
@Entity
public class IntegralDetail extends UUIDBaseModel{

	private Integral integral;//对应积分主表
	private String origin;//积分来源
	private long count;//当前明细的积分增减数
	@ManyToOne
	public Integral getIntegral() {
		return integral;
	}
	public void setIntegral(Integral integral) {
		this.integral = integral;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	
	
}
