package com.doublev2v.integralmall.find.entity;

import java.util.Date;
import java.util.Set;

import com.doublev2v.foundation.core.entity.Identified;
import com.doublev2v.integralmall.entity.BranchShopDto;
import com.doublev2v.integralmall.util.Constant;
import com.doublev2v.integralmall.util.MapPointDistance;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class IntegralOrderVo implements Identified<String>{
	private String id;
	@JsonInclude(Include.NON_NULL)
	private String orderNo;
	@JsonInclude(Include.NON_NULL)
	private Date orderDate;
	private String type;
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
	@JsonInclude(Include.NON_NULL)
	private String remark;
	@JsonIgnore
	private Set<BranchShopDto> shopDtos;//用于获取出来比较哪个分店近
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
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public Set<BranchShopDto> getShopDtos() {
		return shopDtos;
	}
	public void setShopDtos(Set<BranchShopDto> shopDtos) {
		this.shopDtos = shopDtos;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 计算所给经纬度坐标与当前商品的位置的距离最近的分店,并给对象中的部分属性赋值
	 * @param lat_a
	 * @param lng_a
	 * @return
	 */
	public BranchShopDto calculateNearestBranchShop(double lng_a,double lat_a){
		if(Constant.ACTUAL.equals(this.getType())){
			return null;
		}
		if(shopDtos==null||shopDtos.size()==0){
			return null;
		}
		BranchShopDto one=shopDtos.iterator().next();
		double distance=MapPointDistance.getPointsDistance(lng_a, lat_a,
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
		return one;
	}
}
