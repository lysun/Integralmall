package com.doublev2v.integralmall.merchandise.coupon;

import java.time.LocalDateTime;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.doublev2v.integralmall.merchandise.Merchandise;
@Entity
@DiscriminatorValue("0")
public class Coupon extends Merchandise{
	private String address;//地址
	private String shopName;//商户名称
	private String longitude;//经度
	private String latitude;//纬度
	private LocalDateTime expiryDate;//有效期
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
	public LocalDateTime getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDateTime expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	
}
