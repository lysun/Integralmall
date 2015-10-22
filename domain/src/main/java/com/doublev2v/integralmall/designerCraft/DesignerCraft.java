package com.doublev2v.integralmall.designerCraft;

public class DesignerCraft {

	private String id;
	private String craftid;
	private String picUrl;
	private String isFavored="0";
	private String isCollected="0";
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCraftid() {
		return craftid;
	}
	public void setCraftid(String craftid) {
		this.craftid = craftid;
	}
	public String getPicUrl() {
		return "http://122.112.15.152/jefen/images/"+picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getIsFavored() {
		if("0".equals(isFavored)) return "0";
		return "1";
	}
	public void setIsFavored(String isFavored) {
		this.isFavored = isFavored;
	}
	public String getIsCollected() {
		if("0".equals(isCollected)) return "0";
		return "1";
	}
	public void setIsCollected(String isCollected) {
		this.isCollected = isCollected;
	}
}
