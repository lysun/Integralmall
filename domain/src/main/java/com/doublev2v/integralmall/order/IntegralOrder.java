package com.doublev2v.integralmall.order;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.doublev2v.foundation.core.entity.UUIDBaseModel;
import com.doublev2v.integralmall.order.om.OrderMerchandise;
import com.doublev2v.integralmall.shop.Shop;
import com.doublev2v.integralmall.userinfo.UserInfo;
@Entity
public class IntegralOrder extends UUIDBaseModel{
	private String orderNo;
	private Date orderDate;
	private UserInfo user;
	private OrderMerchandise orderMerchandise;
	private String addressId;//收货地址id
	private String status;//未使用:00,已使用:01,待发货:10,已发货:11,已取消:20
	private Shop shop;//店铺信息
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@ManyToOne
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@OneToOne(mappedBy="order")
	public OrderMerchandise getOrderMerchandise() {
		return orderMerchandise;
	}
	public void setOrderMerchandise(OrderMerchandise orderMerchandise) {
		this.orderMerchandise = orderMerchandise;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	@ManyToOne
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	
}
