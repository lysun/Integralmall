package com.doublev2v.integralmall.shop.branch;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;

import org.apache.commons.lang3.StringUtils;

import com.doublev2v.foundation.core.entity.UUIDBaseModel;
import com.doublev2v.integralmall.merchandise.Merchandise;
import com.doublev2v.integralmall.shop.Shop;
import com.doublev2v.integralmall.util.MapPointDistance;
@Entity
public class BranchShop extends UUIDBaseModel{

	private String num;
	private String name;
	private Shop shop;
	private String longitude;//经度
	private String latitude;//纬度
	private String contact;//联系人
	private String address;//具体地址
	private String tel;//联系电话
	private Set<Merchandise> merchs;
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@ManyToOne
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
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
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@ManyToMany(mappedBy="shops")
	@OrderBy("seq")
	public Set<Merchandise> getMerchs() {
		return merchs;
	}
	public void setMerchs(Set<Merchandise> merchs) {
		this.merchs = merchs;
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
