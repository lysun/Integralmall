package com.doublev2v.integralmall.merchandise.dto;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.doublev2v.integralmall.util.MapPointDistance;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class MerchandiseDetail {
	private String id;
	private String name;
	@JsonInclude(Include.NON_NULL)
	private String classifyName;
	@JsonInclude(Include.NON_NULL)
	private String brandName;
	private long integralCount;//所需积分
	private long stock;
	@JsonInclude(Include.NON_NULL)
	private String price;
	@JsonInclude(Include.NON_NULL)
	private String expiryTime;
	@JsonInclude(Include.NON_NULL)//如果为空就不参与序列化
	private String mainPic;
	@JsonInclude(Include.NON_NULL)//如果为空就不参与序列化
	private Set<String> pics;
	@JsonInclude(Include.NON_NULL)
	private String address;//地址
	@JsonInclude(Include.NON_NULL)
	private String shopName;//商户名称
	@JsonInclude(Include.NON_NULL)
	private String longitude;//经度
	@JsonInclude(Include.NON_NULL)
	private String latitude;//纬度
	@JsonInclude(Include.NON_NULL)
	private String remark;//简介
	@JsonIgnore
	private double distance;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getIntegralCount() {
		return integralCount;
	}
	public void setIntegralCount(long integralCount) {
		this.integralCount = integralCount;
	}
	public long getStock() {
		return stock;
	}
	public void setStock(long stock) {
		this.stock = stock;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	public String getExpiryTime() {
		return expiryTime;
	}
	public void setExpiryTime(String expiryTime) {
		this.expiryTime = expiryTime;
	}
	
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
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
	public Set<String> getPics() {
		return pics;
	}
	public void setPics(Set<String> pics) {
		this.pics = pics;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
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
