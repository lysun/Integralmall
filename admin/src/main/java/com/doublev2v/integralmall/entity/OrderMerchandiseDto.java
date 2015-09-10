package com.doublev2v.integralmall.entity;

import java.util.Date;

import com.doublev2v.foundation.core.entity.Identified;

public class OrderMerchandiseDto implements Identified<String>{
	private String id;
	private MerchandiseDto merchandise;
	private int count;//兑换数量
	private long integralCount;//消耗的积分数量
	private String couponCode;//兑换码(消费凭证)
	private Date usageDate;//针对优惠券 使用时间
	private String orderId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public MerchandiseDto getMerchandise() {
		return merchandise;
	}
	public void setMerchandise(MerchandiseDto merchandise) {
		this.merchandise = merchandise;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public long getIntegralCount() {
		return integralCount;
	}
	public void setIntegralCount(long integralCount) {
		this.integralCount = integralCount;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public Date getUsageDate() {
		return usageDate;
	}
	public void setUsageDate(Date usageDate) {
		this.usageDate = usageDate;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
}
