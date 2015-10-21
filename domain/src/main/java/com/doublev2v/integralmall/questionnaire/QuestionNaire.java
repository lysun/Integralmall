package com.doublev2v.integralmall.questionnaire;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;

import com.doublev2v.foundation.core.entity.UUIDBaseModel;

public class QuestionNaire extends UUIDBaseModel {

	private String userId;
	private String name;
	private String age;
	private String occupation;
	private Set<String> color;
	private String size;
	private Set<String> shirt;
	private Set<String> skirt;
	private Set<String> pants;
	private Set<String> style;
	private String price;
	
	@Column(unique=true)
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
	public Set<String> getColor() {
		return color;
	}
	public void setColor(Set<String> color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	@ElementCollection(fetch=FetchType.EAGER)
	public Set<String> getShirt() {
		return shirt;
	}
	public void setShirt(Set<String> shirt) {
		this.shirt = shirt;
	}
	@ElementCollection(fetch=FetchType.EAGER)
	public Set<String> getSkirt() {
		return skirt;
	}
	public void setSkirt(Set<String> skirt) {
		this.skirt = skirt;
	}
	@ElementCollection(fetch=FetchType.EAGER)
	public Set<String> getPants() {
		return pants;
	}
	public void setPants(Set<String> pants) {
		this.pants = pants;
	}
	@ElementCollection(fetch=FetchType.EAGER)
	public Set<String> getStyle() {
		return style;
	}
	public void setStyle(Set<String> style) {
		this.style = style;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
