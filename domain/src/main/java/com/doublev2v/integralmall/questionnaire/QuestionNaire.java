package com.doublev2v.integralmall.questionnaire;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import com.doublev2v.foundation.core.entity.UUIDBaseModel;

@Entity
public class QuestionNaire extends UUIDBaseModel {

	private String userId;
	private String name;
	private String age;
	private String occupation;
	private List<String> color;
	private String size;
	private List<String> shirt;
	private List<String> skirt;
	private List<String> pants;
	private List<String> style;
	private String price;
	
	@Column(unique=true,nullable=false)
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	@ElementCollection(fetch=FetchType.EAGER)
	public List<String> getColor() {
		return color;
	}
	public void setColor(List<String> color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	@ElementCollection(fetch=FetchType.EAGER)
	public List<String> getShirt() {
		return shirt;
	}
	public void setShirt(List<String> shirt) {
		this.shirt = shirt;
	}
	@ElementCollection(fetch=FetchType.EAGER)
	public List<String> getSkirt() {
		return skirt;
	}
	public void setSkirt(List<String> skirt) {
		this.skirt = skirt;
	}
	@ElementCollection(fetch=FetchType.EAGER)
	public List<String> getPants() {
		return pants;
	}
	public void setPants(List<String> pants) {
		this.pants = pants;
	}
	@ElementCollection(fetch=FetchType.EAGER)
	public List<String> getStyle() {
		return style;
	}
	public void setStyle(List<String> style) {
		this.style = style;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
