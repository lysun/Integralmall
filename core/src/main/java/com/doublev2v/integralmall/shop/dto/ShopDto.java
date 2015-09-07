package com.doublev2v.integralmall.shop.dto;

import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.doublev2v.foundation.core.entity.Identified;
import com.doublev2v.foundation.dics.dto.CategoryItemDto;
import com.doublev2v.foundation.media.MediaContentDto;
import com.doublev2v.integralmall.shop.branch.BranchShopDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ShopDto implements Identified<String>{
	private String id;
	private String num;//商户编号
	private String shopName;
	private CategoryItemDto classifyDto;//商品分类
	@JsonIgnore
	private String classifyId;//商品分类
	private String description;
	private MediaContentDto mainPicDto;
	@JsonIgnore
	private MultipartFile mainpicFile;
	private long integral;
	@JsonIgnore
	private String tagName;
	private Set<CategoryItemDto> tags;//简单的对象交给dozer转换
	private Set<BranchShopDto> branchs;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public CategoryItemDto getClassifyDto() {
		return classifyDto;
	}
	public void setClassifyDto(CategoryItemDto classifyDto) {
		this.classifyDto = classifyDto;
	}
	public String getClassifyId() {
		return classifyId;
	}
	public void setClassifyId(String classifyId) {
		this.classifyId = classifyId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public MediaContentDto getMainPicDto() {
		return mainPicDto;
	}
	public void setMainPicDto(MediaContentDto mainPicDto) {
		this.mainPicDto = mainPicDto;
	}
	public MultipartFile getMainpicFile() {
		return mainpicFile;
	}
	public void setMainpicFile(MultipartFile mainpicFile) {
		this.mainpicFile = mainpicFile;
	}
	public Set<CategoryItemDto> getTags() {
		return tags;
	}
	public void setTags(Set<CategoryItemDto> tags) {
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
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public Set<BranchShopDto> getBranchs() {
		return branchs;
	}
	public void setBranchs(Set<BranchShopDto> branchs) {
		this.branchs = branchs;
	}
	

}
