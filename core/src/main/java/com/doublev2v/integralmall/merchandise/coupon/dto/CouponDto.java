package com.doublev2v.integralmall.merchandise.coupon.dto;

import com.doublev2v.integralmall.merchandise.dto.MerchandiseDto;

public class CouponDto extends MerchandiseDto{

	private String address;//地址
	private String shopName;//商户名称
	private String longitude;//经度
	private String latitude;//纬度
	private String expiryTime;//有效期
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
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
	public String getExpiryTime() {
		return expiryTime;
	}
	public void setExpiryTime(String expiryTime) {
		this.expiryTime = expiryTime;
	}
	
	
}
