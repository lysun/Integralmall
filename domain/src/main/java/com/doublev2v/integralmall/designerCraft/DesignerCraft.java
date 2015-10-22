package com.doublev2v.integralmall.designerCraft;

public class DesignerCraft {

	private String id;
	private String picUrl;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPicUrl() {
		return "http://122.112.15.152/jefen/images/"+picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
}
