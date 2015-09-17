package com.doublev2v.integralmall.find.entity;

import java.util.Set;

import com.doublev2v.integralmall.entity.BranchShopDto;
import com.doublev2v.integralmall.util.MapPointDistance;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class CouponVo extends MerchandiseVo	{
	private String expiryTime="";//有效期
	private String address="";//地址
	private String shopName="";//商户名称
	private String longitude="";//经度
	private String latitude="";//纬度
	@JsonIgnore
	private double distance;
	@JsonIgnore
	private Set<BranchShopDto> shopDtos;//用于获取出来比较哪个分店近
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
	
	public Set<BranchShopDto> getShopDtos() {
		return shopDtos;
	}
	public void setShopDtos(Set<BranchShopDto> shopDtos) {
		this.shopDtos = shopDtos;
	}
	
	/**
	 * 根据实体中的分店集合信息中的经纬度坐标与当前商品的位置的距离最近的分店,并给对象中的经纬度、地址、商户名称属性赋值
	 * @param lat_a
	 * @param lng_a
	 * @return
	 */
	public double calculateDistance(double lng_a,double lat_a){
		if(shopDtos==null||shopDtos.size()==0){
			return 0;
		}
		BranchShopDto one=shopDtos.iterator().next();
		distance=MapPointDistance.getPointsDistance(lng_a, lat_a,
				Double.valueOf(one.getLongitude()), Double.valueOf(one.getLatitude()));
		for(BranchShopDto bs:shopDtos){
			double d=MapPointDistance.getPointsDistance(lng_a, lat_a,
					Double.valueOf(bs.getLongitude()), Double.valueOf(bs.getLatitude()));
			if(d<distance){
				distance=d;
				one=bs;
			}
		}
		this.shopName=one.getName();
		this.address=one.getAddress();
		this.longitude=one.getLongitude();
		this.latitude=one.getLatitude();
		
		return distance;
	}

}
