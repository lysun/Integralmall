package com.doublev2v.integralmall.shop.branch;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.doublev2v.foundation.core.entity.UUIDBaseModel;
import com.doublev2v.integralmall.merchandise.Merchandise;
import com.doublev2v.integralmall.shop.Shop;
@Entity
public class BranchShop extends UUIDBaseModel{

	private String num;
	private String name;
	private Shop shop;
	private String longitude;//经度
	private String latitude;//纬度
	private String contact;//联系人
	private String description;//商家介绍
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@OneToMany(mappedBy="shop")
	public Set<Merchandise> getMerchs() {
		return merchs;
	}
	public void setMerchs(Set<Merchandise> merchs) {
		this.merchs = merchs;
	}
	
}
