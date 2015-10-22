package com.doublev2v.integralmall.designerCraft;

public class DesignerCraft {

	private String id;
	private String craftid;
	private String picUrl;
	private int isFavored;
	private int isCollected;
	
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
	public int getIsFavored() {
		if(isFavored==0) return 0;
		return 1;
	}
	public void setIsFavored(int isFavored) {
		this.isFavored = isFavored;
	}
	public int getIsCollected() {
		if(isCollected==0) return 0;
		return 1;
	}
	public void setIsCollected(int isCollected) {
		this.isCollected = isCollected;
	}
}
