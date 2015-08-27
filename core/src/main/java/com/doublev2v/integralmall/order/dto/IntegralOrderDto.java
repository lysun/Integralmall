package com.doublev2v.integralmall.order.dto;

import java.util.Date;

import com.doublev2v.foundation.core.entity.Identified;
import com.doublev2v.integralmall.order.om.OrderMerchandiseDto;
import com.doublev2v.integralmall.userinfo.UserInfo;

public class IntegralOrderDto implements Identified<String>{

	private String id;
	private String orderNo;
	private Date orderDate;
	private UserInfo user;
	private OrderMerchandiseDto orderMerchandiseDto;
	private String ReceiveAddress;//收货地址
	private String status;//未使用:00,已使用:01,待发货:10,已发货:11,已取消:20
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
	
	public OrderMerchandiseDto getOrderMerchandiseDto() {
		return orderMerchandiseDto;
	}
	public void setOrderMerchandiseDto(OrderMerchandiseDto orderMerchandiseDto) {
		this.orderMerchandiseDto = orderMerchandiseDto;
	}
	
	public String getReceiveAddress() {
		return ReceiveAddress;
	}
	public void setReceiveAddress(String receiveAddress) {
		ReceiveAddress = receiveAddress;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

	
	
}
