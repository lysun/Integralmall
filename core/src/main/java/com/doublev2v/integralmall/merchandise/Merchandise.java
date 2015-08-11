package com.doublev2v.integralmall.merchandise;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.doublev2v.foundation.core.entity.UUIDBaseModel;
import com.doublev2v.foundation.dics.CategoryItem;
import com.doublev2v.foundation.media.MediaContent;
@Entity
public class Merchandise extends UUIDBaseModel{
	private String seq;//编号
	private CategoryItem classify;//商品分类
	private CategoryItem brand;//商品品牌
	private String name;//商品名称
	private String shopName;//商户名称
	private String isActual;//是否是实物商品:false.不是实物，true.是实物
	private long integralCount;//所需积分
	private long stock;//库存
	private String original;//渠道专享
	private String address;//地址
	private String longitude;//经度
	private String latitude;//纬度
	private String remark;//简介
	private String isShelve;//是否下架:true.上架，false.下架
	private String price;//价格
	private LocalDateTime expiryDate;//有效期
	private MediaContent mainPicMedia;
	private Set<MediaContent> medias;
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	@ManyToOne
	public CategoryItem getClassify() {
		return classify;
	}
	public void setClassify(CategoryItem classify) {
		this.classify = classify;
	}
	@ManyToOne
	public CategoryItem getBrand() {
		return brand;
	}
	public void setBrand(CategoryItem brand) {
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOriginal() {
		return original;
	}
	public void setOriginal(String original) {
		this.original = original;
	}

	public String getIsActual() {
		return isActual;
	}
	public void setIsActual(String isActual) {
		this.isActual = isActual;
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
	public String getIsShelve() {
		return isShelve;
	}
	public void setIsShelve(String isShelve) {
		this.isShelve = isShelve;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public LocalDateTime getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDateTime expiryDate) {
		this.expiryDate = expiryDate;
	}
	@OneToMany
	@JoinTable
	public Set<MediaContent> getMedias() {
		return medias;
	}
	public void setMedias(Set<MediaContent> medias) {
		this.medias = medias;
	}
	@OneToOne
	public MediaContent getMainPicMedia() {
		return mainPicMedia;
	}
	public void setMainPicMedia(MediaContent mainPicMedia) {
		this.mainPicMedia = mainPicMedia;
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
		
}
