package com.doublev2v.integralmall.order;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.doublev2v.foundation.core.entity.UUIDBaseModel;
import com.doublev2v.integralmall.merchandise.Merchandise;
@Entity
public class OrderMerchandise extends UUIDBaseModel{
	private Merchandise merchandise;
	private int count;//兑换数量
	private long integralCount;//消耗的积分数量
	private String couponCode;//兑换码(消费凭证)
	private LocalDateTime expiryDate;//有效期
	private Date usageDate;//针对优惠券 使用时间
	private IntegralOrder order;
	
	@OneToOne
	public Merchandise getMerchandise() {
		return merchandise;
	}
	public void setMerchandise(Merchandise merchandise) {
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
	public LocalDateTime getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDateTime expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Date getUsageDate() {
		return usageDate;
	}
	public void setUsageDate(Date usageDate) {
		this.usageDate = usageDate;
	}
	@ManyToOne
	@JoinColumn(name="order_id")
	public IntegralOrder getOrder() {
		return order;
	}
	public void setOrder(IntegralOrder order) {
		this.order = order;
	}
	
	
}
