package com.doublev2v.integralmall.merchandise.dto;

import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.doublev2v.foundation.core.entity.Identified;
import com.doublev2v.foundation.dics.dto.CategoryItemDto;
import com.doublev2v.foundation.media.MediaContentDto;
import com.doublev2v.integralmall.shop.branch.BranchShopDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
public class MerchandiseDto implements Identified<String>{
	private String id;
	private String seq;//编号
	private CategoryItemDto classifyDto;//商品分类
	@JsonIgnore
	private String classifyId;//商品分类
	private CategoryItemDto brandDto;//商品品牌
	@JsonIgnore
	private String brandId;//商品品牌id
	private String name;//商品名称
	private String type;//商品类型
	private long integralCount;//所需积分
	private long stock;//库存
	private String original;//渠道专享
	private String remark;//简介
	private String isShelve;
	private MediaContentDto mainPicDto;
	@JsonIgnore
	private MultipartFile mainpicFile;
	private Set<MediaContentDto> mediaDtos;
	@JsonIgnore
	private MultipartFile[] mediaFiles;
	private BranchShopDto shopDto;
	private String shopId;
	private String brief;
	private String start;
	private String end;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
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
	public CategoryItemDto getBrandDto() {
		return brandDto;
	}
	public void setBrandDto(CategoryItemDto brandDto) {
		this.brandDto = brandDto;
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public Set<MediaContentDto> getMediaDtos() {
		return mediaDtos;
	}
	public void setMediaDtos(Set<MediaContentDto> mediaDtos) {
		this.mediaDtos = mediaDtos;
	}
	public MultipartFile[] getMediaFiles() {
		return mediaFiles;
	}
	public void setMediaFiles(MultipartFile[] mediaFiles) {
		this.mediaFiles = mediaFiles;
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
	public BranchShopDto getShopDto() {
		return shopDto;
	}
	public void setShopDto(BranchShopDto shopDto) {
		this.shopDto = shopDto;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	
	
	
}
