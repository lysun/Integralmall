package com.doublev2v.integralmall.merchandise.coupon;

import com.doublev2v.integralmall.merchandise.dto.MerchandiseDto;

public class CouponDto extends MerchandiseDto{

	private String address;//地址
	private String longitude;//经度
	private String latitude;//纬度
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
	
	
}
