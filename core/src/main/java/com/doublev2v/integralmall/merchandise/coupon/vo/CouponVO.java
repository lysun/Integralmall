package com.doublev2v.integralmall.merchandise.coupon.vo;

import org.apache.commons.lang3.StringUtils;

import com.doublev2v.integralmall.merchandise.dto.MerchandiseVO;
import com.doublev2v.integralmall.util.MapPointDistance;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class CouponVO extends MerchandiseVO	{
	@JsonInclude(Include.NON_NULL)
	private String classifyName;
	@JsonInclude(Include.NON_NULL)
	private String brandName;
	private String expiryTime;
	private String address;//地址
	private String shopName;//商户名称
	private String longitude;//经度
	private String latitude;//纬度
	@JsonIgnore
	private double distance;
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
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	/**
	 * 计算所给经纬度坐标与当前商品的位置的距离(单位：米)
	 * @param lat_a
	 * @param lng_a
	 * @return
	 */
	public double calculateDistance(double lng_a,double lat_a){
		if(StringUtils.isBlank(longitude)||StringUtils.isBlank(latitude)){
			return 0;
		}
		double lng_b=Double.valueOf(longitude);
		double lat_b=Double.valueOf(latitude);
		return MapPointDistance.getPointsDistance(lng_a, lat_a, lng_b, lat_b);
	}
}
