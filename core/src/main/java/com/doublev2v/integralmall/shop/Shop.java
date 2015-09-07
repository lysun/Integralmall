package com.doublev2v.integralmall.shop;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.doublev2v.foundation.core.entity.UUIDBaseModel;
import com.doublev2v.foundation.dics.CategoryItem;
import com.doublev2v.foundation.media.MediaContent;
import com.doublev2v.integralmall.shop.branch.BranchShop;
@Entity
public class Shop extends UUIDBaseModel{

	private String num;//商户编号
	private String shopName;
	private CategoryItem classify;//商户类别
	private String description;//商家介绍
	private MediaContent mainPic;
	private Set<CategoryItem> tags;
	private Set<BranchShop> branchShops;
	private long integral;
	
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	@ManyToOne
	public CategoryItem getClassify() {
		return classify;
	}
	public void setClassify(CategoryItem classify) {
		this.classify = classify;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@OneToOne
	public MediaContent getMainPic() {
		return mainPic;
	}
	public void setMainPic(MediaContent mainPic) {
		this.mainPic = mainPic;
	}
	
	@ManyToMany
	@JoinTable(name="shop_tag")
	public Set<CategoryItem> getTags() {
		return tags;
	}
	public void setTags(Set<CategoryItem> tags) {
		this.tags = tags;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public long getIntegral() {
		return integral;
	}
	public void setIntegral(long integral) {
		this.integral = integral;
	}
	@OneToMany(mappedBy="shop")
	public Set<BranchShop> getBranchShops() {
		return branchShops;
	}
	public void setBranchShops(Set<BranchShop> branchShops) {
		this.branchShops = branchShops;
	}
	
}
