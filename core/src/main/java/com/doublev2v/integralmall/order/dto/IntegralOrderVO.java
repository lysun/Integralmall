package com.doublev2v.integralmall.order.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class IntegralOrderVO {
	private String id;
	@JsonInclude(Include.NON_NULL)
	private String orderNo;
	@JsonInclude(Include.NON_NULL)
	private Date orderDate;
	private String isActual;
	private String name;
	private String classifyName="";
	private String brandName="";
	private String mainPic="";
	private String expiryTime="";
	private String address="";//地址
	private String shopName="";//商户名称
	private String longitude="";//经度
	private String latitude="";//纬度
	@JsonInclude(Include.NON_NULL)
	private String usageDate;//针对优惠券 使用时间
	@JsonInclude(Include.NON_NULL)
	private String couponCode;//兑换码(消费凭证)
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
	public String getIsActual() {
		return isActual;
	}
	public void setIsActual(String isActual) {
		this.isActual = isActual;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getMainPic() {
		return mainPic;
	}
	public void setMainPic(String mainPic) {
		this.mainPic = mainPic;
	}
	public String getExpiryTime() {
		return expiryTime;
	}
	public void setExpiryTime(String expiryTime) {
		this.expiryTime = expiryTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getUsageDate() {
		return usageDate;
	}
	public void setUsageDate(String usageDate) {
		this.usageDate = usageDate;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	
}
