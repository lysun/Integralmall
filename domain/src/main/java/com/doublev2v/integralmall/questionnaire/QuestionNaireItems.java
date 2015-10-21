package com.doublev2v.integralmall.questionnaire;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.doublev2v.foundation.core.entity.BaseModel;
import com.doublev2v.foundation.core.entity.Identified;

@Entity
public class QuestionNaireItems extends BaseModel implements Identified<Long> {

	
	private Long id=0L;
	private Set<OrderedItem> age;
	private Set<OrderedItem> occupation;
	private Set<OrderedItem> color;
	private Set<OrderedItem> size;
	private Set<OrderedItem> shirt;
	private Set<OrderedItem> skirt;
	private Set<OrderedItem> pants;
	private Set<OrderedItem> style;
	private Set<OrderedItem> price;

	@Id
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@OneToMany(cascade=CascadeType.ALL)
	@OrderBy("ordernum")
	public Set<OrderedItem> getAge() {
		return age;
	}
	public void setAge(Set<OrderedItem> age) {
		this.age = age;
	}
	@OneToMany(cascade=CascadeType.ALL)
	@OrderBy("ordernum")
	public Set<OrderedItem> getOccupation() {
		return occupation;
	}
	public void setOccupation(Set<OrderedItem> occupation) {
		this.occupation = occupation;
	}
	@OneToMany(cascade=CascadeType.ALL)
	@OrderBy("ordernum")
	public Set<OrderedItem> getColor() {
		return color;
	}
	public void setColor(Set<OrderedItem> color) {
		this.color = color;
	}
	@OneToMany(cascade=CascadeType.ALL)
	@OrderBy("ordernum")
	public Set<OrderedItem> getSize() {
		return size;
	}
	public void setSize(Set<OrderedItem> size) {
		this.size = size;
	}
	@OneToMany(cascade=CascadeType.ALL)
	@OrderBy("ordernum")
	public Set<OrderedItem> getShirt() {
		return shirt;
	}
	public void setShirt(Set<OrderedItem> shirt) {
		this.shirt = shirt;
	}
	@OneToMany(cascade=CascadeType.ALL)
	@OrderBy("ordernum")
	public Set<OrderedItem> getSkirt() {
		return skirt;
	}
	public void setSkirt(Set<OrderedItem> skirt) {
		this.skirt = skirt;
	}
	@OneToMany(cascade=CascadeType.ALL)
	@OrderBy("ordernum")
	public Set<OrderedItem> getPants() {
		return pants;
	}
	public void setPants(Set<OrderedItem> pants) {
		this.pants = pants;
	}
	@OneToMany(cascade=CascadeType.ALL)
	@OrderBy("ordernum")
	public Set<OrderedItem> getStyle() {
		return style;
	}
	public void setStyle(Set<OrderedItem> style) {
		this.style = style;
	}
	@OneToMany(cascade=CascadeType.ALL)
	@OrderBy("ordernum")
	public Set<OrderedItem> getPrice() {
		return price;
	}
	public void setPrice(Set<OrderedItem> price) {
		this.price = price;
	}
}
