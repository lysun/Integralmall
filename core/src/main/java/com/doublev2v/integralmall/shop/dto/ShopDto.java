package com.doublev2v.integralmall.shop.dto;

import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.doublev2v.foundation.core.entity.Identified;
import com.doublev2v.foundation.dics.dto.CategoryItemDto;
import com.doublev2v.foundation.media.MediaContentDto;
import com.doublev2v.integralmall.tag.Tag;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ShopDto implements Identified<String>{
	private String id;
	private String shopName;
	private CategoryItemDto classifyDto;//商品分类
	@JsonIgnore
	private String classifyId;//商品分类
	private String description;
	private MediaContentDto mainPicDto;
	@JsonIgnore
	private MultipartFile mainpicFile;
	@JsonIgnore
	private Set<String> tagIds;
	private Set<Tag> tags;//简单的对象交给dozer转换
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
	public Set<Tag> getTags() {
		return tags;
	}
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	public Set<String> getTagIds() {
		return tagIds;
	}
	public void setTagIds(Set<String> tagIds) {
		this.tagIds = tagIds;
	}
	
	

}
